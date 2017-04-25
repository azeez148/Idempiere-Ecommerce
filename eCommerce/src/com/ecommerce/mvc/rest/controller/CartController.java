/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:CartController.java
 *  Created by: Abdul.Azeez
 *  Date: Sep 6, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: Abdul.Azeez
 *  Date: Sep 6, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.mvc.rest.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.mvc.model.Cart;
import com.ecommerce.mvc.model.Product;
import com.ecommerce.mvc.model.User;
import com.ecommerce.service.CartService;
import com.ecommerce.service.UserService;

/**
 * @author Abdul.Azeez
 *
 */
@RestController
@RequestMapping("/cart")
public class CartController {

	// for logging
	final static Logger logger = Logger.getLogger(CartController.class);

	@Inject
	CartService cartService;
	@Inject
	UserService userService;

	@RequestMapping(value = "/cart/{productId}/{userId}")
	public ResponseEntity<List<Cart>> getCartPage(@PathVariable("productId") String productId,
			@PathVariable("userId") String userId) {

		System.out.println("productId is " + productId);
		System.out.println("userId is " + userId);

		Product product = null;
		User user = null;
		boolean isAdded = false;
		boolean isDupe = false;
		List<Cart> cartList = null;
		Number cartId = 0;
		Integer quantity = 0;

		product = cartService.getProductByID(productId);

		
		if(userId.equals("0")){
			user = userService.setGuestUser();
		}else{
			user = userService.getUserById(userId);
			cartService.deleteAllGuestItems();
		}
		
		System.out.println(user);

		if (!productId.equals("0")) {

			cartList = cartService.getAllAddedProducts(user);
			for (Cart cart : cartList) {
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa "+cart.getPrice());
				if (cart.getProductId().equals(productId)) {
					isDupe = true;
					cartId = cart.getCartId();
					quantity = cart.getQuantity();
				}
				/*
				 * product = cartService.getProductByID(cart.getProductId());
				 * cart.setProduct(product); cart.setUser(user);
				 */
			}

			if (!isDupe) {
				isAdded = cartService.addProducts(product, user);
			} else {
				cartService.updateCart(cartId, quantity);
			}
		}

		cartList = cartService.getAllAddedProducts(user);
		for (Cart cart : cartList) {
			product = cartService.getProductByID(cart.getProductId());
			cart.setProduct(product);
			cart.setUser(user);
		}
		System.out.println(cartList);

		return new ResponseEntity<List<Cart>>(cartList, HttpStatus.OK);
	}

	@RequestMapping(value = "/cart/del/{cartId}/{productId}/{userId}")
	public ResponseEntity<List<Cart>> deleteCartItems(@PathVariable("cartId") String cartId,
			@PathVariable("productId") String productId, @PathVariable("userId") String userId) {

		System.out.println("productId is " + productId);
		System.out.println("cartId is " + cartId);
		System.out.println("userId is " + userId);

		Product product = null;
		User user = null;
		boolean isDeleted = false;
		List<Cart> cartList = null;

		if (!cartId.equals("0")) {
			isDeleted = cartService.removeProducts(Integer.parseInt(cartId.toString()));
		}
		product = cartService.getProductByID(productId);
		user = userService.getUserById(userId);
		System.out.println(user);
		cartList = cartService.getAllAddedProducts(user);

		for (Cart cart : cartList) {
			System.out.println(cart);

			cart.setProduct(product);

			cart.setUser(user);
		}

		if (!isDeleted) {
			return new ResponseEntity<List<Cart>>(cartList, HttpStatus.BAD_REQUEST);
		}

		else {
			return new ResponseEntity<List<Cart>>(cartList, HttpStatus.OK);
		}
	}
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/updateCart/{cartId}/{qty}")
	public ResponseEntity updateCart(@PathVariable("cartId") String cartId,
			@PathVariable("qty") String qty) {

		System.out.println("cartId is " + cartId);
		System.out.println("qty is " + qty);
		
		cartService.updateCartQuantity(Integer.parseInt(cartId), Integer.parseInt(qty));
		
		
	
		return new ResponseEntity(HttpStatus.OK);
	}
}
