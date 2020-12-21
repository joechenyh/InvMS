
package com.nus.invms.domain;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

@Entity
@Table(name="order_list")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	//@FutureOrPresent
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private LocalDate orderDate;
	//@FutureOrPresent
	@DateTimeFormat (pattern="yyyy-MM-dd")
	@Nullable
	private LocalDate dateReceivedReturned;
	
	@NotNull
	private int quantityOrdered;
	@Nullable
	private int quantityReceived;
//	@NotEmpty
//	private String partNumber; 

	private OrderType type;
	private OrderStatus status;

	
	@OneToOne
	private Employee employee; 
	
	@OneToOne
	private Supplier supplier;
	
	@OneToOne
	private Product product;


	


	public Order(LocalDate orderDate, LocalDate dateReceivedReturned, int quantityOrdered, int quantityReceived, 
			OrderStatus status, OrderType type, Employee employee, Supplier supplier, Product product) {

	
		this.orderDate = orderDate;
		this.dateReceivedReturned = dateReceivedReturned;
		this.employee = employee;
		this.quantityOrdered = quantityOrdered;
		this.quantityReceived = quantityReceived;


		this.product = product;
		this.supplier = supplier;

		this.status = status;
		this.type = type;
	}

	

	public Order() {
		super();
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public LocalDate getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}


	public LocalDate getDateReceivedReturned() {
		return dateReceivedReturned;
	}


	public void setDateReceivedReturned(LocalDate dateReceivedReturned) {
		this.dateReceivedReturned = dateReceivedReturned;
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


//	public String getPartNumber() {
//		return partNumber;
//	}
//
//
//	public void setPartNumber(String partNumber) {
//		this.partNumber = partNumber;
//	}


	public OrderType getType() {
		return type;
	}


	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public void setType(OrderType type) {
		this.type = type;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public Supplier getSupplier() {
		return supplier;
	}



	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}





	

	
	
	

	

}
