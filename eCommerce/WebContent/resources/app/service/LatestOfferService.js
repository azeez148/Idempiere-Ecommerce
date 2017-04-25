'use strict';

App
		.factory(
				'LatestOfferService',
				[
						'$http',
						'$q',
						function($http, $q) {

							return {
								getLatestOfferDetails : function(id) {
									console.log('LatestOfferService'+id);
									return $http
											.get(
													'http://localhost:8089/eCommerce/main/latestOffer/'
															+ id)
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
				
								}
							}
						}
						 ]);
