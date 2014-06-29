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
    <link rel="stylesheet" type="text/css" href="../css/misc/gift.css" />
    <link rel="stylesheet" type="text/css" href="../css/common.css">
</head>
<body>
<%@ include file="../include/header.jsp" %>


<div id="categorybarDiv">
    <%@ include file="../include/categorybar.jsp" %>
</div>
<div id="mainContent">
    <div id="storeItemList">
        <div id="gift">
            <div id="gift_title">
                <h1>GIFT COUPON</h1>
                <p>PARKnSHOP Gift Coupon Ordering
                    $50 and $100 Gift Coupon are now available for sale at all PARKnSHOP stores.
                    For purchase of PARKnSHOP Gift Coupon over $10,000, please contact 2606 8827 or
                    2606 8842. </p>
                <img src="../images/misc/img_gift.png"/>
            </div>
            <div id="gift_attention">
                PARKnSHOP cash coupon is not applicable to
                PARKnSHOP.com, telephone and fax ordering.
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