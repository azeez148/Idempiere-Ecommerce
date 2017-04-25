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
			<h2>Create Product Category</h2>
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
							<div class="form-group required">
								<label class='control-label' for="firstname">Category Name</label> <input
									type="text" class="form-control"  ng-model="user.userName" id="firstname"
									required="required">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group required">
								<label class='control-label' for="country">Select Parent</label> <select
									class="form-control" id="country" ng-model="user.userCountry" ng-options="country.countryName for country in countries" ng-change="setStates(user.userCountry)" required="required"></select>
							</div>
						</div>
					</div>
					<!-- /.row -->


					<div class="text-center">
						<button type="submit" class="btn btn-primary" >
							<i class="fa fa-user-md"></i> Create
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

