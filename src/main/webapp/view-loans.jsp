<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*, java.util.*" %>
<%
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    // Database connection setup
    String dbURL = "jdbc:mysql://localhost:3306/Library";
    String dbUser = "root"; // Replace with your database username
    String dbPass = "@jayradhekrishna123"; // Replace with your database password

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
    } catch (Exception e) {
        out.println("Database connection error: " + e.getMessage());
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>System Logs</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/viewTable.css">
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
        <h2>System Logs</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Log ID</th>
                    <th>User ID</th>
                    <th>Action</th>
                    <th>Timestamp</th>
                    <th>Details</th>
                </tr>
            </thead>
            <tbody>
                <%
                    try {
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("SELECT log_id, user_id, action, timestamp, details FROM systemlogs");
                        while (rs.next()) {
                %>
                <tr>
                    <td><%= rs.getInt("log_id") %></td>
                    <td><%= rs.getInt("user_id") %></td>
                    <td><%= rs.getString("action") %></td>
                    <td><%= rs.getTimestamp("timestamp") %></td>
                    <td><%= rs.getString("details") %></td>
                </tr>
                <%
                        }
                    } catch (Exception e) {
                        out.println("<tr><td colspan='5'>Error: " + e.getMessage() + "</td></tr>");
                    }
                %>
            </tbody>
        </table>
    </div>

    <% 
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close(); 
    %>
    <script src="js/viewTable.js"></script>
</body>
</html>
