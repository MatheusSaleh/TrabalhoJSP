<%@page import="fema3bccJsp.Artista"%>
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
	Tela de consulta de artista
	<%
    List<Artista> artistas = (List<Artista>) request.getAttribute("artistas");
    if (artistas != null && !artistas.isEmpty()) { // Adicionando verificação para lista vazia
        for (Artista a : artistas) { %>
            <table border="1">
                <tr>
                    <td><%= a.getCodigo() %></td>
                    <td><%= a.getNome() %></td>
                    <td><%= a.getGravadora() %></td>
                    <td>
                        <form action="/fema3bccJsp/ArtistaControlador">
                            <input type="submit" value="Excluir" onclick="return confirm('Confirma a exclusao?')">
                            <input type="hidden" name="operacao" value="Excluir">
                            <input type="hidden" name="codigoArtista" value="<%= a.getCodigo() %>">
                        </form>
                    </td>
                </tr>
            </table>
<%       }
    } else { %>
        <h1>Não existe artista cadastrado...</h1>
<%   } %>

</body>
</html>