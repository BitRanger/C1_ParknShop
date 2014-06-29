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
    <link rel="stylesheet" type="text/css" href="../css/misc/hotline.css" />
    <link rel="stylesheet" type="text/css" href="../css/common.css">
</head>
<body>
<%@ include file="../include/header.jsp" %>


<div id="categorybarDiv">
    <%@ include file="../include/categorybar.jsp" %>
</div>
<div id="mainContent">
    <div id="storeItemList">
        <div id="hotline">
            <h1 id="hotline_title">
                SERVICE HOTLINE
            </h1>
            <div>
                <div class="listitem">Home Delivery Hotline</div>
                <div class="listItemContent">
                    <p>If you have any comments or enquiries about our Internet, Telephone or Fax Home Delivery Service, please contact:</p>
                    <table class="ServiceTable" cellpadding="0" cellspacing="0">			<tbody><tr><td width="90"><img src="../images/misc/icon_tel.gif">Tel</td><td align="left" width="30">:</td><td width="180">7656 2238</td></tr>			<tr><td><img src="../images/misc/icon_fax.gif">Fax</td><td>:</td><td>2186 3389</td></tr>			<tr><td><img src="../images/misc/icon_email.gif">Email</td><td>:</td><td><a href="mailto:info@parknshop.com">info@parknshop.com</a></td>			</tr>			<tr><td><img src="../images/misc/icon_officehour.gif">Office Hours</td><td>:</td>			<td>Mon - Sun 9:00a.m. - 10:00p.m.</td>			</tr>		</tbody></table>
                </div>
                <div class="listitem">Customer Service Department</div>
                <div class="listItemContent">
                    <p>For enquiries about other services, please contact:</p>
                    <table class="ServiceTable" cellpadding="0" cellspacing="0">			<tbody><tr><td width="90"><img src="../images/misc/icon_tel.gif">Tel</td><td align="left" width="30">:</td><td width="180">7756 3200</td></tr>			<tr><td><img src="../images/misc/icon_fax.gif">Fax</td><td>:</td><td>2145 4161</td></tr>			<tr><td><img src="../images/misc/icon_email.gif">Email</td><td>:</td><td><a href="mailto:care@parknshop.com">care@parknshop.com</a></td>			</tr>			<tr><td><img src="../images/misc/icon_officehour.gif">Office Hours</td><td>:</td>			<td>7 x 24 Customer Care</td>			</tr>		</tbody></table>
                </div>
                <div class="listitem">Advertisement</div>
                <div class="listItemContent">
                    <p>If you want to put some ads on our site, please contact:</p>
                    <table class="ServiceTable" cellpadding="0" cellspacing="0">			<tbody><tr><td width="90"><img src="../images/misc/icon_tel.gif">Tel</td><td align="left" width="30">:</td><td width="180">7346 1297</td></tr>			<tr><td><img src="../images/misc/icon_fax.gif">Fax</td><td>:</td><td>2189 774</td></tr>			<tr><td><img src="../images/misc/icon_email.gif">Email</td><td>:</td><td><a href="mailto:ad@parknshop.com">ad@parknshop.com</a></td>			</tr>			<tr><td><img src="../images/misc/icon_officehour.gif">Office Hours</td><td>:</td>			<td>Mon - Sun 9:00a.m. - 6:00p.m.</td>			</tr>		</tbody></table>
                </div>
                <div class="listitem">Head Office</div>
                <div class="listItemContent">
                    <table class="ServiceTable" cellpadding="0" cellspacing="0">			<tbody><tr><td width="90"><img src="../images/misc/icon_address.gif">Address</td><td align="left" width="30">:</td>			<td width="180"> <div class="w">Watson House,<br>1-5 Wo Liu Hang Road,<br>Fo Tan, Sha Tin, New Territories</div></td></tr>		</tbody></table>
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