/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:ProductService.java
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

import com.ecommerce.mvc.model.Attribute;
import com.ecommerce.mvc.model.Product;

/**
 * @author Abdul.Azeez
 *
 */
public interface ProductService {

	
	/**		Get products by ID	*/
	public Product getProductByID(String ID);
	
	/**		Get All Products by Category	*/

	
	public Set<Product> getProducts(String name, String category);

	
	/**		Get All Products by Category	*/
	
	public Set<Attribute> getProductAttrbutes();

	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return Product
	 * @throws 
	 */
	
	public Set<Product> getAllProducts();

}
