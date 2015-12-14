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

				<li><a class="to-section" href="index.jsp">Home</a></li>
				<li class="to-section"><a href="login.jsp">Login</a></li>
				<li class="to-section"><a href="#">Conciliacion banco</a></li>
				<!--<li class="to-section"><a href="#team">Team</a></li>
                            <li class="to-section"><a href="#portfolio">Portfolio</a></li>-->

				<li class="to-section"><a href="#contact">Contact</a></li>
				<li><a class="social-icon" href="http://www.twitter.com"><i
						class="icon icon-social-twitter"></i></a></li>
				<li><a class="social-icon" href="http://www.twitter.com"><i
						class="icon icon-social-facebook"></i></a></li>
				<li><a class="social-icon" href="http://www.google.com"><i
						class="icon icon-support"></i></a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav> </header>
	<!--End Header-->

	<!-- Start Contact Form Section -->
	<section id="contact">
	<div class="container">
		<div class="row">

			<div class="col-md-12">
				<h2 class="section-title wow fadeInUp">REGISTRATE Y DISFRUTA</h2>
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
				<form method="post" action="registro"
					name="signupform" id="signupform" enctype="multipart/form-data">
					<fieldset>
						<input name="nombre" type="text" id="nombre" placeholder="Nombre*" />
						<input name="apellidos" type="text" id="apellidos" placeholder="Apellidos*" /> 
						<input name="username" type="text" id="username" placeholder="Nombre de usuario*" /> 
						<input name="email" type="email" id="email" placeholder="Email*" />
						<input name="password" type="password" id="password" placeholder="Contraseña*" />
						<input name="edad" type="number" id="edad" placeholder="Edad" />				    
					</fieldset>
					<fieldset>
						<input name="telefono" type="tel" id="telefono" placeholder="Telefono" />
						<input name="pais" type="text" id="pais" placeholder="Pais" />
						<input name="ciudad" type="text" id="ciudad" placeholder="Ciudad"/>
						<input name="calle" type="text" id="calle" placeholder="Calle"/>
						<input name="numero" type="number" id="numero" placeholder="Numero" />
						<input name="piso" type="text" id="piso" placeholder="Piso"/>
						<input name="codigoPostal" type="text" id="codigoPostal" placeholder="Codigo Postal"/>
					</fieldset>
					<fieldset>
						<textarea name="intereses" cols="40" rows="3" id="intereses"
							placeholder="Intereses"></textarea>
						<textarea name="descripcion" cols="40" rows="3" id="descripcion"
							placeholder="Descripcion"></textarea>
					</fieldset>
					<fieldset>
						<input type="file" name="imgUsuario" placeholder="Seleccione una imagen"/>
					</fieldset>
					<input type="submit" class="submit" id="submit"
						value="CREAR USUARIO" />
				</form>
			</div>

		</div>
	</div>
	</section>
	<!-- End Contact Form Section -->

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
