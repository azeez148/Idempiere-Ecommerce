/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:UserMapper.java
 *  Created by: Abdul.Azeez
 *  Date: Oct 27, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: Abdul.Azeez
 *  Date: Oct 27, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.mvc.model.User;

/**
 * @author Abdul.Azeez
 *
 */
public class UserMapper implements RowMapper<User> {
	 public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		 User user = new User();
		 
		 
		 
		 
		 user.setUserId(rs.getString("ecommerce_users_id"));
		user.setIsActive(rs.getString("ecommerce_users_isactive"));
			
		if(rs.getString("ecommerce_users_iscustomer") != null && rs.getString("ecommerce_users_iscustomer").equals("true")){
				user.setIsCustomer(true);
			}
			if(rs.getString("ecommerce_users_iscustomer") != null && rs.getString("ecommerce_users_iscustomer").equals("false")){
				user.setIsCustomer(false);
			}
			
			if(rs.getString("ecommerce_users_ismanaged") != null && rs.getString("ecommerce_users_ismanaged").equals("true")){
				user.setIsManagedByVendor(true);
			}
			if(rs.getString("ecommerce_users_ismanaged") != null && rs.getString("ecommerce_users_ismanaged").equals("false")){
				user.setIsManagedByVendor(false);
			}
			
			if(rs.getString("ecommerce_users_isvendor") != null && rs.getString("ecommerce_users_isvendor").equals("true")){
				user.setIsVendor(true);
			}
			if(rs.getString("ecommerce_users_isvendor") != null && rs.getString("ecommerce_users_isvendor").equals("false")){
				user.setIsVendor(false);
			}
			
//			ecommerce_users_password
			user.setPassword(rs.getString("ecommerce_users_password"));	
			
	//		(rs.getString("ecommerce_users_address1"));
			user.setUserAddress1(rs.getString("ecommerce_users_address1"));
			user.setUserAddress2(rs.getString("ecommerce_users_address2"));
			
			user.setUserEmail(rs.getString("ecommerce_users_email"));
			user.setUserMobile(rs.getString("ecommerce_users_mobile"));
			user.setUserName(rs.getString("ecommerce_users_name"));
			
			user.setUserRole(rs.getString("ecommerce_users_role"));
			user.setUserPinCode(rs.getString("ecommerce_users_pincode"));
			
			user.setUserCountryName(rs.getString("ecommerce_users_country"));
			user.setUserStateName(rs.getString("ecommerce_users_state"));
			user.setUserCityName(rs.getString("ecommerce_users_city"));
			
			user.setUserCountryId(rs.getString("ecommerce_users_country"));
			user.setUserStateId(rs.getString("ecommerce_users_state"));
			user.setUserCityId(rs.getString("ecommerce_users_city"));
			
			user.setAdminId(rs.getString("ecommerce_users_admin_id"));
			
		/*	if(rs.getString("ecommerce_users_admin_id") != null && rs.getString("ecommerce_users_admin_id").equals("")){
				user.setAdminId(rs.getString("ecommerce_users_admin_id"));
			}*/
			
	      return user;
	   }
}
