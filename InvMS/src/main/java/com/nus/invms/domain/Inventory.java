package com.nus.invms.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int inventoryId;
	String supplierName;
	int brandId;
	String brandName;
	String itemName;
	String description;
	String type;
	String category, subCategory;
	Double originalPrice, wholesalePrice,retailPrice,partnerPrice;
	int units;
	@OneToOne
	Product product;
	
	public Inventory() {
		super();
	}
	
	public Inventory(String supplierName, int brandId, String brandName, String itemName, String description,
			String type, String category, String subCategory, Double originalPrice, Double wholesalePrice,
			Double retailPrice, Double partnerPrice, int units, Product product) {
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
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", supplierName=" + supplierName + ", brandId=" + brandId
				+ ", brandName=" + brandName + ", itemName=" + itemName + ", description=" + description + ", type="
				+ type + ", category=" + category + ", subCategory=" + subCategory + ", originalPrice=" + originalPrice
				+ ", wholesalePrice=" + wholesalePrice + ", retailPrice=" + retailPrice + ", partnerPrice="
				+ partnerPrice + ", units=" + units + ", product=" + product + "]";
	}

	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public Double getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}
	public Double getWholesalePrice() {
		return wholesalePrice;
	}
	public void setWholesalePrice(Double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}
	public Double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public Double getPartnerPrice() {
		return partnerPrice;
	}
	public void setPartnerPrice(Double partnerPrice) {
		this.partnerPrice = partnerPrice;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	
	
	
	
	
	
	

}
