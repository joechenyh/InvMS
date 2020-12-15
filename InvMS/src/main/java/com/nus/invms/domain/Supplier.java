package com.nus.invms.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier {
	
	@Id
	int supplierId;
	
	String supplierName, status;

	public Supplier() {
		// TODO Auto-generated constructor stub
	}

}
