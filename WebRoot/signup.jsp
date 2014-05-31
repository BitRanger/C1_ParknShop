<%--
  Created by IntelliJ IDEA.
  User: Jack
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
                <form style="margin:0" action="<%=request.getContextPath()%>/register" method="post">
                    <input name="username" class="signup_input" type="text" placeholder="Pick a username"><br>
                    <input name="email" class="signup_input" type="text" placeholder="Your email"><br>
                    <input name="password" class="signup_input" type="password" placeholder="Create a password"><br>
                    <input class="signup_input" type="password" placeholder="Confirm password"><br>
                    <div id="signup_user_agreement">
                        <input type="checkbox">
                        <span>I have read and accepted the <a href="#">User Agreement</a> </span>
                    </div>
                    <input class="signup_input" type="submit" value="Signup"><br>
                </form>
            </div>
        </div>
    </div>
</div>



<%@ include file="include/footer.jsp" %>

<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/index.js" type="text/javascript"></script>
</body>
</html>























