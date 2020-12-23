package com.nus.invms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nus.invms.domain.Inventory;
import com.nus.invms.domain.Product;
import com.nus.invms.domain.Status;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	
	@Query(value = "SELECT * FROM Product p "
	 		+ "WHERE p.product_name LIKE %:keyword% ",
			 nativeQuery = true)
		public Product findProductByName(@Param("keyword") String keyword);
	

		

}
