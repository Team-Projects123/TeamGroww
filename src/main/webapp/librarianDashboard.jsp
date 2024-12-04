<%@ page import="java.sql.*" %>
<%@ page import="DBConnection" %>
<%
    String role = (String) session.getAttribute("userRole");
    if (role == null || !"Librarian".equalsIgnoreCase(role)) {
        response.sendRedirect("index2.jsp"); // Redirect to login if not Admin
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1>Admin Dashboard</h1>
        <p>Welcome, Admin. Here are the admin options.</p>
        <!-- Add admin-related options here -->
        <a href="logout.jsp" class="btn btn-danger">Logout</a>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
