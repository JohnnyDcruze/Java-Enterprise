<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Monthly Report</title>
<style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        }
        h2 {
            text-align: center;
            background-color: #002d74;
            color: #fff;
            margin: 0;
            padding: 15px;
        }
        .report-form {
            width: 300px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-label {
            font-weight: bold;
        }
        .form-select {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-submit {
            background-color: #002d74;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
        }
        .report {
            width: 300px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .result {
            font-weight: bold;
        }
</style>
</head>
<body>
<h2>Generate Monthly Report</h2>
<div class="report-form">
<form action="/monthlyReport" method="post">
<label for="selectedMonth" class="form-label">Choose a Month:</label>
<select id="selectedMonth" name="selectedMonth" class="form-select">
<option value="01">January</option>
<option value="02">February</option>
<option value="03">March</option>
<option value="04">April</option>
<option value="05">May</option>
<option value="06">June</option>
<option value="07">July</option>
<option value="08">August</option>
<option value="09">September</option>
<option value="10">October</option>
<option value="11">November</option>
<option value="12">December</option>
</select>
<label for="selectedYear" class="form-label">Choose a Year:</label>
<select id="selectedYear" name="selectedYear" class="form-select">
<c:forEach begin="2020" end="2030" var="year">
<option value="${year}">${year}</option>
</c:forEach>
</select>
<input type="submit" value="Generate Report" class="form-submit">
</form>
</div>
<div class="report">
<p>Selected Month: ${selectedMonth}</p>
<p>Single Journey Count: ${singleJourneyCount}</p>
<p>Return Journey Count: ${returnJourneyCount}</p>
<p class="result">Total Count (including return journeys as 50%): ${totalJourneyCount}</p>
</div>
</body>
</html>