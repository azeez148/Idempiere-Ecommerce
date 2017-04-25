/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:UserController.java
 *  Created by: Abdul.Azeez
 *  Date: Oct 6, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: Abdul.Azeez
 *  Date: Oct 6, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.mvc.rest.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.mvc.model.User;
import com.ecommerce.service.UserService;
import com.ecommerce.util.CommonUtil;

/**
 * @author Abdul.Azeez
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	// for logging
	final static Logger logger = Logger.getLogger(ProductController.class);

	@Inject
	UserService userService;

	@RequestMapping(value = "/createUser", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<User> createUser(@RequestBody User user,HttpServletRequest request) {
		System.out.println("Creating User " + user.getUserName());

		boolean isAdded = false;
		if (null != user) {
			user.setIsVendor(false);
			user.setIsCustomer(true);
			user.setIsActive("Y");
			user.setUserRole(CommonUtil.User_Role_User);
			user.setUserCountryName(user.getUserCountry().getCountryName());
			user.setUserStateName(user.getUserState().getStateName());
			user.setUserCityName(user.getUserCity().getCityName());
			isAdded = userService.CreateUser(user,request);
		}

		if (!isAdded) {
			logger.error("error while creating user");
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		logger.info("successfully added user" + user);
		return new ResponseEntity<User>(HttpStatus.OK);

	}

	@RequestMapping(value = "/createVendor", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<User> createVendor(@RequestBody User user,HttpServletRequest request) {
		System.out.println("Creating Vendor " + user.getUserName());
		System.out.println("Creating Vendor IsManagedByVendor " + user.getIsManagedByVendor());
	
		System.out.println("Creating Vendor image " + user.getImage());
		
		
		boolean isAdded = false;
		if (null != user) {
			user.setIsVendor(true);
			user.setIsCustomer(false);
			user.setIsActive("Y");
			
			
			if(user.getIsManagedByVendor() == true){
				user.setUserRole(CommonUtil.User_Role_Admin);
			}else if(user.getIsManagedByVendor() == false){
				user.setUserRole(CommonUtil.User_Role_Vendor);

			}
			
			user.setUserCountryName(user.getUserCountry().getCountryName());
			user.setUserStateName(user.getUserState().getStateName());
			user.setUserCityName(user.getUserCity().getCityName());
			
			isAdded = userService.CreateUser(user,request);
		}

		if (!isAdded) {
			logger.error("error while creating user");
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		logger.info("successfully added user" + user);
		return new ResponseEntity<User>(HttpStatus.OK);

	}
}
