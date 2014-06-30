/**
 * Created by Kaidi on 6/2/2014.
 */

var seller_upload_image_num = 0;
$("#seller_basicInfo").show();
$(".sellerControlItem").click(function() {
    $(".sellerContent").hide();
    $($(this).data("target")).show();
}).mouseenter(function() {
    $(this).css("background-color", "#166496");
}).mouseleave(function() {
    $(this).css("background-color", "#133D58");
});

$("#chooseCategoryBtn").click(function() {
    $("#seller_categoryList").show();
});

$("#seller_categoryList").mouseleave(function() {
    $(this).hide();
});

$(".seller_categoryListItem").mouseenter(function() {
    $(this).css("background-color", "#189918");
    $(this).css("color", "#ffffff");
}).mouseleave(function() {
    $(this).css("background-color", "#efefef");
    $(this).css("color", "#333333");
}).click(function() {
    $("#sellerCategoryTag").show();
});

$(".sellerCategoryTagItem").click(function() {
    if ($(this).data("state") == "0") {
        $(this).css("background-color", "#189918");
        $(this).css("color", "#ffffff");
        $(this).data("state", "1");
    } else {
        $(this).css("background-color", "#efefef");
        $(this).css("color", "#333333");
        $(this).data("state", "0");
    }
});

function choose_category() {

}

function showDelete() {
    $(".uploadImageItem").mouseenter(function() {
        $(this).find(".uploadDelete").show();
    }).mouseleave(function() {
        $(this).find(".uploadDelete").hide();
    });
}

function deleteParent() {
    $(".uploadDelete").click(function() {
        var index = $(this).parent().index();
        $(this).parent().remove();
        if (index != -1) {
            $("#fileInput").children().eq(index).remove();
        }
    });
}

function decreaseImgNum() {
    //var index =
    seller_upload_image_num--;
    if (seller_upload_image_num < 5) {
        $("#upload").show();
    }
}


$("#upload").click(function() {
    var id= new Date().getTime();
    var $newImgUpload = $("<input style='display: none' id='imgFile" + id + "' type='file' name='imgFile" + id + "' onchange='previewImage(this)'>");
    $("#fileInput").append($newImgUpload);
    $("#imgFile" + id).click();
});
function previewImage(file)
{
	console.log(file.value);
    seller_upload_image_num++;
    if (seller_upload_image_num >= 5) {
        $("#upload").hide();
    }
    if (file.files && file.files[0])
    {
        var reader = new FileReader();
        reader.onload = function(evt) {
            var imgSrc = evt.target.result;
            var $newImgItem = $("<div class='uploadImageItem'>" +
                "<a href='javascript:void(0)'>" +
                "<img data='" + file.value + "' class='uploadImg' src='" + imgSrc + "'/>" +
                "</a>" +
                "<a onclick='decreaseImgNum()' class='uploadDelete' href='javascript:void(0)'>delete</a>" +
                "</div>");

            $("#uploadImages").append($newImgItem);
            showDelete();
            deleteParent();
        };
        reader.readAsDataURL(file.files[0]);
    }
    else //for IE
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


function ad_uploadImage() {
    $("#ad_imgFile").click();
}



function ad_previewImage(file)
{
    isAdUpload = 1;
    if (isAdUpload == 1) {
        $("#ad_upload").hide();
    }
    if (file.files && file.files[0])
    {
        var reader = new FileReader();
        reader.onload = function(evt) {
            var imgSrc = evt.target.result;
            $newImgItem = $("<div class='ad_uploadImageItem'>" +
                "<a href='javascript:void(0)'>" +
                "<img class='ad_uploadImg' src='" + imgSrc + "'/>" +
                "</a>" +
                "<a class='ad_uploadDelete' href='javascript:void(0)'>delete</a>" +
                "</div>");
            $("#ad_uploadImages").append($newImgItem);
            $(".ad_uploadImageItem").mouseenter(function() {
                $(this).find(".ad_uploadDelete").show();
            }).mouseleave(function() {
                $(this).find(".ad_uploadDelete").hide();
            });
            $(".ad_uploadDelete").click(function() {
                $(this).parent().remove();
                isAdUpload = 0;
                $("#ad_upload").show();
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


$("#sellerLoginBtn").click(function() {
    var name = $("#sellerUsername").val();
    var pw   = $("#sellerPassword").val();
    if (name == "") {
        $("#sellerError").html("please enter username").show();
    } else if (pw == "") {
        $("#sellerError").html("please enter password").show();
    } else {
        $.post("XXX", {
            name: name,
            password: pw
        }, function(data) {
            if (data == "no user") {
                $("#sellerError").html("no such selleristrator").show();
            } else if (data == "wrong pw") {
                $("#sellerError").html("wrong password, try again").show();
            } else {
                //window.location.reload()
            }
        });
    }
});




























