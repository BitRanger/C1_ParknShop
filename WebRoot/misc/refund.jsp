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
    <link rel="stylesheet" type="text/css" href="../css/misc/refund.css" />
    <link rel="stylesheet" type="text/css" href="../css/common.css">
</head>
<body>
<%@ include file="../include/header.jsp" %>


<div id="categorybarDiv">
    <%@ include file="../include/categorybar.jsp" %>
</div>
<div id="mainContent">
    <div id="storeItemList">
        <div id="refund">
            <div id="refund_title">
                <h1>REFUND / REPLACE GUARANTEE</h1>
                <p>We take pride in offering our customers good quality. If you are dissatisfied with any purchase made at this store, we will be happy to refund or replace it with product of same value after verification.</p>
                <img src="../images/misc/img_replace_refund.jpg"/>
            </div>
            <div>
                <div class="listitem">Remarks</div>
                <div class="listItemContent">
                    <table width="70%" border="0" cellpadding="0" cellspacing="0">
                        <tbody><tr>
                            <td width="10" valign="top"><img src="../images/misc/icon_02.gif"></td>
                            <td>Original receipt must be shown.</td>
                        </tr>
                        <tr>
                            <td valign="top"><img src="../images/misc/icon_02.gif"></td>
                            <td>Refund is applicable to expired or own-brand products, all other products are applicable for replacement.</td>
                        </tr>
                        </tbody></table>
                </div>
                <div class="listitem">Refund / Replace on Online Shopping</div>
                <div class="listItemContent">
                    <table width="70%" border="0" cellpadding="0" cellspacing="0">
                        <tbody><tr>
                            <td width="10" valign="top"><img src="../images/misc/icon_02.gif"></td>
                            <td>Please call the home delivery hotline at 2690 0948 within 7 days of the delivery date.</td>
                        </tr>
                        <tr>
                            <td valign="top"><img src="../images/misc/icon_02.gif"></td>
                            <td> There are two methods of refund:<br>
                                1. Deducted the refund amount of your next  order.<br>
                                2. Credited into your credit card account within four weeks, upon confirmation. </td>
                        </tr>
                        </tbody></table>
                </div>
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