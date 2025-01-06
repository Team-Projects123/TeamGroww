// Highlight the active link in the navbar
document.addEventListener("DOMContentLoaded", function () {
    // Get the current page URL
    const currentPage = window.location.pathname.split("/").pop();

    // Find all navbar links
    const navLinks = document.querySelectorAll("nav .nav-link");

    // Loop through links to find a match
    navLinks.forEach((link) => {
        if (link.getAttribute("href") === currentPage) {
            link.classList.add("active");
        }
    });
});

// Confirm logout functionality
const logoutButton = document.querySelector("header form button");

if (logoutButton) {
    logoutButton.addEventListener("click", (e) => {
        const confirmLogout = confirm("Are you sure you want to log out?");
        if (!confirmLogout) {
            e.preventDefault(); // Prevent form submission
        }
    });
}
