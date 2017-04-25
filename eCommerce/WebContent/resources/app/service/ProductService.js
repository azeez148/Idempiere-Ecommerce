'use strict';

App
		.factory(
				'ProductService',
				[
						'$http',
						'$q',
						function($http, $q) {
							
							return {
								getProductById : function(productId) {
									console.log('in service ProductService  '+productId);
									return $http
											.get(
													/*'http://ec2-52-36-79-151.us-west-2.compute.amazonaws.com:8089/eCommerce/item/cart/'*/
													'http://localhost:8089/eCommerce/product/pdt/'
															+ productId)
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
