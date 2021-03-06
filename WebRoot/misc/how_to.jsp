<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 6/22/2014
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Store</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../css/misc/howtoshop.css" />
    <link rel="stylesheet" type="text/css" href="../css/common.css">
</head>
<body>
<%@ include file="../include/header.jsp" %>


<div id="categorybarDiv">
    <%@ include file="../include/categorybar.jsp" %>
</div>
<div id="mainContent">
    <div id="storeItemList">
        <div id="howtoshop">
            <div id="howtoshop_title">
                <h1>HOW TO SHOP</h1>
                <p><b>Welcome to PARKnSHOP Online Shopping!</b></p>
                <p>Simply follow these steps to shop easily, quickly and enjoyably.</p>
                <ul>
                    <li> Login or select your delivery district as "Guest Visit"</li>
                    <li>Add products to your shopping cart </li>
                    <li>Checkout </li>
                </ul>
                <p>Your order will arrive at your door during your chosen delivery time.</p>
                <br>
                <br>
                <p>Have fun shopping!</p>
                <img src="../images/misc/howtoshop_image.jpg"/>
            </div>


        </div>
    </div>
</div>


<%@ include file="../include/footer.jsp" %>


<script src="../js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.js" type="text/javascript"></script>
<script src="../js/categorybar.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
</body>
</html>