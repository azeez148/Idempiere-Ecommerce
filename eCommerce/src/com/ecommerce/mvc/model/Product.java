/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:Product.java
 *  Created by: srigin.ms
 *  Date: Aug 19, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: srigin.ms
 *  Date: Aug 19, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.mvc.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Set;

/**
 * @author srigin.ms
 *
 */
public class Product {

	private String name;
	private String value;
	private String productID;
	private Double inventoryQty;		//TO-DO :: Qty split up for product Attribute
	private String logoID;
	private byte[] binaryData;
	private Double priceList;
	private Set<AttributeValue> attributes;
	private String documentNote;
	private Double priceStd;
	private BigDecimal discount;
	private String categoryId;
	private String isActive;
	//TO-DO Product Category Object
	
	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the productID
	 */
	public String getProductID() {
		return productID;
	}
	/**
	 * @param productID the productID to set
	 */
	public void setProductID(String productID) {
		this.productID = productID;
	}
	/**
	 * @return the inventoryQty
	 */
	public Double getInventoryQty() {
		return inventoryQty;
	}
	/**
	 * @param inventoryQty the inventoryQty to set
	 */
	public void setInventoryQty(Double inventoryQty) {
		this.inventoryQty = inventoryQty;
	}
	/**
	 * @return the logoID
	 */
	public String getLogoID() {
		return logoID;
	}
	/**
	 * @param logoID the logoID to set
	 */
	public void setLogoID(String logoID) {
		this.logoID = logoID;
	}
	/**
	 * @return the binaryData
	 */
	public byte[] getBinaryData() {
		return binaryData;
	}
	/**
	 * @param binaryData the binaryData to set
	 */
	public void setBinaryData(byte[] binaryData) {
		this.binaryData = binaryData;
	}
	/**
	 * @return the priceList
	 */
	public Double getPriceList() {
		return priceList;
	}
	/**
	 * @param priceList the priceList to set
	 */
	public void setPriceList(Double priceList) {
		this.priceList = priceList;
	}
	/**
	 * @return the attributes
	 */
	public Set<AttributeValue> getAttributes() {
		return attributes;
	}
	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(Set<AttributeValue> attributes) {
		this.attributes = attributes;
	}
	/**
	 * @return the documentNote
	 */
	public String getDocumentNote() {
		return documentNote;
	}
	/**
	 * @param documentNote the documentNote to set
	 */
	public void setDocumentNote(String documentNote) {
		this.documentNote = documentNote;
	}
	/**
	 * @return the priceStd
	 */
	public Double getPriceStd() {
		return priceStd;
	}
	/**
	 * @param priceStd the priceStd to set
	 */
	public void setPriceStd(Double priceStd) {
		this.priceStd = priceStd;
	}
	/**
	 * @return the discount
	 */
	public BigDecimal getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the isActive
	 */
	public String getIsActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productID == null) ? 0 : productID.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productID == null) {
			if (other.productID != null)
				return false;
		} else if (!productID.equals(other.productID))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [name=");
		builder.append(name);
		builder.append(", value=");
		builder.append(value);
		builder.append(", productID=");
		builder.append(productID);
		builder.append(", inventoryQty=");
		builder.append(inventoryQty);
		builder.append(", logoID=");
		builder.append(logoID);
		builder.append(", binaryData=");
		builder.append(Arrays.toString(binaryData));
		builder.append(", priceList=");
		builder.append(priceList);
		builder.append(", attributes=");
		builder.append(attributes);
		builder.append(", documentNote=");
		builder.append(documentNote);
		builder.append(", priceStd=");
		builder.append(priceStd);
		builder.append(", discount=");
		builder.append(discount);
		builder.append(", categoryId=");
		builder.append(categoryId);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append("]");
		return builder.toString();
	}

	
}
