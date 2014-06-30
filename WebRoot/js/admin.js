/**
 * Created by Jack on 6/19/2014.
 */

var isAdUpload = 0;
$("#admin_basicInfo").show();
$(".adminControlItem").click(function() {
    $(".adminContent").hide();
    $($(this).data("target")).show();
}).mouseenter(function() {
    $(this).css("background-color", "#166496");
}).mouseleave(function() {
    $(this).css("background-color", "#133D58");
});

function uploadImage() {
    $("#imgFile").click();
}



function previewImage(file)
{
    isAdUpload = 1;
    if (isAdUpload == 1) {
        $("#upload").hide();
    }
    if (file.files && file.files[0])
    {
        var reader = new FileReader();
        reader.onload = function(evt) {
            var imgSrc = evt.target.result;
            $newImgItem = $("<div class='uploadImageItem'>" +
                "<a href='javascript:void(0)'>" +
                "<img class='uploadImg' src='" + imgSrc + "'/>" +
                "</a>" +
                "<a class='uploadDelete' href='javascript:void(0)'>delete</a>" +
                "</div>");
            $("#uploadImages").append($newImgItem);
            $(".uploadImageItem").mouseenter(function() {
                $(this).find(".uploadDelete").show();
            }).mouseleave(function() {
                $(this).find(".uploadDelete").hide();
            });
            $(".uploadDelete").click(function() {
                $(this).parent().remove();
                isAdUpload = 0;
                $("#upload").show();
            });
        };
        reader.readAsDataURL(file.files[0]);
    }
    else //兼容IE
    {
        /*
         var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
         file.select();
         var src = document.selection.createRange().text;
         var src = document.selection.createRange().text;
         $newImgItem = $("<div class='uploadImageItem'>" +
         "<a href='javascript:void(0)'>" +
         "<img class='uploadImg' src='" + imgSrc + "'/>" +
         "</a>" +
         "<a class='uploadDelete' href='javascript:void(0)'>delete</a>" +
         "</div>");
         $("#uploadImages").append($newImgItem);
         img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
         div.innerHTML = "<div id=divhead style='width:"+
         rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"
         +sFilter+src+"\"'></div>";*/
    }
}


$(".application_delete_btn").click(function() {
    $(this).parent().parent().remove();
});


$(".seller_delete_btn").click(function() {
    $(this).parent().parent().remove();
});


$(".seller_ban_btn").click(function() {
    if ($(this).html() == "Ban") {
        $(this).html("Restore");
        $(this).parent().parent().css("background-color", "#A00000").css("color", "#ffffff");
    } else {
        $(this).html("Ban");
        $(this).parent().parent().css("background-color", "#ffffff").css("color", "#000000");
    }
});

$(".buyer_delete_btn").click(function() {
    $(this).parent().parent().remove();
});


$(".buyer_ban_btn").click(function() {
    if ($(this).html() == "Ban") {
        $(this).html("Restore");
        $(this).parent().parent().css("background-color", "#A00000").css("color", "#ffffff");
    } else {
        $(this).html("Ban");
        $(this).parent().parent().css("background-color", "#ffffff").css("color", "#000000");
    }
});

$(".application_pass_btn").click(function() {
    $(this).parent().parent().css("background-color", "#69FFA5").css("color", "#000000");
    $(this).next().remove();
    $(this).remove();
    $.get("XXX", {}, function() {

    });
});

$(".application_fail_btn").click(function() {
    $(this).parent().parent().css("background-color", "#FFA0A0").css("color", "#000000");
    $(this).prev().remove();
    $(this).remove();
    $.get("XXX", {}, function() {

    });
});




$(".admin_nofify_delete").click(function() {
    $(this).parent().parent().parent().remove();
});

$("#adminLoginBtn").click(function() {
    var name = $("#adminUsername").val();
    var pw   = $("#adminPassword").val();
    if (name == "") {
        $("#adminError").html("please enter username").show();
    } else if (pw == "") {
        $("#adminError").html("please enter password").show();
    } else {
        $.post("XXX", {
            name: name,
            password: pw
        }, function(data) {
            if (data == "no user") {
                $("#adminError").html("no such administrator").show();
            } else if (data == "wrong pw") {
                $("#adminError").html("wrong password, try again").show();
            } else {
                //window.location.reload()
            }
        });
    }
});












