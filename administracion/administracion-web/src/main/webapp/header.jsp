<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-default navbar-alt"
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
						<li class="to-section"><a href="login?accion=salir">Logout</a></li>
					</c:when>
					<c:otherwise>
						<li class="to-section"><a href="login">Login</a></li>
					</c:otherwise>
				</c:choose>
				<!-- <li class="to-section"><a href="#team">Team</a></li>
                            <li class="to-section"><a href="#portfolio">Portfolio</a></li>
 -->
				<li class="dropdown"><span class="dropdown-toggle"
					data-toggle="dropdown">Cursos <b class="caret"></b></span>
					<ul class="dropdown-menu" role="menu">
						<li class="active"><a href="#">Home - Parallax</a></li>
						<li><a href="home-video.html">Home - Video Slider</a></li>
						<li><a href="home-fullwidth.html">Home - Fullwidth</a></li>
						<li><a href="home-landing-page.html">Home - Landing Page</a></li>
						<li><a href="shortcodes.html">Shortcodes</a></li>

					</ul></li>

				<li class="to-section"><a href="signup.jsp">Registrarse</a></li>
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
	<!-- /.container --> </nav>


