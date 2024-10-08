<%@page import="fema3bccJsp.Musica"%>
<%@page import="fema3bccJsp.Artista"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta de Musicas</title>
</head>
<body>
	Tela de consulta de Musica
	<%
    List<Musica> musicas = (List<Musica>) request.getAttribute("musicas");
    if (musicas != null && !musicas.isEmpty()) { 
        for (Musica m : musicas) { %>
            <table border="1">
                <tr>
                    <td><%= m.getCodigo() %></td>
                    <td><%= m.getNome() %></td>
                    <td>
                        <form action="/fema3bccJsp/MusicaControlador">
                            <input type="submit" value="Excluir" onclick="return confirm('Confirma a exclusao?')">
                            <input type="hidden" name="operacao" value="Excluir">
                            <input type="hidden" name="codigoMusica" value="<%= m.getCodigo() %>">
                        </form>
                    </td>
                </tr>
            </table>
<%       }
    } else { %>
        <h1>Não existe musica cadastrada...</h1>
<%   } %>

</body>
</html>