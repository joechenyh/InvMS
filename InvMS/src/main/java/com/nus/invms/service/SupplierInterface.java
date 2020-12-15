package com.nus.invms.service;

import java.util.ArrayList;
import java.util.Optional;

import com.nus.invms.domain.Supplier;

public interface SupplierInterface {
	
	public void saveSupplier(Supplier supplier);
	public ArrayList<Supplier> listAllSuppliers();
	public void deleteSupplier(Supplier supplier);
	public boolean checkSupplierNameExist(Supplier supplier);
	public Supplier findByName(String name);
	public Supplier findById(int id);

}
