package com.ecommerce.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.mvc.model.AdminScreenCategory;

public class AdminScreenMapper implements RowMapper<AdminScreenCategory> {
	 public AdminScreenCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		 
		 AdminScreenCategory adminScreen = new AdminScreenCategory();
		 
		 adminScreen.setCategoryID(rs.getString("admin_category_Id"));
		 adminScreen.setName(rs.getString("category_name"));
		 adminScreen.setParentID(rs.getString("category_parent_id"));
	     
		 return adminScreen;
	   }
}