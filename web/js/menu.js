     document.addEventListener("DOMContentLoaded", function() {
         

      const grade = document.querySelectorAll(".grade");
  
      grade.forEach(grade => {
          const mexerProdutos = grade.querySelector(".horizontal-scroll");
          const mexerEsquerda = grade.querySelector(".mexerEsquerda");
          const mexerDireita = grade.querySelector(".mexerDireita");
  
          // Adiciona um evento quando o botão for clicado
          mexerEsquerda.addEventListener("click", function() {
              mexerProdutos.scrollBy({
                  left: -320,
                  behavior: "smooth"
              });
          });
  
          mexerDireita.addEventListener("click", function() {
              mexerProdutos.scrollBy({
                  left: 320,
                  behavior: "smooth" // Comportamento suave da rolagem
              });
          });
      });

      Swal.fire({
        title: "APROVEITE!",
        text: "Promoção somente agora.",
        imageUrl: "./assets/PopUp.png",
        imageWidth: 400,
        imageHeight: 400,
        imageAlt: "Compre qualquer produto com frete gratis"
      });
  });
  