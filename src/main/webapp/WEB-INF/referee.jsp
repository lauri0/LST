<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/background.css" />
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link href='http://fonts.googleapis.com/css?family=Ubuntu:700' rel='stylesheet' type='text/css'>

</head>

<body>
    <div class="background-image"></div>
    <div id="intro"><h1>Minu kandidaat Riigikogu valimistel on...</h1></div>
    <div class="fullscreen-content">
        <div id="candidate-intro"></div>
        <div align="center" id="candidate-name">${candidateName}</div>
        <div id="comment">–„${comment}”</div>
       <!-- <div>Eesnimi: ${ref.firstName}</div>
        <div>Perekonnanimi: ${ref.lastName}</div>
        <div>Amet: ${ref.occupation}</div> !-->
    </div>

</body>
</html>
