//package com.nus.invms.service;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.nus.invms.domain.Inventory;
//import com.nus.invms.repo.InventoryRepository;
//
//@Service
//public class PartOrderServiceImpl implements InventoryService {
//	
//	@Autowired
//	InventoryRepository irepo;
//
//	@Transactional
//	public boolean saveInventory(Inventory inventory) {
//		if(irepo.save(inventory)!=null) return true; else return false;
//	}
//
//	@Transactional
//	public ArrayList<Inventory> findAllInventories() {
//		return (ArrayList<Inventory>) irepo.findAll();
//	}
//
//	@Transactional
//	public Inventory findInventoryById(Integer id) {
//		return irepo.findById(id).get();
//	}
//
//	@Transactional
//	public void deleteInventory(Inventory inventory) {
//		 irepo.delete(inventory);
//	}
//
////	@Transactional
////	public ArrayList<String> findAllBrandNames() {
////		List<Inventory> inventories = irepo.findAll();
////		ArrayList<String> names = new ArrayList<String>();
////		for (Iterator<Inventory> iterator = inventories.iterator(); iterator.hasNext();) {
////			Inventory inventory = (Inventory) iterator.next();
////			names.add(inventory.getBrandName());
////		}
////		return names;
////	}
//
//
//	
//
//
//}
