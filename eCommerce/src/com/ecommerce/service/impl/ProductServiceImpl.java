/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:ProductServiceImpl.java
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
import java.util.Set;

import javax.inject.Inject;

import com.ecommerce.mvc.model.Attribute;
import com.ecommerce.mvc.model.Product;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.SOAPWebService;

/**
 * @author Abdul.Azeez
 *
 */
public class ProductServiceImpl implements ProductService {

	@Inject
	private SOAPWebService sOAPWebServiceImp;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ecommerce.service.ProductService#getProductByID(java.lang.String)
	 */
	@Override
	public Product getProductByID(String productId) {
		// TODO Auto-generated method stub
		return sOAPWebServiceImp.getProductByID(productId);

	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.ProductService#getProducts(java.lang.String, java.lang.String)
	 */
	@Override
	public Set<Product> getProducts(String name, String category) {
		// TODO Auto-generated method stub
		return sOAPWebServiceImp.getProducts(name, category);
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.ProductService#getProductAttrbutes()
	 */
	@Override
	public Set<Attribute> getProductAttrbutes() {
		// TODO Auto-generated method stub
		return sOAPWebServiceImp.getProductAttrbutes();
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.ProductService#getAllProducts()
	 */
	@Override
	public Set<Product> getAllProducts() {
		return sOAPWebServiceImp.getAllProducts();
	}

}
