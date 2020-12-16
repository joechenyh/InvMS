package com.nus.invms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nus.invms.domain.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
	
	@Query("Select i from Inventory i where i.productId LIKE :productId")
	 List<Inventory> findInventoryByProductId(@Param("productId") int productId);
}
