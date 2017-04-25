<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="robots" content="all,follow">
<meta name="googlebot" content="index,follow,snippet,archive">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="NeST e-commerce">
<meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
<meta name="keywords" content="">
<!-- styles -->
<jsp:directive.include file="../views/common/allStyles.jsp" />
<!-- *** Angular SCRIPTS TO INCLUDE *** -->
<jsp:directive.include file="../views/common/angularScripts.jsp" />
<!-- angularjs app -->
</head>
<body ng-app="myApp">
<!-- <script>
var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        template : "<h1>Main</h1><p>Click on the links to change this content</p>"
    })
    .when("/tshirts", {
        template : "<h1>Banana</h1><p>Bananas contain around 75% water.</p>"
    })
    .when("/tomato", {
        template : "<h1>Tomato</h1><p>Tomatoes contain around 95% water.</p>"
    });
app.controller("tShirtController", function ($scope) {
    $scope.msg = "I love India";
    });
});
</script> -->
	<div ng-view></div>
	<div >{{msg}}</div>
	<jsp:directive.include file="/WEB-INF/views/common/Header.jsp" />
	<jsp:directive.include file="/WEB-INF/views/common/Menu.jsp" />
	<div >
		<!-- <p>
			<a href="#index">Add Student</a>
		</p>
		<p>
			<a href="#viewStudents">View Students</a>
		</p> -->
				<jsp:directive.include file="/WEB-INF/views/home.jsp" />
		
	
	</div>
	<jsp:directive.include file="/WEB-INF/views/common/Footer.jsp" />
</body>
<!-- *** SCRIPTS TO INCLUDE *** -->
<jsp:directive.include file="../views/common/allScripts.jsp" />
</html>
