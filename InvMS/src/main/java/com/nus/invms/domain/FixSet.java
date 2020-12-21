package com.nus.invms.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class FixSet {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fixsetId; 
	
	@Column
	private String fixsetName; 
	
	@Column
	@OneToMany
	@ElementCollection
	private List<Product> product;
	
	@Column
	@ElementCollection
	private List<Integer> partQuantity;
	
	@Column
	Status status;
	

	public int getFixsetId() {
		return fixsetId;
	}

	public void setFixsetId(int fixsetId) {
		this.fixsetId = fixsetId;
	}

	public String getFixsetName() {
		return fixsetName;
	}

	public void setFixsetName(String fixsetName) {
		this.fixsetName = fixsetName;
	}

	

	

	

	public FixSet(String fixsetName, List<Product> product, List<Integer> partQuantity, Status status) {
		super();
		this.fixsetName = fixsetName;
		this.product = product;
		this.partQuantity = partQuantity;
		this.status = status;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public List<Integer> getPartQuantity() {
		return partQuantity;
	}

	public void setPartQuantity(List<Integer> partQuantity) {
		this.partQuantity = partQuantity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public FixSet() {
		super();
	}

	
	
}
