/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:CategoryVendorMapper.java
 *  Created by: Abdul.Azeez
 *  Date: Nov 10, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: Abdul.Azeez
 *  Date: Nov 10, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.mvc.model;

/**
 * @author Abdul.Azeez
 *
 */
public class CategoryVendorMapper {
	private String vendorId;
	private String catgoryId;
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
	 * @return the catgoryId
	 */
	public String getCatgoryId() {
		return catgoryId;
	}
	/**
	 * @param catgoryId the catgoryId to set
	 */
	public void setCatgoryId(String catgoryId) {
		this.catgoryId = catgoryId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CategoryVendorMapper [vendorId=");
		builder.append(vendorId);
		builder.append(", catgoryId=");
		builder.append(catgoryId);
		builder.append("]");
		return builder.toString();
	}
	
	

}
