   document.addEventListener("DOMContentLoaded", function() {
     const container = document.querySelector(".horizontal-scroll");
     const scrollLeftBtn = document.getElementById("scrollLeft");
     const scrollRightBtn = document.getElementById("scrollRight");
    
     scrollLeftBtn.addEventListener("click", function() {
       container.scrollBy({
         left: -300, 
         behavior: "smooth"
       });
     });
    
     scrollRightBtn.addEventListener("click", function() {
       container.scrollBy({
           left: 300, 
           behavior: "smooth"
         });
       });
     });