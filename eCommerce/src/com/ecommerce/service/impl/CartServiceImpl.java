/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:CartServiceImpl.java
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

package com.ecommerce.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.mapper.CartMapper;
import com.ecommerce.mvc.model.Cart;
import com.ecommerce.mvc.model.Product;
import com.ecommerce.mvc.model.User;
import com.ecommerce.service.CartService;
import com.ecommerce.service.SOAPWebService;

/**
 * @author Abdul.Azeez
 *
 */
public class CartServiceImpl implements CartService {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Inject
	private SOAPWebService sOAPWebServiceImp;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ecommerce.service.CartService#getAllAddedProducts(com.ecommerce.mvc.
	 * model.User)
	 */
	@Override
	public List<Cart> getAllAddedProducts(User user) {
		String query = "select cart_id,cart_user_id,cart_product_id,cart_pdt_qty,cart_amount from cart where cart_user_id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Cart> carts = new ArrayList<Cart>();

		carts = jdbcTemplate.query(query, new Object[] { user.getUserId() }, new CartMapper());

		return carts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ecommerce.service.CartService#AddProducts(com.ecommerce.mvc.model.
	 * Product, com.ecommerce.mvc.model.User)
	 */
	@Override
	public boolean addProducts(Product product, User user) {

		Integer cartId = getLatestCartId();
		System.out.println(cartId);

		try {
			String sql = "INSERT INTO cart "
					+ "(cart_id, cart_user_id, cart_product_id,cart_pdt_qty,cart_amount) VALUES (?, ?, ?, ?, ?)";

			jdbcTemplate = new JdbcTemplate(dataSource);

			jdbcTemplate.update(sql,
					new Object[] { cartId, user.getUserId(), product.getProductID(), 1, product.getPriceList() });

			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}

	}

	public Cart getCartById(String id) {
		String query = "select cart_id,cart_user_id,cart_product_id,cart_pdt_qty,cart_amount from cart where cart_id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Cart cart = null;
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		cart = jdbcTemplate.queryForObject(query, new Object[] { id }, new RowMapper<Cart>() {

			@Override
			public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cart cart = new Cart();
				cart.setCartId(rs.getInt("cart_id"));
				cart.setUserId(rs.getString("cart_user_id"));
				cart.setProductId(rs.getString("cart_product_id"));
				cart.setQuantity(rs.getInt("cart_pdt_qty"));
				cart.setPrice(rs.getDouble("cart_amount"));
				return cart;
			}
		});

		return cart;
	}

	public Integer getLatestCartId() {
		Integer lastId = 0;
		String query = "select max(cart_id) from cart";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		lastId = jdbcTemplate.queryForObject(query, Integer.class);
		if (lastId == null) {
			lastId = 0;
		}
		System.out.println(lastId);
		return lastId + 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecommerce.service.CartService#removeProducts(java.lang.Number)
	 */
	@Override
	public boolean removeProducts(Number cartId) {
		// Integer cartId=getLatestCartId();
		System.out.println(cartId);

		try {
			String sql = "DELETE FROM cart WHERE cart_id = ?";

			jdbcTemplate = new JdbcTemplate(dataSource);

			jdbcTemplate.update(sql, new Object[] { cartId });

			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecommerce.service.CartService#getProductByID(java.lang.String)
	 */
	@Override
	public Product getProductByID(String productId) {
		Product product = null;
		product = sOAPWebServiceImp.getProductByID(productId);
		return product;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ecommerce.service.CartService#updateCart(com.ecommerce.mvc.model.
	 * Product, com.ecommerce.mvc.model.User)
	 */
	@Override
	public void updateCart(Number cartId, Integer qty) {

		 Integer quantity=getOriginalQty(cartId);

		try {
			String sql = "UPDATE cart set cart_pdt_qty = ? WHERE cart_id = ?";

			jdbcTemplate = new JdbcTemplate(dataSource);

			jdbcTemplate.update(sql, new Object[] { quantity+qty, cartId });

		} catch (Exception exception) {
			exception.printStackTrace();

		}

	}

	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return Integer
	 * @throws 
	 */
	
	private Integer getOriginalQty(Number cartId) {
		Integer	qty=0;
		String query = "select cart_pdt_qty from cart where cart_id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		qty= jdbcTemplate.queryForObject(query, new Object[] {cartId },Integer.class);
		
		System.out.println(qty);
		return qty;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.CartService#updateCartQuantity(java.lang.Number, java.lang.Integer)
	 */
	@Override
	public void updateCartQuantity(Number cartId, Integer quantity) {
		try {
			String sql = "UPDATE cart set cart_pdt_qty = ? WHERE cart_id = ?";

			jdbcTemplate = new JdbcTemplate(dataSource);

			jdbcTemplate.update(sql, new Object[] { quantity, cartId });

		} catch (Exception exception) {
			exception.printStackTrace();

		}
		
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.CartService#deleteAllGuestItems()
	 */
	@Override
	public void deleteAllGuestItems() {

		try {
			String sql = "DELETE FROM cart WHERE cart_user_id = ?";

			jdbcTemplate = new JdbcTemplate(dataSource);

			jdbcTemplate.update(sql, new Object[] { "0" });

			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}

}
