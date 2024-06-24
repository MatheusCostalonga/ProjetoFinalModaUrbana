//Pega informação do form de pagamento e verifica o radio que esta selecionado
 document.getElementById("Pagamentos").addEventListener("submit", function(event) {
        event.preventDefault();
        // pega a informação que esta marcada como name pagamento
        var metodoPagamento = document.querySelector('input[name="pagamento"]:checked').value;
      
        //caso o metodo de pagamento estiver selecionado em pix então sera mostrado apenas esse metodo de pagamento
        if (metodoPagamento === "pix") {
            document.getElementById("InformPix").style.display = "grid";
            document.getElementById("InformCartaoCredito").style.display = "none";
            document.getElementById("InformCartaoDebito").style.display = "none";
        } else if (metodoPagamento === "cartao_credito") {
        //caso seja o cartão de credito então sera mostrado apenas esse metodo de pagamento
            document.getElementById("InformPix").style.display = "none";
            document.getElementById("InformCartaoCredito").style.display = "grid";
            document.getElementById("InformCartaoDebito").style.display = "none";
        } else if (metodoPagamento === "cartao_debito") {
        //caso seja o cartão de debito então sera mostrado apenas esse metodo de pagamento
            document.getElementById("InformPix").style.display = "none";
            document.getElementById("InformCartaoCredito").style.display = "none";
            document.getElementById("InformCartaoDebito").style.display = "grid";
        }


    });

            var metodoPagamento = document.querySelector('input[name="pagamento"]:checked').value;
            function excluirItemCarrinho(idCarrinho, quantidadeCarrinho, produtoId3) {
                if (confirm("Tem certeza que deseja excluir este item do carrinho?")) {
                    fetch('ExcluirItemCarrinho', {
                        method: 'POST',
                        body: `idCarrinho=${idCarrinho}&quantidadeCarrinho=${quantidadeCarrinho}&idProduto=${produtoId3}`
                    })
                }
            }

document.getElementById("finalizarCompra").addEventListener("submit", function(event) {
    var metodoPagamento = document.querySelector('input[name="pagamento"]:checked').value;

    if (metodoPagamento === "cartao_credito") {
        //Recebe os valores dos input, para a verificação dos campos
        var titularCartao = document.getElementById("titular_cartao").value.trim();
        var numeroCartao = document.getElementById("numero_cartao").value.trim();
        var codigoSeguranca = document.getElementById("codigo_seguranca").value.trim();
        var dataValidade = document.getElementById("data-validade").value.trim();
        
        if (titularCartao === "" || numeroCartao === "" || codigoSeguranca === "" || dataValidade === "") {
            Swal.fire({
                icon: "error",
                title: "Erro!",
                text: "Preencha todos os campos obrigatórios.",
            });
        }
    } else if (metodoPagamento === "cartao_debito"){
        var numeroCartaoDebito = document.getElementById("numeroCartaoDebito").value.trim();
        var dataValidadeDebito = document.getElementById("data-Validade-debito").value.trim();
        var nomeTitularCartaoDebito = document.getElementById("nomeTitularCartaoDebito").value.trim();
        if(numeroCartaoDebito === "" || dataValidadeDebito === "" || nomeTitularCartaoDebito === ""){
            Swal.fire({
                icon: "error",
                title: "Erro!",
                text: "Preencha todos os campos obrigatórios.",
            });
            }
    }
        // Cria um objeto FormData para enviar os dados
        var formData = new FormData();
        formData.append("pagamento", metodoPagamento);
    
        // envia a informação para o servlet adicionado
        fetch("AdicionarItemProdutosPedidos", {
            method: "POST",
            body: formData
        })
});

const CepInput = (event) => {
    let input = event.target; // Pega o que esta no input em que está o onkeyup="CepMascara(event)"
    input.value = CepMascara(input.value); // Aplica a CepMascara ao valor do campo de entrada
}

const CepMascara = (value) => {
    if (!value) return ""; // Retorna uma string vazia se o valor for nulo ou indefinido
    value = value.replace(/\D/g, ""); // Remove todos os caracteres não numéricos
    value = value.replace(/(\d{5})(\d{1,3})$/, "$1-$2"); // Insere o traço após os cinco digitos(numero)
    return value; // Retorna o valor formatado com a máscara de CEP
};


