//Carrega o tbody na página
const tbody = document.querySelector('tbody');
//Carrega o tfoot na página
const tfoot = document.querySelector('tfoot');
//Carrega ID da com informações do rodape da tabela
var dataatualizada = document.querySelector('#dataatualizada')

// Função para atualizar variavel com data e hora atual do sistema
function CheckDateTime(){
    //data e hora do sistema
    var currentdate = new Date();
    var datetime = currentdate.getDay() + "/" + currentdate.getMonth() 
    + "/" + currentdate.getFullYear() + " " 
    + currentdate.getHours() + ":" 
    + currentdate.getMinutes() + ":" + currentdate.getSeconds();
    console.log(datetime);
    console.log(tfoot);
    console.log(dataatualizada)
    return datetime
}

//recuperar o form
document.querySelector('form').addEventListener('submit', function(e){
    //cancele o evento padrão
    e.preventDefault();

    //recuperar os campos
    const campos = [
        document.querySelector('#data'),
        document.querySelector('#tipo'),
        document.querySelector('#descricao'),
        document.querySelector('#categoria'),
        document.querySelector('#valor'),
        document.querySelector('#comentario')
    ]

    //criar uma tr 
    const tr = document.createElement('tr');

    // criar um for para percorrer os campos no array e para cada ocorrência, executar função
    campos.forEach(campo => {

        // criar a td 
        const td = document.createElement('td');

        //passar o conteúdo para a td
        td.textContent = campo.value;

        //colocar a td na tr
        tr.appendChild(td);
       
    });

    // colocando a tr dentro do tbody
    tbody.appendChild(tr);

    // Atualiza rodape da tabela com DATA DA ATUALIZACAO
    dataatualizada.innerHTML = "Última atualização: "+(CheckDateTime());
    
    //limpar o form
    this.reset();
})
// console.log(tfoot);
console.log(dataatualizada)

