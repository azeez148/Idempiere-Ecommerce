'use strict';

angular
		.module('app')
		.controller(
				'WishListController',
				[
						'$scope',
						'async',
						'$filter',
						'WishListService',
						'$rootScope',
						'$window',
						function($scope, async, $filter, WishListService,
								$rootScope, $window) {
							console.log('in WishListController ' + async);

							/*
							 * $scope.cartList=[];
							 * 
							 * 
							 * $scope.cartList=async; console.log("cartList
							 * "+$scope.cartList);
							 * $scope.wishListSize=$scope.cartList.length;
							 */
							$scope.items = [];
							$scope.sortingOrder = sortingOrder;
							$scope.reverse = false;
							$scope.filteredItems = [];
							$scope.groupedItems = [];
							$scope.itemsPerPage = 5;
							$scope.pagedItems = [];
							$scope.currentPage = 0;
							$scope.items = async;
							$scope.wishListSize = 0;
							$rootScope.wishListSize = 0;

							$scope.orderSum = 0;
							$scope.shippingCharge = 0;
							$scope.taxAmount = 0;
							$scope.orderTotal = 0;

							var searchMatch = function(haystack, needle) {
								if (!needle) {
									return true;
								}
								return haystack.toLowerCase().indexOf(
										needle.toLowerCase()) !== -1;
							};

							// init the filtered items
							$scope.search = function() {
								$scope.filteredItems = $filter('filter')($scope.items,function(item) {
											for ( var attr in item) {
												if (searchMatch(item[attr],$scope.query))
													return true;
											}
											return false;
										});
								// take care of the sorting order
								if ($scope.sortingOrder !== '') {
									$scope.filteredItems = $filter('orderBy')
											($scope.filteredItems,$scope.sortingOrder,$scope.reverse);
								}
								$scope.currentPage = 0;
								$scope.wishListSize = $scope.items.length;
								$rootScope.wishListSize = $scope.items.length;
								// now group by pages
								$scope.groupToPages();
							};

							// calculate page in place
							$scope.groupToPages = function() {
								$scope.pagedItems = [];

								for (var i = 0; i < $scope.filteredItems.length; i++) {
									if (i % $scope.itemsPerPage === 0) {
										$scope.pagedItems[Math.floor(i/ $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
									} else {
										$scope.pagedItems[Math.floor(i/ $scope.itemsPerPage)]
												.push($scope.filteredItems[i]);
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

							// functions have been describe process the data for
							// display
							$scope.search();

							// change sorting order
							$scope.sort_by = function(newSortingOrder) {
								if ($scope.sortingOrder == newSortingOrder)
									$scope.reverse = !$scope.reverse;

								$scope.sortingOrder = newSortingOrder;

								// icon setup
								$('th i').each(
										function() {
											// icon reset
											$(this).removeClass().addClass(
													'icon-sort');
										});
								if ($scope.reverse)
									$('th.' + new_sorting_order + ' i')
											.removeClass().addClass(
													'icon-chevron-up');
								else
									$('th.' + new_sorting_order + ' i')
											.removeClass().addClass(
													'icon-chevron-down');
							};

							$scope.deleteProductFromList = function(WishId,
									productId, userId, index) {

								console.log("Do it, and value is " + WishId
										+ "pdt" + productId + "user" + userId
										+ "index is" + index);
								WishListService.removeItemsFromList(WishId,	productId, userId)
									.then(
										function(response) {
											console.log(response);
											// $scope.items = response;
											$scope.items.splice(index, 1);
											console.log($scope.items.length);
											$scope.search();
										}, function(errResponse) {
											alert('error while Deleting in..');
										});
							};


							$scope.getPreviousPage = function() {
								console.log("in getPreviousPage");
								$window.history.back();
							};

						} ]);