<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Railway Login Interface</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #fcff4b, #adff2f);
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }

    .login-container {
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        padding: 20px;
        width: 300px;
        text-align: center;
    }

    h2 {
        color: #333;
    }

    input[type="text"],
    input[type="password"] {
        width: 80%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    input[type="submit"] {
        background-color: #007bff;
        color: #fff;
        padding: 12px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>

</head>
<body>
<div class="login-container">
    <h2>Admin Login Page</h2>
    <form action="/login" method="post">
        <label for="user">Admin Name</label>
        <input type="text" id="user" name="user" required>

        <label for="pass">Password</label>
        <input type="password" id="pass" name="pass" required>

        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>
