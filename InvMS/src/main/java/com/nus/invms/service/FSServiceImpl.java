package com.nus.invms.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nus.invms.domain.FixSet;
import com.nus.invms.domain.FixSetUsage;
import com.nus.invms.domain.Inventory;
import com.nus.invms.domain.PartUsage;
import com.nus.invms.domain.Product;
import com.nus.invms.domain.Status;
import com.nus.invms.repo.FixSetRepository;
import com.nus.invms.repo.FixSetUsageRepository;
import com.nus.invms.repo.PartUsageRepository;

@Service
public class FSServiceImpl implements FSService {

	
	@Autowired
	FixSetRepository fsrepo;
	
	@Autowired
	FixSetUsageRepository fsurepo; 
	
	@Autowired 
	PartUsageRepository purepo;
	
	
	@Override
	public boolean saveFixSet(FixSet fixset) {
		if(fsrepo.save(fixset)!=null) return true; else return false; //C
	}

	@Override
	public List<FixSet> findAllFixSets() {
		return (List<FixSet>) fsrepo.findAll();
		
	}

	@Override
	public FixSet findFixSetById(int id) {
		return fsrepo.findById(id).get();
	}

	@Override
	public void deleteFixSet(FixSet fixset) {
		fixset.setStatus(Status.INACTIVE); //D
		fsrepo.save(fixset);
		
	}

	@Override
	public List<String> findAllFixSetNames() {
		List<FixSet> fixsets = (List<FixSet>) fsrepo.findAll();
		List<String> names = new List<String>();
		for (Iterator<FixSet> iterator = fixsets.iterator(); iterator.hasNext();) {
			FixSet fixset = (FixSet) iterator.next();
			names.add(fixset.getFixsetName());
		}
		return names;
	}

	@Override
	public List<Integer> findAllFixSetId() {
			List<FixSet> fixsets = (List<FixSet>) fsrepo.findAll();
			List<Integer> ids = new List<Integer>();
			for (Iterator<FixSet> iterator = fixsets.iterator(); iterator.hasNext();) {
				FixSet fixset = (FixSet) iterator.next();
				ids.add(fixset.getFixsetId());
			}
			return ids;
	}

	
	
	@Override
	public boolean addFixSetUsage(FixSetUsage fixsetusage) {
		// CREATE PART USAGE !!!
		if(fsurepo.save(fixsetusage)!=null) return true; else return false;
	}

	@Override
	public void deleteFixSetUsage(FixSetUsage fixsetusage) {
	
	
		fsurepo.delete(fixsetusage);
		// Need to call Part Usage in order to change Inventory 
		
	}

	
	@Override
	public List<FixSetUsage> listFixSetUsage() {
		return (List<FixSetUsage>) fsurepo.findAll();
	}

	

	@Override
	public FixSetUsage findByTransactionId(Integer tid) {
		return fsurepo.findById(tid).get();
	}

	@Override
	public List<FixSetUsage> findByUsagedateBetween(String d1, String d2) {
		List<FixSetUsage> fixsets = fsurepo.findByUsagedateBetween(d1, d2);
		return fixsets;
	}

	

	
	
}
