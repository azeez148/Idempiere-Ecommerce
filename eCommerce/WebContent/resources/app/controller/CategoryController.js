'use strict';

angular
		.module('app')
		.controller(
				'CategoryController',
				[
						'$scope',
						'async',
						'$filter',
						'CategoryService',
						'$location',
						'CartService',
						'$rootScope',
						'AttributeService',
						'WishListService',
						function($scope, async, $filter, CategoryService,
								$location, CartService, $rootScope,
								AttributeService, WishListService) {
							console.log(async);
							$scope.categoryList = [];
							$scope.AttributeList = [];
							$scope.AttributeValuesList = [];
							$scope.temperoryItemsList = [];
							$scope.attributesForFilter = [];

							$scope.selectedAttributes = [];

							$scope.newSortingOrder = null;
							$scope.sortingOrder = sortingOrder;
							$scope.reverse = false;
							$scope.filteredItems = [];
							$scope.groupedItems = [];
							$scope.itemsPerPage = 16;
							$scope.pagedItems = [];
							$scope.currentPage = 0;
							$scope.items = async;
							$scope.productListSize = $scope.items.length;
							$scope.pageSize = $scope.itemsPerPage;
							$scope.itemsTemp = $scope.items;
							$scope.filteredItemssize = 0;
							$scope.productPriceList = [];
							$scope.productPriceListTemp = [];

							$scope.category = {
								categoryID : '',
								name : '',
								parentID : null,
								children : null
							}

							$scope.min = 0;
							$scope.max = 0;

							var interval = 100;
							var count;

							$scope.newValueMin = 0;
							$scope.newValueMax = 0;

							$scope.currentCategoryName = null;

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
								if ($scope.sortingOrder !== '') {

									$scope.filteredItems = $filter('orderBy')
											($scope.filteredItems,
													$scope.sortingOrder,
													$scope.reverse);
								}

								$scope.getMinMaxPrices();

								console.log('size is search 2'
										+ $scope.sortingOrder);
								$scope.currentPage = 0;
								// now group by pages
								$scope.groupToPages();

							};

							$scope.getMinMaxPrices = function() {
								console.log("getMinMaxPrices");
								angular.forEach($scope.items,
										function(product) {

											$scope.productPriceList
													.push(product.priceStd);

										});

								$scope.productPriceList.sort(function(a, b) {
									return a - b;
								});
								console.log('sorted array'
										+ $scope.productPriceList);
								$scope.productPriceListTemp = $scope.productPriceList;
								console.log('sorted array length'
										+ $scope.productPriceList.length);

								$scope.min = $scope.productPriceList[0];
								$scope.max = $scope.productPriceList[$scope.productPriceList.length - 1];

								console.log('$scope.min' + $scope.min);
								console.log('$scope.max' + $scope.max);

								// $scope.createRanges($scope.min,$scope.max);
							};

							$scope.createRanges = function(min, max) {

								for (i = min; i <= max; i + 200) {

								}
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
										/*
										 * console.log('$scope.pagedItems'+$scope.pagedItems.length);
										 */
									}

								}

							};

							$scope.range = function(start, end) {
								var ret = [];
								if (!end) {
									end = start;
									start = 0;
								}
								for (var i = start; i < end; i++) {
									ret.push(i);
								}
								return ret;
							};

							$scope.prevPage = function() {
								if ($scope.currentPage > 0) {
									$scope.currentPage--;
									$scope.pageSize = $scope.itemsPerPage;
								}
							};

							$scope.nextPage = function() {
								$scope.pageSize = $scope.pagedItems.length;

								if ($scope.currentPage < $scope.pagedItems.length - 1) {
									$scope.currentPage++;

								}
							};

							$scope.setPage = function() {
								$scope.currentPage = this.n;
							};

							// functions have been describe process the data for
							// display
							$scope.search();

							// change sorting order
							$scope.sort_by = function(newSortingOrder) {

								console.log('size is ' + newSortingOrder);
								if ($scope.sortingOrder == newSortingOrder) {
									return false;
								}
								// $scope.reverse = !$scope.reverse;
								if (newSortingOrder == 'PriceLTH') {
									$scope.sortingOrder = 'priceList';
									$scope.reverse = false;
								} else if (newSortingOrder == 'PriceHTL') {
									$scope.sortingOrder = 'priceList';
									$scope.reverse = true;
								} else if (newSortingOrder == 'NameASC') {
									$scope.sortingOrder = 'name';
									$scope.reverse = false;
								} else if (newSortingOrder == 'NameDSC') {
									$scope.sortingOrder = 'name';
									$scope.reverse = true;
								}

								$scope.search();
							};

							$scope.changePageSize = function(size) {
								console.log('size is ' + size);

								if (size == '0') {
									// $('.btn-all').addClass('active');
									$scope.itemsPerPage = $scope.productListSize;

								} else if (size >= $scope.items.length) {
									// $('.btn-all').addClass('active');
									$scope.itemsPerPage = $scope.productListSize;
								} else {
									// $('.btn-all').addClass('active');
									$scope.itemsPerPage = size;
								}

								$scope.pageSize = $scope.itemsPerPage;
								$scope.search();

							};

							$scope.getCategories = function() {

								CategoryService
										.getCategories()
										.then(
												function(response) {
													console.log(response);
													$scope.categoryList = response;
													var path = $location.path();

													var splittable = path
															.split('/');

													var catId = splittable[2];

													console
															.log("catId"
																	+ catId);
													$scope.categoryId = catId;

													/*
													 * angular.forEach($scope.categoryList,
													 * function(category) {
													 * angular.forEach($scope.categoryList,
													 * function(category) {
													 * angular.forEach($scope.categoryList,
													 * function(category) {
													 * console.log("category"+category);
													 * if(angular.equals(category.categoryID,$scope.categoryId)) {
													 * $scope.currentCategoryName=category.name; }
													 * }); }); });
													 */

												},
												function(errResponse) {
													alert('error while getCategories ..');
												});
							};

							$scope.getCategoryName = function() {

								var path = $location.path();

								var splittable = path.split('/');

								var catId = splittable[2];

								console.log("catId" + catId);
								$scope.categoryId = catId;

								// CategoryService
								CategoryService.getCategoryById(catId).then(
										function(response) {
											console.log(response);
											// $rootScope.cartSize =
											// response.length;
											$scope.category = response;

										}, function(errResponse) {
											alert('error while addToCart ..');
										});

							};

							$scope.addToCart = function(productID, userId) {

								console.log("Do it, and value is " + "pdt"
										+ productID + "user" + userId);
								CartService
										.addItemToCart(productID, userId)
										.then(
												function(response) {
													console.log(response);
													$rootScope.cartSize = response.length;

												},
												function(errResponse) {
													alert('error while addToCart ..');
												});
							};

							$scope.addToWishList = function(productID, userId) {

								console.log("Do it, and value is " + "pdt"
										+ productID + "user" + userId);
								WishListService
										.addItemToList(productID, userId)
										.then(
												function(response) {
													console.log(response);
													$rootScope.wishListSize = response.length;

												},
												function(errResponse) {
													alert('error while addToCart ..');
												});
							};
							$scope.getAttributes = function() {

								AttributeService
										.getAttributes()
										.then(
												function(response) {
													// console.log(response);
													$scope.AttributeList = response;

													console
															.log($scope.AttributeList);
												},
												function(errResponse) {
													alert('error while getAttributes ..');
												});
							};

							$scope.getAllProductsPriceList = function() {

								/*
								 * angular.forEach($scope.items,
								 * function(product) {
								 * 
								 * $scope.productPriceList
								 * .push(product.priceStd);
								 * 
								 * });
								 * 
								 * $scope.productPriceList.sort(function(a, b) {
								 * return a - b; }); console.log('sorted array' +
								 * $scope.productPriceList);
								 * $scope.productPriceListTemp=$scope.productPriceList;
								 * console.log('sorted array length' +
								 * $scope.productPriceList.length);
								 * 
								 * $scope.min = $scope.productPriceList[0];
								 * $scope.max =
								 * $scope.productPriceList[$scope.productPriceList.length -
								 * 1];
								 */

								$(function() {

									$("#slider-range")
											.slider(
													{
														range : true,
														min : $scope.min,
														max : $scope.max,
														values : [ $scope.min,
																$scope.max ],
														slide : function(event,
																ui) {
															
															$scope.min = ui.values[0];
															$scope.max = ui.values[1];

															console
																	.log('$scope.min'
																			+ $scope.min);
															console
																	.log('$scope.max'
																			+ $scope.max);
/*
															$scope.rangeInfo.min = $scope.min;
															$scope.rangeInfo.max = $scope.max;*/
															
															$("#amount")
																	.val(
																			"Rs:"
																					+ ui.values[0]
																					+ " - Rs:"
																					+ ui.values[1])
																	.change();
															console
																	.log('min'
																			+ ui.values[0]);
															console
																	.log('max'
																			+ ui.values[1]);
														
														}
													});
									$("#amount")
											.val(
													"Rs:"
															+ $("#slider-range")
																	.slider(
																			"values",
																			0)
															+ " - Rs:"
															+ $("#slider-range")
																	.slider(
																			"values",
																			1));
								});

							};

							$scope.updateAmount = function(price) {
								//console.log("in updateAmount " + price);

								$scope.rangeInfo.min = $scope.min;
								$scope.rangeInfo.max = $scope.max;
							};

							function sp(size, arr) { // size -
								// child_array.length
								var out = [], i = 0, n = Math.ceil((arr.length)
										/ size);
								while (i < n) {
									out.push(arr.splice(0, (i == n - 1)
											&& size < arr.length ? arr.length
											: size));
									i++;
									console.log('out' + out);
								}

								return out;
							}

							$scope.getChangedValue = function() {
								console.log('in getChangedValue');

							}

							$scope.rangeInfo = {

								min : $scope.min,
								max : $scope.max

							}

							$scope.setSelectedAttribute = function(
									attributeValue, isChecked) {
								console.log($scope.selectedAttributes
										.indexOf(attributeValue));
								if (isChecked
										&& $scope.selectedAttributes
												.indexOf(attributeValue) != 1)
									$scope.selectedAttributes
											.push(attributeValue);
								else if (!isChecked) {
									console.log("insdfgdf");
									var index = $scope.selectedAttributes
											.indexOf(attributeValue);
									$scope.selectedAttributes.splice(index, 1);
								}
							}

						} ]);

angular
		.module('app')
		.filter(
				'priceRange',
				function() {

					return function(pagedItems, rangeInfo,scope) {

						console.log("in priceRange");

						console.log("rangeInfo.min" + rangeInfo.min);
						console.log("rangeInfo.max" + rangeInfo.max);

						return pagedItems
								.filter(function(product) {

									return (product.priceStd >= rangeInfo.min && product.priceStd <= rangeInfo.max);
								});

					}
				});

angular
		.module('app')
		.filter(
				'attributeFilter',
				[ function() {
					return function(pagedItems, selectedAttributes, scope) {
						// console.log('price '+price);

						console.log('selectedAttributes'
								+ selectedAttributes.length);
						var count = 0;

						if (!angular.isUndefined(pagedItems)
								&& !angular.isUndefined(selectedAttributes)) {
							var tempClients = [];
							var tempMyClients = [];

							angular
									.forEach(
											pagedItems,
											function(product) {
												var flag = true;
												console
														.log('value lentgh'
																+ selectedAttributes.length);
												console
														.log('in attributeFilter $scope.newValueMin'
																+ scope.min);
												console
														.log('in attributeFilter $scope.newValueMmax'
																+ scope.max);
												/*
												 * if( product.priceStd >=
												 * scope.min && product.priceStd <=
												 * scope.max ) {
												 */

												angular
														.forEach(
																selectedAttributes,
																function(value) {
																	if (flag) {
																		flag = false;
																		var attributeValues = product.attributes;
																		console
																				.log("Product Attrbiite"
																						+ attributeValues);

																		console
																				.log("value"
																						+ value);

																		if (!angular
																				.isUndefined(attributeValues)) {

																			angular
																					.forEach(
																							attributeValues,
																							function(
																									attribute) {

																								if (!flag) {

																									if (angular
																											.equals(
																													attribute.value,
																													value)) {

																										flag = true;

																									}
																								}
																							});

																		}
																	}

																});

												if (flag) {

													if (tempClients
															.indexOf(product) == -1) {

														tempClients
																.push(product);
													}

												}

											});

							scope.filteredItemssize = tempClients.length;
							console.log('scope.filteredItemssize'
									+ scope.filteredItemssize);

							console.log('tempClients.length1 '
									+ tempClients.length);

							console.log('count in filter ' + count);

							return tempClients;

						} else {
							console.log('in else main');

							return pagedItems;
						}

					};
				} ]);
