<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<!-- <script src="resources/app/other/jquery.flexslider.js"></script>
<script src="resources/app/other/jquery.flexslider.min.js "></script> -->
<script src="./resources/app/other/front.js"></script>
<script src="./resources/app/other/easyzoom.js"></script>

</head>





<script>

      $('.easyzoom').easyZoom({
    	// The text to display within the notice box while loading the zoom image.
    	loadingNotice: 'Loading image',

    	// The text to display within the notice box if an error occurs loading the zoom image.
    	errorNotice: 'Zoom feature coming soon..',

    	// Prevent clicks on the zoom image link.
    	preventClicks: true,

    	// Callback function to execute when the flyout is displayed.
    	onShow: undefined,

    	// Callback function to execute when the flyout is removed.
    	onHide: undefined
    	});

</script>

<div class="container">


	<div class="col-md-12">

	<div ng-init="getCategoryName(productCategoryId)">

                    <ul class="breadcrumb">
                        <li><a href="#">Home</a>
                        </li>
                        <li><a href="#/category/{{category.categoryID}}/0">{{category.name}}</a></li>
                         <li>{{product.name}}</li>
                    </ul>

                </div> 
	


		<div class="col-sm-1"></div>
		<div class="row" id="productMain">
			<div class="col-sm-3">

				<div class="row" id="mainImage">

					<div class="easyzoom easyzoom--overlay">
						<!--   <a href="img/bags/zoom.jpg"> -->
						<a href="resources/img/ProductIMG/{{product.logoID}}.png"> <img
							ng-src="resources/img/ProductIMG/{{product.logoID}}.png" alt=""
							class="img-responsive"></a>
					</div>
				</div>

				<div class="row" id="thumbs">
					<div class="col-xs-2">
						<a href="resources/img/ProductIMG/{{product.logoID}}.png"
							class="thumb"> <img
							ng-src="resources/img/ProductIMG/{{product.logoID}}.png" alt=""
							class="img-responsive">
						</a>
					</div>
					<div class="col-xs-2">
						<a href="resources/img/ProductIMG/{{product.logoID}}.png"
							class="thumb"> <img
							src="resources/img/ProductIMG/{{product.logoID}}.png" alt=""
							class="img-responsive">
						</a>
					</div>
					<div class="col-xs-2">
						<a href="resources/img/ProductIMG/{{product.logoID}}.png"
							class="thumb"> <img
							ng-src="resources/img/ProductIMG/{{product.logoID}}.png" alt=""
							class="img-responsive">
						</a>
					</div>
					<div class="col-xs-2">
						<a href="resources/img/ProductIMG/{{product.logoID}}.png"
							class="thumb"> <img
							ng-src="resources/img/ProductIMG/{{product.logoID}}.png" alt=""
							class="img-responsive">
						</a>
					</div>
					<div class="col-xs-2">
						<a href="resources/img/ProductIMG/{{product.logoID}}.png"
							class="thumb"> <img
							ng-src="resources/img/ProductIMG/{{product.logoID}}.png" alt=""
							class="img-responsive">
						</a>
					</div>
					<div class="col-xs-2">
						<a href="resources/img/ProductIMG/{{product.logoID}}.png"
							class="thumb"> <img
							ng-src="resources/img/ProductIMG/{{product.logoID}}.png" alt=""
							class="img-responsive">
						</a>
					</div>
				</div>


			</div>



			<div class="col-sm-5 box-product">
				<div class="box">
					<h1 class="text-center">{{product.name}}</h1>

					<div ng-show="product.inventoryQty != 0" class="stock text-center">Only
						{{product.inventoryQty}} left in stock</div>
					<div ng-show="product.inventoryQty == 0" class="stock text-center">Out
						of stock</div>

					<div ng-init="getAttributes()">
					
						<div ng-repeat="attributeHeader in AttributeList">
								<select  ng-model="selectedValue" ng-show="attributeHeader.name != 'Brand'" class="form-control size-select dropdown-product-attribute" ng-change="updateValue(selectedValue,attributeHeader.name)">
											
								<option value="0" ng-selected="attributeHeader.name">-- Select {{attributeHeader.name}}--</option>
								<option ng-repeat="attribute in attributeHeader.attributeValues" ng-show="attributeHeader.name == 'Size'"  value="{{attribute.value}}">{{attribute.value}} UK/India</option>
								<option ng-repeat="attribute in attributeHeader.attributeValues" ng-show="attributeHeader.name != 'Size'"  value="{{attribute.value}}">{{attribute.value}}</option>
								</select>
								
					</div>
			</div>


					<p class="goToDescription">
						<a href="#details" class="scroll-to">See more product details</a>
					</p>

					<div ng-show="product.discount != 0">
						<p class="price">
							<del>
								<i class="fa fa-inr rupee"></i> {{product.priceList}}
							</del>
							&nbsp; <span class="stdprice"> <i class="fa fa-inr rupee"></i>
								{{product.priceStd}}
							</span> <span class="taxtext">Inclusive of all taxes</span> <br> <span
								class="discountText">You Save:</span> <span class="discount"><i
								class="fa fa-inr rupee"></i>
								{{product.priceList-product.priceStd}} ({{product.discount}}%)</span>
						</p>


					</div>

					<div ng-show="product.discount == 0">
						<p class="price">
							<i class="fa fa-inr rupee"></i> {{product.priceList}} <span
								class="taxtext">Inclusive of all taxes</span>
						</p>


					</div>

				</div>

			</div>
			<div class="row col-sm-3 box-buttons">
				<div class="box">
				<!-- <p ng-repeat="attributeHeader in AttributeList" ng-show="selectedValue == false">To Buy,Select {{attributeHeader.name}}</p> -->
				
			<div class="alert alert-warning" ng-show="selectedValue == false">	<span>To Buy, Select </span> <span class="list-comma" ng-show="selectedValue == false && attributeHeader.name != 'Brand'" ng-repeat="attributeHeader in AttributeList">{{attributeHeader.name}}</span>
				</div>
				
				<div ng-if="globals.currentUser.userId != null">
				
					<p class="text-center buttons">
						<a href="#/cart/{{product.productID}}/{{globals.currentUser.userId}}" class="btn btn-primary"
							ng-disabled="product.inventoryQty == 0 || selectedValue == false"><i
							class="fa fa-shopping-cart"></i> Add to cart</a>
							
							 <a
							href="#/cart/{{product.productID}}/0" class="btn btn-primary"
							ng-disabled="true"><i class="fa fa-play"></i>Order
							Now</a>
							
							<!--  <a
							href="#/cart/{{product.productID}}/{{globals.currentUser.userId}}" class="btn btn-primary"
							ng-disabled="product.inventoryQty == 0 || selectedValue == false" ><i class="fa fa-play"></i>Order
							Now</a> -->
					</p>
					
					
					<p class="text-center buttons">
							<a href="#/wish/{{product.productID}}/{{globals.currentUser.userId}}" class="btn btn-default"><i class="fa fa-heart"></i> Add to wishlist</a>
					</p>

</div>

<div ng-if="globals.currentUser.userId == null">
				
					<p class="text-center buttons">
						<a href="#/cart/{{product.productID}}/0" class="btn btn-primary"
							ng-disabled="product.inventoryQty == 0 || selectedValue == false"><i
							class="fa fa-shopping-cart"></i> Add to cart</a>
							 <a
							href="#/cart/{{product.productID}}/0" class="btn btn-primary"
							ng-disabled="true"><i class="fa fa-play"></i>Order
							Now</a>
							
							<!--  <a
							href="#/cart/{{product.productID}}/0" class="btn btn-primary"
							ng-disabled="product.inventoryQty == 0 || selectedValue == false"><i class="fa fa-play"></i>Order
							Now</a> -->
					</p>
					
					
					<p class="text-center buttons">
							<a href="#/wish/{{product.productID}}/0" class="btn btn-default"><i class="fa fa-heart"></i> Add to wishlist</a>
					</p>

</div>



				</div>

			</div>
		</div>
		<div class="col-sm-12">
			<div class="col-sm-9">
				<div class="box" id="details">
					<p>
					<h4>Product details</h4>

					<p>{{product.documentNote}}</p>
					<!--      <h4>Material & care</h4>
                            <ul>
                                <li>Polyester</li>
                                <li>Machine wash</li>
                            </ul>
                            <h4>Size & Fit</h4>
                            <ul>
                                <li>Regular fit</li>
                                <li>The model (height 5'8" and chest 33") is wearing a size S</li>
                            </ul>

                            <blockquote>
                                <p><em>Define style this season with Armani's new range of trendy tops, crafted with intricate details. Create a chic statement look by teaming this lace number with skinny jeans and pumps.</em>
                                </p>
                            </blockquote>

                            <hr> -->

				</div>
			</div>
			<div class="col-sm-3"></div>

		</div>


		<div class="row same-height-row">
			<div class="col-md-3 col-sm-6">
				<div class="box same-height">
					<h3>You may also like these products</h3>
				</div>
			</div>

			<div class="col-md-3 col-sm-6">
				<div class="product same-height">
					<div class="flip-container">
						<div class="flipper">
							<div class="front">
								<a href="detail.html"> <img src="../img/bags/b8.jpg" alt=""
									class="img-responsive">
								</a>
							</div>
							<div class="back">
								<a href="detail.html"> <img src="../img/bags/b8.jpg" alt=""
									class="img-responsive">
								</a>
							</div>
						</div>
					</div>
					<a href="detail.html" class="invisible"> <img
						src="../img/bags/b8.jpg" alt="" class="img-responsive">
					</a>
					<div class="text">
						<h3>Fur coat</h3>
						<p class="price">$143</p>
					</div>
				</div>
				<!-- /.product -->
			</div>

			<div class="col-md-3 col-sm-6">
				<div class="product same-height">
					<div class="flip-container">
						<div class="flipper">
							<div class="front">
								<a href="detail.html"> <img src="../img/footwares/s7.jpg"
									alt="" class="img-responsive">
								</a>
							</div>
							<div class="back">
								<a href="detail.html"> <img src="../img/footwares/s7.jpg"
									alt="" class="img-responsive">
								</a>
							</div>
						</div>
					</div>
					<a href="detail.html" class="invisible"> <img
						src="../img/footwares/s7.jpg" alt="" class="img-responsive">
					</a>
					<div class="text">
						<h3>Fur coat</h3>
						<p class="price">$143</p>
					</div>
				</div>
				<!-- /.product -->
			</div>


			<div class="col-md-3 col-sm-6">
				<div class="product same-height">
					<div class="flip-container">
						<div class="flipper">
							<div class="front">
								<a href="detail.html"> <img src="../img/footwares/s8.jpg"
									alt="" class="img-responsive">
								</a>
							</div>
							<div class="back">
								<a href="detail.html"> <img src="../img/footwares/s8.jpg"
									alt="" class="img-responsive">
								</a>
							</div>
						</div>
					</div>
					<a href="detail.html" class="invisible"> <img
						src="../img/footwares/s8.jpg" alt="" class="img-responsive">
					</a>
					<div class="text">
						<h3>Fur coat</h3>
						<p class="price">$143</p>

					</div>
				</div>
				<!-- /.product -->
			</div>
		</div>
	</div>
	<!-- /.col-md-9 -->
</div>
<!-- /.container -->

