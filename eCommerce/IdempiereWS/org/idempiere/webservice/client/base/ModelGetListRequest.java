/**
 * This file is part of iDempiere Java Web Service Client for iDempiere ERP <http://www.idempiere.org>.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Copyright (C) 2015 INGEINT <http://www.ingeint.com>.
 * Copyright (C) Contributors.
 * 
 * Contributors:
 *    - 2015 Saúl Piña <sauljabin@gmail.com, saul.pina@ingeint.com>.
 */

package org.idempiere.webservice.client.base;

import org.idempiere.webservice.client.base.Enums.WebServiceRequestModel;


/**
 * ModelGetListRequest. Web Service Request
 */
public abstract class ModelGetListRequest extends WebServiceRequest {

	private Integer AD_Reference_ID;
	private String filter;

	/**
	 * Gets the AD_Reference_ID
	 * 
	 * @return The AD_Reference_ID
	 */
	public Integer getAD_Reference_ID() {
		return AD_Reference_ID;
	}

	/**
	 * Sets the AD_Reference_ID
	 * 
	 * @param AD_Reference_ID
	 *            The AD_Reference_ID to set
	 */
	public void setAD_Reference_ID(Integer AD_Reference_ID) {
		this.AD_Reference_ID = AD_Reference_ID;
	}

	/**
	 * Gets the filter
	 * 
	 * @return The filter
	 */
	public String getFilter() {
		return filter;
	}

	/**
	 * Sets the filter
	 * 
	 * @param filter
	 *            The filter to set
	 */
	public void setFilter(String filter) {
		this.filter = filter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.idempiere.webservice.client.base.WebServiceRequest#getWebServiceRequestModel()
	 */
	@Override
	public WebServiceRequestModel getWebServiceRequestModel() {
		return WebServiceRequestModel.ModelGetListRequest;
	}

}
