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
    <link rel="stylesheet" type="text/css" href="../css/misc/about.css" />
    <link rel="stylesheet" type="text/css" href="../css/common.css">
</head>
<body>
<%@ include file="../include/header.jsp" %>


<div id="categorybarDiv">
    <%@ include file="../include/categorybar.jsp" %>
</div>
<div id="mainContent">
    <div id="storeItemList">
        <div id="about_us">
            <div id="overview">
                <h1>COMPANY OVERVIEW</h1>
                <p>PARKnSHOP is the leading supermarket chain in Hong Kong. Our brand promise is "You earn more at PARKnSHOP" as we are confident in offering value for money, wide product choice, freshness & safety, and tailored stores to meet the needs of different customer segments.</p>
                <img src="../images/misc/img_logo.jpg"/>
            </div>
            <div>
                <div class="listitem">Value for Money</div>
                <div class="listItemContent">
                    <ul>
                        <li>Offer hundreds of promotions with especially deep savings.</li>
                        <li>MoneyBack loyalty program provides members with tailor made offers.</li>
                        <li>Thousands of Own Labels give customers choice, value and quality.</li>
                    </ul>
                </div>
                <div class="listitem">Wide Product Choice</div>
                <div class="listItemContent">
                    <ul>
                        <li>Hold seasonal bazaars and country food festivals frequently to provide excitement.</li>
                        <li>Wide range of Asian and Western products sourced from around the world.</li>
                        <li>Wide choice of organic food.</li>
                    </ul>
                </div>
                <div class="listitem">Freshness & Safety</div>
                <div class="listItemContent">
                    <ul>
                        <li>Quality Assurance enforces the standards in freshness and food safety audits of stores, suppliers, and fresh food distribution centre.</li>
                        <li>"Vegetable Barcode ID Card" and "Farm Check" Quality Control records enable us to trace the origin of vegetable to the exact farm it was grown. They also detail the full life history of the vegetable to give you the peace of mind.</li>
                    </ul>
                </div>
                <div class="listitem">Tailored Stores</div>
                <div class="listItemContent">
                    <ul>
                        <li>More than 260 stores in Hong Kong and Macau with different store formats to meet the needs of different customer segments.</li>
                    </ul>
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