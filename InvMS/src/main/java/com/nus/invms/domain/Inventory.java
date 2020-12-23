package com.nus.invms.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;


@Entity
@Table(name = "inventory")
public class Inventory {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int inventoryId;
	
	
	

	@NotEmpty
	String brandName, invdescription, invtype, category, subCategory;
	@NotNull
	Double originalPrice, wholesalePrice,retailPrice,partnerPrice;
	
	String itemName;
	@NotNull
	int units;
	
	@OneToOne
	Product product;
	@OneToOne
	Supplier supplier;
	
	String supplierName;


	public Inventory() {
		super();
	}



	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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

	public String getInvdescription() {
		return invdescription;
	}

	public void setInvdescription(String invdescription) {
		this.invdescription = invdescription;
	}

	public String getInvtype() {
		return invtype;
	}

	public void setInvtype(String invtype) {
		this.invtype = invtype;
	}

	public String getCategory() {
		return category;
	}
	
	

	

	

	public Inventory(String brandName, String invdescription,
			String invtype, String category, String subCategory,
			Double originalPrice, Double wholesalePrice, Double retailPrice,
			Double partnerPrice, String itemName, int units, Product product, Supplier supplier,
			String supplierName) {
		super();
		
		this.brandName = brandName;
		this.invdescription = invdescription;
		this.invtype = invtype;
		this.category = category;
		this.subCategory = subCategory;
		this.originalPrice = originalPrice;
		this.wholesalePrice = wholesalePrice;
		this.retailPrice = retailPrice;
		this.partnerPrice = partnerPrice;
		this.itemName = itemName;
		this.units = units;
		this.product = product;
		this.supplier = supplier;
		this.supplierName = supplierName;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", brandName=" + brandName
				+ ", invdescription=" + invdescription + ", invtype=" + invtype + ", category=" + category
				+ ", subCategory=" + subCategory + ", originalPrice=" + originalPrice + ", wholesalePrice="
				+ wholesalePrice + ", retailPrice=" + retailPrice + ", partnerPrice=" + partnerPrice + ", itemName="
				+ itemName + ", units=" + units + ", product=" + product + ", supplier=" + supplier + ", supplierName="
				+ supplierName + "]";
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}



	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
