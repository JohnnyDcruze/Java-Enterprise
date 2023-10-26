<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Deposit Money</title>
</head>
<body>
    <div class="container">
        
        <form action="depositServlet" method="post">
            <label for="amount">Amount to Deposit:</label>
            <input type="number" name="amount" required><br>
            <input type="submit" value="Deposit">
        </form>
    </div>
</body>
</html>
