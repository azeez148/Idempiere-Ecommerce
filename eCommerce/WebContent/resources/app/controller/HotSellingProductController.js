'use strict';

angular.module('app').controller('HotSellingProductController',
		[ '$scope', 'async', function($scope, async) {

			console.log("In Hot");
			$scope.hotSellingProducts = [];
			$scope.hotSellingProducts = async;

		} ]);
