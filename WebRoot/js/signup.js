/**
 * Created by Jack on 5/26/14.
 */


var name_is_taken = false;

function deal_signup() {
    if (check_signup()) {
    	return true;
    }
    return false;
}

function check_signup() {
    var username = document.getElementById("signupForm").username.value;
    if (username == "") {
        $(".signupMessage").html("Please enter a username!").addClass("errorMessage");
        return false;
    }

    var email = document.getElementById("signupForm").email.value;
    if (email == "") {
        if (!name_is_taken) {
            $(".signupMessage").html("Please give your email!").addClass("errorMessage");
        }
        return false;
    }

    if (!check_email_format()) {
        $(".signupMessage").html("Wrong email format!").addClass("errorMessage");
        return false;
    }

    var password = document.getElementById("signupForm").password.value;
    if (password == "") {
        if (!name_is_taken) {
            $(".signupMessage").html("Please choose a password!").addClass("errorMessage");
        }
        return false;
    }

    var pwconfirm = document.getElementById("signupForm").pwconfirm.value;
    if (pwconfirm != password) {
        if (!name_is_taken) {
            $(".signupMessage").html("Password do not match!").addClass("errorMessage");
        }
        return false;
    }

    if (name_is_taken) {
        $(".signupMessage").html("The username has been used!").addClass("errorMessage");
        return false;
    }

    $(".signupMessage").html("Sign up, trade world").removeClass("errorMessage");
    return true;
}
/*
function ajax_check_username() {
    var username = document.getElementById("signupForm").username.value;

    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var result = xmlhttp.responseText;
            if (result == "N") {
                $(".signupMessage").html("The username has been used!").addClass("errorMessage");
                name_is_taken = true;
            } else {
                $(".signupMessage").html("Welcome to Scatter Web").removeClass("errorMessage");
                name_is_taken = false;
            }
        }
    };

    xmlhttp.open("GET", "deal_page/deal_signup_username.php?username=" + username, true);
    xmlhttp.send();
}*/

function check_password() {
    if (!name_is_taken) {
        $(".signupMessage").html("Sign up, trade world").removeClass("errorMessage");
    }
}

function check_email_format() {
    var email = document.getElementById("signupForm").email.value;
    var Expression=/\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
    var objExp = new RegExp(Expression);
    return objExp.test(email);
}

















