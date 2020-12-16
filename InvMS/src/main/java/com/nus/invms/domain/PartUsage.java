package com.nus.invms.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@Table only needed if table different name 
public class PartUsage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	
	//@Column(name="employeeId", nullable=false)
	@ManyToOne
	private Employee employee; 
	
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

	public PartUsage(Employee employee, int partNumber, int quantity, LocalDate usagedate, String carplate) {
		super();
		this.employee = employee;
		this.partNumber = partNumber;
		this.quantity = quantity;
		this.usagedate = usagedate;
		this.carplate = carplate;
	}

	@Override
	public String toString() {
		return "PartUsage [transactionId=" + transactionId + ", employee=" + employee + ", partNumber=" + partNumber
				+ ", quantity=" + quantity + ", usagedate=" + usagedate + ", carplate=" + carplate + "]";
	}

}
