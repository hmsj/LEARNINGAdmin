<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="" type="image/x-icon">
<title>DokuLearning Grupo2</title>

<!-- Stlylesheet -->
<link href="css/style.css" rel="stylesheet" type="text/css" />

<!-- Skin Color -->
<link rel="stylesheet" href="css/colors/green.css" id="color-skins" />
<style type="text/css">
.boton {
	-webkit-border-radius: 4;
	-moz-border-radius: 4;
	border-radius: 4px;
	font-family: Montserrat, sans-serif;
	color: #7E7B7B;
	font-size: 14px;
	background: #F6F7F7;
	padding: 10px 20px 10px 20px;
	text-decoration: none;
	font-weight: 700;
	line-height: 1.6;
	margin: 0 5px 0 5px;
	padding: 10px 22px;
	text-align: center;
}
.boton:hover {
	background: #B2CC02;
	text-decoration: none;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="site-wrapper content">

		<!-- Start Get Connected -->
            <section id="get-connected" class="parallax-section-4">
                <div class="container"> 
                	
                    <div class="col-md-12 text-center">
                        <h3 class="section-title white wow fadeInUp">Administracion</h3> 
                        <p class="subheading grey wow fadeInUp">Configure los <span class="highlight">datos</span> deseados.</p>
                    </div>
                    
                    <div class="row text-center wow fadeInUp">
                    	<ul class="connected-icons text-center">
                            
 							<li class="connected-icon">
                                <a target="_self" href="alumnos">
                                    <span class="icon ion-person size-6x"></span>
                                    <h4 class="white">Usuarios</h4>
                                    <span class="grey">Acceso a los usuarios</span>
                                </a>
                            </li>
                            
                            <li class="connected-icon">
                                <a target="_self" href="cursos">
                                    <span class="icon ion-ios-bookmarks size-6x"></span>
                                    <h4 class="white">Cursos</h4>
                                    <span class="grey">Acceso a los cursos</span>
                                </a>
                            </li>                                                                               
                    	</ul>        
                	</div>  
                    
                </div>
            </section>
            <!-- End Get Connected -->     
		<!-- End Testimonials Section -->

		<!-- Start Footer 1 -->
		<footer id="footer">


		<div class="footer-copyright">
			<div class="container">
				<div class="row">

					<div class="col-md-6 col-sm-12">
						<p>
							© 2015 TIW UC3M <a href="index.html" class="logo">Dokulearning</a>
							All Rights Reserved.
						</p>
					</div>
					<div class="col-md-6 col-sm-12">
						<ul id="social-icons">
							<li><a href="http://www.twitter.com"><i
									class="icon ion-social-twitter"></i></a></li>
							<li><a href="http://www.facebook.com"><i
									class="icon ion-social-facebook"></i></a></li>
							<li><a href="http://www.youtube.com"><i
									class="icon ion-social-youtube"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- End Footer Copyright --> </footer>
		<!-- End Footer 1 -->

		<!-- Start Back To Top -->
		<a id="back-to-top"><i class="icon ion-chevron-up"></i></a>
		<!-- End Back To Top -->

	</div>
	<!-- End Site Wrapper -->

	<!-- jQuery -->
	<script src="js/plugins/jquery.min.js"></script>
	<script src="js/plugins/smoothscroll.min.js"></script>
	<script src="js/plugins/revslider.min.js"></script>
	<script src="js/plugins/bootstrap.min.js"></script>
	<script src="js/plugins/waypoints.min.js"></script>
	<script src="js/plugins/parallax.min.js"></script>
	<script src="js/plugins/easign1.3.min.js"></script>
	<script src="js/plugins/moderniz.min.js"></script>
	<script src="js/plugins/cubeportfolio.min.js"></script>
	<script src="js/plugins/owlcarousel.min.js"></script>
	<script src="js/plugins/tweetie.min.js"></script>
	<script src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
	<script src="js/plugins/gmap3.min.js"></script>
	<script src="js/plugins/wow.min.js"></script>
	<script src="js/plugins/counterup.min.js"></script>
	<script src="js/scripts.js"></script>

</body>
</html>
