package com.nus.invms.repo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nus.invms.domain.Product;

@SpringBootTest
public class ProductRepoTest {
	
	@Autowired
	private ProductRepository prepo;
	
	@Test
	void check() {
		List<Product> products = prepo.findAll();
		ArrayList<String> names = new ArrayList<String>();
		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			names.add(product.getProductName());
			System.out.println(names);
		}
	}

}
