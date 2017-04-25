/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:WishListServiceImp.java
 *  Created by: srigin.ms
 *  Date: Sep 29, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: srigin.ms
 *  Date: Sep 29, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ecommerce.mapper.WishListMapper;
import com.ecommerce.mvc.model.Product;
import com.ecommerce.mvc.model.User;
import com.ecommerce.mvc.model.WishList;
import com.ecommerce.service.SOAPWebService;
import com.ecommerce.service.WishListService;

/**
 * @author srigin.ms
 *
 */
public class WishListServiceImpl implements WishListService{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Inject
	private SOAPWebService sOAPWebServiceImp;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	/* (non-Javadoc)
	 * @see com.ecommerce.service.WishListService#getAllProducts(com.ecommerce.mvc.model.User)
	 */
	@Override
	public List<WishList> getAllProducts(User user) {
		// TODO Auto-generated method stub
		String query = "select wishlist_id, wishlist_user_id, wishlist_product_id, wishlist_pdt_qty, wishlist_amount from wishlist where wishlist_user_id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<WishList> wishLists = new ArrayList<WishList>();

		wishLists = jdbcTemplate.query(query,new Object[] {user.getUserId()},
                new WishListMapper());
		 
		 
		return wishLists;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.WishListService#addProduct(com.ecommerce.mvc.model.Product, com.ecommerce.mvc.model.User)
	 */
	@Override
	public boolean addProduct(Product product, User user) {
		// TODO Auto-generated method stub
		Integer cartId=getLatestWishListId();
		System.out.println(cartId);
		
	try{
		String sql = "INSERT INTO wishlist " +
				"(wishlist_id, wishlist_user_id, wishlist_product_id, wishlist_pdt_qty, wishlist_amount) VALUES (?, ?, ?, ?, ?)";
		
		jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(sql, new Object[] {cartId
				,  user.getUserId(),
				product.getProductID(),1,product.getPriceList()
		});

		return true;
	}
		catch(Exception exception){
			exception.printStackTrace();
			return false;
		}
		
		
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.WishListService#removeProducts(java.lang.Number)
	 */
	@Override
	public boolean removeProducts(Number wishListId) {
		// TODO Auto-generated method stub
		
		try{
			String sql = "DELETE FROM wishlist WHERE wishlist_id = ?";
			
			jdbcTemplate = new JdbcTemplate(dataSource);

			jdbcTemplate.update(sql, new Object[] { wishListId });

			return true;
		}
			catch(Exception exception){
				exception.printStackTrace();
				return false;
			}
		

	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.WishListService#getWishListById(java.lang.String)
	 */
	@Override
	public WishList getWishListById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.WishListService#getProductByID(java.lang.String)
	 */
	@Override
	public Product getProductByID(String productId) {
		// TODO Auto-generated method stub
		Product product = null;
		product=sOAPWebServiceImp.getProductByID(productId);
		return product;
	}

	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return Integer
	 * @throws 
	 */
	public Integer getLatestWishListId() {
		Integer lastId=0;
		String query = "select max(wishlist_id) from wishlist";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		lastId = jdbcTemplate.queryForObject(query, Integer.class);
		if(lastId == null){
			lastId=0;
		}
		return lastId+1;
	}


	/* (non-Javadoc)
	 * @see com.ecommerce.service.WishListService#updateList(java.lang.Number, java.lang.Integer)
	 */
	@Override
	public void updateList(Number wishId, Integer quantity) {
		// TODO Auto-generated method stub
		try{
			String sql = "UPDATE wishlist set wishlist_pdt_qty = ? WHERE wishlist_id = ?";
			
			jdbcTemplate = new JdbcTemplate(dataSource);

			jdbcTemplate.update(sql, new Object[] { quantity,wishId });
	
		}
			catch(Exception exception){
				exception.printStackTrace();
				
			}
	}
	/* (non-Javadoc)
	 * @see com.ecommerce.service.CartService#deleteAllGuestItems()
	 */
	@Override
	public void deleteAllGuestItems() {

		try {
			String sql = "DELETE FROM wishlist WHERE wishlist_user_id = ?";

			jdbcTemplate = new JdbcTemplate(dataSource);

			jdbcTemplate.update(sql, new Object[] { "0" });

			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}

}
