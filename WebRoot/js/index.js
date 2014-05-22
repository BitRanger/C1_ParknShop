/**
 * Created by Jack on 5/16/2014.
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

$("#discount_areaWrapper").mouseenter(function() {
    $(".discount_navBtn").show();
}).mouseleave(function() {
    $(".discount_navBtn").hide();
});


var discount_leftBtn = document.getElementById("discount_leftBtn");
var discount_rightBtn = document.getElementById("discount_rightBtn");
var discount_area = document.getElementById("discount_area");

var position_for_discount = 0;
var discount_move_left;
var discount_move_right;
discount_leftBtn.onclick = function() {
    if (position_for_discount < 0) {
        var shift = 0;
        discount_move_left = function() {
            if (shift < 700) {
                shift += 50;
                position_for_discount += 50;
                discount_area.style.left = parseInt(position_for_discount) + "px";
                setTimeout("discount_move_left()", 20);
            }
        };
        discount_move_left();
    }
};

discount_rightBtn.onclick = function() {
    if (position_for_discount > -1400) {
        var shift = 0;
        discount_move_right = function() {
            if (shift < 700) {
                shift += 50;
                position_for_discount -= 50;
                discount_area.style.left = parseInt(position_for_discount) + "px";
                setTimeout("discount_move_right()", 20);
            }
        };
        discount_move_right();
    }
};







