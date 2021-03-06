
<div id="content">
	<div class="container">
		<div class="col-sm-1"></div>

		<div class="col-sm-10" ng-init="getAllVendors()">

<div class="box">
<form class="form-inline">
  <div class="form-group search-user">
   <input ng-model="searchKeyword" class="form-control"
						id="searchKeyword" placeholder="Enter any Search Keyword">
  </div>
<a class="btn btn-primary create-button" href="#/registerVendor"><i class="fa fa-plus-circle" aria-hidden="true"></i> Create Vendor</a>

</form>
</div>

		

<div class="box">


				<h2>
					<span class="text-center">Manage Vendors</span>
				</h2>
				
				<h5>Total Number of Vendors : {{itemsSize}}</h5>
				
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
								<th class="id" custom-sort order="'userId'" sort="sort">Id&nbsp;</th>
								<th class="logo">Logo&nbsp;</th>
								<th class="name" custom-sort order="'userName'" sort="sort">Name&nbsp;</th>
								<th class="description" custom-sort order="'userMobile'"
									sort="sort">Mobile&nbsp;</th>
								<th class="field3" custom-sort order="'userEmail'" sort="sort">Email&nbsp;</th>
								<!-- <th class="field4" custom-sort order="'userCountryName'" sort="sort">Country&nbsp;</th>
								<th class="field4" custom-sort order="'userStateName'" sort="sort">State&nbsp;</th>
								<th class="field4" custom-sort order="'userCityName'" sort="sort">City&nbsp;</th> -->
<!-- 								<th class="field4" custom-sort order="'field6'" sort="sort">Managed By Vendor&nbsp;</th>
 -->								<th class="field6">Status&nbsp;</th>
								<th class="field7">&nbsp;</th>
							</tr>
						</thead>
						<tfoot>
						<td ng-init="getItemsPerPage()"> <select name="mySelect" id="mySelect"
      ng-options="option.name for option in data.availableOptions track by option.id"
      ng-model="data.selectedOption" class="form-control" ng-change="updateItemsPerPage(data.selectedOption)"></select></td>
							<td colspan="12">
								<div class="pagination pull-right">
									<ul>
										<li ng-class="{disabled: currentPage == 0}"><a href
											ng-click="prevPage()">� Prev</a></li>

										<li
											ng-repeat="n in range(pagedItems.length, currentPage, currentPage + gap) "
											ng-class="{active: n == currentPage}" ng-click="setPage()">
											<a href ng-bind="n + 1">1</a>
										</li>

										<li
											ng-class="{disabled: (currentPage) == pagedItems.length - 1}">
											<a href ng-click="nextPage()">Next �</a>
										</li>
									</ul>
								</div>
							</td>
						</tfoot>
				
						<tbody>
							<tr
								ng-repeat="item in pagedItems[currentPage] | orderBy:sort.sortingOrder:sort.reverse | filter: searchKeyword">
								<td>{{item.userId}}</td>
								
								<td><img
									ng-src="resources/img/vendor/logo/{{item.userId}}.jpg" alt="" class="img-responsive"/></td>
								
								<td>{{item.userName}}</td>
								<td>{{item.userMobile}}</td>
								<td>{{item.userEmail}}</td>
							<!-- 	<td>{{item.userCountryName}}</td>
								<td>{{item.userStateName}}</td>
								<td>{{item.userCityName}}</td> -->
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
								<a class="btn btn-danger btn-xs" data-toggle="modal"  ng-click="openModal(item)"><span ng-if="item.isActive == 'Y'"><i class="fa fa-eye-slash" aria-hidden="true"></i>Deactivate</span>
								<span ng-if="item.isActive == 'N'"><i class="fa fa-eye" aria-hidden="true"></i>
								Activate</span>
								</a>
								<a class="btn btn-info btn-xs" data-toggle="modal" ng-click="openContactModal(item)"><i class="fa fa-envelope-o" aria-hidden="true"></i>Contact Vendor</a>
								
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				 




			</div>
			<!-- box ends here -->




		</div>
		<div class="col-sm-1"></div>


		<!-- Update User Modal -->
		<div class="modal fade" id="updateVendor" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" ng-init="getCountries()">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Update Vendor</h4>
					</div>
					<div class="modal-body">
					
			<form name="myForm" ng-submit="submitVendorAccount()">
				
				
				
				
				<div class="row">
						<div class="col-sm-6">
							<div class="checkbox">
  							<label><input type="checkbox" value="" ng-model="user.isManagedByVendor"> Managed by Vendor</label>
						</div>
						</div>
						<div class="col-sm-6">
							<img class="profile-pic" ng-src="resources/img/vendor/logo/{{user.userId}}.jpg" />
								<!-- <div class="upload-button">Upload Image</div>
 										<input class="file-upload" type="file" accept="image/*"/>  -->
						</div>
					</div>
				
				
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group required">
								<label class='control-label' for="firstname">Name</label> <input
									type="text" class="form-control"  ng-model="user.userName" id="firstname"
									required="required">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group required">
								<label class='control-label' for="phone">Contact Mobile number</label> <input
									type="text" class="form-control"  ng-model="user.userMobile"  id="phone" required="required">
							</div>
						</div>
					</div>
					<!-- /.row -->

					<div class="row">
						<div class="col-sm-6">
							<div class="form-group required">
								<label class='control-label' for="email">Email</label> 
								<input type="text"
									class="form-control" id="email"  ng-model="user.userEmail" required="required">
							</div>
							
							
						</div>
						<div class="col-sm-6">


							<div class="form-group">
								<label class='control-label' for="password">Password</label> <input
									type="password" class="form-control" id="password"  ng-model="user.password" 
									required="required" readonly="readonly">
							</div>
						</div>
					</div>
					<!-- /.row -->
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="address1">Address Line 1</label> <input type="text"
									class="form-control" id="address1"  ng-model="user.userAddress1" >
							</div>
						</div>
						<div class="col-sm-6">


							<div class="form-group">
								<label for="address2">Address Line 2</label> <input type="text"
									class="form-control" id="address2"  ng-model="user.userAddress2" >
							</div>
						</div>
					</div>

					<div class="row">

						<div class="col-sm-6 col-md-3">
							<div class="form-group">
								<label for="zip">Pin Code</label> <input type="text"
									class="form-control" id="zip"  ng-model="user.userPinCode" >
							</div>
						</div>

						<div class="col-sm-6 col-md-3">
						
						<div class="form-group">
								<label class='control-label' for="country">Country</label><!-- <input type="text"
									class="form-control" id="zip"  ng-model="user.userCountryName" readonly="readonly"> -->
									
									<select ng-model="user.userCountry" ng-options="country.countryName for country in countries"  class="form-control"></select>
									
									
							</div>
						</div>

						<div class="col-sm-6 col-md-3">
						
						
						<div class="form-group">
								
								<label class='control-label' for="state">State</label> <select class="form-control"
									id="state" ng-model="user.userState" ng-options="state.stateName for state in user.userCountry.states"  required="required"></select>
									
							</div>
							</div>
						
						<div class="col-sm-6 col-md-3">
							
							
								<div class="form-group">
								<label class='control-label' for="city">City</label> <select class="form-control"
									id="city" ng-model="user.userCity" ng-options="city.cityName for city in user.userState.cities" required="required"></select>
							</div>
						</div>
					</div>

				
				</form>
					
					</div>
					<div class="modal-footer text-center">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary" ng-click="updateVendor(user)"><i class="fa fa-floppy-o" aria-hidden="true"></i> Save
							changes</button>
					</div>
				</div>
			</div>
		</div>



		<!-- Block User Modal -->
		<div class="modal fade" id="blockUser" tabindex="-1" role="dialog"
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
					<h3>Do you want to <span id="userState"> </span><span id="userName"> </span></h3>
					
					
					</div>
					<div class="modal-footer text-center">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary" ng-click="updateVendorStatus(user)"><i class="fa fa-floppy-o" aria-hidden="true"></i> Save changes</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Contact User Modal -->
		<div class="modal fade" id="contactUser" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel"><i class="fa fa-envelope-o" aria-hidden="true"></i> Contact User</h4>
					</div>
					<div class="modal-body">
					
					       <form>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label for="firstname">Name</label>
                                        <input type="text" class="form-control" id="firstname" ng-model="email.userName">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                     <div class="form-group">
                                        <label for="email">Email</label>
                                        <input type="text" ng-model="email.userEmail" class="form-control" id="email">
                                    </div>
                                </div>
                            
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <label for="subject">Subject</label>
                                        <input type="text" class="form-control" id="subject" ng-model="email.subject">
                                    </div>
                                </div>
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <label for="message">Message</label>
                                        <textarea id="message" class="form-control" ng-model="email.message"></textarea>
                                    </div>
                                </div>
                               
                            </div>
                            <!-- /.row -->
                        </form>
					</div>
					<div class="modal-footer text-center">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary" ng-click="sendMail(email)"><i class="fa fa-envelope-o"></i> Send message</button>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>