package com.nus.invms.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	int partNumber, reorderLevel, minReorderQty; 
	String productName, description, colour, dimension, manufacturer, shelfLocation;
	Double unitPrice; 

	public Product() {
		// TODO Auto-generated constructor stub
	}

}
