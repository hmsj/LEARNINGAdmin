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
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<section id="price-list" class="parallax-section-6">
	<div class="container">
		<div class="col-md-12 text-center">
			<h3 class="section-title white wow fadeInUp ">${curso.titulo }</h3>

			<div class="row wow fadeInUp">
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
				<div class="col-md-6 col-sm-6 text-center">
					
					<div class="price-box">
						<div class="price-table">
							<h3 class="label">Imagen</h3>
							<c:choose>
								<c:when test="${not empty curso.imagen  }">
									<img src="${curso.imagen }" alt="${curso.titulo}"
										data-bgposition="center top" data-bgfit="cover"
										data-bgrepeat="no-repeat">
								</c:when>
								<c:otherwise>
									<div class="row text-center wow fadeInUp">
										<!-- <ul class="connected-icons text-center">
											<li class="connected-icon"><span
												class="icon ion-ios-bookmarks size-6x highlight"></span></li>
										</ul> -->
										<img src="img/portfolio/1.jpg" class="img-responsive"
											alt="${curso.titulo }" />
									</div>
								</c:otherwise>
							</c:choose>
							<span class="feature no-border"></span>
						</div>
					</div>
				</div>

				<div class="col-md-6 col-sm-6 text-center">
					<div class="price-box">
						<div class="price-table">
							<h3 class="label">Datos del curso</h3>
							<p class="features grey">
								<span class="feature"> <span class="highlight">Titulo:</span>
									${curso.titulo}
								</span> <span class="feature"> <span class="highlight">Profesor
										titular:</span> ${profesorTitularCurso.idUsuario.nombre }
									${profesorTitularCurso.idUsuario.apellido }
								</span> <span class="feature"> <span class="highlight">Descripcion:</span>
									${curso.descripcion}
								</span> <span class="feature"> <span class="highlight">Categoria:</span>
									${curso.idCategoria.descripcionCategoria}
								</span> <span class="feature"> <span class="highlight">Dificultad:</span>
									${curso.idDificultad.descripcionDificultad}
								</span> <span class="feature"> <span class="highlight">Precio
										Inicial:</span> ${curso.precioInicial} €
								</span> <span class="feature"> <span class="highlight">Promocion:</span>
									${curso.idPromocion.valor} <c:if
										test="${curso.idPromocion.tipoPromocion.idTipoPromocion == 1 }"> € </c:if>
									<c:if
										test="${curso.idPromocion.tipoPromocion.idTipoPromocion == 2 }"> % </c:if>
								</span> <span class="feature"> <span class="highlight">Precio
										Final:</span>
								</span>
								<c:if test="${sessionScope.usuario.admin }">
									<span class="feature"> <span class="highlight">Estado:</span>
										<c:choose>
											<c:when test="${curso.validado }">
											Validado
										</c:when>
											<c:otherwise>
											No validado <a href="cursos?idCurso=${curso.idCurso }&accion=validarCurso" title="Validar Curso"><i
													class="icon ion-checkmark-circled"></i></a>
											</c:otherwise>
										</c:choose>
									</span>
								</c:if>
								<span class="feature"> <span class="highlight">Destacado:</span>
									<c:choose>
										<c:when test="${curso.destacado }">
										Si <c:if test="${sessionScope.usuario.admin }">
											<a href="#" title="Quitar Destacado"><i
												class="icon ion-ios-star"></i></a>
											</c:if>
										</c:when>
										<c:otherwise>
										No 
											<c:if test="${curso.validado }">
												<c:if test="${sessionScope.usuario.admin }">
												<a href="#" title="Hacer Destacado"><i
													class="icon ion-ios-star-outline"></i></a>
												</c:if>
											</c:if>
										</c:otherwise>
									</c:choose>
								</span>
						</div>
					</div>
				</div>
				<br>
		<div class="row" id="contact">
			<div class="col-md-6 col-md-offset-3 text-center wow fadeInUp">
				<form method="post"
					action="cursos?idCurso=${curso.idCurso }&accion=applyPromo"
					name="applyPromoForm" id="applyPromoForm">
					<select name="promoCurso" id=""promoCurso"">
							<option value="0" selected="selected"> Seleccione una promocion</option>
							<c:forEach items="${listadoPromociones }" var="promocion">
								<option value="${promocion.idPromocion }"> ${promocion.nombrePromocion }</option>
							</c:forEach>
					</select>
					
					<input type="submit" class="submit" id="submit"
						value="APLICAR PROMOCION" />
				</form>
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

				<form method="post"
					action="cursos?idCurso=${curso.idCurso }&accion=modifyCurso"
					name="cursoEditForm" id="cursoEditForm">

					<fieldset>
						<input name="tituloEditCurso" type="text" id="tituloEditCurso"
							value="${curso.titulo }" /> <select name="categoriaEditCurso"
							id="categoriaEditCurso">
							<option value="${curso.idCategoria.idCategoria }"
								selected="selected">
								${curso.idCategoria.descripcionCategoria }</option>
							<c:forEach items="${categorias }" var="categoria">
								<option value="${categoria.idCategoria }">
									${categoria.descripcionCategoria }</option>
							</c:forEach>
						</select> <select name="dificultadEditCurso" id="dificultadEditCurso">
							<option value="${curso.idDificultad.idDificultad }"
								selected="selected">${curso.idDificultad.descripcionDificultad }</option>
							<c:forEach items="${dificultades }" var="dificultad">
								<option value="${dificultad.idDificultad }">
									${dificultad.descripcionDificultad }</option>
							</c:forEach>
						</select> <input name="precioEditCurso" type="text" id="precioEditCurso"
							placeholder="Precio del curso*" />
						<c:choose>
							<c:when test="${not empty curso.descripcion }">
								<textarea name="descripcionEdit" cols="40" rows="3"
									id="descripcionEdit" value="${curso.descripcion }"></textarea>
							</c:when>
							<c:otherwise>
								<textarea name="descripcionEditCurso" cols="40" rows="3"
									id="descripcionEditCurso" placeholder="Descripcion"></textarea>
							</c:otherwise>
						</c:choose>

						<input type="file" name="imgEditCurso" size="60"
							placeholder="Seleccione una imagen para el curso" />

					</fieldset>
					<input type="submit" class="submit" id="submit"
						value="MODIFICAR CURSO" />
				</form>
			</div>
		</div>
	</div>
	</section>

	<section id="alumnosMatriculados" class="parallax-section-1">
	<div class="container">
		<div class="col-md-12 text-center">
			<h3 class="section-title wow fadeInUp white">Alumnos
				matriculados</h3>
			<p class="subheading wow fadeInUp">
				<c:if test="${not empty listadoAlumnosCurso }">
					<span class="highlight">Estos son los alumnos matriculados
						en el ${curso.titulo }</span>
				</c:if>
				<c:if test="${empty listadoAlumnosCurso }">
					<span class="highlight">No hay alumnos matriculados en el
						${curso.titulo }</span>
				</c:if>
			</p>

		</div>
		<div class="row">
			<c:if test="${not empty listadoAlumnosCurso }">
				<c:forEach items="${listadoAlumnosCurso }" var="alumnoCurso">

					<div class="col-md-3 col-sm-6 team-member">
						<div class="effect effects wow fadeInUp">
							<div class="img">
								<c:choose>
									<c:when test="${not empty alumnoCurso.idUsuario.imagen }">
										<img src="${alumnoCurso.idUsuario.imagen }"
											class="img-responsive" alt="" />
									</c:when>
									<c:otherwise>
										<img src="img/clients/sinfoto.jpeg" style="margin: auto;"
											class="img-responsive" alt="" />
									</c:otherwise>
								</c:choose>
								<div class="overlay">
									<ul class="expand">
										<li class="social-icon"><a
											href="usuarios?idUsuario=${alumnoCurso.idUsuario.idUsuario }"><i
												class="icon-eye"></i></a></li>


										<c:if test="${sessionScope.usuario.admin }">
											<li class="social-icon"><a
												href="usuarios?idUsuario=${alumnoCurso.idUsuario.idUsuario }"><i
													class="ion-edit"></i></a></li>

											<li class="social-icon"><a
												href="cursos?idCurso=${curso.idCurso }&accion=deleteAlumno&target=${alumnoCurso.idUsuario.username }"><i
													class="ion-trash-a"></i></a></li>
										</c:if>

									</ul>
									<a class="close-overlay hidden">x</a>
								</div>
							</div>
						</div>
						<div class="member-info wow fadeInUp">
							<h4 style="color: white;">${alumnoCurso.idUsuario.nombre }
								${alumnoCurso.idUsuario.apellido }</h4>
							<p>${alumnoCurso.idUsuario.username }</p>
						</div>
					</div>

				</c:forEach>
			</c:if>
			<c:if test="${sessionScope.usuario.admin }">
				<div class="col-md-12 text-center">
					<p class="subheading wow fadeInUp">
						<span class="highlight">Añada un nuevo alumno al curso</span>
					</p>
				</div>
				<div id="contact">
					<div class="col-md-6 col-md-offset-3 text-center wow fadeInUp">
						<form method="post" action="cursos" name="addAlumnform"
							id="addAlumnform">
							<select name="target" id="target">
								<c:forEach items="${usuarios }" var="usuario">
									<option value="${usuario.username }">
										${usuario.username } - </option>
								</c:forEach>
							</select> 
							<input name="tarjeta" id="tarjeta" type="text" placeholder="Inserte una tarjeta para realizar el pago"/>
							<input name="accion" id="accion" type="hidden" value="addAlumno" />
							<input name="idCurso" id="idCurso" type="hidden"
								value="${curso.idCurso }" /> <input type="submit"
								class="submit" id="submit" value="AÑADIR ALUMNO" />
						</form>
					</div>
				</div>
			</c:if>
		</div>
	</div>
	</section>

	<section id="profesoresCurso">
	<div class="container">
		<div class="col-md-12 text-center">
			<h3 class="section-title wow fadeInUp">Profesores del curso</h3>
			<p class="subheading wow fadeInUp">
				<c:if test="${not empty profesoresInvitadosCurso }">
					<span class="highlight">Estos son los profesores del
						${curso.titulo }</span>
				</c:if>
				<c:if test="${empty profesoresInvitadosCurso }">
					<span class="highlight">No hay profesores invitados en el
						${curso.titulo }</span>
				</c:if>
			</p>
		</div>
		<div class="row">
			<c:if test="${not empty profesoresInvitadosCurso }">
				<c:forEach items="${profesoresInvitadosCurso }"
					var="profesorInvitado">
					<div class="col-md-4 col-sm-4 team-member">
						<div class="effect effects wow fadeInUp">
							<div class="img">
								<c:choose>
									<c:when test="${not empty profesorInvitado.idUsuario.imagen }">
										<img src="${profesorInvitado.idUsuario.imagen }"
											class="img-responsive" alt="" />
									</c:when>
									<c:otherwise>
										<img src="img/clients/sinfoto.jpeg" style="margin: auto;"
											class="img-responsive" alt="" />
									</c:otherwise>
								</c:choose>
								<div class="overlay">
									<ul class="expand">
										<li class="social-icon"><a
											href="usuarios?idUsuario=${profesorInvitado.idUsuario.idUsuario }"><i
												class="icon-eye"></i></a></li>

										<c:if test="${sessionScope.usuario.admin }">
											<li class="social-icon"><a
												href="usuarios?idUsuario=${profesorInvitado.idUsuario.idUsuario }"><i
													class="ion-edit"></i></a></li>

											<li class="social-icon"><a
												href="cursos?idCurso=${curso.idCurso }&accion=deleteProfe&target=${profesorInvitado.idUsuario.idUsuario }"><i
													class="ion-trash-a"></i></a></li>
										</c:if>
									</ul>
									<a class="close-overlay hidden">x</a>
								</div>
							</div>
						</div>
						<div class="member-info wow fadeInUp">
							<h4>${profesorInvitado.idUsuario.nombre }
								${profesorInvitado.idUsuario.apellido }</h4>
							<p>${profesorInvitado.idUsuario.username }</p>
						</div>
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${sessionScope.usuario.admin }">
				<div class="col-md-12 text-center">
					<p class="subheading wow fadeInUp">
						<span class="highlight">Añada un profesor invitado al curso</span>
					</p>
				</div>
				<div id="contact">
					<div class="col-md-6 col-md-offset-3 text-center wow fadeInUp">
						<form method="post" action="cursos" name="addProfeform"
							id="addProfeform">
							<select name="targetprofe" id="targetprofe">
								<c:forEach items="${usuarios }" var="usuario">
									<option value="${usuario.username }">
										${usuario.username }</option>
								</c:forEach>
							</select> <input name="accionprofe" id="accionprofe" type="hidden"
								value="addProfe" /> <input name="idcursoprofe"
								id="idcursoprofe" type="hidden" value="${curso.idCurso }" /> <input
								type="submit" class="submit" id="submitprofe"
								value="AÑADIR PROFESOR" />
						</form>
					</div>
				</div>
			</c:if>
		</div>
	</div>
	</section>

	<section id="price-list" class="parallax-section-2">
	<div class="container">
		<div class="col-md-12 text-center">
			<h3 class="section-title white wow fadeInUp">Temario</h3>
			<p class="subheading wow fadeInUp">
				<span class="highlight">Contenido del  ${curso.titulo }</span>
			</p>
		</div>
		<div class="row wow fadeInUp">
			<c:choose>
				<c:when test="${not empty listadoSeccionesDelCurso }">
					<c:forEach items="${listadoSeccionesDelCurso }" var="seccion">
						<div class="col-md-3 col-sm-6 price-list-box">
							<div class="price-box">
								<div class="price-table">
									<h3 class="label">${seccion.titulo }</h3>
									<c:if test="${not empty listadoLeccionesDelCurso }">
										<c:forEach items="${listadoLeccionesDelCurso }" var="leccion">
										<c:if test="${leccion.idSeccion.idSeccion == seccion.idSeccion }">
											<p class="price grey">
												<span class="pricing" style="font-size: medium;">${leccion.titulo }</span>
											</p>
											<c:if test="${not empty sessionScope.usuario }">
												<c:if test="${not empty listadoMaterialesLeccion }">
													<c:forEach items="${listadoMaterialesLeccion }" var="material">
													<c:if test="${leccion.idLeccion == material.idLeccion.idLeccion }">
														<p class="features grey">
															<a class="feature" href="${material.fichero }">${material.titulo }</a>
														</p>
														</c:if>
													</c:forEach>
												</c:if>
											</c:if>
											<p class="features grey">
												<a class="feature" href="material?idCurso=${curso.idCurso }&accion=material">Añadir material <i
													class="icon ion-plus-round"></i></a>
											</p>
											</c:if>
										</c:forEach>
									</c:if>
									<p class="price grey" style="border-top: 1px solid rgba(255, 255, 255, 0.15);">
										<span class="pricing" style="font-size: medium;">Añadir leccion <a href="material?idCurso=${curso.idCurso }&accion=leccion" title="Añadir Leccion"><i
													class="icon ion-plus-circled"></i></a></span>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
					<div class="col-md-3 col-sm-6 price-list-box">
							<div class="price-box">
								<div class="price-table">
									<a href="material?idCurso=${curso.idCurso }&accion=seccion"><h3 class="label">AÑADE UNA SECCION</h3></a>		
								</div>
							</div>
						</div>
				</c:when>
				<c:otherwise>
					<div class="col-md-3 col-sm-6 price-list-box" style="margin-left: 37.5%; margin-right: 37%;">
							<div class="price-box">
								<div class="price-table">
									<a href="material?idCurso=${curso.idCurso }&accion=seccion"><h3 class="label">AÑADE UNA SECCION</h3></a>
									<p class="price grey">
										<a href="material?idCurso=${curso.idCurso }&accion=leccion"><span class="pricing" style="font-size: medium;">Añade una leccion</span></a>
									</p>
									<p class="features grey">
										<a class="feature" href="material?idCurso=${curso.idCurso }&accion=material">Añade un material</a>
									</p>		
								</div>
							</div>
						</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	</section>

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
