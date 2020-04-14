<%@ page import="java.time.LocalDateTime" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>


<div class="container my-5 shadow-lg p-2">
    <form action="/list" method="get">
        <div class="row">
            <div class="form-group col-5">
                <label for="make">Marka:</label>
                <select type="select" class="form-control form-control-lg" name="make" size="1">
                    <option value="any">Wybierz markę:</option>
                    <c:forEach items="${requestScope.makeList}" var="entry">
                        <option value="${entry}">${entry}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col">
                <label>Cena:</label>
                <div class="d-flex flex-row">
                    <input class="w-50" type="number" placeholder="od" name="price-from" min="0" maxlength="9" size="9">
                    <input class="w-50" type="number" placeholder="do" name="price-to" maxlength="9" size="9">
                </div>
            </div>
            <div class="form-group col">
                <label class="d-block">Rok produkcji:</label>
                <div class="d-flex flex-row">
                    <input class="w-50" type="number" placeholder="od" name="year-from" min="1900" maxlength="4"
                           size="4">
                    <input class="w-50" type="number" placeholder="do" name="year-to"
                           max="${LocalDateTime.now().getYear()}" maxlength="4" size="4">
                </div>
            </div>
            <div class="form-group col">
                <label class="d-block">Przebieg:</label>
                <div class="d-flex flex-row">
                    <input class="w-50" type="number" placeholder="od" name="mileage-from" min="0" maxlength="7"
                           size="7">
                    <input class="w-50" type="number" placeholder="do" name="mileage-to" maxlength="7" size="7">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <button class="btn btn-primary btn-block" type="submit">Filtruj</button>
            </div>
        </div>
    </form>
</div>
<div class="container">
    <div class="card-columns">
        <c:forEach items="${requestScope.adsList}" var="entry">
            <div class="card">
                <img class="card-img-top w-100 d-block"
                     src="<c:out value="${entry.car.imageLink}"/>"
                     style="background-size: cover;">
                <div class="card-body d-flex d-lg-flex flex-column flex-grow-1">
                    <div class="d-flex flex-row justify-content-between">
                        <h4><c:out value="${entry.car.make}"/></h4>
                        <h4 class="d-lg-flex"><c:out value="${entry.car.model}"/></h4>
                    </div>
                    <div class="d-block">
                        <p><span class="float-left">Rok produkcji</span><span class="float-right">
                            <c:out value="${entry.car.year}"/></span></p>
                    </div>
                    <div class="d-block">
                        <p><span class="float-left">Przebieg</span><span class="float-right">
                            <c:out value="${entry.car.mileage}"/> km</span></p>
                    </div>
                    <div class="bg-light shadow-sm flex-grow-1"
                         style="font-family: Raleway, sans-serif;font-weight: bold;font-style: normal;margin-top: 20px;padding: 0 10px">
                        <p class="lead text-primary"><span class="float-left">Cena</span>
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
        </c:forEach>
    </div>
</div>


<jsp:include page="footer.jsp"/>