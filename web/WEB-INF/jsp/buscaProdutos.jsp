<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
            <link rel="stylesheet" href="./styles/buscaProdutos.css">
            <link rel="stylesheet" href="./styles/header.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
                <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/187b9a1422.js" crossorigin="anonymous"></script>
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
                                            <p class="card-text" class="quantidade">unidades: ${carrinho.quantidadeCarrinho}</p>
                                            <p class="card-text" class="preco">Valor unidades:<fmt:formatNumber value="${carrinho.valorCarrinho}" type="currency"/></p>
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
             <div class="grade">

        <c:forEach var="produto" items="${produtos}">
                        <div class="card" style="width: 18rem;">
  <div class="card-body">
        <img src="${produto.imagem}" class="card-img-top" alt="...">
     <h5 class="card-title">${produto.nome_produto}</h5>
     <p class="card-text">${produto.descricao}</p>
     <p class="card-text">${produto.valor}</p>
     <a  href="./produtoSelecionado?id=${produto.idProduto}"><input id="button-Comprar" type="submit" value="Visualizar"></a>  </div>
</div>
   </c:forEach>
    </div>
    </main>
    </body>
    <script src="./js/categoria.js"></script>
</html>
