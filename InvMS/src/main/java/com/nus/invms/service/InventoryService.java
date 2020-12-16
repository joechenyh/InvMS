package com.nus.invms.service;

import java.util.ArrayList;

import com.nus.invms.domain.Inventory;

public interface InventoryService {
	 public boolean saveInventory(Inventory inventory);
	 public ArrayList<Inventory> findAllInventories();
	 public Inventory findInventoryById(Integer id);
	 public void deleteInventory(Inventory inventory);
	 public ArrayList<String> findAllBrandNames();
	 public Inventory findInventoryByProductId(int productId);
}
