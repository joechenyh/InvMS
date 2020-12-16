package com.nus.invms.domain;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.FutureOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
//@Table only needed if table different name 
public class PartUsage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	
	//@Column(name="employeeId", nullable=false)
	//@OneToOne
	private int employeeId; 
	
	//@OneToOne
	//@Column(name="partNumber", nullable=false)
	int partNumber;
	
	//@Column(name="quantity", nullable=false)
	int quantity;
	
	@FutureOrPresent
	@DateTimeFormat (pattern="dd-MM-yyyy")
	//@Column(name="date", nullable=false)
	private LocalDate usagedate;
	
	//@Column(name="carplate", nullable=false)
	private String carplate;

	public PartUsage(int employeeId, int partNumber, int quantity, LocalDate usagedate, String carplate) {
		super();
		this.employeeId = employeeId;
		this.partNumber = partNumber;
		this.quantity = quantity;
		this.usagedate = usagedate;
		this.carplate = carplate;
	}



	



	public PartUsage() {
		// TODO Auto-generated constructor stub
	}







	@Override
	public String toString() {
		return "PartUsage [transactionId=" + transactionId + ", employeeId=" + employeeId + ", partNumber=" + partNumber
				+ ", quantity=" + quantity + ", usagedate=" + usagedate + ", carplate=" + carplate + "]";
	}







	public int getTransactionId() {
		return transactionId;
	}



	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}



	public int getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}



	public int getPartNumber() {
		return partNumber;
	}



	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public LocalDate getUsageDate() {
		return usagedate;
	}



	public void setUsageDate(LocalDate date) {
		this.usagedate = date;
	}



	public String getCarplate() {
		return carplate;
	}



	public void setCarplate(String carplate) {
		this.carplate = carplate;
	}





}
