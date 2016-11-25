<table class="table table-striped table-bordered">
	<tr>
		<th>Nom</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${salles}" var="s">
		<tr>
			<td>${s.nom }</td>
			<td><a href="<c:url value="/backoffice/modifier_salle?id=${s.id }"/>" class="btn btn-default" data-id="${s.id}">Modifier</a>
			<a href="#" class="btn btn-default suppr" data-id="${s.id}">Supprimer</a></td>
		</tr>
	</c:forEach>
</table>
<script type="text/javascript">
	$(document).ready(function(){
		$(".suppr").each(function(){
			$(this).click(function(){
				var idSalle = $(this).data("id");
				//alter(idUtilisateur);
				$.ajax({
					url:"<c:url value='/backoffice/delete_salle'/>",
					type: "POST",
					dataType:"json",
					data:{id: idSalle},
					success:function(obj){
						lien.parent().parent().fadeout("slow");
					}
				});
			});
		});
	});
</script>