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
	<!--Start Header-->
	<header> <nav class="navbar navbar-default navbar-alt"
		role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#main-nav">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<!--  <a class="navbar-brand to-top" rel="home" href="#">
                        	<img src="img/assets/logo-dark.png" alt="Dokulearning" class="logo-big">
                            <img src="img/assets/logo-dark.png" alt="Dokulearning" class="logo-small">
                        </a>-->
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="main-nav">
			<ul class="nav navbar-nav  navbar-right">

				<li><a class="to-section" href="principal.jsp">Home</a></li>
				<c:choose>
					<c:when test="${sessionScope.usuario != null }">
						<li class="to-section"><a href="login?accion=salir">Logout</a></li>
					</c:when>
					<c:otherwise>
						<li class="to-section"><a href="login">Login</a></li>
					</c:otherwise>
				</c:choose>
				<li class="to-section"><a href="cursos">Cursos </a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav> </header>
	<!--End Header-->

	<!-- Start Home Revolution Slider Parallax Section -->
	<section id="home-revolution-slider">
	<div class="hero">
		<div class="tp-banner-container">
			<div class="tp-banner">
				<ul>
					<!-- SLIDE 1 -->
					<li data-transition="fade" data-slotamount="7"
						data-masterspeed="2000"
						data-thumb="img/backgrounds/bg-home-fullscreen.jpg"
						data-delay="10000" data-saveperformance="on" data-title=""><img
						src="img/backgrounds/startup-photos-medium.jpg" alt="slidebg1"
						data-bgposition="center top" data-bgfit="cover"
						data-bgrepeat="no-repeat"> <!-- Home Heading -->
						<div class="tp-caption sft" data-x="center" data-y="260"
							data-speed="1200" data-start="1100"
							data-easing="Power3.easeInOut" data-splitin="none"
							data-splitout="none" data-elementdelay="0.1"
							data-endelementdelay="0.1" data-endspeed="300"
							style="z-index: 4; max-width: auto; max-height: auto; white-space: nowrap;">
							<h2 class="home-heading op-1">Bienvenido Administrador</h2>
						</div> <!-- Home Subheading -->

				</ul>
				<div class="tp-bannertimer"></div>
			</div>

			<div class="home-bottom">
				<div class="container text-center">
					<div class="move bounce">
						<a href="#portfolio" class="ion-ios-arrow-down btn-scroll"></a>
					</div>
				</div>
			</div>

		</div>
	</div>
	</section>
	

	<!-- End Home Revolution Slider Parallax Section -->

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
                                <a target="_blank" href="#">
                                    <span class="icon ion-university size-6x"></span>
                                    <h4 class="white">Almunos</h4>
                                    <span class="grey">Acceso al alumnado</span>
                                </a>
                            </li>
                            
                            <li class="connected-icon">
                                <a target="_blank" href="#">
                                    <span class="icon ion-ios-bookmarks size-6x"></span>
                                    <h4 class="white">Cursos</h4>
                                    <span class="grey">Acceso a los cursos</span>
                                </a>
                            </li>
                            
                            <li class="connected-icon">
                                <a target="_blank" href="#"> 
                                    <span class="icon ion-ios-briefcase size-6x"></span>
                                    <h4 class="white">Profesores</h4>
                                    <span class="grey">Acceso al profesorado</span>
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
