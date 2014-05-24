/**
 * Created by Jack on 5/23/2014.
 */
$(document).ready(function() {
    $("#sub_electronics").hide();
    $("#sub_men").hide();
    $("#sub_women").hide();
    $("#sub_babyandkids").hide();
    $("#sub_bookandmedia").hide();
    $("#sub_food").hide();
    $("#sub_homeandkitchen").hide();
    $("#sub_more").hide();
    $(".discount_navBtn").hide();
});

$("#categorybar").mouseleave(function() {
    $("#sub_electronics").hide();
    $("#sub_men").hide();
    $("#sub_women").hide();
    $("#sub_babyandkids").hide();
    $("#sub_bookandmedia").hide();
    $("#sub_food").hide();
    $("#sub_homeandkitchen").hide();
    $("#sub_more").hide();
});

$(".categorybarListItem").mouseenter(function() {
    $(this).css("background-color", "#022C74");
}).mouseleave(function() {
    $(this).css("background-color", "#06113a");
})
;



$("#cate_electronics").mouseenter(function () {
    //$(this).css("background-color", "#022C74");
    $("#sub_electronics").show();
    $("#sub_men").hide();
    $("#sub_women").hide();
    $("#sub_babyandkids").hide();
    $("#sub_bookandmedia").hide();
    $("#sub_food").hide();
    $("#sub_homeandkitchen").hide();
    $("#sub_more").hide();
});

$("#cate_men").mouseenter(function () {
    $("#sub_electronics").hide();
    $("#sub_men").show();
    $("#sub_women").hide();
    $("#sub_babyandkids").hide();
    $("#sub_bookandmedia").hide();
    $("#sub_food").hide();
    $("#sub_homeandkitchen").hide();
    $("#sub_more").hide();
});

$("#cate_women").mouseenter(function () {
    $("#sub_electronics").hide();
    $("#sub_men").hide();
    $("#sub_women").show();
    $("#sub_babyandkids").hide();
    $("#sub_bookandmedia").hide();
    $("#sub_food").hide();
    $("#sub_homeandkitchen").hide();
    $("#sub_more").hide();
});

$("#cate_babyandkids").mouseenter(function () {
    $("#sub_electronics").hide();
    $("#sub_men").hide();
    $("#sub_women").hide();
    $("#sub_babyandkids").show();
    $("#sub_bookandmedia").hide();
    $("#sub_food").hide();
    $("#sub_homeandkitchen").hide();
    $("#sub_more").hide();
});

$("#cate_bookandmedia").mouseenter(function () {
    $("#sub_electronics").hide();
    $("#sub_men").hide();
    $("#sub_women").hide();
    $("#sub_babyandkids").hide();
    $("#sub_bookandmedia").show();
    $("#sub_food").hide();
    $("#sub_homeandkitchen").hide();
    $("#sub_more").hide();
});

$("#cate_food").mouseenter(function () {
    $("#sub_electronics").hide();
    $("#sub_men").hide();
    $("#sub_women").hide();
    $("#sub_babyandkids").hide();
    $("#sub_bookandmedia").hide();
    $("#sub_food").show();
    $("#sub_homeandkitchen").hide();
    $("#sub_more").hide();
});

$("#cate_homeandkitchen").mouseenter(function () {
    $("#sub_electronics").hide();
    $("#sub_men").hide();
    $("#sub_women").hide();
    $("#sub_babyandkids").hide();
    $("#sub_bookandmedia").hide();
    $("#sub_food").hide();
    $("#sub_homeandkitchen").show();
    $("#sub_more").hide();
});

$("#cate_more").mouseenter(function () {
    $("#sub_electronics").hide();
    $("#sub_men").hide();
    $("#sub_women").hide();
    $("#sub_babyandkids").hide();
    $("#sub_bookandmedia").hide();
    $("#sub_food").hide();
    $("#sub_homeandkitchen").hide();
    $("#sub_more").show();
});