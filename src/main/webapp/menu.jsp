<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Connection, java.sql.Statement, java.sql.ResultSet" %>
<%@ page import="fema3bccJsp.DatabaseConnection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestão de Artistas</title>
</head>
<body>
	<h2>Cadastro e Consulta de Artistas</h2>

	<form action="/fema3bccJsp/ArtistaControlador">
		<input type="submit" name="operacao" value="Cadastrar Artista">
	</form>
	<br><br>

	<form action="/fema3bccJsp/ArtistaControlador">
		<input type="submit" name="operacao" value="Consultar Artista">
	</form>
	
	<form action="/fema3bccJsp/AlbumControlador">
		<input type="submit" name="operacao" value="Cadastrar Album">
	</form>
	
	<form action="/fema3bccJsp/AlbumControlador">
		<input type="submit" name="operacao" value="Consultar Album">
	</form>
	
	<form action="/fema3bccJsp/MusicaControlador">
		<input type="submit" name="operacao" value="Consultar Musica">
	</form>
	
	<form action="/fema3bccJsp/MusicaControlador">
		<input type="submit" name="operacao" value="Cadastrar Musica">
	</form>
	

	<%
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
		    conn = DatabaseConnection.getConnection();
		    stmt = conn.createStatement();

		    String sql = "SELECT * FROM cantor";
		    rs = stmt.executeQuery(sql);

		    out.println("<h3>Lista de Cantores Cadastrados:</h3>");
		    while (rs.next()) {
		        out.println("ID: " + rs.getInt("id") + "<br>");
		        out.println("Nome: " + rs.getString("nome") + "<br>");
		        out.println("Gravadora: " + rs.getString("gravadora") + "<br><br>");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		    out.println("Erro ao consultar os cantores: " + e.getMessage());
		} finally {
		    if (rs != null) rs.close();
		    if (stmt != null) stmt.close();
		    if (conn != null) conn.close();
		}
	%>

</body>
</html>
