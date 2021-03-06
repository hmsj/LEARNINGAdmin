<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
<title>DokuLearning Grupo2</title>

<!-- Stlylesheet -->
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.ok_message {
	-webkit-border-radius: 4;
	-moz-border-radius: 4;
	border-radius: 4px;
	font-family: Montserrat, sans-serif;
	color: black;
    top: -10px;
    width: 50%;
    margin-left: auto;
    margin-right: auto;
    line-height: 22px;
    padding: 3px 15px 3px 15px;
    background-color: #B2CC02;
    background-image: url(../img/error.gif);
    background-position: 10px center;
    background-repeat: no-repeat;
}
</style>

<!-- Skin Color -->
<link rel="stylesheet" href="css/colors/green.css" id="color-skins" />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

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
						data-delay="10000" data-saveperformance="on"
						data-title="We Are Vossen"><img
						src="img/backgrounds/bg-1.jpg" alt="slidebg1"
						data-bgposition="center top" data-bgfit="cover"
						data-bgrepeat="no-repeat"> <!-- Home Heading -->
						<div class="tp-caption sft" data-x="center" data-y="260"
							data-speed="1200" data-start="1100"
							data-easing="Power3.easeInOut" data-splitin="none"
							data-splitout="none" data-elementdelay="0.1"
							data-endelementdelay="0.1" data-endspeed="300"
							style="z-index: 4; max-width: auto; max-height: auto; white-space: nowrap;">
							<c:if test="${not empty mensajeError }">
								<div id="message">
									<p class="error_message">${mensajeError }</p>
								</div>
							</c:if>
							<c:if test="${not empty mensajeOK }">
								<div id="message">
									<p class="ok_message">${mensajeOK }</p>
								</div>
							</c:if>
							<h2 class="home-heading op-1">Usuarios DokuLearning</h2>
						</div></li>

				</ul>
				<div class="tp-bannertimer"></div>
			</div>

			<div class="home-bottom">
				<div class="container text-center">
					<div class="move bounce">
						<a href="#features" class=""></a>
					</div>
				</div>
			</div>

		</div>
	</div>
	</section>
	<!-- End Home Revolution Slider Parallax Section -->
	<div class="site-wrapper content">


		<!-- Start Features Section -->
		<section id="cat1">
		<div class="container">
			<div>
				<h2 class="content-title wow fadeInUp">Usuarios</h2>
			</div>
			<div class="row">
				<c:if test="${not empty usuarios }">
					<c:forEach items="${usuarios }" var="usuario">
						<div class="col-md-3 col-sm-3 team-member">
							<div class="effect effects wow fadeInUp">
								<div class="img">
									<c:choose>
										<c:when test="${not empty usuario.imagen }">
											<img src="${usuario.imagen }" class="img-responsive" alt="" />
										</c:when>
										<c:otherwise>
											<img src="img/portfolio/1.jpg" class="img-responsive" alt="" />
										</c:otherwise>
									</c:choose>
									<div class="overlay">
										<ul class="expand">
											<li class="cbp-l-caption-title">${usuario.username }</li>
											<li class="social-icon"><a
												href="usuarios?idUsuario=${usuario.idUsuario }"
												title="Ver perfil"><i class="ion-ios-information"></i></a></li>
											<li class="social-icon"><a
												href="usuarios?idUsuario=${usuario.idUsuario }&accion=deleteUser"
												title="Eliminar usuario"><i class="ion-trash-a"></i></a></li>
											<li class="social-icon"><a
												href="usuarios?idUsuario=${usuario.idUsuario }"
												title="Editar perfil"><i class="ion-edit"></i></a></li>
											<!--<c:if test="${not empty alumno.curso_actual.titulo }">
												<li class="cbp-l-caption-desc">Curso actual
													${alumno.curso_actual.titulo }</li>
											</c:if>-->
										</ul>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
		</section>
		<!--End Features Section -->


		<!-- Start Footer 1 -->
		<footer id="footer">
		<div class="footer-copyright">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-sm-12">
						<p>
							© 2015 Vossen Theme by <a href="inicio" class="logo">Vossen
								Design.</a> All Rights Reserved.
						</p>
					</div>
					<div class="col-md-6 col-sm-12">
						<ul id="social-icons">
							<li><a href="#"><i class="icon ion-social-twitter"></i></a></li>
							<li><a href="#"><i class="icon ion-social-facebook"></i></a></li>
							<li><a href="#"><i class="icon ion-social-googleplus"></i></a></li>
							<li><a href="#"><i
									class="icon ion-social-instagram-outline"></i></a></li>
							<li><a href="#"><i class="icon ion-social-pinterest"></i></a></li>
							<li><a href="#"><i class="icon ion-social-skype"></i></a></li>
							<li><a href="#"><i class="icon ion-social-linkedin"></i></a></li>
							<li><a href="#"><i class="icon ion-social-dropbox"></i></a></li>
							<li><a href="#"><i class="icon ion-social-vimeo"></i></a></li>
							<li><a href="#"><i class="icon ion-social-youtube"></i></a></li>
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
