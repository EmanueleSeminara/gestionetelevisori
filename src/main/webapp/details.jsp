<%@page import="it.gestionetelevisori.model.Televisore"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%Televisore dettaglioTelevisore = (Televisore) request.getAttribute("dettagliTelevisore");%>
<title><%=dettaglioTelevisore.getMarca() + " " + dettaglioTelevisore.getModello()%>
	- Dettaglio</title>
</head>
<body>
	<p>
		Marca:
		<%=dettaglioTelevisore.getMarca()%></p>
	<p>
		Modello:
		<%=dettaglioTelevisore.getModello()%></p>
	<p>
		Prezzo:
		<%=dettaglioTelevisore.getPrezzo()%></p>
	<p>
		Numero Pollici:
		<%=dettaglioTelevisore.getNumeroPollici()%></p>
	<p>
		Codice:
		<%=dettaglioTelevisore.getCodice()%></p>
	<a href="searchForm.jsp">Home</a>

</body>
</html>