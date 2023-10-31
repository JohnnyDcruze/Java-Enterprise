<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ticket Booking</title>
</head>
<body>
    <h2>Ticket Booking</h2>
    <form action="/ticketBooking" method="post">
        <label for="fromLocation">From:</label>
        <input type="text" id="fromLocation" name="fromLocation" required><br>

        <label for="toLocation">To:</label>
        <input type="text" id="toLocation" name="toLocation" required><br>

        <label for="travelDate">Date:</label>
        <input type="date" id="date" name="date" min="<%= java.time.LocalDate.now() %>" required>

        <label for="travelClass">Class:</label>
        <select id="travelClass" name="travelClass">
            <option value="Economy">Economy</option>
            <option value="Business">Business</option>
        </select><br>

        <input type="submit" value="Book Ticket">
    </form>
</body>
</html>
