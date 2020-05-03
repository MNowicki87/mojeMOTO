<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<div class="register-photo">
    <div class="form-container">
        <div class="image-holder"
             style="background-image: url(http://www.banktapet.pl/pictures/2016/0716/1/classic-kool-nice-car-pics-583905.jpg);background-position: center;"></div>
        <form action="admin/user/editUser" method="post">
            <h2 class="text-center"><strong>Edycja konta ${requestScope.user.login}</strong></h2>
            <div class="form-group">
                <label for="name">Imię:</label>
                <input class="form-control" id="name" type="text" name="name" required
                       value="${requestScope.user.name}" placeholder="${requestScope.user.name}" minlength="2">
            </div>
            <div class="form-group">
                <label for="surname">Nazwisko:</label>
                <input class="form-control" id="surname" type="text" name="surname"
                       value="${requestScope.user.surname}" placeholder="${requestScope.user.surname}">
            </div>
            <input type="hidden" name="id" value="${requestScope.user.id}">
            <div class="form-group">
                <button class="btn btn-primary btn-block" type="submit">
                    Zatwierdź zmiany
                </button>
            </div>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp"/>