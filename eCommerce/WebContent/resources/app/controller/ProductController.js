'use strict';

angular
		.module('app')
		.controller(
				'ProductController',
				[
						'$scope',
						'async',
						'$filter',
						'ProductService',
						'$rootScope','AttributeService','CategoryService',
						function($scope, async, $filter, ProductService, $rootScope,AttributeService,CategoryService) {
							console.log('in ProductController ' + async);
							$scope.product=async;
							
							$scope.productCategoryId=$scope.product.categoryId;
							
							
							$scope.category={
									categoryID : '',
									name : '',
									parentID:null,
									children:null
							}
							
							console.log('$scope.productCategoryId'+$scope.productCategoryId);
							
							$scope.productDicount=$scope.product.discount;
							$scope.productDicountAmount=$scope.product.priceList-$scope.product.priceStd;
							$scope.productAttributeList=$scope.product.attributes
							$scope.AttributeList=[];
							$scope.TempAttribute=[];
							$scope.TempAttributeValues = [];
							$scope.TempAttribute.TempAttributeValues=[];
							$scope.IndexList=[];
							$scope.selectedValue=false;
							$scope.selectedColorValue=
							$scope.selectedSizeValue=0;
							$scope.getAttributes = function() {

								AttributeService.getAttributes().then(
										function(response) {
											//console.log(response);
											$scope.AttributeList = response;
											
												
												angular.forEach($scope.AttributeList, function (attributeHeaderList){
													//console.log('in 1'+attributeHeaderList);
													console.log("legthhhhhhhhhhhhhhh : "+attributeHeaderList.attributeValues.length);
													
													angular.forEach(attributeHeaderList.attributeValues, function (attribute){
														//console.log('in product' + $scope.productAttributeList );
														console.log("Oroo attribute" + attribute.value);
														var a = arrayObjectIndexOf($scope.productAttributeList, attribute);
														//console.log("Index : Attribute Value " + a + "===" + attribute.value);
														
													 	if(a == -1)
								                	  	{
													 		//console.log("Deleteing" + attribute.value);
													 		var attributeValue = attributeHeaderList.attributeValues;
													 		var index = arrayObjectIndexOf(attributeValue,attribute);
													 		//attributeHeaderList.attributeValues.splice(index, 1);
													 		$scope.TempAttributeValues.push(attribute);
								                	  	}
													});
													
													angular.forEach($scope.TempAttributeValues, function (temp){
														
														
															console.log("Tem value" +temp.value)
															var attributeValue = attributeHeaderList.attributeValues;
													 		var index = arrayObjectIndexOf(attributeValue,temp);
													 		if(index != -1)
													 			attributeHeaderList.attributeValues.splice(index, 1);	
														
													});
													
													$scope.TempAttributeValues = [];
											});
												
									
											console.log($scope.AttributeList);
										}, function(errResponse) {
											alert('error while getAttributes ..');
										});
							};
							
							function arrayObjectIndexOf(arr, obj){
							    for(var i = 0; i < arr.length; i++){
							        if(angular.equals(arr[i], obj)){
							            return i;
							        }
							    };
							    return -1;
							};
							
							$scope.updateValue = function(selectedValue,headerValue) {
							    console.log("selected is"+selectedValue);
							    console.log("selected headerValue is"+headerValue);
							    if(headerValue == 'Color'){
							    	 $scope.selectedColorValue=selectedValue;
							    }
							    else if(headerValue == 'Size'){
							    	 $scope.selectedSizeValue=selectedValue;
							    }
							   
							    if($scope.selectedColorValue == 0){
							    	 $scope.selectedValue= false;
							    }else{
							    	 $scope.selectedValue= true;
							    }
							    if($scope.selectedSizeValue == 0){
							    	 $scope.selectedValue= false;
							    }else{
							    	 $scope.selectedSizeValue= true;
							    }
							    
							    
							};
							
		$scope.getCategoryName = function(catId) {
				
													CategoryService
													.getCategoryById(catId)
													.then(
															function(response) {
																console.log(response);
																//$rootScope.cartSize = response.length;
																$scope.category=response;

															},
															function(errResponse) {
																alert('error while addToCart ..');
															});
													
							};
						}]);


