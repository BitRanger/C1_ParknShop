/**
 * Created by Jack on 5/23/2014.
 */

$(".itemDetail_PicShow_thumbnail").mouseenter(function() {
    $(this).css("border", "2px solid #445599");
    $(this).css("box-shadow", "0px 1px 9px #4F2FCE");
    var url = $(this).attr("src");
    $("#itemDetail_PicShow_Big_img").attr("src", url);
}).mouseleave(function() {
    $(this).css("border", "none");
    $(this).css("box-shadow", "none");
});

$(".itemDescTabBtn").click(function() {
    $(".itemDescTabBtn").css("border-bottom", "none");
    $(this).css("border-bottom", "3px solid #224499");
});

$("#itemDescTabBtn_detail").click(function() {
    $("#itemDesc_Desc").show();
    $("#itemDesc_Comment").hide();
    $("#itemDesc_Record").hide();
});

$("#itemDescTabBtn_comment").click(function() {
    $("#itemDesc_Desc").hide();
    $("#itemDesc_Comment").show();
    $("#itemDesc_Record").hide();
});

$("#itemDescTabBtn_record").click(function() {
    $("#itemDesc_Desc").hide();
    $("#itemDesc_Comment").hide();
    $("#itemDesc_Record").show();
});








