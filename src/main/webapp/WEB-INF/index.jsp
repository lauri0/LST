<%--
  Created by IntelliJ IDEA.
  User: siiri
  Date: 28/02/15
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <title>Poliitiline soovitusleht</title>

    <link rel="stylesheet" type="text/css" href="css/background.css" />
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">

</head>
<body>
    <p style="text-align: right">
        <a href="./auth">Lisa ennast andmebaasi</a>
    </p>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <div class="background-image"></div>
    <div class="content">
        <form class="input-group" action="/soovitaja" method="get">
            <input type="text" name="referee" class="form-control" id="searchbar" placeholder="Sisesta soovitaja nimi">
            <span class="input-group-btn" id="button-container">
                <button type="submit" class="btn btn-primary btn-block">Mine</button>
            </span>
        </form>
    </div>
</body>
</html>
