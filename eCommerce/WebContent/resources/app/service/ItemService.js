'use strict';

App.factory('ItemService', ['$http', '$q', function($http, $q){

	return {
		
		getIndex: function(category) {
			return $http.get('http://localhost:8080/eCommerce/item/'+category)
					.then(
							function(response){
								return response.data;
							}, 
							function(errResponse){
								console.error('Error while fetching Items');
								return $q.reject(errResponse);
							}
					);
	},	
	fetchAllProducts: function(category) {
		console.log('inservice');
		return $http.get('http://localhost:8089/eCommerce/item/'+category)
				.then(
						function(response){
							return response.data;
						}, 
						function(errResponse){
							console.error('Error while fetching Items');
							return $q.reject(errResponse);
						}
				);
},
		fetchAllItems: function(category) {
					return $http.get('http://localhost:8080/eCommerce/item/'+category)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching Items');
										return $q.reject(errResponse);
									}
							);
			},
		    
			fetchSpecificItem: function(category,id) {
				return $http.get('http://localhost:8080/eCommerce/item/'+category+'/'+id)
						.then(
								function(response){
									 $("#comm").hide();
									return response.data;
								}, 
								function(errResponse){
									console.error('Error while fetching specific Item');
									return $q.reject(errResponse);
								}
						);
			}
	};

}]);
