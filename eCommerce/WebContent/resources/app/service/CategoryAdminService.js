'use strict';

App
		.factory(
				'CategoryAdminService',
				[
						'$http',
						'$q',
						function($http, $q) {
							
							return {
								fetchAllProductCategories : function() {
									console.log('in CategoryAdminService --- fetchAllProductCategories');
									
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
								createUser : function(user) {
									console.log('in RegistrationService ');
									return $http
											.post(
													/*'http://ec2-52-36-79-151.us-west-2.compute.amazonaws.com:8089/eCommerce/item/cart/'*/
													'http://localhost:8089/eCommerce/user/createUser',user)
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
								
								createVendor : function(user) {
									console.log('in RegistrationService ');
									return $http
											.post(
													/*'http://ec2-52-36-79-151.us-west-2.compute.amazonaws.com:8089/eCommerce/item/cart/'*/
													'http://localhost:8089/eCommerce/user/createVendor',user)
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
