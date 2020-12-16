package com.nus.invms.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Partorder")
public class PartOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int orderId;
	Date orderDate;
	Date dateReceived;
	int employeeId, quantityOrdered, quantityReceived;
	String partNumber; 
	String supplier, status;
	String ordertype;	//SQL reserved keyword: type 

	public PartOrder() {
		// TODO Auto-generated constructor stub
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public int getQuantityReceived() {
		return quantityReceived;
	}

	public void setQuantityReceived(int quantityReceived) {
		this.quantityReceived = quantityReceived;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public PartOrder(Date orderDate, Date dateReceived, int employeeId, int quantityOrdered, int quantityReceived,
			String partNumber, String supplier, String status, String ordertype) {
		super();
		this.orderDate = orderDate;
		this.dateReceived = dateReceived;
		this.employeeId = employeeId;
		this.quantityOrdered = quantityOrdered;
		this.quantityReceived = quantityReceived;
		this.partNumber = partNumber;
		this.supplier = supplier;
		this.status = status;
		this.ordertype = ordertype;
	}
	
	

}
