'use strict';

angular
		.module('app')
		.controller(
				'CartController',
				[
						'$scope',
						'async',
						'$filter',
						'CartService',
						'$rootScope','$window',
						function($scope, async, $filter, CartService, $rootScope,$window) {
							console.log('in CartController ' + async);

							$scope.items = [];
							$scope.sortingOrder = sortingOrder;
							$scope.reverse = false;
							$scope.filteredItems = [];
							$scope.groupedItems = [];
							$scope.itemsPerPage = 5;
							$scope.pagedItems = [];
							$scope.currentPage = 0;
							$scope.items = async;
							$scope.cartListSize =0; 
							$rootScope.cartSize = 0;
								
							 $scope.orderSum=0;
							 $scope.shippingCharge=0;
							 $scope.taxAmount=0;
							 $scope.orderTotal=0;
							
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
								$scope.currentPage = 0;
								$scope.cartListSize=$scope.items.length;
								$rootScope.cartSize = $scope.items.length;
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

							$scope.deleteProductFromCart = function(cartId,
									productId, userId, index) {
								
								console.log("Do it, and value is " + cartId
										+ "pdt" + productId + "user" + userId + "index is"+index);
								CartService.removeItemsFromCart(cartId,
										productId, userId).then(
										function(response) {
											console.log(response);
										//	$scope.items = response;
											$scope.items.splice(index, 1);
											console.log($scope.items.length);
											$scope.search();
											$scope.getSum();
											$scope.getTotal($scope.orderSum,$scope.shippingCharge,$scope.taxAmount);
							
										}, function(errResponse) {
											alert('error while Deleting in..');
										});
							};
							
							$scope.getSum = function() {
								console.log("in sum");
								$scope.orderSum=0;
								 angular.forEach($scope.items, function(value, key){
									
							         if(value.product.priceStd != 0 )
							        	 {
							          
							         $scope.orderSum=$scope.orderSum+(value.product.priceStd * value.quantity);
							         console.log("amount"+value.price);
							         console.log($scope.orderSum);
							        	 }
							         });
							};
							$scope.getTotal=function(orderSum,shippingCharge,taxAmount) {
								$scope.orderTotal=0;
								console.log("in getTotal");
								//$scope.shippingCharge=50;
								var totalAddition=shippingCharge+taxAmount;
								console.log("totalAddition" +totalAddition);
								
								console.log("$scope.orderSum" +$scope.orderSum);
								 $scope.orderTotal=$scope.orderSum+totalAddition;
								
							};
								
							$scope.getPreviousPage=function() {
								console.log("in getPreviousPage");
								 $window.history.back();
							};
							
							$scope.updateSum=function(sum) {
								$scope.orderSum=0;
								console.log("order summm "+$scope.orderSum);

								
							 angular.forEach($scope.items, function(value, key){
					
								 $scope.orderSum=$scope.orderSum+(value.product.priceStd * value.quantity);
						         console.log("quantity"+value.quantity);
						         CartService.updateCart(value.cartId,value.quantity).then(
											function(response) {
												console.log(response);
												//$rootScope.cartSize = response.length;

											},
											function(errResponse) {
												alert('error while updateCart ..');
											});
						     	
						         });
							 $scope.getTotal($scope.orderSum,$scope.shippingCharge,$scope.taxAmount);
						};
								
								
						
						} ]);