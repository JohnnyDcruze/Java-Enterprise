<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Daily Report</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            color: #333;
        }
        h2 {
            text-align: center;
            background-color: #002d74;
            color: #fff;
            margin: 0;
            padding: 10px;
        }
        form {
            width: 300px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border: 2px solid #002d74;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }
        label {
            display: block;
            font-size: 18px;
            margin-bottom: 10px;
        }
        input[type="date"] {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 20px;
        }
        input[type="submit"] {
            background-color: #002d74;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #001f4c;
        }
        .report {
            width: 300px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border: 2px solid #002d74;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }
        p {
            font-size: 18px;
            margin: 5px 0;
        }
        a {
            text-decoration: none;
            color: #002d74;
        }
    </style>
</head>
<body>
    <h2>Select a Date</h2>

    <form action="/dailyReport" method="post">
        <label for="selectedDate">Choose a Date:</label>
        <input type="date" id="selectedDate" name="selectedDate">
        <input type="submit" value="Generate Report">
    </form>
    <div class="report">
        <h2>Daily Report</h2>

        <p>Selected Date: ${selectedDate}</p>

        <p>Single Journey Count: ${singleJourneyCount}</p>
        <p>Return Journey Count: ${returnJourneyCount}</p>
        <p>Total Count (including return journeys as 50%): ${TotalJourneyCount}</p>

        <p><a href="/">Back to Home</a></p>
    </div>
</body>
</html>
