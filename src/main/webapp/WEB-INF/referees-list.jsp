<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Soovitajate nimekiri</title>
    <link rel="stylesheet" type="text/css" href="css/background.css" />
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
</head>
<body>
    <div class="background-image"></div>
    <div class="fullscreen-content">
        <table id="referees-list">
        <c:forEach items="${refereeList}" var="item">
            <tr>
                <td><c:out value="${item.firstName } ${item.lastName},  ${item.occupation}" /></td>
            </tr>
        </c:forEach>
        </table>
    </div>
</body>
</html>
