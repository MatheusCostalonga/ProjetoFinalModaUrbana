const openBtn = document.querySelector('.open-btn');
const closeBtn = document.querySelector('.close-btn');
const offcanvasMenu = document.querySelector('.offcanvas-menu')

openBtn.addEventListener('click', function(e) {
    e.preventDefault();
    offcanvasMenu.classList.add('active');
});

closeBtn.addEventListener('click', function (e) {
    e.preventDefault();
    offcanvasMenu.classList.remove('active');
});

document.querySelectorAll('.btn-comprar').forEach(btn => {
    btn.addEventListener('click', function() {
        var idProduto = this.getAttribute('data-id');
        var descricao = this.getAttribute('data-descricao');
        var nome = this.getAttribute('data-nome');
        var preco = this.getAttribute('data-preco');
        var imagem = this.getAttribute('data-imagem');
        var quantidade = this.getAttribute('data-quantidade');
        
        // Crie um novo objeto FormData
        var formData = new FormData();
        
        // Adicione os dados do produto ao FormData
        formData.append('idProduto', idProduto);
        formData.append('descricao', descricao);
        formData.append('nome', nome);
        formData.append('preco', preco);
        formData.append('quantidade',quantidade);
        
        // Crie um Blob a partir do base64 da imagem
        var byteCharacters = atob(imagem);
        var byteNumbers = new Array(byteCharacters.length);
        for (var i = 0; i < byteCharacters.length; i++) {
            byteNumbers[i] = byteCharacters.charCodeAt(i);
        }
        var byteArray = new Uint8Array(byteNumbers);
        var blob = new Blob([byteArray], { type: 'image/jpeg' });
        
        // Adicione a imagem ao FormData
        formData.append('imagem', blob, 'imagem.jpeg');
        
        // Envie o FormData
        fetch('enviarc', {
            method: 'POST',
            body: formData
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Ocorreu um erro ao enviar o formulário.');
            }else{
                alert('Compra feita com sucesso.');
                window.location.href = './home';
            }
           
        })
        .catch(error => {
            console.error('Erro:', error);
        });
    });
});

