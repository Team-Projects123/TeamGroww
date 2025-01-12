<%@ page import="com.user.dao.UserDao, com.user.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Registration</title>
    <!-- Bootstrap CSS -->
     <link rel="stylesheet" href="register.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: url('img/login.jpeg') no-repeat center center/cover;
        }
    </style>
</head>
<body>
    <div class="container-fluid bg-light min-vh-100 d-flex align-items-center justify-content-center">
        <div class="card shadow-lg p-4" style="max-width: 450px; width: 100%; border-radius: 10px;">
            <h3 class="text-center text-success">Register</h3>
            <p class="text-center text-muted mb-4">Create your Library account</p>
            <%
                try {
                    if (request.getMethod().equalsIgnoreCase("post")) {
                        String name = request.getParameter("name");
                        String email = request.getParameter("email");
                        String phone = request.getParameter("phone");
                        String address = request.getParameter("address");
                        String password = request.getParameter("password");
                        String confirmPassword = request.getParameter("confirmPassword");
                        String role = request.getParameter("role");

                        if (password.equals(confirmPassword)) {
                            User user = new User();
                            user.setName(name);
                            user.setEmail(email);
                            user.setPhone(phone);
                            user.setAddress(address);
                            user.setRole(role);
                            user.setPassword(password);

                            UserDao userDAO = new UserDao();
                            boolean isRegistered = userDAO.insertUser(user);

                            if (isRegistered) {
                                out.println("<div class='alert alert-success'>Registration Successful! <a href='login.jsp'>Login here</a>.</div>");
                            } else {
                                out.println("<div class='alert alert-danger'>Registration Failed. Please try again later.</div>");
                            }
                        } else {
                            out.println("<div class='alert alert-danger'>Passwords do not match. Please try again.</div>");
                        }
                    }
                } catch (Exception e) {
                    out.println("<div class='alert alert-danger'>An unexpected error occurred: " + e.getMessage() + "</div>");
                    e.printStackTrace();
                }
            %>
            <form action="register" id="registerForm" method="post" onsubmit="return validateForm()">
                <div id="error-message" class="alert alert-danger d-none">One or more fields are empty. Please fill out all fields.</div>
                <div class="mb-3">
                    <label for="name" class="form-label">Full Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter your name" required>
                    <div class="invalid-feedback">Name is required.</div>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email Address</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
                    <div class="invalid-feedback">Please enter a valid email.</div>
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">Phone</label>
                    <input type="phone" class="form-control" id="phone" name="phone" placeholder="Enter your phone" required>
                    <div class="invalid-feedback">Please enter a valid phone number.</div>
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Your Address</label>
                    <input type="address" class="form-control" id="address" name="address" placeholder="Enter your address" required>
                    <div class="invalid-feedback">Please enter address.</div>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
                    <div class="invalid-feedback">Password must be at least 8 characters long.</div>
                </div>
                <div class="mb-3">
                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
                    <div class="invalid-feedback">Passwords must match.</div>
                </div>
                <div class="mb-3">
                    <label for="role" class="form-label">Role</label>
                    <select class="form-control" id="role" name="role" required>
                        <option value="">Select Role</option>
                        <option value="Librarian">Librarian</option>
                        <option value="User">User</option>
                    </select>
                    <div class="invalid-feedback">Please select a role.</div>
                </div>
                <button type="submit" class="btn btn-success w-100 mt-3">Register</button>
                <div class="text-center mt-3">
                    <a href="login.jsp" class="text-decoration-none">Already have an account? Login here.</a>
                </div>
            </form>
        </div>
    </div>
    <!-- Bootstrap Bundle JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="js/validation.js"></script>
</body>
</html>
