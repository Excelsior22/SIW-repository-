<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista strudenti</title>
</head>
<body>
	<h1>elenco studenti</h1>
	<table>
		<tr>
			<th>Nome</th>
			<th>Cognome</th>
		</tr>
		<c:forEach var="studente" items="${studenti}">
			<tr>
				<td><a href="studenteController?id=${studente.id}">
				Nome: ${studente.nome}</a></td>
				<td><a href="studenteController?id=${studente.id}">
						Cognome: ${studente.cognome} </a></td>
			<tr>
		</c:forEach>
	</table>
</body>
</html>