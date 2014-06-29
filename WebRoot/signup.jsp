<%--
  Created by IntelliJ IDEA.
  User: Kaidi
  Date: 5/17/2014
  Time: 09:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Store</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/signup.css">
</head>
<body>
<div id="signupHeaderWrapper">
    <div id="signupHeader">
        <div id="signupLogoDiv">
            <a href="index.jsp"><img style="width:180px" src="images/logo.jpg"/></a>
        </div>
    </div>
</div>
<div id="signupMainWrapper">
    <div id="signupMain">
        <div id="signMainLeft">
            <div id="signMainLeftText">
                <h1>Start your Trade on ParknShop.com</h1>
                <ul>
                    <li>
                        <span><strong>45</strong> million members in <strong>190+</strong> countries</span>
                    </li>
                    <li>
                        <span>Over <strong>2 million</strong> supplier storefronts</span>
                    </li>
                    <li>
                        <span>Safe and simple trade solutions</span>
                    </li>
                </ul>
            </div>
        </div>
        <div id="signupMainRight">
            <div id="signupPanel">
                <div class="signupMessage">Sign up, trade world</div>
<<<<<<< HEAD
                <form style="margin:0" id="signupForm" method="post" onsubmit="return deal_signup()" action="<%=request.getContextPath()%>/register">
=======
                <form style="margin:0" id="signupForm" method="post" submit="return deal_signup()" action="<%=request.getContextPath()%>/register">
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
                    <input class="signup_input" type="text" name="username" placeholder="Pick a username"><br>
                    <input class="signup_input" type="text" name="email" placeholder="Your email"><br>
                    <input class="signup_input" type="password" name="password" placeholder="Create a password"><br>
                    <input class="signup_input" type="password" name="pwconfirm" placeholder="Confirm password"><br>
<<<<<<< HEAD
					<div id="signup_type">
=======
                    <div id="signup_type">
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
                        <input type="radio" checked="checked" name="role" value="buyer">Buyer
                        <input style="margin-left: 30px" type="radio" name="role" value="seller">Seller
                    </div>
                     <div id="signup_user_agreement">
                        <input type="checkbox">
                        <span>I have read and accepted the <a href="#">User Agreement</a> </span>
                    </div>
                    <input class="signup_input" type="submit" value="Signup" ><br>
                </form>
            </div>
        </div>
    </div>
</div>



<%@ include file="include/footer.jsp" %>

<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/signup.js" type="text/javascript"></script>
</body>
</html>























