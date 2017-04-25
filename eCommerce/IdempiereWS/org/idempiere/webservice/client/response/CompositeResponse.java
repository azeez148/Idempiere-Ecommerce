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

import java.util.ArrayList;
import java.util.List;

import org.idempiere.webservice.client.base.Enums.WebServiceResponseModel;
import org.idempiere.webservice.client.base.WebServiceResponse;

/**
 * CompositeResponse. Response from CompositeInterface Web Service
 */
public class CompositeResponse extends WebServiceResponse {

	private List<WebServiceResponse> responses;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.idempiere.webservice.client.base.WebServiceResponse#getWebServiceResponseModel()
	 */
	@Override
	public WebServiceResponseModel getWebServiceResponseModel() {
		return WebServiceResponseModel.CompositeResponse;
	}

	/**
	 * Default constructor
	 */
	public CompositeResponse() {
		responses = new ArrayList<WebServiceResponse>();
	}

	/**
	 * Gets the responses
	 * 
	 * @return The responses
	 */
	public List<WebServiceResponse> getResponses() {
		List<WebServiceResponse> temp = new ArrayList<WebServiceResponse>();
		temp.addAll(responses);
		return temp;
	}

	/**
	 * Removes the response
	 * 
	 * @param response
	 *            Response
	 */
	public void removeResponse(WebServiceResponse response) {
		responses.remove(response);
	}

	/**
	 * Removes the response
	 * 
	 * @param pos
	 *            Position
	 * @return The response
	 */
	public WebServiceResponse removeResponse(int pos) {
		WebServiceResponse returnResponse = getResponse(pos);
		responses.remove(returnResponse);
		return returnResponse;
	}

	/**
	 * Adds the response
	 * 
	 * @param response
	 *            Response
	 */
	public void addResponse(WebServiceResponse response) {
		responses.add(response);
	}

	/**
	 * Gets the responses count
	 * 
	 * @return The responses count
	 */
	public int getResponsesCount() {
		return responses.size();
	}

	/**
	 * Gets the response
	 * 
	 * @param pos
	 *            Position
	 * @return The response
	 */
	public WebServiceResponse getResponse(int pos) {
		return responses.get(pos);
	}

	/**
	 * Clear this instance
	 */
	public void clear() {
		responses.clear();
	}

}
