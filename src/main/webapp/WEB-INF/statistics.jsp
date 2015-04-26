<%--
  Created by IntelliJ IDEA.
  User: siiri
  Date: 22/03/15
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="header.jsp" %>
<script src="/js/statistics.js"></script>
<title>Statistika</title>
</head>
<body>
<%@ include file="buttons.jsp" %>
<div class="background-image"></div>
<div class="fullscreen-content">
    <p id="stats">${statistics} soovitajat</p>
</div>
<%
    request.getSession().setAttribute("origin", "statistika");
    request.getSession().setAttribute("originjsp", "statistics");
%>
<script>start()</script>
</body>
</html>
