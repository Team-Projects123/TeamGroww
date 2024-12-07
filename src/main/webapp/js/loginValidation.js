document.addEventListener("DOMContentLoaded", function () {
    const loginForm = document.getElementById("loginForm");

    loginForm.addEventListener("submit", function (event) {
        event.preventDefault(); // Prevent form submission for validation
        
        const usernameField = document.getElementById("username");
        const passwordField = document.getElementById("password");
        const roleField = document.getElementById("role");

        let isValid = true;

        // Reset previous feedback
        clearFeedback();

        // Check if username (email) is empty
        if (usernameField.value.trim() === "") {
            showFeedback(usernameField, "Username or email is required.");
            isValid = false;
        } else if (!isValidEmail(usernameField.value.trim())) {
            showFeedback(usernameField, "Please enter a valid email address.");
            isValid = false;
        }

        // Check if password is empty
        if (passwordField.value.trim() === "") {
            showFeedback(passwordField, "Password is required.");
            isValid = false;
        }

        // Check if role is selected
        if (roleField.value === "select") {
            showFeedback(roleField, "Please select a role.");
            isValid = false;
        }

        // Submit form if all fields are valid
        if (isValid) {
            loginForm.submit();
        }
    });

    /**
     * Helper function to show feedback
     * @param {HTMLElement} field 
     * @param {string} message 
     */
    function showFeedback(field, message) {
        const feedback = document.createElement("div");
        feedback.className = "invalid-feedback";
        feedback.textContent = message;

        field.classList.add("is-invalid");
        field.parentNode.appendChild(feedback);
    }

    /**
     * Helper function to clear previous feedback
     */
    function clearFeedback() {
        const feedbackElements = document.querySelectorAll(".invalid-feedback");
        feedbackElements.forEach(element => element.remove());

        const invalidFields = document.querySelectorAll(".is-invalid");
        invalidFields.forEach(field => field.classList.remove("is-invalid"));
    }

    /**
     * Helper function to validate email format
     * @param {string} email 
     * @returns {boolean}
     */
    function isValidEmail(email) {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }
});
