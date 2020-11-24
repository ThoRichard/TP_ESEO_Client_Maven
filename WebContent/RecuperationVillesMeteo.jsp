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

					<li class="nav-item"><form method="post"
							action="RecuperationVilles">
							<button type="submit" class="btn btn-outline-warning">Calcul
								de distance</button>
						</form></li>

					<li class="nav-item">
						<button onclick="window.location.href = 'AfficheVilles?pageno=1';"
							class="btn btn-outline-warning">Afficher toutes les
							villes</button>
					</li>

					<li class="nav-item">
						<button
							onclick="window.location.href = 'RecuperationVilles?meteo=1';"
							class="btn btn-outline-warning">Voir la meteo</button>
					</li>
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


				<h1 class="font-weight-light">Affichage de la météo</h1>
				<p class="lead">Veuillez choisir une ville :</p>

				<div class="row vertical-offset-100">
					<div class="col-sm-5 mx-auto">
						<div class="panel panel-default">
							<div class="panel-body">
								<form method="post" action="RecuperationMeteo">
									<fieldset>
										<div class="form-group">

											<select name="ville1" size="1" class="form-control">
												<%
													ArrayList<Ville> liste1 = (ArrayList) session.getAttribute("villes");
													for (Ville ville : liste1) {
												%>
												<option>
													<%=ville.getNomCommune()%>
													<%
														}
													%>
												
											</select> <br> <br> <input
												class="btn btn-lg btn-primary btn-block" type="submit"
												value="Voir la météo" name="action">
										</div>
									</fieldset>
								</form>

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