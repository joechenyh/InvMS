package com.nus.invms.controller;

import java.util.Iterator;
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
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@GetMapping("/parts/get")
	public List<Part> getParts(){
		return (List<Part>) partrepo.findAll();
	}
	
	@PostMapping("/parts/create")
	public ResponseEntity<Part> createPart (@RequestBody Part part) {
		try {
			Part p = new Part(part.getProduct(), part.getQuantity());
			List<Part> existingParts = (List<Part>) partrepo.findAll();
			for (Iterator<Part> iterator = existingParts.iterator(); iterator.hasNext();) {
				Part existingpart = (Part) iterator.next();
				
				if (existingpart.getProduct().getPartNumber() == p.getProduct().getPartNumber() && existingpart.getQuantity() == p.getQuantity()) {
					return new ResponseEntity<>(null, HttpStatus.CONFLICT);			
			    }
			}
			partrepo.save(p);
			
			return new ResponseEntity<>(p, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping("/parts/get/{id}")
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

	
	@DeleteMapping("/parts/delete/{id}")
	public ResponseEntity<HttpStatus> deletePart(@PathVariable("id") int id) {
//		try {
			List<Fixset> fixsets = (List<Fixset>) fixrepo.findAll();
			Part deletePart = partrepo.findById(id).get();
			for (Iterator<Fixset> iterator = fixsets.iterator(); iterator.hasNext();) {
				Fixset fixset = (Fixset) iterator.next();
				List<Part> parts = fixset.getPart();
				for (Iterator<Part> iterator2 = parts.iterator(); iterator2.hasNext();) {
					Part part = (Part) iterator2.next();
					System.out.println("Part " + part);
					if (part.getPartId() == id) {
						System.out.println("Part 1" + part);
						fixset.removePart(deletePart);	
						System.out.println("Part 2" + part);
						break;
				    }
				}
				fixrepo.save(fixset);
			}
			
			partrepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@DeleteMapping("/parts/delete")
	public ResponseEntity<HttpStatus> deleteAllParts() {
		try {
			partrepo.deleteAll();
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}
	
	@GetMapping("/fixsets/get")
	public List<Fixset> getFixsets(){
		return (List<Fixset>) fixrepo.findAll();
	}
	
	@PostMapping("/fixsets/create")
	public ResponseEntity<Fixset> createFixset (@RequestBody Fixset fixset) {
		try {
			List<Part> parts = fixset.getPart();
			Fixset f = fixrepo.save(new Fixset(fixset.getFixsetName(), fixset.getFixsetDescription(),parts));
			System.out.println(fixset.getPart());
			return new ResponseEntity<>(f, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping("/fixsets/get/{id}")
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
	
	@PutMapping("/fixsets/edit/{id}/{id2}")
	public ResponseEntity<Fixset> editFixset(@PathVariable("id") int id, @PathVariable("id2") int id2, @RequestBody Fixset fixset) {
		Optional<Fixset> fData = fixrepo.findById(id);
		if (fData.isPresent()&& (fixset.getFixsetId() == id)) {
			Fixset _fset = fData.get();
			
			_fset.setFixsetName(fixset.getFixsetName());
			_fset.setFixsetDescription(fixset.getFixsetDescription());
			_fset.getPart().add(partrepo.findById(id2).get());
		
			return new ResponseEntity<>(fixrepo.save(_fset), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@DeleteMapping("/fixsets/delete/{id}")
	public ResponseEntity<HttpStatus> deleteFixset(@PathVariable("id") int id) {
		try {
			
			Fixset fixset = fixrepo.findById(id).get();
			
			fixrepo.deleteById(id);
			
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@DeleteMapping("/fixsets/delete/{id}/{id2}")
	public ResponseEntity<HttpStatus> deleteFixsetPart(@PathVariable("id") int id,@PathVariable("id2") int id2) {

			
			Fixset fixset = fixrepo.findById(id).get();
			
			fixset.removePart(partrepo.findById(id2).get());
			fixrepo.save(fixset);
			
			return new ResponseEntity<>(HttpStatus.OK);
			

	}
	
	@DeleteMapping("/fixsets/delete")
	public ResponseEntity<HttpStatus> deleteAllFixsets() {
		try {
			fixrepo.deleteAll();
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}
	

}
