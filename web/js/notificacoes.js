document.addEventListener("DOMContentLoaded", function () {
  // Seleciona o botão pelo id
  var comprarButton = document.getElementById("comprar");

  // Adiciona um event listener para o evento de clique
  comprarButton.addEventListener("click", function () {    
      // Seleciona os campos de quantidade e tamanho dentro do evento
      var quantidade = document.querySelector('input[name="quantidade"]').value;
      var selected = document.querySelector('select[name="tamanho_id"]').value;

      
   //O include é para verificar se o valor de selected esta entre os valores ditados
      if (quantidade === "" || ![1, 2, 3, 4].includes(parseInt(selected))) {
    // Impede o comportamento padrão do formulário
        event.preventDefault();
          Swal.fire({
              icon: "error",
              title: "Preencha todos os campos",
              text: "Adicione ao menos um produto e selecione um tamanho de produto!",
          });
      }
  });
});


