<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<c:if test="${not empty requestScope.loginExists}">
    Login : ${requestScope.loginExists} already exists in system!
</c:if>

<div class="container">
    <form action="/register" method="post">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text"  id="name" class="form-control" placeholder="Enter name" name="name">
        </div>
        <div class="form-group">
            <label for="surname">Surname:</label>
            <input type="text" id="surname" class="form-control" placeholder="Enter surname" name="surname">
        </div>
        <div class="form-group">
            <label for="login">Login:</label>
            <input type="text" class="form-control" id="login" placeholder="Enter login" name="login">
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>
<jsp:include page="footer.jsp"/>