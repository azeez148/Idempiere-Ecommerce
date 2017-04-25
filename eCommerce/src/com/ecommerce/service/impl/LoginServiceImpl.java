/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:LoginServiceImpl.java
 *  Created by: Abdul.Azeez
 *  Date: Jul 25, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: Abdul.Azeez
 *  Date: Jul 25, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.service.impl;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ecommerce.mapper.UserMapper;
import com.ecommerce.mvc.model.User;
import com.ecommerce.service.LoginService;
import com.ecommerce.service.SOAPWebService;

/**
 * @author Abdul.Azeez
 *
 */
public class LoginServiceImpl implements LoginService {
	// for logging

	final static Logger logger = Logger.getLogger(LoginServiceImpl.class);

	@Inject
	private SOAPWebService sOAPWebServiceImp;

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ecommerce.service.LoginService#loginUser(com.ecommerce.mvc.model.
	 * User)
	 */
	@Override
	public User loginUser(User user) {

		User user2 = sOAPWebServiceImp.getUser(user);
		String role = "";
		if (null != user2) {
			try {
				//String query = "select ecommerce_users_role from ecommerce_users where ecommerce_users_id=?";
				
				
				String query = "select ecommerce_users_id,ecommerce_users_name,ecommerce_users_password,ecommerce_users_mobile,ecommerce_users_email,"
				+ "ecommerce_users_address1,ecommerce_users_address2,ecommerce_users_pincode,ecommerce_users_role,ecommerce_users_country,ecommerce_users_state,"
				+ "ecommerce_users_city,ecommerce_users_isactive,ecommerce_users_isvendor,ecommerce_users_iscustomer,ecommerce_users_ismanaged,ecommerce_users_admin_id,ecommerce_users_password"
				+ " from ecommerce_users where ecommerce_users_id=?";
				
				
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

				//role = jdbcTemplate.queryForObject(query, new Object[] { user2.getUserId() }, String.class);
				
				  user2 = jdbcTemplate.queryForObject(query, 
	                        new Object[]{user2.getUserId()}, new UserMapper());
				
			} catch (Exception exception) {
				exception.printStackTrace();
				System.out.println(exception);
			}

			//user2.setUserRole(role);
		}
		return user2;
	}
}
