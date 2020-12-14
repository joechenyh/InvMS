package com.nus.invms.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Inventory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	
	private String supplierName;
	
	private int brandId;
	private String brandName;
	private String itemName;
	private String description;
	private String type;
	private String category, subCategory;
	private Double originalPrice, wholesalePrice,retailPrice,partnerPrice;
	private int units;
	
	public Inventory(String supplierName, int brandId, String brandName, String itemName, String description,
			String type, String category, String subCategory, Double originalPrice, Double wholesalePrice,
			Double retailPrice, Double partnerPrice, int units) {
		super();
		this.supplierName = supplierName;
		this.brandId = brandId;
		this.brandName = brandName;
		this.itemName = itemName;
		this.description = description;
		this.type = type;
		this.category = category;
		this.subCategory = subCategory;
		this.originalPrice = originalPrice;
		this.wholesalePrice = wholesalePrice;
		this.retailPrice = retailPrice;
		this.partnerPrice = partnerPrice;
		this.units = units;
	} 
	

}
