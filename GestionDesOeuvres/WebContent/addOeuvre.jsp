<%@include file="includes/header.jsp"%>
<c:choose>
	<c:when test="${flagSaisieModif==true}">
		<h3 class="muted">Formulaire d'ajout d'oeuvres</h3>
		<c:set var="actionFormulaire" value="Controller?action=saveOeuvre"
			scope="page" />

	</c:when>
	<c:when test="${flagSaisieModif==false}">
		<h3 class="muted">Formulaire de modifications d'oeuvres</h3>
		<c:set var="actionFormulaire"
			value="Controller?action=updateOeuvre&id=${oeuvre.idOeuvrevente}"
			scope="page" />
	</c:when>
</c:choose>


<input type="hidden" name="uneErreur" value="${MesErreurs}"
	id="id_erreur">

<form method="post" action="${actionFormulaire}"
	onsubmit="return verif();" class="form-horizontal">

	<div class="control-group">
		<label class="control-label" for="titre">Titre de l'oeuvre</label>
		<div class="controls">
			<input type="text" id="titre" name="titre"
				value="${oeuvre.titreOeuvrevente}">
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" for="prix">Prix </label>
		<div class="controls">
			<input type="text" id="prix" name="prix"
				value="${oeuvre.prixOeuvrevente}">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="prix">Propriétaire </label>
		<div class="controls">
			<SELECT name="lstProprietaires">
				<c:forEach var="current" items="${listeProprietaires}">
					<c:choose>
						<c:when
							test="${current.nomProprietaire == oeuvre.proprietaire.nomProprietaire}">
							<option selected value="${current.idProprietaire}">${current.nomProprietaire}</option>
						</c:when>
						<c:otherwise>

							<option value="${current.idProprietaire}">${current.nomProprietaire}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>

			</SELECT>
		</div>
	</div>

	<div class="controls">
		<c:choose>
			<c:when test="${flagSaisieModif==true}">
				<button type="submit" class="btn btn-primary">Ajouter</button>

			</c:when>
			<c:when test="${flagSaisieModif==false}">
				<button type="submit" class="btn btn-primary">Modifier</button>

			</c:when>
		</c:choose>
		<button type="reset" class="btn">Reset</button>
	</div>
</form>

<hr>
<jsp:include page="includes/footer.jsp" />