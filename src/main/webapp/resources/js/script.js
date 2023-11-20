// Criação do menu dinâmico na responsividade
document.addEventListener('DOMContentLoaded', function() {
    const menuToggle = document.getElementById('menu-toggle');
    const menuItems = document.querySelector('.menu-items');
  
    menuToggle.addEventListener('click', function() {
      menuItems.classList.toggle('open');
    });
  });
  