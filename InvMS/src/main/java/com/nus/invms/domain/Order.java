
package com.nus.invms.domain;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="order_list")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	@FutureOrPresent
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private LocalDate orderDate;
	@FutureOrPresent
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private LocalDate dateReceived;
	
	@NotNull
	private int quantityOrdered, quantityReceived;
	@NotEmpty
	private String partNumber; 

	private OrderType type;
	private Status status;

	
	@ManyToOne
	private Employee employee; 
	
	@OneToMany (mappedBy = "order")
	private Collection<Supplier> suppliers;

	
	public Order(LocalDate orderDate, LocalDate dateReceived, int quantityOrdered, int quantityReceived,
			String partNumber, Status status, OrderType type, Employee employee, Collection<Supplier> suppliers) {
		super();
		this.orderDate = orderDate;
		this.dateReceived = dateReceived;
		this.employee = employee;
		this.quantityOrdered = quantityOrdered;
		this.quantityReceived = quantityReceived;
		this.partNumber = partNumber;
		this.suppliers = suppliers;
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


	public LocalDate getDateReceived() {
		return dateReceived;
	}


	public void setDateReceived(LocalDate dateReceived) {
		this.dateReceived = dateReceived;
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


	public OrderType getType() {
		return type;
	}


	public void setType(OrderType type) {
		this.type = type;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Collection<Supplier> getSuppliers() {
		return suppliers;
	}


	public void setSuppliers(Collection<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	

	
	
	

	

}
