/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:AdminProductCategoryService.java
 *  Created by: Abdul.Azeez
 *  Date: Nov 3, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: Abdul.Azeez
 *  Date: Nov 3, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.ecommerce.mvc.model.PriceList;
import com.ecommerce.mvc.model.ProductCategory;
import com.ecommerce.service.PriceListService;
import com.ecommerce.service.SOAPWebService;

/**
 * @author Abdul.Azeez
 *
 */
public class PriceListServiceImpl implements PriceListService{

	@Inject
	private SOAPWebService sOAPWebServiceImp;
	
	/* (non-Javadoc)
	 * @see com.ecommerce.service.AdminProductCategoryService#getAllCategories()
	 */
	@Override
	public List<PriceList> getAllPriceLists() {
		
		
		
		List<PriceList> items = null;
		items=sOAPWebServiceImp.getAllPriceLists();
		
		
		//items=sOAPWebServiceImp.getProductCategory();
		return items;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.AdminProductCategoryService#createCategory(com.ecommerce.mvc.model.ProductCategory)
	 */
	@Override
	public boolean createCategory(ProductCategory category) {
		boolean isAdded=true;
		return isAdded;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.AdminProductCategoryService#updateCategory(com.ecommerce.mvc.model.ProductCategory)
	 */
	@Override
	public boolean updateCategory(ProductCategory category) {
		boolean isUpdated=sOAPWebServiceImp.updateProductCategory(category);
		return isUpdated;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.AdminProductCategoryService#updateCategoryStatus(com.ecommerce.mvc.model.ProductCategory)
	 */
	@Override
	public boolean updateCategoryStatus(ProductCategory category) {
		boolean isUpdated=sOAPWebServiceImp.updateCategoryStatus(category);
		return isUpdated;
	}

}
