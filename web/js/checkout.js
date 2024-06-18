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

//Pega informação do form de pagamento e verifica o radio que esta selecionado
 document.getElementById("formPagamento").addEventListener("submit", function(event) {
        event.preventDefault();
        
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
    
    function excluirItemCarrinho(idCarrinho) {
    if (confirm("Tem certeza que deseja excluir este item do carrinho?")) {
        fetch('ExcluirItemCarrinho', {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            body: `idCarrinho=${idCarrinho}`
        })
        .then(response => {
            if (response.ok) {
                window.location.reload();
            } else {
                alert("Falha ao excluir o item do carrinho");
            }
        })
        .catch(error => {
            console.error("Erro ao excluir o item do carrinho:", error);
        });
    }
}
