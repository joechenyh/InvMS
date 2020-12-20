package com.nus.invms.service;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	@Transactional
	public List<Inventory> searchAllInventories(String keyword){
		if(keyword !=null) {
			return irepo.searchInventoryItem(keyword);
		}
		return (ArrayList<Inventory>) irepo.findAll();
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
		Inventory currentinventory = irepo.findById(inventory.getInventoryId()).get();
		currentinventory = inventory;
		irepo.save(currentinventory);
		
		return currentinventory;
	}

//	@Override
//	@Transactional
//	public List<Inventory> listInventory() {
//		return irepo.findAll();
//	}
	
	@Transactional
	public ArrayList<Inventory> findAllInventories() {
		return (ArrayList<Inventory>) irepo.findAll();
	}

	@Override
	public void createInventory(Inventory inventory) {
		irepo.save(inventory);
	}

//	@Override
//	public List<Inventory> listCompleteInventory() {
//		return irepo.findAll();
//	}

	@Override
	public void updateInventory(Inventory inventory) {
		irepo.save(inventory);
	}
	
	@Transactional
	public Inventory findByInventoryId(Integer id) {
		return irepo.findById(id).get();
	}

	@Override
	public ArrayList<Inventory> findBySupplierNameLike(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory findByBrandId(Integer bid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Inventory> findByBrandNameLike(String bname) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Inventory findInventoryByPartNumber(int partNum) {
		Inventory isearch = null;
		ArrayList<Inventory> iList = new ArrayList<Inventory>();
		iList = (ArrayList<Inventory>) irepo.findAll();
		for (Iterator<Inventory> iterator = iList.iterator(); iterator.hasNext();) {
			Inventory inventory = iterator.next();
			if (inventory.getProduct().getPartNumber()==partNum) {
				isearch = inventory;
				break;
			}
		}
		return isearch;
	}
	
//	Bottom part to create? 

/*	public ArrayList<Inventory> findBySupplierNameLike(String name) {
		return (ArrayList<Inventory>) irepo.findBySupplierName(name);
	}

	public Inventory findByBrandId(Integer bid) {
		return irepo.findByBrandId(bid);
	}

	public ArrayList<Inventory> findByBrandNameLike(String bname) {
		ArrayList<Inventory> bnlist = (ArrayList<Inventory>) irepo.findByBrandNameLike(bname);
		return bnlist;
	}

*/


}
