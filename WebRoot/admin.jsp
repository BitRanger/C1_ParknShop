<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Store</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/admin_css/admin.css" />
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script src="js/Chart.min.js" type="text/javascript"></script>
    <script src="js/geo.js" type="text/javascript"></script>
    <script src="ckeditor/ckeditor.js"></script>
</head>

<body onload="setup();preselect('陕西省');">

<div id="adminHeaderWrapper">
    <div id="adminHeader">
        <div id="adminLogoDiv">
            <a href="index.jsp"><img style="width:180px" src="images/logo.jpg"/></a>
        </div>
    </div>
</div>

<div style="margin-top: 100px" id="mainContent">
    <div id="storeItemList">
        <div id="admin_center">
            <div class="left" id="adminControl">
                <div id="adminAvatar"><img id="adminAvatarImg" src="images/avatar.jpg"></div>
                <ul>
                    <li class="adminControlItem" data-target="#admin_basicInfo">
                        <span>Account Info</span>
                    </li>
                    <li class="adminControlItem" data-target="#admin_security">
                        <span>Security</span>
                    </li>
                    <li class="adminControlItem" data-target="#admin_buyer">
                        <span>Manage Buyer</span>
                    </li>
                    <li class="adminControlItem" data-target="#admin_seller">
                        <span>Manage Seller</span>
                    </li>
                    <li class="adminControlItem" data-target="#admin_ad">
                        <span>Manage Ad</span>
                    </li>
                    <li class="adminControlItem" data-target="#admin_notification">
                        <span>Notification</span>
                    </li>
                    <li class="adminControlItem" data-target="#admin_finance">
                        <span>Finance</span>
                    </li>
                </ul>
            </div>
            <div class="left adminContent" id="admin_basicInfo">
                <%@ include file="admin/admin_basicInfo.jsp" %>
            </div>
            <div class="left adminContent" id="admin_security">
                <%@ include file="admin/admin_security.jsp" %>
            </div>
            <div class="left adminContent" id="admin_buyer">
                <%@ include file="admin/admin_dealbuyer.jsp" %>
            </div>
            <div class="left adminContent" id="admin_seller">
                <%@ include file="admin/admin_dealseller.jsp" %>
            </div>
            <div class="left adminContent" id="admin_ad">
                <%@ include file="admin/admin_ad.jsp" %>
            </div>
            <div class="left adminContent" id="admin_notification">
                <%@ include file="admin/admin_notification.jsp" %>
            </div>
            <div class="left adminContent" id="admin_finance">
                <%@ include file="admin/admin_finance.jsp" %>
            </div>
        </div>
    </div>

</div>


<%@ include file="include/footer.jsp" %>



<script src="js/admin.js" type="text/javascript"></script>
<script src="js/common.js" type="text/javascript"></script>
</body>
</html>
