/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:CartController.java
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.mvc.model.Attribute;
import com.ecommerce.mvc.model.Product;
import com.ecommerce.service.ProductService;

/**
 * @author Abdul.Azeez
 *
 */
@RestController
@RequestMapping("/admin/products")
public class AdminProductController {

	// for logging
	final static Logger logger = Logger.getLogger(AdminProductController.class);

	@Inject
	ProductService productService;

	@RequestMapping(value = "/allProducts")
	public ResponseEntity<Set<Product>> getAllProducts() {

		Set<Product> products = productService.getAllProducts();

		return new ResponseEntity<Set<Product>>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/attributes")
	public ResponseEntity<Set<Attribute>> getAttributesList() {

		Set<Attribute> attributes = productService.getProductAttrbutes();
		// System.out.println("size "+attributes);
		if (attributes.isEmpty()) {
			return new ResponseEntity<Set<Attribute>>(attributes, HttpStatus.OK);
		}
		return new ResponseEntity<Set<Attribute>>(attributes, HttpStatus.OK);
	}

}
