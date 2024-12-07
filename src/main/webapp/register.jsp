<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Registration</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/register.css">
</head>
<body>
    <!-- Fullscreen Background -->
    <div class="container-fluid bg-light min-vh-100 d-flex align-items-center justify-content-center">
        <div class="card shadow-lg p-4" style="max-width: 450px; width: 100%; border-radius: 10px;">
            <h3 class="text-center text-success">Register</h3>
            <p class="text-center text-muted mb-4">Create your Library account</p>
            <form id="registerForm" novalidate>
                <div id="error-message" class="alert alert-danger d-none">One or more fields are empty. Please fill out all fields.</div>
                <div class="mb-3">
                    <label for="name" class="form-label">Full Name</label>
                    <input type="text" class="form-control" id="name" placeholder="Enter your name" required>
                    <div class="invalid-feedback">Name is required.</div>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email Address</label>
                    <input type="email" class="form-control" id="email" placeholder="Enter your email" required>
                    <div class="invalid-feedback">Please enter a valid email.</div>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" placeholder="Enter your password" required>
                    <div class="invalid-feedback">Password must be at least 8 characters long.</div>
                </div>
                <div class="mb-3">
                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                    <input type="password" class="form-control" id="confirmPassword" required>
                    <div class="invalid-feedback">Passwords must match.</div>
                </div>
                <div class="mb-3">
                    <label for="role" class="form-label">Role</label>
                    <select class="form-control" id="role" required>
                        <option value="">Select Role</option>
                        <option value="admin">Librarian</option>
                        <option value="user">User</option>
                    </select>
                    <div class="invalid-feedback">Please select a role.</div>
                </div>
                <button type="submit" class="btn btn-success w-100 mt-3" onclick="validateForm()">Register</button>
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
