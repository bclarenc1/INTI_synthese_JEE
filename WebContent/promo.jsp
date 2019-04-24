<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/main.css">
	<title>Formulaire promotion</title>	
</head>


<body>
	<h2>Gestion des promotions</h2>
	<form action="ServletPromo" method="GET" id="form-contact" class="container">
		<br />
		<div class="from-group">
			<label for="nom">Nom</label>
			<input id="nom" type="text"	placeholder="JJ" value="${nom}" name="nom" required/>
			<label for="eff">Effectif</label>
			<input id="eff" type="number" placeholder="000" value="${eff}" name="eff" required/>
		</div>
		<br/>
		<div>
            <input type="submit" name="ajouter" value="Ajouter promotion" />
        </div>                
	</form>
	

<div class="container">
  <h2>Promos existantes</h2>
  <p>dans la BDD</p>
  <table class="table table-bordered table-sm">

    <thead class=greenrow>
      <tr>
		<th>ID</th>
        <th>Nom</th>
        <th>Effectif</th>
      </tr>
    </thead>

    <tbody>
   		<c:if test="${not empty promos}">
			<c:forEach items="${promos}" var="p">
				<tr>
					<td><c:out value="${p.idPromo}"/></td>
					<td><c:out value="${p.nomPromo}"/></td>
					<td><c:out value="${p.effectif}"/></td>
					<td><a href="SupprimerPromo?idPromo=${p.idPromo}">supprimer</a></td>
				</tr> 
			</c:forEach>
		</c:if>
    </tbody>

  </table>
</div>

</html>