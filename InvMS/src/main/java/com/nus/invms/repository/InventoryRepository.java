package com.nus.invms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nus.invms.domain.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

	@Query("SELECT i FROM inventory i WHERE CONCAT(i.product_id, '') LIKE :keyword"
			+ " OR i.item_name LIKE :keyword")
	public List<Inventory> findInventoryItem(@Param("keyword") String keyword);
}
