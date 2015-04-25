/**
 * Created by siiri on 29/03/15.
 */
function displayNames(id){
    $.get("random",{letter:id},function(responseJson){
        if(responseJson!=null){
            $("#tablediv").text("");
            for(var i=0;i<responseJson.length;i++){
                var obj = responseJson[i];
                var name = obj.firstName + " " + obj.lastName + ", " + obj.occupation;
                var n = document.createElement("a");
                n.setAttribute("href","/soovitaja?referee=" + obj.firstName + "+" + obj.lastName + '%2C+' + obj.occupation);
                n.appendChild(document.createTextNode(name));
                var nameHolder = document.getElementById("tablediv");
                nameHolder.appendChild(n);
                nameHolder.appendChild(document.createElement("br"));

            }

            $("#tablediv").show();
        }
    });
}


$(document).ready(function() {
    var shown = false;
    $(".firstLetter").click(function(e){
        history.pushState({"l": e.target.id}, '', "/soovitajate-nimekiri/" + $(this).attr("id"));
        displayNames(e.target.id);
    })
    $(".firstLetter").hide();
    $("#alphabetically").click(function(){
        if (!shown) {
            $('.firstLetter').animate({width: 'show'});
            history.pushState({"t": true}, "", "");
            shown=true;
        }
        else {
            $('.firstLetter').animate({width: 'hide'});
            history.pushState({"t": false}, "", "");
            shown =false;
        }

        $("#tablediv").hide();
;

    });

    window.addEventListener("popstate", function(e){
        if (e.state != null && e.state.l != null) {
            displayNames(e.state.l);
            $('.firstLetter').animate({width: 'show'});
        }
        else if (e.state != null && e.state.t != null && e.state.t){
            $("#tablediv").hide();
            $('.firstLetter').animate({width: 'hide'});

        }
        else if (e.state != null && e.state.t != null && !e.state.t){
            $("#tablediv").hide();
            $('.firstLetter').animate({width: 'show'});

        }
        else {
            $("#tablediv").hide();
            $('.firstLetter').animate({width: 'hide'});

        }
    });

    $(".firstLetter").hover(
        function() {
            $(this).addClass("highlight");
        },
        function(){
            $(this).removeClass("highlight");

        }
    );
})

