<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    Connection conn = null;
    PreparedStatement pstmt = null;
    String message = "";

    // Database connection setup
    String dbURL = "jdbc:mysql://localhost:3306/Library";
    String dbUser = "root";
    String dbPass = "@jayradhekrishna123";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        if (request.getParameter("delete") != null) {
            String userId = request.getParameter("userId");
            String query = "DELETE FROM users1 WHERE user_id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, userId);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                message = "User deleted successfully.";
            } else {
                message = "No user found with the provided ID.";
            }
        }
    } catch (Exception e) {
        message = "Error: " + e.getMessage();
    } finally {
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="delete.css" rel="stylesheet">
</head>
<body>
    <header class="bg-primary text-white d-flex justify-content-between align-items-center py-3 px-4">
        <h1>Admin Dashboard</h1>
        <form action="logout.jsp" method="post" class="mb-0">
            <button type="submit" class="btn btn-danger">Logout</button>
        </form>
    </header>

    <nav class="nav justify-content-center bg-light py-2">
        <a class="nav-link" href="users.jsp">Users</a>
        <a class="nav-link" href="books.jsp">Books</a>
        <a class="nav-link" href="loans.jsp">Loans</a>
        <a class="nav-link" href="fines.jsp">Fines</a>
        <a class="nav-link" href="reservations.jsp">Reservations</a>
        <a class="nav-link" href="system-logs.jsp">System Logs</a>
    </nav>

    <div class="container mt-4">
        <h2>Delete User</h2>
        <form id="deleteUserForm" method="post">
            <div class="mb-3">
                <label for="userId" class="form-label">User ID</label>
                <input type="number" class="form-control" id="userId" name="userId" required>
            </div>
            <button type="submit" name="delete" class="btn btn-danger">Delete User</button>
        </form>
        <p id="message" class="mt-3 text-success"><%= message %></p>
    </div>

    <script src="delete.js"></script>
</body>
</html>
