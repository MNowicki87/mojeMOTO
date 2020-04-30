<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<div class="container">

    <table class="table table-hover table-dark">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Imię</th>
            <th scope="col">Nazwisko</th>
            <th scope="col">login</th>
            <th scope="col">Hasło</th>
            <th scope="col">Edycja</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.users}" var="listedUser">
            <tr>
                <th scope="row">${listedUser.id}</th>
                <td>${listedUser.name}</td>
                <td>${listedUser.surname}</td>
                <td>${listedUser.login}</td>
                <td>${listedUser.password}</td>
                <td><a href="admin/user/editUser?userId=${listedUser.id}">Edytuj</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>


<jsp:include page="footer.jsp"/>