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
    	body{
    		background: url('img/login.jpeg')no-repeat center center/cover;
    	}
    </style>
</head>
<body>
    <div class="container min-vh-100 d-flex align-items-center justify-content-center">
        <div class="row">
            <!-- Librarian Login Block -->
            <div class="col-md-6 mb-4">
                <div class="card text-center shadow-lg p-4">
                    <h3 class="text-primary">Librarian Login</h3>
                    <p class="text-muted">Log in as Librarian to manage the library system.</p>
                    <a href="librarianLogin.jsp" class="btn btn-primary w-100">Login as Librarian</a>
                </div>
            </div>
            <!-- User Login Block -->
            <div class="col-md-6 mb-4">
                <div class="card text-center shadow-lg p-4">
                    <h3 class="text-success">User Login</h3>
                    <p class="text-muted">Log in as User to access your library account.</p>
                    <a href="userLogin.jsp" class="btn btn-success w-100">Login as User</a>
                </div>
            </div>
        </div>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
