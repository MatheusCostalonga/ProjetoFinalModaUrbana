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
        <img class="imagemLogo" src="./assets/LogoModaUrbana.png" alt="Logo da moda urbana">

        <div class="buttonIcone">
           
        </div>
         <div class="btn-group" role="group">
             <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown"  aria-expanded="false">
      <i class="fa-solid fa-circle-user"></i><span id="textPerfil">Perfil</span>
    </button>
    <ul class="dropdown-menu">
        <li><a class="dropdown-item" href="#"><i id="iconeUsuario" class="fa-solid fa-user"></i>Meu Perfil</a></li>       
      <li><a class="dropdown-item" href="./loginCliente">Login</a></li>
      <li><a class="dropdown-item" href="./CadastroClienteController"><i class="fa-solid fa-user-plus"></i>Cadastrar</a></li>
      <li><a class="dropdown-item" href="./cadastrar-produto"><i class="fa-solid fa-user-plus"></i>ProdutoCAD</a></li>
    </ul>
  </div>
        <div id="campoPesquisa">
        <form class="d-flex" role="search" action="buscar-produtos" method="get">
            <input id="pesquisa" name="busca" class="form-control me-2" type="search" placeholder="Search" aria-label="Search" maxlength="255">
        <button class="btn btn-outline-success" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
      </form>
            </div>

        <div class="main-menu">

            <b><a id="buttonIconeCarrinho" class="open-btn" href="#"><i id="IconeCarrinho" class="fa-solid fa-cart-shopping"></i> Seu Carrinho</a></b>
            <div class="offcanvas-menu">
                <button   class="close-btn" href="#"><i class="fa-solid fa-xmark"></i></button>
                <ul>
                    <li>
                <div id="card">
                    <c:forEach items="${carrinhos}" var="carrinho">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">${carrinho.nomeCarrinho}</h5>
                      <p class="card-text">${carrinho.valorCarrinho}</p>
                      <p class="card-text">${carrinho.imagemCarrinho}</p>
                      <p class="card-text">${carrinho.descricaoCarrinho}</p>
                      <p class="card-text">${carrinho.quantidadeCarrinho}</p>
                      <a href="#" class="btn btn-primary">Comprar</a>
                                  </c:forEach>
                    </div>
                  </div>
</li>

                   </ul>
            </div>
        </div> 

                            <div class="container container-categorias">
                <c:forEach items="${categoria}" var="categorias" >
                    <div class="categoria">
                        <a href="./buscar-produtos?cat=${categorias.id_categoria}&busca=">${categorias.nome}</a>
                    </div>
                </c:forEach>
            </div>
    </header>
    <main>
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
        <c:forEach items="${produtos}" var="produto">
                <div class="card" style="width: 18rem;">
                    <img src="${produto.imagem}" class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">${produto.nome}</h5>
                      <p class="card-text">${produto.descricao}</p>
                      <p class="card-text">${produto.categoriaId}</p>
                      <p class="card-text">${produto.tamanho}</p>
                      <p class="card-text">${produto.valor}</p>
                  <a href="./produtoSelecionado?id=${produto.idProduto}"><input type="submit" value="comprar"></a>
                    </div>
                  </div>
            </c:forEach>

        
    </main>
    <footer>

    </footer>

</body>
<script src="./js/menu.js"></script>
</html>
