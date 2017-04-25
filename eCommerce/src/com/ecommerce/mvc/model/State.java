/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:State.java
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
public class State {
	private String stateId;
	private String  stateName;
	private List<City> cities;
	/**
	 * @return the stateId
	 */
	public String getStateId() {
		return stateId;
	}
	/**
	 * @param stateId the stateId to set
	 */
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}
	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	/**
	 * @return the cities
	 */
	public List<City> getCities() {
		return cities;
	}
	/**
	 * @param cities the cities to set
	 */
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("State [stateId=");
		builder.append(stateId);
		builder.append(", stateName=");
		builder.append(stateName);
		builder.append(", cities=");
		builder.append(cities);
		builder.append("]");
		return builder.toString();
	}
	
	
}
