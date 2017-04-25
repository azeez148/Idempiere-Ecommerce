'use strict';

angular
		.module('app')
		.controller(
				'ProductCategoryController',
				[
						'$scope',
						'$rootScope',
						'ProductCategoryService',
						'$filter',
						'AdminVendorService',
						function($scope, $rootScope,
								ProductCategoryService, $filter,
								AdminVendorService) {

							//showLoading();

						//	ProductCategoryService.fetchAllProductCategories();
							$scope.createdSuccessMsg = null;
							$scope.createdErrorMsg = null;
							$scope.nameErrorMsg = null;
							$scope.mobileErrorMsg = null;
							$scope.passwordErrorMsg = null;
							$scope.emailErrorMsg = null;
							
							$scope.pdtCategories =[];
							 $scope.items = [];
							 $scope.result = [];
								$scope.selectedVendors = [];
								
								$scope.itemsPerPageList = [];

								$scope.states = [];
								$scope.cities = [];
								
								// $scope.selectedCategory = [];
								// var self = this;
								$scope.category = {
									categoryID : '',
									name : '',
									parentID : '',
									parentName : '',
									isActive : '',
									vendorMappers : ''
								};
							
							$scope.getAllProductCategories = function() {
								showLoading();
								fetchAllProductCategories();
						    };
						    
						    function fetchAllProductCategories() {
						    	ProductCategoryService.fetchAllProductCategories().then(
										function(response) {
											console.log("getAllUsers "+response);
											$scope.pdtCategories = response;
											// $scope.search();
											 $scope.gap = 3;
											    
												$scope.filteredItems = [];
												$scope.groupedItems = [];
												$scope.itemsPerPage = 10;
												$scope.pagedItems = [];
												$scope.currentPage = 1;
												$scope.items = $scope.pdtCategories;
												$scope.itemsSize = $scope.items.length;
											 
												  $scope.search();
												  hideLoading();
										},
										function(errResponse) {
											
											$scope.users = null;
											console
													.error('Error while fetchAllUsers');
											hideLoading();

											
										});
							};
							
							//console.log(async);
						//	$scope.pdtCategories = async;
							//$scope.testing = 'selected';
							/*$scope.createdSuccessMsg = null;
							$scope.createdErrorMsg = null;
							$scope.nameErrorMsg = null;
							$scope.mobileErrorMsg = null;
							$scope.passwordErrorMsg = null;
							$scope.emailErrorMsg = null;*/
							/*$scope.result = [];
							$scope.selectedVendors = [];
							// $scope.selectedCategory = [];
							// var self = this;
							$scope.category = {
								categoryID : '',
								name : '',
								parentID : '',
								parentName : '',
								isActive : '',
								vendorMappers : ''
							};*/
							

							// init
							$scope.sort = {
								sortingOrder : 'name',
								reverse : false
							};

							//$scope.gap = 3;

						/*	$scope.filteredItems = [];
							$scope.groupedItems = [];
							$scope.itemsPerPage = 10;
							$scope.pagedItems = [];
							$scope.currentPage = 1;
							$scope.items = $scope.pdtCategories;
							$scope.itemsSize = $scope.items.length;*/
							var searchMatch = function(haystack, needle) {
								if (!needle) {
									return true;
								}
								return haystack.toLowerCase().indexOf(
										needle.toLowerCase()) !== -1;
							};

							// init the filtered items
							$scope.search = function() {

								$scope.filteredItems = $filter('filter')(
										$scope.items,
										function(item) {
											for ( var attr in item) {
												if (searchMatch(item[attr],
														$scope.query))
													return true;
											}
											return false;
										});
								// take care of the sorting order
								if ($scope.sort.sortingOrder !== '') {
									$scope.filteredItems = $filter('orderBy')(
											$scope.filteredItems,
											$scope.sort.sortingOrder,
											$scope.sort.reverse);
								}
								$scope.currentPage = 0;
								// now group by pages
								$scope.groupToPages();

								//hideLoading();
							};

							// calculate page in place
							$scope.groupToPages = function() {
								$scope.pagedItems = [];

								for (var i = 0; i < $scope.filteredItems.length; i++) {
									if (i % $scope.itemsPerPage === 0) {
										$scope.pagedItems[Math.floor(i
												/ $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
									} else {
										$scope.pagedItems[Math.floor(i
												/ $scope.itemsPerPage)]
												.push($scope.filteredItems[i]);
									}
								}
							};

							$scope.range = function(size, start, end) {
								var ret = [];
								console.log(size, start, end);

								if (size < end) {
									end = size;
									start = size - $scope.gap;
								}
								for (var i = start; i < end; i++) {
									ret.push(i);
								}
								console.log(ret);
								return ret;
							};

							$scope.prevPage = function() {
								if ($scope.currentPage > 0) {
									$scope.currentPage--;
								}
							};

							$scope.nextPage = function() {
								if ($scope.currentPage < $scope.pagedItems.length - 1) {
									$scope.currentPage++;
								}
							};

							$scope.setPage = function() {
								$scope.currentPage = this.n;
							};

							// functions have been describe process the data for display
							$scope.search();
							//$scope.selectedItemsPerPage=10;

							$scope.getItemsPerPage = function() {
								
								$scope.data = {
									availableOptions : [ {
										id : '1',
										name : '10'
									}, {
										id : '2',
										name : '25'
									}, {
										id : '3',
										name : '50'
									}, {
										id : '4',
										name : 'All'
									} ],
									selectedOption : {
										id : '1',
										name : '10'
									}
								//This sets the default value of the select in the ui
								};

							};

							$scope.updateItemsPerPage = function(selectedItem) {

								console.log('selectedItem' + selectedItem.id);

								if (selectedItem.id == '1') {
									$scope.itemsPerPage = 10;
								} else if (selectedItem.id == '2') {
									$scope.itemsPerPage = 25;

								} else if (selectedItem.id == '3') {
									$scope.itemsPerPage = 50;
								} else if (selectedItem.id == '4') {
									$scope.itemsPerPage = $scope.itemsSize;
								} else {
									$scope.itemsPerPage = 10;
								}
								
								$scope.search();
							};

							$scope.openCreateModal = function() {
								$scope.category = {
									categoryID : '',
									name : '',
									parentID : '',
									parentName : '',
									isActive : '',
									vendorMappers : ''
								};
								resetMessages();

								//$scope.getVendors();

								console.log('in openCreateModal')
								$scope.categories = $scope.pdtCategories;

								$('#createCategory').modal('show');

							};

							$scope.submitCategory = function(category) {

								showLoading();

								console.log('in submitCategory');
								console.log('in selected ' + $scope.selected);

								var stringToSplit = $scope.selected;

								console.log(' stringToSplit ' + stringToSplit);

								if (category.parentID.categoryID != undefined) {
									category.parentID = category.parentID.categoryID;

								} else {
									category.parentID = null;
								}

								//category.vendorMappers=$scope.selected;

								$scope.tempVendorMappers = $scope.selected;
								category.vendorMappers = [];

								angular.forEach($scope.tempVendorMappers,
										function(value, key) {

											category.vendorMappers
													.push(value.userId);

										});

								console.log('category is ' + category.name);
								console.log('category parent is '
										+ category.parentID);
								console.log('category vendorId is '
										+ category.vendorId);
								createCategory(category);
							};

							function createCategory(category) {
								console.log('in createCategory');

								ProductCategoryService
										.createCategory(category)
										.then(
												function(response) {
													console.log(response);
													reset();
													$('#createCategory').modal(
															'hide');
													$scope.items = response;
													$scope.createdSuccessMsg = "Category created successfully..";
													$scope.itemsSize = $scope.items.length;
													$scope.search();

													hideLoading();
												},
												function(errResponse) {

													hideLoading();
													console
															.error('Error while creating Category');

													$scope.createdErrorMsg = "Category Creation Failed.. Please Try Again.."
												});
							}
							;

							$scope.resetPage = function() {
								reset();
							};

							function reset() {
								$scope.category = {
									categoryID : '',
									name : '',
									parentID : '',
									parentName : '',
									isActive : '',
									vendorMappers : ''
								};
								$scope.selected = '';
								$scope.createCategoryForm.$setPristine(); // reset Form
							}

							$scope.openUpdateModal = function(item) {
								resetMessages();
								console.log('in openCreateModal' + item);
								//$scope.getVendors();
								$scope.category = {
									categoryID : item.categoryID,
									name : item.name,
									parentID : item.parentID,
									parentName : item.parentName,
									isActive : '',
									vendorMappers : item.vendorMappers

								};

								$scope.categories = $scope.pdtCategories;

								angular
										.forEach(
												$scope.categories,
												function(value, key) {

													if ($scope.category.parentID == value.categoryID) {

														return $scope.selectedCategory = value;

													} else {
														return false;
													}

												});

								angular
										.forEach(
												$scope.category.vendorMappers,
												function(value, key) {
													angular
															.forEach(
																	$scope.vendors,
																	function(
																			value1,
																			key1) {

																		if (value == value1.userId) {
																			var index = arrayObjectIndexOf(
																					$scope.vendors,
																					value1);
																			return $scope.selectedVendors
																					.push($scope.vendors[index]);
																		} else {
																			return false;
																		}

																	});

												});
								console.log('$scope.selectedVendors'
										+ $scope.selectedVendors);

								$('#updateCategory').modal('show');

							};

							$scope.getVendors = function() {
								AdminVendorService
										.fetchAllVendors(
												$rootScope.globals.currentUser.userId)
										.then(
												function(response) {
													console.log("response "
															+ response);

													$scope.vendors = response;

												},
												function(errResponse) {
													console
															.error('Error while creating Category');

													$scope.createdErrorMsg = "Category Creation Failed.. Please Try Again.."
												});
							};

							function arrayObjectIndexOf(arr, obj) {
								for (var i = 0; i < arr.length; i++) {
									if (angular.equals(arr[i], obj)) {
										return i;
									}
								}
								;
								return -1;
							}
							;

							$scope.updateCategory = function(item) {
								console.log('in updateCategory' + item);
								showLoading();

								$scope.category = {
									categoryID : item.categoryID,
									name : item.name,
									parentID : item.parentID,
									parentName : item.parentName,
									isActive : '',
									vendorMappers : item.vendorMappers.userId

								};

								console.log('selectedCategory is '
										+ $scope.selectedCategory);

								console.log('category is '
										+ $scope.category.name);
								console.log('current category parent is '
										+ $scope.selectedCategory.name);
								console.log('new category parent is '
										+ $scope.selectedCategory.categoryID);

								$scope.category.parentID = $scope.selectedCategory.categoryID

								$scope.tempVendorMappers = $scope.selectedVendors;
								$scope.category.vendorMappers = [];

								angular.forEach($scope.tempVendorMappers,
										function(value, key) {

											$scope.category.vendorMappers
													.push(value.userId);

										});

								if ($scope.category.parentID != undefined) {

									updateCategory($scope.category);
								} else if ($scope.category.parentName == null) {
									updateCategory($scope.category);
								} else {
									updateCategory($scope.category);
								}

							};

							function updateCategory(category) {
								ProductCategoryService
										.updateCategory(category)
										.then(
												function(response) {
													console.log(response);
													reset();
													$('#updateCategory').modal(
															'hide');
													$scope.items = response;
													$scope.createdSuccessMsg = "Category updated successfully..";
													$scope.itemsSize = $scope.items.length;
													$scope.search();

													hideLoading();
												},
												function(errResponse) {

													hideLoading();
													console
															.error('Error while updating Category');

													$scope.createdErrorMsg = "Category Updation Failed.. Please Try Again.."
												});
							}
							;

							$scope.openModal = function(item) {
								resetMessages();
								console.log('item name is ' + item.name);

								console
										.log('item isActive is '
												+ item.isActive);

								$scope.category = {
									categoryID : item.categoryID,
									name : item.name,
									parentID : item.parentID,
									parentName : item.parentName,
									isActive : item.isActive,
									vendorMappers : item.vendorMappers.userId
								};

								$('#blockCategory').modal('show');
							}

							$scope.updateCategoryStatus = function(item) {

								showLoading();

								$scope.category = {
									categoryID : item.categoryID,
									name : item.name,
									parentID : item.parentID,
									parentName : item.parentName,
									isActive : item.isActive,
									vendorMappers : item.vendorMappers
								};

								console.log('in updateUserStatus user '
										+ $scope.category.name);

								updateStatus($scope.category);

							};

							function updateStatus(category) {
								ProductCategoryService
										.updateCategoryStatus(category)
										.then(
												function(response) {
													console.log(response);
													$('#blockCategory').modal(
															'hide');
													$scope.items = response;
													$scope.createdSuccessMsg = "Category updated successfully..";
													$scope.itemsSize = $scope.items.length;
													$scope.search();

													hideLoading();
												},
												function(errResponse) {
													$scope.updateErrorMsg = "Category Updation Failed.";

													hideLoading();
													//alert('error while updateUserStatus ..');
												});
							}
							;

							$('#createCategory').on('hidden.bs.modal',
									function(e) {
										reset();
										resetMessages();
									});
							$('#updateCategory').on('hidden.bs.modal',
									function(e) {
										reset();
										resetMessages();
									});
							$('#blockCategory').on('hidden.bs.modal',
									function(e) {
										reset();
										resetMessages();
									});

							function resetMessages() {
								$scope.createdSuccessMsg = null;
								$scope.createdErrorMsg = null;
								$scope.nameErrorMsg = null;
								$scope.mobileErrorMsg = null;
								$scope.passwordErrorMsg = null;
								$scope.emailErrorMsg = null;
								$scope.selectedCategory = '';
								$scope.selectedVendors = [];
							}
							;

							function disableButtons() {

								$('.create-button').prop('disabled', true);//disable
								$('.update-button').prop('disabled', true);//disable
								$('.status-button').prop('disabled', true);//disable
								$('.btn-primary').prop('disabled', true);//disable
								$('.btn-default').prop('disabled', true);//disable

							}
							;
							function enableButtons() {

								$('.create-button').prop('disabled', false);//disable
								$('.update-button').prop('disabled', false);//disable
								$('.status-button').prop('disabled', false);//disable
								$('.btn-primary').prop('disabled', false);//disable
								$('.btn-default').prop('disabled', false);//disable

							}
							;
							function showLoading() {

								$('#content').css('opacity', '.3');
								$('#dvLoading').show();

							}
							;

							function hideLoading() {
								$('#content').css('opacity', '1');
								$('#dvLoading').hide();
							}
							;
							// $(this).prop('disabled', true);//disable
						} ]);
