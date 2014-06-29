/**
 * Created by kaidi on 6/1/14.
 */

function trackOrder() {
    window.location.href = "buyer.jsp";
}


$('#loginModal').on('hidden.bs.modal', function () {
    $(".loginMessage").html("User Login").removeClass("errorMessage");
});

function dealLogin() {
    if (checkLogin()) {
        ajax_submit_login();
    }
}

function checkLogin() {
    var username = document.getElementById('loginForm').username.value;
    if (username == "") {
        $(".loginMessage").html("Please enter username!").addClass("errorMessage");
        return false;
    }
    var password = document.getElementById('loginForm').password.value;
    if (password == "") {
        $(".loginMessage").html("Please give password!").addClass("errorMessage");
        return false;
    }
    $(".loginMessage").html("User Login").removeClass("errorMessage");
    return true;
}

function ajax_submit_login() {
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var result = xmlhttp.responseText;
            if (result == "login_succeed") {
                $('#loginModal').modal('hide');
                window.location.href = "index.php";
            } else if (result == "user_not_exist") {
                $(".loginMessage").html("user not exist").addClass("errorMessage");
            } else {
                $(".loginMessage").html("wrong password. Please try again").addClass("errorMessage");
            }
        }
    };
    var username = document.getElementById("loginForm").username.value;
    var password = document.getElementById("loginForm").password.value;

    var sendMessage = "username=" + username + "&password=" + password;

    xmlhttp.open("POST", "deal_page/deal_login.php", true);
    xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlhttp.send(sendMessage);
}
function ajax_logout() {
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var result = xmlhttp.responseText;
            if (result == "logout") {
                window.location.href = "index.php";
            }
        }
    };
    xmlhttp.open("GET", "deal_page/deal_logout.php", true);
    xmlhttp.send();
}


<<<<<<< HEAD
$("input[name=address]").click(function() {
    $("input[name=address]").parent().removeClass("comfirm_address_item_selected");
=======
$("input[name=psRecipientId]").click(function() {
    $("input[name=psRecipientId]").parent().removeClass("comfirm_address_item_selected");
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
    $(this).parent().addClass("comfirm_address_item_selected");
});

$("input[name=payment]").click(function() {
<<<<<<< HEAD
    $("#bankExtra").hide();
=======
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
    $("input[name=payment]").parent().removeClass("payListItem_selected");
    $(this).parent().addClass("payListItem_selected");
});

<<<<<<< HEAD
$("#bankSelectInput").click(function() {
    $("#bankExtra").show();
});

=======
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
$("#comfirm_addAddressBtn").click(function() {
    var province = document.getElementById("confirmAddr_div").province.value;
    var city = document.getElementById("confirmAddr_div").city.value;
    var town = document.getElementById("confirmAddr_div").town.value;
    var zipcode = document.getElementById("confirmAddr_div").zipcode.value;
    var street = document.getElementById("confirmAddr_div").street.value;
    var receiver = document.getElementById("confirmAddr_div").receiver.value;
    var phonenum = document.getElementById("confirmAddr_div").phonenum.value;

    var address = province + " " + city + " " + town + " " +
<<<<<<< HEAD
        street + " " + "ï¼ˆ" + receiver + " æ”¶ï¼‰";
=======
    street + " " + "£¨" + receiver + " ÊÕ£©";
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79

    $newAddr = $("<div class='comfirm_address_item'>" +
                 "<input type='radio' name='address' value=" + address + ">" +
                 "<label style='margin-left: 3px;'>" + address + "</label>" +
                 "<em>" + phonenum + "</em>" +
                 "</div>");
    $("#address_form").append($newAddr);
    $("input[name=address]").click(function() {
        $("input[name=address]").parent().removeClass("comfirm_address_item_selected");
        $(this).parent().addClass("comfirm_address_item_selected");
    });
    $('#newAddress').modal('hide')
});

<<<<<<< HEAD
$(".itemCart_quantityChange").click(function() {
    if ($(this).html() == "+") {
        var num1 = $(this).prev().val();
        num1++;
        $(this).prev().val(num1);
    } else {
        var num2 = $(this).next().val();
        if (num2 > 1) {
            num2--;
        }
        $(this).next().val(num2);
    }
});

=======
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79



















