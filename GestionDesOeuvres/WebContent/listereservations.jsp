<%@include file="includes/header.jsp"%>
<h3 class="muted">Catalogue des Réservations</h3>
<div class="row">
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Titre</th>
				<th>Date</th>
				<th>Statut</th>
				<th>Prénom adhérent</th>
				<th>Nom adhérent</th>
				<th>Confirmer/Supprimer</th>
			</tr>

		</thead>
		<c:forEach items="${listeReservations}" var="current">
			<tr>
				<td>${current.oeuvrevente.titreOeuvrevente}</td>
				<td>${current.dateReservation}</td>
				<td>${current.statut}</td>
				<td>${current.adherent.prenomAdherent}</td>
				<td>${current.adherent.nomAdherent}</td>
				<td><div class="btn-group">
						<c:choose>
							<c:when test="${current.statut eq 'confirmee'}">
								<a class="btn btn-mini btn-primary disabled" href="#"> <i
									class="icon-pencil"></i> Confimer
								</a>
								<a class="btn btn-mini btn-danger"
									href="Controller?action=deleteReservation&idOeuvreVente=${current.oeuvrevente.idOeuvrevente}&idAdherent=
									${current.adherent.idAdherent}">
									<i class="icon-trash"></i> Supprimer
								</a>
							</c:when>
							<c:otherwise>
								<a class="btn btn-mini btn-primary "
									href="Controller?action=confirmReservation&idOeuvreVente=${current.oeuvrevente.idOeuvrevente}&idAdherent=
									${current.adherent.idAdherent}">
									<i class="icon-trash"></i> Confirmer
								</a>
								<a class="btn btn-mini btn-danger"
									href="Controller?action=deleteReservation&idOeuvreVente=${current.oeuvrevente.idOeuvrevente}&idAdherent=
									${current.adherent.idAdherent}">
									<i class="icon-trash"></i> Supprimer
								</a>
							</c:otherwise>
						</c:choose>

					</div></td>
			</tr>
		</c:forEach>
	</table>
</div>
<hr>
<jsp:include page="includes/footer.jsp" />

