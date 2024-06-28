<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Importa biblioteca para utilizar na pagina jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- Definir a moeda atraves da localização -->
<fmt:setLocale value="pt_BR" />
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./styles/checkout.css">
        <link rel="stylesheet" href="./styles/header.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="icon" href="favicon.io" type="image/x-icon">
        <link rel="stylesheet" href="sweetalert2.min.css">
        <title>ecommerce</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/187b9a1422.js" crossorigin="anonymous"></script>

    </head>
    <body>
        
        <main>
            <h2 class="naomexer">Check-out</h2>
                        <div id="TodoCheckout">
                       
                            <form action="modificarEndereco" method="post" enctype="multipart/form-data" >
               <div id="informacaoCliente">
                            <h1>Informações Usuario</h1>
                            <div  id="${usuario.id_usuario}" class="organizar">
                                <span>Nome:</span>
                                <input type="text" name="nome" value="${usuario.nome}" disabled>
                            </div>
                            <div class="organizar">
                                <span>Usuario:</span>
                                <input type="text" name="usuario" value="${usuario.usuario}" disabled>
                            </div>
                            <div class="organizar">
                                <span>CPF:</span>
                                <input type="text" name="cpf" value="${usuario.cpf}" disabled>
                            </div>
                            <div class="organizar">
                                <span>Telefone:</span>
                                <input type="text" name="telefone" value="${usuario.telefone}" disabled>
                            </div>
                            
                            <br><br>
                                    <c:forEach var="enderecosExistente" items="${enderecoExistente}">

                            <h1 id="enderecosExistente.id_endereco">Informações para Entrega</h1>
                            <div class="organizar">
                                <span>Rua:</span>
                            <input  type="text" name="rua" id="rua" value="${enderecosExistente.rua != null ? enderecosExistente.rua : ''}"required >
                        </div>
                    <div class="organizar">
                        <span>Número:</span>
                    <input type="number" name="numero" id="numero" value="${enderecosExistente.numero != null ? enderecosExistente.numero : ''}"required>
                </div>
            <div class="organizar">
                <span>CEP:</span>
                <input onkeyup="CepInput(event)" maxlength="9" type="text" name="cep" id="cep" value="${enderecosExistente.cep != null ? enderecosExistente.cep : ''}"required>
        </div>
    <div class="organizar">
        <span>Complemento:</span>
    <input type="text" name="complemento" id="complemento" value="${enderecosExistente.complemento != null ? enderecosExistente.complemento : ''}">
</div>
    <input type="hidden" name="id_usuario" id="id_usuario" value="${usuario.id_usuario}">
    <input type="hidden" name="id_endereco" id="id_endereco" value="${enderecosExistente.id_endereco}">
    <input type="hidden" name="rua" id="rua" >
    <input type="hidden" name="numero" id="numero">
    <input type="hidden" name="cep" id="cep" >
    <input type="hidden" name="complemento" id="complemento" >
    <div class="organizar">
        <button type="submit">Salvar Endereço</button>
    </div>
</div>
     

</c:forEach>
           </form>
                                        <div id="FormasPagamentos">
                                            
                                               

            <div class="organizarCartao">
                <div class="tituloPagamento">
                    <h1>Informar pagamento</h1>
                </div>
            <!-- <img id="imgCartao" src="./assets/FiguraCartaoCredito.png" alt="imagem cartao de credito"> -->
            <form id="Pagamentos" method="post">
                <input type="radio" id="PagamentoPix" name="pagamento" value="pix">
                <label for="pagamentoPix">PIX</label><br>
                
                <input type="radio" id="PagamentoCartaoCredito" name="pagamento" value="cartao_credito">
                <label for="pagamentoCartaoCredito">Cartão de Crédito</label><br>
                
                <input type="radio" id="PagamentoCartaoDebito" name="pagamento" value="cartao_debito">
                <label for="pagamentoCartaoDebito">Cartão de Débito</label><br>
                

                <button type="submit">Forma de pagamento</button>
            </form>
            <div id="InformPix" style="display: none;">
            <img id="imgpix" src="./assets/QRcodeGuilhermePix.jpeg" alt="QRCode para pagamento via pix">
            </div>
            <div id="confirmarPagamento">
            <div id="InformCartaoCredito" style="display: none;">
            <span>Nome do titular do cartão:</span>
        <input type="number" id="titular_cartao"" name="titular_cartao" required>
    <span>Numero cartao:</span>
    <input type="text" id="numero_cartao" maxlength="16" name="numero_cartao"required >
    <span>Codigo de segurança:</span>
    <input type="number" id="codigo_seguranca" name="codigo_seguranca"required >
    <span>Data de validade:</span>
    <input type="date" id="data-validade" name="data-validade" required>    
</div>

    <div id="InformCartaoDebito" style="display: none;">
        <span>Número do Cartão de Débito:</span>
        <input type="text" id="numeroCartaoDebito" minlength="12" maxlength="19" name="numeroCartaoDebito" required>
        <span>Data de Validade:</span>
        <input type="text" id="data-validade-debito" name="data-validade-debito" required>
        <span>Nome do Titular do Cartão:</span>
        <input type="text" id="nomeTitularCartaoDebito" name="nomeTitularCartaoDebito" required>
    </div> 
</div>
   </div>                        
</div>
<form action="AdicionarItemProdutosPedidos" method="post" enctype="multipart/form-data">
    <div id="TudoSobreProdutos">
        <h1>Produtos do carrinho</h1>

        <section class="ProdutosCarrinhoCheckout">
            <div id="ProdutosCheckout">
                <div id="ProdutoMainCarrinho">
                    <c:forEach items="${carrinhos}" var="carrinho">
                        <div class="informacoesProdutosCheckout">
                            <img src="${carrinho.imagemCarrinho}" alt="...">
                            <div class="infProd">
                                <p class="card-title">${carrinho.nomeCarrinho}</p>
                                <p class="card-text">Descrição: ${carrinho.descricaoCarrinho}</p>
                            </div>
                            <div class="infProd">
                                <p class="card-text">Tamanho: ${carrinho.tamanho}</p>
                                <p class="card-text">Categorias: ${carrinho.nomeCategoria}</p>
                            </div>
                            <div class="infProd">
                                <!-- Formulário separado para excluir o item do carrinho -->
                                <div id="botaoExcluitItemCarrinho">
                                    <p class="card-text">Unidades: ${carrinho.quantidadeCarrinho}</p>
                                    <form action="ExcluirItemCarrinho" method="post">
                                        <button type="button" class="button" onclick="excluirItemCarrinho(${carrinho.id_carrinho},${carrinho.quantidadeCarrinho},${carrinho.produtoId3})">
                                            <i class="svgIcon fa-sharp fa-solid fa-trash"></i>
                                        </button>
                                        <input type="hidden" name="idCarrinho" value="${carrinho.id_carrinho}">
                                        <input type="hidden" name="idProduto" value="${carrinho.produtoId3}">                                    
                                        <input type="hidden" name="quantidadeCarrinho" value="${carrinho.quantidadeCarrinho}">
                                    </form>
                                </div>
                                <p class="card-text">Valor Unidade: <fmt:formatNumber value="${carrinho.valorCarrinho}" type="currency"/></p>
                        </div>
                        </div>
                        <!-- Campos escondidos para adicionar produtos aos pedidos -->
                        <input type="hidden" name="idCarrinho" value="${carrinho.id_carrinho}">
                        <input type="hidden" name="produtoId" value="${carrinho.produtoId3}">
                        <input type="hidden" name="descricao" value="${carrinho.descricaoCarrinho}">
                        <input type="hidden" name="nomeCarrinho" value="${carrinho.nomeCarrinho}">
                        <input type="hidden" name="valor" value="${carrinho.valorCarrinho}">
                        <input type="hidden" name="quantidade" value="${carrinho.quantidadeCarrinho}">
                        <input type="hidden" name="tamanho" value="${carrinho.tamanhoId3}">
                        <input type="hidden" name="categoria" value="${carrinho.categoriaId3}">
                        <input type="hidden" name="imagem" value="${carrinho.imagemCarrinho}">
                    </c:forEach>
                    <input type="hidden" name="id_usuario" id="id_usuario" value="${usuario.id_usuario}">
                </div>
            </div>
        </section>          
        <div class="totalProdutosCheckout">
            <c:forEach items="${totalCarrinho}" var="totalCarrinhos">
                <div class="valorTotal">
                    <p class="card-text">Valor Total: <fmt:formatNumber value="${totalCarrinhos.total}" type="currency"/></p>
                </div>
            </c:forEach>
        </div>
<c:forEach var="enderecosExistente" items="${enderecoExistente}">
    <input type="hidden" name="id_usuario" id="id_usuario" value="${usuario.id_usuario}">
    <input type="hidden" name="nomeUsuario" id="nomeUsuario" value="${usuario.nome}">
    <input type="hidden" name="id_endereco" id="id_endereco" value="${enderecosExistente.id_endereco}">  
</c:forEach>
        <div id="finalizacao">
            <button id="finalizarCompra" type="submit">Finalizar Compra</button>
            <a href="./menu">Deseja voltar às compras? Clique aqui</a>
        </div>
    </div>
</form>

</div>
                    </main>
                    <!-- <footer>
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
                    </footer>                                     -->
    </body>
   <script src="./js/checkout.js"></script> 
   <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</html>