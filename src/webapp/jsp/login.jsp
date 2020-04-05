<jsp:include page="header.jsp"/>
<form action="/login" method="post">
    <div class="form-group">
        <label for="login">login:</label>
        <input type="text" class="form-control" placeholder="login" id="login" name="login">
    </div>
    <div class="form-group">
        <label for="pwd">Password:</label>
        <input type="password" class="form-control" placeholder="Enter password" id="pwd" name="pwd">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<jsp:include page="footer.jsp"/>