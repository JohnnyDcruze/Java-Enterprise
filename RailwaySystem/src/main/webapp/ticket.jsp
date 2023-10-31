<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Indian Railway Ticket</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: blue;
        }
        h2 {
            text-align: center;
            background-color: #002d74;
            color: #fff;
            margin: 0;
            padding: 10px;
        }
        .ticket {
            width: 300px;
            margin: 0 auto;
            border: 1px solid #000;
            padding: 10px;
        }
        p {
            margin: 5px 0;
        }
        .from-to {
            background-color: #002d74;
            color: #fff;
            padding: 5px;
        }
        .class {
            text-align: center;
            font-size: 18px;
            background-color: #002d74;
            color: #fff;
            margin: 0;
            padding: 5px;
        }
    </style>
</head>
<body>
    <h2>Your Indian Railway Ticket</h2>
    <div class="ticket">
        <p class="from-to">From: ${ticketBooking.fromLocation}</p>
        <p class="from-to">To: ${ticketBooking.toLocation}</p>
        <p>Date: ${ticketBooking.travelDate}</p>
        <p class="class">Class: ${ticketBooking.travelClass}</p>
    </div>
</body>
</html>
