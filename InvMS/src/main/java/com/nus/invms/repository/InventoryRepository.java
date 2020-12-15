package com.nus.invms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nus.invms.domain.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

}
