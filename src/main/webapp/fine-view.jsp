<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.user.dao.FineDao" %>
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
       
        <!-- Fines Table -->
        <div id="finesTable" class="table-container hidden">
            <h2>Fines</h2>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Loan ID</th>
                    <th>User ID</th>
                    <th>Amount</th>
                    <th>Paid</th>
                    <th>Payment Date</th>
                </tr>
                <%
                    try {
                        rs = stmt.executeQuery("SELECT * FROM fines");
                        while (rs.next()) {
                %>
                <tr>
                    <td><%= rs.getInt("fine_id") %></td>
                    <td><%= rs.getInt("loan_id") %></td>
                    <td><%= rs.getInt("user_id") %></td>
                    <td><%= rs.getBigDecimal("fine_amount") %></td>
                    <td><%= rs.getBoolean("paid_status") ? "Yes" : "No" %></td>
                    <td><%= rs.getDate("payment_date") %></td>
                </tr>
                <%
                        }
                    } catch (Exception e) {
                        out.println("<tr><td colspan='6'>Error: " + e.getMessage() + "</td></tr>");
                    }
                %>
            </table>
        </div>
    </div>
       
    <script src="js/loginValidation.js"></script>
</body>
</html>
