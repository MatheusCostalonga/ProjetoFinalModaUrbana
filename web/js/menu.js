     document.addEventListener("DOMContentLoaded", function() {
      const grade = document.querySelectorAll(".grade");
  
      grade.forEach(grade => {
          const mexerProdutos = grade.querySelector(".horizontal-scroll");
          const mexerEsquerda = grade.querySelector(".mexerEsquerda");
          const mexerDireita = grade.querySelector(".mexerDireita");
  
          // Adiciona um evento quando o botão for clicado
          mexerEsquerda.addEventListener("click", function() {
              mexerProdutos.scrollBy({
                  left: -300,
                  behavior: "smooth"
              });
          });
  
          mexerDireita.addEventListener("click", function() {
              mexerProdutos.scrollBy({
                  left: 300,
                  behavior: "smooth" // Comportamento suave da rolagem
              });
          });
      });
  });
  