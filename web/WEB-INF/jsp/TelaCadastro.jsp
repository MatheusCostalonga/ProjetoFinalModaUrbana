<%-- 
    Document   : TelaCadastro
    Created on : 08/04/2024, 16:38:17
    Author     : Senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./styles/telaCadastro.css">
        <title>Pagina Cadastro</title>
        <script src="https://kit.fontawesome.com/187b9a1422.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <main>
                <img class="imagem" src="./assets/ModaUrbanaDourada.png"alt="logo da moda urbana">
                      <div id="fundo">   
                <h1>CADASTRO</h1>
                <form name="frmRegister" action="inserir">
                    <div class ="CampoTextCadastro">
                <div class="mb-3">
              <span for="inputNome" class="form-label"><i class="fa-solid fa-circle-user"></i> Nome:</span>
              <input type="text" id="nome" placeholder="Digite seu nome" name="nome" required>
            </div>
            <div class="mb-3">
              <span for="inputUsuario" class="form-label"><i class="fa-solid fa-user"></i> Usuario:</span>
              <input type="text"  id="usuario" placeholder="Digite seu usuario" name="usuario" required>
            </div>
              <div class="mb-3">
              <span for="inputSenha" class="form-label"><i class="fa-solid fa-lock"></i> Senha:</span>
              <input type="password"  id="senha" placeholder="Digite sua senha" name="senha" required>
          </div>
            <div class="mb-3">
              <div id="campos_juntos">
              
              <span for="inputCpf" class="form-label"><i class="fa-solid fa-address-card"></i> CPF:</span>
              <input type="text"  id="cpf" placeholder="Digite seu CPF" name="cpf" maxlength="14" 
                onkeyup="handleCpf(event)" required>

                <span for="inputTelefone" id="text_telefone" class="form-label"><i class="fa-solid fa-phone"></i> Telefone:</span>
              <input type="tel"  id="telefone" placeholder="Digite o Telefone" name="telefone" maxlength="15"
                onkeyup="handlePhone(event)" required>

              </div>
            
                <div id="campo_data_nascimento">
              <span for="inputDate"><i class="fa-regular fa-calendar-days"></i> Data do Nascimento:</span>
              <input type="date"  id="data_nascimento" name="data_nascimento" required>
            </div>
             </div>
            <div>
                <input id="botaoCadastrar" type="button" value="Cadastrar" onclick="cadastro()">
        </div>    
        </form>
        </main> 

    </body>
      <script src="./js/cadastro.js"></script>
</html>
