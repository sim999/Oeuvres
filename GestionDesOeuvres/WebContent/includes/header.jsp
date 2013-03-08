<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date,java.text.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Gestion des Oeuvres</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="css/bootstrap.css" rel="stylesheet">
<style>
body {
	padding-top: 60px;
}
</style>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>

<body>
	<div class="container">

		<div class="masthead">
			<h2 class="muted">Gestion des Oeuvres</h2>
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container">
						<ul class="nav">
							<li><a href="#">Home</a></li>
							<li><a href="Controller?action=addOeuvre">Ajouter une oeuvre
									</a></li>
							<li><a href="Controller?action=listeOeuvres">Consulter le catalogue</a></li>
							<li><a href="Controleur?action=rechercheStage">Confirmer réservation</a></li>
							<li><a href="Controleur?action=rechercheStage">Se déconnecter</a></li>

						</ul>
					</div>
				</div>
			</div>
			<!-- /.navbar -->
		</div>