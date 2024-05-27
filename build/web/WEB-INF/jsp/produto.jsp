<%-- 
    Document   : produto
    Created on : 15/04/2024, 15:51:48
    Author     : Senai
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.bean.ProdutoDTO" %>
<%@ page import="model.DAO.ProdutosDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tela do Produto selecionado</h1>
                <c:forEach items="${produtos}" var="produto">
                <div id="${produto.idProduto}" class="produto">
                    <img src="${produto.imagem}" class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">${produto.nome}</h5>
                      <p class="card-text">${produto.descricao}</p>
                      <p class="card-text">${produto.valor}</p>
                      
                 <span for="quantidade">Quantidade:</span>
                 <input type="number" step="1" class="form-control" id="quantidade" name="quantidade" required>
           

                      <button type="submit" class="btn btn-comprar"  idProduto="${produto.idProduto}" imagem="${produto.imagem}" nome="${produto.nome}" descricao="${produto.descricao}"  valor="${produto.valor}" 
                            quantidade="quantidade" id="comprar">
                        <i class="fa-solid fa-basket-shopping"></i> Comprar
                    </button>
                    </div>
                  </div>
            </c:forEach>
        <%-- Peguei do Luan e ele me explicou o codigo --%>
                <form id="form-comprar" action="enviarItemCarrinho" method="post" enctype="multipart/form-data" style="display: none;">
            <input type="hidden" name="idProduto" id="idProduto">
            <input type="hidden" name="descricao" id="descricao">
            <input type="hidden" name="nome" id="nome">
            <input type="hidden" name="valor" id="valor">
            <input type="hidden" name="imagem" id="imagem">
            <input type="hidden" name="quantidade" id="quantidade">
            
        </form>
    </body>
    <script src="./js/carrinho.js"></script>
</html>
