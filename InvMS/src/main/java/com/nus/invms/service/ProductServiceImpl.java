package com.nus.invms.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nus.invms.domain.Product;
import com.nus.invms.repo.ProductRepository;

@Service
//@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository prepo;
	

	
	@Transactional
	public boolean saveProduct(Product product) {
		if(prepo.save(product)!=null) return true; else return false;
	}

	@Transactional
	public ArrayList<Product> findAllProducts() {
		return (ArrayList<Product>) prepo.findAll();
	}

	@Transactional
	public Product findProductById(Integer id) {
		return prepo.findById(id).get();
	}

	@Transactional
	public void deleteProduct(Product product) {
		 prepo.delete(product);
	}

	@Transactional
	public ArrayList<String> findAllProductNames() {
		List<Product> products = prepo.findAll();
		ArrayList<String> names = new ArrayList<String>();
		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			names.add(product.getProductName());
		}
		return names;
	}
	
	@Transactional
	public Product findProductByName(String keyword) {
		return prepo.findProductByName(keyword);
	}
	
	@Transactional
	public ArrayList<Integer> findAllProductId() {
		List<Product> products = prepo.findAll();
		ArrayList<Integer> id = new ArrayList<Integer>();
		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			id.add(product.getPartNumber());
		}
		return id;
	}


}
