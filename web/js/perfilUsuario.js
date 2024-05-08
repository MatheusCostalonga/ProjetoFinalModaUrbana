const openPerfil = document.querySelector('.btn btn-primary dropdown-toggle');
const dropdownMenu = document.querySelector('.dropdown-menu')

openPerfil.addEventListener('click', function(e) {
    e.preventDefault();
    dropdownMenu.classList.add('active');
});