<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Train</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background: linear-gradient(to bottom, #FAD02E, #FF6B6B); /* Gradient background */
        }
        form {
            background: #fff;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
            width: 300px;
            margin-top: -50px;
        }
        h2 {
            text-align: center;
            color: #fff; /* Heading text color */
            background: #3498db; /* Heading background color */
            padding: 10px;
            border-radius: 10px 10px 0 0;
            margin: 0;
        }
        label, input {
            display: block;
            margin: 15px 0;
            color: #333;
        }
        label {
            font-weight: bold;
        }
        input[type="text"], input[type="time"] {
            width: 80%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="text"]:focus, input[type="time"]:focus {
            border-color: #3498db;
        }
        input[type="submit"] {
            background: #3498db; /* Button background color */
            color: #fff; /* Button text color */
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background: #2980b9; /* Darker button color on hover */
        }
    </style>
</head>
<body>
   
    <form action="/addTrain" method="post">
        <label for="trainNumber">Train Number:</label>
        <input type="text" id="train_number" name="train_number" placeholder="TRN001" required>
 
        <label for="trainName">Train Name:</label>
        <input type="text" id="train_name" name="train_name" placeholder="Local Train 1" required>
 
        <label for="startPoint">Start Point:</label>
        <input type="text" id="start_point" name="start_point" placeholder="Chennai" required>
 
        <label for="endPoint">End Point:</label>
        <input type="text" id="end_point" name="end_point" placeholder="Arakonam" required>
 
        <label for="departureTime">Departure Time:</label>
        <input type="time" id="departure_time" name="departure_time" required>
 
        <input type="submit" value="Add Train">
    </form>
</body>
</html>
