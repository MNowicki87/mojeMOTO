<jsp:include page="header.jsp"/>

<div class="container">
    <form method="post" action="/panel/add">
        <div class="form-row">
            <div class="col">
                <div class="form-group">
                    <label for="make">Marka:</label>
                    <input class="form-control"
                           type="text"
                           name="make"
                           placeholder="Wpisz markę…"
                           minlength="3"
                           required>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="model">Model:</label>
                    <input class="form-control"
                           type="text"
                           name="model"
                           placeholder="Podaj model…"
                           minlength="3"
                           required>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="year">Rok produkcji:</label>
                    <input class="form-control"
                           placeholder="Podaj rok produkcji…"
                           type="number"
                           name="year"
                           min="1900"
                           max="2020"
                           step="1"
                           required>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <div class="form-group">
                    <label for="mileage">Przebieg:</label>
                    <div class="input-group">
                        <input class="form-control"
                               placeholder="Podaj przebieg…"
                               type="text"
                               name="mileage"
                               min="0"
                               required>
                        <div class="input-group-append">
                            <span class="input-group-text">km</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="form-group"><label for="price">Cena:</label>
                    <div class="input-group">
                        <input class="form-control"
                               type="text"
                               name="price"
                               min="100"
                               required
                               placeholder="Podaj cenę…">
                        <div class="input-group-append"><span class="input-group-text">zł</span></div>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="image-link">Link do zdjęcia:</label>
                    <input class="form-control"
                           type="url"
                           name="image-link"
                           placeholder="Tu wklej link do zdjęcia…"
                           required>
                </div>
            </div>
        </div>

        <div class="container">
            <h3>Zwiększ zainteresowanie ogłoszeniem!</h3>
            <p>Usługa Ogłoszenie premium zwiększa widoczność o 200000%</p>
            <div class="custom-control custom-switch">
                <input type="checkbox" name="premium" class="custom-control-input" id="customSwitch1">
                <label class="custom-control-label" for="customSwitch1">Toggle this switch element</label>
            </div>
        </div>

        <div class="form-row">
            <div class="col text-center d-block d-lg-flex justify-content-lg-center align-items-lg-center">
                <button class="btn btn-success btn-block btn-lg d-lg-flex justify-content-lg-center"
                        type="submit"
                        style="height: 40px;margin-top: 15px;line-height: 40px;padding-top: 0;padding-bottom: 0;">
                    Dodaj
                </button>
            </div>
        </div>
    </form>
</div>


<jsp:include page="footer.jsp"/>