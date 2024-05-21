/*Victor me passou e explicou o codigo*/
function cadastro() {
    let nome = frmRegister.nome.value;
    let cpf = frmRegister.cpf.value;
    let telefone = frmRegister.telefone.value;
    let data_nascimento = frmRegister.data_nascimento.value;
    let usuario = frmRegister.usuario.value;
    let senha = frmRegister.senha.value;
    

if (nome.trim() === "") {
        warningToast(text = 'Preencha o campo Nome!');
        frmRegister.nome.focus();
        return false;
    } else if (cpf.trim() === "") {
        warningToast(text = 'Preencha o campo CPF!');
        frmRegister.cpf.focus();
        return false;
    } else if (cpf.length < 14 || cpf.length >= 15) {
        warningToast(text = 'Preencha o campo CPF corretamente!');
        frmRegister.cpf.focus();
        return false;
    } else if (users && users.some(item => item.cpf === cpf)) {
        errorToast(text = 'Cpf de usuário já possui um cadastro!');
        frmRegister.cpf.focus();
        return false;
    } else if (telefone.trim() === "") {
        warningToast(text = 'Preencha o campo Telefone!');
        frmRegister.telefone.focus();
        return false;
    } else if (telefone.length < 14 || telefone.length >= 16) {
        warningToast(text = 'Preencha o campo Telefone corretamente!');
        frmRegister.telefone.focus();
        return false;
    } else if (users && users.some(item => item.telefone === telefone)) {
        errorToast(text = 'Esse numero de telefone ja possui um cadastro!');
        frmRegister.telefone.focus();
        return false;
    } else if (data_nascimento.trim() === "") {
        warningToast(text = 'Selecione uma data de nascimento!');
        frmRegister.data_nascimento.focus();
        return false;
    } else if (data_nascimento > dataFormatada) {
        warningToast(text = 'Selecione uma data valida!');
        frmRegister.data_nascimento.focus();
        return false;
    } else if (usuario.trim() === "") {
        warningToast(text = 'Preencha o campo Nome de Usuario!');
        frmRegister.usuario.focus();
        return false;
    } else if (users && users.some(item => item.usuario === usuario)) {
        errorToast(text = 'Esse nome de usuario ja possui um cadastro!');
        frmRegister.usuario.focus();
        return false;
    } else if (senha.trim() === "") {
        warningToast(text = 'Preencha o campo Senha!');
        frmRegister.senha.focus();
        return false;
    } else if (senha.length < 8) {
        warningToast(text = 'Senha deve conter pelo menos 8 caracteres!');
        frmRegister.senha.focus();
        return false;
    }
    alert(text = 'cadastro realizado com sucesso');
    document.forms["frmRegister"].submit();
}
let users;
fetch('./users')
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao obter dados dos usuários');
        }
        return response.json();
    })
    .then(data_nascimento => {
        users = data_nascimento;
    })
    .catch(error => {
        console.error(error);
    });

const handlePhone = (event) => {
    let input = event.target;
    input.value = phoneMask(input.value);
}

const phoneMask = (value) => {
    if (!value) return "";
    value = value.replace(/\D/g, '');
    value = value.replace(/(\d{2})(\d)/, "($1) $2");
    value = value.replace(/(\d)(\d{4})$/, "$1-$2");
    return value;
}

const handleCpf = (event) => {
    let input = event.target;
    input.value = cpfMask(input.value);
}

const cpfMask = (value) => {
    if (!value) return "";
    value = value.replace(/\D/g, "");
    value = value.replace(/(\d{3})(\d)/, "$1.$2");
    value = value.replace(/(\d{3})(\d)/, "$1.$2");
    value = value.replace(/(\d{3})(\d{1,2})$/, "$1-$2");
    return value;
}

let dataAtual = new Date();
let dataFormatada = dataAtual.getFullYear() + '-' +
    ('0' + (dataAtual.getMonth() + 1)).slice(-2) + '-' +
    ('0' + dataAtual.getDate()).slice(-2);

let elementoData = document.getElementById("data_nascimento");
elementoData.setAttribute("max", dataFormatada);