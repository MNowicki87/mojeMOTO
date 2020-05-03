<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${sessionScope.message!=null}">
    <div role="alert" aria-live="assertive" aria-atomic="true" class="toast" data-autohide="false">
        <div class="toast-header bg-warning">
            <strong class="mr-auto text-dark">Komunikat</strong>
            <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="toast-body">
                ${sessionScope.message}
                ${sessionScope.remove("message")}
        </div>
    </div>
</c:if>
<div class="footer-basic">
    <footer>
        <div class="social">
            <a href="/home"><i class="icon ion-social-instagram"></i></a>
            <a href="/home"><i class="icon ion-social-snapchat"></i></a>
            <a href="/home"><i class="icon ion-social-twitter"></i></a>
            <a href="/home"><i class="icon ion-social-facebook"></i></a>
        </div>
        <ul class="list-inline">
            <li class="list-inline-item"><a href="home">Strona główna</a></li>
            <c:if test="${sessionScope.user != null}">
                <li class="list-inline-item"><a href="list">Ogłoszenia</a></li>
                <li class="list-inline-item"><a href="myads">Moje ogłoszenia</a></li>
            </c:if>
            <li class="list-inline-item"><a href="home">Regulamin</a></li>
            <li class="list-inline-item"><a href="home">Polityka prywatności</a></li>
        </ul>
        <p class="copyright">mojeMOTO © 2020</p>
    </footer>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"></script>
<script>
    $('.toast').toast('show');
    $('.toast').toast('data-animation=true');
</script>
</body>

</html>