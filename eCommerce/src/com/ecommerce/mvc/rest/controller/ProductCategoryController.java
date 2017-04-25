/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:AdminProductCategory.java
 *  Created by: Abdul.Azeez
 *  Date: Nov 3, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: Abdul.Azeez
 *  Date: Nov 3, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.mvc.rest.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.mvc.model.ProductCategory;
import com.ecommerce.service.AdminProductCategoryService;

/**
 * @author Abdul.Azeez
 *
 */
@RestController
@RequestMapping("/admin/category")
public class ProductCategoryController {
	// for logging
	final static Logger logger = Logger.getLogger(ProductCategoryController.class);

	@Inject
	AdminProductCategoryService productCategoryService;

	@RequestMapping(value = "/allcategories")
	public ResponseEntity<List<ProductCategory>> getAllCategories() {

		System.out.println("getAllUsers");

		List<ProductCategory> productCategories = null;
		productCategories = productCategoryService.getAllCategories();

		for (ProductCategory category : productCategories) {
			if (category.getParentID() != null) {
				setParentName(category, productCategories);
			}
		}

		return new ResponseEntity<List<ProductCategory>>(productCategories, HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<List<ProductCategory>> createCategory(@RequestBody ProductCategory category) {

		System.out.println("ProductCategory" + category);

		
		
		
		
		boolean isAdded = productCategoryService.createCategory(category);

		List<ProductCategory> productCategories = null;
		productCategories = productCategoryService.getAllCategories();

		for (ProductCategory productCategory : productCategories) {
			if (productCategory.getParentID() != null) {
				setParentName(productCategory, productCategories);
			}
		}

		return new ResponseEntity<List<ProductCategory>>(productCategories, HttpStatus.OK);

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<List<ProductCategory>> updateCategory(@RequestBody ProductCategory category) {

		System.out.println("in updateCategory ProductCategory .. " + category);

		boolean isUpdated = productCategoryService.updateCategory(category);

		List<ProductCategory> productCategories = null;
		productCategories = productCategoryService.getAllCategories();

		for (ProductCategory productCategory : productCategories) {
			if (productCategory.getParentID() != null) {
				setParentName(productCategory, productCategories);
			}
		}

		return new ResponseEntity<List<ProductCategory>>(productCategories, HttpStatus.OK);

	}

	@RequestMapping(value = "/update/status", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<List<ProductCategory>> updateCategoryStatus(@RequestBody ProductCategory category) {

		System.out.println("in updateCategoryStatus ProductCategory .. " + category);
		
		
		if(category.getIsActive().equals("Y")){
			category.setIsActive("N");
		}else if(category.getIsActive().equals("N")){
			category.setIsActive("Y");
		}
		System.out.println(" ProductCategory before.. " + category);
		boolean isUpdated = productCategoryService.updateCategoryStatus(category);

		List<ProductCategory> productCategories = null;
		productCategories = productCategoryService.getAllCategories();

		for (ProductCategory productCategory : productCategories) {
			if (productCategory.getParentID() != null) {
				setParentName(productCategory, productCategories);
			}
		}

		return new ResponseEntity<List<ProductCategory>>(productCategories, HttpStatus.OK);

	}

	/**
	 * Gets .... @param @param @return void @throws
	 */

	private void setParentName(ProductCategory category, List<ProductCategory> productCategories) {
		for (ProductCategory category2 : productCategories) {
			if (category.getParentID().equals(category2.getCategoryID())) {
				category.setParentName(category2.getName());
			}

		}
	}
}
