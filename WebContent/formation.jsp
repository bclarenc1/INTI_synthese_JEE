<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/main.css">
	<title>Formulaire formation</title>	
</head>


<body>
	<h2>Gestion des formations</h2>
	<form action="ServletFormation" method="GET" id="form-contact" class="container">
		<br />
		<div class="from-group">
			<label for="nom">Nom</label>
			<input id="nom" type="text"	placeholder="JJ" value="${nom}" name="nom" required/>
		</div>
		<br/>
		<div>
            <input type="submit" name="ajouter" value="Ajouter formation" />
        </div>                
	</form>
	

<div class="container">
  <h2>Formations existantes</h2>
  <p>dans la BDD</p>
  <table class="table table-bordered table-sm">

    <thead class=greenrow>
      <tr>
		<th>ID</th>
        <th>Nom</th>
      </tr>
    </thead>

    <tbody>
   		<c:if test="${not empty formations}">
			<c:forEach items="${formations}" var="f">
				<tr>
					<td><c:out value="${f.idFormation}"/></td>
					<td><c:out value="${f.nomFormation}"/></td>
					<td><a href="SupprimerFormation?idFormation=${f.idFormation}">supprimer</a></td>
				</tr> 
			</c:forEach>
		</c:if>
    </tbody>

  </table>
</div>

</html>