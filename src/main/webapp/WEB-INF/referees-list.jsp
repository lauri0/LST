<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Soovitajate nimekiri</title>
    <link rel="stylesheet" type="text/css" href="css/background.css" />
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#tablediv").hide();
            $(".firstLetter").click(function(event){
                $.get("random",{letter: event.target.id},function(responseJson){
                    if(responseJson!=null){
                        $("#tablediv").text("");
                        for(var i=0;i<responseJson.length;i++){
                            var obj = responseJson[i];
                            var name = obj.firstName + " " + obj.lastName + ", " + obj.occupation;
                            var n = document.createTextNode(name);
                            var nameHolder = document.getElementById("tablediv");
                            nameHolder.appendChild(n);
                            nameHolder.appendChild(document.createElement("br"));
                        }

                        $("#tablediv").show();
                    }
                });
            });
        });
    </script>

</head>
<body>
    <div class="background-image"></div>
    <div class="fullscreen-content">
        <p class="firstLetter" id="A">A</p>
        <p class="firstLetter" id="M">M</p>

        <div id="tablediv">

        </div>
        <!-- <table id="referees-list">
        <c:forEach items="${refereeList}" var="item">
            <tr>
                <td><c:out value="${item.firstName } ${item.lastName},  ${item.occupation}" /></td>
            </tr>
        </c:forEach>
        </table> -->
    </div>
</body>
</html>
