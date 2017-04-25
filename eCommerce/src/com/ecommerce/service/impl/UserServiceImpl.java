/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:UserServiceImpl.java
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

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ecommerce.mvc.model.User;
import com.ecommerce.service.UserService;

/**
 * @author Abdul.Azeez
 *
 */
public class UserServiceImpl implements UserService {

	@Inject
	private SOAPWebServiceImp sOAPWebServiceImp;

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecommerce.service.UserService#getUserById(java.lang.String)
	 */
	@Override
	public User getUserById(String userId) {

		User user = sOAPWebServiceImp.getUserById(userId);

		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecommerce.service.UserService#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ecommerce.service.UserService#CreateUser(com.ecommerce.mvc.model.
	 * User)
	 */
	@Override
	public boolean CreateUser(User user, HttpServletRequest request) {
		user = sOAPWebServiceImp.createUser(user);

		// boolean isCreated=sOAPWebServiceImp.createUserLocal(user);

		// Integer cartId = getLatestCartId();
		System.out.println("To Local DB" + user);

		if (null != user) {
			if (null != user.getImage()) {
				String data = user.getImage();
				String base64Image = data.split(",")[1];
				byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);

				try {
					BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));

					File fileNew = new File(
							request.getSession().getServletContext().getRealPath("/resources/img/vendor/logo/"),
							user.getUserId() + ".jpg");

					// File file=new File("C:/idempiere-eCommerce/")

					System.out.println(
							"request.getSession().getServletContext() " + request.getSession().getServletContext());
					System.out.println("fileNew " + fileNew);
					System.out.println(System.getProperty("catalina.base"));

					// write the image to a file
					// File outputfile = new File("image.png");
					boolean imageSaved = ImageIO.write(img, "jpg", fileNew);

					/*
					 * if(imageSaved){ user.setImage(user.getUserId()+".jpg");
					 * 
					 * }
					 */

					System.out.println(imageSaved);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				String sql = "INSERT INTO ecommerce_users "
						+ "(ecommerce_users_id,ecommerce_users_name,ecommerce_users_password,ecommerce_users_mobile,ecommerce_users_email,"
						+ "ecommerce_users_address1,ecommerce_users_address2,ecommerce_users_pincode,ecommerce_users_role,ecommerce_users_country,ecommerce_users_state,"
						+ "ecommerce_users_city,ecommerce_users_isactive,ecommerce_users_isvendor,ecommerce_users_iscustomer,ecommerce_users_ismanaged,ecommerce_users_admin_id"
						+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				jdbcTemplate = new JdbcTemplate(dataSource);

				jdbcTemplate.update(sql,
						new Object[] { user.getUserId(), user.getUserName(), user.getPassword(), user.getUserMobile(),
								user.getUserEmail(), user.getUserAddress1(), user.getUserAddress2(),
								user.getUserPinCode(), user.getUserRole(), user.getUserCountry().getCountryId(),
								user.getUserState().getStateId(), user.getUserCity().getCityId(), user.getIsActive(), user.getIsVendor(),
								user.getIsCustomer(), user.getIsManagedByVendor(),user.getAdminId() });

				return true;
			} catch (Exception exception) {
				exception.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
		// return isCreated;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecommerce.service.UserService#setGuestUser()
	 */
	@Override
	public User setGuestUser() {
		User user = new User();
		user.setUserId("0");
		user.setUserName("Guest User");

		return user;
	}

}
