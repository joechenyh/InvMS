package com.nus.invms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nus.invms.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
//	 @Query("Select p from Product p where p.partName LIKE :partName")
//	 List<Product> findProductByPartName(@Param("partName") int partName);
	 
	 @Query("Select p from Product p where p.productName LIKE :name")
	 List<Product> findProductByProductName(@Param("name") String name);

}
