$(document).ready(function() {
    $("button").click(function() {
        $.ajax({
            type : 'POST',
            url : 'http://localhost:3666/shorten-url',
            data : JSON.stringify({
                "fullUrl" : $("#urlinput").val()
            }),
            contentType : "application/json; charset=utf-8",
            success : function(data) {
                $("#shorturltext").val(data.shortUrl);
            }
        });
    });
});