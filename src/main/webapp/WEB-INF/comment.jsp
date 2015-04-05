<%--
  Created by IntelliJ IDEA.
  User: siiri
  Date: 27/02/15
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="header.jsp" %>
    <title>Kommentaari lisamine</title>
</head>
<body>
    <%@ include file="buttons.jsp" %>
    <div class="search-bar-container">
        <form class="input-group" action="/comment" method="post">
            Eesnimi: ${firstName}<br>
            Perekonnanimi: ${surName}<br>
            <input type="text" name="testOccupation" class="form-control" id="search-bar" placeholder="Sisesta oma amet"> <br>
            <input type="text" name="testComment" class="form-control" id="search-bar" placeholder="Sisesta oma kommentaar"> <br>
            <span class="input-group-btn" id="button-container">
                <button type="submit" class="btn btn-primary go btn-block">Sisesta</button>
            </span>
        </form>

    </div>

<%--
${firstName}
<form action="/comment" method="post">Amet:<BR>
    <input type="text" name="testOccupation"> <br>
    Kommentaar:<br>
    <input type="text" name="testComment"><br>
    <input type="submit" value="Salvesta"/>
</form>
--%>

</body>
</html>
