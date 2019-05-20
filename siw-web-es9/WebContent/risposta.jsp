<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resoconto dei dati</title>
</head>
<body>

	<p>Benvenuto, ecco i suoi dati:</p>
	<div>nome: ${studenteForm.nome}</div>
	<div>cognome: ${studenteForm.cognome}</div>
	<p>sei sicuro di procedere con questi dati?</p>
	<a href="conferma"> conferma</a>

</body>
</html>