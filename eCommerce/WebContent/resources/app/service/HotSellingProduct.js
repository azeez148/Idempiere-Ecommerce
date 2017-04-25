'use strict';

App.factory(
		'HotSellingProduct',
		[
				'$http',
				'$q',
				function($http, $q) {

					return {

						getHotSellingProduct : function() {
							console.log("In Hot");
							return $http
									.get(
											'http://localhost:8089/eCommerce/main/hotSellingProducts')
									.then(
											function(response) {
												return response.data;
											},
											function(errResponse) {
												console.error('Error while fetching Items');
												return $q.reject(errResponse);
											});
						}
					}
				} ]);
