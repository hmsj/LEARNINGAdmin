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
				<!-- <li class="to-section"><a href="#team">Team</a></li>
                            <li class="to-section"><a href="#portfolio">Portfolio</a></li>
 -->
				<li class="dropdown"><span class="dropdown-toggle"
					data-toggle="dropdown">Cursos <b class="caret"></b></span>
					<ul class="dropdown-menu" role="menu">
						<li class="active"><a href="#">Home - Parallax</a></li>
						<li><a href="home-video.html">Home - Video Slider</a></li>
						<li><a href="home-fullwidth.html">Home - Fullwidth</a></li>
						<li><a href="home-landing-page.html">Home - Landing Page</a></li>
						<li><a href="shortcodes.html">Shortcodes</a></li>

					</ul></li>

				<li class="to-section"><a href="signup.jsp">Registrarse</a></li>
				<li><a class="social-icon" href="http://www.twitter.com"><i
						class="icon icon-social-twitter"></i></a></li>
				<li><a class="social-icon" href="http://www.facebook.com"><i
						class="icon icon-social-facebook"></i></a></li>
				<li><a class="social-icon" href="http://www.google.com"><i
						class="icon icon-support"></i></a></li>
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
						data-thumb=".${sessionScope.curso.imagen }"
						data-delay="10000" data-saveperformance="on" data-title=""><!--<img
						src="${sessionScope.curso.imagen }" alt="slidebg1"
						data-bgposition="center top" data-bgfit="cover"
						data-bgrepeat="no-repeat">  --> <!-- Home Heading -->
						<div class="tp-caption sft" data-x="center" data-y="260"
							data-speed="1200" data-start="1100"
							data-easing="Power3.easeInOut" data-splitin="none"
							data-splitout="none" data-elementdelay="0.1"
							data-endelementdelay="0.1" data-endspeed="300"
							style="z-index: 4; max-width: auto; max-height: auto; white-space: nowrap;">
							<h2 class="home-heading op-1">${sessionScope.curso.titulo }</h2>
						</div> <!-- Home Subheading -->
						<div class="tp-caption home-subheading sft fadeout"
							data-x="center" data-y="360" data-speed="1200" data-start="1350"
							data-easing="Power3.easeInOut" data-splitin="none"
							data-splitout="none" data-elementdelay="0.1"
							data-endelementdelay="0.1" data-endspeed="300"
							style="z-index: 4; max-width: auto; max-height: auto; white-space: nowrap;">
							<div class="op-1">${sessionScope.curso.profesor_titular.username }</div>
						</div> <!-- Home Button -->
						<div class="tp-caption home-button sft fadeout" data-x="center"
							data-y="400" data-speed="1200" data-start="1550"
							data-easing="Power3.easeInOut" data-splitin="none"
							data-splitout="none" data-elementdelay="0.1"
							data-endelementdelay="0.1" data-endspeed="300"
							style="z-index: 4; max-width: auto; max-height: auto; white-space: nowrap;">
							<div class="op-1">
								<c:choose>
									<c:when test="${sessionScope.usuario != null }">
										<c:if test="${sessionScope.curso != null }">
											<c:if test="${sessionScope.usuario.tipoUsuario.idtipoUsuario == 1}">
												<c:forEach items="${alumnos }" var="alumno">
													<c:if
														test="${alumno.username.username == sessionScope.usuario.username }">
														<c:if
															test="${alumno.curso_actual.idcurso == sessionScope.curso.idcurso }">
															<a href="#features" class="btn btn-primary btn-scroll">ACCEDER</a>
														</c:if>
														<c:forEach items="${alumno.listado_cursos }" var="cursado">
															<c:if
																test="${cursado.idcurso != sessionScope.curso.idcurso }">
																<a href="#features" class="btn btn-primary btn-scroll">MATRICULARSE</a>
															</c:if>
															<c:if
																test="${cursado.idcurso == sessionScope.curso.idcurso }">
																<a href="#features" class="btn btn-primary btn-scroll">VER
																	TUS DATOS</a>
																<a href="#features" class="btn btn-primary btn-scroll">MATRICULARSE</a>
															</c:if>
														</c:forEach>
													</c:if>
												</c:forEach>
											</c:if>
										</c:if>
									</c:when>
								</c:choose>
							</div>
						</div></li>
				</ul>
				<div class="tp-bannertimer"></div>
			</div>

			<!-- <div class="home-bottom">
				<div class="container text-center">
					<div class="move bounce">
						<a href="#portfolio" class="ion-ios-arrow-down btn-scroll"></a>
					</div>
				</div>
			</div> -->

		</div>
	</div>
	</section>
	<!-- End Home Revolution Slider Parallax Section -->
	<div class="site-wrapper content">

		<section id="services">
		<div class="container">

			<div class="col-md-12 text-center">
				<h3 class="section-title wow fadeInUp">Descricpcion del curso</h3>
				<p class="subheading wow fadeInUp">
					<span class="highlight">${sessionScope.curso.titulo }</span>
				</p>
			</div>
			<div class="row text-center wow fadeInUp">
				<div class="service">
					<span class="icon-eyeglasses size-6x"></span>
					<div class="service-info">
						<p class="service-description">${sessionScope.curso.descripcion }</p>
					</div>
				</div>
			</div>
		</div>
		</section>

		<!-- Start Price List -->
		<section id="price-list" class="parallax-section-6">
		<div class="container">
			<h3 class="section-title white wow fadeInUp">Temario del Curso</h3>
			<div class="row wow fadeInUp">
				<c:if test="${not empty secciones }">
					<c:forEach items="${secciones }" var="seccion">
						<c:if
							test="${sessionScope.curso.idcurso = seccion.curso.idcurso }">
							<div class="col-md-3 col-sm-6 price-list-box">
								<div class="price-box">
									<div class="price-table">
										<h3 class="label">${seccion.titulo }</h3>
										<p class="features grey">
											<c:forEach items="${lecciones }" var="leccion">
												<c:if
													test="${seccion.idseccion == leccion.seccion.idseccion }">
													<span class="feature">${leccion.idleccion } <c:forEach
															items="${materiales }" var="material">
															<c:if
																test="${leccion.idleccion == material.leccion.idleccion }">
																<!-- ***************************AQUI*************************** -->
																<!-- <span><href src="${material.archivo }"></span> -->
															</c:if>
														</c:forEach>
													</span>
												</c:if>
											</c:forEach>
										</p>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</c:if>
			</div>
		</div>
		</section>
		<!-- End Price List -->

	
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
