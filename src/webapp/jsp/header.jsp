<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="pl">
<head>
    <title>Otomoto page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Otomoto</a>
        </div>
        <c:if test="${sessionScope.user != null}">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">Page 1</a></li>
                <li><a href="#">Page 2</a></li>
                <li><a href="#">Page 3</a></li>
            </ul>
            <div class="navbar-header" style="float: right">
                <div class="navbar-header">
                    <p>Witaj ${user.name} uzytkowniku !</p>
                </div>
                <div class="navbar-header" style="float: right">
                    <div class="navbar-header">
                        <a style="color: #fff" href="/logout">Wyloguj</a>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${sessionScope.user == null}">
            <ul class="nav navbar-nav">
                <li><a href="/register">Register</a></li>
            </ul>
            <div class="navbar-header" style="float: right">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/login">Login</a>
                </div>
            </div>
        </c:if>
    </div>
</nav>


