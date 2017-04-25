'use strict';

App
		.factory(
				'AdminUserService',
				[
						'$http',
						'$q',
						function($http, $q) {

							return {
								fetchAllUsers : function() {
									console.log('in AdminUserService --- fetchAllUsers');
									
									return $http
											.get(
													'http://localhost:8089/eCommerce/admin/category/users')
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
								updateUserStatus : function(user) {
									console.log('in AdminUserService  == updateVendorStatus'+user);
									return $http
											.post(
													/*'http://ec2-52-36-79-151.us-west-2.compute.amazonaws.com:8089/eCommerce/item/cart/'*/
													'http://localhost:8089/eCommerce/admin/user/update/status',user)
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
								updateVendor : function(user) {
									console.log('in AdminUserService --- updateVendor');
									return $http
											.post(
													'http://localhost:8089/eCommerce/admin/vendor/update',user)
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
								updateVendorStatus : function(user) {
									console.log('in AdminUserService  == updateVendorStatus');
									return $http
											.post(
													/*'http://ec2-52-36-79-151.us-west-2.compute.amazonaws.com:8089/eCommerce/item/cart/'*/
													'http://localhost:8089/eCommerce/admin/vendor/update/status',user)
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
								sendEmail : function(email) {
									console.log('in AdminUserService  == sendEmail');
									return $http
											.post(
													/*'http://ec2-52-36-79-151.us-west-2.compute.amazonaws.com:8089/eCommerce/item/cart/'*/
													'http://localhost:8089/eCommerce/admin/vendor/email',email)
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
