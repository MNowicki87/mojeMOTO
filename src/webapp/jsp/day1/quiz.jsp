<%@ page language="java" contentType="text/html" %>

<html>
<head>
    <title>Quiz</title>
</head>
<body>
<h1>
    First Question:
</h1>
<p>What is the capital of Spain?</p><br/>
<form method="post" action="/quiz">
    <label>
        <input type="radio" name="answer" value="Barcelona">
        Barcelona
    </label><br/>
    <label>
        <input type="radio" name="answer" value="Toledo">
        Toledo
    </label><br/>
    <label>
        <input type="radio" name="answer" value="Madrid">
        Madrid
    </label><br/>
    <br/>
    <input type="submit" value="Send">
</form>
</body>
</html>