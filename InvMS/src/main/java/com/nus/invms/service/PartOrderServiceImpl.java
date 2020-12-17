package com.nus.invms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nus.invms.domain.PartOrder;
import com.nus.invms.repo.PartOrderRepository;

@Service
public class PartOrderServiceImpl implements PartOrderService {
	
	@Autowired
	PartOrderRepository porepo;

	@Transactional
	public boolean savePartOrder(PartOrder partOrder) {
		if(porepo.save(partOrder)!=null) return true; else return false;
	}

	@Transactional
	public ArrayList<PartOrder> findAllPartOrders() {
		return (ArrayList<PartOrder>) porepo.findAll();
	}

	@Transactional
	public PartOrder findPartOrderById(Integer id) {
		return porepo.findById(id).get();
	}

	@Transactional
	public void deletePartOrder(PartOrder partOrder) {
		 porepo.delete(partOrder);
	}

//	@Transactional
//	public ArrayList<String> findAllBrandNames() {
//		List<Inventory> inventories = irepo.findAll();
//		ArrayList<String> names = new ArrayList<String>();
//		for (Iterator<Inventory> iterator = inventories.iterator(); iterator.hasNext();) {
//			Inventory inventory = (Inventory) iterator.next();
//			names.add(inventory.getBrandName());
//		}
//		return names;
//	}


	


}
