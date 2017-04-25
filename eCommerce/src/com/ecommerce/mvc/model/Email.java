/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:Email.java
 *  Created by: Abdul.Azeez
 *  Date: Nov 2, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: Abdul.Azeez
 *  Date: Nov 2, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.mvc.model;

/**
 * @author Abdul.Azeez
 *
 */
public class Email {
private String userName;
private String userEmail;
private String subject;
private String message;
private String hostEmail;
/**
 * @return the userName
 */
public String getUserName() {
	return userName;
}
/**
 * @param userName the userName to set
 */
public void setUserName(String userName) {
	this.userName = userName;
}
/**
 * @return the userEmail
 */
public String getUserEmail() {
	return userEmail;
}
/**
 * @param userEmail the userEmail to set
 */
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
/**
 * @return the subject
 */
public String getSubject() {
	return subject;
}
/**
 * @param subject the subject to set
 */
public void setSubject(String subject) {
	this.subject = subject;
}
/**
 * @return the message
 */
public String getMessage() {
	return message;
}
/**
 * @param message the message to set
 */
public void setMessage(String message) {
	this.message = message;
}
/**
 * @return the hostEmail
 */
public String getHostEmail() {
	return hostEmail;
}
/**
 * @param hostEmail the hostEmail to set
 */
public void setHostEmail(String hostEmail) {
	this.hostEmail = hostEmail;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Email [userName=");
	builder.append(userName);
	builder.append(", userEmail=");
	builder.append(userEmail);
	builder.append(", subject=");
	builder.append(subject);
	builder.append(", message=");
	builder.append(message);
	builder.append(", hostEmail=");
	builder.append(hostEmail);
	builder.append("]");
	return builder.toString();
}



}
