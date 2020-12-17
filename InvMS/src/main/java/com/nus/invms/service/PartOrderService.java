package com.nus.invms.service;

import java.util.ArrayList;


import com.nus.invms.domain.PartOrder;

public interface PartOrderService {
	 public boolean savePartOrder(PartOrder partOrder);
	 public ArrayList<PartOrder> findAllPartOrders();
	 public PartOrder findPartOrderById(Integer id);
	 public void deletePartOrder(PartOrder partOrder);
	 //public ArrayList<String> findAllBrandNames();
}
