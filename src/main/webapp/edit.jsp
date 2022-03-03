<%@page import="it.gestionetelevisori.model.Televisore"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifica Televisore</title>
</head>
<body>
<% if(request.getAttribute("messaggioDiErrore") != null){ %>
		<p style="color: red;"><%=request.getAttribute("messaggioDiErrore") %></p>
	<%  }else{ %>
		Modifica dati Televisore<br>
	<%}    %>
	<%	Televisore televisoreDaModificare = (Televisore) request.getAttribute("televisoreDaModificare");%>
<form action="ExecuteEditServlet" method="post">
<input type="hidden" name="idTelevisore"
			value="<%=televisoreDaModificare.getId()%>">
		<label for="marcaInputId">MARCA:</label><br>
		<input type="text" name="marcaInput" id="marcaInputId" value="<%=televisoreDaModificare.getMarca()%>">
		<br>
		<label for="modelloInputId">MODELLO:</label><br>
		<input type="text" name="modelloInput" id="modelloInputId" value="<%=televisoreDaModificare.getModello()%>">
		<br>
		<label for="prezzoInputId">PREZZO:</label><br>
		<input type="text" name="prezzoInput" id="prezzoInputId" value="<%=televisoreDaModificare.getPrezzo()%>">
		<br>
		<label for="numeroPolliciInputId">NUMERO POLLICI:</label><br>
		<input type="text" name="numeroPolliciInput" id="numeroPolliciInputId" value="<%=televisoreDaModificare.getNumeroPollici()%>">
		<br>
		<label for="codiceInputId">CODICE:</label><br>
		<input type="text" name="codiceInput" id="codiceInputId" value="<%=televisoreDaModificare.getCodice()%>">
		<br>
		<br><br>
		<input type="submit" value="MODIFICA">
	
	</form>
</body>
</html>