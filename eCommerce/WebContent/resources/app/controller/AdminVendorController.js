'use strict';

angular
		.module('app')
		.controller(
				'AdminVendorController',
				[
						'$scope',
						'$rootScope',
						'AdminVendorService',
						'$filter',
						'RegistrationService',
						function($scope, $rootScope, AdminVendorService,
								$filter, RegistrationService) {
							
							
						
							
							$scope.vendors =[];
							 $scope.items = [];
								$scope.user = {
										userId : null,
										userName : '',
										password : '',
										userMobile : '',
										userEmail : '',
										userAddress1 : '',
										userAddress2 : '',
										userPinCode : '',
										userCountry : null,
										userState : null,
										userCity : null,
										isManagedByVendor : false,
										adminId : '',
										isActive : ''
									};

									$scope.states = [];
									$scope.cities = [];

							
							$scope.getAllVendors = function() {
								showLoading();
								
							var	adminId = $rootScope.globals.currentUser.userId;
							    	fetchAllVendors(adminId);
						    };
						    
						    function fetchAllVendors(adminId) {
						    	AdminVendorService.fetchAllVendors(adminId).then(
										function(response) {
											console.log("getAllUsers "+response);
											$scope.vendors = response;
											// $scope.search();
											 $scope.gap = 1;
											    
											    $scope.filteredItems = [];
											    $scope.groupedItems = [];
											    $scope.itemsPerPage = 5;
											    $scope.pagedItems = [];
											    $scope.currentPage = 1;
												$scope.items = $scope.vendors;
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
							
							
							
							
							
							
							console.log($scope.vendors);
							//$scope.vendors = async;

							$scope.createdSuccessMsg = null;
							$scope.createdErrorMsg = null;
							$scope.nameErrorMsg = null;
							$scope.mobileErrorMsg = null;
							$scope.passwordErrorMsg = null;
							$scope.emailErrorMsg = null;

					
							// init
							$scope.sort = {
								sortingOrder : 'userName',
								reverse : false
							};

					
							var searchMatch = function(haystack, needle) {
								if (!needle) {
									return true;
								}
								return haystack.toLowerCase().indexOf(
										needle.toLowerCase()) !== -1;
							};

							// init the filtered items
							$scope.search = function() {
								$scope.filteredItems = $filter('filter')(
										$scope.items,
										function(item) {
											for ( var attr in item) {
												if (searchMatch(item[attr],
														$scope.query))
													return true;
											}
											return false;
										});
								// take care of the sorting order
								if ($scope.sort.sortingOrder !== '') {
									$scope.filteredItems = $filter('orderBy')(
											$scope.filteredItems,
											$scope.sort.sortingOrder,
											$scope.sort.reverse);
								}
								$scope.currentPage = 0;
								// now group by pages
								$scope.groupToPages();
							};

							// calculate page in place
							$scope.groupToPages = function() {
								$scope.pagedItems = [];

								for (var i = 0; i < $scope.filteredItems.length; i++) {
									if (i % $scope.itemsPerPage === 0) {
										$scope.pagedItems[Math.floor(i
												/ $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
									} else {
										$scope.pagedItems[Math.floor(i
												/ $scope.itemsPerPage)]
												.push($scope.filteredItems[i]);
									}
								}
							};

							$scope.range = function(size, start, end) {
								var ret = [];
								console.log(size, start, end);

								if (size < end) {
									end = size;
									start = size - $scope.gap;
								}
								for (var i = start; i < end; i++) {
									ret.push(i);
								}
								console.log(ret);
								return ret;
							};

							$scope.prevPage = function() {
								if ($scope.currentPage > 0) {
									$scope.currentPage--;
								}
							};

							$scope.nextPage = function() {
								if ($scope.currentPage < $scope.pagedItems.length - 1) {
									$scope.currentPage++;
								}
							};

							$scope.setPage = function() {
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
							
							
							$scope.countries = [];
							$scope.states = [];
							$scope.cities = [];

							// setStates(selectedCountry)

						
								$scope.getCountries = function() {
								
								
									RegistrationService.getCountryDetails().then(
											function(response) {
												console.log(response);
												$scope.countries=response;

											},
											function(errResponse) {
												console
														.error('Error while getting Countries');

												
												
											});
							};
							
							$scope.setStates = function(userCountry) {
								console.log('$scope.userCountry'
										+ $scope.user.userCountry.countryName);

								angular.forEach($scope.countries, function(
										country) {

									if (angular.equals(country,
											$scope.user.userCountry)) {
										$scope.states = country.states;

									}

								});

							};
							$scope.setCities = function(userState) {
								console.log('$scope.userState'
										+ $scope.user.userState.stateName);

								angular
										.forEach(
												$scope.countries,
												function(country) {

													if (angular
															.equals(
																	country,
																	$scope.user.userCountry)) {
														$scope.states = country.states;

														angular
																.forEach(
																		$scope.states,
																		function(
																				state) {

																			if (angular
																					.equals(
																							state,
																							$scope.user.userState)) {
																				$scope.cities = state.cities;

																			}

																		});

													}

												});

							};

							$scope.setCity = function(userCity) {
								console.log('$scope.user.userState'
										+ $scope.user.userCity.cityName);
								$scope.user.userCity = userCity;

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
								
								//$scope.selectedCountry=$scope.user.userCountry;
				               
								
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
									userCityId : item.userCityId,
									userCountryId : item.userCountryId,
									userStateId : item.userStateId,
									userCityName : item.userCityName,
									isManagedByVendor : item.isManagedByVendor,
									adminId : item.adminId,
									isActive : item.isActive
								};
								 $scope.user.userCountry = $filter('filter')($scope.countries, {countryId:$scope.user.userCountryId})[0];
								
					                $scope.user.userState = $filter('filter')($scope.user.userCountry.states, {stateId:$scope.user.userStateId})[0];
					                $scope.user.userCity = $filter('filter')($scope.user.userState.cities, {cityId:$scope.user.userCityId})[0];
								 
								// setStates($scope.user.userCountry);
								 
								// $scope.user.userState = $filter('filter')($scope.states, {stateId:$scope.user.userStateId})[0];
								// setCities($scope.user.userState);
								// $scope.user.userCity = $filter('filter')($scope.cities, {cityId:$scope.user.userCityId})[0];
								 
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
								AdminVendorService
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
								AdminVendorService
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
								showLoading();
								
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

								console.log('in updateUserStatus user ' + user.adminId);

								updateStatus(user);

							}

							function updateStatus(user) {
								AdminVendorService
										.updateVendorStatus(user)
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
							$scope.updateUserStatus = function(userId, status) {
								console.log('in updateUserStatus userId '
										+ userId);
								console.log('in updateUserStatus status '
										+ status);

								AdminVendorService
										.updateUserStatus(userId, status)
										.then(
												function(response) {
													console.log(response);
													$scope.updateSuccessMsg = "User Updated Successfully.";

												},
												function(errResponse) {
													$scope.updateErrorMsg = "User Updation Failed.";
													//alert('error while updateUserStatus ..');
												});
							}

							$scope.getCountryDetails = function() {
								console.log("in getCountryDetails");
								RegistrationService.getCountryDetails().then(
										function(response) {
											console.log(response);
											$scope.countries = response;
										}, function(errResponse) {
											console.log(errResponse);
										});

							};
							// setStates(selectedCountry)

							$scope.setStates = function(userCountry) {
								console.log('$scope.userCountry'
										+ $scope.user.userCountry.countryName);

								angular.forEach($scope.countries, function(
										country) {

									if (angular.equals(country,
											$scope.user.userCountry)) {
										$scope.states = country.states;

									}

								});

							};
							$scope.setCities = function(userState) {
								console.log('$scope.userState'
										+ $scope.user.userState.stateName);

								angular
										.forEach(
												$scope.countries,
												function(country) {

													if (angular
															.equals(
																	country,
																	$scope.user.userCountry)) {
														$scope.states = country.states;

														angular
																.forEach(
																		$scope.states,
																		function(
																				state) {

																			if (angular
																					.equals(
																							state,
																							$scope.user.userState)) {
																				$scope.cities = state.cities;

																			}

																		});

													}

												});

							};

							$scope.setCity = function(userCity) {
								console.log('$scope.user.userState'
										+ $scope.user.userCity.cityName);
								$scope.user.userCity = userCity;

							};

							$scope.submit = function() {
								showLoading();
								
								console.log('in submit');

								console.log('$scope.user.userCountry'
										+ $scope.userCountry);
								console.log('$scope.user.userState'
										+ $scope.userState);
								console.log('$scope.user.userCity'
										+ $scope.userCity);

								if ($scope.user.userId === null) {

									var letters = /^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/;
									var phoneno = /^\d{10}$/;
									var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
									var field = $scope.user.password;
									var mnlen = 5;
									var mxlen = 10;

									if ($scope.user.userName.match(letters)) {
										$scope.nameErrorMsg = null;

										if ($scope.user.userMobile
												.match(phoneno)) {

											$scope.mobileErrorMsg = null;

											if ($scope.user.userEmail
													.match(mailformat)) {
												if (field.length >= mnlen
														&& field.length <= mxlen) {
													$scope.passwordErrorMsg = null;

													console.log(
															'Saving New User',
															$scope.user);

													createUser($scope.user);

												} else {
													$scope.passwordErrorMsg = 'Passsword length Should be in between '
															+ mnlen
															+ '-'
															+ mxlen;
													return false;
												}
											} else {
												$scope.emailErrorMsg = 'Incorrect Email Id';
												return false;
											}

											// return true;  
										} else {
											$scope.mobileErrorMsg = 'Incorrect Mobile Number';
											return false;
										}

									} else {
										$scope.nameErrorMsg = 'Name should contain only Letters';
										return false;
									}

								} else {
									// updateUser(self.user, self.user.id);
									console.log('User updated with id ',
											$scope.user.userId);
								}
								reset();
							}

							// setCities(selectedState)
							function createUser(user) {
								RegistrationService
										.createUser(user)
										.then(
												function(response) {
													console.log(response);
													$scope.createdSuccessMsg = "User created successfully.. Please Signin to your account..";
													hideLoading();
												},
												function(errResponse) {
													console
															.error('Error while creating User');

													$scope.createdErrorMsg = "User Creation Failed.. Please Try Again..";
													hideLoading();
												});
							}
							;
							function reset() {
								$scope.user = {
									userId : null,
									userName : '',
									password : '',
									userMobile : '',
									userEmail : '',
									userAddress1 : '',
									userAddress2 : '',
									userPinCode : '',
									userCountry : null,
									userState : null,
									userCity : null,
									isManagedByVendor : false,
									adminId : '',
									isActive : ''
								};
								$scope.myForm.$setPristine(); // reset Form
								resetMessages();
							}
							
						

				function resetMessages() {
					$scope.createdSuccessMsg = null;
					$scope.createdErrorMsg = null;
					$scope.nameErrorMsg = null;
					$scope.mobileErrorMsg = null;
					$scope.passwordErrorMsg = null;
					$scope.emailErrorMsg = null;
					
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
angular.module('app').$inject = [ '$scope', '$filter' ];

angular
		.module('app')
		.directive(
				"customSort",
				function() {
					return {
						restrict : 'A',
						transclude : true,
						scope : {
							order : '=',
							sort : '='
						},
						template : ' <a ng-click="sort_by(order)" style="color: #555555;">'
								+ '    <span ng-transclude></span>'
								+ '    <i ng-class="selectedCls(order)"></i>'
								+ '</a>',
						link : function(scope) {

							// change sorting order
							scope.sort_by = function(newSortingOrder) {
								var sort = scope.sort;

								if (sort.sortingOrder == newSortingOrder) {
									sort.reverse = !sort.reverse;
								}

								sort.sortingOrder = newSortingOrder;
							};

							scope.selectedCls = function(column) {
								if (column == scope.sort.sortingOrder) {
									return ('icon-chevron-' + ((scope.sort.reverse) ? 'down'
											: 'up'));
								} else {
									return 'icon-sort'
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