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
        <link rel="stylesheet" href="../styles/home.css" />
        <link rel="stylesheet" href="../styles/login.css" />
        <!--FONTES-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600;800&display=swap" rel="stylesheet">
        <title>Sistema Estacionamento</title>
    <script src="../js/jquery/jquery.min.js"></script>
    <script src="../js/cadastrar.js"></script>
    <script src="../js/menu.js"></script>
    </head>
    <body onload="carregarMenu(event)">
        <input name="ativo" id="ativo" type="hidden" value="2"/>
        <header id="menu">          
        </header>
        <main>
            <div id="containerTexto">
                <div id="divHome">
                    <form id="form">
                        <div id="divForm">
                            <h2>CRIE SUA NOVA</h2>
                            <h3>CONTA<spam>.</spam></h3>
                            <input
                            type="text"
                            class="form-control"
                            id="nome"
                            name="nome"
                            placeholder="Nome"
                          />
                            <input
                            type="text"
                            class="form-control"
                            id="email"
                            name="email"
                            placeholder="E-mail"
                            />
                            <input
                            type="text"
                            class="form-control"
                            id="cartaMotorista"
                            name="cartaMotorista"
                            placeholder="N?? Registro Carteira de Habilita????o"
                            />
                          <input
                            type="password"
                            class="form-control"
                            id="password"
                            name="password"
                            placeholder="Senha"
                          />
                        </div>
                    </form>
                    <div id="container-botao">
                        <button style="cursor: pointer;" id="botaoCadastrar" type="button" onclick="cadastrar(event)">Cadastrar</button>
                        <a href="login.jsp">J?? possuo conta</a>
                    </div>
                </div>
            </div>
            <div>
                <img id="img" src="../images/Parking-amico.svg" alt="" />
            </div>
            
        </main>
    </body>
</html>
