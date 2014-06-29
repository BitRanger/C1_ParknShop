<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 6/21/2014
  Time: 08:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Store</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/404.css" />
    <link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>

<div id="mainContent">

    <div id="storeItemList">
        <div class="dialog">
            <div class="content">
                <h4><%=request.getAttribute("message")%></h4>
                <p>Click <a href="<%=request.getContextPath()%>">here</a> to go back to index</p>
            </div>
        </div>
        <div id="itemRecommand">
            <ul>
                <li>
                    <a href="#"><img src="images/detail/recommand1.jpg"/></a>
                </li>
                <li>
                    <a href="#"><img src="images/detail/recommand2.jpg"/></a>
                </li>
                <li>
                    <a href="#"><img src="images/detail/recommand3.jpg"/></a>
                </li>
                <li>
                    <a href="#"><img src="images/detail/recommand4.jpg"/></a>
                </li>
                <li>
                    <a href="#"><img src="images/detail/recommand5.jpg"/></a>
                </li>
            </ul>
        </div>
    </div>

</div>


<%@ include file="include/footer.jsp" %>


<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/categorybar.js" type="text/javascript"></script>
<script src="js/common.js" type="text/javascript"></script>
</body>
</html>