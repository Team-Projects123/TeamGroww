<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=\, initial-scale=1.0">
    <title>Library Management System | E-Library.com</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <link rel="stylesheet" href="css/styles.css">
    <style>
        .contains {
            background: url('img/lib.jpg')no-repeat center center/cover;
            width: 100%;
            height: 75vh;
            color: white;
        }
    </style>
</head>

<body>
    <header>
        <div class="left">
            <img src="img/logo.jpeg" alt="E-Library.com">
            <div>LMS</div>
        </div>
        <div class="mid">
            <ul class="navbar">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="resources.jsp">Resources</a></li>
                <li><a href="#">Contact Us</a></li>
            </ul>
        </div>
        <div class="right">
            <li><a href="register.jsp" ><button class="btn">Sign Up</button></a></li>
            <li><a href="login.jsp"  ><button class="btn">Sign In</button></a></li>
        </div>
    </header>

    <div class="contains">
        <p class="content1">Welcome</p>
        <p class="content2">to</p>
        <p class="content3">Indian Library</p>
    </div>
    

    <footer>
        <p>Copyright &#169; 2024. All Rights Reserved.</p>
        <p>For other queries, please contact us.</p>
    </footer>
</body>

</html>