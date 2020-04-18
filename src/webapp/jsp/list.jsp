<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<c:if test="${not requestScope.myads}">
    <jsp:include page="searchFilter.jsp"/>
</c:if>

<div class="container">
    <div class="card-row d-flex flex-wrap">
        <c:forEach items="${requestScope.adsList}" var="entry">
            <div class="col-lg-4 mb-3 d-flex">
                <div class="card">
                    <img class="card-img-top w-100 d-block"
                         src="<c:out value="${entry.car.imageLink}"/>"
                         style="background-size: cover;" alt="${entry.car.toString()}">
                    <c:if test="${entry.premium}">
                    <span class="badge badge-success position-absolute" style="top: -10px; right: -10px">
                        <span class="material-icons">
                            stars
                        </span>
                    </span>
                    </c:if>
                    <div class="card-body d-flex d-lg-flex flex-column flex-grow-1">
                        <div class="d-flex flex-row justify-content-between">
                            <h4><c:out value="${entry.car.make}"/></h4>
                            <h4 class="d-lg-flex"><c:out value="${entry.car.model}"/></h4>
                        </div>
                        <div class="d-block">
                            <p><span class="float-left">Rok produkcji:</span><span class="float-right">
                            <c:out value="${entry.car.year}"/></span></p>
                        </div>
                        <div class="d-block">
                            <p><span class="float-left">Przebieg:</span><span class="float-right">
                            <c:out value="${entry.car.mileage}"/> km</span></p>
                        </div>
                        <div class="bg-light shadow-sm flex-grow-1"
                             style="font-family: Raleway, sans-serif;font-weight: bold;font-style: normal;margin-top: 20px;padding: 0 10px">
                            <p class="lead text-primary"><span class="float-left">Cena:</span>
                                <span class="float-right"><c:out value="${entry.price}"/> zł</span></p>
                        </div>
                        <div class="card-footer text-muted text-right small">
                            <div class="d-block overflow-auto">
                                <p>
                                <span class="float-left">
                                Dodano:
                                </span>
                                    <span class="float-right">
                                <c:out value="${entry.createdAt.toLocalDate().toString()}"/>
                                </span>
                                </p>
                            </div>
                            <div class="d-block">
                                <p><span class="float-left">Sprzedający</span><span class="float-right">
                            <c:out value="${entry.owner.name}"/> <c:out value="${entry.owner.surname}"/>
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