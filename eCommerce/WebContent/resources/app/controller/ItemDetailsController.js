'use strict';

App.controller('ItemDetailsController', ['async','$route', function(async,$route) {
          var self = this;
          self.item=async;
          var urlpath = $route.current.params.id;

         //console.log("inside controller "+urlpath);
          self.removeTask = function(newlan) {
        	    //alert(newlan);
        	    console.log(newlan);
        	}
}]);
