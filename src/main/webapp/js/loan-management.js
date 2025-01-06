document.addEventListener("DOMContentLoaded", function () {
    const loanForm = document.querySelector("form[method='POST']");
    const userIdInput = document.getElementById("user_id");
    const bookIdInput = document.getElementById("book_id");
    const issueDateInput = document.getElementById("issue_date");
    const dueDateInput = document.getElementById("due_date");

    loanForm.addEventListener("submit", function (event) {
        // Check if all required fields are filled
        if (!userIdInput.value || !bookIdInput.value || !issueDateInput.value || !dueDateInput.value) {
            alert("Please fill out all fields.");
            event.preventDefault(); // Prevent form submission
        }
    });
});
