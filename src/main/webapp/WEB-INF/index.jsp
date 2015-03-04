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
    <link rel="stylesheet" type="text/css" href="css/background.css" />
    <%--<script type="text/javascript" src="JS/jquery-1.4.2.min.js"></script>
    <script src="JS/jquery.autocomplete.js"></script>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script type="text/javascript" src="http://twitter.github.com/bootstrap/assets/js/bootstrap-dropdown.js"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>--%>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">

<%--
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>--%>


</head>
<body>
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
