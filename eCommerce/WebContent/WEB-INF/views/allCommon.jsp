<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<!--  *** TOPBAR *** -->
	
		<div id="all">
			<div id="content">
				<!-- *** offers *** -->
				<jsp:directive.include file="latestOffers.jsp" />
				<!-- *** ADVANTAGES HOMEPAGE *** -->
				<jsp:directive.include file="advantages.jsp" />
				<!-- *** ADVANTAGES END *** -->
				<!-- *** HOT PRODUCT SLIDESHOW *** -->
				<jsp:directive.include file="hotSellingProducts.jsp" />
				<!-- *** HOT END *** -->
				<!-- *** GET INSPIRED *** -->
				<jsp:directive.include file="upComingProducts.jsp" />
				<!-- *** GET INSPIRED END *** -->
			</div>
			<!-- /#content -->

			<!-- *** FOOTER *** -->
			<jsp:directive.include file="common/Footer.jsp" />

			<!-- *** FOOTER END *** -->

			<!-- *** COPYRIGHT *** -->
			<jsp:directive.include file="common/copyRight.jsp" />

			<!-- *** COPYRIGHT END *** -->
			</div>
</body>
</html>