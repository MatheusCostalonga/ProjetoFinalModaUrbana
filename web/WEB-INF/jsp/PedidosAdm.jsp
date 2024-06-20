<%-- 
    Document   : PedidosAdm
    Created on : 20/06/2024, 01:13:15
    Author     : Leandro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="./styles/checkout.css">
        <link rel="stylesheet" href="./styles/header.css">
        <title>JSP Page</title>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    </head>
    <body>
 <header>
            <div id="gridHeader">
            <!-- <img class="imagemLogo" src="./assets/ModaUrbanaLogoHome.png" alt="Logo da moda urbana"> -->
            <div id="logoHeader"></div>
            <div id="campoPesquisa">
            <form class="d-flex" role="search" action="buscar-produtos" method="get">
               <div id="Juntos">
                <input id="pesquisa" name="busca" class="form-control me-2" type="search" placeholder="Search" aria-label="Search" maxlength="255">
            <button class="btn btn-outline-success" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
        </div>  
        </form>
                </div>
                <div class="buttonADMIN">   
                    <li id="buttonUsuarioAdmin" class="nav-item dropdown">
                        <a id="TextUserAdmin" class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="fa-solid fa-user-tie"></i>
                             ADMIN
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="./cadastrar-produto">Cadastrar Produto</a></li>
                            </ul>
                      </li>
                  </div>
                  
             <div class="buttonIcone">   
                <li id="buttonUsuario" class="nav-item dropdown"> 
            <a id="TextUser" class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                <i class="fa-regular fa-circle-user"></i>
                 perfil
            </a>  
             
    
            <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Meu Perfil</a></li>       
                <li><a class="dropdown-item" href="./loginCliente">Login</a></li>       
                <li><a class="dropdown-item" href="./CadastroClienteController">Cadastrar</a></li>       
    
            </ul>
          </li>
      </div> 
      <div class="main-menu">
    
        <b><a id="buttonIconeCarrinho" class="open-btn" href="#"><i id="IconeCarrinho" class="fa-solid fa-cart-shopping"></i> Seu Carrinho</a></b>
    
        <div class="offcanvas-menu">
            <button   class="close-btn" href="#"><i class="fa-solid fa-chevron-right"></i></button>
    
            <div id="card">
                <div id="HeaderCarrinho">
                    <h1 class="TextCarrinhoHeader">Carrinho</h1>
                </div>
                
                <div id="MainCarrinho">
                <div id="ProdutoMainCarrinho">
                <c:forEach items="${carrinhos}" var="carrinho">
                <img src="${carrinho.imagemCarrinho}" class="card-img-top" alt="...">
                <div class="informacoesProdutosCarrinho">
                  <h5 class="card-title">${carrinho.nomeCarrinho}</h5>
                  <p class="card-text" class="quantidade">unit: ${carrinho.quantidadeCarrinho}</p>
                  <p class="card-text" class="preco">valor unit: R$${carrinho.valorCarrinho}</p>
                  <p class="card-text">Tamanho: ${carrinho.tamanho}</p>
                  </div>
                              </c:forEach>
                
                            </div>
                            </div>
               
                            <div id="TotalCarrinho">
                                <!-- Luan me passou e explicou o codigo -->
                          <c:forEach items="${totalCarrinho}" var="totalCarrinhos">
                        <div class="content">
                            <h2 class="text">Preço Total:</h2>
                            <p class="text" id="text">R$ ${totalCarrinhos.total}</p>
                        </div>
                    </c:forEach>                   
                        </div>
                            <div id="buttonCarrinho">
                         <a href="./checkout">      
                             <input type="button" value="Comprar">
                         </a>
                        </div>
                 
                            </div>
              </div>
    
        </div>
            </div> 
            
        </header>
        <main>
                            <h1 id="TituloProdutoCarrinho">Pedidos:</h1>
            <section class="ProdutosCarrinhoCheckout">
        <div id="ProdutosCheckout">
            <div id="ProdutoMainCarrinho">
            <c:forEach items="${pedidosClientesAdm}" var="pedidosClientesAdm">
                <div class="informacoesProdutosCheckout">
            <img src="${pedidosClientesAdm.imagem_pedidos_produtos}" alt="...">
          <div class="infProd">
                <h5 class="card-title">${pedidosClientesAdm.nome_produtos_pedidos}</h5>
            <p class="card-text">Descrição: ${pedidosClientesAdm.descricao_pedidos_produtos}</p>
            </div>
            <div class="infProd">
            <p class="card-text">Tamanho: ${pedidosClientesAdm.nome_tamanho}</p>
              <p class="card-text">Categorias: ${pedidosClientesAdm.nome_categoria}</p>
            </div>
              <div class="infProd">
              <p  class="card-text">Quantidade: ${pedidosClientesAdm.quantidade_pedidos_produtos}</p>
              <p class="card-text">Preço: R$${pedidosClientesAdm.valor_pedidos_produtos}</p>
            </div>
</div>
                          </c:forEach>
</div>
</div>
</section>
                            </main>
    </body>
</html>
