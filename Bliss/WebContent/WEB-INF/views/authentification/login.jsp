<div class="row">
	<div class="col-md-8 col-md-offset-2">
		<form  method="post" data-persist="garlic" action="<c:url value ="/login"/>">
			<div class="form-group">
				<label for="exampleInputEmail1">Login</label>
				<input type="login" name="login" class="form-control" />
			</div>
				<br />
			<div class="form-group">
				<label for="exampleInputPassword1">Mot de passe</label>
				<input type="password" name="password" class="form-control" />
			</div>
				<br />
				<button type="submit" value ="Login" class="btn btn-default">Login</button>
		</form>
	</div>
</div>