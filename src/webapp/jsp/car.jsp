<%@ page language="java" contentType="text/html" %>

<html>
<head>
    <title>City page</title>
</head>

<body>
<h1> Car form </h1>

<form method="post" action="/car">
    <p>Choose a company !</p>
    <input type="text" name="company">
    <p>Choose a model !</p>
    <input type="text" name="model">
    <p>Choose a year !</p>
    <input type="text" name="year">
    <p>Choose an engine !</p>
    <input type="number" name="engine">
    <p>Choose a mileage !</p>
    <input type="number" name="mileage">
    <p>Choose a country !</p>
    <input type="text" name="country">

    <br><br>
    <input type="submit">
</form>
</body>