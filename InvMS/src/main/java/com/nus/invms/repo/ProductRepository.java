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
	
	//1. Find Inventory by Name
	
//		@Query("Select p FROM Product p WHERE p.productName LIKE :productName")
//		public List<Product> findProductByListName(@Param("productName") String productName);
//		
//		@Query("Select p FROM Product p WHERE p.productName = :productName")
//		public Product findProductByName(@Param("productName") String productName);
//		
//		//2. Find Inventory by partNumber
//		 @Query("Select p FROM Product p WHERE p.partNumber = :partNumber")
//	public Product findProductByPartNumber(@Param("partNumber") int partNumber);
//		
//		 //3. Find Inventory by Manufacturer
//		 @Query("Select p FROM Product p WHERE p.manufacturer = :manufacturer")
//		public List<Product> findProductBySupplierName(@Param("manufacturer") String manufacturer);
//		 
//		//4. Find Inventory by Description 
//		 @Query("Select p FROM Product p WHERE p.description LIKE :description")
//			public List<Product> findProductByBrandName(@Param("description") String description);
//		 
//		//5. Find Inventory by Status 
//		 @Query("Select p FROM Product p WHERE p.status = :status")
//			public List<Product> findProductByStatus(@Param("status") Status status);
//		 
//		//6. Find Inventory by Shelf Location
//		 @Query("Select p FROM Product p WHERE p.shelfLocation = :shelfLocation")
//			public List<Product> findProductByShelfLocation(@Param("shelfLocation") String shelfLocation);
	
	@Query(value = "SELECT * FROM Product p "
	 		+ "WHERE p.product_name LIKE %:keyword% ",
			 nativeQuery = true)
		public Product findProductByName(@Param("keyword") String keyword);
	
//	@Query("Select p FROM Product p WHERE p.shelfLocation = :shelfLocation")
//		public ArrayList<Product> findAllActiveProduct();
	
	 @Query("Select p FROM Product p WHERE p.partNumber = :partNumber")
		public Product findProductByPartNumber(@Param("partNumber") int partNumber);
		

}
