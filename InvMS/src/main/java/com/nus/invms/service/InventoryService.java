package com.nus.invms.service;

import java.util.List;

import com.nus.invms.domain.Inventory;

public interface InventoryService {

	public boolean addInventory(Inventory inventory); //C
	public Inventory getInventory(int id); //R
	public void deactivateInventory(Inventory inventory); //D
	public Inventory editInventory(Inventory inventory); //U
	public List<Inventory> listInventory();

}
