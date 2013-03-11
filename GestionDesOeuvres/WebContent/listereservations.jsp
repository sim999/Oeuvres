<%@include file="includes/header.jsp" %>       
<h3 class="muted">Catalogue des oeuvres</h3>
		<div class="row">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
					<th>Titre</th>
                    <th>Date</th>
                    <th>Statut</th>
                    <th>Prénom adhérent</th>
                    <th>Nom adhérent</th>
                    <th>Confirmer</th>
					</tr>
					
				</thead>
				<c:forEach items="${listeReservations}" var="current">
					<tr>
						<td>${current.titreOeuvrevente}</td>
						<td>${current.prixOeuvrevente}</td>
						<td>${current.proprietaire.prenomProprietaire}</td>
						<td>${current.proprietaire.nomProprietaire}</td>
						<td><div class="btn-group">
								  <a class="btn btn-mini btn-primary" href="Controller?action=reserveOeuvre&id=${current.idOeuvrevente}">
								  <i class="icon-pencil"></i> Réserver</a>
								  <a class="btn btn-mini btn-danger" href="Controller?action=modifOeuvre&id=${current.idOeuvrevente}">
								  <i class="icon-trash"></i> Modifier</a>
							</div></td>
					</tr>
				</c:forEach>
			</table>
			</div>
			<hr>
<jsp:include page="includes/footer.jsp" />
			
	

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste réservations</title>
    </head>
    <body>
        <h1 align='center'>Liste des réservations</h1>
            <p>
            <table border="1">
                <tr>
                    <td>Titre</td>
                    <td>Date</td>
                    <td>Statut</td>
                    <td>Prénom adhérent</td>
                    <td>Nom adhérent</td>
                    <td>Confirmer</td>
                </tr>


            </table>
            <a href="xxxxxxxx">Accueil</a>
            <p>

            </p>
    </body>
</html>
