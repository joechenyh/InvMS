package com.nus.invms.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "order")
public class Order {
	
	@Id
	int orderId;
	Date orderDate;
	Date dateReceived;
	int employeeId, quantityOrdered, quantityReceived;
	String partNumber; 
	String supplier, status, type;	
	

	public Order() {
		// TODO Auto-generated constructor stub
	}

}
