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
	<%
		int indexDebut = (int) request.getAttribute("indexDebut");

		int nombrePage = (int) request.getAttribute("nombrePage");
		int numeroPage = (int) request.getAttribute("numeroPage");
		int pageDebut;
		if (numeroPage == 1 || numeroPage == 2) {
			pageDebut = 1;
		} else {
			pageDebut = numeroPage - 2;
		}

		int pageFin;
		if (numeroPage == nombrePage || numeroPage == nombrePage - 1) {
			pageFin = (int) nombrePage;
		} else {
			pageFin = numeroPage + 2;
		}

		ArrayList<Ville> villes = (ArrayList) request.getAttribute("villes");
		int indexFin = 0;
		if (indexDebut == ((nombrePage - 1) * 50)) {
			indexFin = villes.size();
		} else {
			indexFin = indexDebut + 50;
		}

		String url = (String) session.getAttribute("url");
	%>
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
						<button onclick="window.location.href = 'RecuperationVilles?meteo=1';"
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

				<h1 class="font-weight-light">Liste des villes :</h1>
				<br>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">Ville</th>
							<th scope="col">#</th>
							<th scope="col">#</th>
						</tr>
					</thead>
					<tbody>
						<form method="post" action="modification">

							<%
								for (int i = indexDebut; i < indexFin; i++) {
							%>
						
						<tr>
							<td><%=villes.get(i).getNomCommune()%></td>
							<td><a
								href="modification?ville=<%=villes.get(i).getNomCommune()%>">Modifier</a></td>
							<td><a
								href="suppression?ville=<%=villes.get(i).getNomCommune()%>">Supprimer</a><br></td>
						</tr>

						<%
							}
						%>

						</form>
					</tbody>
				</table>
			</div>
		</div>

		<%
			if (nombrePage > 1) {
		%>
		<div class="container-central" style="margin-top: 19px;">
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
					<li class="page-item"><a class="page-link"
						href="AfficheVilles?pageno=1" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
					</a></li>
					<c:forEach var="entry" begin="<%=pageDebut%>" end="<%=pageFin%>"
						step="1">
						<li class="page-item"><a class="page-link"
							href="AfficheVilles?pageno=${entry}">${entry}</a></li>
					</c:forEach>
					<li class="page-item"><a class="page-link"
						href="AfficheVilles?pageno=<%=nombrePage%>" aria-label="Next">
							<span aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
					</a></li>
				</ul>
			</nav>
		</div>
		<%
			}
		%>

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