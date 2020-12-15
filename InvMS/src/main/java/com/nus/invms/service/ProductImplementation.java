package com.nus.invms.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nus.invms.domain.Product;
import com.nus.invms.repo.ProductRepository;

@Service
@Transactional
public class ProductImplementation implements ProductInterface {

	@Autowired
	ProductRepository prorepo;
	
	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		prorepo.save(product);

	}

	@Override
	public ArrayList<Product> listAllProducts() {
		// TODO Auto-generated method stub
		return (ArrayList<Product>) prorepo.findAll();
	}


	@Override
	public boolean checkProductNameExist(Product product) {
		// TODO Auto-generated method stub
		
		ArrayList<Product> plist = listAllProducts();
		for (Iterator<Product> iterator = plist.iterator(); iterator.hasNext();) {
			Product prod = (Product) iterator.next();
			if (prod.getProductName().equals(product.getProductName())) {
		    	return true;
		    }
		}
		
		return false;
	}

	@Override
	public Product findByName(String name) {
		// TODO Auto-generated method stub
		Product product = prorepo.findProductByproductName(name);
		return product;
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		prorepo.delete(product);
	}

	@Override
	public Optional<Product> findById(int id) {
		// TODO Auto-generated method stub
		return prorepo.findById(id);
	}


}
