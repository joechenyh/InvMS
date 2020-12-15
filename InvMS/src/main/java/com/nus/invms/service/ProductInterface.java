package com.nus.invms.service;

import java.util.ArrayList;
import java.util.Optional;

import com.nus.invms.domain.Product;

public interface ProductInterface {

	public void saveProduct(Product product);
	public ArrayList<Product> listAllProducts();
	public void deleteProduct(Product product);
	public boolean checkProductNameExist(Product product);
	public Product findByName(String name);
	public Optional<Product> findById(int id);
	
}
