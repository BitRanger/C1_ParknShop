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



















