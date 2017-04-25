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

package org.idempiere.webservice.client.exceptions;

/**
 * WebService Timeout Exception
 */
public class WebServiceTimeoutException extends WebServiceException {

	private static final long serialVersionUID = -3429134033196006001L;

	public WebServiceTimeoutException() {
	}

	public WebServiceTimeoutException(String message) {
		super(message);
	}

	public WebServiceTimeoutException(Throwable cause) {
		super(cause);
	}

	public WebServiceTimeoutException(String message, Throwable cause) {
		super(message, cause);
	}

}
