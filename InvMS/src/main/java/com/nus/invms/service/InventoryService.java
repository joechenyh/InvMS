package com.nus.invms.service;

import java.util.List;

import com.nus.invms.domain.Inventory;

public interface InventoryService {

	public void addInventory(Inventory inventory); //C
	public boolean checkInventory(Inventory inventory); //R
	public void deactivateInventory(Inventory inventory); //D
	public void editInventory(Inventory inventory); //U
	public List<Inventory> listInventory();

}
