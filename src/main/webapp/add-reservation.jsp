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
        int userId = Integer.parseInt(request.getParameter("user_id"));
        int bookId = Integer.parseInt(request.getParameter("book_id"));
        String status = request.getParameter("status");

        try {
            String insertSQL = "INSERT INTO reservations (user_id, book_id, status) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(insertSQL);
            stmt.setInt(1, userId);
            stmt.setInt(2, bookId);
            stmt.setString(3, status);
            stmt.executeUpdate();
            message = "Reservation added successfully!";
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
    <title>Add Reservation</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/reservation-management.css">
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
        <h2>Add New Reservation</h2>

        <!-- Display message -->
        <% if (!message.isEmpty()) { %>
            <div class="alert alert-info">
                <%= message %>
            </div>
        <% } %>

        <form action="add-reservations.jsp" method="POST">
            <div class="mb-3">
                <label for="user_id" class="form-label">User ID</label>
                <input type="number" class="form-control" id="user_id" name="user_id" required>
            </div>

            <div class="mb-3">
                <label for="book_id" class="form-label">Book ID</label>
                <input type="number" class="form-control" id="book_id" name="book_id" required>
            </div>

            <div class="mb-3">
                <label for="status" class="form-label">Reservation Status</label>
                <select class="form-select" id="status" name="status" required>
                    <option value="Active" selected>Active</option>
                    <option value="Completed">Completed</option>
                    <option value="Cancelled">Cancelled</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Add Reservation</button>
            <a href="reservations.jsp" class="btn btn-secondary">Back to Reservations List</a>
        </form>
    </div>
    <script src="js/reservation-management.js"></script>
</body>
</html>
