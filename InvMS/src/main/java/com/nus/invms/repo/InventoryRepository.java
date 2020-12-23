package com.nus.invms.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nus.invms.domain.Inventory;


public interface InventoryRepository extends JpaRepository<Inventory, Integer>
{
	
	 @Query(value = "SELECT * FROM Inventory i "
		 		+ "WHERE i.product_part_number LIKE %:keyword% "
		 		+ "OR i.supplier_name LIKE %:keyword% "

		 		+ "OR i.brand_name LIKE %:keyword% "
		 		+ "OR CONCAT(i.item_name, '') LIKE %:keyword% "
		 		+ "OR CONCAT(i.invdescription, '') LIKE %:keyword% "
		 		+ "OR i.invType LIKE %:keyword% "
		 		+ "OR i.category LIKE %:keyword% "
		 		+ "OR i.sub_category LIKE %:keyword% "
		 		+ "OR CONCAT(i.units, '') LIKE %:keyword%",
				 nativeQuery = true)
			public Page<Inventory> searchInventoryItem(@Param("keyword") String keyword, Pageable pageable);
	 


	
}


