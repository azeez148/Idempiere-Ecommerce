/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:LoginController.java
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

package com.ecommerce.mvc.rest.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.mvc.model.User;
import com.ecommerce.service.CartService;
import com.ecommerce.service.LoginService;

/**
 * @author Abdul.Azeez
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	// for logging
	final static Logger logger = Logger.getLogger(LoginController.class);
	User user = null;

	@Inject
	@Named(value = "loginService")
	LoginService loginService;
	@Inject
	CartService cartService;
	
	/**
	 * @param user
	 *            object
	 * @return user object if true else null.
	 */
	@RequestMapping(value = "/{userName}", method = RequestMethod.POST)
	public User loginUser(@PathVariable String userName) {
		logger.info("In controller");
		System.out.println("In controller");
		System.out.println("userName:: " + userName);
		user = new User();
		user.setUserName(userName);
		
		
		
		
		
		
		user = loginService.loginUser(user);
		
		//temp for test admin page should be removed.....
				//user.setUserRole("Admin");
		
		
		System.out.println("after Logging in :: " + user);
		logger.info("after Logging in :: " + user);
/*		
		user.setSource("index");
		user.setDestination("adminHome");*/
		
		if(!(null == user.getUserId()) || !("".equals(user.getUserId()))){
			cartService.deleteAllGuestItems();
		}
		
		return user;

	}
	@RequestMapping(value="/index")
    public String getComputersTemplate() {
		System.out.println("in controll");
        return "pages/tShirtsHome";   
    }
}
