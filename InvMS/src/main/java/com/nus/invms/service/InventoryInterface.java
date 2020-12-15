package com.nus.invms.service;

import java.util.List;

import com.nus.invms.domain.Inventory;

public interface InventoryInterface {
	public List<Inventory> search(String keyword);
	public void createInventory(Inventory inventory);
	public List<Inventory> listCompleteInventory();
	public void updateInventory(Inventory inventory);
}
