/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:AdminProductCategoryService.java
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

package com.ecommerce.service.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ecommerce.mapper.VendorCategoryMapper;
import com.ecommerce.mvc.model.CategoryVendorMapper;
import com.ecommerce.mvc.model.ProductCategory;
import com.ecommerce.service.AdminProductCategoryService;
import com.ecommerce.service.SOAPWebService;

/**
 * @author Abdul.Azeez
 *
 */
public class AdminProductCategoryServiceImpl implements AdminProductCategoryService {

	@Inject
	private SOAPWebService sOAPWebServiceImp;

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecommerce.service.AdminProductCategoryService#getAllCategories()
	 */
	@Override
	public List<ProductCategory> getAllCategories() {

		List<ProductCategory> items = null;
		items = sOAPWebServiceImp.getAllProductCategories();
		
		List<CategoryVendorMapper> vendorMappers =new ArrayList<CategoryVendorMapper>();
		
		List<String> vendorIdList = new ArrayList<>();
		
		
		for(ProductCategory productCategory:items){
			
			vendorIdList=getAllCategoryVendorMappings(productCategory.getCategoryID());
		/*	if(null != vendorMappers){
			for(CategoryVendorMapper vendorMapper:vendorMappers){
				vendorIdList.add(vendorMapper.getVendorId());
			}*/
			
			productCategory.setVendorMappers(vendorIdList);
		
	
		}
		

		// items=sOAPWebServiceImp.getProductCategory();
		return items;
	}

	/**
	 * @param string 
	 * Gets ....
	 * @param 
	 * @param 
	 * @return List<CategoryVendorMapper>
	 * @throws 
	 */
	
	private List<String> getAllCategoryVendorMappings(String catgoryId) {
		String query = "select vendor_id from vendor_categories where category_id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CategoryVendorMapper> categoryVendorMappers = new ArrayList<CategoryVendorMapper>();
		
		
		List<String> vendorIdList = new ArrayList<>();

		//vendorIdList=jdbcTemplate.query(query, new Object[] {catgoryId}, new String());
		
try{
	//categoryVendorMappers = jdbcTemplate.query(query, new Object[] {catgoryId}, new VendorCategoryMapper());
	
	vendorIdList = (List<String>) jdbcTemplate.queryForList(query, new Object[] {catgoryId},String.class);

	
}
		catch(Exception exception){
			vendorIdList=null;
		}

		
		return vendorIdList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ecommerce.service.AdminProductCategoryService#createCategory(com.
	 * ecommerce.mvc.model.ProductCategory)
	 */
	@Override
	public boolean createCategory(ProductCategory category) {
		boolean isAdded = false;
		ProductCategory categoryTemp = category;
		String categoryId = sOAPWebServiceImp.createProductCategory(category);

		if (!("".equals(categoryId))) {

			List<CategoryVendorMapper> vendorMappers = null;
			CategoryVendorMapper vendorMapper = null;

			if (null != categoryTemp.getVendorMappers() && categoryTemp.getVendorMappers().size() != 0) {
				vendorMappers = new ArrayList<>();
				for (String vendorId : categoryTemp.getVendorMappers()) {
					vendorMapper = new CategoryVendorMapper();
					vendorMapper.setVendorId(vendorId);
					vendorMapper.setCatgoryId(categoryId);

					vendorMappers.add(vendorMapper);
				}
			}

			System.out.println(vendorMappers);

			isAdded = createVendorCategoryMapperEntry(vendorMappers);

		}

		return isAdded;
	}

	/**
	 * Gets .... @param @param @return boolean @throws
	 */

	private boolean createVendorCategoryMapperEntry(final List<CategoryVendorMapper> vendorMappers) {

		
		
		String sql = "INSERT INTO vendor_categories "
				+ "(category_id, vendor_id) VALUES (?, ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		
		try {

			jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement statement, int i) throws SQLException {
					CategoryVendorMapper categoryVendorMapper = vendorMappers.get(i);
					statement.setString(1, categoryVendorMapper.getCatgoryId());
					statement.setString(2, categoryVendorMapper.getVendorId());

				}

				@Override
				public int getBatchSize() {
					return vendorMappers.size();
				}
			});
			return true;
		} catch (Exception exception) {
			System.out.println(exception);
			return false;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ecommerce.service.AdminProductCategoryService#updateCategory(com.
	 * ecommerce.mvc.model.ProductCategory)
	 */
	@Override
	public boolean updateCategory(ProductCategory category) {
		ProductCategory categoryTemp = category;
		boolean isUpdated = sOAPWebServiceImp.updateProductCategory(category);
		boolean isDeleted=false;
		
		
		if(isUpdated){
		if (!("".equals(category.getCategoryID()))) {

			List<CategoryVendorMapper> vendorMappers = null;
			CategoryVendorMapper vendorMapper = null;

			if (null != categoryTemp.getVendorMappers() && categoryTemp.getVendorMappers().size() != 0) {
				vendorMappers = new ArrayList<>();
				for (String vendorId : categoryTemp.getVendorMappers()) {
					vendorMapper = new CategoryVendorMapper();
					vendorMapper.setVendorId(vendorId);
					vendorMapper.setCatgoryId(category.getCategoryID());

					vendorMappers.add(vendorMapper);
				}
			}

			System.out.println(vendorMappers);
			
			isDeleted=deleteAllEntriesOfCategories(categoryTemp.getCategoryID());
if(isDeleted){
	isUpdated = createVendorCategoryMapperEntry(vendorMappers);
}else{
	System.out.println("exits from isDeleted");
	
}
			

		}
		System.out.println("exits from isUpdated");
		
		
		}
		
		
		
		
		return isUpdated;
	}

	/**
	 * Gets ....
	 * @param 
	 * @param 
	 * @return boolean
	 * @throws 
	 */
	
	private boolean deleteAllEntriesOfCategories(String categoryID) {
		try {
			String sql = "DELETE FROM vendor_categories WHERE category_id = ?";

			jdbcTemplate = new JdbcTemplate(dataSource);

			jdbcTemplate.update(sql, new Object[] { categoryID });

			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ecommerce.service.AdminProductCategoryService#updateCategoryStatus(
	 * com.ecommerce.mvc.model.ProductCategory)
	 */
	@Override
	public boolean updateCategoryStatus(ProductCategory category) {
		boolean isUpdated = sOAPWebServiceImp.updateCategoryStatus(category);
		return isUpdated;
	}
	
}
