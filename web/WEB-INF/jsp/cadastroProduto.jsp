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
    <title>Cadastro de Produto</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Cadastro de Produto</h2>
        <form action="cadastrarProduto" method="POST" enctype="multipart/form-data">
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" class="form-control" id="nome" name="nome" required>
            </div>
            <div class="form-group">
                <label for="descricao">Descrição</label>
                <input type="text" class="form-control" id="descricao" name="descricao" required>
            </div>            
            <div class="form-group">
                <label for="categoria">Categoria:</label>
                <select class="form-control" id="categorias" name="categorias">
                    <option value="1">Camiseta</option>
                    <option value="2">Camisa</option>
                    <option value="3">Calça</option>
                    <option value="4">Jaqueta</option>
                    <option value="5">Bermuda</option>
                </select>
            </div>
                        <div class="form-group">
                <label for="tamanho">Tamanho:</label>
                <select class="form-control" id="categorias" name="Tamanho">
                    <option value="1">GG</option>
                    <option value="2">G</option>
                    <option value="3">M</option>
                    <option value="4">P</option>
                </select>
            </div>

                        <div class="form-group">
                <label for="quantidade">Quantidade:</label>
                <input type="number" step="1" class="form-control" id="quantidade" name="quantidade" required>
            </div>
            <div class="form-group">
                <label for="valor">Valor:</label>
                <input type="number" step="0.01" class="form-control" id="valor" name="valor" required>
            </div>

            <div class="form-group">
                <label for="imagem">Imagem do Produto:</label>
                <input type="file" class="form-control-file" id="imagem" name="imagem">
            </div>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>