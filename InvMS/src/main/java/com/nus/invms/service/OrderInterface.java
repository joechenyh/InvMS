package com.nus.invms.service;

import java.util.ArrayList;

import com.nus.invms.domain.Order;

public interface OrderInterface {
	
	public void saveOrder(Order order);
	public ArrayList<Order> listAllOrders();
//	public void deleteProduct(int id);
	public Order findById(int id);
	public void deleteById(int id);

}
