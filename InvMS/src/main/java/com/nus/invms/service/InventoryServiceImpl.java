package com.nus.invms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nus.invms.domain.Inventory;
import com.nus.invms.domain.PartUsage;
import com.nus.invms.repo.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	InventoryRepository irepo;
	
	public InventoryServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public boolean addInventory(Inventory inventory) {
			if(irepo.save(inventory)!=null) return true; else return false;

		}
	

	@Override
	@Transactional
	public Inventory getInventory(int id) {
		return irepo.findById(id).get();
	}

	@Override
	@Transactional
	public void deactivateInventory(Inventory inventory) {
		irepo.delete(inventory);
	
	}

	@Override
	@Transactional
	public Inventory editInventory(Inventory inventory) {
		Inventory currentinventory = irepo.findById(inventory.getProductId()).get();
		currentinventory = inventory;
		irepo.save(currentinventory);
		
		return currentinventory;
	}

	@Override
	@Transactional
	public List<Inventory> listInventory(String term) {
		if (term != null) {
			return irepo.searchInventory(term);
		}
		return irepo.findAll();
	}





}
