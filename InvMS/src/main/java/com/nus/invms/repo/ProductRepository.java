package com.nus.invms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nus.invms.domain.Inventory;
import com.nus.invms.domain.Product;
import com.nus.invms.domain.Status;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	// Product findProductByproductName(String name);
	// Search by Description? 
	
// THIS IS JUST A TESTING SENTENCE 
	// UPDATED COPY 
	
	
	//1. Find Inventory by Name
	
		@Query("Select p from Product p where p.productName LIKE :productName")
		List<Inventory> findProductByName(@Param("productName") String productName);
		
		//2. Find Inventory by partNumber
		 @Query("Select p from Product p where p.partNumber = :partNumber")
		 Inventory findInventoryByPartNumber(@Param("partNumber") int partNumber);
		
		 //3. Find Inventory by Manufacturer
		 @Query("Select p from Product p where p.manufactuer LIKE :manufacturer")
			List<Inventory> findInventoryBySupplierName(@Param("manufacturer") String manufacturer);
		 
		//4. Find Inventory by Description 
		 @Query("Select p from Product p where p.description LIKE :description")
			List<Inventory> findInventoryByBrandName(@Param("description") String description);
		 
		//5. Find Inventory by Status 
		 @Query("Select p from Product p where p.status LIKE :status")
			List<Inventory> findInventoryByCategory(@Param("status") Status status);
		 
		//6. Find Inventory by Shelf Location
		 @Query("Select p from Product p where p.shelflocation LIKE :shelflocation")
			List<Inventory> findInventoryBySubCategory(@Param("shelflocation") String shelflocation);
		

}
