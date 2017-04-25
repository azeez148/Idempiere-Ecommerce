/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:MainController.java
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

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.mvc.model.Country;
import com.ecommerce.mvc.model.Product;
import com.ecommerce.mvc.model.ProductCategory;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.CommonService;
import com.ecommerce.service.ProductService;

/**
 * @author Abdul.Azeez
 *
 */
@RestController
@RequestMapping("/main")
public class MainController {

	// for logging
	final static Logger logger = Logger.getLogger(MainController.class);

	@Inject
	CategoryService categoryService;

	@Inject
	CommonService commonService;

	@Inject
	ProductService productService;

	@RequestMapping(value = "/categories")
	public ResponseEntity<List<ProductCategory>> getCategoriesList() {

		List<ProductCategory> items = categoryService.getProductCategory();
		if (items.isEmpty()) {
			return new ResponseEntity<List<ProductCategory>>(items, HttpStatus.OK);
		}
		return new ResponseEntity<List<ProductCategory>>(items, HttpStatus.OK);
	}

	@RequestMapping(value = "/hotSellingProducts")
	public ResponseEntity<List<Product>> getHotSellingProducts() {
		/* List<Product> items = sOAPWebServiceImp.getHotSellingProducts(); */
		List<Product> items = commonService.getHotSellingProducts();
		if (items.isEmpty()) {
			return new ResponseEntity<List<Product>>(items, HttpStatus.OK);
		}
		return new ResponseEntity<List<Product>>(items, HttpStatus.OK);
	}

	@RequestMapping(value = "/latestOffer/{id}")
	public ResponseEntity<Object> findAllLatestOffers(@PathVariable("id") String id) {

		Object item = null;
		return new ResponseEntity<Object>(item, HttpStatus.OK);
	}

	@RequestMapping(value = "/image")
	public ResponseEntity<List<Object>> writeImage(HttpServletRequest servletContext) {
		commonService.writeAllImages(servletContext);
		return new ResponseEntity<List<Object>>(HttpStatus.OK);
	}
	@RequestMapping(value = "/countryList")
	public ResponseEntity<List<Country>> getAllCountryDetails() {

		
		List<Country> countries=commonService.getAllCountryDetails();
		for(Country country:countries){
		System.out.println("country is  "+country);
		}
		return new ResponseEntity<List<Country>>(countries,HttpStatus.OK);
	}
}
