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
            <p>Kutsu tuttav soovitama</p>
            <input type="text" name="recipient" id="recipient" class="form-control" placeholder="Sisesta kutsutava meiliaadress">

            <input type="text" name="subject" id="subject" class="form-control" id="search-bar" placeholder="Sisesta meili pealkiri">

            <input type="text" name = "contents" id="contents" class="form-control" placeholder="Sisesta kutse sisu">

            <div id="test">
            <span class="input-group-btn" id="invite-button-container">
                <button type="submit" class="invite-btn btn btn-primary go btn-block">Saada</button>
            </span>
            </div>
        </form>

    </div>

</body>
</html>
