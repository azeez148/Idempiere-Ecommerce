/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:MainServiceImpl.java
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

package com.ecommerce.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.ecommerce.mvc.model.Country;
import com.ecommerce.mvc.model.Product;
import com.ecommerce.service.CommonService;
import com.ecommerce.service.SOAPWebService;

/**
 * @author Abdul.Azeez
 *
 */
public class CommonServiceImpl implements CommonService {
		
	@Inject
	private SOAPWebService sOAPWebServiceImp;

	@Override
	public void writeAllImages(HttpServletRequest servletContext) {
		sOAPWebServiceImp.writeAllImages(servletContext);
	}
	/* (non-Javadoc)
	 * @see com.ecommerce.service.CommonService#getHotSellingProducts()
	 */
	@Override
	public List<Product> getHotSellingProducts() {
		List<Product> items = sOAPWebServiceImp.getHotSellingProducts();
		return items;
	}
	/* (non-Javadoc)
	 * @see com.ecommerce.service.CommonService#getAllCountryDetails()
	 */
	@Override
	public List<Country> getAllCountryDetails() {
		List<Country> countries = sOAPWebServiceImp.getCountries();
		return countries;
	}

}
