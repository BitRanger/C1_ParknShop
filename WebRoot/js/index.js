/**
 * Created by Jack on 5/16/2014.
 */


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







