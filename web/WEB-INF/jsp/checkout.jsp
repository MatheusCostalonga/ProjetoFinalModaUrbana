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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>checkout</title>
        <link rel="stylesheet" href="./styles/checkout.css">
        <link rel="stylesheet" href="./styles/menu.css">
    </head>
    <body>
        <div id="ProdutosCheckout">
            <div id="ProdutoMainCarrinho">
            <c:forEach items="${carrinhos}" var="carrinho">
            <img src="${carrinho.imagemCarrinho}" class="card-img-top" alt="...">
            <div class="informacoesProdutosCarrinho">
              <h5 class="card-title">${carrinho.nomeCarrinho}</h5>
              <p class="card-text" class="quantidade">Quantidade: ${carrinho.quantidadeCarrinho}</p>
              <p class="card-text">Descrição: ${carrinho.descricaoCarrinho}</p>
              <p class="card-text" class="preco">Preço: R$${carrinho.valorCarrinho}</p>
              <p class="card-text">Tamanho:</p>
              </div>
                          </c:forEach>

<span>Endereço</span>
<input type="text">

                          <span for="pagamento">Forma de pagamento:</span>
                          <div class="form-group">
                              <select class="form-control" id="pagamento" name="pagamento">
                                  <option value="1">Camiseta</option>
                                  <option value="2">Camisa</option>
                                  <option value="3">Calça</option>
                                  <option value="4">Jaqueta</option>
                                  <option value="5">Bermuda</option>
                              </select>
                          </div>
                        </div>
                        </div>
                        <button>Finalizar Compra</button>
                        <a href="./menu">Deseja voltar as compras? click aqui</a>
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
