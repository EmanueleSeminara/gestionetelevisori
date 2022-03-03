<%@page import="it.gestionetelevisori.model.Televisore"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%Televisore televisoreDaEliminare = (Televisore) request.getAttribute("televisoreDaEliminare");%>
<title><%=televisoreDaEliminare.getMarca() + " " + televisoreDaEliminare.getModello()%>
	- Eliminazione</title>
</head>
<body>
	<p>
		Marca:
		<%=televisoreDaEliminare.getMarca()%></p>
	<p>
		Modello:
		<%=televisoreDaEliminare.getModello()%></p>
	<p>
		Prezzo:
		<%=televisoreDaEliminare.getPrezzo()%></p>
	<p>
		Numero Pollici:
		<%=televisoreDaEliminare.getNumeroPollici()%></p>
	<p>
		Codice:
		<%=televisoreDaEliminare.getCodice()%></p>
	<form action="ExecuteDeleteServlet" method="post">
		<input type="hidden" name="idTelevisore"
			value="<%=televisoreDaEliminare.getId()%>"> <input
			type="submit" value="OK">
	</form>

</body>
</html>