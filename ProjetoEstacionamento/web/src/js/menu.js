function carregarMenu(event){
    var element = document.getElementById('menu');
    var ativo = document.getElementById('ativo').value;
    console.log(ativo);
    var codigo = `<div class="navbar">`;
    codigo += `<ul>`;
    var opcoes = ['Home', 'Login', 'Cadastrar', 'Estacionamento'];
    var links = ['/ProjetoEstacionamento/index.jsp', '/ProjetoEstacionamento/src/pages/login.jsp',
    '/ProjetoEstacionamento/src/pages/cadastrar.jsp', '/ProjetoEstacionamento/src/pages/estacionamento.jsp'];
    for(var i=0; i<4; i++){ 
        codigo += `<li class="list-item `;
        if(i == ativo){
            codigo += ` active">`;
        }else{
            codigo += `">`;
        }
        
        codigo += `<b class="left-curve"></b>
                   <b class="right-curve"></b>
                   <a href="`;
        codigo += links[i];
        codigo += `">`;
        codigo += opcoes[i];
        codigo += `</a>
                </li>`;
    }
    
    
    if(localStorage.getItem('userCliente')!=='0'){
        codigo +=   `<li class="list-item `;
        if(ativo == 4){
            codigo += ` active">`;
        }else{
            codigo += `">`;
        } 
        codigo += `<b class="left-curve"></b>
                    <b class="right-curve"></b>
                    <a href="/ProjetoEstacionamento/src/pages/reservas.jsp">
                        Reservas
                    </a>
                </li>`;
        
        codigo +=   `<li class="list-item `;
        if(ativo == 5){
            codigo += ` active">`;
        }else{
            codigo += `">`;
        } 
        codigo += `<b class="left-curve"></b>
                    <b class="right-curve"></b>
                    <a href="/ProjetoEstacionamento/src/pages/automoveis.jsp">
                        Automóveis
                    </a>
                </li>`;
        codigo += `<li class="list-item">
                        <b class="left-curve"></b>
                        <b class="right-curve"></b>
                        <a href="#" onclick="logout(event);">
                            Sair
                        </a>
                    </li>`;
    }
    
    codigo += `</ul>`;
    codigo += `</div>`;              
    element.innerHTML = codigo;
    
    
    
}

function logout(event){
    localStorage.setItem('userCliente', "0");
    window.location = "../../../ProjetoEstacionamento/index.jsp";
}

