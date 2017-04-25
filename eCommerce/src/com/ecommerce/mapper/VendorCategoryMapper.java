package com.ecommerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.mvc.model.CategoryVendorMapper;

public class VendorCategoryMapper implements RowMapper<CategoryVendorMapper> {
	 public CategoryVendorMapper mapRow(ResultSet rs, int rowNum) throws SQLException {
		 CategoryVendorMapper mapper = new CategoryVendorMapper();
		 mapper.setCatgoryId(rs.getString("category_id"));
		 mapper.setVendorId(rs.getString("vendor_id"));
		
	      return mapper;
	   }
}