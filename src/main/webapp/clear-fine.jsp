<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    Connection conn = null;
    PreparedStatement stmt = null;
    String dbURL = "jdbc:mysql://localhost:3306/Library"; // Your database URL
    String dbUser = "root"; // Your database username
    String dbPass = "@jayradhekrishna123"; // Your database password
    String message = "";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
    } catch (Exception e) {
        message = "Database connection error: " + e.getMessage();
    }

    if (request.getMethod().equalsIgnoreCase("POST")) {
        int fineId = Integer.parseInt(request.getParameter("fine_id"));
        double fineAmount = Double.parseDouble(request.getParameter("fine_amount"));

        try {
            String updateSQL = "UPDATE fines SET paid_status = ?, payment_date = CURRENT_DATE WHERE fine_id = ?";
            stmt = conn.prepareStatement(updateSQL);
            stmt.setBoolean(1, true); // Set the fine as paid
            stmt.setInt(2, fineId);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                message = "Fine cleared successfully!";
            } else {
                message = "No fine found with the provided ID.";
            }
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
    <title>Clear Fine</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/management.css">
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
        <h2>Clear Fine</h2>

        <!-- Display message -->
        <% if (!message.isEmpty()) { %>
            <div class="alert alert-info">
                <%= message %>
            </div>
        <% } %>

        <form action="clear-fine.jsp" method="POST">
            <div class="mb-3">
                <label for="fine_id" class="form-label">Fine ID</label>
                <input type="text" class="form-control" id="fine_id" name="fine_id" required>
            </div>
            <div class="mb-3">
                <label for="fine_amount" class="form-label">Fine Amount</label>
                <input type="text" class="form-control" id="fine_amount" name="fine_amount" required>
            </div>

            <button type="submit" class="btn btn-success">Clear Fine</button>
            <a href="fines.jsp" class="btn btn-secondary">Back to Fines List</a>
        </form>
    </div>
    <script src="js/delete.js"></script>
</body>
</html>
