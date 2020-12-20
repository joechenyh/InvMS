package com.nus.invms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nus.invms.domain.Fixset;
import com.nus.invms.domain.Part;
import com.nus.invms.repo.FixsetRepository;
import com.nus.invms.repo.PartRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RestFixsetController {
	
	@Autowired
	private PartRepository partrepo;
	
	@Autowired
	private FixsetRepository fixrepo;
	
	@GetMapping("/parts")
	public List<Part> getParts(){
		return (List<Part>) partrepo.findAll();
	}
	
	@PostMapping("/parts")
	public ResponseEntity<Part> createPart (@RequestBody Part part) {
		try {
			Part p = partrepo.save(new Part(part.getProduct(), part.getQuantity()));
			return new ResponseEntity<>(p, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping("/parts/{id}")
	public ResponseEntity<Part> getPartById(@PathVariable("id") Integer id) {
		int i = id;
		Optional<Part> pData = partrepo.findById(i);
		if (pData.isPresent()) {
			return new ResponseEntity<>(pData.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/parts/edit/{id}/{quantity}")
	public ResponseEntity<Part> editPart(@PathVariable("id") int id, @PathVariable("quantity") int quantity) {
		Optional<Part> pData = partrepo.findById(id);
		if (pData.isPresent()) {
			Part _part = pData.get();
			_part.setQuantity(quantity);
			return new ResponseEntity<>(partrepo.save(_part), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@DeleteMapping("/parts/{id}")
	public ResponseEntity<HttpStatus> deletePart(@PathVariable("id") int id) {
		try {
			partrepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@DeleteMapping("/parts")
	public ResponseEntity<HttpStatus> deleteAllParts() {
		try {
			partrepo.deleteAll();
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}
	
	@GetMapping("/fixsets")
	public List<Fixset> getFixsets(){
		return (List<Fixset>) fixrepo.findAll();
	}
	
	@PostMapping("/fixsets")
	public ResponseEntity<Fixset> createFixset (@RequestBody Fixset fixset) {
		try {
			Fixset f = fixrepo.save(new Fixset(fixset.getFixsetName(), fixset.getFixsetDescription(),fixset.getPart()));
			return new ResponseEntity<>(f, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping("/fixsets/{id}")
	public ResponseEntity<Fixset> getFixsetById(@PathVariable("id") Integer id) {
		int i = id;
		Optional<Fixset> fData = fixrepo.findById(i);
		if (fData.isPresent()) {
			return new ResponseEntity<>(fData.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/fixsets/edit/{id}")
	public ResponseEntity<Fixset> editFixset(@PathVariable("id") int id, @RequestBody Fixset fixset) {
		Optional<Fixset> fData = fixrepo.findById(id);
		if (fData.isPresent()&& (fixset.getFixsetId() == id)) {
			Fixset _fset = fData.get();
			_fset.setFixsetId(fixset.getFixsetId());
			_fset.setFixsetName(fixset.getFixsetName());
			_fset.setFixsetDescription(fixset.getFixsetDescription());
			_fset.setPart(fixset.getPart());
			return new ResponseEntity<>(fixrepo.save(_fset), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@DeleteMapping("/fixsets/{id}")
	public ResponseEntity<HttpStatus> deleteFixset(@PathVariable("id") int id) {
		try {
			fixrepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@DeleteMapping("/fixsets")
	public ResponseEntity<HttpStatus> deleteAllFixsets() {
		try {
			fixrepo.deleteAll();
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}
	

}
