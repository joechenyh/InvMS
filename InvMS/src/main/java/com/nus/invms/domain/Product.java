
package com.nus.invms.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Table;


@Entity
@Table(name = "product")

public class Product {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int partNumber;
	@NotNull
	private int reorderLevel, minReorderQty; 
	@NotEmpty
	private String productName, description, colour, dimension, shelfLocation;
	
	@NotEmpty 
	private String manufacturer;
	
	@NotNull
	private Double unitPrice;
	private Status status;    
	
	public Product(int partNumber, int reorderLevel, int minReorderQty, String productName, String description, String colour,
			String dimension, String manufacturer, String shelfLocation, Double unitPrice, Status status) {
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
		this.status = status;
	} 
	
	

	
	

	public int getReorderLevel() {
		return reorderLevel;
	}

	public int getPartNumber() {
		return partNumber;
	}


	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Product() {
	super();
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
		return "Product [partNumber=" + partNumber + ", reorderLevel=" + reorderLevel + ", minReorderQty="
				+ minReorderQty + ", productName=" + productName + ", description=" + description + ", colour=" + colour
				+ ", dimension=" + dimension + ", shelfLocation=" + shelfLocation + ", manufacturer=" + manufacturer
				+ ", unitPrice=" + unitPrice + ", status=" + status + "]";
	}
	
	



}
