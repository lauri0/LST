<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


    <%@ include file="header.jsp" %>
    <link href='//fonts.googleapis.com/css?family=Ubuntu:700' rel='stylesheet' type='text/css'>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Soovitajate nimekiri</title>
    <script src="/js/displayRefereeNames.js"></script>
<%
    request.getSession().setAttribute("origin", "soovitajate-nimekiri");
%>
</head>
<body>
    <%@ include file="buttons.jsp" %>
    <div class="background-image"></div>
    <div class="fullscreen-content">


        <p class="displayOptions" id="alphabetically">Tähestiku järgi</p>
        <!--<p class="displayOptions" id="recentlyAdded">Viimati lisatud</p>!-->

        <c:set var="alphabet" value="A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,R,S,Š,Z,T,U,V,Õ,Ä,Ö,Ü"></c:set>
        <c:forEach items="${fn:split(alphabet, ',')}" var="item">
            <p class="firstLetter" id="${item}">${item}</p>
        </c:forEach>


        <p id="tablediv">

        </p>
        <!-- <table id="referees-list">
        <c:forEach items="${refereeList}" var="item">
            <tr>
                <td><c:out value="${item.firstName } ${item.lastName},  ${item.occupation}" /></td>
            </tr>
        </c:forEach>
        </table> -->
    </div>
</body>
</html>
