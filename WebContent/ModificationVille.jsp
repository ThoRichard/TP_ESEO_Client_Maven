<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.Ville"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
							class="btn btn-outline-warning">Voir la m�t�o</button>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Masthead-->

	<section class="page-section" id="services">
		<div class="container">
			<div class="text-center">
				<br>
				<h1 class="font-weight-light">
					Modification de la ville
					<%=session.getAttribute("nomCommune")%></h1>
				<br>
				<form method="POST" action="EffectuerModification">
					<div class="form-group">
						<label for="codeCommune">Code Commune INSEE</label> <input
							type="text" class="form-control" id="codeCommune"
							value="<%=session.getAttribute("codeCommune")%>" disabled> 
					</div>
					<div class="form-group">
						<label for="nomCommune">Nom commune</label> <input
							type="text" class="form-control" id="nomCommune" name="nomCommune"
							value="<%=session.getAttribute("nomCommune")%>" required> 
					</div>
					<div class="form-group">
						<label for="codePostal">Code postal</label> <input
							type="text" class="form-control" id="codePostal" name="codePostal"
							value ="<%=session.getAttribute("codePostal")%>" required> 
					</div>
					<div class="form-group">
						<label for="libelleAcheminement">Libelle acheminement</label> <input
							type="text" class="form-control" id="libelleAcheminement" name="libelleAcheminement"
							value="<%=session.getAttribute("libelleAcheminement")%>" required> 
					</div>
					
					<div class="form-group">
						<label for="ligne">Ligne</label> <input
							type="text" class="form-control" id="ligne" name="ligne"
							value="<%=session.getAttribute("ligne")%>"> 
					</div>
					<div class="form-group">
						<label for="latitude">Latitude</label> <input
							type="number" step="any" class="form-control" id="latitude" name="latitude"
							value="<%=session.getAttribute("latitude")%>"> 
					</div>
					<div class="form-group">
						<label for="longitude">Longitude</label> <input
							type="number" step="any" class="form-control" id="longitude" name="longitude"
							value="<%=session.getAttribute("longitude")%>"> 
					</div>
					<button type="submit" name="codeCommune" value="<%=session.getAttribute("codeCommune")%>" class="btn btn-primary">Modifier</button>
				</form>

			</div>
		</div>
	</section>


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
	<script>
		$(function() {
			$('[data-toggle="tooltip"]').tooltip()
		})
	</script>
</body>
</html>