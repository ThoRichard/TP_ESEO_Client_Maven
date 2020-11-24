<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.Ville"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>TWIC 2020</title>
<link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
</head>
<body id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="index.html">TWIC
				2020</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars ml-1"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav text-uppercase ml-auto">
					<form method="post" action="RecuperationVilles">
						<li class="nav-item"><button type="submit"
								class="btn btn-outline-warning">Calcul de distance</button></li>
					</form>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#portfolio">Toutes les villes</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Masthead-->
	<div class="container"></div>

	<br>
	<section class="page-section" id="services">
		<div class="container">
			<div class="text-center">


				<h1 class="font-weight-light">Calcul la distance entre les
					villes</h1>
				<p class="lead">Veuillez choisir deux villes :</p>
				
					<div class="row vertical-offset-100">
						<div class="col-sm-5 mx-auto">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">Villes choisies :</h3>
									<br>
								</div>
								<div class="panel-body">
									<FORM method="post" action="calculDistance">
										<fieldset>
											<div class="form-group">

												<SELECT name="ville1" size="1">
													<%
														ArrayList<Ville> liste1 = (ArrayList) session.getAttribute("villes");
														for (Ville ville : liste1) {
													%>
													<OPTION>
														<%=ville.getNomCommune()%>
														<%
															}
														%>
													
												</SELECT> <SELECT name="ville2" size="1">
													<%
														ArrayList<Ville> liste2 = (ArrayList) session.getAttribute("villes");
														for (Ville ville : liste2) {
													%>
													<OPTION>
														<%=ville.getNomCommune()%>
														<%
															}
														%>
													
												</SELECT> <br> <br> <input
													class="btn btn-lg btn-primary btn-block" type="submit"
													value="Calcul de la distance" name="action">
											</div>
										</fieldset>
										<input class="btn btn-lg btn-primary btn-block" type="submit"
											value="Voir la météo" name="action">
									</FORM>
									<br> <a href="afficheVille"> Afficher les villes </a><br>
								</div>
							</div>
						
					</div>
				</div>
			</div>
		</div>
	

		<!-- Bootstrap core JS-->
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
		<!-- Third party plugin JS-->
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
		<!-- Contact form JS-->
		<script src="assets/mail/jqBootstrapValidation.js"></script>
		<script src="assets/mail/contact_me.js"></script>
		<!-- Core theme JS-->
		<script src="js/scripts.js"></script>
</body>
</html>