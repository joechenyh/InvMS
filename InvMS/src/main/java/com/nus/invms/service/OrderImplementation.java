package com.nus.invms.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nus.invms.domain.Order;
import com.nus.invms.domain.Status;
import com.nus.invms.repo.OrderRepository;

@Service
@Transactional
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
	public Order findById(int id) {
		// TODO Auto-generated method stub
		return orepo.findById(id).get();
	}
	
	@Transactional
	public void deleteById(int id) {
		orepo.deleteById(id);
	}
	


}
