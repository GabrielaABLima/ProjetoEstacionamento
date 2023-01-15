function cadastrar(event){
    
    console.log("entrou");
    let nome = document.getElementById("nome").value;
    let email = document.getElementById("email").value;
    let cartaMotorista = document.getElementById("cartaMotorista").value;
    let senha = document.getElementById("password").value;
    let inserir = "inserir";
    let idUsuario;
    $.ajax("../../usuario", {
        data: {
            acao: inserir,
            login: email,
            senha: senha
        },
        datatype: "text"
    }).done(usuario => {
        idUsuario = usuario.ID;
        console.log(idUsuario);
        cadastrarCliente(inserir, nome, cartaMotorista, idUsuario);
        
    }).fail( ( jqXHR, textStatus, errorThrown ) => {
        alert( "Erro: " + errorThrown + "\n" +
        "Status: " + textStatus );
     });
}   
function cadastrarCliente(inserir, nome, cartaMotorista, idUsuario){
    
    $.ajax("../../cliente", {
        
        data: {
            acao: inserir,
            nome: nome,
            cartaMotorista: cartaMotorista,
            idUsuario: idUsuario
        },
        datatype: "text"
        
    }).done(response => {
        redirectUserCadastro();
        console.log("Dados cliente inseridos no banco de dados");
    }).fail( ( jqXHR, textStatus, errorThrown ) => {
        alert( "Erro: " + errorThrown + "\n" +
        "Status: " + textStatus );
     });
    
}

function logar(event){
    let email = document.getElementById("usuario").value;
    let senha = document.getElementById("password").value;
    let linha = $( "#logado" );
    linha.html( "" );
    let listar = "listar";
    if(email == "admin"){
        localStorage.setItem('admin', 1);
    }
    $.ajax("../../usuario", {
        data: {
            acao: listar,
            login: email,
            senha: senha
        },
        datatype: "text"
    }).done(cliente => {
        console.log(cliente);
        if(cliente == 0){
            linha.append("Usuário não encontrado");
        }else{
            localStorage.setItem('userCliente', cliente);
            localStorage.setItem('email', email);
            location.href = "../../index.jsp"; 
        }
    }).fail( ( jqXHR, textStatus, errorThrown ) => {
        alert( "Erro: " + errorThrown + "\n" +
        "Status: " + textStatus );
     });
}


function redirectUserCadastro(){
    location.href = "/ProjetoEstacionamento/src/pages/login.jsp";
}