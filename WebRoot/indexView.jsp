<%@page import="com.bitranger.parknshop.common.controller.Utility"%>
<%@page import="com.bitranger.parknshop.common.model.PsItem"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.bitranger.parknshop.common.model.PsCategory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	List<PsCategory> psCategories = (List<PsCategory>) session
			.getAttribute("psCategories");
	HashMap<Integer, List<PsItem>> psIndexDisplay = (HashMap<Integer, List<PsItem>>) request
			.getAttribute("psIndexDisplay");
%>
<html>
<head>
<title>Online Store</title>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
	<%@ include file="include/header.jsp"%>


	<div id="categorybarDiv">
		<%@ include file="include/categorybar.jsp"%>
	</div>
	<div id="mainContent">
		<%@ include file="include/attracting.jsp"%>
		<div id="storeItemList">
			<%
				for (PsCategory psCategory : psCategories) {
			%>
			<div class="storeItemListRow">
				<div class="storeItemListRowTitle">
					<h1>
						<%=psCategory.getName()%>
						<small>Some of new products in this month</small>
					</h1>
				</div>
				<%
					List<PsItem> psItems = psIndexDisplay.get(psCategory.getId());
						for (PsItem psItem : psItems) {
				%>
				<div class="storeItem">
					<a href="<%=request.getContextPath()%>/item/<%=psItem.getId()%>"><img
						width="180px"
						src="<%=request.getContextPath()%>/images/<%=psItem.getUrlPicture()%>"
						alt="..."></a>
					<div class="storeItemDesc">
						<h5>
							<a class="storeItemLink"
								href="<%=request.getContextPath()%>/item/<%=psItem.getId()%>"><%=Utility.slice(psItem.getName(), 30)%></a>
						</h5>
						<p>Price: $<%=psItem.getPrice()%></p>
						<p><a href="<%=request.getContextPath()%>/addcart?itemId=<%=psItem.getId()%>">Add Cart</a>
					</div>
				</div>
				<%
					}
				%>
			</div>
			<%
				}
			%>

		</div>
	</div>


	<%@ include file="include/footer.jsp"%>


	<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.js" type="text/javascript"></script>
	<script src="js/categorybar.js" type="text/javascript"></script>
	<script src="js/index.js" type="text/javascript"></script>
	<script src="js/common.js" type="text/javascript"></script>
</body>
</html>