package com.nus.invms.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class PartUsage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;

	@OneToOne
	private Employee employee;

	@OneToOne
	private Product product;

	int quantity;

	@PastOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate usagedate;

	@NotEmpty
	private String carplate;


	
	public PartUsage() {
		super();
	}

	

	public PartUsage(Employee employee, Product product, int quantity, @PastOrPresent LocalDate usagedate,
			String carplate) {
		super();
		this.employee = employee;
		this.product = product;
		this.quantity = quantity;
		this.usagedate = usagedate;
		this.carplate = carplate;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getUsagedate() {
		return usagedate;
	}

	public void setUsagedate(LocalDate usagedate) {
		this.usagedate = usagedate;
	}

	public String getCarplate() {
		return carplate;
	}

	public void setCarplate(String carplate) {
		this.carplate = carplate;
	}

}
