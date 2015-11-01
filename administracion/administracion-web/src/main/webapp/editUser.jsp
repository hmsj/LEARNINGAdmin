<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
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
	<jsp:include page="header.jsp"></jsp:include>

	<section id="price-list" class="parallax-section-6">
	<div class="container">

		<div class="col-md-12 text-center">
			<h3 class="section-title white wow fadeInUp ">${sessionScope.usuario.nombre }
				${sessionScope.usuario.apellidos }</h3>
		</div>
		<div class="row wow fadeInUp">

			<div class="col-md-6 col-sm-6 text-center">
				<div class="price-box">
					<div class="price-table">
						<h3 class="label">Imagen</h3>
						<c:choose>
							<c:when test="${not empty sessionScope.usuario.imagen  }">
								<img src="${sessionScope.usuario.imagen }"
									alt="${sessionScope.usuario.username}"
									data-bgposition="center top" data-bgfit="cover"
									data-bgrepeat="no-repeat">
							</c:when>
							<c:otherwise>
								<div class="row text-center wow fadeInUp">
									<ul class="connected-icons text-center">
										<li class="connected-icon"><span
											class="icon ion-ios-person size-6x highlight"></span></li>
									</ul>
								</div>
								<!-- 
								 src="/img/clients/client-1.png"
									alt="${sessionScope.usuario.username}"
									data-bgposition="center top" data-bgfit="cover"
									data-bgrepeat="no-repeat">
									 -->
							</c:otherwise>
						</c:choose>

						<span class="feature no-border"></span>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-sm-6 text-center">
				<div class="price-box">
					<div class="price-table">
						<h3 class="label">Perfil Actual</h3>
						<p class="features grey">
							<span class="feature"> <span class="highlight">Nombre
									de usuario:</span> ${sessionScope.usuario.username}
							</span> <span class="feature"> <span class="highlight">Nombre:</span>
								${sessionScope.usuario.nombre}
							</span> <span class="feature"> <span class="highlight">Apellidos:</span>
								${sessionScope.usuario.apellidos}
							</span> <span class="feature"> <span class="highlight">E-mail:</span>
								${sessionScope.usuario.email}
							</span>
							<c:if test="${sessionScope.usuario.telefono != null }">
								<span class="feature"> <span class="highlight">Telefono:</span>
									${sessionScope.usuario.telefono}
								</span>
							</c:if>
							<c:if test="${sessionScope.usuario.descripcion != null }">
								<span class="feature"> <span class="highlight">Descripcion:</span>
									${sessionScope.usuario.descripcion}
								</span>
							</c:if>
							<c:if test="${sessionScope.usuario.intereses != null }">
								<span class="feature"> <span class="highlight">Intereses:</span>
									${sessionScope.usuario.intereses}
								</span>
							</c:if>
							<span class="feature no-border"></span>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>


	<section id="contact">
	<div class="container">
		<div class="row">

			<div class="col-md-12">
				<h2 class="section-title wow fadeInUp">EDITA TUS DATOS</h2>
			</div>

			<div class="col-md-6 col-md-offset-3 text-center wow fadeInUp">
				<form method="post" action="usuarios?accion=editar" name="editUserform" id="editUserform">
					<fieldset>
						<input name="nombreEdit" type="text" id="nombreEdit"
							value="${sessionScope.usuario.nombre }" /> <input
							name="apellidosEdit" type="text" id="apellidosEdit"
							value="${sessionScope.usuario.apellidos }" /> <input
							name="usernameEdit" type="text" id="usernameEdit"
							value="${sessionScope.usuario.username }" /> <input
							name="emailEdit" type="text" id="emailEdit"
							value="${sessionScope.usuario.email }" /> <input name="edadEdit"
							type="number" id="edadEdit" value="${sessionScope.usuario.edad }" />
						<input name="phoneEdit" type="tel" id="phoneEdit"
							value="${sessionScope.usuario.telefono }" />

					</fieldset>
					<fieldset>
						<c:choose>
							<c:when test="${not empty sessionScope.usuario.intereses }">
								<textarea name="interesEdit1" cols="40" rows="3"
									id="interesEdit1" value="${sessionScope.usuario.intereses }"></textarea>
							</c:when>
							<c:otherwise>
								<textarea name="interesEdit2" cols="40" rows="3"
									id="interesEdit2" placeholder="Intereses"></textarea>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${not empty sessionScope.usuario.descripcion }">
								<textarea name="descripcionEdit1" cols="40" rows="3"
									id="descripcionEdit"
									value="${sessionScope.usuario.descripcion }"></textarea>
							</c:when>
							<c:otherwise>
								<textarea name="descripcionEdit2" cols="40" rows="3"
									id="descripcionEdit2" placeholder="Descripcion"></textarea>
							</c:otherwise>
						</c:choose>
					</fieldset>
					<input type="submit" class="submit" id="submitEdit"
						value="Cambiar Datos" />
				</form>
			</div>

		</div>
	</div>
	</section>
	<c:choose>
		<c:when test="${not empty mensaje }">
			<section id="cursoMatriculado" class="parallax-section-1">
			<div class="container">
				<div class="col-md-12 text-center">
					<h3 class="section-title white wow fadeInUp ">TU CURSO ACTUAL</h3>
				</div>
				<div class="row">

					<c:choose>
						<c:when test="${not empty sessionScope.alumno.curso_actual }">
							<div class="col-md-6 text-left about-text">
								<h2 class="content-title white wow fadeInUp">${sessionScope.alumno.curso_actual.titulo }</h2>
								<p class="grey wow fadeInUp">${sessionScope.alumno.curso_actual.descripcion }</p>
							</div>

							<div class="col-md-6 wow fadeInUp">
								<div class="container">
									<c:choose>
										<c:when
											test="${not empty sessionScope.alumno.curso_actual.imagen }">
											<img src="${sessionScope.alumno.curso_actual.imagen }"></img>
										</c:when>
										<c:otherwise>
											<div class="row text-center wow fadeInUp">
												<ul class="connected-icons text-center">
													<li class="connected-icon"><span
														class="icon ion-ios-person size-6x highlight"></span></li>
												</ul>
											</div>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="col-md-12 text-center">
								<p class="subheading wow fadeInUp">No tienes ningun curso
									matriculado en este momento</p>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			</section>

			<!-- Start Team Section -->
			<section id="matriculadoEdit">
			<div class="container">

				<div class="col-md-12 text-center wow fadeInUp">
					<h3 class="section-title">Tus cursos realizados</h3>
				</div>

				<div class="row">
					<c:choose>
						<c:when test="${not empty alumno.listado_cursos }">
							<c:forEach items="${alumno.listado_cursos }" var="cursado">
								<c:if test="${cursado.idcurso != alumno.curso_actual.idcurso }">
									<div class="col-md-6 col-sm-6 team-member">
										<div class="effect effects wow fadeInUp">
											<div class="img">
											<c:choose>
											<c:when test="${not empty cursado.imagen }">
												<img src="${cursado.imagen }" class="img-responsive" alt="" />
											</c:when>
											<c:otherwise>
												<img src="img/portfolio/1.jpg" class="img-responsive" alt="" />
											</c:otherwise>
											</c:choose>
												<div class="overlay">
													<ul class="expand">
														<c:forEach items="${calificaciones }" var="calificacion">
															<c:if
																test="${calificacion.alumno.username.username == alumno.username.username && calificacion.curso.idcurso == cursado.idcurso}">
																<li><span class="highlight">Tu nota es: </span>
																	${calificacion.nota }</li>
															</c:if>
															<c:if
																test="${calificacion.alumno.username.username == alumno.username.username && calificacion.curso.idcurso == cursado.idcurso}">
																<li><span class="highlight">Has conseguido
																		el nivel: </span>${calificacion.tipoLogro.descripcion_tipoLogro }</li>
															</c:if>
														</c:forEach>
														<li><span class="highlight">La dificultad es:
														</span>${cursado.dificultad.descripcion_tipoDificultad }</li>
													</ul>
													<a class="close-overlay hidden">x</a>
												</div>
											</div>
										</div>
										<div class="member-info wow fadeInUp">
											<h4>${cursado.profesor_titular }</h4>
											<h5 class="highlight">${cursado.titulo }</h5>
											<p>${cursado.descripcion }</p>
										</div>

									</div>
								</c:if>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<div class="col-md-12 text-center">
								<p class="subheading wow fadeInUp">Aun no has finalizado
									ningun curso</p>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</section>
		</c:when>
		<c:when test="${not empty mensaje1 }">
			<section id="testimonials" class="parallax-section-7">
			<div class="container">
				<div class="row">
					<div class="col-md-12 text-center">
						<h3 class="section-title white wow fadeInUp">Sus cursos</h3>
						<p class="subheading grey wow fadeInUp">Estos son los cursos
							que ha subido</p>
					</div>

					<div class="clients">
						<c:choose>
							<c:when test="${not empty cursos }">
								<c:forEach items="${cursos }" var="curso">
									<c:if
										test="${curso.profesor_titular == sessionScope.usuario.username }">
										<div class="col-md-2 col-sm-3 col-xs-6 client wow fadeInUp">
											<c:choose>
												<c:when test="${not empty curso.imagen }">
													<a href="cursos?idcurso=${curso.idcurso }">
														<div class="logo-dark">
															<img src="${curso.imagen }" class="img-responsive"
																alt="client">
														</div>
														<div class="logo-light">
															<p class="text-center">${curso.titulo }</p>
														</div>
													</a>
												</c:when>
												<c:otherwise>
													<a href="cursos?idcurso=${curso.idcurso }">
														<div class="logo-dark">
															<img src="img/portfolio/1.jpg" class="img-responsive"
																alt="client">
														</div>
														<div class="logo-light">
															<p class="text-center">${curso.titulo }</p>
														</div>
													</a>
												</c:otherwise>
											</c:choose>
										</div>
									</c:if>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<div class="col-md-12 text-center">
									<p class="subheading wow fadeInUp">Aun no ha añadido ningun curso</p>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
			</section>
		</c:when>
	</c:choose>


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
