
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
        <script src="../js/reservas.js"></script>
    </head>
    <body onload="carregarMenu(event); listarReservas(event)">
        <input name="ativo" id="ativo" type="hidden" value="4"/>
        <header id="menu">          
        </header>
        <main>
            <div id="containerTexto">
                
                <div id="divHome">
                
                    <table id="form">
                        
                        <div id="divForm">
                            <h2>SUAS</h2>
                            <h3>RESERVAS<spam>.</spam></h3>
                            
                            <thead>
                                
                                <th>Cliente</th>
                                <th>Estacionamento</th>
                                <th>Data</th>
                                <th colspan="2">Ações</th>
                            </thead>
                            <tbody id="tabelaConteudo">
                                                         
                            </tbody>
                            
                        </div>
                        
                    </table>
                    <div id="container-botao-novo">
                        
                        <button style="cursor: pointer; height: 5vh; width:15vh;"  id="criarReserva" onclick="abrirModal(event)">Adicionar</button>
                    </div>
                    
                    
                </div>
            </div>
            <div>
                <img style=" height: 100vh; width: 100vh;" src="../images/Order ride-amico.svg" alt="" />
            </div>
            
            <div class="modal">
                
                <button style="cursor: pointer; border: none; outline: none;" onclick="fecharModal(event)"><i <i class="fa-solid fa-xmark"></i></i></button>
                <div class="content">
                    
                    <h2 style="padding-bottom: 8px;">Nova Reserva</h2>
                    <form id="formModal">
                        <input
                            type="text"
                            class="item_form"
                            id="cliente"
                            name="cliente"
                            placeholder="Nome"
                          />
                        <input
                            type="text"
                            class="item_form"
                            id="estacionamento"
                            name="estacionamento"
                            placeholder="Estacionamento"
                          />
                        <input
                            type="text"
                            class="item_form"
                            id="data"
                            name="data"
                            placeholder="Data da Reserva"
                          />
                        
                    </form>
                        <button style="cursor: pointer; height: 7vh; width:18vh; padding-top: 2vh; margin-left: 10px;"  id="criarReserva" onclick="cadastrarReserva(event)">Adicionar</button>
                </div>
                
            </div>
            
            <div class="modalEdit">
                
                <button style="cursor: pointer; border: none; outline: none;" onclick="fecharModalEdit(event)"><i <i class="fa-solid fa-xmark"></i></i></button>
                <div class="content">
                    
                    <h2 style="padding-bottom: 8px;">Editar Reserva</h2>
                    <form id="formModal">
                        <input
                            type="text"
                            class="item_form"
                            id="clienteEdit"
                            name="clienteEdit"
                            placeholder="Nome"
                          />
                        <input
                            type="text"
                            class="item_form"
                            id="estacionamentoEdit"
                            name="estacionamentoEdit"
                            placeholder="Estacionamento"
                          />
                        <input
                            type="text"
                            class="item_form"
                            id="dataEdit"
                            name="dataEdit"
                            placeholder="Data da Reserva"
                          />
                        
                    </form>
                        <button style="cursor: pointer; height: 7vh; width:18vh; padding-top: 2vh; margin-left: 10px;"  id="editarReserva">Salvar</button>
                </div>
                
            </div>
            
        </main>
    </body>
</html>
