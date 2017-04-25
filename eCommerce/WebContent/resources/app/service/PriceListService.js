'use strict';

App
		.factory(
				'PriceListService',
				[
						'$http',
						'$q',
						function($http, $q) {

							return {
								fetchAllPriceLists : function() {
									console.log('in PriceListService --- fetchAllPriceLists');
									
									return $http
											.get(
													'http://localhost:8089/eCommerce/admin/pricelist/pricelists')
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
								createCategory : function(pricelist) {
									console.log('in ProductCategoryService --- createCategory');
									return $http
											.post(
													'http://localhost:8089/eCommerce/admin/pricelist/create',pricelist)
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
													'http://localhost:8089/eCommerce/admin/pricelist/update',category)
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
													'http://localhost:8089/eCommerce/admin/pricelist/update/status',category)
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
