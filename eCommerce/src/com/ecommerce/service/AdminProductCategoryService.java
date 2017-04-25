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

package com.ecommerce.service;

import java.util.List;

import com.ecommerce.mvc.model.ProductCategory;

/**
 * @author Abdul.Azeez
 *
 */
public interface AdminProductCategoryService {

	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return List<User>
	 * @throws 
	 */
	
	List<ProductCategory> getAllCategories();

	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return boolean
	 * @throws 
	 */
	
	boolean createCategory(ProductCategory category);

	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return boolean
	 * @throws 
	 */
	
	boolean updateCategory(ProductCategory category);

	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return boolean
	 * @throws 
	 */
	
	boolean updateCategoryStatus(ProductCategory category);

}
