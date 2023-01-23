<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*" %>
<%@ page import="Controller.Contato"%>

<%
	@ SuppressWarnings ("unchecked")
	ArrayList<Contato> lista = (ArrayList<Contato>)request.getAttribute("contato");
%>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <title>Lista de Contatos</title>
        <meta name="description"  content="Utililizado para listar contatos">
        <meta name="viewport"     content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="Imagens/Agenda.png">
        <link rel="stylesheet"    href="style.css">
    </head>
    
    <body>
		<div class="cabecalho">
            <form action="Home">
                <button id="casaButton"      type="submit"><img id="homeImg"      src="Imagens/Casa.png"></button>
            </form>

            <form action="Adicionar">
                <button id="adicionarButton" type="submit"><img id="adicionarImg" src="Imagens/Adicionar.png"></button>
            </form>
            
            <form action="Listar">
                <button id="listarButton"    type="submit"><img id="listarImg"    src="Imagens/Listar.png"></button>
            </form>
        </div>

        <div class="tabela">
            <table align="center" cellpadding="8">
                <tr align="center" class="t1">
                	<td class="t1">Id</td>
                    <td class="t1">Nome</td>
                    <td class="t1">Telefone</td>
                    <td class="t1">Email</td>
                    <td></td>
                    <td></td>
                </tr>
                
                <%
            	for(int i = 0; i < lista.size(); i++) 
            	{
           		 %>
           		 
                <tr align="center" class="t2">
                	<td class="t2"><%=lista.get(i).getId()%></td>
                    <td class="t2"><%=lista.get(i).getNome()%></td>
                    <td class="t2"><%=lista.get(i).getFone()%></td>
                    <td class="t2"><%=lista.get(i).getEmail()%></td>
                    <td class="t2"><a href="Editar?Id=<%=lista.get(i).getId()%>"><img src="Imagens/Editar.png"></a></td>
                    <td class="t2"><a href="Remover?Id=<%=lista.get(i).getId()%>"><img id="removerImg" src="Imagens/Excluir.png"></a></td>
                </tr>
                <%
            	}
                %>
            </table>
        </div>
    </body>
</html>