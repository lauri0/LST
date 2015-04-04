<%--
  Created by IntelliJ IDEA.
  User: siiri
  Date: 22/03/15
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html manifest="soovitusleht.MF">
<head>
    <title>Statistika</title>
    <link rel="stylesheet" type="text/css" href="css/background.css" />
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <%@ include file="header.jsp" %>
</head>
<body>
    <div class="background-image"></div>
    <div class="fullscreen-content">
        <div id="statistics">${statistics} soovitajat</div>
    </div>
</body>
</html>
