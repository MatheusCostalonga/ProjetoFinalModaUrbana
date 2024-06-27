<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Importa biblioteca para utilizar na pagina jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- Definir a moeda atraves da localização -->
<fmt:setLocale value="pt_BR" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="./styles/menu.css">
        <link rel="stylesheet" href="./styles/header.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>ecommerce</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/187b9a1422.js" crossorigin="anonymous"></script>
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

        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block w-100" src="./assets/Carrousel1.png" alt="Primeiro Slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="./assets/Carrousel2.png" alt="Segundo Slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="./assets/Carrousel3.png" alt="Terceiro Slide">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Anterior</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Próximo</span>
            </a>
        </div>

        <h1 class="my-4">Camisetas</h1> 
        <div class="grade">
            <button class="mexerEsquerda"><i class="fa-solid fa-chevron-left"></i></button> 
            <div class="horizontal-scroll">

                <div class="rows">
                    <c:forEach var="camiseta" items="${camisetas}">
                        <div class="card-body">
                            <div class="imagemProduto">
                                <img src="${camiseta.imagem}" class="card-img-top" alt="...">
                            </div>
                            <h5 class="card-title">${camiseta.nome_produto}</h5>
                            <p class="card-text">${camiseta.descricao}</p>
                            <p><fmt:formatNumber value="${camiseta.valor}" type="currency"/></p>
                            <p class="card-text">${camiseta.nome_categoria}</p>
                            <a  href="./produtoSelecionado?id=${camiseta.idProduto}"><input id="button-Comprar" type="submit" value="Visualizar"></a>

                        </div>
                    </c:forEach>
                </div>
            </div>
            <button class="mexerDireita"><i class="fa-solid fa-chevron-right"></i></button> 

        </div> 
        <h1>Camisas polo</h1> 
        <div class="grade">
            <button class="mexerEsquerda"><i class="fa-solid fa-chevron-left"></i></button> 
            <div class="horizontal-scroll">

                <div class="rows">
                    <c:forEach var="camisas" items="${camisa}">
                        <div class="card-body">
                            <div class="imagemProduto">
                                <img src="${camisas.imagem}" class="card-img-top" alt="...">
                            </div>
                            <h5 class="card-title">${camisas.nome_produto}</h5>
                            <p class="card-text">${camisas.descricao}</p>
                            <p><fmt:formatNumber value="${camisas.valor}" type="currency"/></p>
                            <p class="card-text">${camisas.nome_categoria}</p>
                            <a  href="./produtoSelecionado?id=${camisas.idProduto}"><input id="button-Comprar" type="submit" value="Visualizar"></a>

                        </div>
                    </c:forEach>
                </div>
            </div>
            <button class="mexerDireita"><i class="fa-solid fa-chevron-right"></i></button> 
        </div>  
        <h1>Calças</h1>
        <div class="grade">
            <button class="mexerEsquerda"><i class="fa-solid fa-chevron-left"></i></button> 
            <div class="horizontal-scroll">

                <div class="rows">
                    <c:forEach var="calcas" items="${calca}">
                        <div class="card-body">
                            <div class="imagemProduto">
                                <img src="${calcas.imagem}" class="card-img-top" alt="...">
                            </div>
                            <h5 class="card-title">${calcas.nome_produto}</h5>
                            <p class="card-text">${calcas.descricao}</p>
                            <p><fmt:formatNumber value="${calcas.valor}" type="currency"/></p>
                            <p class="card-text">${calcas.nome_categoria}</p>
                            <a  href="./produtoSelecionado?id=${calcas.idProduto}"><input id="button-Comprar" type="submit" value="Visualizar"></a>

                        </div>
                    </c:forEach>
                </div>
            </div>
            <button class="mexerDireita"><i class="fa-solid fa-chevron-right"></i></button> 

        </div> 
        <h1>Jaquetas</h1>
        <div class="grade">
            <button class="mexerEsquerda"><i class="fa-solid fa-chevron-left"></i></button> 
            <div class="horizontal-scroll">

                <div class="rows">
                    <c:forEach var="jaquetas" items="${jaqueta}">
                        <div class="card-body">
                            <div class="imagemProduto">
                                <img src="${jaquetas.imagem}" class="card-img-top" alt="...">
                            </div>
                            <h5 class="card-title">${jaquetas.nome_produto}</h5>
                            <p class="card-text">${jaquetas.descricao}</p>
                            <p><fmt:formatNumber value="${jaquetas.valor}" type="currency"/></p>
                            <p class="card-text">${jaquetas.nome_categoria}</p>
                            <a  href="./produtoSelecionado?id=${jaquetas.idProduto}"><input id="button-Comprar" type="submit" value="Visualizar"></a>

                        </div>
                    </c:forEach>
                </div>
            </div>
            <button class="mexerDireita"><i class="fa-solid fa-chevron-right"></i></button> 

        </div>  
        <h1>Bermudas</h1>
        <div class="grade">
            <button class="mexerEsquerda"><i class="fa-solid fa-chevron-left"></i></button> 
            <div class="horizontal-scroll">

                <div class="rows">
                    <c:forEach var="bermudas" items="${bermuda}">
                        <div class="card-body">
                            <div class="imagemProduto">
                                <img src="${bermudas.imagem}" class="card-img-top" alt="...">
                            </div>
                            <h5 class="card-title">${bermudas.nome_produto}</h5>
                            <p class="card-text">${bermudas.descricao}</p>
                            <p><fmt:formatNumber value="${bermudas.valor}" type="currency"/></p>
                            <p class="card-text">${bermudas.nome_categoria}</p>
                            <a  href="./produtoSelecionado?id=${bermudas.idProduto}"><input id="button-Comprar" type="submit" value="Visualizar"></a>

                        </div>
                    </c:forEach>
                </div>
            </div>
            <button class="mexerDireita"><i class="fa-solid fa-chevron-right"></i></button> 

        </div>    
          <h1>Outro produto</h1>
          
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
<script src="./js/menu.js"></script>
<script src="./js/carrinho.js"></script> 
<script src="./js/notificacoes.js"></script> 

</html>