<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Register</title>
</head>
<body>

 
        <h1>Create a Bank Account</h1>
        <form action="RegisterServlet" method="post">
            <label for="userId">User ID:</label>
            <input type="text" name="userId" required><br>
            <label for="userName">User Name:</label>
            <input type="text" name="userName" required><br>
            <label for="password">Password:</label>
            <input type="password" name="password" required><br>
            <input type="submit" value="Register">
        </form>
</body>
</html>

