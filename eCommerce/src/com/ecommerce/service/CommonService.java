/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:MainService.java
 *  Created by: Abdul.Azeez
 *  Date: Sep 9, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: Abdul.Azeez
 *  Date: Sep 9, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ecommerce.mvc.model.Country;
import com.ecommerce.mvc.model.Product;

/**
 * @author Abdul.Azeez
 *
 */
public interface CommonService {

	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return void
	 * @throws 
	 */
	
	public void writeAllImages(HttpServletRequest servletContext);

	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return List<Product>
	 * @throws 
	 */
	
	public List<Product> getHotSellingProducts();

	/**
	 * @return 
	 * Gets ....
	 * @param 
	 * @param 
	 * @return void
	 * @throws 
	 */
	
	public List<Country> getAllCountryDetails();

}
