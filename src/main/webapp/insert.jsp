<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aggiunta nuovo televisore</title>
</head>
<body>
<% if(request.getAttribute("messaggioDiErrore") != null){ %>
		<p style="color: red;"><%=request.getAttribute("messaggioDiErrore") %></p>
	<%  }else{ %>
		Inserire dati nuovo Televisore<br>
	<%}    %>
<form action="ExecuteInsertServlet" method="post">
		<label for="marcaInputId">MARCA:</label><br>
		<input type="text" name="marcaInput" id="marcaInputId">
		<br>
		<label for="modelloInputId">MODELLO:</label><br>
		<input type="text" name="modelloInput" id="modelloInputId">
		<br>
		<label for="prezzoInputId">PREZZO:</label><br>
		<input type="text" name="prezzoInput" id="prezzoInputId">
		<br>
		<label for="numeroPolliciInputId">NUMERO POLLICI:</label><br>
		<input type="text" name="numeroPolliciInput" id="numeroPolliciInputId">
		<br>
		<label for="codiceInputId">CODICE:</label><br>
		<input type="text" name="codiceInput" id="codiceInputId">
		<br>
		<br><br>
		<input type="submit" value="AGGIUNGI">
	
	</form>
</body>
</html>