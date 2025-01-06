<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.servlet.*, javax.servlet.http.*" %>
<%
    Connection conn = null;
    PreparedStatement stmt = null;
    String dbURL = "jdbc:mysql://localhost:3306/Library"; // Your database URL
    String dbUser = "root"; // Your database username
    String dbPass = "@jayradhekrishna123"; // Your database password
    String message = "";

    // Establish connection
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
    } catch (Exception e) {
        message = "Database connection error: " + e.getMessage();
    }

    if (request.getMethod().equalsIgnoreCase("POST")) {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String genre = request.getParameter("genre");
        String publisher = request.getParameter("publisher");
        String isbn = request.getParameter("isbn");
        int copiesTotal = Integer.parseInt(request.getParameter("copies_total"));
        int copiesAvailable = Integer.parseInt(request.getParameter("copies_available"));

        try {
            String insertSQL = "INSERT INTO books (title, author, genre, publisher, isbn, copies_total, copies_available) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setString(3, genre);
            stmt.setString(4, publisher);
            stmt.setString(5, isbn);
            stmt.setInt(6, copiesTotal);
            stmt.setInt(7, copiesAvailable);
            stmt.executeUpdate();
            message = "Book added successfully!";
        } catch (SQLException e) {
            message = "Error: " + e.getMessage();
        }
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Book</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/book-management.css">
</head>
<body>
    <header class="bg-primary text-white d-flex justify-content-between align-items-center py-3 px-4">
        <h1>Admin Dashboard</h1>
        <form action="logout.jsp" method="post" class="mb-0">
            <button type="submit" class="btn btn-danger">Logout</button>
        </form>
    </header>

    <!-- Navbar -->
    <nav class="nav justify-content-center bg-light py-2">
        <a class="nav-link" href="users.jsp">Users</a>
        <a class="nav-link" href="books.jsp">Books</a>
        <a class="nav-link" href="loans.jsp">Loans</a>
        <a class="nav-link" href="fines.jsp">Fines</a>
        <a class="nav-link" href="reservations.jsp">Reservations</a>
        <a class="nav-link" href="system-logs.jsp">System Logs</a>
    </nav>
    <div class="container mt-4">
        <h2>Add New Book</h2>

        <!-- Display message -->
        <% if (!message.isEmpty()) { %>
            <div class="alert alert-info">
                <%= message %>
            </div>
        <% } %>

        <form action="add-book.jsp" method="POST">
            <div class="mb-3">
                <label for="title" class="form-label">Book Title</label>
                <input type="text" class="form-control" id="title" name="title" required>
            </div>

            <div class="mb-3">
                <label for="author" class="form-label">Author</label>
                <input type="text" class="form-control" id="author" name="author" required>
            </div>

            <div class="mb-3">
                <label for="genre" class="form-label">Genre</label>
                <input type="text" class="form-control" id="genre" name="genre" required>
            </div>

            <div class="mb-3">
                <label for="publisher" class="form-label">Publisher</label>
                <input type="text" class="form-control" id="publisher" name="publisher" required>
            </div>

            <div class="mb-3">
                <label for="isbn" class="form-label">ISBN</label>
                <input type="text" class="form-control" id="isbn" name="isbn" required>
            </div>

            <div class="mb-3">
                <label for="copies_total" class="form-label">Total Copies</label>
                <input type="number" class="form-control" id="copies_total" name="copies_total" required>
            </div>

            <div class="mb-3">
                <label for="copies_available" class="form-label">Available Copies</label>
                <input type="number" class="form-control" id="copies_available" name="copies_available" required>
            </div>

            <button type="submit" class="btn btn-primary">Add Book</button>
            <a href="books.jsp" class="btn btn-secondary">Back to Books List</a>
        </form>
    </div>
    <script src="js/book-management.js" ></script>
</body>
</html>
