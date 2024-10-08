<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Musica</title>
</head>
<body>
	Tela de cadastro de album
	<form action="/fema3bccJsp/MusicaControlador">
		<br>
		<label>Codigo</label>
		<input type="text" name="codigoMusica">
		<br>
		<br>
		<label>Nome</label>
		<input type="text" name="nomeMusica">
		<br>
		<br>	
		<input type="submit" name="operacao" value="Cadastrar Nova Musica">
	</form>
</body>
</html>