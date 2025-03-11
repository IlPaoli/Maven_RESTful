<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index</title>
</head>
<body>
	<h2>
		<p>Benvenuto Utente Curioso, questa è la mia prima JSP.</p>
		<p>Oggi è il giorno <%= new Date() %></p>
		<p>Autore: <a href = "http://localhost:8080/author.jsp">link</a></p>
	</h2>
</body>
</html>
