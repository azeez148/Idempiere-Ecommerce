/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:CategoryServiceImpl.java
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

import com.ecommerce.mvc.model.Product;
import com.ecommerce.mvc.model.ProductCategory;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.SOAPWebService;

/**
 * @author Abdul.Azeez
 *
 */
public class CategoryServiceImpl implements CategoryService{

	@Inject
	private SOAPWebService sOAPWebServiceImp;
	
	
	/* (non-Javadoc)
	 * @see com.ecommerce.service.CategoryService#getDBProducts(java.lang.Object, java.lang.String)
	 */
	@Override
	public Set<Product> getProducts(String name, String categoryId) {
		
		Set<Product> items = sOAPWebServiceImp.getProducts(name, categoryId);
		return items;
	}


	/* (non-Javadoc)
	 * @see com.ecommerce.service.CategoryService#getProductCategory()
	 */
	@Override
	public List<ProductCategory> getProductCategory() {
		List<ProductCategory> items = null;
		items=sOAPWebServiceImp.getProductCategory();
		return items;
	}


	/* (non-Javadoc)
	 * @see com.ecommerce.service.CategoryService#getCategoryById(java.lang.String)
	 */
	@Override
	public ProductCategory getCategoryById(String categoryId) {
		ProductCategory category=sOAPWebServiceImp.getCategoryById(categoryId);
		//ProductCategory category=sOAPWebServiceImp.getCa
		return category;
	}



}
