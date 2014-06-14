<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Online Store</title>
  <meta charset="utf-8">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<%@ include file="../include/header.jsp" %>

<div id="categorybarDiv">
    <%@ include file="../include/categorybar.jsp" %>
</div>
<div id="mainContent">
<div id="storeItemList">
<div class="storeItemListRow">
    <div class="storeItemListRowTitle">
        <h1>Fashion
            <small>Some of new products in this month</small>
        </h1>
    </div>
    <div class="storeItem">
        <a href="detail.jsp"><img width="180px" src="images/lunbo.jpg" alt="..."></a>
        <div class="caption">
            <a href="detail.jsp">
                <h7>
                    This is the goods description.This is the goods description.This is the
                    goods description.
                </h7>
            </a>
            <h5><b>style-clothes</b> </h5>
            <p>Price: $50.00</p>
            <p>Available</p>
        </div>
    </div>
    <div class="storeItem">
    <c:forEach value="${item-list}" item="item">
    
    ///item-detail?item-id=435435
    
    <c:url value="/item-detail"> 
    <c:param name="item-id" value="${item.id}"/>
    </c:url>
    
    <form action="/item-detail" method="get">
    	<input name="item-id" value="${item.id}"/>
    </form>
    
    
        <a href="detail.jsp"><img width="180px" src="images/lunbo.jpg" alt="..."></a>
        <div class="caption">
            <a href="detail.jsp">
                <h7>
                    This is the goods description.This is the goods description.This is the
                    goods description.
                </h7>
            </a>
            <h5><b>style-clothes</b> </h5>
            <p>Price: $50.00</p>
            <p>Available</p>
        </div>
    </div>
    <div class="storeItem">
        <a href="detail.jsp"><img width="180px" src="images/lunbo.jpg" alt="..."></a>
        <div class="caption">
            <a href="detail.jsp">
                <h7>
                    This is the goods description.This is the goods description.This is the
                    goods description.
                </h7>
            </a>
            <h5><b>style-clothes</b> </h5>
            <p>Price: $50.00</p>
            <p>Available</p>
        </div>
    </div>
    <div class="storeItem">
        <a href="detail.jsp"><img width="180px" src="images/lunbo.jpg" alt="..."></a>
        <div class="caption">
            <a href="detail.jsp">
                <h7>
                    This is the goods description.This is the goods description.This is the
                    goods description.
                </h7>
            </a>
            <h5><b>style-clothes</b> </h5>
            <p>Price: $50.00</p>
            <p>Available</p>
        </div>
    </div>
    <div class="storeItem">
        <a href="detail.jsp"><img width="180px" src="images/lunbo.jpg" alt="..."></a>
        <div class="caption">
            <a href="detail.jsp">
                <h7>
                    This is the goods description.This is the goods description.This is the
                    goods description.
                </h7>
            </a>
            <h5><b>style-clothes</b> </h5>
            <p>Price: $50.00</p>
            <p>Available</p>
        </div>
    </div>
</div>
<div class="storeItemListRow">
    <div class="storeItemListRowTitle">
        <h1>Fashion
            <small>Some of new products in this month</small>
        </h1>
    </div>
    <div class="storeItem">
        <a href="detail.jsp"><img width="180px" src="images/lunbo.jpg" alt="..."></a>
        <div class="caption">
            <a href="detail.jsp">
                <h7>
                    This is the goods description.This is the goods description.This is the
                    goods description.
                </h7>
            </a>
            <h5><b>style-clothes</b> </h5>
            <p>Price: $50.00</p>
            <p>Available</p>
        </div>
    </div>
    <div class="storeItem">
        <a href="detail.jsp"><img width="180px" src="images/lunbo.jpg" alt="..."></a>
        <div class="caption">
            <a href="detail.jsp">
                <h7>
                    This is the goods description.This is the goods description.This is the
                    goods description.
                </h7>
            </a>
            <h5><b>style-clothes</b> </h5>
            <p>Price: $50.00</p>
            <p>Available</p>
        </div>
    </div>
    <div class="storeItem">
        <a href="detail.jsp"><img width="180px" src="images/lunbo.jpg" alt="..."></a>
        <div class="caption">
            <a href="detail.jsp">
                <h7>
                    This is the goods description.This is the goods description.This is the
                    goods description.
                </h7>
            </a>
            <h5><b>style-clothes</b> </h5>
            <p>Price: $50.00</p>
            <p>Available</p>
        </div>
    </div>
    <div class="storeItem">
        <a href="detail.jsp"><img width="180px" src="images/lunbo.jpg" alt="..."></a>
        <div class="caption">
            <a href="detail.jsp">
                <h7>
                    This is the goods description.This is the goods description.This is the
                    goods description.
                </h7>
            </a>
            <h5><b>style-clothes</b> </h5>
            <p>Price: $50.00</p>
            <p>Available</p>
        </div>
    </div>
    <div class="storeItem">
        <a href="detail.jsp"><img width="180px" src="images/lunbo.jpg" alt="..."></a>
        <div class="caption">
            <a href="detail.jsp">
                <h7>
                    This is the goods description.This is the goods description.This is the
                    goods description.
                </h7>
            </a>
            <h5><b>style-clothes</b> </h5>
            <p>Price: $50.00</p>
            <p>Available</p>
        </div>
    </div>
</div>
<div class="storeItemListRow">
    <div class="storeItemListRowTitle">
        <h1>Fashion
            <small>Some of new products in this month</small>
        </h1>
    </div>
    <div class="storeItem">
        <a href="detail.jsp"><img width="180px" src="images/lunbo.jpg" alt="..."></a>
        <div class="caption">
            <a href="detail.jsp">
                <h7>
                    This is the goods description.This is the goods description.This is the
                    goods description.
                </h7>
            </a>
            <h5><b>style-clothes</b> </h5>
            <p>Price: $50.00</p>
            <p>Available</p>
        </div>
    </div>
    <div class="storeItem">
        <a href="detail.jsp"><img width="180px" src="images/lunbo.jpg" alt="..."></a>
        <div class="caption">
            <a href="detail.jsp">
                <h7>
                    This is the goods description.This is the goods description.This is the
                    goods description.
                </h7>
            </a>
            <h5><b>style-clothes</b> </h5>
            <p>Price: $50.00</p>
            <p>Available</p>
        </div>
    </div>
    <div class="storeItem">
        <a href="detail.jsp"><img width="180px" src="images/lunbo.jpg" alt="..."></a>
        <div class="caption">
            <a href="detail.jsp">
                <h7>
                    This is the goods description.This is the goods description.This is the
                    goods description.
                </h7>
            </a>
            <h5><b>style-clothes</b> </h5>
            <p>Price: $50.00</p>
            <p>Available</p>
        </div>
    </div>
    <div class="storeItem">
        <a href="detail.jsp"><img width="180px" src="images/lunbo.jpg" alt="..."></a>
        <div class="caption">
            <a href="detail.jsp">
                <h7>
                    This is the goods description.This is the goods description.This is the
                    goods description.
                </h7>
            </a>
            <h5><b>style-clothes</b> </h5>
            <p>Price: $50.00</p>
            <p>Available</p>
        </div>
    </div>
    <div class="storeItem">
        <a href="detail.jsp"><img width="180px" src="images/lunbo.jpg" alt="..."></a>
        <div class="caption">
            <a href="detail.jsp">
                <h7>
                    This is the goods description.This is the goods description.This is the
                    goods description.
                </h7>
            </a>
            <h5><b>style-clothes</b> </h5>
            <p>Price: $50.00</p>
            <p>Available</p>
        </div>
    </div>
</div>
</div>
</div>



<%@ include file="include/footer.jsp" %>

<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/index.js" type="text/javascript"></script>
</body>
</html>