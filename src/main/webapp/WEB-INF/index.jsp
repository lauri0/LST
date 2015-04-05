<%--
  Created by IntelliJ IDEA.
  User: siiri
  Date: 28/02/15
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ include file="header.jsp" %>
    <title>Poliitiline soovitusleht</title>
</head>
<%
    request.getSession().setAttribute("origin", "index");
    request.getSession().setAttribute("originjsp", "index");
%>
<body>
    <%@ include file="buttons.jsp" %>
    <script src="js/bootstrap.min.js"></script>
    <div class="background-image"></div>
    <div class="search-bar-container">
        <form class="input-group" action="/soovitaja" method="get">
            <input type="text" name="referee" class="form-control" id="search-bar" placeholder="Sisesta soovitaja nimi">
            <span class="input-group-btn" id="button-container">
                <button type="submit" class="btn btn-primary go btn-block">Mine</button>
            </span>
        </form>

    </div>
</body>
</html>
