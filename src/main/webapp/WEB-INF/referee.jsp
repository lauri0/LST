<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/background.css" />
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
</head>

<body>
    <div class="background-image"></div>

    <div class="fullscreen-content">
        <div id="candidate-intro">Minu kandidaat Riigikogu valimistel on:</div>
        <div id="candidate-name">${candidateName}</div>
        <div id="comment">–„${comment}”</div>
       <!-- <div>Eesnimi: ${ref.firstName}</div>
        <div>Perekonnanimi: ${ref.lastName}</div>
        <div>Amet: ${ref.occupation}</div> !-->
    </div>

</body>
</html>
