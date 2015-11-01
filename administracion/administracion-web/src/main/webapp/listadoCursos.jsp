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
														<c:choose>
															<c:when test="${not empty curso.imagen }">
																<img src="${curso.imagen }" class="img-responsive"
																	alt="" />
															</c:when>
															<c:otherwise>
																<img src="img/portfolio/1.jpg" class="img-responsive"
																	alt="" />
															</c:otherwise>
														</c:choose>
														<div class="overlay">
															<ul class="expand">
																<li class="cbp-l-caption-title">${curso.titulo }</li>
																<li class="cbp-l-caption-desc">by
																	${curso.profesor_titular }</li>
																<li class="cbp-l-icon"><a
																	href="cursos?idcurso=${curso.idcurso }"><i
																		class="icon-info"></i></a></li>
																<li class="cbp-l-caption-desc">Precio inicial:
																	${curso.precio_inicial } €</li>
																<c:if
																	test="${curso.oferta.tipoOferta.idtipoOferta == 1}">
																	<li class="cbp-l-caption-desc">Descuento:
																		${curso.oferta.valor} €</li>
																</c:if>
																<c:if
																	test="${curso.oferta.tipoOferta.idtipoOferta == 2}">
																	<li class="cbp-l-caption-desc">Descuento:
																		${curso.oferta.valor} %</li>
																</c:if>
																<li class="cbp-l-caption-desc">Precio final:
																	${curso.precio_final } €</li>

															</ul>
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
														<c:choose>
															<c:when test="${not empty curso.imagen }">
																<img src="${curso.imagen }" class="img-responsive"
																	alt="" />
															</c:when>
															<c:otherwise>
																<img src="img/portfolio/1.jpg" class="img-responsive"
																	alt="" />
															</c:otherwise>
														</c:choose>
														<div class="overlay">
															<ul class="expand">
																<li class="cbp-l-caption-title">${curso.titulo }</li>
																<li class="cbp-l-caption-desc">by
																	${curso.profesor_titular }</li>
																<li class="cbp-l-icon"><a
																	href="cursos?idcurso=${curso.idcurso }"><i
																		class="icon-info"></i></a></li>
																<li class="cbp-l-caption-desc">Precio inicial:
																	${curso.precio_inicial } €</li>
																<c:if
																	test="${curso.oferta.tipoOferta.idtipoOferta == 1}">
																	<li class="cbp-l-caption-desc">Descuento:
																		${curso.oferta.valor} €</li>
																</c:if>
																<c:if
																	test="${curso.oferta.tipoOferta.idtipoOferta == 2}">
																	<li class="cbp-l-caption-desc">Descuento:
																		${curso.oferta.valor} %</li>
																</c:if>
																<li class="cbp-l-caption-desc">Precio final:
																	${curso.precio_final } €</li>

															</ul>
														</div>
													</div>
												</div>
												<div class="member-info wow fadeInUp">
													<h4 style="color: white;">${curso.profesor_titular }</h4>
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
														<c:choose>
															<c:when test="${not empty curso.imagen }">
																<img src="${curso.imagen }" class="img-responsive"
																	alt="" />
															</c:when>
															<c:otherwise>
																<img src="img/portfolio/1.jpg" class="img-responsive"
																	alt="" />
															</c:otherwise>
														</c:choose>
														<div class="overlay">
															<ul class="expand">
																<li class="cbp-l-caption-title">${curso.titulo }</li>
																<li class="cbp-l-caption-desc">by
																	${curso.profesor_titular }</li>
																<li class="cbp-l-icon"><a
																	href="cursos?idcurso=${curso.idcurso }"><i
																		class="icon-info"></i></a></li>
																<li class="cbp-l-caption-desc">Precio inicial:
																	${curso.precio_inicial } €</li>
																<c:if
																	test="${curso.oferta.tipoOferta.idtipoOferta == 1}">
																	<li class="cbp-l-caption-desc">Descuento:
																		${curso.oferta.valor} €</li>
																</c:if>
																<c:if
																	test="${curso.oferta.tipoOferta.idtipoOferta == 2}">
																	<li class="cbp-l-caption-desc">Descuento:
																		${curso.oferta.valor} %</li>
																</c:if>
																<li class="cbp-l-caption-desc">Precio final:
																	${curso.precio_final } €</li>

															</ul>
														</div>
													</div>
												</div>
												<div class="member-info wow fadeInUp">
													<h4>${curso.profesor_titular }</h4>
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
														<c:choose>
															<c:when test="${not empty curso.imagen }">
																<img src="${curso.imagen }" class="img-responsive"
																	alt="" />
															</c:when>
															<c:otherwise>
																<img src="img/portfolio/1.jpg" class="img-responsive"
																	alt="" />
															</c:otherwise>
														</c:choose>
														<div class="overlay">
															<ul class="expand">
																<li class="cbp-l-caption-title">${curso.titulo }</li>
																<li class="cbp-l-caption-desc">by
																	${curso.profesor_titular }</li>
																<li class="cbp-l-icon"><a
																	href="cursos?idcurso=${curso.idcurso }"><i
																		class="icon-info"></i></a></li>
																<li class="cbp-l-caption-desc">Precio inicial:
																	${curso.precio_inicial } €</li>
																<c:if
																	test="${curso.oferta.tipoOferta.idtipoOferta == 1}">
																	<li class="cbp-l-caption-desc">Descuento:
																		${curso.oferta.valor} €</li>
																</c:if>
																<c:if
																	test="${curso.oferta.tipoOferta.idtipoOferta == 2}">
																	<li class="cbp-l-caption-desc">Descuento:
																		${curso.oferta.valor} %</li>
																</c:if>
																<li class="cbp-l-caption-desc">Precio final:
																	${curso.precio_final } €</li>

															</ul>
														</div>
													</div>
												</div>
												<div class="member-info wow fadeInUp">
													<h4 style="color: white;">${curso.profesor_titular }</h4>
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
														<c:choose>
															<c:when test="${not empty curso.imagen }">
																<img src="${curso.imagen }" class="img-responsive"
																	alt="" />
															</c:when>
															<c:otherwise>
																<img src="img/portfolio/1.jpg" class="img-responsive"
																	alt="" />
															</c:otherwise>
														</c:choose>
														<div class="overlay">
															<ul class="expand">
																<li class="cbp-l-caption-title">${curso.titulo }</li>
																<li class="cbp-l-caption-desc">by
																	${curso.profesor_titular }</li>
																<li class="cbp-l-icon"><a
																	href="cursos?idcurso=${curso.idcurso }"><i
																		class="icon-info"></i></a></li>
																<li class="cbp-l-caption-desc">Precio inicial:
																	${curso.precio_inicial } €</li>
																<c:if
																	test="${curso.oferta.tipoOferta.idtipoOferta == 1}">
																	<li class="cbp-l-caption-desc">Descuento:
																		${curso.oferta.valor} €</li>
																</c:if>
																<c:if
																	test="${curso.oferta.tipoOferta.idtipoOferta == 2}">
																	<li class="cbp-l-caption-desc">Descuento:
																		${curso.oferta.valor} %</li>
																</c:if>
																<li class="cbp-l-caption-desc">Precio final:
																	${curso.precio_final } €</li>

															</ul>
														</div>
													</div>
												</div>
												<div class="member-info wow fadeInUp">
													<h4>${curso.profesor_titular }</h4>
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
														<c:choose>
															<c:when test="${not empty curso.imagen }">
																<img src="${curso.imagen }" class="img-responsive"
																	alt="" />
															</c:when>
															<c:otherwise>
																<img src="img/portfolio/1.jpg" class="img-responsive"
																	alt="" />
															</c:otherwise>
														</c:choose>
														<div class="overlay">
															<ul class="expand">
																<li class="cbp-l-caption-title">${curso.titulo }</li>
																<li class="cbp-l-caption-desc">by
																	${curso.profesor_titular }</li>
																<li class="cbp-l-icon"><a
																	href="cursos?idcurso=${curso.idcurso }"><i
																		class="icon-info"></i></a></li>
																<li class="cbp-l-caption-desc">Precio inicial:
																	${curso.precio_inicial } €</li>
																<c:if
																	test="${curso.oferta.tipoOferta.idtipoOferta == 1}">
																	<li class="cbp-l-caption-desc">Descuento:
																		${curso.oferta.valor} €</li>
																</c:if>
																<c:if
																	test="${curso.oferta.tipoOferta.idtipoOferta == 2}">
																	<li class="cbp-l-caption-desc">Descuento:
																		${curso.oferta.valor} %</li>
																</c:if>
																<li class="cbp-l-caption-desc">Precio final:
																	${curso.precio_final } €</li>

															</ul>
														</div>
													</div>
												</div>
												<div class="member-info wow fadeInUp">
													<h4 style="color: white;">${curso.profesor_titular }</h4>
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
														<c:choose>
															<c:when test="${not empty curso.imagen }">
																<img src="${curso.imagen }" class="img-responsive"
																	alt="" />
															</c:when>
															<c:otherwise>
																<img src="img/portfolio/1.jpg" class="img-responsive"
																	alt="" />
															</c:otherwise>
														</c:choose>
														<div class="overlay">
															<ul class="expand">
																<li class="cbp-l-caption-title">${curso.titulo }</li>
																<li class="cbp-l-caption-desc">by
																	${curso.profesor_titular }</li>
																<li class="cbp-l-icon"><a
																	href="cursos?idcurso=${curso.idcurso }"><i
																		class="icon-info"></i></a></li>
																<li class="cbp-l-caption-desc">Precio inicial:
																	${curso.precio_inicial } €</li>
																<c:if
																	test="${curso.oferta.tipoOferta.idtipoOferta == 1}">
																	<li class="cbp-l-caption-desc">Descuento:
																		${curso.oferta.valor} €</li>
																</c:if>
																<c:if
																	test="${curso.oferta.tipoOferta.idtipoOferta == 2}">
																	<li class="cbp-l-caption-desc">Descuento:
																		${curso.oferta.valor} %</li>
																</c:if>
																<li class="cbp-l-caption-desc">Precio final:
																	${curso.precio_final } €</li>

															</ul>
														</div>
													</div>
												</div>
												<div class="member-info wow fadeInUp">
													<h4>${curso.profesor_titular }</h4>
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
