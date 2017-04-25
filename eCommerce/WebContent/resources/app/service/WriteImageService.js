'use strict';

App.factory(
		'WriteImageService',
		[
				'$http',
				'$q',
				function($http, $q) {

					return {

						getImage : function() {
							console.log("In Hot");
							return $http
									.get(
											'http://localhost:8089/eCommerce/main/image')
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
