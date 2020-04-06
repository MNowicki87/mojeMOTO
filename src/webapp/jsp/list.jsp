<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>


<div class="container">
    <div class="card-columns">
        <c:forEach items="${requestScope.adsList}" var="entry">
            <div class="card">
                <img class="card-img-top w-100 d-block"
                                   src="<c:out value="${entry.car.imageLink}"/>"
                                   style="background-size: cover;">
                <div class="card-body d-flex d-lg-flex flex-column flex-grow-1">
                    <div class="d-block"></div>
                    <div class="d-flex flex-row justify-content-between">
                        <h4><c:out value="${entry.car.make}"/></h4>
                        <h4 class="d-lg-flex"><c:out value="${entry.car.model}"/></h4>
                    </div>
                    <div class="d-block">
                        <p><span class="float-left">Rok produkcji</span><span class="float-right"><c:out value="${entry.car.year}"/></span></p>
                    </div>
                    <div class="d-block">
                        <p><span class="float-left">Przebieg</span><span class="float-right"><c:out value="${entry.car.mileage}"/> km</span></p>
                    </div>
                    <div class="d-block">
                        <p><span class="float-left">Sprzedający</span><span class="float-right">
                            <c:out value="${entry.owner.name}"/> <c:out value="${entry.owner.surname}"/>
                        </span>
                        </p>
                    </div>
                    <div class="bg-light shadow-sm flex-grow-1"
                         style="font-family: Raleway, sans-serif;font-weight: bold;font-style: normal;margin-top: 20px;margin-bottom: 20px;">
                        <p class="lead text-monospace text-primary"><span class="float-left">Cena</span><span
                                class="float-right"><c:out value="${entry.price}"/> zł</span></p>
                    </div>
                    <p class="d-lg-flex flex-grow-1 align-items-end align-self-end mt-auto">
                        <small class=" text-muted flex-grow-1 align-self-end mb-auto float-right">dodatno:
                            <c:out value="${entry.createdAt.toLocalDate().toString()}"/>
                    </small></p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


<jsp:include page="footer.jsp"/>