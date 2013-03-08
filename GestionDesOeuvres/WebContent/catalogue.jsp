<%@include file="includes/header.jsp" %>       
<h3 class="muted">Catalogue des oeuvres</h3>
		<div class="row">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Titre</th>
						<th>Prix</th>
						<th>Pr�nom propri�taire</th>
						<th>Nom propri�ataire</th>
						<th>R�server/Modifier</th>
					</tr>
				</thead>
				<c:forEach items="${listeOeuvres}" var="current">
					<tr>
						<td>${current.titreOeuvrevente}</td>
						<td>${current.prixOeuvrevente}</td>
						<td>${current.proprietaire.prenomProprietaire}</td>
						<td>${current.proprietaire.nomProprietaire}</td>
						<td><div class="btn-group">
								  <a class="btn btn-mini btn-primary" href="Controller?action=reserveOeuvre&id=${current.idOeuvrevente}">
								  <i class="icon-pencil"></i> R�server</a>
								  <a class="btn btn-mini btn-danger" href="Controller?action=modifOeuvre&id=${current.idOeuvrevente}">
								  <i class="icon-trash"></i> Modifier</a>
							</div></td>
					</tr>
				</c:forEach>
			</table>
			</div>
			<hr>
<jsp:include page="includes/footer.jsp" />
			
	