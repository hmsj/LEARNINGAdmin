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
			<h3 class="section-title white wow fadeInUp ">Ticket del Pedido Realizado</h3>

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
			</div>
			<div class="col-md-6 col-sm-6 text-center" style="margin-left: 25%;">
				<div class="price-box">
					<div class="price-table">
						<h3 class="label">Datos del pedido</h3>
						<p class="features grey">
						<c:if test="${not empty pedidoCreado }">
							<c:if test="${not empty alumnoMatriculado }">
								<span class="feature"> <span class="highlight">Codigo de pedido:</span> ${pedidoCreado.codigoPedido}</span> 
								<span class="feature"> <span class="highlight">Codigo de operacion:</span> ${pedidoCreado.codigoOperacion}</span>
								<span class="feature"> <span class="highlight">Fecha del pedido:</span> ${pedidoCreado.fechaPedido}</span>
								<span class="feature"> <span class="highlight">Importe:</span> ${pedidoCreado.importe}</span>
								<span class="feature"> <span class="highlight">Nombre y apellidos:</span> ${alumnoMatriculado.idUsuario.nombre} ${alumnoMatriculado.idUsuario.apellido}</span>
								<span class="feature"> <span class="highlight">Nombre de usuario del alumno:</span> ${alumnoMatriculado.idUsuario.username}</span>
								<span class="feature"> <span class="highlight">Titulo del curso:</span> ${alumnoMatriculado.idCurso.titulo}</span>
								<span class="feature"> <span class="highlight">Numero de tarjeta:</span> ${pedidoCreado.codigoTarjeta}</span>
							</c:if>
						</c:if> 
					</div>
				</div>
			</div>
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
