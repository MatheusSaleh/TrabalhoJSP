<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Tela de cadstro de artista
	<form action="/fema3bccJsp/ArtistaControlador">
		<br>
		<label>Codigo</label>
		<input type="text" name="codigoArtista">
		<br>
		<br>
		<label>Nome</label>
		<input type="text" name="nomeArtista">
		<br>
		<br>	
		<label>Gravadora</label>
		<input type="text" name="gravadora">
		<br>
		<br>	
		<input type="submit" name="operacao" value="Cadastrar">
	</form>
</body>
</html>