<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<h3 class="section-title white wow fadeInUp ">Edite su perfil</h3>
			</div>
		<div class="row wow fadeInUp">

			<div class="col-md-6 col-sm-6 text-center">
				<div class="price-box">
					<div class="price-table">
						<h3 class="label">Perfil Actual</h3>
						<p class="price grey">
							**********/////////////FOTOGRAFIA****************************
						</p>
						<p class="features grey">
							<span class="feature">${sessionScope.usuario.username}</span> <span
								class="feature">${sessionScope.usuario.password}</span> <span 
								class="feature">${sessionScope.usuario.telefono}</span> <span 
								class="feature">${sessionScope.usuario.email}</span> <span
								class="feature no-border"></span>
							</span>

						</p>
					</div>
				</div>
			</div>		
			<div class="col-md-6 col-sm-6 text-center wow fadeInUp">
				<div class="price-box">
					<div class="price-table">
						<h3 class="label">Editar perfil</h3>
							<form method="post" action="editar" name="editform" id="editform">
					<fieldset>
						<p class="features" >
							<span class="feature"><input name="username" type="text" id="username"
									placeholder="Nombre de usuario*" /></span> 
							<span class="feature"><input name="password" type="password" id="password" 
									placeholder="Contraseña*"/></span> 
							<span class="feature"><input name="telefono" type="telefono" id="telefono" 
									placeholder="Telefono*"/></span> 
							<span class="feature"><input name="email" type="email" id="email"
									 placeholder="Email*"/></span> 
									 <span class="feature no-border"></span>
							</span>
						</p>
					</fieldset>
					<input type="submit" class="submit" id="submit" value="CAMBIAR" />
				</form>
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
