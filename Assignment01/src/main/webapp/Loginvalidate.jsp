<%@page import="db.demo.UserValidate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 	
<%@ include file="header.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validate Login</title>
</head>
<body>
<%
String user=request.getParameter("uname");
String password=request.getParameter("pass");
UserValidate validate=new UserValidate();
if(validate.isValidUser(user, password)) {
	session.setAttribute("user", user);
	%>
	   
	<h2>Welcome to <%=user%></h2><br/>
	<jsp:include page="welcome.jsp" >
	<jsp:param value="<%=user %>" name="user"/>
	</jsp:include>
	<a href='Home.jsp'>Click to home page</a>
	<%
	}
else{
	%>
	<h3 style="color:red">Invalid credentials </h3>
	<a href="Login.html">Click re-login</a>
	<%
	}%>
</body>
</html>