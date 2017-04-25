/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:Country.java
 *  Created by: Abdul.Azeez
 *  Date: Oct 4, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: Abdul.Azeez
 *  Date: Oct 4, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.mvc.model;

import java.util.List;

/**
 * @author Abdul.Azeez
 *
 */
public class Country {

	private String countryId;
	private String countryCode;
	private String countryName;
	private List<State> states;
	/**
	 * @return the countryId
	 */
	public String getCountryId() {
		return countryId;
	}
	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}
	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	/**
	 * @return the states
	 */
	public List<State> getStates() {
		return states;
	}
	/**
	 * @param states the states to set
	 */
	public void setStates(List<State> states) {
		this.states = states;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Country [countryId=");
		builder.append(countryId);
		builder.append(", countryCode=");
		builder.append(countryCode);
		builder.append(", countryName=");
		builder.append(countryName);
		builder.append(", states=");
		builder.append(states);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
