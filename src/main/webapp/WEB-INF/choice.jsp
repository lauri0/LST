<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    Vali kandidaat<BR>
    <select name="testChoice" form="candidateform">
        <option value="Poliitik 1">Poliitik 1</option>
        <option value="Poliitik 2">Poliitik 2</option>
        <option value="Poliitik 3">Poliitik 3</option>
        <option value="Poliitik 4">Poliitik 4</option>
    </select>

    </form>
    <form action="/choice" id="candidateform" method="post">
        <input type="submit" value="Salvesta"/>
    </form>
</body>
</html>
