<form class="form-horizontal" data-persist="garlic" method="post"
	action="#">
	<div class="form-group">
		<label for="inputName3" class="col-sm-2 control-label">Nom de
			l'ordinateur</label>
		<div class="col-sm-6">
			<input name="nom" type="text" class="form-control" id="inputName3"
				placeholder="Nom de l'ordinateur">
		</div>
	</div>
	<div class="form-group">
		<label for="inputIp3" class="col-sm-2 control-label">Ip de
			l'ordinateur</label>
		<div class="col-sm-6">
			<input name="ip" required
				pattern="((^|\.)((25[0-5])|(2[0-4]\d)|(1\d\d)|([1-9]?\d))){4}$"
				type="text" class="form-control" id="inputIp3"
				placeholder="255.255.255.255">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Salle</label>
		<div class="col-sm-6">
			<select name="salle" class="form-control">
				<c:forEach var="salle" items="${salles}">
					<option value="${salle.id}">${salle.nom}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">Enregistrer</button>
		</div>
	</div>
</form>