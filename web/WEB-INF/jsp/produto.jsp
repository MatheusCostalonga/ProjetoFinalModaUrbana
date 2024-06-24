<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.bean.ProdutoDTO" %>
<%@ page import="model.DAO.ProdutosDAO" %>
<!-- Importa biblioteca para utilizar na pagina jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- Definir a moeda atraves da localização -->
<fmt:setLocale value="pt_BR" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produto Unico</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="./styles/produtoSelecionado.css">
        <link rel="stylesheet" href="./styles/header.css">

            <script src="sweetalert2.min.js"></script>
            <link rel="stylesheet" href="sweetalert2.min.css">
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
                            Bem Vindo <br> ${usuario.nome}
                        </a>  
    
                        <ul class="dropdown-menu">
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
                <div>
                    <b><a class="open-btn" href="./menu"><i id="iconeCategoria" class="fa-solid fa-bars menu"></i>  Todas as Categorias</i></a></b>
                </div>
                <b> <a href="">Jaqueta</a></b>
                <div>
                    <b> <a href="">Camisa</a></b>
                </div>
                <div>
                    <b> <a href="">Camiseta</a></b>
                </div>
                <div>
                     <b> <a href="">Calça</a></b>
                </div>
                <div>
                    <b> <a href="">Bermuda </a></b>
                </div>
            </div>                      
<form action="enviarItemCarrinho" method="post" enctype="multipart/form-data">

                <c:forEach items="${produtos}" var="produto">
                <div id="${produto.idProduto}" class="produto">
                    <div class="imagemProduto">
                    <h5 id="tituloProduto">${produto.nome_produto}</h5>
                    <img src="${produto.imagem}"  alt="...">
                </div>
                    <div class="InformProduto">
                        <p id="descricaoProduto" >Descrição: ${produto.descricao}</p>
                        <span id="TextQuantidade" for="quantidade">Quantidade:</span>
                        <input type="number" min="1" name="quantidade" id="quantidade">
                        <!-- <input type="number" id="quantidade" name="quantidade"> -->
                        <span id="TextTamanho" >Tamanho:</span>
                        <select class="form-control" name="tamanho_id" id="tamanho_id">
                        <option selected>Selecione o tamanho</option>
                        <option value="1">GG</option>
                        <option value="2">G</option>
                        <option value="3">M</option>
                        <option value="4">P</option>
                        </select>
                        <p id="valorProduto">Preço: <fmt:formatNumber value="${produto.valor}" type="currency"/></p>

            <input type="hidden" name="idProduto" id="idProduto" value="${produto.idProduto}">
            <input type="hidden" name="categoriaId" id="categoriaId" value="${produto.categoriaId}">
            <input type="hidden" name="descricao" id="descricao" value="${produto.descricao}">
            <input type="hidden" name="nome_produto" id="nome_produto" value="${produto.nome_produto}">
            <input type="hidden" name="valor" id="valor" value="${produto.valor}">
            <input type="hidden" name="imagem" id="imagem" value="${produto.imagem}">
            <input type="hidden" name="id_usuario" id="id_usuario" value="${usuario.id_usuario}">
            
   <button type="submit" class="btn btn-comprar" id="comprar">
                        <i class="fa-solid fa-basket-shopping"></i> Adicionar ao carrinho
                    </button>
        
   
                      
                    </div>
                  </div>
            </c:forEach>
    </form>
       

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
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://kit.fontawesome.com/187b9a1422.js" crossorigin="anonymous"></script>
    <script src="./js/carrinho.js"></script>
    <script src="./js/notificacoes.js"></script> 

    </html>
