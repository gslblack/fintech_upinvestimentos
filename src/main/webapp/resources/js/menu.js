document.addEventListener("DOMContentLoaded", function() {
    const menuIcon = document.getElementById("menu-icon");
    const closeMenu = document.getElementById("close-menu");
    const sideMenu = document.getElementById("side-menu");

    menuIcon.addEventListener("click", function() {
        sideMenu.classList.remove("hidden");
        sideMenu.style.right = "0"; // Abre o menu à direita da tela
    });

    closeMenu.addEventListener("click", function() {
        sideMenu.classList.add("hidden");
        sideMenu.style.right = "-250px"; // Fecha o menu
    });
});
