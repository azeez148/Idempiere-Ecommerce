'use strict';

angular
		.module('app')
		.controller(
				'PriceListController',
				[
						'$scope',
						'async',
						'$rootScope',
						'ProductCategoryService',
						'$filter',
						function($scope, async, $rootScope,
								ProductCategoryService, $filter) {
							console.log(async);
							$scope.pdtCategories = async;

							$scope.createdSuccessMsg = null;
							$scope.createdErrorMsg = null;
							$scope.nameErrorMsg = null;
							$scope.mobileErrorMsg = null;
							$scope.passwordErrorMsg = null;
							$scope.emailErrorMsg = null;

							// var self = this;
							$scope.category = {
								categoryID : '',
								name : '',
								parentID : '',
								parentName : '',
								isActive : '',

							};

							$scope.states = [];
							$scope.cities = [];

							// init
							$scope.sort = {
								sortingOrder : 'name',
								reverse : false
							};

							$scope.gap = 1;

							$scope.filteredItems = [];
							$scope.groupedItems = [];
							$scope.itemsPerPage = 10;
							$scope.pagedItems = [];
							$scope.currentPage = 1;
							$scope.items = $scope.pdtCategories;
							$scope.itemsSize = $scope.items.length;
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

							$scope.openCreateModal = function() {
								resetMessages();
								console.log('in openCreateModal')
								$scope.categories = $scope.pdtCategories;
								$('#createCategory').modal('show');

							};

							$scope.submitCategory = function(category) {
								console.log('in submitCategory');
								//console.log('category is '+$scope.category.name);

								//$scope.categories = $scope.pdtCategories;
								//$('#createCategory').modal('show');
								category.parentID = category.parentID.categoryID
								console.log('category is ' + category.name);
								console.log('category parent is '
										+ category.parentID)
								createCategory(category);
							};

							function createCategory(category) {
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
												},
												function(errResponse) {
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
									isActive : ''
								};
								$scope.createCategoryForm.$setPristine(); // reset Form
							}

							$scope.openUpdateModal = function(item) {
								resetMessages();
								console.log('in openCreateModal' + item)
								$scope.categories = $scope.pdtCategories;
								$scope.category = {
									categoryID : item.categoryID,
									name : item.name,
									parentID : item.parentID,
									parentName : item.parentName,
									isActive : ''
								};

								/* $scope.data = {
									     availableOptions: $scope.categories,
									     selectedOption: {id: item.parentID, name: item.name} //This sets the default value of the select in the ui
									     };
								 */

								$('#updateCategory').modal('show');

							};

							$scope.updateCategory = function(category) {
								console.log('in updateCategory');

								//category.parentID=category.parentID.categoryID
								console.log('category is ' + category.name);
								console.log('current category parent is '
										+ category.parentName);
								console.log('new category parent is '
										+ category.parentID.categoryID);

								category.parentID = category.parentID.categoryID

								if (category.parentID != undefined) {

									updateCategory(category);
								} else if (category.parentName == null) {
									updateCategory(category);
								} else {
									updateCategory(category);
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
												},
												function(errResponse) {
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
									isActive : item.isActive
								};

								$('#blockCategory').modal('show');
							}

							$scope.updateCategoryStatus = function(category) {

								/*	$scope.category = {
											categoryID : item.categoryID,
											name : item.name,
											parentID : item.parentID,
											parentName :item.parentName,
											isActive : item.isActive
									};*/

								console.log('in updateUserStatus user '
										+ category.name);

								updateStatus(category);

							}

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
												},
												function(errResponse) {
													$scope.updateErrorMsg = "Category Updation Failed.";
													//alert('error while updateUserStatus ..');
												});
							}
							;
							function resetMessages() {
								$scope.createdSuccessMsg = null;
								$scope.createdErrorMsg = null;
								$scope.nameErrorMsg = null;
								$scope.mobileErrorMsg = null;
								$scope.passwordErrorMsg = null;
								$scope.emailErrorMsg = null;
							};
						} ]);
