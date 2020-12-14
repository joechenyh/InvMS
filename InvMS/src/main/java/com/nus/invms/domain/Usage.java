package com.nus.invms.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usage {
	
	int transactionId, employeeId, partNumber, quantity;
	Date date;
	String carplate;
	

	public Usage() {
		// TODO Auto-generated constructor stub
	}

}
