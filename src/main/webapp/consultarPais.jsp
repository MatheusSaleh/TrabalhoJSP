<%@page import="fema3bccJsp.Pais"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Tela de consulta de pais
	<%
		List<Pais> paises = (List<Pais>) request.getAttribute("paises");
		if (paises != null){
			for (Pais p : paises){ %>
				<table border="1">
					<tr>
						<td><%= p.getCodigo()  %></td>
						<td><%= p.getNome()  %></td>
						<td><%= p.getSigla()  %></td>
						<td>
							<form action="/fema3bccJsp/PaisControlador">
								<input type="submit" value="Excluir" onclick="return confirm('Confirma a exclusao?')">
								<input type="hidden" name="operacao" value="Excluir">
								<input type="hidden" name="codigoPais" value="<%= p.getCodigo() %>">
							</form>
						</td>
					</tr>
				</table>
	<%		}	
		} else{ %>
			<h1>Não existe pais cadastrado...</h1>
	<%	}  %>
</body>
</html>