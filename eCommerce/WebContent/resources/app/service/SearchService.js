'use strict';

App.factory(
		'SearchService',
		[
				'$http',
				'$q',
				function($http, $q) {

					return {

						getSearchProduct : function(name) {
							console.log("In SearCh Service");
							return $http
									.get(
											'http://localhost:8089/eCommerce/category/search/' + name)
									.then(
											function(response) {
												console.log("Got the response")
												console.log(response.data)
												return response.data;
											},
											function(errResponse) {
												console.error('Error while fetching Items');
												return $q.reject(errResponse);
											});
						}
					}
				} ]);
