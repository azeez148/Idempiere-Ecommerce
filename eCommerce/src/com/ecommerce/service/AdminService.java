/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:CartService.java
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

import com.ecommerce.mvc.model.AdminScreenCategory;
import com.ecommerce.mvc.model.Email;
import com.ecommerce.mvc.model.User;

/**
 * @author Abdul.Azeez
 *
 */
public interface AdminService {

	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return List<AdminScreenCategory>
	 * @throws 
	 */
	
	List<AdminScreenCategory> getAllCategories();

	/**
	 * @param type 
	 * Gets ....
	 * @param 
	 * @param 
	 * @return List<User>
	 * @throws 
	 *//*
	
	List<User> getAllUsers(String type);
*/
	/**
	 * @param type 
	 * Gets ....
	 * @param 
	 * @param 
	 * @return List<User>
	 * @throws 
	 */
	
	List<User> getAllUsers();

	/**
	 * @param adminId 
	 * Gets ....
	 * @param 
	 * @param 
	 * @return List<User>
	 * @throws 
	 */
	
	List<User> getAllVendors(String adminId);

	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return boolean
	 * @throws 
	 */
	
	boolean updateVendor(User user);

	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return boolean
	 * @throws 
	 */
	
	boolean sendMail(Email email);

	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return boolean
	 * @throws 
	 */
	
	
	boolean updateVendorStatus(User user);
	
	
}
