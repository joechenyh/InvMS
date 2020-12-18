package com.nus.invms.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nus.invms.domain.Product;
import com.nus.invms.domain.Supplier;
import com.nus.invms.repo.SupplierRepository;

@Service
@Transactional
public class SupplierImplementation implements SupplierInterface {

	@Autowired
	SupplierRepository suprepo;
	
	@Override
	public void saveSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		suprepo.save(supplier);

	}

	@Transactional
	public ArrayList<Supplier> listAllSuppliers() {
		// TODO Auto-generated method stub
		return (ArrayList<Supplier>) suprepo.findAll();
	}

	@Override
	public void deleteSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		suprepo.delete(supplier);

	}

	@Override
	public boolean checkSupplierNameExist(Supplier supplier) {
		// TODO Auto-generated method stub
		
		ArrayList<Supplier> slist = listAllSuppliers();
		for (Iterator<Supplier> iterator = slist.iterator(); iterator.hasNext();) {
			Supplier sup = (Supplier) iterator.next();
			if (sup.getSupplierName().equals(supplier.getSupplierName())) {
		    	return true;
		    }
		}
		
		return false;
	}

	@Override
	public Supplier findByName(String name) {
		// TODO Auto-generated method stub
		
		return suprepo.findSupplierBysupplierName(name);
	}

	@Transactional
	public Supplier findById(int id) {
		// TODO Auto-generated method stub
		return suprepo.findById(id).get();
	}

}
