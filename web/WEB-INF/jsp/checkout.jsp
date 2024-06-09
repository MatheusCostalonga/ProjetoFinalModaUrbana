    <%-- 
    Document   : checkout
    Created on : 21/05/2024, 21:39:24
    Author     : Leandro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./styles/checkout.css">

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="icon" href="favicon.io" type="image/x-icon">
        <title>ecommerce</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/187b9a1422.js" crossorigin="anonymous"></script>

    </head>
    <body>
<header>
     <h1>Check-out</h1>
</header>
        <main>
                        <div id="TodoCheckout">
                        <div id="informacaoCliente">
                           
                            <div class="organizar">
                               <span>Rua:</span>
                               <input type="text" name="rua" required>
                           </div>
                           <div class="organizar">
                            <span>Número:</span>
                            <input type="number" name="numero" required>
                        </div>
                        <div class="organizar">
                            <span>CEP:</span>
                            <input type="text" name="cep" required>
                        </div>
                        <div class="organizar">
                            <span>Complemento:</span>
                            <input type="text" name="complemento" required>
                        </div>
                                      
                                           <div id="finalizacao">
                                           <button>Finalizar Compra</button>
                                           <a href="./menu">Deseja voltar as compras? click aqui</a>
                                       </div>
                                        </div>
                                        <div id="FormasPagamentos">
                                            
                                               
                                          
                                            <div class="organizarCartao">
                                                <img id="imgCartao" src="./assets/FiguraCartaoCredito.png" alt="imagem cartao de credito">
                                                <span>Numero cartao:</span>
                                                <input type="number" name="numero_cartao" required>
                                                <span>data de validade:</span>
                                                <input type="date" name="data-validade" required>
                                                <span>Codigo de segurança:</span>
                                                <input type="number" name="codigo_seguranca" required>
                                                <span for="pagamento">Forma de pagamento:</span>
                                                    <select  id="pagamento" name="pagamento" required>
                                                       <option >Seleciona uma opção</option>
                                                        <option value="1">Pix</option>
                                                        <option value="2">Cartão de Debito</option>
                                                        <option value="3">Cartão de Credito</option>
                                                    </select>
                                                  </div>
                                                
                                        </div>
                                        <div id="TudoSobreProdutos">
                    <h1>Produtos do carrinho</h1>
            <section class="ProdutosCarrinhoCheckout">
        <div id="ProdutosCheckout">
            <div id="ProdutoMainCarrinho">
            <c:forEach items="${carrinhos}" var="carrinho">
                <div class="informacoesProdutosCheckout">
            <img src="${carrinho.imagemCarrinho}" alt="...">
          <div class="infProd">
                <p class="card-title">${carrinho.nomeCarrinho}</p>
            <p class="card-text">Descrição: ${carrinho.descricaoCarrinho}</p>
            </div>
            <div class="infProd">
            <p class="card-text">Tamanho: ${carrinho.tamanho}</p>
              <p class="card-text">Categorias: ${carrinho.nomeCategoria}</p>
            </div>
              <div class="infProd">
              <p  class="card-text">Unidades: ${carrinho.quantidadeCarrinho}</p>
              <p class="card-text">Valor Unidade: R$${carrinho.valorCarrinho}</p>
            </div>
</div>
                          </c:forEach>
</div>
</div>
</section>

<div class="totalProdutosCheckout">
    <c:forEach items="${totalCarrinho}" var="totalCarrinhos">
        <div class="valorTotal">
            <span class="text"> Valor Total: R$ ${totalCarrinhos.total}</span>
        </div>
    </c:forEach>   
</div>
</div>
</div>
                    </main>
<footer>
            <div class="rodape">
            <div class="redesSociais">
            <span>Visite nossas redes sociais</span>
           <span><i class="fa-brands fa-instagram"></i>@modaUrbana</span>
           <span><i class="fa-brands fa-facebook"></i>@modaUrbana</span>
        </div>
        <div class="metodoContato">
            <span>Nosso contato para você fazer seu pedido</span>
            <span><i class="fa-solid fa-phone"></i>(43) 99888-8888</span>
            <span><i class="fa-brands fa-whatsapp"></i>+55 (43) 9999-9999</span>
        </div>
    </div>
        </footer>                                    
    </body>
</html>
