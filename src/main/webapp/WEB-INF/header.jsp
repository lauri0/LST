<%--
  Created by IntelliJ IDEA.
  User: siiri
  Date: 03/04/15
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html manifest="soovitusleht.appcache">
<head>
    <link rel="stylesheet" type="text/css" href="css/background.css" />
    <link rel="stylesheet" type="text/css" href="css/header.css" />
    <link href='//fonts.googleapis.com/css?family=Ubuntu:700' rel='stylesheet' type='text/css'>
    <title></title>
</head>
<body>
    <div class="home">
        <a href="/index" class="btn btn-primary btn-block">Kodu</a>
    </div>
    <div class="background-image"></div>
    <div class="referees-button">
        <a href="/soovitajate-nimekiri" class="btn btn-primary btn-block">Soovitajad</a>
    </div>
    <div class="log-in">
        <a href="/auth" class="btn btn-primary btn-block">Logi sisse</a>
    </div>
    <div class="invite">
        <a type="submit" class="btn btn-primary btn-block">Saada kutse</a>
    </div>
    <div class="statistics">
        <a href="/statistika" class="btn btn-primary btn-block">Statistika</a>
    </div>
</body>
</html>
