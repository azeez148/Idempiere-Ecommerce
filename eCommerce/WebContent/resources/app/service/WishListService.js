'use strict';

App
		.factory(
				'WishListService',
				[
						'$http',
						'$q',
						function($http, $q) {
							
							return {
								addItemToList : function(productId,userId) {
									console.log("In WishList" + productId + "___" + userId)
									return $http
											.get(
													/*'http://ec2-52-36-79-151.us-west-2.compute.amazonaws.com:8089/eCommerce/item/cart/'*/
													'http://localhost:8089/eCommerce/wish/wish/'
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
								removeItemsFromList : function(wishListId,productId,userId) {
									return $http
											.get(
													'http://nestit-iso-171:8089/eCommerce/wish/wish/del/'+ wishListId +'/'+ productId +'/'+ userId)
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
