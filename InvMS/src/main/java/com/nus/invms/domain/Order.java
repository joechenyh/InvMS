package com.nus.invms.domain;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;

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
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private LocalDate orderDate;
	@FutureOrPresent
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private LocalDate dateReceived;
	private int quantityOrdered, quantityReceived;
	private String partNumber; 
	private String status, type;

	
	@ManyToOne
	private Employee employee; 
	
	@ManyToMany
	private Collection<Supplier> suppliers;

	
	public Order(LocalDate orderDate, LocalDate dateReceived, int quantityOrdered, int quantityReceived,
			String partNumber, String status, String type, Employee employee, Collection<Supplier> suppliers) {
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
	

	
	
	

	

}
