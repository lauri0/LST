<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <%@ include file="header.jsp" %>
    <title>Soovitaja valikud</title>
</head>
<body>
    <%@ include file="buttons.jsp" %>

    <div id="intro"><h1>Minu kandidaat Riigikogu valimistel on...</h1></div>

    <div class="fullscreen-content">
        <div class="candidate-name">${candidateName}</div>
        <div class="comment">${comment}</div>
    </div>

</body>
</html>
