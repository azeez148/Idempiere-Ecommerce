<div id="content">
	<div class="container">

		<div class="col-md-12">

			<ul class="breadcrumb">
				<li><a href="#">Home</a></li>
				<li>New account</li>
			</ul>

		</div>
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<div class="box">
				<h1>New account</h1>

				<p class="lead">Not our registered customer yet?</p>
				<p>With registration with us new world of fashion, fantastic
					discounts and much more opens to you! The whole process will not
					take you more than a minute!</p>
				<p class="text-muted">
					If you have any questions, please feel free to <a
						href="contact.html">contact us</a>, our customer service center is
					working for you 24/7.
				</p>

				<hr>

				<form name="myForm" ng-submit="submit()">
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
								<label class='control-label' for="phone">Mobile number</label> <input
									type="text" class="form-control"  ng-model="user.userMobile"  id="phone" required="required">
							</div>
						</div>
					</div>
					<!-- /.row -->

					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="email">Email</label> 
								<input type="text"
									class="form-control" id="email"  ng-model="user.userEmail" >
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
								<label for="country">Country</label> <select
									class="form-control" id="country" ng-model="user.userCountry" ng-options="country.countryName for country in countries" ng-change="setStates(user.userCountry)" required="required"></select>
							</div>
						</div>

						<div class="col-sm-6 col-md-3">
							<div class="form-group required">
								<label for="state">State</label> <select class="form-control"
									id="state" ng-model="user.userState" ng-options="state.stateName for state in states" ng-change="setCities(user.userState)" required="required"></select>
							</div>
						</div>
						<div class="col-sm-6 col-md-3">
							
							
								<div class="form-group required">
								<label for="city">City</label> <select class="form-control"
									id="city" ng-model="user.userCity" ng-options="city.cityName for city in cities" ng-change="setCity(user.userCity)" required="required"></select>
							</div>
						</div>
					</div>

					<div class="text-center">
						<button type="submit" class="btn btn-primary" >
							<i class="fa fa-user-md"></i> Register
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

