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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ecommerce.mapper.AdminScreenMapper;
import com.ecommerce.mapper.UserMapper;
import com.ecommerce.mvc.model.AdminScreenCategory;
import com.ecommerce.mvc.model.Email;
import com.ecommerce.mvc.model.User;
import com.ecommerce.service.AdminService;
import com.ecommerce.service.SOAPWebService;

/**
 * @author Abdul.Azeez
 *
 */
public class AdminServiceImpl implements AdminService {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	@Inject
	private SOAPWebService sOAPWebServiceImp;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.AdminService#getAllCategories()
	 */
	@Override
	public List<AdminScreenCategory> getAllCategories() {
		
		Map<AdminScreenCategory, String> parentChildMap = new HashMap<>();
		String query = "select admin_category_id,category_name,category_parent_id from admin_category order by admin_category_id ";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<AdminScreenCategory> adminScreens = new ArrayList<AdminScreenCategory>();

		adminScreens = jdbcTemplate.query(query, new Object[] {}, new AdminScreenMapper());
		
		for(AdminScreenCategory screenCategory:adminScreens){
			/*if(null != screenCategory.getParentID()){
				//addChildren(adminScreens,screenCategory);
				
				
			}*/
			parentChildMap.put(screenCategory, screenCategory.getParentID());
		}
		
		List<AdminScreenCategory> screenCategories = null;
		screenCategories=processCategoryHierarchy(parentChildMap);

		
		return screenCategories;
		
	}

	/**
	 * @param parentChildMap
	 *            Gets .... @param @param @return List<ProductCategory> @throws
	 */

	private List<AdminScreenCategory> processCategoryHierarchy(Map<AdminScreenCategory, String> parentChildMap) {
		List<AdminScreenCategory> result = new ArrayList<>();
		for (Map.Entry<AdminScreenCategory, String> entry : parentChildMap.entrySet()) {

			AdminScreenCategory category = entry.getKey();
			category.setChildren(getChildren(parentChildMap, category.getCategoryID()));

			if (null == entry.getValue() || entry.getValue().length() == 0) {
				result.add(category);
			}
		}
		return result;
	}
	
	/**
	 * @param string
	 *            Gets .... @param @param @return List<ProductCategory> @throws
	 */

	private List<AdminScreenCategory> getChildren(Map<AdminScreenCategory, String> parentChildMap, String parentID) {
		// TODO Auto-generated method stub
		List<AdminScreenCategory> children = new ArrayList<>();
		for (Map.Entry<AdminScreenCategory, String> entry : parentChildMap.entrySet()) {
			if (entry.getValue() == null)
				continue;
			else if (entry.getValue().equals(parentID)) {
				children.add(entry.getKey());
			}

		}

		return children;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.AdminService#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		//sOAPWebServiceImp
		//List<User> users = sOAPWebServiceImp.getAllUsers(type);
		

		
		String query = "select ecommerce_users_id,ecommerce_users_name,ecommerce_users_password,ecommerce_users_mobile,ecommerce_users_email,"
				+ "ecommerce_users_address1,ecommerce_users_address2,ecommerce_users_pincode,ecommerce_users_role,ecommerce_users_country,ecommerce_users_state,"
				+ "ecommerce_users_city,ecommerce_users_isactive,ecommerce_users_isvendor,ecommerce_users_iscustomer,ecommerce_users_ismanaged,ecommerce_users_admin_id "
				+ " from ecommerce_users where ecommerce_users_iscustomer = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<User> users = new ArrayList<User>();

		users = jdbcTemplate.query(query, new Object[] { "true" }, new UserMapper());

		
		
		
		
		
		
		
		
		
		return users;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.AdminService#getAllVendors()
	 */
	@Override
	public List<User> getAllVendors(String adminId) {
	//	List<User> users=null;
		
	
		
		String query = "select ecommerce_users_id,ecommerce_users_name,ecommerce_users_password,ecommerce_users_mobile,ecommerce_users_email,"
				+ "ecommerce_users_address1,ecommerce_users_address2,ecommerce_users_pincode,ecommerce_users_role,ecommerce_users_country,ecommerce_users_state,"
				+ "ecommerce_users_city,ecommerce_users_isactive,ecommerce_users_isvendor,ecommerce_users_iscustomer,ecommerce_users_ismanaged,ecommerce_users_admin_id"
				+ " from ecommerce_users where ecommerce_users_isvendor=? AND ecommerce_users_admin_id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<User> users = new ArrayList<User>();

		users = jdbcTemplate.query(query, new Object[] { "true",adminId }, new UserMapper());

		
		
		
		
		
		
		
		
		
		return users;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.AdminService#updateVendor(com.ecommerce.mvc.model.User)
	 */
	@Override
	public boolean updateVendor(User user) {
		String sql1 ="UPDATE ecommerce_users set ecommerce_users_name = ? ,ecommerce_users_mobile = ?,ecommerce_users_email = ?,ecommerce_users_address1 = ?,"
				+ "ecommerce_users_address2 = ?,ecommerce_users_pincode = ? ";
		
		StringBuilder sql = new StringBuilder(sql1);
				
				if(null == user.getAdminId() || "".equals(user.getAdminId())){
					String sql2 = ",ecommerce_users_ismanaged = ?,ecommerce_users_admin_id = ?"
					+ " WHERE ecommerce_users_id = ?";
					sql.append(sql2);
				}
				
				else if(null != user.getAdminId() || !("".equals(user.getAdminId()))){
					String sql3 = ",ecommerce_users_ismanaged = ?,ecommerce_users_admin_id = ?"
					+ " WHERE ecommerce_users_id = ?";
					sql.append(sql3);
				}
		
				
				
		
		/*if(null == user.getAdminId() || "".equals(user.getAdminId())){
			String sql1 = ",ecommerce_users_ismanaged,ecommerce_users_admin_id)";
			+ " WHERE cart_id = ?");
		}*/
		
		try {
			System.out.println(sql);

			jdbcTemplate = new JdbcTemplate(dataSource);

			jdbcTemplate.update(sql.toString(), new Object[] { user.getUserName(),user.getUserMobile(),user.getUserEmail(),user.getUserAddress1(),user.getUserAddress2()
					,user.getUserPinCode(),user.getIsManagedByVendor(),user.getAdminId(),user.getUserId()});
			return true;

		} catch (Exception exception) {
			exception.printStackTrace();

		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.AdminService#sendMail(com.ecommerce.mvc.model.Email)
	 */
	@Override
	public boolean sendMail(Email email) {
	
		Properties props = new Properties();
		props.put("mail.smtp.host", "casnestit.nestgroup.net");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		 /*props.put("mail.smtp.socketFactory.fallback", "true"); // Should be true
		 props.put("mail.transport.protocol", "smtp");
		 props.put("mail.smtp.starttls.enable", "true");*/

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("abdul.azeez@nestgroup.net","password2@");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("abdul.azeez@nestgroup.net"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email.getUserEmail()));
			message.setSubject(email.getSubject());
			message.setText("Dear "+email.getUserName() +","+
					"\n\n"+email.getMessage());

			Transport.send(message);

			System.out.println("Done");
			return true;

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
	
		return false;
	}

	
		
		
	


	
	


/**
 * Gets ....
 * @param 
 * @param 
 * @return Object
 * @throws 
 */

public Session getSession() {
	 System.out.println("SimpleEmail Start");
		
	    String smtpHostServer = "casnestit.nestgroup.net";
	    String emailID = "abdul.azeez@nestgroup.net";
	    
	    Properties props = System.getProperties();

	    props.put("mail.smtp.host", smtpHostServer);

	    Session session = Session.getInstance(props, null);
	    return session;
}

/* (non-Javadoc)
 * @see com.ecommerce.service.AdminService#updateVendorStatus(com.ecommerce.mvc.model.User)
 */
@Override
public boolean updateVendorStatus(User user) {
	String sql ="UPDATE ecommerce_users set ecommerce_users_isactive=?  WHERE ecommerce_users_id = ?";
	
	
	try {
		System.out.println(sql);

		jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(sql.toString(), new Object[] { user.getIsActive(),user.getUserId()});
		return true;

	} catch (Exception exception) {
		exception.printStackTrace();

	}
	
	return false;
}
}
	
