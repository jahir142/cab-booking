<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cab Book</title>
<link rel="Stylesheet" href="style.css">
</head>
<body class="book" style="text-align:center; font-family: Arial;">
    <h2>Cab Booking Form</h2>

    <form action="BookCabServlet" method="post">
        <label>Name:</label><br>
        <input type="text" name="name" required><br><br>

        <label>Phone:</label><br>
        <input type="text" name="phone" required><br><br>

        <label>Pickup Location:</label><br>
        <input type="text" name="pickup" required><br><br>

        <label>Drop Location:</label><br>
        <input type="text" name="drop" required><br><br>

        <button type="submit">Submit Booking</button>
    </form>
</body>
</html>