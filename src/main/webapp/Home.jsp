<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <title>Agenda</title>
        <meta name="viewport"     content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="Imagens/Agenda.png">
        <link rel="stylesheet"    type="text/css" href="style.css">
    </head>
    <body>
        <div class="cabecalho">
            <form action="Home">
                <button id="casaButton"       type="submit"><img id="homeImg"      src="Imagens/Casa.png"></button>
            </form>

            <form action="Adicionar">
                <button id="adicionarButton"  type="submit"><img id="adicionarImg" src="Imagens/Adicionar.png"></button>
            </form>
            
            <form action="Listar">
                <button id="listarButton"     type="submit"><img id="listarImg"    src="Imagens/Listar.png"></button>
            </form>
        </div>
    </body>
</html>
