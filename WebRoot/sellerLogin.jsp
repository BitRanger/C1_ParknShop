<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 6/28/2014
  Time: 01:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>seller Login</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/seller_css/sellerLogin.css" />
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <style>
        .sellerError {
            border: 1px solid #ff0000;
            box-shadow: 0 0 3px #ff0000;
        }
    </style>
</head>
<body>
<div id="sellerHeaderWrapper">
    <div id="sellerHeader">
        <div id="sellerLogoDiv">
            <a href="index.jsp"><img style="width:180px" src="images/logo.jpg"/></a>
        </div>
    </div>
</div>

<div style="margin-top: 100px" id="mainContent">
    <div id="storeItemList">
        <div id="sellerLoginTitle">Seller Login</div>
        <form id="sellerLoginForm" method="post" action="seller/sellerlogin">
            <div id="sellerError"></div>
            <div>
                <label class="common_label">Username</label>
                <input type="text" class="common_input" id="email" name="email">
            </div>
            <div>
                <label class="common_label">Password</label>
                <input type="password" class="common_input" id="password" name="password">
            </div>
            <div>
                <input class="common_btn" type="submit" value="Login" id="sellerLoginBtn">
            </div>
        </form>
    </div>
</div>

<%@ include file="include/footer.jsp" %>

<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="js/seller.js" type="text/javascript"></script>
</body>
</html>
