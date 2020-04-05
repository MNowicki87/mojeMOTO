<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>Login page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    </head>

    <body>

        <h1>Podaj swoje dane</h1>

        <form method="post" action="/person">
            <label for="firstName">Imię</label>
            <input name="firstName" type="text"/><br/>
            <label for="lastName">Nazwisko</label>
            <input name="lastName" type="text"/><br/>

            <p>Płeć:</p>
            <input type="radio" id="male" name="gender" value="male"/>
            <label for="male">Mężczyzna</label><br/>
            <input type="radio" id="female" name="gender" value="female"/>
            <label for="female">Kobieta</label><br/>

            <label for="birthday">Data urodzenia:</label>
            <input type="date" id="birthday" name="birthday"/>

            <br/>
            <input type="submit"/>
        </form>

    </body>

</html>