package com.ecommerce.service;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.idempiere.webservice.client.base.LoginRequest;
import org.idempiere.webservice.client.net.WebServiceConnection;

import com.ecommerce.mvc.model.Attribute;
import com.ecommerce.mvc.model.Country;
import com.ecommerce.mvc.model.PriceList;
import com.ecommerce.mvc.model.Product;
import com.ecommerce.mvc.model.ProductCategory;
import com.ecommerce.mvc.model.User;

/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:WebService.java
 *  Created by: srigin.ms
 *  Date: Aug 17, 2016
 *  
/**
 * @author srigin.ms
 *
 */
public interface SOAPWebService {

	/** Get connection to the web Service					*/
	public WebServiceConnection getConnection();
	
	/**	Get Login details				*/
	public LoginRequest getLogin();
			
	/**		Get Products Category	*/
	public List<ProductCategory> getProductCategory();
	
	/**		Get Hot Selling Products	*/
	
	public List<Product> getHotSellingProducts();
	
	
	/** Write All Images		*/
	
	void writeAllImages(HttpServletRequest servletContext);


	/**		Get products by ID	*/
	public Product getProductByID(String ID);
	
	/**		Get All Products by Category	*/

	
	public Set<Product> getProducts(String name, String category);


	/**		Get All Products by Category	*/
	
	public Set<Attribute> getProductAttrbutes();

	/** Get the User Info	 */
	
	public User getUser(User user);
	
/** Get the Country Info	 */
	
	public List<Country> getCountries();

/**
 * Gets ....
 * @param 
 * @param 
 * @return ProductCategory
 * @throws 
 */

public ProductCategory getCategoryById(String categoryId);

/**
 * Gets ....
 * @param 
 * @param 
 * @return List<User>
 * @throws 
 */

public List<User> getAllUsers(String type);

/**
 * Gets ....
 * @param 
 * @param 
 * @return List<ProductCategory>
 * @throws 
 */

public List<ProductCategory> getAllProductCategories();

/**
 * Gets ....
 * @param 
 * @param 
 * @return boolean
 * @throws 
 */

public String createProductCategory(ProductCategory category);

/**
 * Gets ....
 * @param 
 * @param 
 * @return boolean
 * @throws 
 */

public boolean updateProductCategory(ProductCategory category);

/**
 * Gets ....
 * @param 
 * @param 
 * @return boolean
 * @throws 
 */

public boolean updateCategoryStatus(ProductCategory category);

/**
 * Gets ....
 * @param 
 * @param 
 * @return List<PriceList>
 * @throws 
 */

public List<PriceList> getAllPriceLists();

/**
 * Gets ....
 * @param 
 * @param 
 * @return Product
 * @throws 
 */

public Set<Product> getAllProducts();

}
