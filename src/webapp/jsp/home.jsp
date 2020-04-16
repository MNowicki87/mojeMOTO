<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<div class="jumbotron text-left">
    <div class="col-9 m-auto jumbo-inner-box">
        <h1 class="text-center">Szukasz samochodu?</h1>
        <h3 class="text-center">
            Twoje nowe auto już na Ciebie czeka <br>
            <span class="small">na<br></span>
            <span class="text-primary">mojeMOTO!</span>
        </h3>
        <p>
            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quas, amet, quibusdam dolorem fuga quo minima illo
            architecto provident laborum temporibus vero cupiditate labore enim error odio facere minus quidem
            dignissimos reprehenderit nemo! Consectetur quibusdam cumque doloribus. Tempora, quod dignissimos unde
            perspiciatis accusantium ad corrupti molestias eveniet veritatis suscipit. Deserunt, facere.
        </p>
        <p class="text-center" style="font-weight: bold;font-style: normal;font-family: Raleway, sans-serif;">
            <c:if test="${sessionScope.user == null}">
                <a class="btn btn-outline-primary btn-lg text-white bg-primary border rounded shadow-lg heartBeat"
                   role="button" href="/login"
                   style="opacity: 1;filter: blur(0px);font-family: Raleway, sans-serif;font-weight: bold;">
                    Zaloguj się
                </a>
            </c:if>
            <c:if test="${sessionScope.user != null}">
                <a class="btn btn-outline-primary btn-lg text-white bg-primary border rounded shadow-lg heartBeat"
                   role="button" href="/list"
                   style="opacity: 1;filter: blur(0px);font-family: Raleway, sans-serif;font-weight: bold;">
                    Przeglądaj ogłoszenia
                </a>
            </c:if>
        </p>
    </div>
</div>
<jsp:include page="footer.jsp"/>