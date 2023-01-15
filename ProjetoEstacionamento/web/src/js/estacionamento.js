/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function listarEstacionamento(event){
    let listar = "listar";
    console.log("entrou funcao");
    $.ajax( "../../estacionamento", {
        data: {
            acao: listar
        },
        datatype: "text"
    }).done( ( data ) =>{
        console.log(data);
        let linhaTabela = $( "#tabelaConteudo" );
        linhaTabela.html( "" );

        data.forEach(estacionamento => {
            linhaTabela.append(`<tr class="dadoLinha">`);
            let linha1 = $('<td class="dadoTabela"></td>')
                    .html( `${estacionamento.nome}` );
            let linha2 = $('<td class="dadoTabela"></td>').html(`${estacionamento.endereco}`);

            let linha3 = $('<td class="dadoTabela"></td>')
                    .html( `${estacionamento.cnpj}` );
            let linha4 = $('<td class="dadoTabela"></td>')
                    .html( `${estacionamento.vagas}` );
            
            let linha5 = $('<td class="dadoTabela" colspan="2"></td>')
                    .html(`<a href="#" onclick="excluirEstacionamento('${estacionamento.id}');"><i class="fa-solid fa-trash"></i></a>
                           <a href="#" onclick="editarEstacionamento('${estacionamento.id}');"><i class="fa-solid fa-pen-to-square"></i></a>`);
            
           linhaTabela.append(linha1);
           linhaTabela.append(linha2);
           linhaTabela.append(linha3);
           linhaTabela.append(linha4);
           linhaTabela.append(linha5);
           
           linhaTabela.append('</tr>');

        });
    }).fail( ( jqXHR, textStatus, errorThrown ) => {
        alert( "Erro: " + errorThrown + "\n" +
        "Status: " + textStatus );
     });
}

function abrirModal(event){
    const modal = document.querySelector(".modal");
    modal.style.display = 'block';
}

function fecharModal(event){
    const modal = document.querySelector(".modal");
    modal.style.display = 'none';
}

function abrirModalEdit(event, id){
    const modal = document.querySelector(".modalEdit");
    modal.style.display = 'block';
    let botao = document.getElementById("editarEstacionamento").setAttribute("onclick", `editEstacionamento(${id})`);
}

function fecharModalEdit(event){
    const modal = document.querySelector(".modalEdit");
    modal.style.display = 'none';
}

function cadastrarEstacionamento(event){
    let nome = document.getElementById("nome").value;
    let endereco = document.getElementById("endereco").value;
    let cnpj = document.getElementById("cnpj").value;
    let vagas = document.getElementById("vagas").value;

    let inserir = "inserir";
    
    
    $.ajax("../../estacionamento",{
        
        data: {
            acao: inserir,
            nome: nome,
            endereco: endereco,
            cnpj: cnpj,
            vagas: vagas

        },
        datatype: "text"
        
    }).done(response => {
        
        console.log("Dados inseridos no banco de dados");
    }).fail( ( jqXHR, textStatus, errorThrown ) => {
        alert( "Erro: " + errorThrown + "\n" +
        "Status: " + textStatus );
     });
     
     document.location.reload(true);
}


function editEstacionamento(id){
    let nome = document.getElementById("nomeEdit").value;
    let endereco = document.getElementById("enderecoEdit").value;
    let cnpj = document.getElementById("cnpjEdit").value;
    let vagas = document.getElementById("vagasEdit").value;
    
    let atualizar = "atualizar";
    
    
    $.ajax("../../estacionamento",{
        
        data: {
            acao: atualizar,
            nome: nome,
            endereco: endereco,
            cnpj: cnpj,
            vagas: vagas,
            id: id

        },
        datatype: "text"
        
    }).done(response => {
        
        console.log("Dados atualizados no banco de dados");
    }).fail( ( jqXHR, textStatus, errorThrown ) => {
        alert( "Erro: " + errorThrown + "\n" +
        "Status: " + textStatus );
     });
     
     document.location.reload(true);
}

function excluirEstacionamento(id){
    let deletar = "deletar";

    $.ajax("../../estacionamento",{
        
        data: {
            acao: deletar,
            id: id
        },
        datatype: "text"
    }).done(response => {
        
        console.log("Dados excluídos do banco de dados");
    }).fail( ( jqXHR, textStatus, errorThrown ) => {
        alert( "Erro: " + errorThrown + "\n" +
        "Status: " + textStatus );
     });
     
     document.location.reload(true);
}

function editarEstacionamento(id){
    let preparar = "preparar";
    console.log(id);
    
    $.ajax("../../estacionamento",{
        
        data: {
            acao: preparar,
            id: id
        },
        datatype: "text"
    }).done(estacionamento => {
        abrirModalEdit(event, id);
        document.getElementById("nomeEdit").value = estacionamento.nome;
        document.getElementById("enderecoEdit").value = estacionamento.endereco;
        document.getElementById("cnpjEdit").value = estacionamento.cnpj;
        document.getElementById("vagasEdit").value = estacionamento.vagas;
        
    }).fail( ( jqXHR, textStatus, errorThrown ) => {
        alert( "Erro: " + errorThrown + "\n" +
        "Status: " + textStatus );
     });
     
}