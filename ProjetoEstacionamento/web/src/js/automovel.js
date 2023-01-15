function listarAutomovel(event){
    let listar = "listar";
    let idCliente = localStorage.getItem('userCliente');
    console.log("entrou funcao");
    $.ajax( "../../automovel", {
        data: {
            acao: listar,
            idCliente: idCliente
        },
        datatype: "text"
    }).done( ( data ) =>{

        // data já contém o objeto resultado do parse
        // do json retornado. isso é automático.
        console.log(data);
        let linhaTabela = $( "#tabelaConteudo" );
        linhaTabela.html( "" );

        data.forEach(automovel => {
            linhaTabela.append(`<tr class="dadoLinha">`);
            let linha1 = $('<td class="dadoTabela"></td>')
                    .html( `${automovel.placa}` );
            let linha2 = $('<td class="dadoTabela"></td>');
            console.log(automovel.estacionado);
            if(automovel.estacionado){
                    linha2.html( `Estacionado` );
            }else{
                    linha2.html( `Não estacionado` );
            }
            

            let linha3 = $('<td class="dadoTabela"></td>')
                    .html( `${automovel.tipo}` );

            let linha5 = $('<td class="dadoTabela" colspan="2"></td>')
                    .html(`<a href="#" onclick="excluirCarro('${automovel.id}');"><i class="fa-solid fa-trash"></i></a>
                           <a href="#" onclick="editarCarro('${automovel.id}');"><i class="fa-solid fa-pen-to-square"></i></a>`);
           
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
    let botao = document.getElementById("editarAutomovel").setAttribute("onclick", `editCarro(${id})`);
}

function fecharModalEdit(event){
    const modal = document.querySelector(".modalEdit");
    modal.style.display = 'none';
}

function editCarro(idA){
    console.log(idA);
    let placa = document.getElementById("placaEdit").value;
    let estacionado = document.getElementById("estacionadoEdit").value;
    let tipo = document.getElementById("tipoEdit").value;
    
    let idCliente = localStorage.getItem('userCliente');
    let id = idA - 0;
    console.log(id);
    let atualizar = "atualizar";
    
    if(estacionado === 1){
        estacionado = true;
    }else{
        estacionado = false;
    }
    
    $.ajax("../../automovel",{
        data: {
            acao: atualizar,
            id: id,
            placa: placa,
            tipo: tipo,
            estacionado: estacionado,
            idCliente: idCliente
            
        }, datatype: "text"
    }).done(response=>{
        console.log("dados atualizados");
        
    }).fail( ( jqXHR, textStatus, errorThrown ) => {
        alert( "Erro: " + errorThrown + "\n" +
        "Status: " + textStatus );
     });
     
     document.location.reload(true);
}

function cadastrarCarro(event){
    let placa = document.getElementById("placa").value;
    let estacionado = document.getElementById("estacionado").value;
    let tipo = document.getElementById("tipo").value;
    let idCliente = localStorage.getItem('userCliente');
    let inserir = "inserir";
    if(estacionado === 1){
        estacionado = true;
    }else{
        estacionado = false;
    }
    
    console.log(placa);
    console.log(estacionado);
    console.log(tipo);
    
    
    $.ajax("../../automovel",{
        
        data: {
            acao: inserir,
            placa: placa,
            estacionado: estacionado,
            tipo: tipo,
            idCliente: idCliente
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

function excluirCarro(id){
    let deletar = "deletar";

    
    
    $.ajax("../../automovel",{
        
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

function editarCarro(id){
    let preparar = "preparar";
    $.ajax("../../automovel",{
        
        data: {
            acao: preparar,
            id: id
        },
        datatype: "text"
    }).done(automovel => {
        abrirModalEdit(event, id);
        console.log(automovel.id);
        document.getElementById("placaEdit").value = automovel.placa;
        
        
    }).fail( ( jqXHR, textStatus, errorThrown ) => {
        alert( "Erro: " + errorThrown + "\n" +
        "Status: " + textStatus );
     });

}