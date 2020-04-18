<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<c:if test="${not empty requestScope.loginExists}">
    Login : ${requestScope.loginExists} already exists in system!
</c:if>

<div class="register-photo">
    <div class="form-container">
        <div class="image-holder"
             style="background-image: url(&quot;http://www.banktapet.pl/pictures/2016/0716/1/classic-kool-nice-car-pics-583905.jpg&quot;);background-position: center;"></div>
        <form action="/register" method="post">
            <h2 class="text-center"><strong>Utwórz konto</strong></h2>
            <div class="form-group">
                <input class="form-control" type="text" name="name" required placeholder="Imię"
                       minlength="2">
            </div>
            <div class="form-group">
                <input class="form-control" type="text" name="surname" placeholder="Nazwisko">
            </div>
            <div class="form-group">
                <input class="form-control" type="text" name="login" required="" placeholder="Login"
                       minlength="4">
            </div>
            <div class="form-group">
                <input class="form-control" type="password" name="pwd" required=""
                       placeholder="Hasło" minlength="2">
            </div>
            <div class="form-group">
                <button class="btn btn-primary btn-block" type="submit">
                    Zarejestruj
                </button>
            </div>
            <a href="/login" class="already">Masz już konto? Zaloguj się tutaj.</a></form>
        </form>
    </div>
</div>
<jsp:include page="footer.jsp"/>