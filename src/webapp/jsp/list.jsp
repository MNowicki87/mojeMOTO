<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<c:if test="${not requestScope.myads}">
    <jsp:include page="searchFilter.jsp"/>
</c:if>

<div class="container">
    <div class="card-row d-flex flex-wrap">
        <c:if test="${empty requestScope.adsMap}">
            <p>Nie masz aktualnie żadnych ogłoszeń.
            <c:if test="${requestScope.user.active}">
                możesz dodać ogłoszenie <a href="panel/add">tutaj</a></p>
            </c:if>
            <c:if test="${!requestScope.user.active}">
                Aby dodać ogłoszenie aktywuj konto, klikakając link w wiadomości e-mail.</p>
            </c:if>
        </c:if>
        <c:forEach items="${requestScope.adsMap}" var="entry">
            <div class="col-lg-4 mb-3 d-flex">
                <div class="card <c:if test="${entry.key.premium}">premium-ad-card</c:if>">
                    <img class="card-img-top w-100 d-block"
                         src="<c:out value="${entry.key.car.imageLink}"/>"
                         style="background-size: cover;" alt="${entry.key.car.toString()}">
                    <a class="shadow-lg d-block" href="panel/list?toggleObservedId=${entry.key.id}">
                            <span class="position-absolute badge
                                    <c:if test="${entry.key.observersIds.contains(sessionScope.user.id)}">
                                        badge-success text-white
                                    </c:if>
                                    <c:if test="${!entry.key.observersIds.contains(sessionScope.user.id)}">
                                        badge-light text-secondary
                                    </c:if>
                                    "
                                  style="top: -10px; left: -10px">
                                <span class="material-icons">
                                    star
                                </span>
                            </span>
                    </a>

                    <div class="card-body d-flex d-lg-flex flex-column flex-grow-1">
                        <div class="d-flex flex-row justify-content-between">
                            <h4><c:out value="${entry.key.car.make}"/></h4>
                            <h4 class="d-lg-flex"><c:out value="${entry.key.car.model}"/></h4>
                        </div>
                        <div class="d-block">
                            <p><span class="float-left">Rok produkcji:</span><span class="float-right">
                            <c:out value="${entry.key.car.year}"/></span></p>
                        </div>
                        <div class="d-block">
                            <p><span class="float-left">Przebieg:</span><span class="float-right">
                            <c:out value="${entry.key.car.mileage}"/> km</span></p>
                        </div>
                        <div class="bg-light shadow-sm flex-grow-1"
                             style="font-family: Raleway, sans-serif;font-weight: bold;font-style: normal;margin-top: 20px;padding: 0 10px">
                            <p class="lead text-primary"><span class="float-left">Cena:</span>
                                <span class="float-right"><c:out value="${entry.key.price}"/> zł</span></p>
                        </div>
                        <div class="card-footer text-muted text-right small">
                            <div class="d-block overflow-auto">
                                <p>
                                <span class="float-left">
                                Dodano:
                                </span>
                                    <span class="float-right">
                                <c:out value="${entry.key.createdAt.toLocalDate().toString()}"/>
                                </span>
                                </p>
                            </div>
                            <div class="d-block">
                                <p><span class="float-left">Sprzedający</span><span class="float-right">
                            <c:out value="${entry.value}"/>
                        </span>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


<jsp:include page="footer.jsp"/>