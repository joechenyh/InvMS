package com.nus.invms.domain;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Supplier {
	
	@Id
<<<<<<< HEAD
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int supplierId;
	
	@NotEmpty
	private String supplierName;
	private Status status;
	
	@NotEmpty
	private String phoneNumber;
	@NotEmpty
	private String address, emailAddress;
	
	@ManyToOne
	private Order order;
	
	public Supplier(String supplierName) {
		super();
		this.supplierName = supplierName;
=======
	@GeneratedValue(strategy = GenerationType.AUTO)
	int supplierId;
	
	String supplierName, status;

	public Supplier() {
		// TODO Auto-generated constructor stub
>>>>>>> refs/heads/joe_branch
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
