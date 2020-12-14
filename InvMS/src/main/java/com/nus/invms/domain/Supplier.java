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
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Supplier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int supplierId;
	private String supplierName, status;
	
	@ManyToMany (mappedBy="suppliers") 
	private Collection<Order> orders;
	
	public Supplier(String supplierName, String status) {
		super();
		this.supplierName = supplierName;
		this.status = status;
	}
	
	
	

	

}
