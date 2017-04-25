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

package org.idempiere.webservice.client.response;

import org.idempiere.webservice.client.base.DataRow;
import org.idempiere.webservice.client.base.Enums.WebServiceResponseModel;
import org.idempiere.webservice.client.base.WebServiceResponse;

/**
 * StandardResponse. Response from SetDocAction, CreateData, DeleteData, UpdateData Web Services
 */
public class StandardResponse extends WebServiceResponse {

	private Integer recordID;
	private DataRow outputFields;

	/**
	 * Response from SetDocAction, CreateData, DeleteData, UpdateData Web Services
	 */
	public StandardResponse() {
		outputFields = new DataRow();
	}

	/**
	 * Gets the recordID
	 * 
	 * @return The recordID
	 */
	public Integer getRecordID() {
		return recordID;
	}

	/**
	 * Sets the recordID
	 * 
	 * @param recordID
	 *            The recordID to set
	 */
	public void setRecordID(Integer recordID) {
		this.recordID = recordID;
	}

	/**
	 * Gets the outputFields
	 * 
	 * @return The outputFields
	 */
	public DataRow getOutputFields() {
		return outputFields;
	}

	/**
	 * Sets the outputFields
	 * 
	 * @param outputFields
	 *            The outputFields to set
	 */
	public void setOutputFields(DataRow outputFields) {
		this.outputFields = outputFields;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.idempiere.webservice.client.base.WebServiceResponse#getWebServiceResponseModel()
	 */
	@Override
	public WebServiceResponseModel getWebServiceResponseModel() {
		return WebServiceResponseModel.StandardResponse;
	}

}
