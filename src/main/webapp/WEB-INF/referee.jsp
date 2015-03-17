<%--
  Created by IntelliJ IDEA.
  User: siiri
  Date: 01/03/15
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/background.css" />
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
</head>
<body>
    <div class="background-image"></div>
    <div class="fullscreen-content">
<div>
    Eesnimi: ${ref.firstName}
</div>
<div>
    Perekonnanimi: ${ref.lastName}
</div>
<div>
    Amet: ${ref.occupation}
</div>
    </div>
</body>
</html>
