// book-management.js
document.addEventListener("DOMContentLoaded", function () {
    // Example validation for form inputs
    const deleteLoanForm = document.querySelector("form[action='delete-loan.jsp']");
    const clearFineForm = document.querySelector("form[action='clear-fine.jsp']");

    if (deleteLoanForm) {
        deleteLoanForm.addEventListener("submit", function (event) {
            const loanIdInput = document.getElementById("loan_id");
            if (!loanIdInput.value) {
                alert("Please enter a valid Loan ID.");
                event.preventDefault();
            }
        });
    }

    if (clearFineForm) {
        clearFineForm.addEventListener("submit", function (event) {
            const fineIdInput = document.getElementById("fine_id");
            const fineAmountInput = document.getElementById("fine_amount");

            if (!fineIdInput.value || !fineAmountInput.value) {
                alert("Please enter both Fine ID and Fine Amount.");
                event.preventDefault();
            }
        });
    }

    const form = document.querySelector("form");
    const deleteButton = form.querySelector("button[name='delete']");

    // Attach an event listener to the delete button
    deleteButton.addEventListener("click", function (event) {
        event.preventDefault(); // Prevent form submission

        // Retrieve values from input fields
        const userIdInput = document.getElementById('userId');
    const messageElement = document.getElementById('message');

    // Reset the message
    messageElement.textContent = '';

    // Check if userId is valid
    if (!userIdInput.value || userIdInput.value <= 0) {
        e.preventDefault();
        messageElement.textContent = 'Please enter a valid User ID.';
        messageElement.classList.add('text-danger');
    }
    });


});

