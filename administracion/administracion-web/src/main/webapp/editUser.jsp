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
			<h3 class="section-title white wow fadeInUp ">${usuario.nombre }
				${usuario.apellido }</h3>
		</div>
		<div class="row wow fadeInUp">

			<div class="col-md-6 col-sm-6 text-center">
				<div class="price-box">
					<div class="price-table">
						<h3 class="label">Imagen</h3>
						<c:choose>
							<c:when test="${not empty usuario.imagen  }">
								<img src="${usuario.imagen }" alt="${usuario.username}"
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
									de usuario:</span> ${usuario.username}
							</span> <span class="feature"> <span class="highlight">Nombre:</span>
								${usuario.nombre }
							</span> <span class="feature"> <span class="highlight">Apellidos:</span>
								${usuario.apellido }
							</span> <span class="feature"> <span class="highlight">E-mail:</span>
								${usuario.correo }
							</span>
							<c:if test="${usuario.idDireccion.telefono != null }">
								<span class="feature"> <span class="highlight">Telefono:</span>
									${usuario.idDireccion.telefono}
								</span>
							</c:if>
							<c:if test="${usuario.descripcion != null }">
								<span class="feature"> <span class="highlight">Descripcion:</span>
									${usuario.descripcion}
								</span>
							</c:if>
							<c:if test="${usuario.intereses != null }">
								<span class="feature"> <span class="highlight">Intereses:</span>
									${usuario.intereses}
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
				<h2 class="section-title wow fadeInUp">EDITA LOS DATOS</h2>
			</div>

			<div class="col-md-6 col-md-offset-3 text-center wow fadeInUp">
				<form method="post" action="usuarios?accion=editar"
					name="editUserform" id="editUserform">
					<fieldset>
						<input name="nombreEdit" type="text" id="nombreEdit"
							value="${usuario.nombre }" /> <input name="apellidosEdit"
							type="text" id="apellidosEdit" value="${usuario.apellido }" /> <input
							name="usernameEdit" type="text" id="usernameEdit"
							value="${usuario.username }" /> <input name="emailEdit"
							type="text" id="emailEdit" value="${usuario.correo }" /> <input
							name="edadEdit" type="number" id="edadEdit"
							value="${usuario.edad }" /> <input name="phoneEdit" type="tel"
							id="phoneEdit" value="${usuario.idDireccion.telefono }" />

					</fieldset>
					<fieldset>
						<c:choose>
							<c:when test="${not empty usuario.intereses }">
								<textarea name="interesEdit1" cols="40" rows="3"
									id="interesEdit1" value="${usuario.intereses }"></textarea>
							</c:when>
							<c:otherwise>
								<textarea name="interesEdit2" cols="40" rows="3"
									id="interesEdit2" placeholder="Intereses"></textarea>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${not empty usuario.descripcion }">
								<textarea name="descripcionEdit1" cols="40" rows="3"
									id="descripcionEdit" value="${usuario.descripcion }"></textarea>
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
	<%-- <c:choose> --%>
	<section id="cursoMatriculado" class="parallax-section-1">
	<div class="container">
		<div class="col-md-12 text-center">
			<h3 class="section-title white wow fadeInUp ">TU CURSO ACTUAL</h3>
		</div>
		<div class="row">
			<c:forEach items="${alumnosEnCursos }" var="alumnoEnCurso">
				<c:choose>
					<c:when
						test="${alumnoEnCurso.idUsuario.idUsuario == usuario.idUsuario}">
						<div class="col-md-6 text-left about-text">
							<h2 class="content-title white wow fadeInUp">${alumnoEnCurso.idCurso.titulo }</h2>
							<p class="grey wow fadeInUp">${alumnoEnCurso.idCurso.descripcion }</p>
						</div>
						<div class="col-md-6 wow fadeInUp">
							<div class="container">
								<c:choose>
									<c:when test="${not empty alumnoEnCurso.idCurso.imagen }">
										<img src="${alumnoEnCurso.idCurso.imagen }"></img>
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
							<p class="subheading wow fadeInUp">No tiene ningun curso
								matriculado en este momento</p>
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
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
			<c:forEach items="${alumnosCursados }" var="alumnoCursado">
				<c:choose>
					<c:when
						test="${alumnoCursado.idUsuario.idUsuario == usuario.idUsuario && !alumnoCursado.enCurso }">

						<div class="col-md-6 col-sm-6 team-member">
							<div class="effect effects wow fadeInUp">
								<div class="img">
									<c:choose>
										<c:when test="${not empty alumnoCursado.idCurso.imagen }">
											<img src="${alumnoCursado.idCurso.imagen }"
												class="img-responsive" alt="" />
										</c:when>
										<c:otherwise>
											<img src="img/portfolio/1.jpg" class="img-responsive" alt="" />
										</c:otherwise>
									</c:choose>
									<div class="overlay">
										<ul class="expand">
											<li><span class="highlight">Tu nota es: </span>
												${alumnoCursado.notaMedia }</li>
											<li><span class="highlight">Has conseguido el
													nivel: </span>${alumnoCursado.idLogro.descripcionLogro }</li>


											<li><span class="highlight">La dificultad es: </span>${alumnoCursado.idCurso.idDificultad.descripcionDificultad }</li>
										</ul>
										<a class="close-overlay hidden">x</a>
									</div>
								</div>
							</div>
							<div class="member-info wow fadeInUp">
								<h4></h4>
								<h5 class="highlight">${alumnoCursado.idCurso.titulo }</h5>
								<p>${alumnoCursado.idCurso.descripcion }</p>
							</div>

						</div>


					</c:when>
					<c:otherwise>
						<div class="col-md-12 text-center">
							<p class="subheading wow fadeInUp">Aun no has finalizado
								ningun curso</p>
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
	</section>

<!-- Seccion para mostrar los cursos subidos como profesor titular -->

	<%-- <section id="testimonials" class="parallax-section-7">
	<div class="container">
		<div class="row">
			<div class="col-md-12 text-center">
				<h3 class="section-title white wow fadeInUp">Sus cursos</h3>
				<p class="subheading grey wow fadeInUp">Estos son los cursos que
					ha subido</p>
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
							<p class="subheading wow fadeInUp">Aun no ha añadido ningun
								curso</p>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
	</section> --%>



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
