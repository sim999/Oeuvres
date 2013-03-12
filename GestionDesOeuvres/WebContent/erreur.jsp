<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date,java.text.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Gestion des Oeuvres</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le style -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/datepicker.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<script src="javascript/jquery.js" type="text/javascript"></script>
<script src="javascript/bootstrap.js" type="text/javascript"></script>
<script src="javascript/bootstrap-dropdown.js" type="text/javascript"></script>
<script src="javascript/bootstrap-datepicker.js" type="text/javascript"></script>

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
		<div class="jumbotron pagination-centered">
			<h1>Erreur</h1>
			<p class="lead">${erreur}</p>
		</div>
		<hr>
<jsp:include page="includes/footer.jsp" />