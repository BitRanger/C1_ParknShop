/**
 * Created by Kaidi on 6/2/2014.
 */

var seller_upload_image_num = 0;

$(".sellerControlItem").click(function() {
    $(".sellerContent").hide();
    $($(this).data("target")).show();
}).mouseenter(function() {
    $(this).css("background-color", "#166496");
}).mouseleave(function() {
    $(this).css("background-color", "#133D58");
});


function choose_category() {

}

function uploadImage() {
    $("#imgFile").click();
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
        $(this).parent().remove();
    });
}

function decreaseImgNum() {
    seller_upload_image_num--;
    if (seller_upload_image_num < 5) {
        $("#upload").show();
    }
}



function previewImage(file)
{
    seller_upload_image_num++;
    if (seller_upload_image_num >= 5) {
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
                            "<a onclick='decreaseImgNum()' class='uploadDelete' href='javascript:void(0)'>delete</a>" +
                            "</div>");
            $("#uploadImages").append($newImgItem);
            showDelete();
            deleteParent();
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



























