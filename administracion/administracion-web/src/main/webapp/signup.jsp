<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link rel="stylesheet" href="css/colors/green.css" id="color-skins"/> 
    </head>
    <body>
                <!--Start Header-->
        <header>
			<nav class="navbar navbar-default" role="navigation">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#main-nav">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
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
                            <!--<li class="to-section"><a href="#team">Team</a></li>
                            <li class="to-section"><a href="#portfolio">Portfolio</a></li>-->                            
                            
                            <li class="to-section"><a href="#contact">Contact</a></li>
                            <li><a class="social-icon" href="http://www.twitter.com"><i class="icon icon-social-twitter"></i></a></li>
                            <li><a class="social-icon" href="http://www.twitter.com"><i class="icon icon-social-facebook"></i></a></li>
                            <li><a class="social-icon" href="http://www.google.com"><i class="icon icon-support"></i></a></li>
                      </ul>
                    </div><!-- /.navbar-collapse -->
				</div><!-- /.container -->
			</nav>
		</header>
        <!--End Header-->
        
       <!-- Start Contact Form Section -->    
            <section id="contact">
                <div class="container">
                    <div class="row">
                        
                        <div class="col-md-12">
                            <h2 class="section-title wow fadeInUp">REGISTRATE Y DISFRUTA</h2> 
                        </div>
                        
                        <div class="col-md-6 col-md-offset-3 text-center wow fadeInUp">
                            <div id="message"></div>
                            <form method="post" action="" name="signupform" id="signupform">
                            	<label for="tipouser">Selecciona uno de los siguientes roles:</label><fieldset>
                            		Alumno:<input name="tipouser" type="radio" id="tipouser" value="alumno" checked="checked">
                            		Profesor<input name="tipouser" type="radio" id="tipouser" value="profesor">
                            	</fieldset>
                                <fieldset>
                                	<input name="nombre" type="text" id="nombre" placeholder="Nombre*" style="color:red;"/> 
                                	<input name="apellidos" type="text" id="apellidos" placeholder="Apellidos*" style="color:red;"/> 
                                	<input name="username" type="text" id="username" placeholder="Nombre de usuario*" style="color:red;"/> 
                                	<input name="email" type="email" id="email" placeholder="Email*" style="color:red;"/>
                                	<input name="password" type="password" id="password" placeholder="Contraseña*" style="color:red;"/>  
                                	<input name="edad" type="number" id="edad" placeholder="Edad"/>
                                	<input name="intereses" type="text" id="intereses" placeholder="Intereses"/> 
                                	<input name="descripcion" type="text" id="descripcion" placeholder="Descripcion"/>
                                	<input name=> 
                                	
                                </fieldset>
                                <fieldset>
                                	<label for="pagos">Permite el uso de sus datos para sus cobros</label>
                                		<input name="paypal" type="checkbox" id="paypal">
                                </fieldset>
                                <input type="submit" class="submit" id="submit" value="CREAR USUARIO" />
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
