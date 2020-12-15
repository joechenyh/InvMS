package com.nus.invms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "inventory")
public class Inventory {
	@Id
	@Column(name = "product_id")
	@NotNull
	int productId;
	@Column(name = "supplier")
	@NotNull
	String supplierName;
	@Column(name = "brand_id")
	@NotNull
	int brandId;
	@Column(name = "brand_name")
	@NotNull
	String brandName;
	@Column(name = "item_name")
	@NotNull
	String itemName;
	@Column(name = "item_description")
	String description;
	@Column(name = "item_type")
	@NotNull
	String type;
	@NotNull
	String category;
	@Column(name = "subcategory")
	@NotNull
	String subCategory;
	@NotNull
	@Column(name = "original_price")
	Double originalPrice;
	@Column(name = "wholesale_price")
	Double wholesalePrice;
	@NotNull
	@Column(name = "retail_price")
	Double retailPrice;
	@Column(name = "partner_price")
	Double partnerPrice;
	@NotNull
	int units;

	public Inventory() {
		// TODO Auto-generated constructor stub
	}

	public Inventory(@NotNull int productId, @NotNull String supplierName, @NotNull int brandId,
			@NotNull String brandName, @NotNull String itemName, String description, @NotNull String type,
			@NotNull String category, @NotNull String subCategory, @NotNull Double originalPrice, Double wholesalePrice,
			@NotNull Double retailPrice, Double partnerPrice, @NotNull int units) {
		super();
		this.productId = productId;
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	@Override
	public String toString() {
		return "Inventory [productId=" + productId + ", supplierName=" + supplierName + ", brandId=" + brandId
				+ ", brandName=" + brandName + ", itemName=" + itemName + ", description=" + description + ", type="
				+ type + ", category=" + category + ", subCategory=" + subCategory + ", originalPrice=" + originalPrice
				+ ", wholesalePrice=" + wholesalePrice + ", retailPrice=" + retailPrice + ", partnerPrice="
				+ partnerPrice + ", units=" + units + "]";
	}

}
