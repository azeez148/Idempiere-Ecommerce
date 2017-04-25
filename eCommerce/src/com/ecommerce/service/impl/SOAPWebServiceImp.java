/*
 * Copyright (C) 2013 Nest Information Technologies. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form 
 * or by any means, electronic, mechanical or otherwise, is 
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 *  Class Name:ProductWebServiceImp.java
 *  Created by: srigin.ms
 *  Date: Aug 17, 2016
 *  
 *  Version: <<vesion>> 
 *  Purpose: <<description>> 
 *  
 *  Modifications:
 *  
 *  Modified By: srigin.ms
 *  Date: Aug 17, 2016
 *  Desc: Created and Implemented
 */

package com.ecommerce.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.idempiere.webservice.client.base.DataRow;
import org.idempiere.webservice.client.base.Enums.WebServiceResponseStatus;
import org.idempiere.webservice.client.base.Field;
import org.idempiere.webservice.client.base.LoginRequest;
import org.idempiere.webservice.client.net.WebServiceConnection;
import org.idempiere.webservice.client.request.CompositeOperationRequest;
import org.idempiere.webservice.client.request.CreateDataRequest;
import org.idempiere.webservice.client.request.QueryDataRequest;
import org.idempiere.webservice.client.request.UpdateDataRequest;
import org.idempiere.webservice.client.response.CompositeResponse;
import org.idempiere.webservice.client.response.StandardResponse;
import org.idempiere.webservice.client.response.WindowTabDataResponse;
import org.idempiere.webservice.client.util.Base64Util;
import org.springframework.beans.factory.annotation.Value;

import com.ecommerce.mvc.model.Attribute;
import com.ecommerce.mvc.model.AttributeValue;
import com.ecommerce.mvc.model.City;
import com.ecommerce.mvc.model.Country;
import com.ecommerce.mvc.model.PriceList;
import com.ecommerce.mvc.model.Product;
import com.ecommerce.mvc.model.ProductCategory;
import com.ecommerce.mvc.model.State;
import com.ecommerce.mvc.model.User;
import com.ecommerce.mvc.rest.controller.MainController;
import com.ecommerce.service.SOAPWebService;
import com.ecommerce.util.ImageUtility;

/**
 * @author srigin.ms
 *
 */
public class SOAPWebServiceImp implements SOAPWebService {

	// for logging
	final static Logger logger = Logger.getLogger(MainController.class);

	@Inject
	private WebServiceConnection webServiceConnection;

	@Inject
	private LoginRequest loginRequest;

	@Value("${M_PriceList_Version_ID}")
	String pricelistVersion;

	/*
	 * (non-Javadoc) * @see
	 * com.ecommerce.service.ProductWebService#getConnection()
	 */
	@Override
	public WebServiceConnection getConnection() {
		// TODO Auto-generated method stub
		return webServiceConnection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecommerce.service.ProductWebService#getLogin()
	 */
	@Override
	public LoginRequest getLogin() {
		// TODO Auto-generated method stub
		return loginRequest;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecommerce.service.SOAPWebService#getProducts()
	 */
	@Override
	public List<Product> getHotSellingProducts() {

		List<Product> allProducts = new ArrayList<Product>();
		QueryDataRequest queryDataRequest = new QueryDataRequest();
		queryDataRequest.setWebServiceType("QueryHotSellingproducts");
		queryDataRequest.setLogin(getLogin());
		queryDataRequest.setLimit(5);

		DataRow dataRow = new DataRow();
		dataRow.addField("M_PriceList_Version_ID", pricelistVersion);
		queryDataRequest.setDataRow(dataRow);

		WebServiceConnection client = getConnection();

		try {
			WindowTabDataResponse response = client.sendRequest(queryDataRequest);
			if (response.getStatus() == WebServiceResponseStatus.Error) {
				System.out.println(response.getErrorMessage());
			} else {

				for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
					Product product = new Product();
					for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {

						Field field = response.getDataSet().getRow(i).getFields().get(j);
						if (field.getColumn().equalsIgnoreCase("Name"))
							product.setName(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("M_Product_ID"))
							product.setProductID(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("Ad_Image_ID"))
							product.setLogoID(field.getStringValue());
					}
					allProducts.add(product);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return allProducts;
	}

	/*
		*//**
			 * Query the result @param @param @return List<Product> @throws
			 *//*
			 * 
			 * private List<Product> hotSellingProduct(List<Product>
			 * allProducts) { // TODO Auto-generated method stub
			 * 
			 * List<Product> result = new ArrayList<>(); Set<Product> products =
			 * new HashSet<>();
			 * 
			 * for (Product product : allProducts) {
			 * 
			 * if(!products.add(product)) { Iterator<Product> iterator =
			 * products.iterator(); while(iterator.hasNext()) { Product product2
			 * = iterator.next(); if(product2.equals(product)) { int qty1 =
			 * Integer.parseInt(product2.getQtyOrdered()); int qty2 =
			 * Integer.parseInt(product.getQtyOrdered());
			 * product2.setQtyOrdered(String.valueOf(qty1+qty2)); } } } }
			 * result.addAll(products); //Sort the result to Qty Ordered
			 * Collections.sort(result, new Comparator<Product>() {
			 * 
			 * @Override public int compare(Product product1, Product product2)
			 * { // TODO Auto-generated method stub Integer qty1 =
			 * Integer.parseInt(product1.getQtyOrdered()); Integer qty2 =
			 * Integer.parseInt(product2.getQtyOrdered()); return
			 * qty2.compareTo(qty1); } }); return result; }
			 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecommerce.service.SOAPWebService#getProductCategory()
	 */
	@Override
	public List<ProductCategory> getProductCategory() {
		// TODO Auto-generated method stub
		Map<ProductCategory, String> parentChildMap = new HashMap<>();
		QueryDataRequest queryDataRequest = new QueryDataRequest();
		queryDataRequest.setWebServiceType("QueryProductCategoryTest");
		queryDataRequest.setLogin(getLogin());
		/* queryDataRequest.setLimit(3); */

		/* dataRow.addField("Name", "%Store%"); */

		WebServiceConnection client = getConnection();

		try {
			WindowTabDataResponse response = client.sendRequest(queryDataRequest);

			if (response.getStatus() == WebServiceResponseStatus.Error) {
				System.out.println(response.getErrorMessage());
			} else {
				for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
					ProductCategory product = new ProductCategory();
					for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {

						Field field = response.getDataSet().getRow(i).getFields().get(j);
						if (field.getColumn().equalsIgnoreCase("Name"))
							product.setName(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("M_Product_Category_ID"))
							product.setCategoryID(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("M_Product_Category_Parent_ID"))
							product.setParentID(field.getStringValue());
					}
					parentChildMap.put(product, product.getParentID());
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return processCategoryHierarchy(parentChildMap);
	}

	/**
	 * @param parentChildMap
	 *            Gets .... @param @param @return List<ProductCategory> @throws
	 */

	private List<ProductCategory> processCategoryHierarchy(Map<ProductCategory, String> parentChildMap) {
		// TODO Auto-generated method stub
		List<ProductCategory> result = new ArrayList<>();
		for (Map.Entry<ProductCategory, String> entry : parentChildMap.entrySet()) {

			ProductCategory category = entry.getKey();
			category.setChildren(getChildren(parentChildMap, category.getCategoryID()));

			if (entry.getValue().equals(null) || entry.getValue().length() == 0) {
				result.add(category);
			}

		}
		return result;
	}

	/**
	 * @param string
	 *            Gets .... @param @param @return List<ProductCategory> @throws
	 */

	private List<ProductCategory> getChildren(Map<ProductCategory, String> parentChildMap, String parentID) {
		// TODO Auto-generated method stub
		List<ProductCategory> children = new ArrayList<>();
		for (Map.Entry<ProductCategory, String> entry : parentChildMap.entrySet()) {
			if (entry.getValue() == null)
				continue;
			else if (entry.getValue().equals(parentID)) {
				children.add(entry.getKey());
			}

		}

		return children;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecommerce.service.SOAPWebService#writeAllImages()
	 */
	@Override
	public void writeAllImages(HttpServletRequest servletContext) {
		// TODO Auto-generated method stub
		ImageUtility imageUtility = new ImageUtility();
		QueryDataRequest queryDataRequest = new QueryDataRequest();
		queryDataRequest.setWebServiceType("QueryImageTest");
		queryDataRequest.setLogin(getLogin());

		WebServiceConnection client = getConnection();

		try {
			WindowTabDataResponse response = client.sendRequest(queryDataRequest);

			if (response.getStatus() == WebServiceResponseStatus.Error) {
				System.out.println(response.getErrorMessage());
			} else if (response.getStatus() == WebServiceResponseStatus.Unsuccessful) {
				System.out.println("Unsuccessful");
			} else {
				for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
					for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
						Field field = response.getDataSet().getRow(i).getFields().get(j);
						if (field.getColumn().equals("BinaryData") && !field.getValue().toString().isEmpty()) {
							byte[] img = new byte[1024];
							img = Base64Util.decode(field.getValue().toString());
							// System.out.println(img);
							imageUtility.writeFile(servletContext,
									response.getDataSet().getRow(i).getField("AD_Image_ID").getValue().toString()
											+ ".png",
									img);
						}

					}
					System.out.println();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Product getProductByID(String ID) {
		// TODO Auto-generated method stub

		Set<Product> allProducts = new HashSet<Product>();
		QueryDataRequest queryDataRequest = new QueryDataRequest();
		queryDataRequest.setWebServiceType("QueryFromStorage");
		queryDataRequest.setLogin(getLogin());

		DataRow dataRow = new DataRow();
		dataRow.addField("M_PriceList_Version_ID", pricelistVersion);

		if (ID != null && ID.length() > 0)
			dataRow.addField("M_Product_ID", ID);

		queryDataRequest.setDataRow(dataRow);

		WebServiceConnection client = getConnection();

		try {
			WindowTabDataResponse response = client.sendRequest(queryDataRequest);
			if (response.getStatus() == WebServiceResponseStatus.Error) {
				System.out.println(response.getErrorMessage());
			} else {

				for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
					Product product = new Product();
					Set<AttributeValue> attributes = new HashSet<>();
					for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {

						Field field = response.getDataSet().getRow(i).getFields().get(j);
						if (field.getColumn().equalsIgnoreCase("Name"))
							product.setName(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("Value"))
							product.setValue(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("M_Product_Category_ID"))
							product.setCategoryId(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("M_Product_ID"))
							product.setProductID(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("Logo_ID"))
							product.setLogoID(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("PriceList"))
							product.setPriceList(Double.valueOf(field.getStringValue()));
						else if (field.getColumn().equalsIgnoreCase("ProductAttribute")
								|| field.getColumn().equalsIgnoreCase("InstanceAttribute")) {

							String[] tokensVal = field.getStringValue().split("_");

							for (String string : tokensVal) {
								AttributeValue attribute = new AttributeValue();
								attribute.setValue(string);
								attributes.add(attribute);
							}
							product.setAttributes(attributes);
						} else if (field.getColumn().equalsIgnoreCase("DocumentNote"))
							product.setDocumentNote(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("sum"))
							product.setInventoryQty(
									Double.valueOf(field.getStringValue().isEmpty() ? "0" : field.getStringValue()));
						else if (field.getColumn().equalsIgnoreCase("PriceStd"))
							product.setPriceStd(
									Double.valueOf(field.getStringValue().isEmpty() ? "0" : field.getStringValue()));

					}
					if (!allProducts.add(product)) {
						for (Product products : allProducts) {
							if (products.equals(product)) {
								if (products.getAttributes() != null && product.getAttributes() != null) {
									Set<AttributeValue> attributes2 = new HashSet<>();
									attributes2.addAll(products.getAttributes());
									attributes2.addAll(product.getAttributes());
									products.setAttributes(attributes2);
								} else if (product.getAttributes() != null)
									products.setAttributes(product.getAttributes());

								products.setInventoryQty(products.getInventoryQty() + product.getInventoryQty());
							}

						}

					}
					product.setDiscount(setProductDiscount(product));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return allProducts.isEmpty() ? null : allProducts.iterator().next();
	}

	@Override
	public Set<Product> getProducts(String name, String category) {
		// TODO Auto-generated method stub

		Set<Product> allProducts = new HashSet<Product>();
		QueryDataRequest queryDataRequest = new QueryDataRequest();
		queryDataRequest.setWebServiceType("QueryFromStorage");
		queryDataRequest.setLogin(getLogin());

		DataRow dataRow = new DataRow();
		dataRow.addField("M_PriceList_Version_ID", pricelistVersion);

		if (category != null && category.length() > 0)
			dataRow.addField("M_Product_Category_ID", category);

		if (name != null && name.length() > 0)
			dataRow.addField("Name", "%" + name.toLowerCase() + "%");

		queryDataRequest.setDataRow(dataRow);

		WebServiceConnection client = getConnection();

		try {
			WindowTabDataResponse response = client.sendRequest(queryDataRequest);
			if (response.getStatus() == WebServiceResponseStatus.Error) {
				System.out.println(response.getErrorMessage());
			} else {

				for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
					Product product = new Product();
					Set<AttributeValue> attributes = new HashSet<>();
					for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {

						Field field = response.getDataSet().getRow(i).getFields().get(j);
						if (field.getColumn().equalsIgnoreCase("Name"))
							product.setName(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("Value"))
							product.setValue(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("M_Product_ID"))
							product.setProductID(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("Logo_ID"))
							product.setLogoID(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("PriceList"))
							product.setPriceList(
									Double.valueOf(field.getStringValue().isEmpty() ? "0" : field.getStringValue()));
						else if (field.getColumn().equalsIgnoreCase("ProductAttribute")
								|| field.getColumn().equalsIgnoreCase("InstanceAttribute")) {

							String[] tokensVal = field.getStringValue().split("_");

							for (String string : tokensVal) {
								AttributeValue attribute = new AttributeValue();
								attribute.setValue(string);
								attributes.add(attribute);
							}
							product.setAttributes(attributes);
						} else if (field.getColumn().equalsIgnoreCase("DocumentNote"))
							product.setDocumentNote(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("sum"))
							product.setInventoryQty(
									Double.valueOf(field.getStringValue().isEmpty() ? "0" : field.getStringValue()));
						else if (field.getColumn().equalsIgnoreCase("PriceStd"))
							product.setPriceStd(
									Double.valueOf(field.getStringValue().isEmpty() ? "0" : field.getStringValue()));

					}
					if (!allProducts.add(product)) {
						for (Product products : allProducts) {
							if (products.equals(product)) {
								if (products.getAttributes() != null && product.getAttributes() != null) {
									Set<AttributeValue> attributes2 = new HashSet<>();
									attributes2.addAll(products.getAttributes());
									attributes2.addAll(product.getAttributes());
									products.setAttributes(attributes2);
								} else if (product.getAttributes() != null)
									products.setAttributes(product.getAttributes());

								products.setInventoryQty(products.getInventoryQty() + product.getInventoryQty());
							}

						}

					}
					product.setDiscount(setProductDiscount(product));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("All Products" + allProducts);
		return allProducts;
	}

	/**
	 * @param product
	 *            Gets .... @param @param @return void @throws
	 */

	private BigDecimal setProductDiscount(Product product) {
		// TODO Auto-generated method stub
		BigDecimal Discount = new BigDecimal(0);
		if (product.getPriceList().intValue() != 0)
			Discount = BigDecimal
					.valueOf((product.getPriceList() - product.getPriceStd()) / product.getPriceList() * 100.0);
		if (Discount.scale() > 2)
			Discount = Discount.setScale(2, BigDecimal.ROUND_HALF_UP);
		return Discount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecommerce.service.SOAPWebService#getProducts()
	 */
	@Override
	public Set<Attribute> getProductAttrbutes() {

		Set<Attribute> allAttributes = new HashSet<Attribute>();
		QueryDataRequest queryDataRequest = new QueryDataRequest();
		queryDataRequest.setWebServiceType("QueryAttributeValue");
		queryDataRequest.setLogin(getLogin());

		DataRow dataRow = new DataRow();
		queryDataRequest.setDataRow(dataRow);

		WebServiceConnection client = getConnection();

		try {
			WindowTabDataResponse response = client.sendRequest(queryDataRequest);
			if (response.getStatus() == WebServiceResponseStatus.Error) {
				System.out.println(response.getErrorMessage());
			} else {

				for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
					Attribute attribute = new Attribute();
					List<AttributeValue> attributeValues = new ArrayList<>();
					for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {

						Field field = response.getDataSet().getRow(i).getFields().get(j);
						if (field.getColumn().equalsIgnoreCase("AttributeName"))
							attribute.setName(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("AttributeValue")) {
							AttributeValue attributeValue = new AttributeValue();
							attributeValue.setValue(field.getStringValue());
							attributeValues.add(attributeValue);

							attribute.setAttributeValues(attributeValues);

						}
					}
					if (!allAttributes.add(attribute)) {
						for (Attribute attribute1 : allAttributes) {
							if (attribute1.equals(attribute)) {
								if (attribute1.getAttributeValues() != null && attribute.getAttributeValues() != null) {
									Set<AttributeValue> attributes2 = new HashSet<>();
									attributes2.addAll(attribute1.getAttributeValues());
									attributes2.addAll(attribute.getAttributeValues());
									attribute1.setAttributeValues(new ArrayList<>(attributes2));
								} else if (attribute.getAttributeValues() != null)
									attribute1.setAttributeValues(attribute.getAttributeValues());
							}

						}

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return allAttributes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ecommerce.service.SOAPWebService#getUser(com.ecommerce.mvc.model.
	 * User)
	 */
	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub

		User user2 = null;

		QueryDataRequest queryDataRequest = new QueryDataRequest();
		queryDataRequest.setWebServiceType("QueryUser");
		queryDataRequest.setLogin(getLogin());

		DataRow dataRow = new DataRow();
		dataRow.addField("Name", user.getUserName().toLowerCase());
		queryDataRequest.setDataRow(dataRow);

		WebServiceConnection client = getConnection();

		try {
			WindowTabDataResponse response = client.sendRequest(queryDataRequest);
			if (response.getStatus() == WebServiceResponseStatus.Error) {
				System.out.println(response.getErrorMessage());
			} else {

				for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {

					user2 = new User();

					for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {

						Field field = response.getDataSet().getRow(i).getFields().get(j);
						if (field.getColumn().equalsIgnoreCase("AD_User_ID"))
							user2.setUserId((field.getStringValue()));
						if (field.getColumn().equalsIgnoreCase("Name"))
							user2.setUserName((field.getStringValue()));
						if (field.getColumn().equalsIgnoreCase("Password"))
							user2.setPassword((field.getStringValue()));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user2;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecommerce.service.SOAPWebService#getCountries()
	 */
	@Override
	public List<Country> getCountries() {

		List<Country> tempCountryList = null;
		List<Country> countryList = null;
		Country country = null;
		QueryDataRequest queryDataRequest = new QueryDataRequest();
		queryDataRequest.setWebServiceType("QueryCountry");
		queryDataRequest.setLogin(getLogin());

		WebServiceConnection client = getConnection();

		try {
			WindowTabDataResponse response = client.sendRequest(queryDataRequest);
			if (response.getStatus() == WebServiceResponseStatus.Error) {
				System.out.println(response.getErrorMessage());
			} else {
				tempCountryList = new ArrayList<Country>();
				for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {

					country = new Country();
					State state = new State();
					City city = new City();
					List<State> states = new ArrayList<State>();
					List<City> cities = new ArrayList<City>();
					for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {

						Field field = response.getDataSet().getRow(i).getFields().get(j);
						if (field.getColumn().equalsIgnoreCase("C_Country_ID"))
							country.setCountryId((field.getStringValue()));
						if (field.getColumn().equalsIgnoreCase("CountryName"))
							country.setCountryName((field.getStringValue()));
						if (field.getColumn().equalsIgnoreCase("CountryCode"))
							country.setCountryCode((field.getStringValue()));

						if (field.getColumn().equalsIgnoreCase("C_Region_ID")) {
							state.setStateId((field.getStringValue()));
						}
						if (field.getColumn().equalsIgnoreCase("RegionName")) {
							state.setStateName((field.getStringValue()));
						}
						if (field.getColumn().equalsIgnoreCase("C_City_ID")) {
							city.setCityId((field.getStringValue()));
						}
						if (field.getColumn().equalsIgnoreCase("cityname")) {
							city.setCityName((field.getStringValue()));
						}
					}
					states.add(state);
					cities.add(city);
					state.setCities(cities);
					country.setStates(states);
					tempCountryList.add(country);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		countryList = finalizeCountryList(tempCountryList);

		return countryList;
	}

	/**
	 * Gets .... @param @param @return void @throws
	 * 
	 * @return
	 */

	private List<Country> finalizeCountryList(List<Country> countryList) {
		List<Country> tempCountryList = new ArrayList<Country>();
		// List<State> tempStateList = new ArrayList<State>();
		List<String> tempCList = new ArrayList<String>();
		List<State> tempSList = new ArrayList<>();
		/*
		 * List<City> tempCityList = new ArrayList<>();
		 * 
		 * Map<String, List<State>> countryMap = new HashMap<String,
		 * List<State>>();
		 * 
		 * List<State> tempStateList = new ArrayList<State>(); State state =
		 * null;
		 * 
		 * Country tempCountry = null;
		 */
		for (Country country : countryList) {
			// logger.info("country is "+country);
			if (!tempCList.contains(country.getCountryId())) {
				tempCList.add(country.getCountryId());

				tempCountryList.add(country);
			}

		}

		for (Country country : tempCountryList) {

			tempSList = findAllStates(country, countryList);
			// tempCityList=findAllCities(country,countryList);

			country.setStates(tempSList);
			logger.info("country  is " + country);

		}

		return tempCountryList;

	}

	/**
	 * Gets .... @param @param @return List<String> @throws
	 * 
	 * @param countryObj2
	 */

	private List<City> findAllCities(Country countryObj2, State state, List<Country> countryList) {
		List<City> cities = new ArrayList<>();
		City city = null;

		for (Country countryObj : countryList) {

			if (countryObj.getStates().size() != 0) {

				if (state.getStateId().equals(countryObj.getStates().get(0).getStateId())) {

					city = countryObj.getStates().get(0).getCities().get(0);
					// logger.info("state is "+state);
					if (!("").equals(city.getCityId())) {
						cities.add(city);
						// logger.info("city is " + city);

					}
				}
			}
		}

		return cities;

	}

	/**
	 * @param countryList
	 *            Gets .... @param @param @return void @throws
	 */

	private List<State> findAllStates(Country country, List<Country> countryList) {

		List<State> states = new ArrayList<>();
		List<String> tempStateList = new ArrayList<>();
		State state = null;
		State tempState = null;
		List<City> tempCityList = new ArrayList<>();

		for (Country countryObj : countryList) {

			if (country.getCountryId().equals(countryObj.getCountryId())) {

				state = countryObj.getStates().get(0);

				if (!("").equals(state.getStateId())) {

					if (!tempStateList.contains(state.getStateId())) {
						tempStateList.add(state.getStateId());

						tempState = state;
						states.add(tempState);
					}

					tempCityList = findAllCities(countryObj, state, countryList);

					state.setCities(tempCityList);

					// countryMap.put(cId, arg1)

				}

			}

		}

		return states;

	}

	/**
	 * @return Creates User.... @param @param @return void @throws
	 */

	public User createUser(User user) {

		// composite

		CompositeOperationRequest compositeOperation = new CompositeOperationRequest();
		compositeOperation.setLogin(getLogin());
		compositeOperation.setWebServiceType("CreateBpartnerComposite");

		// BPartner
		CreateDataRequest createBuisnessPartner = new CreateDataRequest();
		createBuisnessPartner.setWebServiceType("CreateBuisnessPartner");
		DataRow data = new DataRow();
		data.addField("Name", user.getUserName());
		
		
		//data.addField("IsCustomer", "Y");
		
		if(user.getIsVendor() == false){
			data.addField("IsVendor", "N");
		}else if(user.getIsVendor() == true){
			data.addField("IsVendor", "Y");
			data.addField("C_BP_Group_ID", "104"); // Standard BPGroup:Vendors
			
		}
		
		if(user.getIsCustomer() == false ){
			data.addField("IsCustomer", "N");
		}else if(user.getIsCustomer() == true ){
			data.addField("IsCustomer", "Y");
			data.addField("C_BP_Group_ID", "103"); // Standard BPGroup: Standard Customers
		}
		
		data.addField("IsProspect", "N");
		
		
		
		createBuisnessPartner.setDataRow(data);

		// User
		CreateDataRequest createUser = new CreateDataRequest();
		createUser.setWebServiceType("CreateUser");
		DataRow dataUser = new DataRow();
		dataUser.addField("Name", user.getUserName());
		dataUser.addField("EMail", user.getUserEmail());
		dataUser.addField("Phone", user.getUserMobile());
		dataUser.addField("Password", user.getPassword());
	//	dataUser.addField("Password", user.getPassword());
		dataUser.addField("C_BPartner_ID", "@C_BPartner.C_BPartner_ID");
		createUser.setDataRow(dataUser);

		//String userId="@C_BPartner.C_BPartner_ID";
		
		
		DataRow dataUserTemp = new DataRow();
		dataUserTemp.addField("tempUserId","@AD_User.AD_User_ID");
		
		System.out.println("tempUserId issssssssssssss "+dataUserTemp.getField("tempUserId"));
		
		
		
		// Location
		CreateDataRequest createLocation = new CreateDataRequest();
		createLocation.setWebServiceType("CreateLocation");
		DataRow dataLocation = new DataRow();
		dataLocation.addField("Address1", user.getUserAddress1());
		dataLocation.addField("Address2", user.getUserAddress2());
		dataLocation.addField("Postal", user.getUserPinCode());
		dataLocation.addField("C_City_ID", user.getUserCity().getCityId());
		dataLocation.addField("C_Country_ID", user.getUserCountry().getCountryId());
		dataLocation.addField("C_Region_ID", user.getUserState().getStateId());
		dataLocation.addField("RegionName", user.getUserState().getStateName());
		createLocation.setDataRow(dataLocation);

		// BPLocation
		CreateDataRequest createBPLocation = new CreateDataRequest();
		createBPLocation.setWebServiceType("CreateBPLocation");
		DataRow dataBPLocation = new DataRow();
		dataBPLocation.addField("C_BPartner_ID", "@C_BPartner.C_BPartner_ID");
		dataBPLocation.addField("C_Location_ID", "@C_Location.C_Location_ID");
		createBPLocation.setDataRow(dataBPLocation);

		compositeOperation.addOperation(createBuisnessPartner);
		compositeOperation.addOperation(createUser);
		compositeOperation.addOperation(createLocation);
		compositeOperation.addOperation(createBPLocation);

		WebServiceConnection client = getConnection();

		try {
			CompositeResponse response = client.sendRequest(compositeOperation);

			if (response.getStatus() == WebServiceResponseStatus.Error) {
				System.out.println(response.getErrorMessage());
			} else {
				if(null != response.getResponse(1)){
					StandardResponse response2=(StandardResponse) response.getResponse(1);
					if(!(response2.getStatus() == WebServiceResponseStatus.Error)){
									user.setUserId(response2.getRecordID().toString());
					}
				}
				//WindowTabDataResponse dataResponse=(WindowTabDataResponse) response.getResponse(1);

				//System.out.println(dataResponse.);
				
				
				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Gets .... @param @param @return ProductCategory @throws
	 */

	public ProductCategory getCategoryById(String categoryId) {

		ProductCategory productCategory = null;

		QueryDataRequest queryDataRequest = new QueryDataRequest();
		queryDataRequest.setWebServiceType("QueryCategoryByID");
		queryDataRequest.setLogin(getLogin());

		DataRow dataRow = new DataRow();
		dataRow.addField("M_Product_Category_ID", categoryId);
		queryDataRequest.setDataRow(dataRow);

		WebServiceConnection client = getConnection();

		try {
			WindowTabDataResponse response = client.sendRequest(queryDataRequest);
			if (response.getStatus() == WebServiceResponseStatus.Error) {
				System.out.println(response.getErrorMessage());
			} else {

				for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {

					productCategory = new ProductCategory();

					for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {

						Field field = response.getDataSet().getRow(i).getFields().get(j);
						if (field.getColumn().equalsIgnoreCase("M_Product_Category_ID"))
							productCategory.setCategoryID((field.getStringValue()));
						if (field.getColumn().equalsIgnoreCase("Name"))
							productCategory.setName((field.getStringValue()));

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return productCategory;

	}

	/**
	 * Gets .... @param @param @return User @throws
	 */

	public User getUserById(String userId) {
		User user = null;

		QueryDataRequest queryDataRequest = new QueryDataRequest();
		queryDataRequest.setWebServiceType("QueryUserById");
		queryDataRequest.setLogin(getLogin());

		DataRow dataRow = new DataRow();
		dataRow.addField("AD_User_ID", userId);
		queryDataRequest.setDataRow(dataRow);

		WebServiceConnection client = getConnection();

		try {
			WindowTabDataResponse response = client.sendRequest(queryDataRequest);
			if (response.getStatus() == WebServiceResponseStatus.Error) {
				System.out.println(response.getErrorMessage());
			} else {

				for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {

					user = new User();

					for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {

						Field field = response.getDataSet().getRow(i).getFields().get(j);
						if (field.getColumn().equalsIgnoreCase("AD_User_ID"))
							user.setUserId(((field.getStringValue())));
						if (field.getColumn().equalsIgnoreCase("Name"))
							user.setUserName(((field.getStringValue())));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecommerce.service.SOAPWebService#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers(String type) {

		List<User> users = new ArrayList<User>();

		User user = null;

		QueryDataRequest queryDataRequest = new QueryDataRequest();
		queryDataRequest.setWebServiceType("GetAllUsers");
		queryDataRequest.setLogin(getLogin());

		DataRow dataRow = new DataRow();

		if (type.equals("customer")) {
			dataRow.addField("IsCustomer", "Y");
		} else if (type.equals("vendor")) {
			dataRow.addField("IsVendor", "Y");
		}

		queryDataRequest.setDataRow(dataRow);

		WebServiceConnection client = getConnection();

		try {
			WindowTabDataResponse response = client.sendRequest(queryDataRequest);
			if (response.getStatus() == WebServiceResponseStatus.Error) {
				System.out.println(response.getErrorMessage());
			} else {

				for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {

					user = new User();

					for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {

						Field field = response.getDataSet().getRow(i).getFields().get(j);
						if (field.getColumn().equalsIgnoreCase("AD_User_ID"))
							user.setUserId(((field.getStringValue())));
						if (field.getColumn().equalsIgnoreCase("UserName"))
							user.setUserName(((field.getStringValue())));
						if (field.getColumn().equalsIgnoreCase("EMail"))
							user.setUserEmail(((field.getStringValue())));
						if (field.getColumn().equalsIgnoreCase("Phone"))
							user.setUserMobile(((field.getStringValue())));
						if (field.getColumn().equalsIgnoreCase("C_BPartner_Location_ID"))
							user.setUserLocationId(((field.getStringValue())));
						if (field.getColumn().equalsIgnoreCase("C_BPartner_ID"))
							user.setUserPartnerId(((field.getStringValue())));
						if (field.getColumn().equalsIgnoreCase("IsActive"))
							user.setIsActive(((field.getStringValue())));
						if (field.getColumn().equalsIgnoreCase("bpartnername"))
							user.setUserPartnerName(((field.getStringValue())));
						if (field.getColumn().equalsIgnoreCase("RegionName"))
							user.setUserStateName(((field.getStringValue())));
						if (field.getColumn().equalsIgnoreCase("cityname"))
							user.setUserCityName(((field.getStringValue())));
						if (field.getColumn().equalsIgnoreCase("CountryName"))
							user.setUserCountryName(((field.getStringValue())));
						if (field.getColumn().equalsIgnoreCase("Address1"))
							user.setUserAddress1(((field.getStringValue())));
						if (field.getColumn().equalsIgnoreCase("Address2"))
							user.setUserAddress2(((field.getStringValue())));

					}
					users.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.SOAPWebService#getAllProductCategories()
	 */
	@Override
	public List<ProductCategory> getAllProductCategories() {
		// TODO Auto-generated method stub
				//Map<ProductCategory, String> parentChildMap = new HashMap<>();
		List<ProductCategory> productCategories=new ArrayList<ProductCategory>();
				QueryDataRequest queryDataRequest = new QueryDataRequest();
				queryDataRequest.setWebServiceType("QueryAllProductCategory");
				queryDataRequest.setLogin(getLogin());
			

				WebServiceConnection client = getConnection();

				try {
					WindowTabDataResponse response = client.sendRequest(queryDataRequest);

					if (response.getStatus() == WebServiceResponseStatus.Error) {
						System.out.println(response.getErrorMessage());
					} else {
						for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
							ProductCategory category = new ProductCategory();
							for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {

								Field field = response.getDataSet().getRow(i).getFields().get(j);
								if (field.getColumn().equalsIgnoreCase("Name"))
									category.setName(field.getStringValue());
								else if (field.getColumn().equalsIgnoreCase("M_Product_Category_ID"))
									category.setCategoryID(field.getStringValue());
								else if (field.getColumn().equalsIgnoreCase("M_Product_Category_Parent_ID"))
									category.setParentID(field.getStringValue());
								else if (field.getColumn().equalsIgnoreCase("IsActive")){
										category.setIsActive(field.getStringValue());
									
								}
									
									
							}
							productCategories.add(category);
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				
				
				return productCategories;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.SOAPWebService#createProductCategory(com.ecommerce.mvc.model.ProductCategory)
	 */
	@Override
	public String createProductCategory(ProductCategory category) {
		String categoryId="";

		CreateDataRequest createDataRequest = new CreateDataRequest();
		createDataRequest.setWebServiceType("CreateNewProductCategory");
		createDataRequest.setLogin(getLogin());

		
		DataRow dataRow = new DataRow();
		dataRow.addField("M_Product_Category_Parent_ID", category.getParentID());
		dataRow.addField("Name", category.getName());
		dataRow.addField("Value", category.getName());
		createDataRequest.setDataRow(dataRow);

		
		
		WebServiceConnection client = getConnection();

		try {
			StandardResponse response = client.sendRequest(createDataRequest);
			if (response.getStatus() == WebServiceResponseStatus.Error) {
				System.out.println(response.getErrorMessage());
			} else {
				
				
						if(null != response.getRecordID()){
							categoryId=response.getRecordID().toString();
							
							
						}
						//WindowTabDataResponse dataResponse=(WindowTabDataResponse) response.getResponse(1);

						//System.out.println(dataResponse.);
						
						
						return categoryId;
					}
				
				
				

			/*	for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {

					productCategory = new ProductCategory();

					for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {

						Field field = response.getDataSet().getRow(i).getFields().get(j);
						if (field.getColumn().equalsIgnoreCase("M_Product_Category_ID"))
							productCategory.setCategoryID((field.getStringValue()));
						if (field.getColumn().equalsIgnoreCase("Name"))
							productCategory.setName((field.getStringValue()));

					}
				}*/
			}
		catch (Exception e) {
			e.printStackTrace();
		}

		return categoryId;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.SOAPWebService#updateProductCategory(com.ecommerce.mvc.model.ProductCategory)
	 */
	@Override
	public boolean updateProductCategory(ProductCategory category) {
		UpdateDataRequest updateDataRequest = new UpdateDataRequest();
		updateDataRequest.setWebServiceType("UpdateProductCategory");
		updateDataRequest.setLogin(getLogin());
		updateDataRequest.setRecordID(Integer.parseInt(category.getCategoryID()));
		
		DataRow dataRow = new DataRow();
		dataRow.addField("Name", category.getName());
		dataRow.addField("M_Product_Category_Parent_ID", category.getParentID());
		dataRow.addField("Value", category.getName());
		updateDataRequest.setDataRow(dataRow);

		
		
		WebServiceConnection client = getConnection();

		try {
			StandardResponse response = client.sendRequest(updateDataRequest);
			if (response.getStatus() == WebServiceResponseStatus.Error) {
				System.out.println(response.getErrorMessage());
			} else {
				return true;

			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.SOAPWebService#updateCategoryStatus(com.ecommerce.mvc.model.ProductCategory)
	 */
	@Override
	public boolean updateCategoryStatus(ProductCategory category) {
		UpdateDataRequest updateDataRequest = new UpdateDataRequest();
		updateDataRequest.setWebServiceType("UpdateProductCategoryStatus");
		updateDataRequest.setLogin(getLogin());
		updateDataRequest.setRecordID(Integer.parseInt(category.getCategoryID()));
		
		DataRow dataRow = new DataRow();
		dataRow.addField("IsActive", category.getIsActive());
		/*if(category.getIsActive().equals("Y")){
			dataRow.addField("IsActive", category.getName());
		}else if(category.getIsActive().equals("N")){
			dataRow.addField("IsActive", category.getName());
		}*/
		
		updateDataRequest.setDataRow(dataRow);

		
		
		WebServiceConnection client = getConnection();

		try {
			StandardResponse response = client.sendRequest(updateDataRequest);
			if (response.getStatus() == WebServiceResponseStatus.Error) {
				System.out.println(response.getErrorMessage());
			} else {
				return true;

			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.SOAPWebService#getAllPriceLists()
	 */
	@Override
	public List<PriceList> getAllPriceLists() {
		List<PriceList> priceLists=new ArrayList<PriceList>();
		QueryDataRequest queryDataRequest = new QueryDataRequest();
		queryDataRequest.setWebServiceType("QueryAllPriceLists");
		queryDataRequest.setLogin(getLogin());
		/* queryDataRequest.setLimit(3); */

		/* dataRow.addField("Name", "%Store%"); */

		WebServiceConnection client = getConnection();

		try {
			WindowTabDataResponse response = client.sendRequest(queryDataRequest);

			if (response.getStatus() == WebServiceResponseStatus.Error) {
				System.out.println(response.getErrorMessage());
			} else {
				for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
					PriceList priceList = new PriceList();
					for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {

						Field field = response.getDataSet().getRow(i).getFields().get(j);
						if (field.getColumn().equalsIgnoreCase("Name"))
							priceList.setName(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("Description"))
							priceList.setDescription(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("IsSOPriceList"))
							priceList.setIsSalesPriceList(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("IsActive"))
							priceList.setIsActive(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("M_PriceList_ID"))
							priceList.setPriceListId(field.getStringValue());
						/*else if (field.getColumn().equalsIgnoreCase("C_Currency_ID_Currency"))
							category.setIsActive(field.getStringValue());
						else if (field.getColumn().equalsIgnoreCase("IsActive"))
							category.setIsActive(field.getStringValue());*/
							
						
							
							
					}
					priceLists.add(priceList);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		return priceLists;
	}

	/* (non-Javadoc)
	 * @see com.ecommerce.service.SOAPWebService#getAllProducts()
	 */
	@Override
	public Set<Product> getAllProducts() {
		// TODO Auto-generated method stub

				Set<Product> allProducts = new HashSet<Product>();
				QueryDataRequest queryDataRequest = new QueryDataRequest();
				queryDataRequest.setWebServiceType("GetAllProducts");
				queryDataRequest.setLogin(getLogin());

				DataRow dataRow = new DataRow();
				dataRow.addField("M_PriceList_Version_ID", pricelistVersion);


				queryDataRequest.setDataRow(dataRow);

				WebServiceConnection client = getConnection();

				try {
					WindowTabDataResponse response = client.sendRequest(queryDataRequest);
					if (response.getStatus() == WebServiceResponseStatus.Error) {
						System.out.println(response.getErrorMessage());
					} else {

						for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
							Product product = new Product();
							Set<AttributeValue> attributes = new HashSet<>();
							for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {

								Field field = response.getDataSet().getRow(i).getFields().get(j);
								if (field.getColumn().equalsIgnoreCase("Name"))
									product.setName(field.getStringValue());
								else if (field.getColumn().equalsIgnoreCase("Value"))
									product.setValue(field.getStringValue());
								else if (field.getColumn().equalsIgnoreCase("M_Product_ID"))
									product.setProductID(field.getStringValue());
								else if (field.getColumn().equalsIgnoreCase("Logo_ID"))
									product.setLogoID(field.getStringValue());
								
								else if (field.getColumn().equalsIgnoreCase("IsActive"))
									product.setIsActive(field.getStringValue());
								else if (field.getColumn().equalsIgnoreCase("M_Product_Category_ID"))
									product.setCategoryId(field.getStringValue());
								
								
								else if (field.getColumn().equalsIgnoreCase("PriceList"))
									product.setPriceList(
											Double.valueOf(field.getStringValue().isEmpty() ? "0" : field.getStringValue()));
								else if (field.getColumn().equalsIgnoreCase("ProductAttribute")
										|| field.getColumn().equalsIgnoreCase("InstanceAttribute")) {

									String[] tokensVal = field.getStringValue().split("_");

									for (String string : tokensVal) {
										AttributeValue attribute = new AttributeValue();
										attribute.setValue(string);
										attributes.add(attribute);
									}
									product.setAttributes(attributes);
								} else if (field.getColumn().equalsIgnoreCase("DocumentNote"))
									product.setDocumentNote(field.getStringValue());
								else if (field.getColumn().equalsIgnoreCase("sum"))
									product.setInventoryQty(
											Double.valueOf(field.getStringValue().isEmpty() ? "0" : field.getStringValue()));
								else if (field.getColumn().equalsIgnoreCase("PriceStd"))
									product.setPriceStd(
											Double.valueOf(field.getStringValue().isEmpty() ? "0" : field.getStringValue()));

							}
							if (!allProducts.add(product)) {
								for (Product products : allProducts) {
									if (products.equals(product)) {
										if (products.getAttributes() != null && product.getAttributes() != null) {
											Set<AttributeValue> attributes2 = new HashSet<>();
											attributes2.addAll(products.getAttributes());
											attributes2.addAll(product.getAttributes());
											products.setAttributes(attributes2);
										} else if (product.getAttributes() != null)
											products.setAttributes(product.getAttributes());

										products.setInventoryQty(products.getInventoryQty() + product.getInventoryQty());
									}

								}

							}
							product.setDiscount(setProductDiscount(product));
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("All Products" + allProducts);
				return allProducts;
	}


}
// GetAllUsers