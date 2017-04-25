/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:ImageUtility.java
 *  Created by: srigin.ms
 *  Date: Aug 25, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: srigin.ms
 *  Date: Aug 25, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author srigin.ms
 *
 */
public class ImageUtility{



	public void writeFile(HttpServletRequest servletContext, String ID, byte[] bytes) throws IOException {


		 String webappRoot = servletContext.getServletContext().getRealPath("/");
		    String relativeFolder = File.separator + "resources" + File.separator
		                             + "img" + File.separator + "ProductIMG" +  File.separator;
		String filename = webappRoot + relativeFolder + ID;
		FileOutputStream fos = new FileOutputStream(filename);
		fos.write(bytes);
		fos.flush();
		fos.close();
	
	}



	
}
