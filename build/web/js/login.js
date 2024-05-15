function validacao() {
    let usuario = frmLogin.usuario.value;
     let senha = frmLogin.senha.value;

    if (usuario.trim() === "") {
        warningToast(text = 'Preencha o nome do usuario!');
        frmLogin.usuario.focus();
       return false;
    } else if (senha.trim() === "") {
        warningToast(text = 'Preencha o campo da senha!');
        frmLogin.senha.focus();
        return false;
    } else {    
        let matchedUser = clientes.find(item => item.usuario === usuario && item.senha === senha);
        if (!matchedUser) {
            errorToast(text = 'Nome de Usuário ou senha incorretos!');
            frmLogin.usuario.focus();
            frmLogin.senha.focus();
            return false;
        } else {
            document.forms["frmLogin"].submit();
        }
        
    }
}

let clientes;
fetch('./clientes')
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao obter dados');
        }
        return response.json();
    })
    .then(data => {
        clientes = data;
        console.log(clientes)
    })
    .catch(error => {
        console.error(error);
    });