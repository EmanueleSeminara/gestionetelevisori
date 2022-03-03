<%@page import="java.util.List"%>
<%@page import="it.gestionetelevisori.model.Televisore"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Risultati ricerca</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
}

th, td {
	padding: 10px;
}

.center {
	margin-left: auto;
	margin-right: auto;
}

th.pulsante{
	border: none;
	background: #ccc;
}


</style>
</head>
<body>
<table class="center">
		<thead>
			<tr>
				<th>Marca</th>
				<th>Modello</th>
				<th>Prezzo</th>
				<th>Azione</th>
			</tr>
		</thead>

		<%
		List<Televisore> listaDaServlet = (List<Televisore>) request.getAttribute("risultatoRicerca");
		for (Televisore televisoreItem : listaDaServlet) {
		%>
		<tr>
			<td><%=televisoreItem.getMarca()%></td>
			<td><%=televisoreItem.getModello()%></td>
			<td><%=televisoreItem.getPrezzo()%></td>
			<td><a
				href="SeeDetailsServlet?idDaInviareComeParametro=<%=televisoreItem.getId()%>">Dettaglio</a>
				<a
				href="PrepareEditServlet?idDaInviareComeParametro=<%=televisoreItem.getId()%>">Modifica</a>
				<a
				href="PrepareDeleteServlet?idDaInviareComeParametro=<%=televisoreItem.getId()%>">Elimina</a>
			</td>
		</tr>
		<%
		}
		%>

	<tr><th colspan="4" class="pulsante"><a href="PrepareInsertServlet">Aggiungi Televisore</a></th></tr>
	</table>
</body>
</html>