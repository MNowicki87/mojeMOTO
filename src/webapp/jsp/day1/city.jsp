<%@ page language="java" contentType="text/html, charset=UTF-8"%>

<html>
<head>
    <title>City page</title>
</head>

<body>

<h1>Hey! Choose city and we'll tell you what you should say to a Polish football fan :-)</h1>

<form method="post" action="/city">
    <p>Choose city</p>
    <select name="city" size="1">
        <option>Warszawa</option>
        <option>Lodz</option>
        <option>Gdansk</option>
        <option>Chorzow</option>
    </select>
    <br/>
    <input type="submit"/>
</form>

</body>

</html>