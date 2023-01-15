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
        <script src="../js/automovel.js"></script>
    </head>
    <body onload="carregarMenu(event);listarAutomovel(event)">
        <input name="ativo" id="ativo" type="hidden" value="5"/>
        <header id="menu">          
        </header>
        <main>
            <div id="containerTexto">
                
                <div id="divHome">
                
                    <table id="form">
                        
                        <div id="divForm">
                            <h2>BEM-VINDO(A) À SUA</h2>
                            <h3>GARAGEM<spam>.</spam></h3>
                            
                            <thead>
                                
                                <th>Placa</th>
                                <th>Estacionado</th>
                                <th>Tipo</th>
                                <th colspan="2">Ações</th>
                            </thead>
                            <tbody id="tabelaConteudo">
                                                         
                            </tbody>
                            
                        </div>
                        
                    </table>
                    <div id="container-botao-novo">
                        
                        <button style="cursor: pointer; height: 5vh; width:15vh;"  id="criarAutomovel" onclick="abrirModal(event)">Adicionar</button>
                    </div>
                    
                    
                </div>
            </div>
            <div>
                <img style=" height: 100vh; width: 100vh;" src="../images/Parking-pana.svg" alt="" />
            </div>
            
            <div class="modal">
                
                <button style="cursor: pointer; border: none; outline: none;" onclick="fecharModal(event)"><i <i class="fa-solid fa-xmark"></i></i></button>
                <div class="content">
                    
                    <h2 style="padding-bottom: 8px;">Cadastro Automóvel</h2>
                    <form id="formModal">
                        <input
                            type="text"
                            class="item_form"
                            id="placa"
                            name="placa"
                            placeholder="Placa"
                          />
                        <div class="item_form" id="divCheck">
                       
                        <input 
                            type = "checkbox" 
                            class="item_form"
                            id = "estacionado" 
                            name = "estacionado" 
                            value = "1"
                            placeholder="Estacionado"
                        /> 
                        Estacionado
                        <input 
                            type = "checkbox" 
                            class="item_form"
                            id = "estacionado" 
                            name = "estacionado" 
                            value = "0"
                            placeholder="Estacionado"
                        /> 
                        Não Estacionado
                        </div>
                        <select class="item_form" name="tipo" id="tipo" > 
                            <option hidden value="">Tipo</option>
                            <option value="Carro">
                               Carro
                            </option>
                            <option value="Moto">
                               Moto
                            </option>
                            <option value="Caminhao">
                               Caminhão
                            </option>
                            <option value="Onibus">
                               Ônibus
                            </option>
                       </select>
                    </form>
                        <button style="cursor: pointer; height: 7vh; width:18vh; padding-top: 2vh; margin-left: 10px;"  id="criarAutomovel" onclick="cadastrarCarro(event)">Adicionar</button>
                </div>
                
            </div>
            
            <div class="modalEdit">
                
                <button style="cursor: pointer; border: none; outline: none;" onclick="fecharModalEdit(event)"><i <i class="fa-solid fa-xmark"></i></i></button>
                <div class="content">
                    
                    <h2 style="padding-bottom: 8px;">Editar Automóvel</h2>
                    <form id="formModal">
                        <input
                            type="text"
                            class="item_form"
                            id="placaEdit"
                            name="placaEdit"
                            placeholder="Placa"
                          />
                        <div class="item_form" id="divCheck">
                       
                        <input 
                            type = "checkbox" 
                            class="item_form"
                            id = "estacionadoEdit" 
                            name = "estacionadoEdit" 
                            value = "1"
                            placeholder="Estacionado"
                        /> 
                        Estacionado
                        <input 
                            type = "checkbox" 
                            class="item_form"
                            id = "estacionadoEdit" 
                            name = "estacionadoEdit" 
                            value = "0"
                            placeholder="Estacionado"
                        /> 
                        Não Estacionado
                        </div>
                        <select class="item_form" name="tipoEdit" id="tipoEdit" > 
                            <option id="tipoEditar" name="tipoEditar" hidden value="">Tipo</option>
                            <option value="Carro">
                               Carro
                            </option>
                            <option value="Moto">
                               Moto
                            </option>
                            <option value="Caminhao">
                               Caminhão
                            </option>
                            <option value="Onibus">
                               Ônibus
                            </option>
                       </select>
                    </form>
                        <button style="cursor: pointer; height: 7vh; width:18vh; padding-top: 2vh; margin-left: 10px;"  id="editarAutomovel">Salvar</button>
                </div>
                
            </div>
            
        </main>
    </body>
</html>
