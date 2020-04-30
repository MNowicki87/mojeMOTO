<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>mojeMOTO</title>
    <base href="http://localhost:8080/">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/material-design-icons/3.0.1/iconfont/material-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <style>
        .footer-basic {
            padding: 40px 0;
            background-color: #ffffff;
            color: #4b4c4d;
        }

        .footer-basic ul {
            padding: 0;
            list-style: none;
            text-align: center;
            font-size: 18px;
            line-height: 1.6;
            margin-bottom: 0;
        }

        .footer-basic li {
            padding: 0 10px;
        }

        .footer-basic ul a {
            color: inherit;
            text-decoration: none;
            opacity: 0.8;
        }

        .footer-basic ul a:hover {
            opacity: 1;
        }

        .footer-basic .social {
            text-align: center;
            padding-bottom: 25px;
        }

        .footer-basic .social > a {
            font-size: 24px;
            width: 40px;
            height: 40px;
            line-height: 40px;
            display: inline-block;
            text-align: center;
            border-radius: 50%;
            border: 1px solid #ccc;
            margin: 0 8px;
            color: inherit;
            opacity: 0.75;
        }

        .footer-basic .social > a:hover {
            opacity: 0.9;
        }

        .footer-basic .copyright {
            margin-top: 15px;
            text-align: center;
            font-size: 13px;
            color: #aaa;
            margin-bottom: 0;
        }

        .navigation-clean-button {
            background: #fff;
            padding-top: .75rem;
            padding-bottom: .75rem;
            color: #333;
            border-radius: 0;
            box-shadow: none;
            border: none;
            margin-bottom: 0;
        }

        @media (min-width: 768px) {
            .navigation-clean-button {
                padding-top: 1rem;
                padding-bottom: 1rem;
            }
        }

        .navigation-clean-button .navbar-brand {
            font-weight: bold;
            color: inherit;
        }

        .navigation-clean-button .navbar-brand:hover {
            color: #222;
        }

        .navigation-clean-button .navbar-toggler {
            border-color: #ddd;
        }

        .navigation-clean-button .navbar-toggler:hover,
        .navigation-clean-button .navbar-toggler:focus {
            background: none;
        }

        .navigation-clean-button .navbar-toggler {
            color: #888;
        }

        .navigation-clean-button .navbar-collapse,
        .navigation-clean-button .form-inline {
            border-top-color: #ddd;
        }

        .navigation-clean-button .navbar-nav a.active,
        .navigation-clean-button .navbar-nav > .show > a {
            background: none;
            box-shadow: none;
        }

        .navigation-clean-button.navbar-light .navbar-nav a.active,
        .navigation-clean-button.navbar-light .navbar-nav a.active:focus,
        .navigation-clean-button.navbar-light .navbar-nav a.active:hover {
            color: #8f8f8f;
            box-shadow: none;
            background: none;
            pointer-events: none;
        }

        .navigation-clean-button.navbar .navbar-nav .nav-link {
            padding-left: 18px;
            padding-right: 18px;
        }

        .navigation-clean-button.navbar-light .navbar-nav .nav-link {
            color: #465765;
        }

        .navigation-clean-button.navbar-light .navbar-nav .nav-link:focus,
        .navigation-clean-button.navbar-light .navbar-nav .nav-link:hover {
            color: #37434d !important;
            background-color: transparent;
        }

        .navigation-clean-button .navbar-nav > li > .dropdown-menu {
            margin-top: -5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, .1);
            background-color: #fff;
            border-radius: 2px;
        }

        .navigation-clean-button .dropdown-menu .dropdown-item:focus,
        .navigation-clean-button .dropdown-menu .dropdown-item {
            line-height: 2;
            font-size: 14px;
            color: #37434d;
        }

        .navigation-clean-button .dropdown-menu .dropdown-item:focus,
        .navigation-clean-button .dropdown-menu .dropdown-item:hover {
            background: #eee;
            color: inherit;
        }

        .navigation-clean-button .actions .login {
            margin-right: 1rem;
            text-decoration: none;
            color: #465765;
        }

        .navigation-clean-button .navbar-text .action-button,
        .navigation-clean-button .navbar-text .action-button:active,
        .navigation-clean-button .navbar-text .action-button:hover {
            background: #56c6c6;
            border-radius: 20px;
            font-size: inherit;
            color: #fff;
            box-shadow: none;
            border: none;
            text-shadow: none;
            padding: .5rem 1rem;
            transition: background-color 0.25s;
            font-size: inherit;
        }

        .register-photo {
            background: #f1f7fc;
            padding: 80px 0;
        }

        .register-photo .image-holder {
            display: table-cell;
            width: auto;
            background: url(../../assets/img/meeting.jpg);
            background-size: cover;
        }

        .register-photo .form-container {
            display: table;
            max-width: 900px;
            width: 90%;
            margin: 0 auto;
            box-shadow: 1px 1px 5px rgba(0, 0, 0, 0.1);
        }

        .register-photo form {
            display: table-cell;
            width: 400px;
            background-color: #ffffff;
            padding: 40px 60px;
            color: #505e6c;
        }

        @media (max-width: 991px) {
            .register-photo form {
                padding: 40px;
            }
        }

        .register-photo form h2 {
            font-size: 24px;
            line-height: 1.5;
            margin-bottom: 30px;
        }

        .register-photo form .form-control {
            background: #f7f9fc;
            border: none;
            border-bottom: 1px solid #dfe7f1;
            border-radius: 0;
            box-shadow: none;
            outline: none;
            color: inherit;
            text-indent: 6px;
            height: 40px;
        }

        .register-photo form .form-check {
            font-size: 13px;
            line-height: 20px;
        }

        .register-photo form .btn-primary {
            background: #f4476b;
            border: none;
            border-radius: 4px;
            padding: 11px;
            box-shadow: none;
            margin-top: 35px;
            text-shadow: none;
            outline: none !important;
        }

        .register-photo form .btn-primary:hover, .register-photo form .btn-primary:active {
            background: #eb3b60;
        }

        .register-photo form .btn-primary:active {
            transform: translateY(1px);
        }

        .register-photo form .already {
            display: block;
            text-align: center;
            font-size: 12px;
            color: #6f7a85;
            opacity: 0.9;
            text-decoration: none;
        }

        .card-img-top {
            object-fit: cover;
            height: 150px;
        }

        .navigation-clean-button .navbar-text .action-button:hover {
            background: #66d7d7;
        }

        .jumbotron {
            background-image: url(https://images.unsplash.com/photo-1520340356584-f9917d1eea6f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1489&q=80);
            background-size: cover;
            background-position: center;
        }

        .jumbo-inner-box {
            background-color: rgba(0, 0, 0, 0.8);
            padding: 40px 6vw;
            color: #fff;
        }

        .jumbo-inner-box p {
            margin-bottom: 3rem;
        }

        .card-body {
            padding: 0;
        }

        .card-body .d-block,
        .card-body .d-flex {
            padding: 0 10px;
        }

        .card-img-top {
            margin-bottom: 15px;
        }

        .card {
            min-width: 100%;
        }

        input.w-50 {
            min-width: 60px;
        }

        .custom-switch .custom-control-label::after {
            border-color: #1579f6;
        }
        .custom-control-label::before{
            border-color: #1579f6;
        }



    </style>
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
                        <c:if test="${sessionScope.user.admin}">
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