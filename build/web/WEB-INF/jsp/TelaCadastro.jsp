<%-- 
    Document   : TelaCadastro
    Created on : 08/04/2024, 16:38:17
    Author     : Senai
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./styles/telaCadastro.css">
        <title>Pagina Cadastro</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/187b9a1422.js" crossorigin="anonymous"></script>    </head>
    <body>
        <main>
          <div id="imgResponsiva">
          <img class="imagem" src="./assets/ModaUrbanaLogoLogin.png" alt="Logo da loja na tela de cadastro">
        </div>
          <div id="fundo">   
                <h1>CADASTRO</h1>
                <form name="frmRegister" action="inserir">

                     <span for="inputNome"> Nome:</span>
                <div class="mb-3">
             <i class="fa-solid fa-user"></i>
                <input type="text" id="nome" name="nome" required>
            </div>
            <span for="inputUsuario" class="form-label">Usuario:</span>
            <div class="mb-3">
              
              <i class="fa-solid fa-circle-user"></i>
              <input type="text"  id="usuario"  name="usuario" required>
            </div>
            <span for="inputSenha" class="form-label">Senha:</span>
              <div class="mb-3">             
               <i class="fa-solid fa-lock"></i>
              <input type="password"  id="senha"  name="senha" required>
          </div>  
          <span for="inputCpf" class="cpfText">CPF:</span>
          <span for="inputTelefone" id="text_telefone">Telefone:</span>

            <div class="camposJuntos">
            <div class="mb-3">  
              <i class="fa-solid fa-address-card"></i>            
              <input type="text"  id="cpf"  name="cpf" maxlength="14" 
                onkeyup="handleCpf(event)" required>
            </div>
            <div class="mb-3">
                <i class="fa-solid fa-phone"></i>
                <input type="tel"  id="telefone"  name="telefone" maxlength="15"
                onkeyup="handlePhone(event)" required>
                </div>
              </div>
                <span for="inputDate">Data do Nascimento:</span>
                <div class="mb-3">
                  <i id="iconeCalendario" class="fa-regular fa-calendar-days"></i>
              <input type="date"  id="data_nascimento" name="data_nascimento" required>
            </div>
            <div id="BotaoResponsivo">
            <input id="botaoCadastrar" type="button" value="PROSSEGUIR" onclick="cadastro()">
            <a id="linkLogin" href="./loginCliente">Possuo Login</a>
          </div>   
          </div>   
        </form>
        </main> 

    </body>
      <script src="./js/cadastro.js"></script>
</html>
