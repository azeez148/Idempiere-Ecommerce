'use strict';

angular.module('app').controller('LoginController', function($scope, $http, $state,AuthenticationService,FlashService,WishListService,$rootScope,CartService) {
	console.log('in Login Controller');

	$scope.user = {};
	
	
/*    (function initController() {
        // reset login status
    	console.log("In initController");
        AuthenticationService.ClearCredentials();
    })();
    
    */
    $scope.login =  function () {
        //vm.dataLoading = true;   
        console.log("in Login Service");
            AuthenticationService.Login($scope.user.username, $scope.user.password, function (response) {
            if (response.success) {
            	$scope.userId=response.userId;
            	
            	$scope.userRole=response.userRole;
            	$scope.userEmail=response.userEmail;
            	
                AuthenticationService.SetCredentials($scope.user.username, $scope.user.password,$scope.userId,$scope.userRole,$scope.userEmail);
                $('#login-modal').modal('hide');
                
                if($scope.userRole == 'SuperAdmin'){
                	alert('SuperAdmin');
                	
                	  $state.go('app.admin', {}, {reload: true});
                }
                else{
                	$scope.getCartSize($scope.userId);
                }
                
                
                
             
              //  $location.path('/');
            } else {
            	console.log("Wrong PAssword")
                FlashService.Error(response.message);
                //vm.dataLoading = false;
            }
        });
    };
    
    $scope.logOut = function() {
    	
    	console.log("in LogOut");
    	AuthenticationService.ClearCredentials();
 
    }
    
	$scope.getCartSize = function(userId) {

		 CartService.addItemToCart(0,userId).then(
					function(response) {
						console.log("in getCartSize");
						console.log(response);
						$rootScope.cartSize=response.length;
						console.log("response.length"+response.length);	
					}, function(errResponse) {
						alert('error while Deleting in..');
					});
			  
	
	};
    
    
    $scope.getWishListSize = function(userId) {

    	WishListService.addItemToList(0,userId).then(
					function(response) {
						console.log("in wishhhhhhhhhhhhhhhhhh");
						console.log(response);
						$rootScope.wishListSize=response.length;
						console.log("response.length"+response.length);	
					}, function(errResponse) {
						alert('error while Deleting in..');
					});
	};
});
//#REF =http://plnkr.co/edit/tg25kr?p=preview