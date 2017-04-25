<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<!-- <script src="resources/app/other/bootstrap-hover-dropdown.js"></script> 
 -->

</head>


<!-- *** Menu ***
 _________________________________________________________ -->
<div ng-controller="MenuController" ng-init="getCategories()">

	<div class="navbar navbar-default yamm" role="navigation" id="navbar">
		<div class="container-fluid">
			<div class="navbar-header">


				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navigation"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#search" aria-expanded="false">
					<span class="sr-only">Toggle search</span> <i class="fa fa-search"></i>
					<!-- <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> -->
				</button>



				<a class="btn btn-default navbar-toggle" href="#/cart/0/0"> <i
					class="fa fa-shopping-cart"></i> <span class="hidden-xs">3
						items in cart</span>
				</a> <a class="navbar-brand home" href="" ng-click="reloadHome()"
					data-animate-hover="bounce"> <img
					src="<spring:message code="eco.path.images.logo" />"
					alt="Obaju logo" class="hidden-xs"> <img
					src="<spring:message code="eco.path.images.logo" />"
					alt="Obaju logo" class="visible-xs"><span class="sr-only">eCommerce
						- go to homepage</span>
				</a>

			</div>
			<!--/.navbar-header -->


			<!-- Collect the nav links, forms, and other content for toggling -->
			<div ng-if="globals.currentUser.userRole != 'SuperAdmin'"
				class="collapse navbar-collapse" id="navigation">
				<ul class="nav navbar-nav menu-items">
					<!--  <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Link</a></li> -->
					<!-- user view -->
					<li class="dropdown" ng-repeat="item in categoryList"><a
						href="" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">{{item.name}} <span class="caret"></span></a>
						<ul class="dropdown-menu sub-menu" ng-if="item.children">
							<li>
								<div class="yamm-content">
									<div class="row">

										<div ng-repeat="subitem in item.children" class="col-sm-9">
											<h5>{{subitem.name}}</h5>

											<ul ng-if="subitem.children">
												<li ng-repeat="lastsubitem in subitem.children"><a
													href="#/category/{{lastsubitem.categoryID}}/0">
														{{lastsubitem.name}}</a></li>
											</ul>
										</div>

									</div>
								</div>
							</li>

						</ul></li>

				</ul>
			</div>


			<!-- ng-init="getAdminScreens()" -->

			<div ng-if="globals.currentUser.userRole == 'SuperAdmin'"
				class="collapse navbar-collapse" id="navigation">
				<!-- admin view -->

				<ul class="nav navbar-nav menu-items">
					


					<li class="dropdown" ng-init="active = true"><a href="#/dashboard"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false" ng-class="{'active': active === true}" ng-click="active = !active"><i class="fa fa-tachometer" aria-hidden="true"></i> DashBoard</a></li>
							
							
													
					<li class="dropdown"><a href=""
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false"><i class="fa fa-users" aria-hidden="true"></i>
						 Users<span
							class="caret"></span></a>
							
									<ul class="dropdown-menu sub-menu">
							<li>
								<div class="yamm-content">
									<div class="row">

										<div class="col-sm-12">
											<h5><i class="fa fa-cog" aria-hidden="true"></i> Manage Users</h5>

											<ul>
											<li><a href="#/users"><i class="fa fa-list" aria-hidden="true"></i> All Users</a></li>
												<!-- <li><a href="#/registerVendor"><i class="fa fa-plus-circle" aria-hidden="true"></i> Add Vendor</a></li> -->
											</ul>
										</div>


									</div>
								</div>
							</li>


						</ul>
							</li>
							
							
							<li class="dropdown"><a href=""
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false"><i class="fa fa-industry" aria-hidden="true"></i> Vendors<span
							class="caret"></span></a>
						<ul class="dropdown-menu sub-menu">
							<li>
								<div class="yamm-content">
									<div class="row">

										<div class="col-sm-12">
											<h5><i class="fa fa-cog" aria-hidden="true"></i> Manage Vendors</h5>

											<ul>
											<li><a href="#/vendors/{{globals.currentUser.userId}}"><i class="fa fa-list" aria-hidden="true"></i> All Vendors</a></li>
												<li><a href="#/registerVendor"><i class="fa fa-plus-circle" aria-hidden="true"></i> Add New Vendor</a></li>
											</ul>
										</div>


									</div>
								</div>
							</li>


						</ul></li>
							
							
	
								<li class="dropdown"><a href=""
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false"><i class="fa fa-sitemap" aria-hidden="true"></i>
						 Product Categories<span
							class="caret"></span></a>
						<ul class="dropdown-menu sub-menu">
							<li>
								<div class="yamm-content">
									<div class="row">

										<div class="col-sm-12">
											<h5><i class="fa fa-cog" aria-hidden="true"></i> Manage Product Categories</h5>

											<ul>
												<li><a href="#/pdtcategory">
														<i class="fa fa-list" aria-hidden="true"></i> All Categories</a></li>
											</ul>
										</div>


									</div>
								</div>
							</li>


						</ul></li>
							
							
							
							
					<li class="dropdown"><a href=""
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false"><i class="fa fa-cubes" aria-hidden="true"></i>
						 Products<span
							class="caret"></span></a>
						<ul class="dropdown-menu sub-menu">
							<li>
								<div class="yamm-content">
									<div class="row">

										<div class="col-sm-12">
											<h5><i class="fa fa-cog" aria-hidden="true"></i> Manage Products</h5>

											<ul>
											<li><a href="#/products"> <i class="fa fa-list" aria-hidden="true"></i> All Products</a></li>
												<li><a href="#/products/create"> <i class="fa fa-plus-circle" aria-hidden="true"></i> Add New Product</a></li>
											</ul>
										</div>


									</div>
								</div>
							</li>


						</ul></li>
				
									<li class="dropdown"><a href=""
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false"><i class="fa fa-gift" aria-hidden="true"></i> Deals<span
							class="caret"></span></a>
						<ul class="dropdown-menu sub-menu">
							<li>
								<div class="yamm-content">
									<div class="row">

										<div class="col-sm-12">
											<h5><i class="fa fa-cog" aria-hidden="true"></i> Manage Deals</h5>

											<ul>
											<li><a href="#/deals/list"><i class="fa fa-list" aria-hidden="true"></i> All Deals</a></li>
												<li><a href="#/deals/create"><i class="fa fa-plus-circle" aria-hidden="true"></i> Add New Deal</a></li>
											</ul>
										</div>


									</div>
								</div>
							</li>


						</ul></li>
				
				
					<li class="dropdown"><a href=""
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false"><i class="fa fa-file-text" aria-hidden="true"></i>
 Orders<span
							class="caret"></span></a>
						<ul class="dropdown-menu sub-menu">
							<li>
								<div class="yamm-content">
									<div class="row">

										<div class="col-sm-12">
											<h5><i class="fa fa-cog" aria-hidden="true"></i> Manage Orders</h5>

											<ul>
											<li><a href="#/pricelist"><i class="fa fa-list" aria-hidden="true"></i> All Orders</a></li>
												<!-- <li><a href="#/pricelist/create"><i class="fa fa-plus-circle" aria-hidden="true"></i></a></li> -->
											</ul>
										</div>


									</div>
								</div>
							</li>


						</ul></li> 

		<li class="dropdown"><a href=""
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false"><i class="fa fa-file" aria-hidden="true"></i>
				Reports<span
							class="caret"></span></a>
						<ul class="dropdown-menu sub-menu">
							<li>
								<div class="yamm-content">
									<div class="row">

										<div class="col-sm-12">
											<h5><i class="fa fa-cog" aria-hidden="true"></i> Manage Reports</h5>

											<ul>
												<li><a href="#/userReports"><i class="fa fa-users" aria-hidden="true"></i> Users</a></li>
												<li><a href="#/vendorReports"><i class="fa fa-industry" aria-hidden="true"></i> Vendors</a></li>
												<li><a href="#/productReports"><i class="fa fa-cubes" aria-hidden="true"></i> Products</a></li>
												<li><a href="#/dealReports"><i class="fa fa-gift" aria-hidden="true"></i> Deals</a></li>
												<li><a href="#/orderReports"><i class="fa fa-file-text" aria-hidden="true"></i> Orders</a></li>
											</ul>
										</div>


									</div>
								</div>
							</li>


						</ul></li> 
						
							<li class="dropdown" ng-init="active = true"><a href="#/config"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false" ng-class="{'active': active === true}" ng-click="active = !active"><i class="fa fa-cogs" aria-hidden="true"></i> System Configuration</a></li>
							

				</ul>

			</div>
			<!-- /.navbar-collapse -->

			<div
				ng-if="globals.currentUser.userId != null && globals.currentUser.userRole != 'SuperAdmin'">

				<div class="navbar-buttons"
					ng-init="getCartSize(globals.currentUser.userId)">

					<div class="navbar-collapse collapse right" id="basket-overview">
						<a href="#/cart/0/{{globals.currentUser.userId}}"
							class="btn btn-primary navbar-btn"><i
							class="fa fa-shopping-cart"></i><span class="hidden-sm">{{cartSize}}
								items in cart</span></a>
					</div>
					<!--/.nav-collapse -->

					<div class="navbar-collapse collapse right" id="search-not-mobile">
						<button type="button" class="btn navbar-btn btn-primary"
							data-toggle="collapse" data-target="#search">
							<span class="sr-only">Toggle search</span> <i
								class="fa fa-search"></i>
						</button>
					</div>

				</div>

			</div>
			<div
				ng-if="globals.currentUser.userId == null && globals.currentUser.userRole != 'SuperAdmin'">

				<div class="navbar-buttons" ng-init="getCartSize(0)">

					<div class="navbar-collapse collapse right" id="basket-overview">
						<a href="#/cart/0/0" class="btn btn-primary navbar-btn"><i
							class="fa fa-shopping-cart"></i><span class="hidden-sm">{{cartSize}}
								items in cart</span></a>
					</div>
					<!--/.nav-collapse -->

					<div class="navbar-collapse collapse right" id="search-not-mobile">
						<button type="button" class="btn navbar-btn btn-primary"
							data-toggle="collapse" data-target="#search">
							<span class="sr-only">Toggle search</span> <i
								class="fa fa-search"></i>
						</button>
					</div>

				</div>
			</div>

			<div class="collapse clearfix" id="search">

				<form class="navbar-form" role="search">
					<div class="input-group stylish-input-group">



						<input type="text" class="form-control" placeholder="Search"
							ng-model="text"> <span class="input-group-addon">
							<button type="submit" ng-click="searchProduct('#/search',text)">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>

					</div>
				</form>

			</div>
			<!--/.nav-collapse -->

		</div>
		<!-- /.container -->
	</div>
</div>
<!-- /#navbar -->

<!-- *** NAVBAR END *** -->