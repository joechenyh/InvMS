package com.nus.invms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "inventory")
public class Inventory {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int inventoryId;
	
	@NotNull
	int brandId;
	
	//private int productId; // this is the Product Part Number

//	@OneToMany(mapped by "supplier")
	//private String supplierName;
	@NotEmpty
	String brandName, invdescription, invtype, category, subCategory;
	@NotNull
	Double originalPrice, wholesalePrice,retailPrice,partnerPrice;
	
	String itemName;
	int units;
	
	@OneToOne
	Product product;
	@OneToOne
	Supplier supplier;
	
	String supplierName;
//	@Column
//	private int brandId;
//
//	@Column
//	private String brandName;
//
//	@Column
//	private String itemName;
//
//	@Column
//	private String invdescription;
//
//	@Column
//	private String invtype;
//
//	@Column
//	private String category, subCategory;
//
//	@Column
//	private Double originalPrice, wholesalePrice, retailPrice, partnerPrice;
//
//	@Column
//	private int units;

//	@Override
//	public String toString() {
//		return "Inventory [productId=" + productId + ", supplierName=" + supplierName + ", brandId=" + brandId
//				+ ", brandName=" + brandName + ", itemName=" + itemName + ", invdescription=" + invdescription + ", invtype="
//				+ invtype + ", category=" + category + ", subCategory=" + subCategory + ", originalPrice=" + originalPrice
//				+ ", wholesalePrice=" + wholesalePrice + ", retailPrice=" + retailPrice + ", partnerPrice="
//				+ partnerPrice + ", units=" + units + "]";
//	}
//
//	public Inventory(String supplierName, int brandId, String brandName, String itemName, String invdescription,
//			String invtype, String category, String subCategory, Double originalPrice, Double wholesalePrice,
//			Double retailPrice, Double partnerPrice, int units) {
//		super();
//		this.supplierName = supplierName;
//		this.brandId = brandId;
//		this.brandName = brandName;
//		this.itemName = itemName;
//		this.invdescription = invdescription;
//		this.invtype = invtype;
//		this.category = category;
//		this.subCategory = subCategory;
//		this.originalPrice = originalPrice;
//		this.wholesalePrice = wholesalePrice;
//		this.retailPrice = retailPrice;
//		this.partnerPrice = partnerPrice;
//		this.units = units;
//	}

	public Inventory() {
		super();
	}

//	public int getProductId() {
//		return productId;
//	}
//
//	public void setProductId(int productId) {
//		this.productId = productId;
//	}

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

	

	

	public Inventory(@NotNull int brandId, @NotEmpty String brandName, @NotEmpty String invdescription,
			@NotEmpty String invtype, @NotEmpty String category, @NotEmpty String subCategory,
			@NotNull Double originalPrice, @NotNull Double wholesalePrice, @NotNull Double retailPrice,
			@NotNull Double partnerPrice, String itemName, int units, Product product, Supplier supplier,
			String supplierName) {
		super();
		this.brandId = brandId;
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
		return "Inventory [inventoryId=" + inventoryId + ", brandId=" + brandId + ", brandName=" + brandName
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

//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}

//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}

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
