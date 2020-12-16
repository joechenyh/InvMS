package com.nus.invms.service;

import java.util.ArrayList;

import com.nus.invms.domain.Product;

public interface ProductService {
	 public boolean saveProduct(Product product);
	 public ArrayList<Product> findAllProducts();
	 public Product findProductById(Integer id);
	 public void deleteProduct(Product product);
	 public ArrayList<String> findAllProductNames();
	 public ArrayList<Integer> findAllProductId();
	 public Product findProductByProductName(String productName);
}
