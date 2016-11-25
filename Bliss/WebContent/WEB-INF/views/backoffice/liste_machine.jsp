<table class="table table-striped table-bordered">
    <tr>
        <th>Nom</th>
        <th>IP</th>
        <th>Salle</th>
        <th>Action</th>
    </tr>
    
    <c:forEach items="${machines}" var="m" >
        <tr>
        	<td>${m.nom }</td>
            <td>${m.ip }</td>
            <td>${m.nomSalle}</td>
            <td><a href="<c:url value="/backoffice/modifier_machine?id=${m.id }"/>" class="btn btn-default" data-id="${m.id}">Modifier</a>
            <a href="#" class="btn btn-default suppr" data-id="${m.id}">Supprimer</a></td>
        </tr>
    </c:forEach>
</table>
<script type="text/javascript">
    $(document).ready(function(){
        $(".suppr").each(function(){
            $(this).click(function(){
            	var lien = $(this);
                var idMachine = $(this).data("id");
                //alter(idUtilisateur);
                $.ajax({
                    url:"<c:url value='/backoffice/delete_machine'/>",
                    type: "POST",
                    dataType:"json",
                    data:{id: idMachine},
                    complete:function(obj){
                        lien.parent().parent().fadeOut("slow");
                    }
                });
            });
        });
    });
</script>