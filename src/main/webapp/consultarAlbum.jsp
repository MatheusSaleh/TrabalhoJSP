<%@page import="fema3bccJsp.Album"%>
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
	Tela de consulta de album
	<%
    List<Album> albuns = (List<Album>) request.getAttribute("albuns");
    if (albuns != null && !albuns.isEmpty()) { 
        for (Album a : albuns) { %>
            <table border="1">
                <tr>
                    <td><%= a.getCodigo() %></td>
                    <td><%= a.getNome() %></td>
                    <td>
                        <form action="/fema3bccJsp/AlbumControlador">
                            <input type="submit" value="Excluir" onclick="return confirm('Confirma a exclusao?')">
                            <input type="hidden" name="operacao" value="Excluir">
                            <input type="hidden" name="codigoAlbum" value="<%= a.getCodigo() %>">
                        </form>
                    </td>
                </tr>
            </table>
<%       }
    } else { %>
        <h1>Não existe album cadastrado...</h1>
<%   } %>

</body>
</html>