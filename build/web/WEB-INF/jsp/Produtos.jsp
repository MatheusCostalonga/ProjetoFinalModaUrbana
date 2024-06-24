<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Importa biblioteca para utilizar na pagina jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- Definir a moeda atraves da localização -->
<fmt:setLocale value="pt_BR" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./styles/header.css">
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
                <c:set var="admin" value="${usuario.id_usuario}"/>
                <c:choose>
                    <c:when test="${admin == 1}">
                <div class="buttonADMIN">   
                    <li id="buttonUsuarioAdmin" class="nav-item dropdown">
                        <a id="TextUserAdmin" class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="fa-solid fa-user-tie"></i>
                            ADMIN
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="./cadastrar-produto">Cadastrar Produto</a></li>
                            <li><a class="dropdown-item" href="./pedidosAdm">Pedidos dos Clientes</a></li> 
                        </ul>
                    </li>
                </div>
            </c:when>
            <c:otherwise>
    
            </c:otherwise> 
                    </c:choose>
    
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
                            <li><a class="dropdown-item" href="./pedidosCliente">Pedidos</a></li> 
      
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
                                            <c:forEach items="${somaProdutos}" var="somaProduto">
                                          <!--      <p class="card-text">valor total: R$${somaProduto.totalProdutos}</p>-->
                                               </c:forEach>
                                            <p class="card-text">Tamanho: ${carrinho.tamanho}</p>
                                        </div>
                                    </c:forEach>
    
                                </div>
                            </div>
    
                            <div id="TotalCarrinho">
                                <!-- Luan me passou e explicou o codigo -->
                                <c:forEach items="${totalCarrinho}" var="totalCarrinhos">
                                    <div class="content">
                                        <h2 class="text">Valor Total do Carrinho:</h2>
                                        <p class="text" id="text">R$ ${totalCarrinhos.total}</p>
                                    </div>
                                </c:forEach>                   
                            </div>
                            <div id="buttonCarrinho">
                                <a href="./checkoutController">      
                                    <input type="button" value="Comprar">
    
                                </a>
                            </div>
    
                        </div>
                    </div>
    
                </div>
            </div> 
    
        </header>
    </body>
</html>
