/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:ProductCategory.java
 *  Created by: srigin.ms
 *  Date: Aug 22, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: srigin.ms
 *  Date: Aug 22, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.mvc.model;

import java.util.List;

/**
 * @author srigin.ms
 *
 */
public class ProductCategory {

	private String name;
	private String categoryID;
	private String parentID;
	private List<ProductCategory> children;
	private String parentName;
	private String isActive;
	private String vendorId;
	
	private List<String> vendorMappers;
	
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
	 * @return the categoryID
	 */
	public String getCategoryID() {
		return categoryID;
	}
	/**
	 * @param categoryID the categoryID to set
	 */
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	/**
	 * @return the parentID
	 */
	public String getParentID() {
		return parentID;
	}
	/**
	 * @param parentID the parentID to set
	 */
	public void setParentID(String parentID) {
		this.parentID = parentID;
	}
	/**
	 * @return the children
	 */
	public List<ProductCategory> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(List<ProductCategory> children) {
		this.children = children;
	}
	/**
	 * @return the parentName
	 */
	public String getParentName() {
		return parentName;
	}
	/**
	 * @param parentName the parentName to set
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
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
	
	
	
	/**
	 * @return the vendorId
	 */
	public String getVendorId() {
		return vendorId;
	}
	/**
	 * @param vendorId the vendorId to set
	 */
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	/**
	 * @return the vendorMappers
	 */
	public List<String> getVendorMappers() {
		return vendorMappers;
	}
	/**
	 * @param vendorMappers the vendorMappers to set
	 */
	public void setVendorMappers(List<String> vendorMappers) {
		this.vendorMappers = vendorMappers;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryID == null) ? 0 : categoryID.hashCode());
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
		ProductCategory other = (ProductCategory) obj;
		if (categoryID == null) {
			if (other.categoryID != null)
				return false;
		} else if (!categoryID.equals(other.categoryID))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductCategory [name=");
		builder.append(name);
		builder.append(", categoryID=");
		builder.append(categoryID);
		builder.append(", parentID=");
		builder.append(parentID);
		builder.append(", children=");
		builder.append(children);
		builder.append(", parentName=");
		builder.append(parentName);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", vendorId=");
		builder.append(vendorId);
		builder.append(", vendorMappers=");
		builder.append(vendorMappers);
		builder.append("]");
		return builder.toString();
	}
}
