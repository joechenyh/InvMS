package com.nus.invms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nus.invms.domain.Inventory;


public interface InventoryRepository extends JpaRepository<Inventory, Integer>
{
	
	//1. Find Inventory by Name
	
	@Query("Select i from Inventory i where i.itemName LIKE :name")
	List<Inventory> findInventoryByName(@Param("name") String name);
	
	//2. Find Inventory by ID 
	
	 @Query("Select i from Inventory i where i.productId = :productId")
	 Inventory findInventoryById(@Param("productId") int productId);
	
	 //3. Find Inventory by SupplierName
	 @Query("Select i from Inventory i where i.supplierName LIKE :suppliername")
		List<Inventory> findInventoryBySupplierName(@Param("suppliername") String suppliername);
	 
	//4. Find Inventory by BrandName
	 @Query("Select i from Inventory i where i.brandName LIKE :brandName")
		List<Inventory> findInventoryByBrandName(@Param("brandName") String brandName);
	 
	//5. Find Inventory by Category 
	 @Query("Select i from Inventory i where i.category LIKE :category")
		List<Inventory> findInventoryByCategory(@Param("category") String category);
	 
	//6. Find Inventory by Sub Category 
	 @Query("Select i from Inventory i where i.subCategory LIKE :subCategory")
		List<Inventory> findInventoryBySubCategory(@Param("subCategory") String subCategory);
	
	 @Query(value="SELECT * FROM Inventory i WHERE concat(i.productId, '', i.supplierName, '', i.brandId, '', i.itemName, '', i.invdescription, '', invtype) LIKE '%:term%'",
				nativeQuery = true)
		public List<Inventory> searchInventory(@Param("term") String term);
	
}


