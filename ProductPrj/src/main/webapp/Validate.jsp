<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <title>Validate Admin and User</title>
</head>
<body>

<%
  // Get the username and password from the request.
  String username = request.getParameter("username");
  String password = request.getParameter("password");

  // Validate the username and password.
  boolean isAdmin = username.equals("admin") && password.equals("password");
  boolean isUser = username.equals("user") && password.equals("password");

  // If the user is an admin, display an admin message.
  if (isAdmin) {
    response.sendRedirect("admin.html");
  } else if (isUser) {
	  response.sendRedirect("UserServlet");

  } else {
%>
    <h1>Invalid username or password.</h1>
<%
  }
%>

</body>
</html>
