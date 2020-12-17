package com.nus.invms.domain;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PartOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int orderId;
	LocalDate orderDate;
	LocalDate dateReceived;  //later part
	int employeeId; //random 
	int quantityOrdered; 
	int quantityReceived; //later part
	@OneToOne
	Product product;  
	String supplier; 
	String status; 
	String type;
	
	public PartOrder() {
		super();
	}
	public PartOrder(LocalDate orderDate, LocalDate dateReceived, int employeeId, int quantityOrdered, int quantityReceived,
			Product product, String supplier, String status, String type) {
		super();
		this.orderDate = orderDate;
		this.dateReceived = dateReceived;
		this.employeeId = employeeId;
		this.quantityOrdered = quantityOrdered;
		this.quantityReceived = quantityReceived;
		this.product = product;
		this.supplier = supplier;
		this.status = status;
		this.type = type;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public LocalDate getDateReceived() {
		return dateReceived;
	}
	public void setDateReceived(LocalDate dateReceived) {
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "PartOrder [orderId=" + orderId + ", orderDate=" + orderDate + ", dateReceived=" + dateReceived
				+ ", employeeId=" + employeeId + ", quantityOrdered=" + quantityOrdered + ", quantityReceived="
				+ quantityReceived + ", product=" + product + ", supplier=" + supplier + ", status=" + status
				+ ", type=" + type + "]";
	}	
	
	
	

}
