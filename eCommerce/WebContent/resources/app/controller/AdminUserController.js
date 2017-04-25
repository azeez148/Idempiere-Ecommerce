'use strict';

angular
		.module('app')
		.controller(
				'AdminUserController',
				[
						'$scope',
						'$rootScope','AdminUserService','$filter',
						function($scope,$rootScope,AdminUserService,$filter) {
						//	console.log(async);
							//$scope.users = async;
						//	$scope.getUsersTable();
				/*			$scope.getUsersTable = function() {
								console.log("$scope.users"+$scope.users);
							$(function() {
							    $('#example').DataTable( {
							        data: $scope.users,
							        columns: [
							                  { data: "userId" },
									            { data: "userName" },
									            { data: "userMobile" },
									            { data: "userEmail" },
									            { data: "userLocationId" },
									            { data: "userPartnerId" }
							        ]
							    });
							});
							};*/
							
							
							//AdminUserService.fetchAllUsers();
							
							
						    // init
							
							$scope.users =[];
							 $scope.items = [];
							
							$scope.getAllUsers = function() {
								showLoading();
							    	fetchAllUsers();
						    };
						    
						    function fetchAllUsers() {
						    	AdminUserService.fetchAllUsers().then(
										function(response) {
											console.log("getAllUsers "+response);
											$scope.users = response;
											// $scope.search();
											 $scope.gap = 1;
											    
											    $scope.filteredItems = [];
											    $scope.groupedItems = [];
											    $scope.itemsPerPage = 5;
											    $scope.pagedItems = [];
											    $scope.currentPage = 1;
											    $scope.items = $scope.users;
												$scope.itemsSize=$scope.items.length;
											 
												  $scope.search();
												  hideLoading();
										},
										function(errResponse) {
											
											$scope.users = null;
											console
													.error('Error while fetchAllUsers');
											hideLoading();

											
										});
							};
							
							
						    $scope.sort = {       
						                sortingOrder : 'userName',
						                reverse : false
						            };
						    
						   /* $scope.gap = 1;
						    
						    $scope.filteredItems = [];
						    $scope.groupedItems = [];
						    $scope.itemsPerPage = 5;
						    $scope.pagedItems = [];
						    $scope.currentPage = 1;
						    $scope.items = $scope.users;
							$scope.itemsSize=$scope.items.length;*/
						    var searchMatch = function (haystack, needle) {
						        if (!needle) {
						            return true;
						        }
						        return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
						    };

						    // init the filtered items
						    $scope.search = function () {
						        $scope.filteredItems = $filter('filter')($scope.items, function (item) {
						            for(var attr in item) {
						                if (searchMatch(item[attr], $scope.query))
						                    return true;
						            }
						            return false;
						        });
						        // take care of the sorting order
						        if ($scope.sort.sortingOrder !== '') {
						            $scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
						        }
						        $scope.currentPage = 0;
						        // now group by pages
						        $scope.groupToPages();
						    };
						    
						  
						    // calculate page in place
						    $scope.groupToPages = function () {
						        $scope.pagedItems = [];
						        
						        for (var i = 0; i < $scope.filteredItems.length; i++) {
						            if (i % $scope.itemsPerPage === 0) {
						                $scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
						            } else {
						                $scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
						            }
						        }
						    };
						    
						    $scope.range = function (size,start, end) {
						        var ret = [];        
						        console.log(size,start, end);
						                      
						        if (size < end) {
						            end = size;
						            start = size-$scope.gap;
						        }
						        for (var i = start; i < end; i++) {
						            ret.push(i);
						        }        
						         console.log(ret);        
						        return ret;
						    };
						    
						    $scope.prevPage = function () {
						        if ($scope.currentPage > 0) {
						            $scope.currentPage--;
						        }
						    };
						    
						    $scope.nextPage = function () {
						        if ($scope.currentPage < $scope.pagedItems.length - 1) {
						            $scope.currentPage++;
						        }
						    };
						    
						    $scope.setPage = function () {
						        $scope.currentPage = this.n;
						    };

						    // functions have been describe process the data for display
						    $scope.search();


							$scope.getItemsPerPage = function() {
								
								$scope.data = {
									availableOptions : [ {
										id : '1',
										name : '10'
									}, {
										id : '2',
										name : '25'
									}, {
										id : '3',
										name : '50'
									}, {
										id : '4',
										name : 'All'
									} ],
									selectedOption : {
										id : '1',
										name : '10'
									}
								//This sets the default value of the select in the ui
								};

							};

							$scope.updateItemsPerPage = function(selectedItem) {

								console.log('selectedItem' + selectedItem.id);

								if (selectedItem.id == '1') {
									$scope.itemsPerPage = 10;
								} else if (selectedItem.id == '2') {
									$scope.itemsPerPage = 25;

								} else if (selectedItem.id == '3') {
									$scope.itemsPerPage = 50;
								} else if (selectedItem.id == '4') {
									$scope.itemsPerPage = $scope.itemsSize;
								} else {
									$scope.itemsPerPage = 10;
								}
								
								$scope.search();
							};
						    
						    
							$scope.openModal = function(item) {
								console.log('item name is ' + item.userName);
								console.log('item userMobile is ' + item.userMobile);
								console.log('item userMobile is ' + item.userMobile);
								
								console.log('item userEmail is ' + item.userEmail);
								console.log('item userCountryName is ' + item.userCountryName);
								console.log('item userStateName is ' + item.userStateName);
								console.log('item userCityName is ' + item.userCityName);
								console.log('item isManagedByVendor is ' + item.isManagedByVendor);
								console.log('item adminId is ' + item.adminId);
								console.log('item isActive is ' + item.isActive);

								if (item.isActive == 'Y') {
									$("#userState").text("Block ");
								} else if (item.isActive == 'N') {
									$("#userState").text("Activate ");
								}
								$("#userName").text(item.userName);
								$("#userId").val(item.userId);
								$scope.id = item.userId;
								$scope.status = item.isActive;

								
								$scope.user = {
										userId : item.userId,
										userName : item.userName,
										password : item.password,
										userMobile : item.userMobile,
										userEmail : item.userEmail,
										userAddress1 : item.userAddress1,
										userAddress2 : item.userAddress2,
										userPinCode : item.userPinCode,
										userCountryName : item.userCountryName,
										userStateName : item.userStateName,
										userCityName : item.userCityName,
										isManagedByVendor : item.isManagedByVendor,
										adminId : item.adminId,
										isActive : item.isActive
									};
								
								console.log('item is ... ' + item.adminId);
								console.log('$scope.user is ... ' + $scope.user.adminId);
								
								$('#blockUser').modal('show');
							}

							$scope.openUpdateModal = function(item) {
								console.log('item name is ' + item.userName);
								console.log('item.isMangedByVendor is '
										+ item.isMangedByVendor);

								$scope.user = {
									userId : item.userId,
									userName : item.userName,
									password : item.password,
									userMobile : item.userMobile,
									userEmail : item.userEmail,
									userAddress1 : item.userAddress1,
									userAddress2 : item.userAddress2,
									userPinCode : item.userPinCode,
									userCountryName : item.userCountryName,
									userStateName : item.userStateName,
									userCityName : item.userCityName,
									isManagedByVendor : item.isManagedByVendor,
									adminId : item.adminId,
									isActive : item.isActive
								};
								$('#updateVendor').modal('show');
							}

							$scope.openContactModal = function(item) {
								console.log('item name is ' + item.userName);
								console.log('item.isMangedByVendor is '
										+ item.isMangedByVendor);

								/*		$scope.user = {
											userId : item.userId,
											userName : item.userName,
											password : item.password,
											userMobile : item.userMobile,
											userEmail : item.userEmail,
											userAddress1 : item.userAddress1,
											userAddress2 : item.userAddress2,
											userPinCode : item.userPinCode,
											userCountryName : item.userCountryName,
											userStateName : item.userStateName,
											userCityName : item.userCityName,
											isManagedByVendor : item.isManagedByVendor,
											adminId : item.adminId,
											isActive:item.isActive
										};*/
								$scope.email = {
									hostEmail : $rootScope.globals.currentUser.userEmail,
									userName : item.userName,
									userEmail : item.userEmail,
									subject : '',
									message : ''

								};
								$('#contactUser').modal('show');
							}

							$scope.sendMail = function(email) {
								showLoading();
								console.log('user name is ' + email.userName);
								console.log('subject  is ' + email.subject);
								console.log('message is ' + email.message);
								sendEmail(email);

							}
							function sendEmail(email) {
								AdminUserService
										.sendEmail(email)
										.then(
												function(response) {
													console.log(response);
													//$scope.items=response;
													//$scope.search();
													$scope.createdSuccessMsg = "Email To: "
															+ email.userName
															+ " Send  successfully..";
													$('#contactUser').modal(
															'hide');
													hideLoading();
												},
												function(errResponse) {
													
													console
															.error('Error while Contacting Vendor:'
																	+ email.userName);

													$scope.createdErrorMsg = "Email Send To Vendor: "
															+ email.userName
															+ " Failed.. Please Try Again..";
													hideLoading();
												});
							};

							$scope.updateVendor = function(user) {
								showLoading();
							
								console.log('user name is ' + user.userName);

								if (user.isMangedByVendor == true) {

									user.adminId = "";

								} else if ($scope.isMangedByVendor == false) {
									user.adminId = $rootScope.globals.currentUser.userId;
								}

								updateVendor(user);

							}

							function updateVendor(user) {
								AdminUserService
										.updateVendor(user)
										.then(
												function(response) {
													console.log(response);
													$scope.items = response;
													$scope.search();
													$scope.createdSuccessMsg = "Vendor: "
															+ user.userName
															+ " Updated successfully..";
													$('#updateVendor').modal(
															'hide');
													hideLoading();
												},
												function(errResponse) {
													console
															.error('Error while Updating Vendor:'
																	+ user.userName);

													$scope.createdErrorMsg = "Vendor: "
															+ user.userName
															+ " Updation Failed.. Please Try Again..";
													hideLoading();
												});
							}
							;

							$scope.updateVendorStatus = function(user) {
/*
								$scope.user = {
									userId : item.userId,
									userName : item.userName,
									password : item.password,
									userMobile : item.userMobile,
									userEmail : item.userEmail,
									userAddress1 : item.userAddress1,
									userAddress2 : item.userAddress2,
									userPinCode : item.userPinCode,
									userCountryName : item.userCountryName,
									userStateName : item.userStateName,
									userCityName : item.userCityName,
									isManagedByVendor : item.isManagedByVendor,
									adminId : item.adminId,
									isActive : item.isActive
								};*/
								showLoading();
								console.log('in updateUserStatus user ' + user.adminId);

								updateStatus(user);

							}

							function updateStatus(user) {
								AdminUserService
										.updateUserStatus(user)
										.then(
												function(response) {
													console.log(response);
													$scope.items = response;
													$scope.search();
													$scope.updateSuccessMsg = "User Updated Successfully.";
													$('#blockUser').modal('hide');
													hideLoading();
												},
												function(errResponse) {
													$scope.updateErrorMsg = "User Updation Failed.";
													hideLoading();
													//alert('error while updateUserStatus ..');
												});
							}
							;
							function showLoading() {

								$('#content').css('opacity', '.3');
								$('#dvLoading').show();

							}
							;

							function hideLoading() {
								$('#content').css('opacity', '1');
								$('#dvLoading').hide();
							}
							;
						    
						
				} ]);
/*

fessmodule.$inject = ['$scope', '$filter'];

fessmodule.directive("customSort", function() {
return {
    restrict: 'A',
    transclude: true,    
    scope: {
      order: '=',
      sort: '='
    },
    template : 
      ' <a ng-click="sort_by(order)" style="color: #555555;">'+
      '    <span ng-transclude></span>'+
      '    <i ng-class="selectedCls(order)"></i>'+
      '</a>',
    link: function(scope) {
                
    // change sorting order
    scope.sort_by = function(newSortingOrder) {       
        var sort = scope.sort;
        
        if (sort.sortingOrder == newSortingOrder){
            sort.reverse = !sort.reverse;
        }                    

        sort.sortingOrder = newSortingOrder;        
    };
    
   
    scope.selectedCls = function(column) {
        if(column == scope.sort.sortingOrder){
            return ('icon-chevron-' + ((scope.sort.reverse) ? 'down' : 'up'));
        }
        else{            
            return'icon-sort' 
        } 
    };      
  }// end link
}
});*/
/*
angular
		.module('app')
		.filter(
				'selectFromSelected',
				function() {

					   return function (incItems, value) {
				            var out = [{}];
				            
				            if(value){
				                for(x=0; x<incItems.length; x++){
				                    if(incItems[x].Value == value)
				                        out.push(incItems[x]);
				                }
				                return out;
				            }
				            else if(!value){
				                return incItems
				            }
				        };
				});





*/







/*

angular.module('app').('filters', [])
.filter('selectFromSelected', function () {
        return function (incItems, value) {
            var out = [{}];
            
            if(value){
                for(x=0; x<incItems.length; x++){
                    if(incItems[x].Value == value)
                        out.push(incItems[x]);
                }
                return out;
            }
            else if(!value){
                return incItems
            }
        };
    });

*/