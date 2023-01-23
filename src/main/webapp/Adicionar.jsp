<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <title>Adicionar Contato</title>
        <meta name="description"  content="Utilizado para adicionar contatos">
        <meta name="viewport"     content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="Imagens/Agenda.png">
        <link rel="stylesheet"    href="style.css">
    </head>
    <body>
          <div class="cabecalho">
            <form action="Home">
                <button id="casaButton"       type="submit"><img id="homeImg"       src="Imagens/Casa.png"></button>
            </form>

            <form action="Adicionar">
                <button id="adicionarButton"  type="submit"><img id="adicionarImg"  src="Imagens/Adicionar.png"></button>
            </form>
            
            <form action="Listar">
                <button id="listarButton"     type="submit"><img id="listarImg"     src="Imagens/Listar.png"></button>
            </form>
        </div>
        
        <div id="AdicionarPane">
            <form action="salvarContato">  
            <input id="Caixa1"     type="text"   name="nome"     placeholder="Nome"><br><br>
            <input id="Caixa2"     type="text"   name="telefone" placeholder="Telefone"><br><br>
            <input id="Caixa1"     type="text"   name="email"    placeholder="Email"><br><br> 
	        <input class="Botao1"  type="submit" value="Adicionar">
            </form>
        </div>
        
    </body>
</html>