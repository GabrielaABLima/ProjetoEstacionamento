<%-- 
    Document   : index
    Created on : 11 de nov. de 2022, 19:57:12
    Author     : Gabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--CSS-->
        <link rel="stylesheet" href="src/styles/home.css" />
        <!--FONTES-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600;800&display=swap" rel="stylesheet">
        <title>Sistema Estacionamento</title>
        <script src="./src/js/jquery/jquery.min.js"></script>
        <script src="./src/js/menu.js"></script>
    </head>
    <body onload="carregarMenu(event)">
        <input name="user" id="user" type="hidden" value="noUser"/>
        <input name="ativo" id="ativo" type="hidden" value="0"/>
        <header id="menu">          
        </header>
        <main>
            <div id="containerTexto">
                <div id="divHome">
                    <h3>RESERVE SUA</h3>
                    <h1>VAGA<spam>.</spam></h1>
                    <p>Não perca tempo procurando uma vaga para estacionar, reserve a sua de maneira remota!</p>
                    <p>É simples: basta cadastrar seus dados, selecionar a vaga de seu interesse e reservar. Pronto!</p> 
                    <p>Faça seu cadastro já</p>
                    <div id="container-botao">
                        <a href="./src/pages/cadastrar.jsp" <button id="botaoCadastrar"> Cadastrar </button></a>
                        <a id="link" href="./src/pages/login.jsp">Já possuo uma conta</a>
                    </div>
                </div>
            </div>
            <div>
                <img id="img" src="./src/images/Parking-amico.svg" alt="" />
            </div>
            
        </main>
    </body>
</html>
