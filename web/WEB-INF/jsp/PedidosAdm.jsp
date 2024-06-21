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
                <link rel="stylesheet" href="./styles/Pedidos.css">
        <title>Gestionar Pedidos</title>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
                <script src="https://kit.fontawesome.com/187b9a1422.js" crossorigin="anonymous"></script>

    </head>
    <body>
 <header>
   <a href="./menu"><i class="fa-sharp fa-solid fa-house"></i>
   </a> 
 </header>
        <main>
                            <h1 id="titulo">Pedidos:</h1>
            <section id="todasInformacoes">
        <div id="produtosClientes">
            <c:forEach items="${pedidosClientesAdm}" var="pedidoClienteAdm">
                <div id="informacoesProdutos">
            <img src="${pedidoClienteAdm.imagem}" alt="Imagem do produto escolhido">
          <div class="infProd">
                <h5 class="card-title">${pedidoClienteAdm.nomeProdutos}</h5>
                <p class="infProd">Usuario: ${pedidoClienteAdm.nomeUsuario}</p>
            </div>
            <div class="infProd">
            <p class="card-text">Tamanho: ${pedidoClienteAdm.nomeTamanho}</p>
            <p class="infProd">Telefone: ${pedidoClienteAdm.telefone}</p>
        </div>
        <div class="infProd">
                  <p class="card-text">Categorias: ${pedidoClienteAdm.nomeCategoria}</p>
                  <p class="infProd">Rua: ${pedidoClienteAdm.ruaEndereco}</p>
            </div>
            <div class="infProd">
                <p  class="card-text">Quantidade: ${pedidoClienteAdm.quantidade}</p>
                <p class="infProd">CEP: ${pedidoClienteAdm.cep}</p>
                
            </div>
            <div class="infProd">
                <p class="card-text">Preço: R$${pedidoClienteAdm.valorProduto}</p>
            <p class="infProd">numero: ${pedidoClienteAdm.numeroEndereco}</p>
            </div>

</div>
                          </c:forEach>
</div>
</section>
                            </main>
    </body>
</html>
