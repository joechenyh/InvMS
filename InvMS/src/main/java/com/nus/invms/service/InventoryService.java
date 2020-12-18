package com.nus.invms.service;

import java.util.ArrayList;
import java.util.List;

import com.nus.invms.domain.Inventory;

public interface InventoryService {

	public boolean addInventory(Inventory inventory); //C
	public Inventory getInventory(int id); //R
	public void deactivateInventory(Inventory inventory); //D
	public Inventory editInventory(Inventory inventory); //U
	public List<Inventory> listInventory();
//	public List<Inventory> search(String keyword);
	
	
	
	public void createInventory(Inventory inventory);
	public List<Inventory> listCompleteInventory();
	public void updateInventory(Inventory inventory);
//	public Inventory findByInventoryId(Integer keyword);
	
	public Inventory findByProductId(Integer id);
	public ArrayList<Inventory> findBySupplierNameLike(String name);
	public Inventory findByBrandId(Integer bid);
	public ArrayList<Inventory>	findByBrandNameLike(String bname);
//	public ArrayList<Inventory> findByItemNameLike(String s);
//	public ArrayList<Inventory> findByTypeLike(String s);

}
