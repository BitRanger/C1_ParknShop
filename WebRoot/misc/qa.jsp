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
    <link rel="stylesheet" type="text/css" href="../css/misc/qa.css" />
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
                <h1>QUALITY ASSURANCE DEPARTMENT</h1>
                <p>PARKnSHOP's Quality Assurance (QA) Department consists of a dedicated team of quality and food safety professionals with the mission of ensuring the products that PARKnSHOP sells meet the highest standards of freshness, quality and safety. The QA team is made up of highly experienced personal and includes many qualified scientists with expertise in the areas of food safety, agriculture and livestock farming as well as laboratory analysis. The QA Department reports directly to PARKnSHOP's Managing Director and acts independently within the company. The QA Department is involved with food receiving standards, store operation standards, customer's services, PARKnSHOP exclusive brands (e.g. Select, Best Buy & Imperial Banquet) development and has an array of control mechanisms in place through food safety audits of stores and fresh food suppliers and fresh food distribution centre together with approval for new fresh food supplier and new product.</p>
                <br>
                <br>
                <br>
                <br>
                <p>PARKnSHOP's QA Department has been and continues to be the pioneer of food safety development for Hong Kong consumers so you can have peace of mind when you shop at PARKnSHOP. We continually work to improve Hong Kong's fresh food safety standards by transforming our fresh food supply chain to develop world class food handling practices, traceability & an audit & testing program.</p>
                <img src="../images/misc/photo03.jpg"/>
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