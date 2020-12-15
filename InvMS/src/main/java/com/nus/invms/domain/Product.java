package com.nus.invms.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int partNumber;
	@NotNull
	private int reorderLevel, minReorderQty; 
	@NotEmpty
	private String productName, description, colour, dimension, manufacturer, shelfLocation;
	@NotNull
	private Double unitPrice;
	private Status status;
	
	public Product(int reorderLevel, int minReorderQty, String productName, String description, String colour,
			String dimension, String manufacturer, String shelfLocation, Double unitPrice) {
		super();
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
	
	


}
