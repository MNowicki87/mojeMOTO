<%@ page import="java.time.LocalDateTime" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container my-5 shadow-lg p-2">
    <form action="/panel/list" method="get">
        <div class="row">
            <div class="form-group col-lg-3">
                <label for="make">Marka:</label>
                <select type="select" class="form-control form-control-lg" name="make" id="make" size="1">
                    <option value="any">Wybierz markę…</option>
                    <c:forEach items="${makeList}" var="make">
                        <option value="${make}">${make}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-xs-2 col-md-3">
                <label>Cena:</label>
                <div class="d-flex flex-row">
                    <input class="w-50" type="number" placeholder="od" name="minPrice" min="0"
                           max="${Integer.MAX_VALUE}" maxlength="8" size="9">
                    <input class="w-50" type="number" placeholder="do" name="maxPrice"
                           min="0" max="${Integer.MAX_VALUE}" maxlength="8" size="9">
                </div>
            </div>
            <div class="form-group col-xs-2 col-md-3">
                <label class="d-block">Rok produkcji:</label>
                <div class="d-flex flex-row">
                    <input class="w-50" type="number" placeholder="od" name="minYear"
                           min="1900" max="${LocalDateTime.now().getYear()+1}" maxlength="4" size="4">
                    <input class="w-50" type="number" placeholder="do" name="maxYear"
                           min="1900" max="${LocalDateTime.now().getYear()+1}" maxlength="4" size="4">
                </div>
            </div>
            <div class="form-group col-xs-2 col-md-3">
                <label class="d-block">Przebieg:</label>
                <div class="d-flex flex-row">
                    <input class="w-50" type="number" placeholder="od" name="minMileage"
                           min="0" max="${Integer.MAX_VALUE}" maxlength="7"
                           size="7">
                    <input class="w-50" type="number" placeholder="do" name="maxMileage" min="0"
                           max="${Integer.MAX_VALUE}" maxlength="7" size="7">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <button class="btn btn-primary btn-block" type="submit">Filtruj</button>
            </div>
        </div>
        <c:if test="${not empty requestScope.invalidPriceParam}">
            <p class="text-center text-danger mt-3">${requestScope.invalidPriceParam}</p>
        </c:if>
        <c:if test="${not empty requestScope.invalidYearParam}">
            <p class="text-center text-danger mt-3">${requestScope.invalidYearParam}</p>
        </c:if>
        <c:if test="${not empty requestScope.invalidMileageParam}">
            <p class="text-center text-danger mt-3">${requestScope.invalidMileageParam}</p>
        </c:if>
    </form>
</div>