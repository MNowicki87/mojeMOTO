<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>


<div class="register-photo">
    <div class="form-container">
        <div class="image-holder"
             style="background-image: url(&quot;http://www.banktapet.pl/pictures/2016/0716/1/classic-kool-nice-car-pics-583905.jpg&quot;);background-position: center;"></div>
        <form action="login" method="post">
            <h2 class="text-center"><strong>Zaloguj się</strong></h2>
            <div class="form-group"><input class="form-control" type="text" name="login" autofocus required
                                           placeholder="Login" minlength="4"></div>
            <div class="form-group"><input class="form-control" type="password" name="pwd" required
                                           placeholder="Hasło" minlength="2"></div>
            <div class="form-group">
                <button class="btn btn-primary btn-block" type="submit">Zaloguj</button>
            </div>
            <c:if test="${not empty requestScope.loginFailure}">
                <p class="text-danger">${requestScope.loginFailure}</p>
            </c:if>
            <a href="register" class="already">Nie masz konta? Zarejestruj się tutaj.</a>
        </form>
    </div>
</div>
<jsp:include page="footer.jsp"/>