<%@page import="com.bitranger.parknshop.common.model.PsItem"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Online Store</title>
	<meta charset="utf-8" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="css/index.css" />
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
            for (PsCategory psCategory : (java.util.List<PsCategory>)request.getAttribute("psCategories"))
            {
        %>
        <div class="storeItemListRow">
            <div class="storeItemListRowTitle">
                <h1><a href="<%=request.getContextPath()%>/item/<%=psCategory.getId()%>"><%=psCategory.getName()%></a>
                    <small>Some of new products in this month</small>
                </h1>
            </div>
            <%
	            for (PsItem psItem : ((java.util.HashMap<Integer, java.util.List<PsItem>>)request.getAttribute("psIndexDisplay")).get(psCategory.getId()))
	            {
        	%>
            <div class="storeItem">
                <a href="<%=request.getContextPath()%>/item/<%=psItem.getId()%>"><img width="180px" src="<%=request.getContextPath()%>/images/<%=psItem.getUrlPicture()%>" alt="<%=psItem.getId()%>"></a>
                <div class="storeItemDesc">
                    <h5><a class="storeItemLink" href="#"><%=psItem.getName() %></a> </h5>
                    <p>Price: $<%=psItem.getPrice() %></p>
                </div>
            </div>
            <%  } %>
        </div>
        <%
            }
        %>

    </div>

</div>


<%@ include file="include/footer.jsp" %>


<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/categorybar.js" type="text/javascript"></script>
<script src="js/index.js" type="text/javascript"></script>
</body>
</html>