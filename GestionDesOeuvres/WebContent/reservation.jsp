<%@include file="includes/header.jsp"%>

<input type="hidden" name="uneErreur" value="${MesErreurs}"
	id="id_erreur">

<form method="post" action="Controller?action=saveReservation"
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
		<label class="control-label" for="date">Prix </label>
		<div class="controls">
			<input type="text" id="datefin" name="datefin"
				data-date-format="yyyy-mm-dd">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="prix">Adhérent </label>
		<div class="controls">
			<SELECT name="lstProprietaires">
				<c:forEach var="current" items="${listeAdherents}">
					<option selected value="${current.idAdherent}">${current.nomAdherent}</option>
				</c:forEach>

			</SELECT>
		</div>
	</div>

	<div class="controls">
		<button type="submit" class="btn btn-primary">Réserver</button>
		<button type="reset" class="btn">Reset</button>
	</div>
</form>

<hr>
<jsp:include page="includes/footer.jsp" />