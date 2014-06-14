<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 6/2/2014
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Store</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/seller_css/seller.css" />
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <script src="js/geo.js" type="text/javascript"></script>
    <script src="ckeditor/ckeditor.js"></script>
</head>
<body onload="setup();preselect('陕西省');">
<%@ include file="include/header.jsp" %>

<div style="margin-top: 100px" id="mainContent">
    <div id="storeItemList">
        <div id="seller_center">
            <div class="left" id="sellerControl">
                <div id="sellerAvatar"><img id="sellerAvatarImg" src="images/avatar.jpg"></div>
                <ul>
                    <li class="sellerControlItem" data-target="#seller_basicInfo">
                        <span>Account Info</span>
                    </li>
                    <li class="sellerControlItem" data-target="#seller_security">
                        <span>Security</span>
                    </li>
                    <li class="sellerControlItem" data-target="#seller_publish">
                        <span>Publish Product</span>
                    </li>
                    <li class="sellerControlItem" data-target="#seller_list">
                        <span>ProductList</span>
                    </li>
                    <li class="sellerControlItem" data-target="#seller_recycle">
                        <span>Recycle</span>
                    </li>
                    <li class="sellerControlItem" data-target="#seller_record">
                        <span>Record</span>
                    </li>
                    <li class="sellerControlItem" data-target="#seller_notification">
                        <span>Notification</span>
                    </li>
                    <li class="sellerControlItem" data-target="#seller_finance">
                        <span>Finance</span>
                    </li>
                </ul>
            </div>
            <div class="left sellerContent" id="seller_basicInfo">
                <%@ include file="seller/seller_basicInfo.jsp" %>
            </div>
            <div class="left sellerContent" id="seller_security">
                <%@ include file="seller/seller_security.jsp" %>
            </div>
            <div class="left sellerContent" id="seller_publish">
                <%@ include file="seller/seller_publish.jsp" %>
            </div>
            <div class="left sellerContent" id="seller_list">
                <%@ include file="seller/seller_list.jsp" %>
            </div>
            <div class="left sellerContent" id="seller_recycle">
                <%@ include file="seller/seller_recycle.jsp" %>
            </div>
            <div class="left sellerContent" id="seller_record">
                <%@ include file="seller/seller_record.jsp" %>
            </div>
            <div class="left sellerContent" id="seller_notification">
                <%@ include file="seller/seller_notification.jsp" %>
            </div>
            <div class="left sellerContent" id="seller_finance">
                <%@ include file="seller/seller_finance.jsp" %>
            </div>
        </div>
    </div>

</div>


<%@ include file="include/footer.jsp" %>


<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>

<script src="js/seller.js" type="text/javascript"></script>
<script src="js/common.js" type="text/javascript"></script>
</body>
</html>
