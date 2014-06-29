<%@page import="com.bitranger.parknshop.common.ads.PsPromotItem"%>
<%@page import="com.bitranger.parknshop.buyer.controller.Utility"%>
<%@page import="com.bitranger.parknshop.common.model.PsItem"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.bitranger.parknshop.common.model.PsCategory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	List<PsCategory> psCategories = (List<PsCategory>) session
			.getAttribute("psCategories");
	List<PsItem> psItemsForPromotion = (List<PsItem>) request
			.getAttribute("psItems");
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
		<div id="attracting">
			<div id="attractingLeft">
				<div id="attractingBigShow">
					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"
								class=""></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"
								class=""></li>
							<li data-target="#carousel-example-generic" data-slide-to="3"
								class=""></li>
						</ol>
						<div class="carousel-inner">
						<%
						List<PsPromotItem> ad_list = (List<PsPromotItem>)request.getAttribute("ad_list");
						for(PsPromotItem curAd : ad_list) {
						%>
						<div class="item">
								<img src="<%= curAd.getPicUrl()%>" />
						</div>
						<%} %>
							<div class="item">
								<img src="images/attracting1.jpg" />
							</div>
							<div class="item active left">
								<img src="images/attracting2.jpg" />
							</div>
							<div class="item next left">
								<img src="images/attracting3.jpg" />
							</div>
							<div class="item next left">
								<img src="images/attracting4.jpg" />
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>
				<div id="attracting_cutting">
					<div id="discount_title">
						<span id="discount_title_left"> Big Deal on Today </span> <span
							id="discount_title_right"> Hong Kong's Leading Discount
							Center </span>
					</div>
					<div id="discount_areaWrapper">
						<div id="discount_area">
							<div class="discount_area_list">
								<%
									for (int i = 0; i < 5; i++) {
								%>
								<a href="<%=request.getContextPath()%>/item/<%=psItemsForPromotion.get(i).getId()%>">
								<div class="discountItem">
									<img width="125" height="98" class="discountItemImg" src="<%=psItemsForPromotion.get(i).getUrlPicture() %>" />
								</div>
								</a>
								<%
									}
								%>
							</div>
							<div class="discount_area_list">
								<%
									for (int i = 5; i < 10; i++) {
								%>
								<a href="<%=request.getContextPath()%>/item/<%=psItemsForPromotion.get(i).getId()%>">
								<div class="discountItem">
									<img width="125" height="98" class="discountItemImg" src="<%=psItemsForPromotion.get(i).getUrlPicture() %>" />
								</div>
								</a>
								<%
									}
								%>
							</div>
							<div class="discount_area_list">
								<%
									for (int i = 10; i < 15; i++) {
								%>
								<a href="<%=request.getContextPath()%>/item/<%=psItemsForPromotion.get(i).getId()%>">
								<div class="discountItem">
									<img width="125" height="98" class="discountItemImg" src="<%=psItemsForPromotion.get(i).getUrlPicture() %>" />
								</div>
								</a>
								<%
									}
								%>
							</div>
						</div>
						<a class="discount_navBtn" id="discount_leftBtn"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="discount_navBtn" id="discount_rightBtn"> <span
							class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>
			</div>

			<div id="attractingRight">
				<img style="width: 275px" src="images/imgad.gif" /> <img
					style="margin-top: 20px; width: 275px" src="images/imgad2.jpg" /> <span
					id="ad_span"> <a id="ad_link">Advertisement</a>
				</span>
			</div>
		</div>
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
						width="180px" height="180px" src="<%=psItem.getUrlPicture()%>"
						alt="..."></a>
					<div class="storeItemDesc">
						<h5>
							<a class="storeItemLink"
								href="<%=request.getContextPath()%>/item/<%=psItem.getId()%>"><%=Utility.slice(psItem.getName(), 30)%></a>
						</h5>
						<p>
							Price: $<%=psItem.getPrice()%></p>
						<p>
							<a
								href="<%=request.getContextPath()%>/addcart?itemId=<%=psItem.getId()%>">Add
								Cart</a>
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