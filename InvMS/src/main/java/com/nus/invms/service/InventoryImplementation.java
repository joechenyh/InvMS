package com.nus.invms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nus.invms.domain.Inventory;
import com.nus.invms.repository.InventoryRepository;

@Service
public class InventoryImplementation implements InventoryInterface {

	@Autowired
	InventoryRepository irepo;

//	public List<Inventory> search(String keyword){
//		return irepo.findInventoryItem(keyword);
//	}

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

	public Inventory findByProductId(Integer id) {
		return irepo.findById(id).get();
	}

	public ArrayList<Inventory> findBySupplierNameLike(String name) {
		return (ArrayList<Inventory>) irepo.findBySupplierName(name);
	}

	public Inventory findByBrandId(Integer bid) {
		return irepo.findByBrandId(bid);
	}

	public ArrayList<Inventory> findByBrandNameLike(String bname) {
		ArrayList<Inventory> bnlist = (ArrayList<Inventory>) irepo.findByBrandNameLike(bname);
		return bnlist;
	}
	
//	public Inventory findByInventoryId(Integer keyword){
//		return irepo.findById(keyword).get();
//	}

//	public ArrayList<Inventory> findByBrandNameLike(String s){
//		
//	}
}
