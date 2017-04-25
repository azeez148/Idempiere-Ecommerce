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

import java.util.HashMap;
import java.util.Map;

/**
 * Component Info Class
 */
public class ComponentInfo {

	public static final String NAME = "iDempiere Web Service Client";
	public static final String COMPONENT_NAME = "idempierewsc";
	public static final String VERSION = "1.5.0";

	/**
	 * Get Component info
	 * 
	 * @return Map info
	 */
	public static Map<String, String> ToMap() {
		Map<String, String> info = new HashMap<String, String>();
		info.put("NAME", NAME);
		info.put("COMPONENT_NAME", COMPONENT_NAME);
		info.put("VERSION", VERSION);
		return info;
	}
}
