
<div id="content">
	<div class="container">
		<div class="col-sm-1"></div>

		<div class="col-sm-10">

<div class="box">
<form class="form-inline">
  <div class="form-group search-user">
   <input ng-model="searchKeyword" class="form-control"
						id="searchKeyword" placeholder="Enter any Search Keyword">
  </div>
<!-- <a class="btn btn-primary create-button" href="#/createCategory">Create Category</a>
 -->
 
<a class="btn btn-primary create-button" data-toggle="modal" ng-click="openCreateModal()"> <i class="fa fa-plus-circle" aria-hidden="true"></i>Create Price List</a>
 
</form>
</div>

		

<div class="box">


				<h2>
					<span class="text-center">Manage Price Lists</span>
				</h2>
				
				<h5>Total number of items : {{itemsSize}}</h5>
				
<div class="alert alert-success" ng-show="createdSuccessMsg != null">
				<span class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>
				{{createdSuccessMsg}}
				</div>
						<div class="alert alert-danger" ng-show="createdErrorMsg != null">
				<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				{{createdErrorMsg}}
				</div>
				<div class="alert alert-danger" ng-show="nameErrorMsg != null">
				<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				{{nameErrorMsg}}
				</div>
					<div class="alert alert-danger" ng-show="mobileErrorMsg != null">
					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				{{mobileErrorMsg}}
				</div>
					<div class="alert alert-danger" ng-show="passwordErrorMsg != null">
					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				{{passwordErrorMsg}}
				</div>
					<div class="alert alert-danger" ng-show="emailErrorMsg != null">
					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				{{emailErrorMsg}}
				</div>


					<div class="table-responsive">

					<table class="table table-sm table-striped table-condensed table-hover table-bordered">
						<thead>

							<tr>
								<th class="id" custom-sort order="'id'" sort="sort">Id&nbsp;</th>
								<!-- <th class="logo" custom-sort order="'logo'">Logo&nbsp;</th> -->
								<th class="name" custom-sort order="'name'" sort="sort">Name&nbsp;</th>
								<th class="description" custom-sort order="'description'"
									sort="sort">Sales Price List&nbsp;</th>
							<!-- 	<th class="field3" custom-sort order="'field3'" sort="sort">Email&nbsp;</th>
								<th class="field4" custom-sort order="'field4'" sort="sort">Country&nbsp;</th>
								<th class="field4" custom-sort order="'field5'" sort="sort">State&nbsp;</th>
								<th class="field4" custom-sort order="'field6'" sort="sort">City&nbsp;</th> -->
<!-- 								<th class="field4" custom-sort order="'field6'" sort="sort">Managed By Vendor&nbsp;</th>
 -->								<th class="field6" custom-sort order="'field8'" sort="sort">Status&nbsp;</th>
								<th class="field7" custom-sort order="'field9'" sort="sort">&nbsp;</th>
							</tr>
						</thead>
						<tfoot>
							<td colspan="12">
								<div class="pagination pull-right">
									<ul>
										<li ng-class="{disabled: currentPage == 0}"><a href
											ng-click="prevPage()">« Prev</a></li>

										<li
											ng-repeat="n in range(pagedItems.length, currentPage, currentPage + gap) "
											ng-class="{active: n == currentPage}" ng-click="setPage()">
											<a href ng-bind="n + 1">1</a>
										</li>

										<li
											ng-class="{disabled: (currentPage) == pagedItems.length - 1}">
											<a href ng-click="nextPage()">Next »</a>
										</li>
									</ul>
								</div>
							</td>
						</tfoot>
				
						<tbody>
							<tr
								ng-repeat="item in pagedItems[currentPage] | orderBy:sort.sortingOrder:sort.reverse | filter: searchKeyword">
								<td>{{item.priceListId}}</td>
								
								<!-- <td><img
									ng-src="resources/img/vendor/logo/{{item.userId}}.jpg" alt="" class="img-responsive"/></td>
								 -->
								<td>{{item.name}}</td>
								<td>
								
								 <h6><span ng-if="item.isSalesPriceList == 'Y'" class="label label-success">Yes</span></h6>
									<h6><span ng-if="item.isSalesPriceList == 'N'" class="label label-danger">No</span></h6> 
								</td>
							
								<!-- <td>
								 <input type="checkbox" ng-model="item.isManagedByVendor" disabled="disabled">
								</td> -->
								
								<td>
								
							
							
								 <h6><span ng-if="item.isActive == 'Y'" class="label label-success">Active</span></h6>
									<h6><span ng-if="item.isActive == 'N'" class="label label-danger">InActive</span></h6> 
								
								</td>
								
								<!-- data-target="#blockUser" -->
								<td>
								<a class="btn btn-info btn-xs" data-toggle="modal" ng-click="openUpdateModal(item)"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>Update</a>
								<a class="btn btn-danger btn-xs" data-toggle="modal"  ng-click="openModal(item)"><span ng-if="item.isActive == 'Y'"><i class="fa fa-eye-slash" aria-hidden="true"></i>
Deactivate</span>
								<span ng-if="item.isActive == 'N'"><i class="fa fa-eye" aria-hidden="true"></i>
								Activate</span>
								</a>
								<!-- <a class="btn btn-info btn-xs" data-toggle="modal" ng-click="openContactModal(item)">Contact Category</a> -->
								
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				 




			</div>
			<!-- box ends here -->




		</div>
		<div class="col-sm-1"></div>


		<!-- Create Category Modal -->
		<div class="modal fade" id="createCategory" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Create Price List</h4>
					</div>
					<div class="modal-body">
					
			<form name="createCategoryForm">
				
				
				<div class="alert alert-success" ng-show="createdSuccessMsg != null">
				
				{{createdSuccessMsg}}
				</div>
						<div class="alert alert-danger" ng-show="createdErrorMsg != null">
				
				{{createdErrorMsg}}
				</div>
				<div class="alert alert-danger" ng-show="nameErrorMsg != null">
				
				{{nameErrorMsg}}
				</div>
					<div class="alert alert-danger" ng-show="mobileErrorMsg != null">
				{{mobileErrorMsg}}
				</div>
					<div class="alert alert-danger" ng-show="passwordErrorMsg != null">
				{{passwordErrorMsg}}
				</div>
					<div class="alert alert-danger" ng-show="emailErrorMsg != null">
				{{emailErrorMsg}}
				</div>
				
				
				
	
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group required">
								<label class='control-label' for="name">Price List Name</label> <input
									type="text" class="form-control"  ng-model="category.name" id="name"
									required="required">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label class='control-label' for="country">Select Parent</label> <select
									class="form-control" id="country" ng-model="category.parentID" ng-options="category.name for category in categories"></select>
							</div>
						</div>
					</div>
					<!-- /.row -->

					

				
				</form>
					
					</div>
					<div class="modal-footer text-center">
								
						<button type="button" class="btn btn-primary" ng-click="submitCategory(category)" >
							<i class="fa fa-plus-circle" aria-hidden="true"></i> Create
						</button>
						<button type="button" class="btn btn-primary" ng-click="resetPage()">
							<i class="fa fa-refresh" aria-hidden="true"></i>Reset
						</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		
		
		<!-- Update Category Modal -->
		<div class="modal fade" id="updateCategory" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Update Price List</h4>
					</div>
					<div class="modal-body">
					
			<form name="createCategoryForm">
				
				
				<div class="alert alert-success" ng-show="createdSuccessMsg != null">
				
				{{createdSuccessMsg}}
				</div>
						<div class="alert alert-danger" ng-show="createdErrorMsg != null">
				
				{{createdErrorMsg}}
				</div>
				<div class="alert alert-danger" ng-show="nameErrorMsg != null">
				
				{{nameErrorMsg}}
				</div>
					<div class="alert alert-danger" ng-show="mobileErrorMsg != null">
				{{mobileErrorMsg}}
				</div>
					<div class="alert alert-danger" ng-show="passwordErrorMsg != null">
				{{passwordErrorMsg}}
				</div>
					<div class="alert alert-danger" ng-show="emailErrorMsg != null">
				{{emailErrorMsg}}
				</div>
				
				
				
	
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group required">
								<label class='control-label' for="name">Price List Name</label> <input
									type="text" class="form-control"  ng-model="category.name" id="name"
									required="required">
							</div>
						</div>
							<div class="col-sm-4">
							<div class="form-group">
								<label class='control-label' for="name">Current Parent Category</label> <input
									type="text" class="form-control"  ng-model="category.parentName" id="name" readonly="readonly">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class='control-label' for="country">New Parent </label> 
								
							<!-- 	<input
									type="text" class="form-control"  ng-model="category.parentName" id="name"
									readonly="readonly"> -->
								
								
						 	<select
									class="form-control" id="country" ng-model="category.parentID" ng-options="category.name for category in categories"></select>  
					
							
							
							 </div>
						</div>
					</div>
					<!-- /.row -->

					

				
				</form>
					
					</div>
					<div class="modal-footer text-center">
								
						<button type="button" class="btn btn-primary" ng-click="updateCategory(category)" >
							<i class="fa fa-pencil-square-o" aria-hidden="true"></i> Update
						</button>
						<!-- <button type="button" class="btn btn-primary" ng-click="resetPage()">
							<i class="fa fa-refresh" aria-hidden="true"></i>Reset
						</button> -->
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>


		<!-- Block Category Modal -->
		<div class="modal fade" id="blockCategory" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Confirmation</h4>
					</div>
					<div class="modal-body">
					<h3>Do you want to <span ng-if="category.isActive == 'Y'">De-Activate </span><span ng-if="category.isActive == 'N'">Activate </span>{{category.name}}</h3>
					
					
					</div>
					<div class="modal-footer text-center">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary" ng-click="updateCategoryStatus(category)"><i class="fa fa-floppy-o" aria-hidden="true"></i>Save changes</button>
					</div>
				</div>
			</div>
		</div>

		

	</div>
</div>