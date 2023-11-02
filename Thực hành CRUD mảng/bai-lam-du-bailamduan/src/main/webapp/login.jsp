<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <style>
        body {
            padding: 40px;
        }

        .form-container {
            max-width: 400px;
            margin: 0 auto;
        }

        .form-container h1 {
            text-align: center;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h1>Login</h1>
    <form action="login" method="post">
        <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" id="email" name="email" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Password:</label>
            <input type="password" id="password" name="password" class="form-control" required>
        </div>

        <div class="d-grid">
            <input type="submit" value="Login" class="btn btn-primary">
        </div>
    </form>
</div>

<script src="js/bootstrap.min.js"></script>
</body>
</html>