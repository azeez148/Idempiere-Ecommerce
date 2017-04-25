/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:AdminController.java
 *  Created by: Abdul.Azeez
 *  Date: Oct 21, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: Abdul.Azeez
 *  Date: Oct 21, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.mvc.rest.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.mvc.model.AdminScreenCategory;
import com.ecommerce.mvc.model.Email;
import com.ecommerce.mvc.model.User;
import com.ecommerce.service.AdminService;

/**
 * @author Abdul.Azeez
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
	///
	// for logging
	final static Logger logger = Logger.getLogger(AdminController.class);

	@Inject
	AdminService adminService;

	@RequestMapping(value = "/categories")
	public ResponseEntity<List<AdminScreenCategory>> getCategoriesList() {

		List<AdminScreenCategory> screens = null;

		screens = adminService.getAllCategories();

		System.out.println("adminnnnn " + screens);

		return new ResponseEntity<List<AdminScreenCategory>>(screens, HttpStatus.OK);
	}

	@RequestMapping(value = "/category/users")
	public ResponseEntity<List<User>> getAllUsers() {

		System.out.println("getAllUsers");

		List<User> userList = null;
		userList = adminService.getAllUsers();

		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

/*	@RequestMapping(value = "/user/{userId}/{status}")
	public ResponseEntity<List<User>> updateUserStatus(@PathVariable("userId") String userId,
			@PathVariable("status") String status) {

		System.out.println("updateUserStatus userId " + userId + " status " + status);

		return new ResponseEntity<List<User>>(HttpStatus.OK);
	}*/

	@RequestMapping(value = "/category/vendors/{adminId}")
	public ResponseEntity<List<User>> getAllVendors(@PathVariable("adminId") String adminId) {

		System.out.println("getAllVendors" + adminId);

		List<User> userList = null;

		// userList=adminService.getAllUsers("vendor");
		userList = adminService.getAllVendors(adminId);
		System.out.println("userlist is.. " + userList);

		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@RequestMapping(value = "/vendor/update", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<List<User>> updateVendor(@RequestBody User user) {

		System.out.println("updateVendor" + user);

		List<User> userList = null;

		// userList=adminService.getAllUsers("vendor");
		String superAdminId = user.getAdminId();
		boolean isUpdated = false;

		if (user.getIsManagedByVendor() == true) {
			user.setAdminId("");
		}

		isUpdated = adminService.updateVendor(user);
		System.out.println("IsUpdatedddd .. " + isUpdated);

		userList = adminService.getAllVendors(superAdminId);

		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/update/status", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<List<User>> updateUserStatus(@RequestBody User user) {

		System.out.println("updateUserStatus" + user);

		List<User> userList = null;

		// userList=adminService.getAllUsers("vendor");
	//	String superAdminId = user.getAdminId();
		boolean isUpdated = false;

		System.out.println("user.getIsActive() .. " + user.getIsActive());

		if (user.getIsActive().equals("Y")) {
			user.setIsActive("N");
		} else if (user.getIsActive().equals("N")) {
			user.setIsActive("Y");
		}

		isUpdated = adminService.updateVendorStatus(user);
		System.out.println("IsUpdatedddd .. " + isUpdated);

		userList = adminService.getAllUsers();

		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@RequestMapping(value = "/vendor/update/status", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<List<User>> updateVendorStatus(@RequestBody User user) {

		System.out.println("updateVendor" + user);

		List<User> userList = null;

		// userList=adminService.getAllUsers("vendor");
		String superAdminId = user.getAdminId();
		boolean isUpdated = false;

		System.out.println("user.getIsActive() .. " + user.getIsActive());

		if (user.getIsActive().equals("Y")) {
			user.setIsActive("N");
		} else if (user.getIsActive().equals("N")) {
			user.setIsActive("Y");
		}

		isUpdated = adminService.updateVendorStatus(user);
		System.out.println("IsUpdatedddd .. " + isUpdated);

		userList = adminService.getAllVendors(superAdminId);

		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@RequestMapping(value = "/vendor/email", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<List<User>> sendMail(@RequestBody Email email) {

		System.out.println("updateVendor" + email);

		boolean isSend = false;
		isSend = adminService.sendMail(email);

		if (isSend) {
			return new ResponseEntity<List<User>>(HttpStatus.OK);

		} else {
			return new ResponseEntity<List<User>>(HttpStatus.BAD_REQUEST);

		}

	}
}
