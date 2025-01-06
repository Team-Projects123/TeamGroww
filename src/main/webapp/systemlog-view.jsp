<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>
<%
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    // Database connection setup
    String dbURL = "jdbc:mysql://localhost:3306/Library";
    String dbUser = "root"; // Replace with your database username
    String dbPass = "your_password"; // Replace with your database password

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
    <title>Librarian Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/librarian-dashboard.css">
    
</head>
<body>
    <header>
        <h1>Admin Dashboard</h1>
    </header>
    <nav>
        <a href="#" onclick="showTable('usersTable')">Users</a>
        <a href="#" onclick="showTable('booksTable')">Books</a>
        <a href="#" onclick="showTable('loansTable')">Loans</a>
        <a href="#" onclick="showTable('finesTable')">Fines</a>
        <a href="#" onclick="showTable('reservationsTable')">Reservations</a>
        <a href="#" onclick="showTable('logsTable')">System Logs</a>
    </nav>
    <div class="container">
        <!-- Users Table -->
        

        <!-- System Logs Table -->
        <div id="logsTable" class="table-container hidden">
            <h2>System Logs</h2>
            <table>
                <tr>
                    <th>ID</th>
                    <th>User ID</th>
                    <th>Action</th>
                    <th>Timestamp</th>
                    <th>Details</th>
                </tr>
                <%
                    try {
                        rs = stmt.executeQuery("SELECT * FROM systemlogs");
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
            </table>
        </div>
    </div>
    

    <script src="js/loginValidation.js"></script>
</body>
</html>
