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
                    <c:set var="usuarioLogado" value="${usuario.id_usuario}"/>
                    <c:choose>
                        <c:when test="${usuarioLogado == 1}">
                    <div class="buttonADMIN">   
                        <li id="buttonUsuarioAdmin" class="nav-item dropdown">
                            <a id="TextUserAdmin" class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="fa-solid fa-user-tie"></i>
                                ADMIN
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="./cadastrar-produto">Cadastrar produto</a></li>
                                <li><a class="dropdown-item" href="./pedidosAdm">Pedidos dos clientes</a></li> 
                                <li><a class="dropdown-item" href="./CadastroClienteController">Cadastrar clientes</a></li>    
                            </ul>
                        </li>
                    </div>
                </c:when>
                <c:otherwise>
        
                </c:otherwise> 
                        </c:choose>
        
                    <div class="buttonIcone">   
                        <li id="buttonUsuario" class="ajusteBotaoUsuario"> 
                            <a id="TextUser" class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="fa-regular fa-circle-user"></i>
                                Bem Vindo ${usuario.nome}
                            </a>  
                            
        
                            <ul class="dropdown-menu">
                                <c:choose>
                                    <c:when test="${usuarioLogado == 0}">
                                        <li><a class="dropdown-item" href="./loginCliente">Realizar login</a></li>       
                                        <li><a class="dropdown-item" href="./CadastroClienteController">Realizar cadastro</a></li>    
                                    </c:when>
                                    <c:otherwise>
                                   </c:otherwise> 
                                    </c:choose>
                                <li><a class="dropdown-item" href="./pedidosCliente">Meus pedidos</a></li> 
                                <c:choose>
                                    <c:when test="${usuarioLogado >= 1}">
                                            <li><a type="submit" class="dropdown-item" href="./loginCliente">Deslogar</a></li>                     
                                    </c:when>
                                    <c:otherwise>
                                   </c:otherwise> 
                                    </c:choose>
        
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
                                                <input type="text" name="idCarrinho" value="${carrinho.id_carrinho}" style="display: none;">
                                                <h5 class="card-title">${carrinho.nomeCarrinho}</h5>
                                                <p class="card-text" class="quantidade">unit: ${carrinho.quantidadeCarrinho}</p>
                                                <p class="card-text" class="preco">Valor unit:<fmt:formatNumber value="${carrinho.valorCarrinho}" type="currency"/></p>
                                                <c:forEach items="${somaProdutos}" var="somaProduto">
                                              <!--      <p class="card-text">valor total: R$${somaProduto.totalProdutos}</p>-->
                                                   </c:forEach>
                                                <p class="card-text">Tamanho: ${carrinho.tamanho}</p>
                                            </div>
                                        </c:forEach>
        
                                    </div>
                                </div>
        
                                <div id="TotalCarrinho">
                                    <h2 class="text">Valor Total do Carrinho:</h2>
                                    <c:forEach items="${totalCarrinho}" var="totalCarrinhos">
                                        <div class="content">
                                            <p class="text" id="text"><fmt:formatNumber value="${totalCarrinhos.total}" type="currency"/></p>
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
        
            <main>
                <div class="categorias">
        
                <div class="container-categorias">
                                <div>
                        <b><a class="open-btn" href="./menu"><i id="iconeCategoria" class="fa-solid fa-bars menu"></i>  Todas as Categorias</i></a></b>
                    </div>
                <c:forEach items="${categoria}" var="categorias" >
                        <a href="./buscar-produtos?cat=${categorias.id_categoria}&busca=">${categorias.nome_categoria}</a>
                </c:forEach>
            </div> 
                </div>             
    </body>
</html>
