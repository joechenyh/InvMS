package com.nus.invms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.nus.invms.domain.Order;
import com.nus.invms.domain.Status;
import com.nus.invms.repo.OrderRepository;

public class OrderImplementation implements OrderInterface {

	@Autowired
	OrderRepository orepo;

	@Override
	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		orepo.save(order);
	}

	@Override
	public ArrayList<Order> listAllOrders() {
		// TODO Auto-generated method stub
		return (ArrayList<Order>) orepo.findAll();
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		Order order = findById(id);
		order.setStatus(Status.INACTIVE);;
		orepo.save(order);
	}

	@Override
	public Order findById(int id) {
		// TODO Auto-generated method stub
		return orepo.findById(id).get();
	}
	


}
