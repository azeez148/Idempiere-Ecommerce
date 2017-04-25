// Code goes here

var App = angular.module('app', [ 'ui.router', 'ngCookies']);

App.config(function($stateProvider, $urlRouterProvider) {
	
	
	$urlRouterProvider.otherwise('/home');

	$stateProvider.state('app', {
		abstract : true,
		views : {
			header : {
				templateUrl : 'header',
				controller : 'LoginController'
			},
			nav : {
				templateUrl : 'nav',
				controller : 'MenuController as MenuCtrl'
			},
			'' : {
				templateUrl : 'content',
				controller : 'ContentController as Content',
				resolve : {
					async : [ 'WriteImageService', function(WriteImageService) {
						// $http returns a promise for the url data
						return WriteImageService.getImage();
					} ]
				}
			},

			footer : {
				templateUrl : 'footer',
				controller : 'FooterController as Footer'
			}

		}
	})

	.state('app.items', {
		url : '/items',
		templateUrl : 'items',
		controller : 'ItemsController as Items'
	})

	.state('app.home', {
		url : '/home',
		views : {
			'' : {
				templateUrl : 'home'
			},
			'latestOffers@app.home' : {
				templateUrl : 'home/latestOffers',
				controller : 'HomeController',
			},
			'hotSellingProducts@app.home' : {
				templateUrl : 'home/hotSellingProducts',
				controller : 'HotSellingProductController',
				resolve : {
						async : [ 'HotSellingProduct', function(HotSellingProduct) {
							// $http returns a promise for the url data
							return HotSellingProduct.getHotSellingProduct();
						} ]
					}
			},
			'upComingProducts@app.home' : {
				templateUrl : 'home/upComingProducts',
				controller : 'UpComingProductController'
			}
		}

	})
	
	.state('app.tShirts', {  
		url : '/tShirts',
		templateUrl : 'home/tShirts',
		controller : 'CategoryController'
	})
	
	.state('app.category', {
		url : '/category/:id/:num',
		templateUrl :	function(params){ return 'home/category/' + params.id +'/'+ params.num; },
		//templateUrl : 'home/category',
		controller : 'CategoryController',
		resolve: {
            async: ['CategoryService', '$stateParams', function(CategoryService, $stateParams) {
                return CategoryService.fetchAllProducts($stateParams.id);
            }]
        }
	})
	
	.state('app.search', {
		url : '/search/:name',
		//templateUrl :	function(params){ return 'home/category/' + params.id; },
		templateUrl : function(params){ return 'home/search/' + params.name; },
		controller : 'CategoryController',
		resolve: {
            async: ['SearchService', '$stateParams', function(SearchService, $stateParams) {
                return SearchService.getSearchProduct($stateParams.name);
            }]
        }
	})
	
		
	.state('app.register', {
		url : '/register',
		//templateUrl :	function(params){ return 'home/category/' + params.id; },
		templateUrl : function(){ return 'register' },
		controller : 'UserController',
		resolve: {
            async: ['RegistrationService', function(RegistrationService) {
                return RegistrationService.getCountryDetails();
            }]
        }
	})
	.state('app.latestOfferDetails', {
		url : '/latestOfferDetails/:id',
		templateUrl :	function(params){ return 'latestOfferDetails/' + params.id; },
		//templateUrl : 'home/category',
		controller : 'LatestOfferController',
		resolve: {
            async: ['LatestOfferService', '$stateParams', function(LatestOfferService, $stateParams) {
                return LatestOfferService.getLatestOfferDetails($stateParams.id);
            }]
        }
	})
	
	.state('app.cart', {
		url : '/cart/:productId/:userId',
		templateUrl :	function(params){ return 'cart'; },
		//templateUrl : 'home/category',
		controller : 'CartController',
		resolve: {
            async: ['CartService', '$stateParams', function(CartService, $stateParams) {
                return CartService.addItemToCart($stateParams.productId,$stateParams.userId);
            }]
        }
	})	
	
	.state('app.wish', {
		url : '/wish/:productId/:userId',
		templateUrl :	function(params){ return 'wish'; },
		//templateUrl : 'home/category',
		controller : 'WishListController',
		resolve: {
            async: ['WishListService', '$stateParams', function(WishListService, $stateParams) {
                return WishListService.addItemToList($stateParams.productId,$stateParams.userId);
            }]
        }
	})
	
		.state('app.customer-Account', {
		url : '/customer-Account',
		templateUrl :	'customer-Account',
		//templateUrl : 'home/category',
		//controller : 'AccountController',
	})
	
	.state('app.product', {
		url : '/product/:productId',
		templateUrl :	function(params){ return 'product'; },
		//templateUrl : 'home/category',
		controller : 'ProductController',
		resolve: {
            async: ['ProductService', '$stateParams', function(ProductService, $stateParams) {
                return ProductService.getProductById($stateParams.productId);
            }]
        }
	})		
	.state('app.allCategories', {
		url : '/allCategories',
		templateUrl :	function(params){ return 'allCategories'; },
	})
		.state('app.latestOfferItems', {
		url : '/latestOfferItems/:num',
		templateUrl :	function(params){ return 'latestOfferItems/'+ params.num; },
	})
		.state('app.admin', {
		url : '/admin/home',
		templateUrl :	function(params){ return 'admin'; }
		//templateUrl : 'home/category',
		/*controller : 'AdminHomeController',*/
	/*	resolve: {
            async: ['ProductService', '$stateParams', function(ProductService, $stateParams) {
                return ProductService.getProductById($stateParams.productId);
            }]
        }*/
	})
		.state('app.users', {
		url : '/users',
		templateUrl :	function(params){ return 'admin/users'; },
		//templateUrl : 'home/category',
		controller : 'AdminUserController'
	/*	resolve: {
            async: ['AdminUserService', function(AdminUserService) {
                return AdminUserService.fetchAllUsers();
            }]
        }*/
	})
	.state('app.vendors', {
		url : '/vendors/:adminId',
		templateUrl :	function(params){ return 'admin/vendors'; },
		//templateUrl : 'home/category',
		controller : 'AdminVendorController'
	/*	resolve: {
            async: ['AdminVendorService','$stateParams', function(AdminVendorService,$stateParams) {
                return AdminVendorService.fetchAllVendors($stateParams.adminId);
            }]
        }*/
	})
		.state('app.registerVendor', {
		url : '/registerVendor',
		//templateUrl :	function(params){ return 'home/category/' + params.id; },
		templateUrl : function(){ return 'admin/registerVendor'; },
		controller : 'UserController',
		resolve: {
            async: ['RegistrationService', function(RegistrationService) {
                return RegistrationService.getCountryDetails();
            }]
        }
	})
		.state('app.pdtcategory', {
		url : '/pdtcategory',
		templateUrl :	function(params){ return 'admin/pdtcategory'; },
		//templateUrl : 'home/category',
		controller : 'ProductCategoryController'
	/*	resolve: {
            async: ['ProductCategoryService', function(ProductCategoryService) {
                return ProductCategoryService.fetchAllProductCategories();
            }]
        }*/
	})
		.state('app.createCategory', {
		url : '/createCategory',
		//templateUrl :	function(params){ return 'home/category/' + params.id; },
		templateUrl : function(){ return 'admin/createCategory'; },
		controller : 'CategoryAdminController',
		resolve: {
            async: ['CategoryAdminService', function(CategoryAdminService) {
                return CategoryAdminService.fetchAllProductCategories();
            }]
        }
	})
		.state('app.pricelist', {
		url : '/pricelist',
		templateUrl :	function(params){ return 'admin/pricelists'; },
		//templateUrl : 'home/category',
		controller : 'PriceListController',
		resolve: {
            async: ['PriceListService', function(PriceListService) {
                return PriceListService.fetchAllPriceLists();
            }]
        }
	})
		.state('app.products', {
		url : '/products',
		templateUrl :	function(){ return 'admin/products'; },
		controller : 'AdminProductController'
	
	})
})



App.controller('ContentController', function(AuthenticationService) {

});

App.controller('FooterController', function() {
});

/*App.factory('myService', function() {
    return {
        foo: function() {
            alert("I'm foo!");
        }
    };
});
*/

App.run( function($rootScope,$cookieStore) {
    console.log("app run");
    $rootScope.globals = $cookieStore.get('globals') || {};
    console.log("User" + $rootScope.globals.currentUser )
      if ($rootScope.globals.currentUser) {
    	  /*	$rootScope.globals = $rootScope.globals.currentUser.username */
      }

});



/*run.$inject = ['$rootScope', '$location', '$cookieStore', '$http'];
function run($rootScope, $location, $cookieStore, $http) {
    // keep user logged in after page refresh
	
    $rootScope.globals = $cookieStore.get('globals') || {};
    if ($rootScope.globals.currentUser) {
        $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
    }


};*/
