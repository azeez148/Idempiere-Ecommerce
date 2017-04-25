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

import com.ecommerce.mvc.model.Cart;
import com.ecommerce.mvc.model.Product;
import com.ecommerce.mvc.model.User;

/**
 * @author Abdul.Azeez
 *
 */
public interface CartService {
	
	public List<Cart> getAllAddedProducts(User user);
	public boolean addProducts(Product product,User user);
	public boolean removeProducts(Number number);
	public Cart getCartById(String id);
	/**
	 * Gets ProductByID....
	 * @param productId
	 * @param 
	 * @return Product
	 * @throws 
	 */
	
	public Product getProductByID(String productId);
	
	/**
	 * @param quantity 
	 * Gets ....
	 * @param 
	 * @param 
	 * @return void
	 * @throws 
	 */
	
	public void updateCart(Number cartId, Integer quantity);
	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return void
	 * @throws 
	 */
	
	public void updateCartQuantity(Number cartId, Integer quantity);
	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return void
	 * @throws 
	 */
	
	public void deleteAllGuestItems();
}
