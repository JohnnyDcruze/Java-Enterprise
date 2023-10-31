<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Remove Train</title>
 
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
 
        h2 {
            background-color: #333;
            color: white;
            padding: 10px;
            text-align: center;
        }
 
        form {
            background-color: white;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: 20px auto;
            max-width: 400px;
        }
 
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
 
        select {
            width: 100%;
            padding: 5px;
            margin-bottom: 20px;
        }
 
        input[type="submit"] {
            background-color: #333;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }
 
        input[type="submit"]:hover {
            background-color: #555;
        }
 
        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <h2>Remove Train</h2>
    <form action="/removeTrain" method="post">
        <label for="selectedTrain">Select a train to remove:</label>
        <select name="selectedTrain" id="selectedTrain">
            <c:forEach items="${trains}" var="train">
                <option value="${train.train_id}">
                    ${train.train_number} - ${train.train_name}
                </option>
            </c:forEach>
        </select>
        <br><br>
        <input type="submit" value="Remove Train">
    </form>
    <br>
    <a href="/dashboard">Return to Dashboard</a>
</body>
</html>