<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Tela de cadstro de pais
	<form action="/fema3bccJsp/PaisControlador">
		<br>
		<label>Codigo</label>
		<input type="text" name="codigoPais">
		<br>
		<br>
		<label>Nome</label>
		<input type="text" name="nomePais">
		<br>
		<br>	
		<label>Sigla</label>
		<input type="text" name="siglaPais">
		<br>
		<br>	
		<input type="submit" name="operacao" value="Cadastrar">
	</form>
</body>
</html>