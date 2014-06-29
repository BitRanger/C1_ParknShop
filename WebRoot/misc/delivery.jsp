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
    <link rel="stylesheet" type="text/css" href="../css/misc/delivery.css" />
    <link rel="stylesheet" type="text/css" href="../css/common.css">
</head>
<body>
<%@ include file="../include/header.jsp" %>


<div id="categorybarDiv">
    <%@ include file="../include/categorybar.jsp" %>
</div>
<div id="mainContent">
    <div id="storeItemList">
        <div id="delivery">
            <div id="delivery_title">
                <h1>DELEVERY DETAILS</h1>
            </div>
            <div>
                <div class="listitem">Convenient Delivery Times</div>
                <div class="listItemContent" style="position: relative; height: 100px">
                    <table width="500" border="0" cellpadding="0" cellspacing="0" class="table01">      <tbody><tr>        <td colspan="2"><strong class="bigfont2">The following delivery time slots are available.</strong></td>      </tr>      <tr>        <th width="250">Delivery time slot</th>        <th width="250">Order deadline</th>      </tr>      <tr>        <td>9:00 a.m. - 1:00 p.m.</td>        <td>By 3:00 p.m. on the previous day</td>      </tr>      <tr>        <td>2:00 p.m. - 6:00 p.m.</td>        <td>8:00 a.m. on day of delivery</td>      </tr>      <tr>        <td>7:00 p.m. - 10:00 p.m.</td>        <td>11:00 a.m. on day of delivery</td>      </tr>    </tbody></table>
                    <img id="delivery_img" src="../images/misc/img_delivery_details.jpg">
                </div>
                <div class="listitem">Notes</div>
                <div class="listItemContent">
                    <table width="90%" border="0" cellpadding="0" cellspacing="0">            <tbody><tr>                <td width="10" valign="top"><img src="../images/misc/icon_02.gif"></td>                <td>Our next day service only applies to office delivery orders.</td>            </tr>            <tr>                <td valign="top"><img src="../images/misc/icon_02.gif"></td>                <td>Order will be delivered within 7 days from the day of order.</td>            </tr>            <tr>                <td valign="top"><img src="../images/misc/icon_02.gif"></td>                <td>Delivery will be delayed if a typhoon signal No.8 is raised or a black rainstorm warning is in effect. </td>            </tr>            <tr>                <td valign="top"><img src="../images/misc/icon_02.gif"></td>                <td>Delivery service is not available for the Outlying Islands. (except Ma Wan, Discovery Bay, Tung Chung &amp; Hong Kong International Airport)</td>          </tr>            <tr>                <td valign="top"><img src="../images/misc/icon_02.gif"></td>                <td>As all vehicles are prohibited from entering Ma Wan after 4:00 p.m., only the 10:00 a.m. to 1:00 p.m. and from 2:00 p.m. to 4:00 p.m. delivery time slots are available for orders to be delivered there.</td>            </tr>            <tr>                <td valign="top"><img src="../images/misc/icon_02.gif"></td>                <td>    For bulk purchases of more than one case, we will confirm the delivery day with you directly.</td>            </tr>                    </tbody></table>
                </div>
                <div class="listitem">Charges</div>
                <div class="listItemContent">
                    <table width="90%" border="0" cellpadding="0" cellspacing="0">            <tbody><tr>                <td width="10" valign="top"><img src="../images/misc/icon_02.gif"></td>                <td>Home delivery is free when you spend $500 or more.</td>            </tr>            <tr>                <td valign="top"><img src="../images/misc/icon_02.gif"></td>                <td>Home delivery is available for $30 for purchases less than $500 (including delivery to Discovery Bay). </td>            </tr>        </tbody></table>
                </div>
                <div class="listitem">Remarks</div>
                <div class="listItemContent">
                    <table width="90%" border="0" cellpadding="0" cellspacing="0">            <tbody><tr>                <td width="10" valign="top"><img src="../images/misc/icon_02.gif"></td>                <td>Prices shown on PARKnSHOP.com may vary from those found in-store.</td>            </tr>            <tr>                <td valign="top"><img src="../images/misc/icon_02.gif"></td>                <td>The prices charged are those applicable <u>on the day you order</u>.</td>            </tr>            <tr>                <td valign="top"><img src="../images/misc/icon_02.gif"></td>                <td>The delivery service is only available in Hong Kong. There is no overseas delivery.</td>            </tr>            <tr>                <td valign="top"><img src="../images/misc/icon_02.gif"></td>                <td>Home delivery is not available to areas that cannot be reached directly by our vehicles, or buildings without a functioning lift to the 3/F or above.</td>            </tr>            <tr>              <td valign="top"><img src="../images/misc/icon_02.gif"></td>              <td>As our vehicles cannot reach Big Wave Bay Village, Shek O without permission letters, customers must collect deliveries to these areas in the car park.</td>            </tr>            <tr>                <td valign="top"><img src="../images/misc/icon_02.gif"></td>                <td>All orders are subject to confirmation of final availability and PARKnSHOP reserves the right to reject the order in the event that any of the products or services requested are unavailable. In the event that we are unable to fulfill any of the products or services in your order, we will notify you by phone or email before delivery.</td>            </tr><tr>                <td valign="top"><img src="../images/misc/icon_02.gif"></td>                <td>    Please note that all goods will be delivered as scheduled and to the best of our ability. We aim to deliver the goods when there is somebody in. We cannot accept responsibility for goods left outside at the customer's request.</td>            </tr>        </tbody></table>
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