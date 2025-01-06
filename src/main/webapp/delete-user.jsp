<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    Connection conn = null;
    PreparedStatement pstmt = null;
    String message = "";

    // Database connection setup
    String dbURL = "jdbc:mysql://localhost:3306/Library";
    String dbUser = "root"; // Replace with your database username
    String dbPass = "@jayradhekrishna123"; // Replace with your database password

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        if (request.getParameter("delete") != null) {
            String userId = request.getParameter("userId");
            String query = "DELETE FROM users WHERE user_id = ?";
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
</head>
<body>
    <div class="container mt-4">
        <h2>Delete User</h2>
        <form method="post">
            <div class="mb-3">
                <label for="userId" class="form-label">User ID</label>
                <input type="text" class="form-control" id="userId" name="userId" required>
            </div>
            <button type="submit" name="delete" class="btn btn-danger">Delete User</button>
        </form>
        <p class="mt-3 text-success"><%= message %></p>
    </div>
</body>
</html>
