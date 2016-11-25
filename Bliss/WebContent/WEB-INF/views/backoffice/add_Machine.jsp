<form class="form-horizontal" data-persist="garlic" method="post" action="#">
  <div class="form-group">
    <label for="inputName3" class="col-sm-2 control-label">Nom de l'ordinateur</label>
    <div class="col-sm-6">
      <input name="nom" type="text" class="form-control" id="inputName3" placeholder="Nom de l'ordinateur">
    </div>
  </div>
  <div class="form-group">
    <label for="inputIp3" class="col-sm-2 control-label">Ip de l'ordinateur</label>
    <div class="col-sm-6">
      <input name="ip" data-fv-ip="true" type="text" class="form-control" id="inputIp3" placeholder="Ip de l'ordinateur">
    </div>
  </div>
<!--    <div class="form-group">
    <label for="inputNameSalle3" class="col-sm-2 control-label">Nom de la salle</label>
    <div class="col-sm-10">
      <input name="inputNameSalle3" type="text" class="form-control" id="inputNameSalle3" placeholder="Nom de la salle">
    </div>
  </div> -->
    <div class="form-group">
    <label  class="col-sm-2 control-label">Salle</label>
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