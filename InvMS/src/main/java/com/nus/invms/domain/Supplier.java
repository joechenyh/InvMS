package com.nus.invms.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int supplierId;
	
	String supplierName, status;

	public Supplier() {
		// TODO Auto-generated constructor stub
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Supplier(String supplierName, String status) {
		super();
		this.supplierName = supplierName;
		this.status = status;
	}
	
	

}
