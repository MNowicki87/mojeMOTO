<jsp:include page="header.jsp"/>

<div class="container">
    <form method="post" action="/add">
        <div class="form-row">
            <div class="col">
                <div class="form-group">
                    <label for="make">Marka:</label>
                    <input class="form-control" type="text" name="make" required="" placeholder="Wpisz markę…"
                           minlength="3">
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="model">Model:</label>
                    <input class="form-control" type="text" name="model" required="" placeholder="Podaj model…"
                           minlength="3">
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="year">Rok produkcji:</label>
                    <input class="form-control" type="number" name="year" required="" placeholder="Podaj rok produkcji…"
                           min="1900" max="2020" step="1">
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <div class="form-group">
                    <label for="mileage">Przebieg:</label>
                    <div class="input-group">
                        <input class="form-control" type="text" name="mileage" required=""
                               placeholder="Podaj przebieg…">
                        <div class="input-group-append">
                            <span class="input-group-text">km</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="form-group"><label for="price">Cena:</label>
                    <div class="input-group">
                        <div class="input-group-prepend"></div>
                        <input class="form-control" type="text" name="price" required="" placeholder="Podaj cenę…">
                        <div class="input-group-append"><span class="input-group-text">zł</span></div>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="form-group"><label for="image-link">Link do zdjęcia:</label><input class="form-control"
                                                                                              type="url"
                                                                                              name="image-link"
                                                                                              required=""
                                                                                              placeholder="Tu wklej link do zdjęcia…">
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col text-center d-block d-lg-flex justify-content-lg-center align-items-lg-center">
                <button class="btn btn-success btn-block btn-lg d-lg-flex justify-content-lg-center" type="submit"
                        style="height: 40px;margin-top: 15px;line-height: 40px;padding-top: 0;padding-bottom: 0;">Dodaj
                </button>
            </div>
        </div>
</div>
</form>
</div>


<jsp:include page="footer.jsp"/>