package com.nus.invms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.nus.invms.domain.FixSet;
import com.nus.invms.domain.FixSetUsage;
import com.nus.invms.domain.PartUsage;
import com.nus.invms.domain.Product;

@Service
public interface FSService {
	
		public boolean saveFixSet(FixSet fixset);  
		public List<FixSet> findAllFixSets(); 
		public FixSet findFixSetById(int id);
		public void deleteFixSet(FixSet fixset); 
	
	
		public List<String> findAllFixSetNames();
		public List<Integer> findAllFixSetId();
	 
	 	public boolean addFixSetUsage(FixSetUsage fixsetusage); //C
		public void deleteFixSetUsage(FixSetUsage fixsetusage); //D
		
		public List<FixSetUsage> listFixSetUsage(); 
		public List<FixSetUsage> findByUsagedateBetween(String d1, String d2);
		public FixSetUsage findByTransactionId(Integer tid); //R
	
	
}
