<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<head>

 
</head>
<!--  <script src="resources/app/other/front.js"></script> 
 --><!-- *** Header ***
 _________________________________________________________ -->
<div id="top">
	<div class="container">
		<div  class="col-md-6 offer">
		<div ng-if="globals.currentUser.userRole != 'SuperAdmin'" >
			<a href="#" class="btn btn-success btn-sm" data-animate-hover="shake"><spring:message
					code="eco.header.offerday" /></a> <a href="#">Get flat 35% off on
				orders over $50!</a>
				</div>
				<div ng-if="globals.currentUser.userRole == 'SuperAdmin'" >
		<h4>eCommerce Admin Panel</h4>	
				</div>
		</div>
	
	<div ng-if="globals.currentUser.userId == null">
	
	<div class="col-md-6" ng-init="getWishListSize(0)">

			<ul class="menu" ng-show ="globals.currentUser.username == null">
				<li><a href="" data-toggle="modal" data-target="#login-modal"><spring:message
							code="eco.link.login" /></a></li>
				<li><a href="#/register"><spring:message
							code="eco.link.register" /></a></li>
				<%-- <li><a href="contact.html"><spring:message code="eco.link.contact" /></a></li> --%>
				<%-- <li><a href="#"><spring:message code="eco.index.hotweek" />Recently viewed</a></li> --%>
			</ul>
<!-- <<<<<<< .mine		<div ng-show ="globals.currentUser.username != null"> 
		<i class="fa fa-user fa-2x user-profile-icon" aria-hidden="true"></i>
			<span class="username-text">Welcome {{globals.currentUser.username}}</span>
			
			
			
		 	<p><a href="#/login" class="btn btn-primary">Logout</a></p>
=======			 -->
<ul ng-show ="globals.currentUser.username != null"> 
	
				
				<li class="dropdown username-text"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false"> <i
							class="fa fa-user fa-2x dropbtn"
							aria-hidden="true"></i> Welcome {{globals.currentUser.username}}<span
							class="caret"></span>
							</a>
							<ul class="dropdown-menu sub-menu-header">
								<li ng-if="globals.currentUser.userId == null"><a href="#/wish/0/0"><i class="fa fa-heart fa-1x"></i>
										Wish List({{wishListSize}})
									</a>
								
								</li>
									<li ng-if="globals.currentUser.userId != null"><a href="#/wish/0/{{globals.currentUser.userId}}"><i class="fa fa-heart fa-1x"></i>
										Wish List({{wishListSize}})
									</a>
								
								</li>
								<li><a href="#/customer-Account"><i class="fa fa-user fa-1x"></i>
										User Profile
									</a>
								
								</li>
								
								<li ng-click = "logOut()" ><a href="#/home"><i class="fa fa-sign-out fa-1x"></i>
										Log Out
									</a>
								
								</li>
							
							
							</ul>
				
				</li>
		 	</ul>
		 

		 

		
		</div>
		
		</div>
		<div ng-if="globals.currentUser.userId != null">
		
			<div class="col-md-6" ng-init="getWishListSize(globals.currentUser.userId)">

			<ul class="menu" ng-show ="globals.currentUser.username == null">
				<li><a href="" data-toggle="modal" data-target="#login-modal"><spring:message
							code="eco.link.login" /></a></li>
				<li><a href="#/register"><spring:message
							code="eco.link.register" /></a></li>
				<%-- <li><a href="contact.html"><spring:message code="eco.link.contact" /></a></li> --%>
				<%-- <li><a href="#"><spring:message code="eco.index.hotweek" />Recently viewed</a></li> --%>
			</ul>
<!-- <<<<<<< .mine		<div ng-show ="globals.currentUser.username != null"> 
		<i class="fa fa-user fa-2x user-profile-icon" aria-hidden="true"></i>
			<span class="username-text">Welcome {{globals.currentUser.username}}</span>
			
			
			
		 	<p><a href="#/login" class="btn btn-primary">Logout</a></p>
=======			 -->
<ul ng-show ="globals.currentUser.username != null"> 
	
				
				<li class="dropdown username-text"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false"> <i
							class="fa fa-user fa-2x dropbtn"
							aria-hidden="true"></i> Welcome {{globals.currentUser.username}}<span
							class="caret"></span>
							</a>
							<ul class="dropdown-menu sub-menu-header">
								<li ng-if="globals.currentUser.userId == null && globals.currentUser.userRole != 'SuperAdmin'"><a href="#/wish/0/0"><i class="fa fa-heart fa-1x"></i>
										Wish List({{wishListSize}})
									</a>
								
								</li>
									<li ng-if="globals.currentUser.userId != null && globals.currentUser.userRole != 'SuperAdmin'"><a href="#/wish/0/{{globals.currentUser.userId}}"><i class="fa fa-heart fa-1x"></i>
										Wish List({{wishListSize}})
									</a>
								
								</li>
								<li><a href="#/customer-Account"><i class="fa fa-user fa-1x"></i>
										User Profile
									</a>
								
								</li>
								
								<li ng-click = "logOut()" ><a href="#/home"><i class="fa fa-sign-out fa-1x"></i>
										Log Out
									</a>
								
								</li>
							
							
							</ul>
				
				</li>
		 	</ul>
		 

		 

		
		</div>
		
		
		
		</div>
		
	</div>
	<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
		aria-labelledby="Login" aria-hidden="true">
		<div class="modal-dialog modal-sm">

			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="Login">
						<spring:message code="eco.header.loginhead" />
					</h4>
				</div>
				<div class="modal-body">
						<div ng-class="{ 'alert': flash, 'alert-success': flash.type === 'success', 'alert-danger': flash.type === 'error' }" ng-if="flash" ng-bind="flash.message"></div>
						<form name="form" ng-submit="login()">
							<div class="form-group"
								ng-class="{ 'has-error': form.username.$dirty && form.username.$error.required }">
								<input type="text" name="username" placeholder="User Name" id="username" class="form-control" ng-model="user.username" required /> 
								<span ng-show="form.username.$dirty && form.username.$error.required" class="help-block">Username is required</span>
							</div>
							<div class="form-group"
								ng-class="{ 'has-error': form.password.$dirty && form.password.$error.required }">
								<input type="password" name="password" placeholder="Password" id="password" class="form-control" ng-model="user.password" required /> 
								<span ng-show="form.password.$dirty && form.password.$error.required" class="help-block">Password is required</span>
							</div>
							<div class="form-actions">
								<p class="text-center">
								<button type="submit" ng-disabled="form.$invalid || user.dataLoading"
									class="btn btn-primary">Login</button></p>
								<img ng-if="user.dataLoading"
									src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA==" />
								<p class="text-center text-muted"> <spring:message code="eco.header.notregister" />
							</p>
								<p class="text-center text-muted">
								<a href="#/register"  class="btn btn-link"><strong> <spring:message code="eco.link.registernow" /></strong></a>
							</p>
							</div>
						</form>

						<%-- <div class="form-group">
									<input ng-modal="email" type="text" class="form-control" id="email-modal"
										placeholder="email">
								</div>
								<div class="form-group">
									<input ng-modal="password" type="password" class="form-control" id="password-modal"
										placeholder="password">
								</div>

								<p class="text-center">
									<button class="btn btn-primary">
										<i class="fa fa-sign-in"></i><spring:message code="eco.button.login" />
									</button>`
								</p> --%>

				</div>
			</div>
		</div>
	</div>

</div>

<!-- *** TOP BAR END *** -->
