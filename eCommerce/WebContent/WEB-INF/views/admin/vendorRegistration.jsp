<div id="content">
	<div class="container">
<!-- 
		<div class="col-md-12">

			<ul class="breadcrumb">
				<li><a href="#">Home</a></li>
				<li>New account</li>
			</ul>

		</div> -->
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<div class="box">
			<hr>

				<form name="myForm" ng-submit="submitVendorAccount()">
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
							<div class="checkbox">
  							<label><input type="checkbox" value="" ng-model="isMangedByVendor"> Managed by Vendor</label>
						</div>
						</div>
						<div class="col-sm-6">
							<img class="profile-pic" src="" />
<div class="upload-button">Upload Image</div>
 <input class="file-upload" type="file" accept="image/*"/> 
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


							<div class="form-group required">
								<label class='control-label' for="password">Password</label> <input
									type="password" class="form-control" id="password"  ng-model="user.password" 
									required="required">
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
							<div class="form-group required">
								<label class='control-label' for="country">Country</label> <select
									class="form-control" id="country" ng-model="user.userCountry" ng-options="country.countryName for country in countries" ng-change="setStates(user.userCountry)" required="required"></select>
							</div>
						</div>

						<div class="col-sm-6 col-md-3">
							<div class="form-group required">
								<label class='control-label' for="state">State</label> <select class="form-control"
									id="state" ng-model="user.userState" ng-options="state.stateName for state in states" ng-change="setCities(user.userState)" required="required"></select>
							</div>
						</div>
						<div class="col-sm-6 col-md-3">
							
							
								<div class="form-group required">
								<label class='control-label' for="city">City</label> <select class="form-control"
									id="city" ng-model="user.userCity" ng-options="city.cityName for city in cities" ng-change="setCity(user.userCity)" required="required"></select>
							</div>
						</div>
					</div>

					<div class="text-center">
						<button type="submit" class="btn btn-primary" >
							<i class="fa fa-user-md"></i> Register
						</button>
						<button type="button" class="btn btn-primary" ng-click="reset()">
							<i class="fa fa-refresh" aria-hidden="true"></i>Reset
						</button>
					</div>
				</form>
			</div>
		</div>
		
		<div class="col-md-3"></div>
	</div>
	<!-- /.container -->
</div>
<!-- /#content -->

