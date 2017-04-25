'use strict';

App
		.factory(
				'CartService',
				[
						'$http',
						'$q',
						function($http, $q) {
							
							return {
								addItemToCart : function(productId,userId) {
									console.log('in service PRODUCT  '+productId +' USER '+userId);
									return $http
											.get(
													/*'http://ec2-52-36-79-151.us-west-2.compute.amazonaws.com:8089/eCommerce/item/cart/'*/
													'http://localhost:8089/eCommerce/cart/cart/'
															+ productId +'/'+userId)
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
								removeItemsFromCart : function(cartId,productId,userId) {
									console.log('in service  cart '+cartId +' PRODUCT '+productId +' USER '+userId);
									return $http
											.get(
													'http://localhost:8089/eCommerce/cart/cart/del/'+ cartId +'/'+ productId +'/'+ userId)
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
								updateCart : function(cartId,qty) {
									console.log('in service updateCart  '+cartId +' qty '+qty);
									return $http
											.get(
													/*'http://ec2-52-36-79-151.us-west-2.compute.amazonaws.com:8089/eCommerce/item/cart/'*/
													'http://localhost:8089/eCommerce/cart/updateCart/'
															+cartId+"/"+qty)
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
