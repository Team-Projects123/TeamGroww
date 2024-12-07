function validateForm() {
    const form = document.getElementById('registerForm');
    const inputs = form.querySelectorAll('input, select');
    let isValid = true;

    // Reset validation state
    inputs.forEach(input => {
        input.classList.remove('is-invalid');
    });
    const errorMessage = document.getElementById('error-message');
    errorMessage.classList.add('d-none');

    // Validate each input field
    inputs.forEach(input => {
        if (!input.value.trim()) {
            input.classList.add('is-invalid');
            isValid = false;
        }
    });

    // Additional validation for password confirmation
    const password = document.getElementById('password').value.trim();
    const confirmPassword = document.getElementById('confirmPassword').value.trim();
    if (password !== confirmPassword) {
        document.getElementById('confirmPassword').classList.add('is-invalid');
        isValid = false;
    }

    if (!isValid) {
        // Display error message
        errorMessage.textContent = "One or more fields are empty. Please fill out all fields.";
        errorMessage.classList.remove('d-none');
        return;
    }

    // If the form is valid, proceed
    alert('Form is successfully validated!');
    form.submit();
}
