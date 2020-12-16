package com.nus.invms.domain;

import javax.persistence.Column;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId; // this is the Product Part Number

//	@OneToMany(mapped by "supplier")
	private String supplierName;

	@Column
	private int brandId;

	@Column
	private String brandName;

	@Column
	private String itemName;

	@Column
	private String invdescription;

	@Column
	private String invtype;

	@Column
	private String category, subCategory;

	@Column
	private Double originalPrice, wholesalePrice, retailPrice, partnerPrice;

	@Column
	private int units;

	@Override
	public String toString() {
		return "Inventory [productId=" + productId + ", supplierName=" + supplierName + ", brandId=" + brandId
				+ ", brandName=" + brandName + ", itemName=" + itemName + ", invdescription=" + invdescription + ", invtype="
				+ invtype + ", category=" + category + ", subCategory=" + subCategory + ", originalPrice=" + originalPrice
				+ ", wholesalePrice=" + wholesalePrice + ", retailPrice=" + retailPrice + ", partnerPrice="
				+ partnerPrice + ", units=" + units + "]";
	}

	public Inventory(String supplierName, int brandId, String brandName, String itemName, String invdescription,
			String invtype, String category, String subCategory, Double originalPrice, Double wholesalePrice,
			Double retailPrice, Double partnerPrice, int units) {
		super();
		this.supplierName = supplierName;
		this.brandId = brandId;
		this.brandName = brandName;
		this.itemName = itemName;
		this.invdescription = invdescription;
		this.invtype = invtype;
		this.category = category;
		this.subCategory = subCategory;
		this.originalPrice = originalPrice;
		this.wholesalePrice = wholesalePrice;
		this.retailPrice = retailPrice;
		this.partnerPrice = partnerPrice;
		this.units = units;
	}


}
