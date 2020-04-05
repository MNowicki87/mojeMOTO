<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!doctype html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Car registration service</title>
</head>
<body>

    <h1>Register a car</h1>

    <form method="post" action="car.jsp">
        <label>Marka</label>
        <input type="text" id="make" name="make"><br>

        <label>Model</label>
        <input type="text" name="model"><br>

        <label>Silnik</label>
        <input type="text" name="engine"><br>

        <label>Silnik</label>
        <input type="text" name="country"><br>

        <label>Rok</label>
        <input type="text" name="year"><br>

        <label>Przebieg</label>
        <input type="text" name="mileage"><br>
        <input type="submit">
    </form>

</body>
</html>