/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:Cart.java
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

package com.ecommerce.mvc.model;


/**
 * @author srigin.ms
 *
 */
public class WishList {
	private Number wishID;
	private String productId;
	private String userId;
	private Integer quantity;
	private Double price;
	private User user;
	private Product product;
	
	/**
	 * @return the wishID
	 */
	public Number getWishID() {
		return wishID;
	}
	/**
	 * @param wishID the wishID to set
	 */
	public void setWishID(Number wishID) {
		this.wishID = wishID;
	}
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
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
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WishList [wishID=");
		builder.append(wishID);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", price=");
		builder.append(price);
		builder.append(", user=");
		builder.append(user);
		builder.append(", product=");
		builder.append(product);
		builder.append("]");
		return builder.toString();
	}
	


}
