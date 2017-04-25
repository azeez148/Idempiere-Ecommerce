
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>

</head>
<script type="text/javascript">
        var sortingOrder = 'name';
    </script>
    
<div id="content">
	<div class="container">

	<!-- 	<div class="col-md-12">
			<ul class="breadcrumb">
				<li><a href="#">Home</a></li>
				<li>Shopping cart</li>
			</ul>
		</div> -->

		<div class="col-md-9" id="basket">

			<div class="box">

				<form method="post" action="checkout1.html">

					<h1>Shopping cart</h1>
					<p class="text-muted">
						You currently have
						{{cartListSize}}
						item(s) in your cart.
					</p>
					<div class="table-responsive">
					


						<table class="table table-striped table-condensed table-hover">
							<thead>
								<tr>
									<th class="id"> &nbsp;<a ng-click="sort_by('id')"><i
											class="icon-sort"></i></a></th>
									<th class="name">Item Name&nbsp;<a
										ng-click="sort_by('name')"><i class="icon-sort"></i></a></th>
									<th class="description">Quantity&nbsp;<a
										ng-click="sort_by('description')"><i class="icon-sort"></i></a></th>
									<th class="field3">Unit price&nbsp;<a
										ng-click="sort_by('field3')"><i class="icon-sort"></i></a></th>
									<th class="field4">Discount&nbsp;<a
										ng-click="sort_by('field4')"><i class="icon-sort"></i></a></th>
									<th class="field5">Total&nbsp;<a
										ng-click="sort_by('field5')"><i class="icon-sort"></i></a></th>
								</tr>
							</thead>
							<tfoot>
								<td>
									<div class="pagination pull-right">
										<ul>
											<li ng-class="{disabled: currentPage == 0}"><a href
												ng-click="prevPage()">« Prev</a></li>
											<li ng-repeat="n in range(pagedItems.length)"
												ng-class="{active: n == currentPage}" ng-click="setPage()">
												<a href ng-bind="n + 1">1</a>
											</li>
											<li
												ng-class="{disabled: currentPage == pagedItems.length - 1}">
												<a href ng-click="nextPage()">Next »</a>
											</li>
										</ul>
									</div>
								</td>
							</tfoot>
							<tbody>
								<tr
									ng-repeat="item in pagedItems[currentPage] | orderBy:sortingOrder:reverse">
									<td><img
									ng-src="resources/img/ProductIMG/{{item.product.logoID}}.png" alt=""
									class="img-responsive"/></td>
									
									<td>
									<a href="#/product/{{item.product.productID}}"> {{item.product.name}} </a></td>
																	<!-- <td>{{item.quantity}}</td> -->
									<td><input type="Number" ng-model="item.quantity" value="{{item.quantity}}"  min="1" max="99" ng-change="updateSum(item.product.priceStd * item.quantity,$index)"/></td>
									<td>{{item.product.priceStd}}</td>
									<td>$0.00</td>
									<td><input class="form-control total-price" id="ex1" type="text" value="{{item.product.priceStd * item.quantity}}" readonly="readonly"/></td>
									 <td><a href="" ng-click="deleteProductFromCart(item.cartId,item.product.productID,item.userId,$index)"><i class="fa fa-trash-o"></i></a>
<!-- 									 <td><a href="#/cart/del/{{item.cartId}}/{{item.product.productID}}/{{item.userId}}"><i class="fa fa-trash-o"></i></a>
 -->								</tr>
							</tbody>
						</table>

					</div>
					<!-- /.table-responsive -->

					<div class="box-footer">
						<div class="pull-left">
							<!-- <a href="#/allCategories" class="btn btn-default"><i -->
							<a href="" ng-click="getPreviousPage()" class="btn btn-default"><i
								class="fa fa-chevron-left"></i> Continue shopping</a>
						</div>
						<div class="pull-right">
						<!-- 	<button class="btn btn-default">
								<i class="fa fa-refresh"></i> Update basket
							</button> -->
							<button type="submit" class="btn btn-primary" disabled="disabled">
								Proceed to checkout <i class="fa fa-chevron-right"></i>
							</button>
						</div>
					</div>

				</form>

			</div>
			

		</div>
		<!-- /.col-md-9 -->

		<div class="col-md-3">
			<div class="box" id="order-summary">
				<div class="box-header">
					<h3>Order summary</h3>
				</div>
				<p class="text-muted">Shipping and additional costs are
					calculated based on the values you have entered.</p>

				<div class="table-responsive">
					<table class="table">
						<tbody>
							<tr>
								<td>Order subtotal</td>
							<!-- 	<th ng-init="getSum()">{{orderSum}}</th> -->
								<th ng-init="getSum()">{{orderSum}}</th>
							</tr>
							<tr>
								<td>Shipping and handling</td>
								<th>{{shippingCharge}}</th>
							</tr>
							<tr>
								<td>Tax</td>
								<th>{{taxAmount}}</th>
							</tr>
							<tr class="total">
								<td>Total</td>
								<th ng-init="getTotal(orderSum,shippingCharge,taxAmount)">{{orderTotal}}</th>
							</tr>
						</tbody>
					</table>
				</div>

			</div>


		</div>
		<!-- /.col-md-3 -->

	</div>
	<!-- /.container -->
</div>
<!-- /#content -->