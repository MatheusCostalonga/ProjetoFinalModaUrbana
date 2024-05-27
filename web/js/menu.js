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

// let currentScrollPosition = 0;
// let scrollAmount = 320;

// const card = document.querySelector('.card');
// const hScroll = document.querySelector('.horizontal-scroll');
// const btnScrollLeft = document.querySelector('#btn-scroll-left');
// const btnScrollRight = document.querySelector('#btn-scroll-right');


// let maxScroll = -card.offsetWidth + hScroll.offsetWidth;

// function scrollHorizontally(val){
//     currentScrollPosition += (val * scrollAmount);

//     if(currentScrollPosition > 0){
//         currentScrollPosition = 0;
//     }
//     if(currentScrollPosition < maxScroll){
//         currentScrollPosition = maxScroll;
//     }
//     card.style.left = currentScrollPosition + "px";

// }