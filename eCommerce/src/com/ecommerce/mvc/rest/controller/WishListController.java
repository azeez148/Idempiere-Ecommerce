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
import com.ecommerce.mvc.model.WishList;
import com.ecommerce.service.CartService;
import com.ecommerce.service.UserService;
import com.ecommerce.service.WishListService;

/**
 * @author Abdul.Azeez
 *
 */
@RestController
@RequestMapping("/wish")
public class WishListController {

	// for logging
	final static Logger logger = Logger.getLogger(WishListController.class);

	@Inject
	WishListService wishListService;
	@Inject
	UserService userService;

	@RequestMapping(value = "/wish/{productId}/{userId}")
	public ResponseEntity<List<WishList>> getWishList(@PathVariable("productId") String productId,
			@PathVariable("userId") String userId) {

		Product product = null;
		User user = null;
		boolean isDupe = false;
		List<WishList> wishList = null;
		Number wishId = 0;
		Integer quantity = 0;

		product = wishListService.getProductByID(productId);

		/*user = userService.getUserById(userId);
		System.out.println(user);*/
		
		
		if(userId.equals("0")){
			user = userService.setGuestUser();
		}else{
			user = userService.getUserById(userId);
			wishListService.deleteAllGuestItems();
		}
		
		

		if (!productId.equals("0")) {

			wishList = wishListService.getAllProducts(user);
			for (WishList item : wishList) {
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa "+item.getPrice());
				if (item.getProductId().equals(productId)) {
					isDupe = true;
					wishId = item.getWishID();
					quantity = item.getQuantity();
				}
			}

			if (!isDupe) {
				wishListService.addProduct(product, user);
			} else {
				wishListService.updateList(wishId, quantity);
			}
		}

		wishList = wishListService.getAllProducts(user);
		for (WishList item : wishList) {
			product = wishListService.getProductByID(item.getProductId());
			item.setProduct(product);
			item.setUser(user);
		}
		System.out.println(wishList);

		return new ResponseEntity<List<WishList>>(wishList, HttpStatus.OK);
	}

	@RequestMapping(value = "/wish/del/{wishId}/{productId}/{userId}")
	public ResponseEntity<List<WishList>> deleteWishListItem(@PathVariable("wishId") String wishListId,
			@PathVariable("productId") String productId, @PathVariable("userId") String userId) {

		System.out.println("productId is " + productId);
		System.out.println("cartId is " + wishListId);
		System.out.println("userId is " + userId);

		Product product = null;
		User user = null;
		boolean isDeleted = false;
		List<WishList> wishList = null;

		if (!wishListId.equals("0")) {
			isDeleted = wishListService.removeProducts(Integer.parseInt(wishListId.toString()));
		}
		product = wishListService.getProductByID(productId);
		user = userService.getUserById(userId);
		System.out.println(user);
		wishList = wishListService.getAllProducts(user);

		for (WishList item : wishList) {
			System.out.println(item);

			item.setProduct(product);

			item.setUser(user);
		}

		if (!isDeleted) {
			return new ResponseEntity<List<WishList>>(wishList, HttpStatus.BAD_REQUEST);
		}

		else {
			return new ResponseEntity<List<WishList>>(wishList, HttpStatus.OK);
		}
	}
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/updateCart/{wishID}/{qty}")
	public ResponseEntity updateCart(@PathVariable("wishID") String wishID,
			@PathVariable("qty") String qty) {

		System.out.println("cartId is " + wishID);
		System.out.println("qty is " + qty);
		
		wishListService.updateList(Integer.parseInt(wishID), Integer.parseInt(qty));
		
		
		//return null;

	/*	Product product = null;
		User user = null;
		boolean isAdded = false;
		boolean isDupe = false;
		List<Cart> cartList = null;
		Number cartId = 0;
		Integer quantity = 0;

		product = cartService.getProductByID(productId);

		user = userService.getUserById(userId);
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
				
				 * product = cartService.getProductByID(cart.getProductId());
				 * cart.setProduct(product); cart.setUser(user);
				 
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
		System.out.println(cartList);*/

		return new ResponseEntity(HttpStatus.OK);
	}
}
