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

package com.ecommerce.util;

import org.idempiere.webservice.client.base.LoginRequest;
import org.idempiere.webservice.client.exceptions.XMLWriteException;
import org.idempiere.webservice.client.net.WebServiceConnection;

public abstract class AbstractTestWS {

	private LoginRequest login;
	private WebServiceConnection client;

	public AbstractTestWS() {
		login = new LoginRequest();
		login.setUser("SuperUser");
		login.setPass("System");
		login.setClientID(1000001);
		login.setRoleID(1000002);
		login.setOrgID(0);
		login.setStage(2);

		client = new WebServiceConnection();
		client.setAttempts(3);
		client.setTimeout(5000);
		client.setAttemptsTimeout(5000);
		client.setUrl(getUrlBase());
		client.setAppName("Java Test WS Client");
		runTest();  				//	UnComment for the defualt working with the test data WS
	}

	public LoginRequest getLogin() {
		return login;
	}

	public String getUrlBase() {
		return "http://nestit-iso-171:8081";
	}

	public WebServiceConnection getClient() {
		return client;
	}

	public void printTotal() {
		System.out.println("--------------------------");
		System.out.println("Web Service: " + getWebServiceType());
		System.out.println("Attempts: " + client.getAttemptsRequest());
		System.out.println("Time: " + client.getTimeRequest());
		System.out.println("--------------------------");
	}

	public void saveRequestResponse() {
		try {
			getClient().writeRequest("E:\\WebService\\OUTPUT\\" + getWebServiceType() + "_request.xml");
			getClient().writeResponse("E:\\WebService\\OUTPUT\\" + getWebServiceType() + "_response.xml");
		} catch (XMLWriteException e) {
			e.printStackTrace();
		}
	}

	public void printRequestResponse() {
		try {
			getClient().writeRequest(System.out);
			System.out.println();
			System.out.println();
			getClient().writeResponse(System.out);
		} catch (XMLWriteException e) {
			e.printStackTrace();
		}
	}

	public void runTest() {
		testPerformed();
		//saveRequestResponse();
		printTotal();
		System.out.println();
	}

	public abstract String getWebServiceType();

	public abstract void testPerformed();

}
