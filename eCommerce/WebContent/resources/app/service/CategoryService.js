'use strict';

App
		.factory(
				'CategoryService',
				[
						'$http',
						'$q',
						function($http, $q) {

							return {
								fetchAllProducts : function(categoryId) {
									console.log('inservice'+categoryId);
									return $http
											.get(
													'http://localhost:8089/eCommerce/category/cat/'
															+ categoryId)
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
								getCategories : function() {
									return $http
											.get(
													'http://localhost:8089/eCommerce/main/categories/'
															)
											.then(
													function(response) {
													
														return response.data;
													},
													function(errResponse) {
														console
																.error('Error while fetching specific Item');
														return $q
																.reject(errResponse);
													});
								},	getCategoryById : function(categoryId) {
									console.log('getCategoryById'+categoryId);
									return $http
									.get(
											'http://localhost:8089/eCommerce/category/category/'+categoryId
													)
									.then(
											function(response) {
											
												return response.data;
											},
											function(errResponse) {
												console
														.error('Error while fetching specific Item');
												return $q
														.reject(errResponse);
											});
						},
						getAdminScreens : function() {
							return $http
									.get(
											'http://localhost:8089/eCommerce/admin/categories/'
													)
									.then(
											function(response) {
											
												return response.data;
											},
											function(errResponse) {
												console
														.error('Error while fetching specific Item');
												return $q
														.reject(errResponse);
											});
						}
								
								
								
								
								
								
								
								
								
								
								/*getIndex : function(category) {
									return $http
											.get(
													'http://localhost:8089/eCommerce/item/'
															+ category)
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
								fetchAllItems : function(category) {
									return $http
											.get(
													'http://localhost:8080/eCommerce/item/'
															+ category)
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

								fetchSpecificItem : function(category, id) {
									return $http
											.get(
													'http://localhost:8080/eCommerce/item/'
															+ category + '/'
															+ id)
											.then(
													function(response) {
														$("#comm").hide();
														return response.data;
													},
													function(errResponse) {
														console
																.error('Error while fetching specific Item');
														return $q
																.reject(errResponse);
													});
								}*/
								
							};

						} ]);
