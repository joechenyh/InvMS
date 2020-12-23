package com.nus.invms.service;

import java.util.ArrayList;

import org.springframework.data.domain.Page;

import com.nus.invms.domain.Inventory;

public interface InventoryService {

	public boolean addInventory(Inventory inventory); //C
	public Inventory getInventory(int id); //R
	public void deactivateInventory(Inventory inventory); //D
	public Inventory editInventory(Inventory inventory); //U

	public ArrayList<Inventory> findAllInventories(); //Rahmat
	
//	public List<Inventory> searchAllInventories(String keyword);
	public Page<Inventory> searchInventory(int pageNumber, String keyword);
	
	public void createInventory(Inventory inventory);

	public void updateInventory(Inventory inventory);

	public Inventory findByInventoryId(Integer id);
	public ArrayList<Inventory> findBySupplierNameLike(String name);
	public Inventory findByBrandId(Integer bid);
	public ArrayList<Inventory>	findByBrandNameLike(String bname);

	public Inventory findInventoryByPartNumber(int partNum);

}
