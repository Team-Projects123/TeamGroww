<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.user.dao.BookDao" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Resources</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/resources.css">
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
    <div class="container mt-5">
        <h1 class="text-center mb-4">Library Resources</h1>
        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>Book ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Genre</th>
                        <th>Publisher</th>
                        <th>ISBN</th>
                        <th>Copies Available</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Connection conn = null;
                        PreparedStatement stmt = null;
                        ResultSet rs = null;

                        try {
                            // Database connection
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "password");

                            // Fetch books data
                            String query = "SELECT * FROM books";
                            stmt = conn.prepareStatement(query);
                            rs = stmt.executeQuery();

                            // Display books in the table
                            while (rs.next()) {
                                int bookId = rs.getInt("book_id");
                                String title = rs.getString("title");
                                String author = rs.getString("author");
                                String genre = rs.getString("genre");
                                String publisher = rs.getString("publisher");
                                String isbn = rs.getString("isbn");
                                int copiesAvailable = rs.getInt("copies_available");
                    %>
                    <tr>
                        <td><%= bookId %></td>
                        <td><%= title %></td>
                        <td><%= author %></td>
                        <td><%= genre %></td>
                        <td><%= publisher %></td>
                        <td><%= isbn %></td>
                        <td><%= copiesAvailable %></td>
                        <td>
                            <%
                                if (copiesAvailable > 0) {
                            %>
                            <form action="issueBook.jsp" method="post" style="display:inline;">
                                <input type="hidden" name="bookId" value="<%= bookId %>">
                                <button type="submit" class="btn btn-primary btn-sm">Issue</button>
                            </form>
                            <%
                                } else {
                            %>
                            <button type="button" class="btn btn-secondary btn-sm" disabled>Unavailable</button>
                            <%
                                }
                            %>
                        </td>
                    </tr>
                    <%
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            if (rs != null) rs.close();
                            if (stmt != null) stmt.close();
                            if (conn != null) conn.close();
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
    <!-- Bootstrap Bundle JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
