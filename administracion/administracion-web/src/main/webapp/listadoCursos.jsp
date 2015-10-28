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
			<a class="navbar-brand to-top" rel="home" href="#"> <img
				src="img/assets/logo-white.png" alt="Dokulearning" class="logo-big">
				<img src="img/assets/logo-dark.png" alt="Dokulearning"
				class="logo-small">
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="main-nav">
			<ul class="nav navbar-nav  navbar-right">

				<li><a class="to-top">Home</a></li>
				<li class="to-section"><a href="login.jsp">Login</a></li>
				<!-- <li class="to-section"><a href="#team">Team</a></li>
                            <li class="to-section"><a href="#portfolio">Portfolio</a></li>
                            
                            <li class="dropdown">
                                <span class="dropdown-toggle" data-toggle="dropdown">Cursos <b class="caret"></b></span>
                                <ul class="dropdown-menu" role="menu">
                                    <li class="active"><a href="#">Home - Parallax</a></li>
                                    <li><a href="home-video.html">Home - Video Slider</a></li>
                                    <li><a href="home-fullwidth.html">Home - Fullwidth</a></li>
                                    <li><a href="home-landing-page.html">Home - Landing Page</a></li> 
                                    <li><a href="shortcodes.html">Shortcodes</a></li>
                                    <li><a href="http://themeforest.net/user/VossenDesign/portfolio" id="btn-buy"><span class="btn-buy">Buy Now</span></a></li>
                                </ul>
                            </li> 
                            
                            <li class="to-section"><a href="#contact">Contact</a></li> -->
				<li><a class="social-icon" href="#"><i
						class="icon icon-social-twitter"></i></a></li>
				<li><a class="social-icon" href="#"><i
						class="icon icon-social-facebook"></i></a></li>
				<li><a class="social-icon" href="#"><i
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
							<h2 class="home-heading op-1">Cursos DokuLearning</h2>
						</div></li>

				</ul>
				<div class="tp-bannertimer"></div>
			</div>

			<div class="home-bottom">
				<div class="container text-center">
					<div class="move bounce">
						<a href="#features" class="ion-ios-arrow-down btn-scroll"></a>
					</div>
				</div>
			</div>

		</div>
	</div>
	</section>
	<!-- End Home Revolution Slider Parallax Section -->
	<div class="site-wrapper content">

		<c:if test="${not empty categorias }">
			<c:forEach items="${categorias }" var="categoria">
				<c:choose>
					<c:when test="${categoria.idcategoria == 1 }">
						<!-- Start Features Section -->
						<section id="cat1">
						<div class="container">
							<div>
								<h2 class="content-title wow fadeInUp">Cursos de
									${categoria.descripcion_categoria }</h2>
							</div>
							<div class="row">
								<c:if test="${not empty cursos }">
									<c:forEach items="${cursos }" var="curso">
										<c:if test="${curso.categoria.idcategoria == 1 }">
											<div class="col-md-6 col-sm-4 team-member">
												<div class="effect effects wow fadeInUp">
													<div class="img">
														<img src="${curso.imagen }" class="img-responsive" alt="" />
														<div class="overlay">
															<ul class="expand">
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-facebook"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-twitter"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-youtube"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-dribbble"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class=" icon-envelope-open"></i></a></li>
															</ul>
															<a class="close-overlay hidden">x</a>
														</div>
													</div>
												</div>
												<div class="member-info wow fadeInUp">
													<h4></h4>
													<p>${curso.descripcion }</p>
												</div>
											</div>
										</c:if>
									</c:forEach>
								</c:if>
							</div>
						</div>
						</section>
						<!--End Features Section -->
					</c:when>

					<c:when test="${categoria.idcategoria == 2 }">
						<section id="cat2" class="parallax-section-1">
						<div class="container">
							<div>
								<h2 class="content-title white wow fadeInUp">Cursos de
									${categoria.descripcion_categoria}</h2>
							</div>
							<div class="row">
								<c:if test="${not empty cursos }">
									<c:forEach items="${cursos }" var="curso">
										<c:if test="${curso.categoria.idcategoria == 2 }">
											<div class="col-md-6 col-sm-4 team-member">
												<div class="effect effects wow fadeInUp">
													<div class="img">
														<img src="${curso.imagen }" class="img-responsive" alt="" />
														<div class="overlay">
															<ul class="expand">
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-facebook"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-twitter"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-youtube"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-dribbble"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class=" icon-envelope-open"></i></a></li>
															</ul>
															<a class="close-overlay hidden">x</a>
														</div>
													</div>
												</div>
												<div class="member-info wow fadeInUp">
													<h4 style="color: white;">${curso.profesor_titular.nombre }</h4>
													<p>${curso.descripcion }</p>
												</div>
											</div>
										</c:if>
									</c:forEach>
								</c:if>
							</div>
						</div>
						</section>
					</c:when>

					<c:when test="${categoria.idcategoria == 3 }">
						<section id="cat3">
						<div class="container">
							<div>
								<h2 class="content-title wow fadeInUp">Cursos de
									${categoria.descripcion_categoria}</h2>
							</div>
							<div class="row">
								<c:if test="${not empty cursos }">
									<c:forEach items="${cursos }" var="curso">
										<c:if test="${curso.categoria.idcategoria == 3 }">
											<div class="col-md-6 col-sm-4 team-member">
												<div class="effect effects wow fadeInUp">
													<div class="img">
														<img src="${curso.imagen }" class="img-responsive" alt="" />
														<div class="overlay">
															<ul class="expand">
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-facebook"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-twitter"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-youtube"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-dribbble"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class=" icon-envelope-open"></i></a></li>
															</ul>
															<a class="close-overlay hidden">x</a>
														</div>
													</div>
												</div>
												<div class="member-info wow fadeInUp">
													<h4>${curso.profesor_titular.nombre }</h4>
													<p>${curso.descripcion }</p>
												</div>
											</div>
										</c:if>
									</c:forEach>
								</c:if>
							</div>
						</div>
						</section>
					</c:when>

					<c:when test="${categoria.idcategoria == 4 }">
						<section id="cat4" class="parallax-section-2">
						<div class="container">
							<div>
								<h2 class="content-title white wow fadeInUp">Cursos de
									${categoria.descripcion_categoria}</h2>
							</div>
							<div class="row">
								<c:if test="${not empty cursos }">
									<c:forEach items="${cursos }" var="curso">
										<c:if test="${curso.categoria.idcategoria == 4 }">
											<div class="col-md-6 col-sm-4 team-member">
												<div class="effect effects wow fadeInUp">
													<div class="img">
														<img src="${curso.imagen }" class="img-responsive" alt="" />
														<div class="overlay">
															<ul class="expand">
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-facebook"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-twitter"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-youtube"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-dribbble"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class=" icon-envelope-open"></i></a></li>
															</ul>
															<a class="close-overlay hidden">x</a>
														</div>
													</div>
												</div>
												<div class="member-info wow fadeInUp">
													<h4 style="color: white;">${curso.profesor_titular.nombre }</h4>
													<p>${curso.descripcion }</p>
												</div>
											</div>
										</c:if>
									</c:forEach>
								</c:if>
							</div>
						</div>
						</section>
					</c:when>

					<c:when test="${categoria.idcategoria == 5 }">ç
						<section id="cat5">
						<div class="container">
							<div>
								<h2 class="content-title wow fadeInUp">Cursos de
									${categoria.descripcion_categoria}</h2>
							</div>
							<div class="row">
								<c:if test="${not empty cursos }">
									<c:forEach items="${cursos }" var="curso">
										<c:if test="${curso.categoria.idcategoria == 5 }">
											<div class="col-md-6 col-sm-4 team-member">
												<div class="effect effects wow fadeInUp">
													<div class="img">
														<img src="${curso.imagen }" class="img-responsive" alt="" />
														<div class="overlay">
															<ul class="expand">
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-facebook"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-twitter"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-youtube"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-dribbble"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class=" icon-envelope-open"></i></a></li>
															</ul>
															<a class="close-overlay hidden">x</a>
														</div>
													</div>
												</div>
												<div class="member-info wow fadeInUp">
													<h4>${curso.profesor_titular.nombre }</h4>
													<p>${curso.descripcion }</p>
												</div>
											</div>
										</c:if>
									</c:forEach>
								</c:if>
							</div>
						</div>
						</section>
					</c:when>

					<c:when test="${categoria.idcategoria == 6 }">
						<section id="cat6" class="parallax-section-3">
						<div class="container">
							<div>
								<h2 class="content-title white wow fadeInUp">Cursos de
									${categoria.descripcion_categoria}</h2>
							</div>
							<div class="row">
								<c:if test="${not empty cursos }">
									<c:forEach items="${cursos }" var="curso">
										<c:if test="${curso.categoria.idcategoria == 6 }">
											<div class="col-md-6 col-sm-4 team-member">
												<div class="effect effects wow fadeInUp">
													<div class="img">
														<img src="${curso.imagen }" class="img-responsive" alt="" />
														<div class="overlay">
															<ul class="expand">
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-facebook"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-twitter"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-youtube"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-dribbble"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class=" icon-envelope-open"></i></a></li>
															</ul>
															<a class="close-overlay hidden">x</a>
														</div>
													</div>
												</div>
												<div class="member-info wow fadeInUp">
													<h4 style="color: white;">${curso.profesor_titular.nombre }</h4>
													<p>${curso.descripcion }</p>
												</div>
											</div>
										</c:if>
									</c:forEach>
								</c:if>
							</div>
						</div>
						</section>
					</c:when>

					<c:when test="${categoria.idcategoria == 7 }">
						<section id="cat7">
						<div class="container">
							<div>
								<h2 class="content-title wow fadeInUp">
									${categoria.descripcion_categoria} cursos</h2>
							</div>
							<div class="row">
								<c:if test="${not empty cursos }">
									<c:forEach items="${cursos }" var="curso">
										<c:if test="${curso.categoria.idcategoria == 7 }">
											<div class="col-md-6 col-sm-4 team-member">
												<div class="effect effects wow fadeInUp">
													<div class="img">
														<img src="${curso.imagen }" class="img-responsive" alt="" />
														<div class="overlay">
															<ul class="expand">
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-facebook"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-twitter"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-youtube"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class="icon-social-dribbble"></i></a></li>
																<li class="social-icon"><a href="#"
																	onClick="return false;"><i
																		class=" icon-envelope-open"></i></a></li>
															</ul>
															<a class="close-overlay hidden">x</a>
														</div>
													</div>
												</div>
												<div class="member-info wow fadeInUp">
													<h4>${curso.profesor_titular.nombre }</h4>
													<p>${curso.descripcion }</p>
												</div>
											</div>
										</c:if>
									</c:forEach>
								</c:if>
							</div>
						</div>
						</section>
					</c:when>
				</c:choose>
			</c:forEach>
		</c:if>

		<!-- Start Footer 1 -->
		<footer id="footer">
		<div class="footer-copyright">
			<div class="container">
				<div class="row">

					<div class="col-md-6 col-sm-12">
						<p>
							© 2015 Vossen Theme by <a href="index.html" class="logo">Vossen
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
