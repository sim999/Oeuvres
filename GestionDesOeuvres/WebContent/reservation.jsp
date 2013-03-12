<%@include file="includes/header.jsp"%>

<input type="hidden" name="uneErreur" value="${MesErreurs}"
	id="id_erreur">

<form method="post" action="Controller?action=saveReservation&id=${oeuvre.idOeuvrevente}" class="form-horizontal">

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
		<label class="control-label" for="datedebut">Date Réservation</label>
		<div class="controls">

			<input type="text" id="datedebut" name="datedebut"
				data-date-format="yyyy-mm-dd">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="prix">Adhérent </label>
		<div class="controls">
			<SELECT name="lstReservations">
				<c:forEach var="current" items="${listeAdherents}">
					<option value="${current.idAdherent}">${current.nomAdherent}</option>
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

<script language=javascript>
	$('#datedebut').datepicker().on('changeDate', function(ev) {

		$('#datedebut').datepicker('hide');
	});

</script>


