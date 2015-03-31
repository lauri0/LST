/**
 * Created by siiri on 29/03/15.
 */
$(document).ready(function() {
    $(".firstLetter").hide();
    $("#alphabetically").click(function(){
        //$(".firstLetter").slideToggle();
        $('.firstLetter').animate({width: 'toggle'});
        $("#tablediv").hide();
        $(".firstLetter").click(function(event){
            history.pushState({}, '', "/soovitajate-nimekiri/" + $(this).attr("id"));
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
})