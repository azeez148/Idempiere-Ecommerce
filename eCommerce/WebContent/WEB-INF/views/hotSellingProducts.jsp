<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<script src="resources/app/other/front.js"></script>

</head>

<!-- Top Selling Products -->
	<div id="hot">

		<div class="box">
			<div class="container">
				<div class="col-md-12">
					<h2><spring:message code="eco.index.hotweek" /></h2>
				</div>
			</div>
		</div>
		
		<div class="container">
			<div class="product-slider">
				<div class="item">
					<div class="product">
						<div class="flip-container">  
							<div class="flipper">
								<div class="front">
									<a href="#/product/{{hotSellingProducts[0].productID}}"> <img ng-src="resources/img/ProductIMG/{{hotSellingProducts[0].logoID}}.png" 
										alt="" class="img-responsive">
									</a>
								</div>
						<div class="back">
									<a href="#/product/{{hotSellingProducts[0].productID}}"> <img ng-src="resources/img/ProductIMG/{{hotSellingProducts[0].logoID}}.png"
										alt="" class="img-responsive">
									</a>
								</div> 
							</div>
						</div>
		<a href="detail.html" class="invisible"> <img ng-src="resources/img/ProductIMG/{{hotSellingProducts[0].logoID}}.png" 
						alt="" class="img-responsive">
						</a> 
						<div class="text">
							<h3>
								<a href="#/product/{{hotSellingProducts[0].productID}}">{{hotSellingProducts[0].name}}</a>
							</h3>
							
							
							
							<p class="buttons" ng-if="globals.currentUser.userId == null">
								<a href="#/product/{{hotSellingProducts[0].productID}}" class="btn btn-primary btn-sm">View detail</a> 
						<!-- 	<a href="" ng-click="addToCart(item.productID,0)" class="btn btn-primary btn-sm" ng-disabled="item.inventoryQty == 0"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->
								
								
								
								<a href="" ng-click="addToWishList(hotSellingProducts[0].productID,0)" class="btn btn-default btn-sm"><i class="fa fa-heart"></i>Add to WishList</a>
								
								
							
							</p>
							
								<p class="buttons" ng-if="globals.currentUser.userId != null">
								<a href="#/product/{{hotSellingProducts[0].productID}}" class="btn btn-primary btn-sm">View detail</a> 
						<!-- 	<a href="" ng-click="addToCart(item.productID,0)" class="btn btn-primary btn-sm" ng-disabled="item.inventoryQty == 0"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->								
								
								<a href="" ng-click="addToWishList(hotSellingProducts[0].productID,globals.currentUser.userId)" class="btn btn-default btn-sm"><i class="fa fa-heart"></i>Add to WishList</a>
							
							</p>
							
							
							
<!-- 							<p class="price">
							{{hotSellingProducts[0].priceList}} INR</p> -->
						</div>
						<!-- /.text -->
					 <div class="ribbon sale">
                                    <div class="theribbon">Top Selling</div>
                                    <div class="ribbon-background"></div>
                                </div>
					</div>
					<!-- /.product -->
				</div>

				<div class="item">
					<div class="product">
						<div class="flip-container">
							<div class="flipper">
								<div class="front">
										<a href="#/product/{{hotSellingProducts[1].productID}}"> <img ng-src="resources/img/ProductIMG/{{hotSellingProducts[1].logoID}}.png" 
										alt="" class="img-responsive">
									</a>
								</div>
							<div class="back">
									<a href="#/product/{{hotSellingProducts[1].productID}}"> <img ng-src="resources/img/ProductIMG/{{hotSellingProducts[1].logoID}}.png"
										alt="" class="img-responsive">
									</a>
								</div> 
							</div>
						</div>
										<a href="#/product/{{hotSellingProducts[1].productID}}" class="invisible"> <img
							 ng-src="resources/img/ProductIMG/{{hotSellingProducts[1].logoID}}.png" alt="" class="img-responsive">
						</a> 
						<div class="text">
							<h3>
								<a href="#/product/{{hotSellingProducts[1].productID}}">{{hotSellingProducts[1].name}}</a>
							</h3>
	<!-- 						<p class="price">
								{{hotSellingProducts[1].priceList}} INR
							</p> -->
							
							
							
							<p class="buttons" ng-if="globals.currentUser.userId == null">
								<a href="#/product/{{hotSellingProducts[1].productID}}" class="btn btn-primary btn-sm">View detail</a> 
						<!-- 	<a href="" ng-click="addToCart(item.productID,0)" class="btn btn-primary btn-sm" ng-disabled="item.inventoryQty == 0"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->
								
								
								
								<a href="" ng-click="addToWishList(hotSellingProducts[1].productID,0)" class="btn btn-default btn-sm"><i class="fa fa-heart"></i>Add to WishList</a>
								
								
							
							</p>
							
								<p class="buttons" ng-if="globals.currentUser.userId != null">
								<a href="#/product/{{hotSellingProducts[1].productID}}" class="btn btn-primary btn-sm">View detail</a> 
						<!-- 	<a href="" ng-click="addToCart(item.productID,0)" class="btn btn-primary btn-sm" ng-disabled="item.inventoryQty == 0"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->								
								
								<a href="" ng-click="addToWishList(hotSellingProducts[1].productID,globals.currentUser.userId)" class="btn btn-default btn-sm"><i class="fa fa-heart"></i>Add to WishList</a>
							
							</p>
							
							
						</div>
						<!-- /.text -->
						
						 <div class="ribbon sale">
                                    <div class="theribbon">Top Selling</div>
                                    <div class="ribbon-background"></div>
                                </div>

					<!-- 	<div class="ribbon sale">
							<div class="theribbon">SALE</div>
							<div class="ribbon-background"></div>
						</div> -->
						<!-- /.ribbon -->

					<!-- 	<div class="ribbon new">
							<div class="theribbon">NEW</div>
							<div class="ribbon-background"></div>
						</div> -->
						<!-- /.ribbon -->

					<!-- 	<div class="ribbon gift">
							<div class="theribbon">GIFT</div>
							<div class="ribbon-background"></div>
						</div> -->
						<!-- /.ribbon -->
					</div>
					<!-- /.product -->
				</div>
				<div class="item">
					<div class="product">
						<div class="flip-container">
							<div class="flipper">
								<div class="front">
										<a href="#/product/{{hotSellingProducts[2].productID}}"> <img ng-src="resources/img/ProductIMG/{{hotSellingProducts[2].logoID}}.png" 
										alt="" class="img-responsive" >
									</a>
								</div>
							<div class="back">
									<a href="#/product/{{hotSellingProducts[2].productID}}"> <img ng-src="resources/img/ProductIMG/{{hotSellingProducts[2].logoID}}.png" 
										alt="" class="img-responsive">
									</a>
								</div>
							</div>
						</div>
					<a href="#/product/{{hotSellingProducts[2].productID}}" class="invisible"> <img
							ng-src="resources/img/ProductIMG/{{hotSellingProducts[2].logoID}}.png"  alt="" class="img-responsive">
						</a> 
						<div class="text">
							<h3>
								<a href="#/product/{{hotSellingProducts[2].productID}}">{{hotSellingProducts[2].name}}</a>
							</h3>
<!-- 							<p class="price">
							{{hotSellingProducts[2].priceList}} INR</p> -->
							
							
							
							
							
							<p class="buttons" ng-if="globals.currentUser.userId == null">
								<a href="#/product/{{hotSellingProducts[2].productID}}" class="btn btn-primary btn-sm">View detail</a> 
						<!-- 	<a href="" ng-click="addToCart(item.productID,0)" class="btn btn-primary btn-sm" ng-disabled="item.inventoryQty == 0"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->
								
								
								
								<a href="" ng-click="addToWishList(hotSellingProducts[2].productID,0)" class="btn btn-default btn-sm"><i class="fa fa-heart"></i>Add to WishList</a>
								
								
							
							</p>
							
								<p class="buttons" ng-if="globals.currentUser.userId != null">
								<a href="#/product/{{hotSellingProducts[2].productID}}" class="btn btn-primary btn-sm">View detail</a> 
						<!-- 	<a href="" ng-click="addToCart(item.productID,0)" class="btn btn-primary btn-sm" ng-disabled="item.inventoryQty == 0"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->								
								
								<a href="" ng-click="addToWishList(hotSellingProducts[2].productID,globals.currentUser.userId)" class="btn btn-default btn-sm"><i class="fa fa-heart"></i>Add to WishList</a>
							
							</p>
							
							
							
							
							
							
						</div>
						<!-- /.text -->
						
						
						 <div class="ribbon sale">
                                    <div class="theribbon">Top Selling</div>
                                    <div class="ribbon-background"></div>
                                </div>
<!-- 
						<div class="ribbon new">
							<div class="theribbon">NEW</div>
							<div class="ribbon-background"></div>
						</div> -->
						<!-- /.ribbon -->
					</div>
					<!-- /.product -->
				</div>

				<div class="item">
					<div class="product">
						<div class="flip-container">
							<div class="flipper">
								<div class="front">
										<a href="#/product/{{hotSellingProducts[3].productID}}"> <img ng-src="resources/img/ProductIMG/{{hotSellingProducts[3].logoID}}.png" 
										alt="" class="img-responsive" >
									</a>
								</div>
								<div class="back">
									<a href="#/product/{{hotSellingProducts[3].productID}}"> <img ng-src="resources/img/ProductIMG/{{hotSellingProducts[3].logoID}}.png" 
										alt="" class="img-responsive">
									</a>
								</div>
							</div>
						</div>
 						<a href="#/product/{{hotSellingProducts[3].productID}}" class="invisible"> <img
							ng-src="resources/img/ProductIMG/{{hotSellingProducts[3].logoID}}.png"  alt="" class="img-responsive">
						</a> 
						<div class="text">
							<h3>
								<a href="#/product/{{hotSellingProducts[3].productID}}">{{hotSellingProducts[3].name}}</a>
							</h3>
							
							
							
							
							<p class="buttons" ng-if="globals.currentUser.userId == null">
								<a href="#/product/{{hotSellingProducts[3].productID}}" class="btn btn-primary btn-sm">View detail</a> 
						<!-- 	<a href="" ng-click="addToCart(item.productID,0)" class="btn btn-primary btn-sm" ng-disabled="item.inventoryQty == 0"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->
								
								
								
								<a href="" ng-click="addToWishList(hotSellingProducts[3].productID,0)" class="btn btn-default btn-sm"><i class="fa fa-heart"></i>Add to WishList</a>
								
								
							
							</p>
							
								<p class="buttons" ng-if="globals.currentUser.userId != null">
								<a href="#/product/{{hotSellingProducts[3].productID}}" class="btn btn-primary btn-sm">View detail</a> 
						<!-- 	<a href="" ng-click="addToCart(item.productID,0)" class="btn btn-primary btn-sm" ng-disabled="item.inventoryQty == 0"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->								
								
								<a href="" ng-click="addToWishList(hotSellingProducts[3].productID,globals.currentUser.userId)" class="btn btn-default btn-sm"><i class="fa fa-heart"></i>Add to WishList</a>
							
							</p>
							
							
							
		<!-- 					<p class="price">
							{{hotSellingProducts[3].priceList}} INR</p> -->
						</div>
						<!-- /.text -->
						
						 <div class="ribbon sale">
                                    <div class="theribbon">Top Selling</div>
                                    <div class="ribbon-background"></div>
                                </div>

						<!-- <div class="ribbon gift">
							<div class="theribbon">GIFT</div>
							<div class="ribbon-background"></div>
						</div> -->
						<!-- /.ribbon -->
					</div>
					<!-- /.product -->
				</div>
				<!-- /.col-md-4 -->

				<div class="item">
					<div class="product">
						<div class="flip-container">
							<div class="flipper">
								<div class="front">
										<a href="#/product/{{hotSellingProducts[4].productID}}"> <img ng-src="resources/img/ProductIMG/{{hotSellingProducts[4].logoID}}.png" 
										alt="" class="img-responsive">
									</a>
								</div>
							<div class="back">
									<a href="#/product/{{hotSellingProducts[4].productID}}"> <img ng-src="resources/img/ProductIMG/{{hotSellingProducts[4].logoID}}.png" 
										alt="" class="img-responsive">
									</a>
								</div> 
							</div>
						</div>
						<a href="#/product/{{hotSellingProducts[4].productID}}" class="invisible"> <img
							ng-src="resources/img/ProductIMG/{{hotSellingProducts[4].logoID}}.png"  alt="" class="img-responsive">
						</a> 
						<div class="text">
							<h3>
								<a href="#/product/{{hotSellingProducts[4].productID}}">{{hotSellingProducts[4].name}}</a>
							</h3>
			<!-- 				<p class="price">
								{{hotSellingProducts[4].priceList}} INR
							</p> -->
							
							
							
							
							
							
							<p class="buttons" ng-if="globals.currentUser.userId == null">
								<a href="#/product/{{hotSellingProducts[4].productID}}" class="btn btn-primary btn-sm">View detail</a> 
						<!-- 	<a href="" ng-click="addToCart(item.productID,0)" class="btn btn-primary btn-sm" ng-disabled="item.inventoryQty == 0"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->
								
								
								
								<a href="" ng-click="addToWishList(hotSellingProducts[4].productID,0)" class="btn btn-default btn-sm"><i class="fa fa-heart"></i>Add to WishList</a>
								
								
							
							</p>
							
								<p class="buttons" ng-if="globals.currentUser.userId != null">
								<a href="#/product/{{hotSellingProducts[4].productID}}" class="btn btn-primary btn-sm">View detail</a> 
						<!-- 	<a href="" ng-click="addToCart(item.productID,0)" class="btn btn-primary btn-sm" ng-disabled="item.inventoryQty == 0"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->								
								
								<a href="" ng-click="addToWishList(hotSellingProducts[4].productID,globals.currentUser.userId)" class="btn btn-default btn-sm"><i class="fa fa-heart"></i>Add to WishList</a>
							
							</p>
							
						</div>
						<!-- /.text -->
						 <div class="ribbon sale">
                                    <div class="theribbon">Top Selling</div>
                                    <div class="ribbon-background"></div>
                                </div>
<!-- 
						<div class="ribbon sale">
							<div class="theribbon">SALE</div>
							<div class="ribbon-background"></div>
						</div> -->
						<!-- /.ribbon -->

						<!-- <div class="ribbon new">
							<div class="theribbon">NEW</div>
							<div class="ribbon-background"></div>
						</div> -->
						<!-- /.ribbon -->

					<!-- 	<div class="ribbon gift">
							<div class="theribbon">GIFT</div>
							<div class="ribbon-background"></div>
						</div> -->
						<!-- /.ribbon -->
					</div>
					<!-- /.product -->
				</div>
			</div>
			<!-- /.product-slider -->
		</div>
		<!-- /.container -->

	</div>
	<!-- /#hot -->


