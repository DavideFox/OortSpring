<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE HTML>
<!--
	Industrious by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>Biblioteca | Ricerca utenti</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="<c:url value="/assets/css/main.css" />"/>
	</head>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<a class="logo" href="../">Utente</a>
				<nav>
					<a href="#menu">Menu</a>
				</nav>
			</header>

		<!-- Nav -->
		<nav id="menu">
			<ul class="links">
				<li><a href="../">Home</a></li>
				<li><a href="./inserisci">Inserimento</a></li>
				<li><a href="./visualizza">Visualizzazione</a></li>
				<li><a href="./modifica">Modifica</a></li>
				<li><a href="./ricerca">Ricerca</a></li>
			</ul>
		</nav>

		<!-- Heading -->
			<div id="heading" >
				<h1>Ricerca utente</h1>
			</div>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="inner">
					<div class="content">
						<!-- Form -->
						<h3>Email da cercare</h3>
						<form  method="post" action="">
							<div class="row gtr-uniform">
								<!--div class="col-6 col-12-xsmall"-->
								<div class="col-12">
									<input type="email" name="search-value" id="search-value" value="" placeholder="Email" />
								</div>
								<!-- Break -->
								<div class="col-12">
									<ul class="actions">
										<li><input type="submit" value="Invia" class="primary"/></li>
										<li><input type="reset" value="Cancella" /></li>
									</ul>
								</div>
							</div>
						</form>
						 
					<c:if test = "${utente != null}">
							<h3>Utente modificato</h3>
							<div class="table-wrapper">
								<table>
									<thead>
										<tr>
										<th>Nome</th>
										<th>Cognome</th>
										<th>Telefono</th>
										<th>Email</th>
										<th>Codice fiscale</th>
										</tr>
									</thead>
									<tbody>									
										<tr>
										<td>${utente.nome}</td>
										<td>${utente.cognome}</td>
										<td>${utente.telefono}</td>
										<td>${utente.email}</td>
										<td>${utente.codiceFiscale}</td>
										</tr>
									</tbody>		
								</table>
							</div>
					</c:if>
					</div>
				</div>
			</section>

		<!-- Footer -->
			<footer id="footer">
				<div class="inner">
					<div class="copyright">
						&copy; Luca Gregori.
					</div>
				</div>
			</footer>

		<!-- Scripts -->
			<script src="<c:url value="/assets/js/jquery.min.js" />"></script>
			<script src="<c:url value="/assets/js/browser.min.js" />"></script>
			<script src="<c:url value="/assets/js/breakpoints.min.js" />"></script>
			<script src="<c:url value="/assets/js/util.js" />"></script>
			<script src="<c:url value="/assets/js/main.js" />"></script>

	</body>
</html>