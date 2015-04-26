<%--
  Created by IntelliJ IDEA.
  User: siiri
  Date: 05/04/15
  Time: 03:05
  To change this template use File | Settings | File Templates.
--%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ include file="header.jsp" %>
    <link rel="stylesheet" type="text/css" href="/css/jquery-ui.css" />
    <script src="/js/index.js"></script>
    <script src="/js/jquery-ui.js"></script>
    <title>Soovitaja kutsumine</title>
</head>
<body>
    <%@ include file="buttons.jsp" %>
    <div class="search-bar-container">
        <form class="input-group" action="/invite" method="post">
            <br><center><font size = "4">Kutsu tuttav soovitama</font></center><br><br>
            <input type="text" name="recipient" class="form-control" id="search-bar" placeholder="Sisesta kutsutava meiliaadress"> <br>
            <input type="text" name="subject" class="form-control" id="search-bar" placeholder="Sisesta meili pealkiri"> <br>
            <textarea name = "contents" rows="5" cols="62" placeholder="   Sisesta kutse sisu"></textarea>
            <span class="input-group-btn" id="button-container">
                <button type="submit" class="btn btn-primary go btn-block">Saada</button>
            </span>
        </form>

    </div>

</body>
</html>
