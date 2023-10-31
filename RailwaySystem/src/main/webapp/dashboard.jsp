<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Railway Dashboard</title>
    <style>
        .button-container {
            text-align: center;
            margin-top: 20px;
        }
        .button-container button {
            display: inline-block;
            margin: 5px;
        }
    </style>
</head>
<body>
    <h2>Dashboard Home Page</h2>
    <h2>Welcome to the Railway System</h2>
    
    <div class="button-container">
        <button onclick="location.href='/addTrain'">Add Train</button>
        <button onclick="location.href='/removeTrain'">Remove Train</button><br>
        <button onclick="location.href='/ticketBooking'">Ticket Booking</button>
        <button onclick="location.href='/monthlyReport'">Monthly Report</button><br>
        <button onclick="location.href='/schedule'">Schedule</button>
    </div>
</body>
</html>
