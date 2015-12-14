<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

</style>
</head>
<body>
		<!--Start Header-->
	<header> <nav class="navbar navbar-default" role="navigation">
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
						<li class="dropdown"><span class="dropdown-toggle"
							data-toggle="dropdown">Mi cuenta <b class="caret"></b></span>
							<ul class="dropdown-menu" role="menu">
								<li class="active"><a
									href="usuarios?username=${sessionScope.usuario.username }">Mi
										perfil</a></li>
								<li><a href="#">Conciliacion banco</a></li>
								<li><a href="login?accion=salir">Logout</a></li>
							</ul></li>
					</c:when>
					<c:otherwise>
						<li class="to-section"><a href="login">Login</a></li>
						<li class="to-section"><a href="registro">Registrarse</a></li>
					</c:otherwise>
				</c:choose>

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

	<section id="contact">
	<div class="container">
		<div class="row">

			<div class="col-md-12">
				<h2 class="section-title wow fadeInUp">AÑADE UN MATERIAL AL CURSO</h2>
			</div>

			<div class="col-md-6 col-md-offset-3 text-center wow fadeInUp">
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
				<form method="post" action="material?accion=material" name="materialForm"
					id="materialForm" enctype="multipart/form-data">

					<select name="leccionMaterial" id="leccionMaterial">
							<option value="0" selected="selected"> Seleccione una leccion</option>
							<c:forEach items="${listadoLeccionesCurso }" var="leccion">
								<option value="${leccion.idLeccion }"> ${leccion.titulo }</option>
							</c:forEach>
					</select>
					
					<fieldset>
						<input name="tituloMaterial" type="text" id="tituloMaterial"
							placeholder="Titulo del material" />
						<textarea name="descripcionMaterial" cols="40" rows="3"
							id="descripcionMaterial" placeholder="Descripcion del Material"></textarea>
						<input name="file" type="file" placeholder="Elija el archivo que desea subir al curso">
					</fieldset>
					
					<input name="idCurso" id="idCurso" type="hidden" value="${curso.idCurso }" />
					
					<input type="submit" class="submit" id="submit"
						value="AÑADIR MATERIAL" />
				</form>
			</div>

		</div>
	</div>
	</section>
</body>
</html>