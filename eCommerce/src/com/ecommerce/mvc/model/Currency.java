/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:Currency.java
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
public class Currency {
private String currencyCode;
private String currencyId;
private String symbol;
private String description;
/**
 * @return the currencyCode
 */
public String getCurrencyCode() {
	return currencyCode;
}
/**
 * @param currencyCode the currencyCode to set
 */
public void setCurrencyCode(String currencyCode) {
	this.currencyCode = currencyCode;
}
/**
 * @return the currencyId
 */
public String getCurrencyId() {
	return currencyId;
}
/**
 * @param currencyId the currencyId to set
 */
public void setCurrencyId(String currencyId) {
	this.currencyId = currencyId;
}
/**
 * @return the symbol
 */
public String getSymbol() {
	return symbol;
}
/**
 * @param symbol the symbol to set
 */
public void setSymbol(String symbol) {
	this.symbol = symbol;
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
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Currency [currencyCode=");
	builder.append(currencyCode);
	builder.append(", currencyId=");
	builder.append(currencyId);
	builder.append(", symbol=");
	builder.append(symbol);
	builder.append(", description=");
	builder.append(description);
	builder.append("]");
	return builder.toString();
}

}
