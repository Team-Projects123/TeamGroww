// Validation for Add Book Form
document.addEventListener("DOMContentLoaded", function () {
    const addBookForm = document.querySelector("form[action='add-book.jsp']");
    const deleteBookForm = document.querySelector("form[action='delete-book.jsp']");

    if (addBookForm) {
        addBookForm.addEventListener("submit", function (e) {
            const title = document.getElementById("title").value.trim();
            const author = document.getElementById("author").value.trim();
            const genre = document.getElementById("genre").value.trim();
            const publisher = document.getElementById("publisher").value.trim();
            const isbn = document.getElementById("isbn").value.trim();
            const copiesTotal = parseInt(document.getElementById("copies_total").value);
            const copiesAvailable = parseInt(document.getElementById("copies_available").value);

            if (!title || !author || !genre || !publisher || !isbn) {
                alert("Please fill in all fields!");
                e.preventDefault();
                return;
            }

            if (copiesAvailable > copiesTotal) {
                alert("Available copies cannot exceed total copies!");
                e.preventDefault();
                return;
            }
        });
    }

    if (deleteBookForm) {
        deleteBookForm.addEventListener("submit", function (e) {
            const bookId = parseInt(document.getElementById("book_id").value);

            if (isNaN(bookId) || bookId <= 0) {
                alert("Please enter a valid Book ID!");
                e.preventDefault();
            }
        });
    }
});
