<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/main.css">
	<title>Formulaire stagiaire</title>	
</head>


<body>
	<h2>Gestion des stagiaires</h2>
	<form action="ServletStagiaire" method="GET" id="form-contact" class="container">
		<br />
		<div class="from-group">
			<label for="nom">Nom</label>
			<input id="nom" type="text"	placeholder="..." value="${nom}" name="nom" required/>
			<label for="prenom">Prénom</label>
			<input id="prenom" type="text" placeholder="..." value="${prenom}" name="prenom" required/>
			<label for="age">Âge</label>
			<input id="age" type="number" placeholder="000" value="${age}" name="age" required/>
			<label for="age">ID Promo</label>
			<input id="fpromo" type="number" placeholder="000" value="${fpromo}" name="fpromo" required/>
		</div>
		<br/>
		<div>
            <input type="submit" name="ajouter" value="Ajouter stagiaire" />
        </div>                
	</form>
	

<div class="container">
  <h2>Stagiaires existants</h2>
  <p>dans la BDD</p>
  <table class="table table-bordered table-sm">

    <thead class=greenrow>
      <tr>
		<th>ID</th>
        <th>Prénom</th>
        <th>Nom</th>
        <th>Âge</th>
      </tr>
    </thead>

    <tbody>
   		<c:if test="${not empty stagiaires}">
			<c:forEach items="${stagiaires}" var="st">
				<tr>
					<td><c:out value="${st.idStagiaire}"/></td>
					<td><c:out value="${st.prenom}"/></td>
					<td><c:out value="${st.nom}"/></td>
					<td><c:out value="${st.age}"/></td>
					<td><c:out value="${st.fpromo}"/></td>
					<td><a href="SupprimerStagiaire?idStagiaire=${st.idStagiaire}">supprimer</a></td>
				</tr> 
			</c:forEach>
		</c:if>
    </tbody>

  </table>
</div>

</html>