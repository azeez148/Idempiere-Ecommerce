<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!-- <div ng-repeat="product in productList">
									
												
	{{ productList.model }}
												
 
    </div>
  -->
 <script>
 
  </script>

<!--  <div id="mydiv">
    <img src="/resources/img/ajax-loader.gif" class="ajax-loader"/>
</div> -->



<script type="text/javascript">
        var sortingOrder = 'name';
    </script>
<c:set var="cat" scope="session" value="${category}" />

<div class="container" >
<!-- 
	     <div class="col-md-12" ng-init="getCategoryName()">

                    <ul class="breadcrumb">
                        <li><a href="#">Home</a>
                        </li>
                        <li>{{categoryName}}</li>
                    </ul>

                </div> -->

	<div class="col-md-2">
		<!-- *** MENUS AND FILTERS ***
 _________________________________________________________ -->
		<div class="panel panel-default sidebar-menu">

			<div class="panel-heading">
				<h3 class="panel-title">Categories</h3>
			</div>

			<div class="panel-body" ng-init="getCategories()">
			
			
			
				<ul class="nav nav-pills nav-stacked category-menu">
					<li ng-repeat="item in categoryList">
					
					
					<a href="">{{item.name}}</a>
						<ul class="nav nav-pills nav-stacked category-submenu">
						<li ng-repeat="subitem in item.children">
						
						
						<a href="">{{subitem.name}}</a>
							
							<ul class="nav nav-pills nav-stacked category-submenu-item">
						<li  ng-repeat="lastsubitem in subitem.children"  ng-class="{active: lastsubitem.categoryID == categoryId}">
							<a href="#/category/{{lastsubitem.categoryID}}/0">{{lastsubitem.name}}</a>
						</li>
						</ul>
							
						</li>
				
						
						
							
						</ul></li>
						
		

				</ul>

			</div>
		</div>
		
	
<div ng-init="getAttributes()">
		<div ng-repeat="attributeHeader in AttributeList" class="panel panel-default sidebar-menu" >

			<div class="panel-heading">
				<h3 class="panel-title">
					{{attributeHeader.name}} <!-- <a class="btn btn-xs btn-danger pull-right" href="#"><i
						class="fa fa-times-circle"></i> Clear</a> -->
				</h3>
			</div>

			<div class="panel-body panel-attributes">

			
					<div class="form-group">
					<div class="scrollbar" id="style-1">
      <div class="force-overflow">
      
      
							<div class="checkbox" ng-repeat="attribute in attributeHeader.attributeValues"> 
  					<input type="checkbox" checklist-model="attribute.value" ng-model="attribute.isChecked" ng-change="setSelectedAttribute(attribute.value,attribute.isChecked)">{{attribute.value}}

						</div>
      
      </div>
    </div>
		
						
					</div>

			</div>
		</div>
	 	
		<div class="panel panel-default sidebar-menu" ng-init="getAllProductsPriceList()">

                        <div class="panel-heading">
                            <h3 class="panel-title">Price</h3>
                        </div>

                        <div class="panel-body">
                        
                        <p>
  <label for="amount">Price range:</label>
  <input type="text"  id="amount"  ng-model="price" readonly style="border:0; color:#4fbfa8; font-weight:bold;" ng-change="updateAmount(price)">
</p>
<div id="slider-range"></div>

     </div>
     
    <!--   <input type="text"  id="price1"  ng-model="price1" ng-change="updateMin(price1)">
       <input type="text"  id="price2"  ng-model="price2" ng-change="updateMax(price2)"> -->
     
                    </div> 
                    
                    
           

</div>

		<!-- *** MENUS AND FILTERS END *** -->

	<!-- 	<div class="banner">
			<a href="#"> <img src="../img/banner.jpg" alt="sales 2014"
				class="img-responsive">
			</a>
		</div> -->
	</div>
	
	<div class="col-md-1"></div>
	<div class="col-md-8">
	
	<div ng-init="getCategoryName()">

                    <ul class="breadcrumb">
                        <li><a href="#">Home</a>
                        </li>
                        <li>{{category.name}}</li>
                    </ul>

                </div> 
	
	
		<div class="box info-bar">
			<div class="row">
				<div ng-if="filteredItemssize == 0" class="col-sm-12 col-md-4 products-showing">
					Showing <strong>{{pagedItems[currentPage].length}}</strong> of <strong>{{productListSize}}</strong>
					products
				</div>
				
				<div ng-if="filteredItemssize != 0" class="col-sm-12 col-md-4 products-showing">
					Showing <strong>{{filteredItemssize}}</strong> of <strong>{{productListSize}}</strong>
					products
				</div>

				<div class="col-sm-12 col-md-8  products-number-sort">
					<div class="row">
						<form class="form-inline">
							<div class="col-md-4 col-sm-6">
								<div class="products-number">
									<strong>Show</strong> <a href ng-click="changePageSize(16)"
										class="btn btn-default btn-xs">16</a> <a href
										ng-click="changePageSize(32)" class="btn btn-default btn-xs">32</a>
									<a href ng-click="changePageSize(0)"
										class="btn btn-default btn-xs">All</a> products
								</div>
							</div>
							<div class="col-md-4 col-sm-6">
								<div class="products-sort-by">
									<strong>Sort by</strong> <select ng-model="selectedSort"
										class="form-control" ng-click="sort_by(selectedSort)">
										<option value="PriceLTH">Price Low To High</option>
										<option value="PriceHTL">Price High To Low</option>
										<option value="NameASC">Name ASC</option>
										<option value="NameDSC">Name DSC</option>
									</select>



								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!--  <div class="box"> -->
		<div class="row">
			<div class="pagination pull-right">
				<ul>
					<li ng-class="{disabled: currentPage == 0}"><a href
						ng-click="prevPage()">« Prev</a></li>
					<li ng-repeat="n in range(pagedItems.length)"
						ng-class="{active: n == currentPage}" ng-click="setPage()"><a
						href ng-bind="n + 1">1</a></li>
					<li ng-class="{disabled: currentPage == pagedItems.length - 1}">
						<a href ng-click="nextPage()">Next »</a>
					</li>
				</ul>
			</div>
			<!--             </div> -->
		</div>

		<div class="row products">

			<div
				ng-repeat="item in filtered =  (pagedItems[currentPage] | orderBy:sortingOrder:reverse | priceRange:rangeInfo:this | attributeFilter:selectedAttributes:this)"
				class="col-md-3 col-sm-6">
				<div class="product">
					<div class="flip-container">
						<div class="flipper">
						
						
							<div class="front">
								<a href="#/product/{{item.productID}}"> <img
									ng-src="resources/img/ProductIMG/{{item.logoID}}.png" alt=""
									class="img-responsive" ng-class="{outofstock : item.inventoryQty === 0}">
								</a>
							</div>
							<div class="back">
								<a href="#/product/{{item.productID}}"> <img
									ng-src="resources/img/ProductIMG/{{item.logoID}}.png" alt=""
									class="img-responsive" ng-class="{outofstock : item.inventoryQty === 0}">
								</a>
							</div>



						</div>
						<a href="#/product/{{item.productID}}" class="invisible"> <img
							ng-src="resources/img/ProductIMG/{{item.logoID}}.png" alt="" class="img-responsive" >
						</a>
						<div class="text">
							<h3>
								<a href="#/product/{{item.productID}}">{{item.name}} </a>
							</h3>
							
							
							
							<!--  <p class="price"><i class="fa fa-inr rupee"></i> {{item.priceList}}</p>  -->
							
							
						
									<div ng-show="item.discount != 0 && item.inventoryQty != 0">
								
						<p class="price">
							<del>
								<i class="fa fa-inr rupee"></i> {{item.priceList}}
							</del>
							&nbsp; <span class="stdprice"> <i class="fa fa-inr rupee"></i>
								{{item.priceStd}}</span> 
								<span class="taxtext">Inclusive of all taxes</span>
						</p>
	 								<div class="ribbon sale gift">
                                    <div class="theribbon"> {{item.discount }}% Off</div>
                                    <div class="ribbon-background"></div>
                                </div>

					</div>
							<div ng-show="item.discount == 0">
						<p class="price">
							<i class="fa fa-inr rupee"></i> {{item.priceStd}} <span
								class="taxtext">Inclusive of all taxes</span>
						</p>


					</div> 
							
							<p class="buttons" ng-if="globals.currentUser.userId == null">
								<a href="#/product/{{item.productID}}" class="btn btn-primary btn-sm">View detail</a> 
						<!-- 	<a href="" ng-click="addToCart(item.productID,0)" class="btn btn-primary btn-sm" ng-disabled="item.inventoryQty == 0"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->
								
								
								
								<a href="" ng-click="addToWishList(item.productID,0)" class="btn btn-default btn-sm"><i class="fa fa-heart"></i>Add to WishList</a>
								
								
							
							</p>
							
								<p class="buttons" ng-if="globals.currentUser.userId != null">
								<a href="#/product/{{item.productID}}" class="btn btn-primary btn-sm">View detail</a> 
						<!-- 	<a href="" ng-click="addToCart(item.productID,0)" class="btn btn-primary btn-sm" ng-disabled="item.inventoryQty == 0"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->								
								
								<a href="" ng-click="addToWishList(item.productID,globals.currentUser.userId)" class="btn btn-default btn-sm"><i class="fa fa-heart"></i>Add to WishList</a>
							
							</p>
							
						</div>
						<!-- /.text -->
						
						
							 <div ng-show="item.inventoryQty == 0" class="ribbon sale new">
                                    <div class="theribbon">Out of stock</div>
                                    <div class="ribbon-background"></div>
                                </div>
						
					</div>
					<!-- /.product -->
				</div>


				<!-- /.col-md-4 -->
			</div>
		<!-- 	ng-if="pagedItemsLength >= 8"{{pagedItemsLength}} -->
			<div ng-show="pagedItems[currentPage].length >= 8 && filteredItemssize == 0" class="pagination pull-right">
				<ul>
					<li ng-class="{disabled: currentPage == 0}"><a href
						ng-click="prevPage()">« Prev</a></li>
					<li ng-repeat="n in range(pagedItems.length)"
						ng-class="{active: n == currentPage}" ng-click="setPage()"><a
						href ng-bind="n + 1">1</a></li>
					<li ng-class="{disabled: currentPage == pagedItems.length - 1}">
						<a href ng-click="nextPage()">Next »</a>
					</li>
				</ul>
			</div>
			
			<div ng-show="pagedItems[currentPage].length >= 8 && filteredItemssize >= 8" class="pagination pull-right">
				<ul>
					<li ng-class="{disabled: currentPage == 0}"><a href
						ng-click="prevPage()">« Prev</a></li>
					<li ng-repeat="n in range(pagedItems.length)"
						ng-class="{active: n == currentPage}" ng-click="setPage()"><a
						href ng-bind="n + 1">1</a></li>
					<li ng-class="{disabled: currentPage == pagedItems.length - 1}">
						<a href ng-click="nextPage()">Next »</a>
					</li>
				</ul>
			</div>
			<!-- /.products -->

	
		</div>
		<!-- /.col-md-9 -->
	</div>
	
	<div class="col-md-1"></div>
	
	<!-- /.container -->
	</div>