/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:User.java
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

package com.ecommerce.mvc.model;

/**
 * @author Abdul.Azeez
 *
 */
public class User {
	private String userId;
	private String userName;
	private String password;
	private String userMobile;
	private String userEmail;
	private String userAddress1;
	private String userAddress2;
	private String userPinCode;
	private Country userCountry;
	private State userState;
	private City userCity;
	private String userRole;
	private String userLocationId;
	private String userPartnerId;
	private String isActive;
	private String userPartnerName;
	private String userStateName;
	private String userCityName;
	private String userCountryName;
	private Boolean isVendor;
	private Boolean isManagedByVendor;
	private Boolean isCustomer;
	private String adminId;
	private String image;
	private String userCountryId;
	private String userStateId;
	private String userCityId;
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the userMobile
	 */
	public String getUserMobile() {
		return userMobile;
	}
	/**
	 * @param userMobile the userMobile to set
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
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
	 * @return the userAddress1
	 */
	public String getUserAddress1() {
		return userAddress1;
	}
	/**
	 * @param userAddress1 the userAddress1 to set
	 */
	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;
	}
	/**
	 * @return the userAddress2
	 */
	public String getUserAddress2() {
		return userAddress2;
	}
	/**
	 * @param userAddress2 the userAddress2 to set
	 */
	public void setUserAddress2(String userAddress2) {
		this.userAddress2 = userAddress2;
	}
	/**
	 * @return the userPinCode
	 */
	public String getUserPinCode() {
		return userPinCode;
	}
	/**
	 * @param userPinCode the userPinCode to set
	 */
	public void setUserPinCode(String userPinCode) {
		this.userPinCode = userPinCode;
	}
	/**
	 * @return the userCountry
	 */
	public Country getUserCountry() {
		return userCountry;
	}
	/**
	 * @param userCountry the userCountry to set
	 */
	public void setUserCountry(Country userCountry) {
		this.userCountry = userCountry;
	}
	/**
	 * @return the userState
	 */
	public State getUserState() {
		return userState;
	}
	/**
	 * @param userState the userState to set
	 */
	public void setUserState(State userState) {
		this.userState = userState;
	}
	/**
	 * @return the userCity
	 */
	public City getUserCity() {
		return userCity;
	}
	/**
	 * @param userCity the userCity to set
	 */
	public void setUserCity(City userCity) {
		this.userCity = userCity;
	}
	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}
	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	/**
	 * @return the userLocationId
	 */
	public String getUserLocationId() {
		return userLocationId;
	}
	/**
	 * @param userLocationId the userLocationId to set
	 */
	public void setUserLocationId(String userLocationId) {
		this.userLocationId = userLocationId;
	}
	/**
	 * @return the userPartnerId
	 */
	public String getUserPartnerId() {
		return userPartnerId;
	}
	/**
	 * @param userPartnerId the userPartnerId to set
	 */
	public void setUserPartnerId(String userPartnerId) {
		this.userPartnerId = userPartnerId;
	}
	/**
	 * @return the isActive
	 */
	public String getIsActive() {
		return isActive;
	}
	/**
	 * @return the userPartnerName
	 */
	public String getUserPartnerName() {
		return userPartnerName;
	}
	/**
	 * @param userPartnerName the userPartnerName to set
	 */
	public void setUserPartnerName(String userPartnerName) {
		this.userPartnerName = userPartnerName;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	/**
	 * @return the userStateName
	 */
	public String getUserStateName() {
		return userStateName;
	}
	/**
	 * @param userStateName the userStateName to set
	 */
	public void setUserStateName(String userStateName) {
		this.userStateName = userStateName;
	}
	/**
	 * @return the userCityName
	 */
	public String getUserCityName() {
		return userCityName;
	}
	/**
	 * @param userCityName the userCityName to set
	 */
	public void setUserCityName(String userCityName) {
		this.userCityName = userCityName;
	}
	/**
	 * @return the userCountryName
	 */
	public String getUserCountryName() {
		return userCountryName;
	}
	/**
	 * @param userCountryName the userCountryName to set
	 */
	public void setUserCountryName(String userCountryName) {
		this.userCountryName = userCountryName;
	}
	/**
	 * @return the isVendor
	 */
	public Boolean getIsVendor() {
		return isVendor;
	}
	/**
	 * @param isVendor the isVendor to set
	 */
	public void setIsVendor(Boolean isVendor) {
		this.isVendor = isVendor;
	}
	/**
	 * @return the isManagedByVendor
	 */
	public Boolean getIsManagedByVendor() {
		return isManagedByVendor;
	}
	/**
	 * @param isManagedByVendor the isManagedByVendor to set
	 */
	public void setIsManagedByVendor(Boolean isManagedByVendor) {
		this.isManagedByVendor = isManagedByVendor;
	}
	/**
	 * @return the isCustomer
	 */
	public Boolean getIsCustomer() {
		return isCustomer;
	}
	/**
	 * @param isCustomer the isCustomer to set
	 */
	public void setIsCustomer(Boolean isCustomer) {
		this.isCustomer = isCustomer;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the adminId
	 */
	public String getAdminId() {
		return adminId;
	}
	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	/**
	 * @return the userCountryId
	 */
	public String getUserCountryId() {
		return userCountryId;
	}
	/**
	 * @param userCountryId the userCountryId to set
	 */
	public void setUserCountryId(String userCountryId) {
		this.userCountryId = userCountryId;
	}
	/**
	 * @return the userStateId
	 */
	public String getUserStateId() {
		return userStateId;
	}
	/**
	 * @param userStateId the userStateId to set
	 */
	public void setUserStateId(String userStateId) {
		this.userStateId = userStateId;
	}
	/**
	 * @return the userCityId
	 */
	public String getUserCityId() {
		return userCityId;
	}
	/**
	 * @param userCityId the userCityId to set
	 */
	public void setUserCityId(String userCityId) {
		this.userCityId = userCityId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", userMobile=");
		builder.append(userMobile);
		builder.append(", userEmail=");
		builder.append(userEmail);
		builder.append(", userAddress1=");
		builder.append(userAddress1);
		builder.append(", userAddress2=");
		builder.append(userAddress2);
		builder.append(", userPinCode=");
		builder.append(userPinCode);
		builder.append(", userCountry=");
		builder.append(userCountry);
		builder.append(", userState=");
		builder.append(userState);
		builder.append(", userCity=");
		builder.append(userCity);
		builder.append(", userRole=");
		builder.append(userRole);
		builder.append(", userLocationId=");
		builder.append(userLocationId);
		builder.append(", userPartnerId=");
		builder.append(userPartnerId);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", userPartnerName=");
		builder.append(userPartnerName);
		builder.append(", userStateName=");
		builder.append(userStateName);
		builder.append(", userCityName=");
		builder.append(userCityName);
		builder.append(", userCountryName=");
		builder.append(userCountryName);
		builder.append(", isVendor=");
		builder.append(isVendor);
		builder.append(", isManagedByVendor=");
		builder.append(isManagedByVendor);
		builder.append(", isCustomer=");
		builder.append(isCustomer);
		builder.append(", adminId=");
		builder.append(adminId);
		builder.append(", image=");
		builder.append(image);
		builder.append(", userCountryId=");
		builder.append(userCountryId);
		builder.append(", userStateId=");
		builder.append(userStateId);
		builder.append(", userCityId=");
		builder.append(userCityId);
		builder.append("]");
		return builder.toString();
	}

	
}
