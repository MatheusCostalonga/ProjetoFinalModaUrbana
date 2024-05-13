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
          <img class="imagem" src="./assets/ModaUrbanaLogoLogin.png" alt="Logo da loja na tela de cadastro">
          <div id="fundo">   
                <h1>CADASTRO</h1>
                <form name="frmRegister" action="inserir">
                    <div class ="CampoTextCadastro">
                <div class="mb-3">
              <span for="inputNome" class="form-label"> Nome:</span>
              <i class="nomeIcone" class="fa-solid fa-circle-user"></i><input type="text" id="nome" name="nome" required>
            </div>
            <div class="mb-3">
              <span for="inputUsuario" class="form-label"> Usuario:</span>
              <i class="usuarioIcone" class="fa-solid fa-user"></i><input type="text"  id="usuario"  name="usuario" required>
            </div>
              <div class="mb-3">
              <span for="inputSenha" class="form-label"> Senha:</span>
              <i class="senhaIcone" class="fa-solid fa-lock"></i><input type="password"  id="senha"  name="senha" required>
          </div>
            <div class="mb-3">
              <div id="campos_juntos">
              <span for="inputCpf" class="form-label"> CPF:</span>
              <i class="cpfIcone" class="fa-solid fa-address-card"></i><input type="text"  id="cpf"  name="cpf" maxlength="14" 
                onkeyup="handleCpf(event)" required>
                <span for="inputTelefone" id="text_telefone" class="form-label"> Telefone:</span>
              <i class="telefoneIcone" class="fa-solid fa-phone"></i><input type="tel"  id="telefone"  name="telefone" maxlength="15"
                onkeyup="handlePhone(event)" required>
              </div>
                <div id="campo_data_nascimento">
              <span for="inputDate"> Data do Nascimento:</span>
              <i class="dataNascimentoIcone" class="fa-regular fa-calendar-days"></i><input type="date"  id="data_nascimento" name="data_nascimento" required>
            </div>
             </div>
            <div>
                <input id="botaoCadastrar" type="button" value="PROSSEGUIR" onclick="cadastro()">
        </div>    
        </form>
        </main> 

    </body>
      <script src="./js/cadastro.js"></script>
</html>
