$(document).ready(function(){

    $("#intro-text").hide();
    $(".sign-toggle").click(function(){
        var intro =  $("#intro-text");
        var form = $("#form-and-text-container");
        if($(this).hasClass("glyphicon-minus-sign")) {
           var intro_text_height = parseInt(intro.css("height"));
           form.css("padding-bottom",form.css("padding-bottom","-="+intro_text_height));
           intro.hide();
       }
       else{
           intro.show();
           var intro_text_height = parseInt(intro.css("height"));
           form.css("padding-bottom",form.css("padding-bottom","+="+intro_text_height));

       }

        $(this).toggleClass("glyphicon-plus-sign glyphicon-minus-sign");
    });

        $("#search-bar").autocomplete({
        source: function(request, response){
                $.ajax({
                    url:"SearchServlet",
                    type:"GET",
                    data:{
                        term: request.term
                    },
                    dataType: "json",
                    success: function(data){
                        response($.map(data,function(v,i){
                           return{
                               label: v.firstName + " " + v.lastName + ", " + v.occupation,
                               value: v.firstName + " " + v.lastName + ", " + v.occupation
                           }
                        }));


                    }

                });
            }
        });

});
