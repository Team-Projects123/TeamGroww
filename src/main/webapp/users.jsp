<%@ page import="java.sql.*" %>
<%@ page import="DBConnection" %>
<%
    String action = request.getParameter("action");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String name = request.getParameter("name");
    String role = request.getParameter("role");

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    // Handle login action
    if ("login".equals(action)) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM users WHERE email='" + email + "' AND password='" + password + "'";
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                String userRole = rs.getString("u_role");
                session.setAttribute("userRole", userRole);
                session.setAttribute("userEmail", email);
                if ("Librarian".equals(userRole)) {
                    response.sendRedirect("adminDashboard.jsp");  // Redirect to admin dashboard
                } else {
                    response.sendRedirect("userDashboard.jsp");  // Redirect to user dashboard
                }
            } else {
                out.println("<p>Invalid credentials</p>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }

    // Handle registration action
    if ("register".equals(action)) {
        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            String insertQuery = "INSERT INTO users (u_name, email, password, u_role) VALUES ('" + name + "', '" + email + "', '" + password + "', '" + role + "')";
            int rowsAffected = stmt.executeUpdate(insertQuery);
            if (rowsAffected > 0) {
                out.println("<p>Registration successful. Please <a href='index.jsp'>Login</a></p>");
            } else {
                out.println("<p>Registration failed. Try again.</p>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }
%>
