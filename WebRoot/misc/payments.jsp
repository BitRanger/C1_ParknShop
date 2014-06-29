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
    <link rel="stylesheet" type="text/css" href="../css/misc/payments.css" />
    <link rel="stylesheet" type="text/css" href="../css/common.css">
</head>
<body>
<%@ include file="../include/header.jsp" %>


<div id="categorybarDiv">
    <%@ include file="../include/categorybar.jsp" %>
</div>
<div id="mainContent">
    <div id="storeItemList">
        <div id="payments">
            <div id="payments_title">
                <h1>PAYMENT METHODS</h1>
            </div>
            <div>
                <div class="listitem">We accept the following payment methods</div>
                <div class="listItemContent">
                    <div class="imgRow">
                        <div>
                            <img src="../images/misc/cash.gif"><br>
                            <span>Cash on Delivery</span>
                        </div>
                        <div>
                            <img src="../images/misc/mastercard.gif"><br>
                            <span>Master Card</span>
                        </div>
                        <div>
                            <img src="../images/misc/visa.gif"><br>
                            <span>Visa</span>
                        </div>
                        <div>
                            <img src="../images/misc/america%20express.gif"><br>
                            <span>America Express</span>
                        </div>
                    </div>
                    <div class="imgRow">
                        <div>
                            <img src="../images/misc/img_gift.png"><br>
                            <span>Gift Coupon</span>
                        </div>
                        <div>
                            <img src="../images/misc/alipay.JPG"><br>
                            <span>Alipay</span>
                        </div>
                        <div>
                            <img src="../images/misc/tenpay.jpg"><br>
                            <span>Tenpay</span>
                        </div>
                        <div>
                            <img src="../images/misc/unionpay.JPG"><br>
                            <span>Unionpay</span>
                        </div>
                    </div>
                    <div>
                        <p>Prices shown on PARKnSHOP.com are listed in Dollar and may vary from those found in store.</p>
                        <br>
                        <p>We accept Visa, MasterCard, American Express, Cash On Delivery, Gift Coupon, Alipay, Tenpay and Unionpay. The total amount cannot exceed $10,000 if you pay by Visa or MasterCard. If you are paying with a credit card, please enter the card number without spaces or dashes. If you are paying with alipay or tenpay, please be sure their own payment policies. If you are paying with unionpay, please visit your online bank for more information. For prices that are determined by the weight of products, 5% of your total purchase amount will be held and reserved from your Visa or MasterCard account. The actual cost of your purchase will be charged towards your account and will be shown on the receipt when your order is delivered.</p>
                    </div>
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