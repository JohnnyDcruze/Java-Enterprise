<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Train Schedule</title>
<style>
    body {
        font-family: Arial, sans-serif;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #ddd;
    }
</style>
</head>
<body>
<table>
    <tr>
        <th>Train Number</th>
        <th>Train Name</th>
        <th>Start Point</th>
        <th>End Point</th>
        <th>Departure Time</th>
    </tr>
    <c:forEach items="${trains}" var="train">
        <tr>
            <td>${train.train_number}</td>
            <td>${train.train_name}</td>
            <td>${train.start_point}</td>
            <td>${train.end_point}</td>
            <td>${train.departure_time}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
