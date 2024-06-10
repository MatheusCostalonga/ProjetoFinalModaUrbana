<%-- 
    Document   : TelaLogin
    Created on : 08/04/2024, 16:38:51
    Author     : Senai
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
     <script src="https://kit.fontawesome.com/52a6b206fa.js" crossorigin="anonymous"></script>
             <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <meta charset="UTF-8">
     <!--   <link rel="icon" type="image/x-icon" href="https://cdn-icons-png.flaticon.com/128/14512/14512231.png">-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./styles/telaLogin.css">
        <title>Login</title>
</head>
<body>
    <main>
    <img class="imagem" src="./assets/ModaUrbanaLogoLogin.png" alt="Logo da loja na tela de login">
    
    <div id="fundo">
        <form action="logar" method="post" enctype="multipart/form-data" >
        <h1>LOGIN</h1>
        <span class="usuario">Usuario:</span>
        <!-- placeholder="  Digite seu usuario" -->
        <i id="usuarioIcone" class="fa-solid fa-user"></i><input name="usuario" value="admin"  type="text" id="usuario" >

        <span class="senha">Senha:</span>

            <i id="cadeadoIcone" class="fa-solid fa-lock"></i><input name="senha" value="admin" type="password" id="senha">
               <button type="submit" id="button">PROSSEGUIR</button>
            <a id="linkCadastro" href="./CadastroClienteController">Não tem conta? Cadastre-se aqui!!</a>
        </form>
    </div>

</main>

</body>


</html>
