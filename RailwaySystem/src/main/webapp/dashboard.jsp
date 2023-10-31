<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Railway Dashboard</title>
    <style>
        /* Style for the navigation bar */
        .navbar {
            background-color: #333;
            display: flex;
            padding: 10px 0;
            justify-content: space-around; /* Center-align links */
            position: relative;
            z-index: 2; /* Ensure the navbar is above the background image */
        }
        .navbar a {
            color: #fff;
            text-decoration: none;
            padding: 10px 20px;
            transition: background-color 0.3s;
            border-radius: 5px;
        }
        .navbar a:hover {
            background-color: #007BFF; /* Dark blue on hover */
        }
        
        /* Style for the ticket booking form */
        .ticket-form {
            background-color: #f5f5f5; /* Light gray background */
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 300px;
            padding: 20px;
            float: right; /* Position to the right */
            margin: 20px;
            margin-top: 25px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Add a subtle shadow effect */
            position: relative;
            z-index: 2; /* Ensure the form is above the background image */
        }
        .ticket-form h2 {
            font-size: 1.5em;
            margin-bottom: 20px;
        }
        .ticket-form label {
            display: block;
            font-weight: bold;
        }
        .ticket-form input[type="text"],
        .ticket-form input[type="date"],
        .ticket-form select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }
        .ticket-form select {
            height: 38px;
        }
        .ticket-form input[type="submit"] {
            background-color: #007BFF; /* Blue submit button */
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s;
            float: right;
        }
        .ticket-form input[type="submit"]:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }

        /* Style for the background image */
        body {
            background-image: url('images/train.jpg'); /* Update with your image URL or local path */
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a href="/addTrain">Add Train</a>
        <a href="/removeTrain">Remove Train</a>
        <a href="/dailyReport">Daily Report</a>
        <a href="/monthlyReport">Monthly Report</a>
        <a href="/train">Schedule</a>
    </div>

    <div class="ticket-form">
        <h2>Ticket Booking</h2>
        <form action="/ticketBooking" method="post">


			<label for="fromLocation">From:</label> 
			<select id="fromLocation" name="fromLocation" required>
			<c:forEach items="${fromTrains}" var="train">
                <option value="${train.name}">
                    ${train.name}
                </option>
            </c:forEach>
			</select> 
			<label for="toLocation">To:</label> 
			<select id="toLocation" name="toLocation" required>
			<c:forEach items="${toTrains}" var="train">
                <option value="${train.name}">
                    ${train.name}
                </option>
            </c:forEach>
			</select> 

            <label for="travelDate">Date:</label>
            <input type="date" id="date" name="date" min="<%= java.time.LocalDate.now() %>" required>

            <label for="travelClass">Class:</label>
            <select id="travelClass" name="travelClass">
                <option value="Economy">Economy</option>
                <option value="Business">Business</option>
            </select>

 			<label for="Journey">Journey Type:</label>
   			<select id="Journey" name="Journey" required>
     	 	   <option value="single">single</option>
     	  	  <option value="return">return</option>
  			</select>
            <input type="submit" value="Book Ticket">
        </form>
    </div>
</body>
</html>
