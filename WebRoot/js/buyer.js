/**
 * Created by Kaidi on 5/31/2014.
 */

$(".buyerControlItem").click(function() {
    $(".buyerContent").hide();
    $($(this).data("target")).show();
}).mouseenter(function() {
    $(this).css("background-color", "#166496");
}).mouseleave(function() {
    $(this).css("background-color", "#133D58");
});

function confirm_address() {
    var province = document.getElementById("address_div").province.value;
    var city = document.getElementById("address_div").city.value;
    var town = document.getElementById("address_div").town.value;
    var zipcode = document.getElementById("address_div").zipcode.value;
    var street = document.getElementById("address_div").street.value;
    var receiver = document.getElementById("address_div").receiver.value;
    var phonenum = document.getElementById("address_div").phonenum.value;

    $newtr = $("<tr>" +
        "<td>" + receiver + "</td>" +
        "<td>" + province + " " + city + " " + town + "</td>" +
        "<td>" + street + "</td>" +
        "<td>" + zipcode + "</td>" +
        "<td>" + phonenum + "</td>" +
        "<td><a href='#'>Modify</a> <a href='#'>Delete</a></td>");
    $("#saveAddressTable").append($newtr);
}


$(".comment_star_item>i").click(function(event) {
    var rating = event.target;
    var left = pointerX(event) - rating.offsetLeft;
    if (0 <= left && left < 16) {
        $(this).removeClass($(this).attr("class"));
        $(this).addClass("bitranger_1_star");
        $(this).data("rating", "1");
        $(this).next().hide();
    } else if (16 <= left && left < 32) {
        $(this).removeClass($(this).attr("class"));
        $(this).addClass("bitranger_2_star");
        $(this).data("rating", "2");
        $(this).next().hide();
    } else if (32 <= left && left < 48) {
        $(this).removeClass($(this).attr("class"));
        $(this).addClass("bitranger_3_star");
        $(this).data("rating", "3");
        $(this).next().hide();
    } else if (48 <= left && left < 64) {
        $(this).removeClass($(this).attr("class"));
        $(this).addClass("bitranger_4_star");
        $(this).data("rating", "4");
        $(this).next().hide();
    } else if (64 <= left && left < 80) {
        $(this).removeClass($(this).attr("class"));
        $(this).addClass("bitranger_5_star");
        $(this).data("rating", "5");
        $(this).next().hide();
    }
});

function pointerX(event)
{
    return event.pageX || (event.clientX + (document.documentElement.scrollLeft || document.body.scrollLeft));
}

function pointerY(event)
{
    return event.pageY || (event.clientY + (document.documentElement.scrollTop || document.body.scrollTop));
}

function checkComment() {
    if ($("#item_comment_area").val() == "") {
        $("#comment_error").show();
        return false;
    }
    if ($("#rating1").data("rating") == 0) {
        $("#rating1").next().css("display", "inline-block");
        return false;
    }
    if ($("#rating2").data("rating") == 0) {
        $("#rating2").next().css("display", "inline-block");
        return false;
    }
    if ($("#rating3").data("rating") == 0) {
        $("#rating3").next().css("display", "inline-block");
        return false;
    }
    if ($("#rating4").data("rating") == 0) {
        $("#rating4").next().css("display", "inline-block");
        return false;
    }
    return true;
}

$("#item_comment_area").keyup(function() {
    $("#comment_error").hide();
});




