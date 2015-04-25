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
    <link rel="stylesheet" type="text/css" href="/css/jquery-ui.css" />
    <script src="/js/index.js"></script>
    <script src="/js/jquery-ui.js"></script>

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
        <div id="form-and-text-container" class="input-group" >
            <div id="intro-text"><p id="app-intro-text">Tihti kuuleme nurinat, et pole kedagi valida või et ei tunne kandidaate. Kandidaatide nimekirjas ei ole meie lemmikuid või isikuid, keda usaldada. Aga meil kõigil on oma lemmik, keda me usaldame – poliitik, omavalitsustegelane, ajakirjanik, teadlane, näitleja.. ühesõnaga tuntud inimene –, ja kelle arvamus on meile oluline. Need on inimesed, kes ise ei kandideeri, kuid kes on enda jaoks välja selgitanud kandidaadid, keda nemad usaldavad, kelle poolt nad hääletavad ja keda nad soovitavad valida ka oma fännidel.</p></div>
            <div class="expandable">
                <span class="sign-toggle glyphicon glyphicon-plus-sign"></span>
            </div>
            <form id="people-search-bar" action="/soovitaja" method="get">
                <input type="text" name="referee" class="form-control" id="search-bar" placeholder="Sisesta soovitaja nimi">
                <span class="input-group-btn" id="button-container">
                    <button type="submit" class="btn btn-primary go btn-block">Mine</button>
                </span>
            </form>
        </div>

    </div>
</body>
</html>
