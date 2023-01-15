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
        <!--ÍCONES-->
        <script src="https://kit.fontawesome.com/80598962c0.js" crossorigin="anonymous"></script>
        <!--CSS-->
        <link rel="stylesheet" href="../styles/home.css" />
        <link rel="stylesheet" href="../styles/login.css" />
        <link rel="stylesheet" href="../styles/estilo.css" />
        <!--FONTES-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600;800&display=swap" rel="stylesheet">
        <title>Sistema Estacionamento</title>
        <script src="../js/jquery/jquery.min.js"></script>
        <script src="../js/cadastrar.js"></script>
        <script src="../js/menu.js"></script>
        <script src="../js/estacionamento.js"></script>
    </head>
    <body onload="carregarMenu(event); listarEstacionamento(event)">
        <input name="ativo" id="ativo" type="hidden" value="3"/>
        <header id="menu">          
        </header>
        <main>
            <div id="containerTexto">
                
                <div id="divHome">
                
                    <table id="form">
                        
                        <div id="divForm">
                            <h2>ESTACIONAMENTOS</h2>
                            <h3>DISPONÍVEIS<spam>.</spam></h3>
                            
                            <thead>
                                
                                <th>Nome</th>
                                <th>Endereço</th>
                                <th>CNPJ</th>
                                <th>Vagas</th>
                                <th colspan="2">Ações</th>
                            </thead>
                            <tbody id="tabelaConteudo">
                                                         
                            </tbody>
                            
                        </div>
                        
                    </table>
                    <div id="container-botao-novo">
                        
                        <button style="cursor: pointer; height: 5vh; width:15vh;"  id="criarEstacionamento" onclick="abrirModal(event)">Adicionar</button>
                    </div>
                    
                    
                </div>
            </div>
            <div>
                <img style=" height: 100vh; width: 100vh;" src="../images/estacionamento.svg" alt="" />
            </div>
            
            <div class="modal">
                
                <button style="cursor: pointer; border: none; outline: none;" onclick="fecharModal(event)"><i <i class="fa-solid fa-xmark"></i></i></button>
                <div class="content">
                    
                    <h2 style="padding-bottom: 8px;">Cadastro Estacionamento</h2>
                    <form id="formModal">
                        <input
                            type="text"
                            class="item_form"
                            id="nome"
                            name="nome"
                            placeholder="Nome"
                          />
                        <input
                            type="text"
                            class="item_form"
                            id="endereco"
                            name="endereco"
                            placeholder="Endereço"
                          />
                        <input
                            type="text"
                            class="item_form"
                            id="cnpj"
                            name="cnpj"
                            placeholder="CNPJ"
                          />
                        <input
                            type="number"
                            class="item_form"
                            id="vagas"
                            name="vagas"
                            placeholder="Número de Vagas"
                          />
                        
                    </form>
                        <button style="cursor: pointer; height: 7vh; width:18vh; padding-top: 2vh; margin-left: 10px;"  id="criarEstacionamento" onclick="cadastrarEstacionamento(event)">Adicionar</button>
                </div>
                
            </div>
            
             <div class="modalEdit">
                
                <button style="cursor: pointer; border: none; outline: none;" onclick="fecharModalEdit(event)"><i <i class="fa-solid fa-xmark"></i></i></button>
                <div class="content">
                    
                    <h2 style="padding-bottom: 8px;">Editar Estacionamento</h2>
                    <form id="formModal">
                        <input
                            type="text"
                            class="item_form"
                            id="nomeEdit"
                            name="nomeEdit"
                            placeholder="Nome"
                          />
                        <input
                            type="text"
                            class="item_form"
                            id="enderecoEdit"
                            name="enderecoEdit"
                            placeholder="Endereço"
                          />
                        <input
                            type="text"
                            class="item_form"
                            id="cnpjEdit"
                            name="cnpjEdit"
                            placeholder="CNPJ"
                          />
                        <input
                            type="number"
                            class="item_form"
                            id="vagasEdit"
                            name="vagasEdit"
                            placeholder="Número de Vagas"
                          />
                        
                    </form>
                        <button style="cursor: pointer; height: 7vh; width:18vh; padding-top: 2vh; margin-left: 10px;"  id="editarEstacionamento">Salvar</button>
                </div>
                
            </div>
            
        </main>
    </body>
</html>
