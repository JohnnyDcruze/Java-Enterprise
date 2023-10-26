<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>y
</head>
<body>
    <h2>Welcome, <%= request.getParameter("userID") %></h2>
    
    <ul>
        <li><a href="withdraw.jsp">1. Withdraw</a></li>
        <li><a href="deposit.jsp">2. Deposit</a></li>
        <li><a href="fundtransfer.jsp">3. Fund Transfer</a></li>
        <li><a href="balance.jsp">4. Balance Check</a></li>
    </ul>

    <form action="LogoutServlet" method="post">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
