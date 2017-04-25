<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<head>
<!-- <script src="resources/app/other/front.js"></script> 
 --></head>

	<div id="all">
		<!-- *** FOOTER ***
 _________________________________________________________ -->
		<div id="footer">
			<div class="container">
				<div class="row">
				
					<!-- <div class="col-md-1 col-sm-6">
						

					</div>
				 -->
					<div class="col-md-4 col-sm-6 pages-footer">
						<h4><spring:message code="eco.footer.pagehead" /></h4>

						<ul>
							<li><a href="text.html">About us</a></li>
							<li><a href="text.html">Terms and conditions</a></li>
							<li><a href="faq.html">FAQ</a></li>
							<li><a href="contact.html">Contact us</a></li>
						</ul>

						<hr>

						<h4>User section</h4>

						<ul>
							<li><a href="#" data-toggle="modal"
								data-target="#login-modal">Login</a></li>
							<li><a href="register.html">Regiter</a></li>
						</ul>

						<hr class="hidden-md hidden-lg hidden-sm">

					</div>
					<!-- /.col-md-3 -->

	<%-- 				<div class="col-md-3 col-sm-6">

						<h4><spring:message code="eco.footer.categoryhead" /></h4>

						<h5>Men</h5>

						<ul>
							<li><a href="category.html">T-shirts</a></li>
							<li><a href="category.html">Shirts</a></li>
							<li><a href="category.html">Accessories</a></li>
						</ul>

						<h5>Ladies</h5>
						<ul>
							<li><a href="category.html">T-shirts</a></li>
							<li><a href="category.html">Skirts</a></li>
							<li><a href="category.html">Pants</a></li>
							<li><a href="category.html">Accessories</a></li>
						</ul>

						<hr class="hidden-md hidden-lg">

					</div> --%>
					<!-- /.col-md-3 -->

					<div class="col-md-4 col-sm-6">

						<h4><spring:message code="eco.footer.comphead" /></h4>

						<p>
							<strong><spring:message code="eco.company.name" /></strong> <br><spring:message code="eco.company.address1" /><br><spring:message code="eco.company.address2" />
							<br><spring:message code="eco.company.city" /><br><spring:message code="eco.company.district" />
							<spring:message code="eco.company.state" /> <br> <strong><spring:message code="eco.company.country" /></strong>
						</p>

						<a href="contact.html">Go to contact page</a>

						<hr class="hidden-md hidden-lg">

					</div>
					<!-- /.col-md-3 -->



					<div class="col-md-4 col-sm-6">

						<h4><spring:message code="eco.footer.subscribehead" /></h4>

						<p class="text-muted"><spring:message code="eco.footer.subscribedesc" /></p>

						<form>
							<div class="input-group">

								<input type="text" class="form-control"> <span
									class="input-group-btn">

									<button class="btn btn-default" type="button">Subscribe!</button>

								</span>

							</div>
							<!-- /input-group -->
						</form>

						<hr>

						<h4><spring:message code="eco.footer.sharehead" /></h4>

						<p class="social">
							<a href="#" class="facebook external" data-animate-hover="shake"><i
								class="fa fa-facebook"></i></a> <a href="#" class="twitter external"
								data-animate-hover="shake"><i class="fa fa-twitter"></i></a> <a
								href="#" class="instagram external" data-animate-hover="shake"><i
								class="fa fa-instagram"></i></a> <a href="#" class="gplus external"
								data-animate-hover="shake"><i class="fa fa-google-plus"></i></a>
							<a href="#" class="email external" data-animate-hover="shake"><i
								class="fa fa-envelope"></i></a>
						</p>


					</div>
					<!-- /.col-md-3 -->

				</div>
				<!-- /.row -->

			</div>
			<!-- /.container -->
		</div>
		<div id="copyright">
			<div class="container">
				<div class="col-md-12">
					<p class="pull-right"><spring:message code="eco.company.copyrghit" /></p>

				</div>
				<!-- 		<div class="col-md-6">
						<p class="pull-right">
							eCommerce Site by <a
								href=" http://www.nestgroup.net "></a>
							with support from <a href=" http://www.nestgis.com/nestit.html "> </a>
							Not removing these links is part of the licence conditions of the template. Thanks for understanding :)
						</p>
					</div> -->
			</div>
		</div>
		<!-- /#footer -->
	</div>
	<!-- *** FOOTER END *** -->

