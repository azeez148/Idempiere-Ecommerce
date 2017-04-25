/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:WishListMapper.java
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

package com.ecommerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.mvc.model.WishList;

/**
 * @author srigin.ms
 *
 */
public class WishListMapper implements RowMapper<WishList> {

	 public WishList mapRow(ResultSet rs, int rowNum) throws SQLException {
		 WishList wishList = new WishList();
			wishList.setWishID(rs.getInt("wishlist_id"));
			wishList.setUserId(rs.getString("wishlist_user_id"));
			wishList.setProductId(rs.getString("wishlist_product_id"));
			wishList.setQuantity(rs.getInt("wishlist_pdt_qty"));
			wishList.setPrice(rs.getDouble("wishlist_amount"));
	      return wishList;
	   }
}
