/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:CategoryService.java
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
import java.util.Set;

import com.ecommerce.mvc.model.Product;
import com.ecommerce.mvc.model.ProductCategory;

/**
 * @author Abdul.Azeez
 *
 */
public interface CategoryService {

	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return List<Product>
	 * @throws 
	 */
	
	public Set<Product> getProducts(String name, String categoryId);

	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return List<ProductCategory>
	 * @throws 
	 */
	
	public List<ProductCategory> getProductCategory();

	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return ProductCategory
	 * @throws 
	 */
	
	public ProductCategory getCategoryById(String categoryId);

}
