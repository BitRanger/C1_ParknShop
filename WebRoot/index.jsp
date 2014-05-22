<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Online Store</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<%@ include file="include/header.jsp" %>


<div id="categorybarDiv">
    <%@ include file="include/categorybar.jsp" %>
</div>
<div id="mainContent">
    <%@ include file="include/attracting.jsp" %>
    <div id="storeItemList">

        <%
            for (int i = 0; i < 4; i++) {
        %>
        <div class="storeItemListRow">
            <div class="storeItemListRowTitle">
                <h1>Fashion
                    <small>Some of new products in this month</small>
                </h1>
            </div>
            <div class="storeItem">
                <a href="detail.jsp"><img width="180px" src="images/clothes_demo.jpg" alt="..."></a>
                <div class="storeItemDesc">
                    <h5><a class="storeItemLink" href="#">Spring break graphic tee, Men T-shirt</a> </h5>
                    <p>Price: $50.00</p>
                </div>
            </div>
            <div class="storeItem">
                <a href="detail.jsp"><img width="180px" src="images/clothes_demo.jpg" alt="..."></a>
                <div class="storeItemDesc">
                    <h5><a class="storeItemLink" href="#">Spring break graphic tee, Men T-shirt</a> </h5>
                    <p>Price: $50.00</p>
                </div>
            </div>
            <div class="storeItem">
                <a href="detail.jsp"><img width="180px" src="images/clothes_demo.jpg" alt="..."></a>
                <div class="storeItemDesc">
                    <h5><a class="storeItemLink" href="#">Spring break graphic tee, Men T-shirt</a> </h5>
                    <p>Price: $50.00</p>
                </div>
            </div>
            <div class="storeItem">
                <a href="detail.jsp"><img width="180px" src="images/clothes_demo.jpg" alt="..."></a>
                <div class="storeItemDesc">
                    <h5><a class="storeItemLink" href="#">Spring break graphic tee, Men T-shirt</a> </h5>
                    <p>Price: $50.00</p>
                </div>
            </div>
            <div class="storeItem">
                <a href="detail.jsp"><img width="180px" src="images/clothes_demo.jpg" alt="..."></a>
                <div class="storeItemDesc">
                    <h5><a class="storeItemLink" href="#">Spring break graphic tee, Men T-shirt</a> </h5>
                    <p>Price: $50.00</p>
                </div>
            </div>
        </div>
        <%
            }
        %>

    </div>

</div>


<%@ include file="include/footer.jsp" %>


<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/index.js" type="text/javascript"></script>
</body>
</html>