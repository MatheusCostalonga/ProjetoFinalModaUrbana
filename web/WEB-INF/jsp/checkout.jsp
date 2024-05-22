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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <c:forEach items="${carrinhos}" var="carrinho">
                    <img src="${carrinho.imagemCarrinho}" class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">${carrinho.nomeCarrinho}</h5>
                      <p class="card-text">${carrinho.valorCarrinho}</p>
                      <p class="card-text">${carrinho.imagemCarrinho}</p>
                      <p class="card-text">${carrinho.descricaoCarrinho}</p>
                      <p class="card-text">${carrinho.quantidadeCarrinho}</p>
                      </div>
                                  </c:forEach>
    </body>
</html>
