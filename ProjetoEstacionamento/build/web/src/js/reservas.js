function listarReservas(event){
    let listar = "listar";
    console.log("entrou funcao");
    $.ajax( "../../reserva", {
        data: {
            acao: listar
        },
        datatype: "text"
    }).done( ( data ) =>{
        console.log(data);
        let linhaTabela = $( "#tabelaConteudo" );
        linhaTabela.html( "" );

        data.forEach(reserva => {
            linhaTabela.append(`<tr class="dadoLinha">`);
            let linha1 = $('<td class="dadoTabela"></td>')
                    .html( `${reserva.cliente}` );
            let linha2 = $('<td class="dadoTabela"></td>').html(`${reserva.estacionamento}`);

            let linha3 = $('<td class="dadoTabela"></td>')
                    .html( `${reserva.data}` );

             let linha5 = $('<td class="dadoTabela" colspan="2"></td>')
                    .html(`<a href="#" onclick="excluirReserva('${reserva.id}');"><i class="fa-solid fa-trash"></i></a>
                           <a href="#" onclick="editarReserva('${reserva.id}');"><i class="fa-solid fa-pen-to-square"></i></a>`);
           linhaTabela.append(linha1);
           linhaTabela.append(linha2);
           linhaTabela.append(linha3);
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
    let botao = document.getElementById("editarReserva").setAttribute("onclick", `editReserva(${id})`);
}

function fecharModalEdit(event){
    const modal = document.querySelector(".modalEdit");
    modal.style.display = 'none';
}

function cadastrarReserva(event){
    let cliente = document.getElementById("cliente").value;
    let estacionamento = document.getElementById("estacionamento").value;
    let data = document.getElementById("data").value;

    let inserir = "inserir";
    
    
    $.ajax("../../reserva",{
        
        data: {
            acao: inserir,
            cliente: cliente,
            estacionamento: estacionamento,
            data: data

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


function editReserva(id){
    let cliente = document.getElementById("clienteEdit").value;
    let estacionamento = document.getElementById("estacionamentoEdit").value;
    let data = document.getElementById("dataEdit").value;
    
    let atualizar = "atualizar";
    
    
    $.ajax("../../reserva",{
        
        data: {
            acao: atualizar,
            cliente: cliente,
            estacionamento: estacionamento,
            data: data,
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

function excluirReserva(id){
    let deletar = "deletar";

    $.ajax("../../reserva",{
        
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

function editarReserva(id){
    let preparar = "preparar";
    console.log(id);
    
    $.ajax("../../reserva",{
        
        data: {
            acao: preparar,
            id: id
        },
        datatype: "text"
    }).done(reserva => {
        abrirModalEdit(event, id);
        document.getElementById("clienteEdit").value = reserva.cliente;
        document.getElementById("estacionamentoEdit").value = reserva.estacionamento;
        document.getElementById("dataEdit").value = reserva.data;
        
    }).fail( ( jqXHR, textStatus, errorThrown ) => {
        alert( "Erro: " + errorThrown + "\n" +
        "Status: " + textStatus );
     });
     
}