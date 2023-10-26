<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Withdraw</title>
</head>
<body>
    <h2>Withdraw Money</h2>
    <form action="withdrawServlet" method="post">
        <label for="amount">Enter Amount:</label>
        <input type="number" id="amount" name="amount" required><br>
        <input type="submit" value="Withdraw">
    </form>
    <a href="welcome.jsp">Back to Welcome</a>
</body>
</html>
