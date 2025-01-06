function validateForm() {
    // Get form elements
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var phone = document.getElementById("phone").value;
    var address = document.getElementById("address").value;
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    var role = document.getElementById("role").value;

    // Validate name
    if (name == "") {
        alert("Please enter your full name.");
        return false;
    }

    // Validate email
    var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
        alert("Please enter a valid email address.");
        return false;
    }
    if (phone.length < 10) {
        alert("Please enter valid phone no.");
        return false;
    }
    if (address=="") {
        alert("Please enter a valid  address.");
        return false;
    }

    // Validate password length
    if (password.length < 8) {
        alert("Password must be at least 8 characters long.");
        return false;
    }

    // Check if passwords match
    if (password !== confirmPassword) {
        alert("Passwords do not match.");
        return false;
    }

    // Validate role selection
    if (role == "") {
        alert("Please select a role.");
        return false;
    }

    // If all validations pass
    return true;
}
