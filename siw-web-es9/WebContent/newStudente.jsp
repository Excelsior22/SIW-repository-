<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="CSS/style.css" rel="stylesheet" />
<meta charset="ISO-8859-1">
</head>
<body>
	<p>Inserimento dati dello studente:</p>
	<form action="studenteController" method="post">
		<div>
			Nome: <input type="text" name="nome"
				value= "${nome}" />
			<span class="error"> ${nomeErr} </span>
		</div>
		<div>

			Cognome: <input type="text" name="cognome"
				value="${cognome}" />
			<span class="error"> ${cognomeErr} </span>
		</div>
		<input type="submit" name="submit" value="invia" />
	</form>

</body>
</html>