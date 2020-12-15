package com.nus.invms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nus.invms.domain.Inventory;
import com.nus.invms.repository.InventoryRepository;

@Service
public class InventoryImplementation implements InventoryInterface{

	@Autowired
	InventoryRepository irepo;
	
	public List<Inventory> search(String keyword){
		return irepo.findInventoryItem(keyword);
	}

	@Override
	public void createInventory(Inventory inventory) {
		irepo.save(inventory);
	}

	@Override
	public List<Inventory> listCompleteInventory() {
		return irepo.findAll();
	}

	@Override
	public void updateInventory(Inventory inventory) {
		irepo.save(inventory);
	}
	
}
