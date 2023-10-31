<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Train Added</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            margin: 0;
            padding: 0;
        }
 
        h2 {
            color: #333;
        }
 
        ul {
            list-style: none;
            padding: 0;
        }
 
        li {
            background-color: #fff;
            margin: 10px;
            padding: 10px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
            display: inline-block;
        }
 
        a {
            text-decoration: none;
            color: #007bff;
        }
 
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>Train Added Successfully</h2>
    <p>The following train has been added to the database:</p>
    <ul>
        <li>Train Number: ${train.trainNumber}</li>
        <li>Train Name: ${train.trainName}</li>
        <li>End Point: ${train.endPoint}</li>
        <li>End Point: ${train.startPoint}</li>
        <li>Departure Time: ${train.departureTime}</li>
    </ul>
    
    <a href="/dashboard">Return to Dashboard</a>
</body>
</html>
 