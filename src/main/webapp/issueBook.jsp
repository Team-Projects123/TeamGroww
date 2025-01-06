<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Issue Book</title>
</head>
<body>
<%
    int bookId = Integer.parseInt(request.getParameter("bookId"));
    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        // Database connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "password");

        // Update copies available
        String updateQuery = "UPDATE books SET copies_available = copies_available - 1 WHERE book_id = ?";
        stmt = conn.prepareStatement(updateQuery);
        stmt.setInt(1, bookId);
        int rowsUpdated = stmt.executeUpdate();

        if (rowsUpdated > 0) {
            out.println("<h3>Book issued successfully!</h3>");
        } else {
            out.println("<h3>Failed to issue the book. Please try again.</h3>");
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("<h3>Error occurred while issuing the book.</h3>");
    } finally {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }
%>
<a href="resources.jsp">Back to Resources</a>
</body>
</html>
