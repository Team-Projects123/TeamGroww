<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.user.dao.LoanDao" %>
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
    <div class="container">
        <!-- Loans Table -->
        <div id="loansTable" class="table-container hidden">
            <h2>Loans</h2>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Book ID</th>
                    <th>User ID</th>
                    <th>Issue Date</th>
                    <th>Due Date</th>
                    <th>Return Date</th>
                </tr>
                <%
                    try {
                        rs = stmt.executeQuery("SELECT * FROM loans");
                        while (rs.next()) {
                %>
                <tr>
                    <td><%= rs.getInt("loan_id") %></td>
                    <td><%= rs.getInt("book_id") %></td>
                    <td><%= rs.getInt("user_id") %></td>
                    <td><%= rs.getDate("issue_date") %></td>
                    <td><%= rs.getDate("due_date") %></td>
                    <td><%= rs.getDate("return_date") %></td>
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
