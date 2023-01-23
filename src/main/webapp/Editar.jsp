<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <title>Editar Contato</title>
        <meta name="description" content="Utilizado para adicionar contatos">
        <meta name="viewport"    content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="Imagens/Agenda.png">
        <link rel="stylesheet"   href="style.css">
    </head>
    <body>
		<div class="cabecalho">
            <form action="Home">
                <button id="casaButton" type="submit"><img id="homeImg" src="Imagens/Casa.png"></button>
            </form>

            <form action="Adicionar">
                <button id="adicionarButton" type="submit"><img id="adicionarImg" src="Imagens/Adicionar.png"></button>
            </form>
            
            <form action="Listar">
                <button id="listarButton"    type="submit"><img id="listarImg"    src="Imagens/Listar.png"></button>
            </form>
        </div>   
        <div id="AdicionarPane">
            <form action="Edita" method="get">
            	<input type="hidden"   name="Id"     value="<%out.print(request.getAttribute("Id"));%>">
                <input id="Caixa1"     type="text"   name="Nome"     placeholder="Nome"     value="<%out.print(request.getAttribute("Nome"));%>"><br><br>
                <input id="Caixa2"     type="text"   name="Telefone" placeholder="Telefone" value="<%out.print(request.getAttribute("Telefone"));%>"><br><br>
                <input id="Caixa1"     type="text"   name="Email"    placeholder="Email"    value="<%out.print(request.getAttribute("Email"));%>"><br><br>   
                <input class="Botao2"  type="submit" value="Editar">
            </form>
        </div>
        
    </body>
</html>