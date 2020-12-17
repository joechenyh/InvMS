package com.nus.invms.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private int partNumber;
	private int reorderLevel, minReorderQty;
	private String productName, description, colour, dimension, manufacturer, shelfLocation;
	private Double unitPrice;
		
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int partNumber, int reorderLevel, int minReorderQty, String productName, String description,
			String colour, String dimension, String manufacturer, String shelfLocation, Double unitPrice) {
		super();
		this.partNumber = partNumber;
		this.reorderLevel = reorderLevel;
		this.minReorderQty = minReorderQty;
		this.productName = productName;
		this.description = description;
		this.colour = colour;
		this.dimension = dimension;
		this.manufacturer = manufacturer;
		this.shelfLocation = shelfLocation;
		this.unitPrice = unitPrice;
	}

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public int getMinReorderQty() {
		return minReorderQty;
	}

	public void setMinReorderQty(int minReorderQty) {
		this.minReorderQty = minReorderQty;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getShelfLocation() {
		return shelfLocation;
	}

	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Member [partNumber=" + partNumber + ", reorderLevel=" + reorderLevel + ", minReorderQty="
				+ minReorderQty + ", productName=" + productName + ", description=" + description + ", colour=" + colour
				+ ", dimension=" + dimension + ", manufacturer=" + manufacturer + ", shelfLocation=" + shelfLocation
				+ ", unitPrice=" + unitPrice + "]";
	}
	
	
	
	
	
	
}
