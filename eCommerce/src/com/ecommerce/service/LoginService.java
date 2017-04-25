/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:LoginService.java
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

package com.ecommerce.service;

import com.ecommerce.mvc.model.User;

/**
 * @author Abdul.Azeez
 *
 */
public interface LoginService {

	/**
	 * @return 
	 * Gets ....
	 * @param 
	 * @param 
	 * @return User obj
	 * @throws 
	 */
	
	public User loginUser(User user);

}
