<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.time.LocalDateTime" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>mojeMOTO</title>
<%--    <base href="http://localhost:8080/">--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/material-design-icons/3.0.1/iconfont/material-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <jsp:include page="style.jsp"/>
</head>

<body>
<div>
    <nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
        <div class="container"><a class="navbar-brand" href="home">mojeMOTO</a>
            <button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span
                    class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse"
                 id="navcol-1">
                <c:if test="${sessionScope.user != null}">
                    <ul class="nav navbar-nav mr-auto">
                        <li class="nav-item" role="presentation">
                            <a class="nav-link" href="panel/list">Ogłoszenia</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="dropdown-toggle nav-link" data-toggle="dropdown"
                               aria-expanded="false">
                                Moje ogłoszenia
                            </a>
                            <div class="dropdown-menu" role="menu">
                                <a class="dropdown-item" role="presentation" href="panel/myads">
                                    Pokaż moje ogłoszenia
                                </a>
                                <a class="dropdown-item" role="presentation" href="panel/add">
                                    Dodaj nowe ogłoszenie
                                </a>
                            </div>
                        </li>
                        <c:if test="${sessionScope.user.userRole eq 'ADMIN'}">
                            <li class="nav-item" role="presentation">
                                <a class="nav-link" href="admin/users">Użytkownicy</a>
                            </li>
                        </c:if>
                    </ul>
                </c:if>
                <c:if test="${sessionScope.user == null}">
                <span class="navbar-text actions ml-auto">
                    <a href="login" class="login align-middle">
                        Zaloguj
                    </a>
                    <a class="btn btn-light action-button" role="button" href="register">
                        Zarejestruj
                    </a>
                </span>
                </c:if>
                <c:if test="${sessionScope.user != null}">
                    <span class="navbar-text actions">
                    <span class="navbar-text align-middle mr-2">Witaj, ${sessionScope.user.name}!</span>
                    <a class="btn btn-outline-danger action-button" role="button" href="logout">
                        Wyloguj
                    </a>
                </span>
                </c:if>
            </div>
        </div>
    </nav>
</div>