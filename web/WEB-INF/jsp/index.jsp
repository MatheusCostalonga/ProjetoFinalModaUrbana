<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="./styles/menu.css">
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
              <p class="card-text" class="quantidade">Quantidade: ${carrinho.quantidadeCarrinho}</p>
              <p class="card-text">Descrição: ${carrinho.descricaoCarrinho}</p>
              <p class="card-text" class="preco">Preço: R$${carrinho.valorCarrinho}</p>
              <p class="card-text">Tamanho:</p>
              </div>
                          </c:forEach>
            
                        </div>
                        </div>
           
                        <div id="TotalCarrinho">
                            <!-- Luan me passou e explicou o codigo -->
                      <c:forEach items="${totalCarrinho}" var="totalCarrinhos">
                    <div class="content">
                        <h2 class="text">Preço Total:</h2>
                        <p class="preco" id="preco">R$ ${totalCarrinhos.total}</p>
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
        <div class="categorias">
            <div>
                        <b><a class="open-btn" href="#"><i id="iconeCategoria" class="fa-solid fa-bars menu"></i>  Todas as Categorias</i></a></b>
                    </div>
                    <b> <a href="">Jaqueta</a></b>
                        <div>
                            <b> <a href="">Camisa</a></b>
                        </div>
                        <div>
                            <b> <a href="">Camiseta</a></b>
                        </div>
                        <div>
                            <b> <a href="">Calça </a></b>
                        </div>
                        <div>
                            <b> <a href="">Bermuda </a></b>
                        </div>
                    </div> 
    
             <!-- <div class="container-categorias">
                <c:forEach items="${categoria}" var="categorias" >
                    <div class="categoria">
                        <a href="./buscar-produtos?cat=${categorias.id_categoria}&busca=">${categorias.nome}</a>
                    </div>
                </c:forEach>
            </div> -->
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
           
            <h1 class="my-4">Camiseta</h1>
             <div class="grade">
                <button class="scrollLeft"><i class="fa-solid fa-chevron-left"></i></button>
                 <div class="horizontal-scroll">
                    
                <div class="rows">
                    <c:forEach var="camiseta" items="${camisetas}">
                                <div class="card-body">
                                    <div class="imagemProduto">
                                        <img src="${produto.imagem}" class="card-img-top" alt="...">
                                    </div>
                                    <h5 class="card-title">${camiseta.nome}</h5>
                                    <p class="card-text">${camiseta.descricao}</p>
                                    <p class="card-text">${camiseta.valor}</p>
                                    <p class="card-text">${camiseta.categoriaId}</p>
                                    <a  href="./produtoSelecionado?id=${produto.idProduto}"><input id="button-Comprar" type="submit" value="comprar"></a>

                            </div>
                    </c:forEach>
                </div>
                </div>
                <button class="scrollRight"><i class="fa-solid fa-chevron-right"></i></button>

                </div>
                <h1>Outro produto</h1>
                <div class="grade">
                    <button id="scrollLeft"><i class="fa-solid fa-chevron-left"></i></button>
                     <div class="horizontal-scroll">
                        
                    <div class="rows">
                        <c:forEach var="produto" items="${produtos}">
                                    <div class="card-body">
                                        <div class="imagemProduto">
                                            <img src="${produto.imagem}" class="card-img-top" alt="...">
                                        </div>
                                        <h5 class="card-title">${produto.nome}</h5>
                                        <p class="card-text">${produto.descricao}</p>
                                        <p class="card-text">${produto.valor}</p>
                                        <a  href="./produtoSelecionado?id=${produto.idProduto}"><input id="button-Comprar" type="submit" value="comprar"></a>
    
                                </div>
                        </c:forEach>
                    </div>
                    </div>
                    <button id="scrollRight"><i class="fa-solid fa-chevron-right"></i></button>
    
                    </div>
    </main>
    <footer>
    </footer>

</body>
<script src="./js/menu.js"></script>
 <script src="./js/carrinho.js"></script> 
</html>