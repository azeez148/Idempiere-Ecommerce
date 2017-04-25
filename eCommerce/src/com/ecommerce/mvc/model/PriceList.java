/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:PriceList.java
 *  Created by: Abdul.Azeez
 *  Date: Nov 8, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: Abdul.Azeez
 *  Date: Nov 8, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.mvc.model;

/**
 * @author Abdul.Azeez
 *
 */
public class PriceList {
private String name;
private String priceListId;
private String description;
private String isActive;
private Currency currency;
private String isSalesPriceList;


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
 * @return the priceListId
 */
public String getPriceListId() {
	return priceListId;
}
/**
 * @param priceListId the priceListId to set
 */
public void setPriceListId(String priceListId) {
	this.priceListId = priceListId;
}
/**
 * @return the description
 */
public String getDescription() {
	return description;
}
/**
 * @param description the description to set
 */
public void setDescription(String description) {
	this.description = description;
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
 * @return the currency
 */
public Currency getCurrency() {
	return currency;
}
/**
 * @param currency the currency to set
 */
public void setCurrency(Currency currency) {
	this.currency = currency;
}
/**
 * @return the isSalesPriceList
 */
public String getIsSalesPriceList() {
	return isSalesPriceList;
}
/**
 * @param isSalesPriceList the isSalesPriceList to set
 */
public void setIsSalesPriceList(String isSalesPriceList) {
	this.isSalesPriceList = isSalesPriceList;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("PriceList [name=");
	builder.append(name);
	builder.append(", priceListId=");
	builder.append(priceListId);
	builder.append(", description=");
	builder.append(description);
	builder.append(", isActive=");
	builder.append(isActive);
	builder.append(", currency=");
	builder.append(currency);
	builder.append(", isSalesPriceList=");
	builder.append(isSalesPriceList);
	builder.append("]");
	return builder.toString();
}



}
