'use strict';

	angular.module('app').controller('LatestOfferController',
			[ '$scope','async', function($scope,async) {
				console.log('in LatestOfferController'+async);
				$scope.productList=[];
				$scope.productList = async;
				console.log($scope.productList);
			} ]);