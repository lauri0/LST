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
    <title>Kommentaar</title>
</head>
<body>
    ${firstName}
    <form action="/comment" method="post">Amet:<BR>
        <input type="text" name="testOccupation"> <br>
        Kommentaar:<br>
        <input type="text" name="testComment"><br>
        <input type="submit" value="Salvesta"/>
    </form>
</body>
</html>
