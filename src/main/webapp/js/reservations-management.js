document.addEventListener("DOMContentLoaded", function () {
    const reservationForm = document.querySelector("form[method='POST']");
    const userIdInput = document.getElementById("user_id");
    const bookIdInput = document.getElementById("book_id");
    const statusSelect = document.getElementById("status");

    // Prevent form submission if any required field is empty
    reservationForm.addEventListener("submit", function (event) {
        let errorMessage = "";

        // Check if User ID is provided
        if (!userIdInput.value) {
            errorMessage += "User ID is required.\n";
        }

        // Check if Book ID is provided
        if (!bookIdInput.value) {
            errorMessage += "Book ID is required.\n";
        }

        // Check if Status is selected
        if (!statusSelect.value) {
            errorMessage += "Reservation Status is required.\n";
        }

        // If there are validation errors, prevent the form from submitting and show an alert
        if (errorMessage) {
            alert("Please fix the following errors:\n" + errorMessage);
            event.preventDefault(); // Prevent form submission
        } else {
            // Confirm the reservation details before submitting the form
            const confirmation = confirm(`Are you sure you want to reserve Book ID ${bookIdInput.value} for User ID ${userIdInput.value}?`);
            if (!confirmation) {
                event.preventDefault(); // Prevent form submission if the user cancels
            }
        }
    });
});
