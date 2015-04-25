<%--
  Created by IntelliJ IDEA.
  User: siiri
  Date: 22/03/15
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="header.jsp" %>
<title>Statistika</title>
</head>
<body>
<%@ include file="buttons.jsp" %>
<div class="background-image"></div>
<div class="fullscreen-content">
    <center id="stats">${statistics} soovitajat</center><br><br><br><br>
    <center>
        <font size="4">Olete olnud sellel lehel</font>
        <font size="4" id="min"></font>
        <font size="4">:</font>
        <font size="4" id="sec"></font>
    </center>
</div>
<%
    request.getSession().setAttribute("origin", "statistika");
    request.getSession().setAttribute("originjsp", "statistics");
%>
</body>
</html>
<script>
    start();
</script>
<script>
    function start() {
        var eventSource = new EventSource("PushServlet");

        eventSource.addEventListener('second', function(event) {
            document.getElementById('sec').innerHTML = event.data;
        }, false);
        eventSource.addEventListener('minute', function(event) {
            document.getElementById('min').innerHTML = event.data;
        }, false);
    }

    start()
</script>