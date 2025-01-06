// JavaScript for form validation
document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent form submission to allow validation

    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var role = document.getElementById("role").value;

    // Validate email
    if (!validateEmail(email)) {
        alert("Please enter a valid email address.");
        return;
    }

    // Validate password (basic length check)
    if (password.length < 6) {
        alert("Password should be at least 6 characters long.");
        return;
    }

    // Role validation
    if (role === "") {
        alert("Please select a role.");
        return;
    }

    // If everything is valid, submit the form
    this.submit();
});

// Simple email validation regex
function validateEmail(email) {
    var pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return pattern.test(email);
}
