'use strict';

angular
		.module('app')
		.controller(
				'CategoryAdminController',
				[
						'$scope',
						'async',
						'$filter',
						'RegistrationService',
						'$rootScope',
						'$window',
						function($scope, async, $filter, RegistrationService,
								$rootScope, $window) {
							console.log('in CategoryAdminController ' + async);

						console.log('categories'+async)
							
							
							
							//	myService.foo();
							//$('#login-modal').modal('hide');
							
						
							
							
							
							$scope.createdSuccessMsg = null;
							$scope.createdErrorMsg =null;
							$scope.nameErrorMsg = null;
							$scope.mobileErrorMsg = null;
							$scope.passwordErrorMsg = null;

							// var self = this;
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
								image : null,
								adminId:''
							};

							$scope.countries = async;
							$scope.states = [];
							$scope.cities = [];

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
								console.log('in submit');
								
								//console.log('isMangedByVendor'+$scope.isMangedByVendor);

								console.log('$scope.user.userCountry'
										+ $scope.userCountry);
								console.log('$scope.user.userState'
										+ $scope.userState);
								console.log('$scope.user.userCity'
										+ $scope.userCity);

								if ($scope.user.userId === null) {

									var letters = /^[A-Za-z]+$/;
									var phoneno = /^\d{10}$/;
									var field = $scope.user.password;
									var mnlen = 5;
									var mxlen = 10;

									if ($scope.user.userName.match(letters)) {
										$scope.nameErrorMsg = null;

										if ($scope.user.userMobile
												.match(phoneno)) {
											$scope.mobileErrorMsg = null;

											if (field.length >= mnlen
													&& field.length <= mxlen) {
												$scope.passwordErrorMsg = null;

												console.log('Saving New User',
														$scope.user);

												createUser($scope.user);
												

											} else {
												$scope.passwordErrorMsg = 'Passsword length Should be in between '
														+ mnlen + '-' + mxlen;
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
								
							}
							
							
							
							//vendor specific
							
						    var readURL = function(input) {
						        if (input.files && input.files[0]) {
						            var reader = new FileReader();

						            reader.onload = function (e) {
						                $('.profile-pic').attr('src', e.target.result);
						            }
						    
						            reader.readAsDataURL(input.files[0]);
						        }
						        console.log("image"+input.files[0]);
						    }
						    

						    $(".file-upload").on('change', function(){
						        readURL(this);
						        
						        var selectedFile = this.files[0];
						        selectedFile.convertToBase64(function(base64){
						             console.log("string image "+base64);
						             $scope.user.image=base64;
						        }) 
						    });
						    
						    $(".upload-button").on('click', function() {
						       $(".file-upload").click();
						    });
						    
						    File.prototype.convertToBase64 = function(callback){
					            var reader = new FileReader();
					            reader.onload = function(e) {
					                 callback(e.target.result)
					            };
					            reader.onerror = function(e) {
					                 callback(null);
					            };        
					            reader.readAsDataURL(this);
					    };
							
							
							$scope.submitVendorAccount = function() {
								console.log('in submit');
								
								console.log('isMangedByVendor'+$scope.isMangedByVendor);
								
								if($scope.isMangedByVendor == true){
									
									$scope.user.isManagedByVendor=true;
									
								}
								else if($scope.isMangedByVendor == false){
									$scope.user.adminId=$rootScope.globals.currentUser.userId;
								}

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

													createVendor($scope.user);

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
							function createVendor(user) {
								RegistrationService
										.createVendor(user)
										.then(
												function(response) {
													console.log(response);
													$scope.createdSuccessMsg = "Vendor: "+user.userName+" created successfully..";

												},
												function(errResponse) {
													console
															.error('Error while creating User:' +user.userName);
													
													$scope.createdErrorMsg = "Vendor: "+user.userName+" Creation Failed.. Please Try Again.."
												});
							};
							// setCities(selectedState)
							function createUser(user) {
								RegistrationService
										.createUser(user)
										.then(
												function(response) {
													console.log(response);
													$scope.createdSuccessMsg = "User: "+user.userName+" created successfully.. Please Signin to your account..";
													reset();
												},
												function(errResponse) {
													console
															.error('Error while creating User');
													
													$scope.createdErrorMsg = "User: "+user.userName+" Creation Failed.. Please Try Again.."
												});
							};
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
									image : null,
									adminId:''
								};
								 $('.profile-pic').attr('src', null);
								$scope.myForm.$setPristine(); // reset Form
							}
							;
							$scope.reset=function(){
								console.log("in reset");
								reset();
							} 
						} ]);