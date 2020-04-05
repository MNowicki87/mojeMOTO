<%@ page language="java" contentType="text/html" %>

<html>
<head>
    <title>City page</title>
</head>

<body>
<h1> Hey please choose a city and we will tell You what You should say to polish football fan :) </h1>

<form method="post" action="/city">
    <p>Choose a city !</p>
    <select name="city" size="1">
        <option>Warszawa</option>
        <option>Lodz</option>
        <option>Gdansk</option>
        <option>Chorzow</option>
    </select>
    <br><br>
    <input type="submit">
</form>
</body>