'use strict';

App
		.factory(
				'AdminProductService',
				[
						'$http',
						'$q',
						function($http, $q) {

							return {
								fetchAllProducts : function() {
									console.log('in AdminProductService --- fetchAllProducts');
									
									return $http
											.get(
													'http://localhost:8089/eCommerce/admin/products/allProducts')
											.then(
													function(response) {
														return response.data;
													},
													function(errResponse) {
														console
																.error('Error while fetching Items');
														return $q
																.reject(errResponse);
													});
								
								},
								createCategory : function(category) {
									console.log('in ProductCategoryService --- createCategory'+category);
									return $http
											.post(
													'http://localhost:8089/eCommerce/admin/category/create',category)
											.then(
													function(response) {
														return response.data;
													},
													function(errResponse) {
														console
																.error('Error while fetching Items');
														return $q
																.reject(errResponse);
													});
								
								},
								updateCategory : function(category) {
									console.log('in ProductCategoryService --- updateCategory');
									return $http
											.post(
													'http://localhost:8089/eCommerce/admin/category/update',category)
											.then(
													function(response) {
														return response.data;
													},
													function(errResponse) {
														console
																.error('Error while fetching Items');
														return $q
																.reject(errResponse);
													});
								
								},
								updateCategoryStatus : function(category) {
									console.log('in ProductCategoryService --- updateCategoryStatus');
									return $http
											.post(
													'http://localhost:8089/eCommerce/admin/category/update/status',category)
											.then(
													function(response) {
														return response.data;
													},
													function(errResponse) {
														console
																.error('Error while fetching Items');
														return $q
																.reject(errResponse);
													});
								
								},
								getVendors : function() {
									console.log('in ProductCategoryService --- getVendors');
									return $http
									.get(
											'http://localhost:8089/eCommerce/admin/category/allcategories')
									.then(
											function(response) {
												return response.data;
											},
											function(errResponse) {
												console
														.error('Error while fetching Items');
												return $q
														.reject(errResponse);
											});
								
								},
								
							};

						} ]);
