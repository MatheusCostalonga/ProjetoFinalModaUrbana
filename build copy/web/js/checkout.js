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
 document.getElementById("Pagamentos").addEventListener("submit", function(event) {
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


    function excluirItemCarrinho(idCarrinho, quantidadeCarrinho, produtoId3) {
    if (confirm("Tem certeza que deseja excluir este item do carrinho?")) {
        fetch('ExcluirItemCarrinho', {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            body: `idCarrinho=${idCarrinho}&quantidadeCarrinho=${quantidadeCarrinho}&idProduto=${produtoId3}`
        })
    }
}
    var numeroCartaoInput = document.getElementById('numero_cartao');

    // Adiciona um listener para o evento 'input'
    numeroCartaoInput.addEventListener('input', function() {
        // Remove todos os caracteres que não são dígitos
        var numeroCartao = this.value.replace(/\D/g, '');

        // Limita o número de caracteres entre 13 e 19
        if (numeroCartao.length > 19) {
            numeroCartao = numeroCartao.slice(0, 19);
        }

        // Atualiza o valor do campo de entrada com os dígitos formatados
        this.value = numeroCartao;
    });
// Seleciona o elemento input
let inputNumeroCartao = document.getElementById("numeroCartaoDebito");

// Adiciona um listener para o evento input
inputNumeroCartao.addEventListener('input', function() {
    // Remove letras, mantendo apenas números
    this.value = this.value.replace(/[^\d]/g, '');
});
document.addEventListener('DOMContentLoaded', function() {
    let numeroCartaoDebito = document.getElementById('numeroCartaoDebito');

    numeroCartaoDebito.addEventListener('input', function(e) {
        // Remove todos os espaços
        let value = e.target.value.replace(/\s+/g, ''); 
        // Adiciona espaço a cada 4 dígitos
        e.target.value = value.replace(/(\d{4})(?=\d)/g, '$1 '); 
    });
});
    // Seleciona o elemento input para o número do cartão de crédito
    let numeroCartaoCreditoInput = document.getElementById('numero_cartao');

    // Adiciona um listener para o evento 'input'
    numeroCartaoCreditoInput.addEventListener('input', function() {
        // Remove todos os caracteres que não são dígitos
        let numeroCartao = this.value.replace(/\D/g, '');

        // Limita o número de caracteres entre 16
        if (numeroCartao.length > 16) {
            numeroCartao = numeroCartaoCredito.slice(0, 16);
        }

        // Formata o número com espaços a cada 4 dígitos
        let CartaoCretito = '';
        for (let i = 0; i < numeroCartaoCredito.length; i++) {
            if (i > 0 && i % 4 === 0) {
                CartaoCretito += ' ';
            }
            CartaoCretito += numeroCartaoCredito[i];
        }

        // Atualiza o valor do campo de entrada com os dígitos formatados
        this.value = CartaoCretito;
    });
