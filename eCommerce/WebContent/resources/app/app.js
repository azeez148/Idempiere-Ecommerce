'use strict';

var Apbp = angular.module('myApp',['ngRoute']);

Appb.config(['$routeProvider', function($routeProvider) {
	$routeProvider
	
	/*.when('/shop/index', {
		templateUrl: 'shop/index',
		controller : "ItemListController as itemListCtrl",
		resolve: {
            async: ['ItemService', function(ItemService) {
                return ItemService.getIndex('index');
           	}]
        }
	})	*/
	.when('/shop/tShirts', {
			templateUrl: 'shop/tShirts',
			controller : "ItemListController as itemListCtrl",
			resolve: {
                async: ['ItemService', function(ItemService) {
                    return ItemService.fetchAllItems('tShirts');
               	}]
            }
		})
		.when('/shop/home', {
			templateUrl: 'shop/home',
			controller : "ItemListController as itemListCtrl",
			resolve: {
                async: ['ItemService', function(ItemService) {
                    return ItemService.fetchAllItems('tShirts');
               	}]
            }
		})
		.when('/shop/phones', {
			templateUrl: 'shop/phones',
			controller : "ItemListController as itemListCtrl",
			resolve: {
                async: ['ItemService', function(ItemService) {
                    return ItemService.fetchAllItems('phones');
               	}]
            }
		})
		.when('/shop/printers', {
			templateUrl: 'shop/printers',
			controller : "ItemListController as itemListCtrl",
			resolve: {
                async: ['ItemService', function(ItemService) {
                    return ItemService.fetchAllItems('printers');
               	}]
            }
		})
		.when('/shop/computerdetails/:id', {
			templateUrl: 'shop/computerdetails',
			controller : "ItemDetailsController as itemDetailsCtrl",
			resolve: {
                async: ['ItemService','$route', function(ItemService , $route) {
                    return ItemService.fetchSpecificItem('computers',$route.current.params.id);
               	}]
            }
		})
		.when('/shop/phonedetails/:id', {
			templateUrl: 'shop/phonedetails',
			controller : "ItemDetailsController as itemDetailsCtrl",
			resolve: {
                async: ['ItemService','$route', function(ItemService , $route) {
                    return ItemService.fetchSpecificItem('phones',$route.current.params.id);
               	}]
            }
		})
		.when('/shop/printerdetails/:id', {
			templateUrl: 'shop/printerdetails',
			controller : "ItemDetailsController as itemDetailsCtrl",
			resolve: {
                async: ['ItemService','$route', function(ItemService , $route) {
                    return ItemService.fetchSpecificItem('printers',$route.current.params.id);
               	}]
            }
		})
		
		.otherwise({redirectTo:'/shop/index'});		
}]);

