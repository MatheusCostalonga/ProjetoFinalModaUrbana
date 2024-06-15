function VerificacaoEndereco() {
    var rua = document.getElementById("rua").value;
    var numero = document.getElementById("numero").value;
    var cep = document.getElementById("cep").value;
    var complemento = document.getElementById("complemento").value;

    if (rua.trim() !== "" && cep.trim() !== "") {
    document.getElementById("enderecoForm").action = "EditarEndereco";
    document.getElementById("action").value = "EditarEndereco";
} else {
    document.getElementById("enderecoForm").action = "InserirIndereco";
    document.getElementById("action").value = "InserirIndereco";
}
}