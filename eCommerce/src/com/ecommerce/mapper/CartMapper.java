package com.ecommerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.mvc.model.Cart;

public class CartMapper implements RowMapper<Cart> {
	 public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		 Cart cart = new Cart();
			cart.setCartId(rs.getInt("cart_id"));
			cart.setUserId(rs.getString("cart_user_id"));
			cart.setProductId(rs.getString("cart_product_id"));
			cart.setQuantity(rs.getInt("cart_pdt_qty"));
			cart.setPrice(rs.getDouble("cart_amount"));
	      return cart;
	   }
}