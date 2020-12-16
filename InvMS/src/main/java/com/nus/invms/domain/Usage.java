package com.nus.invms.domain;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@Table(name="usage_list")
public class Usage {
	
	/*
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionId;
	
	@ManyToOne
	/*(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="employeeId")
	private Employee employee;
	private int partNumber, quantity;
	
	@FutureOrPresent
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private LocalDate date;
	private String carplate;
	
	public Usage(int partNumber, int quantity, LocalDate date, String carplate, Employee employee) {
		super();
		this.employee = employee;
		this.partNumber = partNumber;
		this.quantity = quantity;
		this.date = date;
		this.carplate = carplate;
	}
	
	
	*/
}
