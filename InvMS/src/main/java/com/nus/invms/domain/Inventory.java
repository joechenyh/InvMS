package com.nus.invms.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventory {
	
	
	int productId;
	String supplierName;
	int brandId;
	String brandName;
	String itemName;
	String description;
	String type;
	String category, subCategory;
	Double originalPrice, wholesalePrice,retailPrice,partnerPrice;
	int units; 

	public Inventory() {
		// TODO Auto-generated constructor stub
	}

}
