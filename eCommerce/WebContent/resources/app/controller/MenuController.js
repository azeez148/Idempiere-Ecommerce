'use strict';

angular.module('app').controller('MenuController',
		function($scope, $http, $state, $rootScope, SearchService,$filter,CategoryService,CartService) {
	
	
	
	// document.getElementById("spinner").style.display = "block";
	
	
	
			console.log('in MenuController');
			$scope.categoryList = [];
			$rootScope.cartSize =0;
			$scope.items = [];
			$scope.adminScreenList =[];
			
			
			
			
			$scope.getCategories = function() {
				CategoryService.getCategories().then(
						function(response) {
							console.log(response);
							$scope.categoryList = response;
							console.log($scope.categoryList.length);
							
						}, function(errResponse) {
							alert('error while Deleting in..');
						});

				/**/
			};

			
			
			$scope.getAdminScreens = function() {
				CategoryService.getAdminScreens().then(
						function(response) {
							console.log(response);
							$scope.adminScreenList = response;
							console.log($scope.adminScreenList.length);
						}, function(errResponse) {
							alert('error while Deleting in..');
						});
			};
			
			
			
			$scope.searchProduct = function(path, query) {

				// $location.path(path);
				if (query) 
				{
					$state.go('app.search', {name : query});	  
				}
				/**/
			};
			
	/*		$scope.items = CartService.addItemToCart(0,0).then(
						function(response) {
							console.log("in getCartSize");
							console.log(response);
							$rootScope.cartSize=response.length;
							console.log("response.length"+response.length);	
						}, function(errResponse) {
							alert('error while Deleting in..');
						});*/
			
			$scope.reloadHome = function() {

				$state.go('app.home', {}, {reload: true});
					  
			
			};
			$scope.getCartSize = function(userId) {

				 CartService.addItemToCart(0,userId).then(
							function(response) {
								console.log("in getCartSize");
								console.log(response);
								$rootScope.cartSize=response.length;
								console.log("response.length"+response.length);	
							}, function(errResponse) {
								alert('error while Deleting in..');
							});
					  
			
			};
			
			
		});
