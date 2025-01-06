<%@ page import="com.user.dao.UserDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/login.css">
    <style>
        body {
            background: url('img/login.jpeg') no-repeat center center/cover;
        }
    </style>
</head>
<body>
    <div class="container min-vh-100 d-flex align-items-center justify-content-center">
        <div class="row w-100">
            <!-- Login Form -->
            <div class="col-md-6 offset-md-3">
                <div class="card shadow-lg p-4">
                    <h3 class="text-center text-primary">Library Login</h3>
                    <p class="text-center text-muted">Log in to access your library account</p>
                    <%
                        if (request.getMethod().equalsIgnoreCase("post")) {
                            String email = request.getParameter("email");
                            String password = request.getParameter("password");
                            String role = request.getParameter("role");

                            UserDao userDAO = new UserDao();
                            boolean isValidUser = userDAO.loginUser(email, password, role);

                            if (isValidUser) {
                                if (role.equals("Librarian")) {
                                    response.sendRedirect("librarianDashboard.jsp");
                                } else {
                                    response.sendRedirect("userDashboard.jsp");
                                }
                            } else {
                                out.println("<div class='alert alert-danger text-center'>Invalid Login Credentials!</div>");
                            }
                        }
                    %>
                    <form method="post" class="needs-validation" novalidate>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email Address</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
                            <div class="invalid-feedback">Please enter a valid email.</div>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
                            <div class="invalid-feedback">Password is required.</div>
                        </div>
                        <div class="mb-3">
                            <label for="role" class="form-label">Role</label>
                            <select class="form-control" id="role" name="role" required>
                                <option value="User">User</option>
                                
                            </select>
                            <div class="invalid-feedback">Please select a role.</div>
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Login</button>
                    </form>
                    <div class="text-center mt-3">
                        <a href="register.jsp" class="text-decoration-none">Don't have an account? Register here.</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
     <script src="js/loginValidation.js"></script>
</body>
</html>
