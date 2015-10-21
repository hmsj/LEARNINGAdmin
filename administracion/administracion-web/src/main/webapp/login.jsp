<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <a class="navbar-brand to-top" rel="home" href="#">
                        	<img src="img/assets/logo-dark.png" alt="Dokulearning" class="logo-big">
                            <img src="img/assets/logo-dark.png" alt="Dokulearning" class="logo-small">
                        </a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="main-nav">
                    
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
                            <h2 class="section-title wow fadeInUp">BIENVENIDO ADMINISTRADOR</h2> 
                        </div>
                        
                        <div class="col-md-6 col-md-offset-3 text-center wow fadeInUp">
                            <div id="message"></div>
                            <!-- Contact Form will be functional only on your server. Upload to your server when testing. -->
                            <form method="post" action="" name="loginform" id="loginform">
                                <fieldset>
                                        <input name="username" type="text" id="username" placeholder="Nombre de administrador"/> 
                                        <input name="password" type="password" id="password" placeholder="Contraseña"/>  
                                </fieldset>
                                <input type="submit" class="submit" id="submit" value="ENTRAR" />
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
