'use strict';

angular.module('app').filter('startFilter', function () {
		    return function (input, start) {
		        if (!input || !input.length) { return; }

		        start = +start;
		        return input.slice(start);
		    };
		});