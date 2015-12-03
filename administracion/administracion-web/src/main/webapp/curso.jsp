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
	<jsp:include page="header.jsp"></jsp:include>
	<section id="price-list" class="parallax-section-6">
	<div class="container">
		<div class="col-md-12 text-center">
			<h3 class="section-title white wow fadeInUp ">${curso.titulo }</h3>

			<div class="row wow fadeInUp">

				<div class="col-md-6 col-sm-6 text-center">
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
																	alt="" />
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
							<span class="feature"> <span class="highlight">Titulo:</span> ${curso.titulo}</span>
							<span class="feature"> <span class="highlight">Profesor titular:</span> ${profesorTitularCurso.idUsuario.nombre } ${profesorTitularCurso.idUsuario.apellido }</span> 
							<span class="feature"> <span class="highlight">Descripcion:</span> ${curso.descripcion}</span>
							<span class="feature"> <span class="highlight">Categoria:</span> ${curso.idCategoria.descripcionCategoria}</span>
							<span class="feature"> <span class="highlight">Dificultad:</span> ${curso.idDificultad.descripcionDificultad}</span>
							<span class="feature"> <span class="highlight">Precio Inicial:</span> ${curso.precioInicial}</span>
							<span class="feature"> <span class="highlight">Promocion:</span> ${curso.idPromocion.valor} 
								<c:if test="${curso.idPromocion.tipoPromocion.idTipoPromocion == 1 }"> € </c:if> 
								<c:if test="${curso.idPromocion.tipoPromocion.idTipoPromocion == 2 }"> % </c:if>
							</span>
							<span class="feature"> <span class="highlight">Precio Final:</span> </span>
							<c:if test="${sessionScope.usuario.admin }">
								<span class="feature"> <span class="highlight">Estado:</span> 
									<c:choose>
										<c:when test="${curso.validado }">
											Validado
										</c:when>
										<c:otherwise>
											No validado <a href="#" title="Validar Curso"><i class="icon ion-checkmark-circled"></i></a>	
										</c:otherwise>
									</c:choose>
								</span>
								<span class="feature"> <span class="highlight">Destacado:</span> 
									<c:choose>
										<c:when test="${curso.destacado }">
											Si <a href="#" title="Quitar Destacado"><i class="icon ion-ios-star"></i></a>
										</c:when>
										<c:otherwise>
											No 
											<c:if test="${curso.validado }">
												<a href="#" title="Hacer Destacado"><i class="icon ion-ios-star-outline"></i></a>
											</c:if>
											</c:otherwise>
									</c:choose>
								</span>
							</c:if>
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
