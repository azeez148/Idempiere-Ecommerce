/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:CartService.java
 *  Created by: Abdul.Azeez
 *  Date: Aug 29, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: Abdul.Azeez
 *  Date: Aug 29, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.service;

import java.util.List;

import com.ecommerce.mvc.model.Product;
import com.ecommerce.mvc.model.User;
import com.ecommerce.mvc.model.WishList;


/**
 * @author srigin.ms
 *
 */
public interface WishListService {
	
	/**	Get all products		*/
	public List<WishList> getAllProducts(User user);
	
	/**	Add product		*/
	public boolean addProduct(Product product,User user);
	
	/**	Remove product		*/
	public boolean removeProducts(Number number);
	
	/**	Get By ID	*/
	public WishList getWishListById(String id);
	
	/**	Get Product by ID	*/
	public Product getProductByID(String productId);
	
	/**	UPDATE List	*/
	public void updateList(Number wishId, Integer quantity);

	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return void
	 * @throws 
	 */
	
	public void deleteAllGuestItems();
}
