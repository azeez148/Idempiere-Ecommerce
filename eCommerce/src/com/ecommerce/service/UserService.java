/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:UserService.java
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

package com.ecommerce.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ecommerce.mvc.model.User;

/**
 * @author Abdul.Azeez
 *
 */
public interface UserService {
	
public User getUserById(String userId);
public List<User> getAllUsers();
/**
 * @param request 
 * Gets ....
 * @param 
 * @param 
 * @return boolean
 * @throws 
 */

public boolean CreateUser(User user, HttpServletRequest request);
/**
 * Gets ....
 * @param 
 * @param 
 * @return User
 * @throws 
 */

public User setGuestUser();

}
