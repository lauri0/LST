<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

    <table>
    <c:forEach items="${refereeList}" var="item">
        <tr>
            <td><c:out value="${item.firstName } ${item.lastName},  ${item.occupation}" /></td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
