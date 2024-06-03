<%-- 
    Document   : cadastrarProduto
    Created on : 01/05/2024, 10:49:52
    Author     : Iago
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="https://kit.fontawesome.com/187b9a1422.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./styles/cadastroProduto.css">
    <title>Cadastrar Produto</title>
</head>
<body>
        <header>
            <a href="./menu"><i id="IconeList" class="fa-solid fa-list"></i></a>
        </header>
        <main>
            <h2>Cadastrar Produto</h2>
        <form class="cadastroProd" action="cadastrarProduto" method="POST" enctype="multipart/form-data">
           <div id="juntos">
            <div class="group-cadastro">
            <span for="nome">Nome do produto:</span>

            <div class="form-group">
                <input type="text" class="form-control" id="nome_produto" name="nome_produto" required>
            </div>
            <span for="descricao">Descrição:</span>
            <div class="form-group">
                <input type="text" class="form-control" id="descricao" name="descricao" required>
            </div>            
            <span for="categoria">Categoria:</span>
            <div class="form-group">
                <select class="form-control" id="categorias" name="categorias">
                    <option value="1">Camiseta</option>
                    <option value="2">Camisa</option>
                    <option value="3">Calça</option>
                    <option value="4">Jaqueta</option>
                    <option value="5">Bermuda</option>
                </select>
            </div>
            <span for="tamanho">Tamanho:</span>
                        <div class="form-group">
                <select class="form-control" id="categorias" name="Tamanho">
                    <option value="1">GG</option>
                    <option value="2">G</option>
                    <option value="3">M</option>
                    <option value="4">P</option>
                </select>
            </div>

            <span for="quantidade">Quantidade:</span>
                        <div class="form-group">
                <input type="number" step="1" class="form-control" id="quantidade" name="quantidade" required>
            </div>
            <span for="valor">Valor:</span>
            <div class="form-group">
                <input type="number" step="0.01" class="form-control" id="valor" name="valor" required>
            </div>
            <button type="submit" class="btn btn-primary">Cadastrar Produto</button>
        </div>     
        <div class="form-imagem">    
            <label class="inserirImagem" for="imagem">Imagem Principal do produto</label>    
            <input type="file" class="form-control-file" value="Imagem principal" id="imagem" name="imagem">
        </div>
        </div>
        </form>
    </div>
</main>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</html>