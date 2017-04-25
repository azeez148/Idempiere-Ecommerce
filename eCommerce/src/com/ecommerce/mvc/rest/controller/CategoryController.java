/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:CategoryController.java
 *  Created by: Abdul.Azeez
 *  Date: Sep 6, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: Abdul.Azeez
 *  Date: Sep 6, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.mvc.rest.controller;

import java.util.Set;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.mvc.model.Product;
import com.ecommerce.mvc.model.ProductCategory;
import com.ecommerce.service.CategoryService;

/**
 * @author Abdul.Azeez
 *
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
	// for logging
	final static Logger logger = Logger.getLogger(CategoryController.class);
	
	@Inject
	CategoryService categoryService;

	
	@RequestMapping(value = "/cat/{categoryId}")
	public ResponseEntity<Set<Product>> findAllProductsByCatagory(@PathVariable("categoryId") String categoryId) {
		
		Set<Product> items = categoryService.getProducts(null, categoryId);
		if(items == null){
		return new ResponseEntity<Set<Product>>(items,HttpStatus.OK);
		}
		return new ResponseEntity<Set<Product>>(items, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/search/{name}")
	public ResponseEntity<Set<Product>> findsearchResults(@PathVariable("name") String name) {
		
		Set<Product> items = categoryService.getProducts(name, null);
        if(items.isEmpty()){
            return new ResponseEntity<Set<Product>>(items, HttpStatus.OK);
        }
        return new ResponseEntity<Set<Product>>(items, HttpStatus.OK);
	}
	@RequestMapping(value = "/category/{categoryId}")
	public ResponseEntity<ProductCategory> getCategoryById(@PathVariable("categoryId") String categoryId) {
		
		System.out.println("categoryId"+categoryId);
		ProductCategory category=categoryService.getCategoryById(categoryId);
        return new ResponseEntity<ProductCategory>( category,HttpStatus.OK);
	}
}
