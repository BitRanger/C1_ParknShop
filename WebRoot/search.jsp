<%@page import="com.bitranger.parknshop.common.ads.PsPromotItem"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Online Store</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/storeHeader.css">
<link rel="stylesheet" type="text/css" href="css/categorybar.css">
<link rel="stylesheet" type="text/css" href="css/footer.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/search.css">
</head>
<style>
.page_link {
	width: 100px;
	height: 35px;
	border: none;
	border-radius: 3px;
	color: #ffffff;
	background-color: #3A8BE4;
	box-shadow: 0px 2px 0px #2B32DB
}
.notice
{

}
</style>
<body>
	<%@ include file="include/header.jsp"%>

	<div id="categorybarDiv">
		<%@ include file="include/categorybar.jsp"%>
	</div>

	<div id="mainContent">
		<div id="storeItemList">
			<div class="property-list">
				<div class="row-item">
					<div class="row-item-name">
						<span>Sort:</span>
					</div>
					<div class="row-item-content">
						<ul style="list-style:none;">
							<li class="item-style"><a href="#"
								onclick="addPriceAscending();">Price Ascending</a></li>
							<li class="item-style"><a href="#"
								onclick="addPriceDescending();">Price Descending</a></li>
							<li class="item-style"><a href="#"
								onclick="addVoteDescending();">Vote</a></li>
							<li class="item-style"><a href="#"
								onclick="addClickCountDescending()">Popularity</a></li>
							<li class="item-style"><a href="#">Sales-volume</a></li>
						</ul>
					</div>
				</div>
			</div>

			<div class="property-list">
				<a href="#" onclick="prevPage();" style="font-size: 18px"><Button
						class="page_link">Prev</Button></a> <span id="notice" class="notice"></span> <a
					href="#" onclick="nextPage();"
					style="font-size: 18px; margin-left: 32px"><Button
						class="page_link">Next</Button></a>
			</div>

			<c:choose>
				<c:when test="${item_count eq 0 }">
		There's no item yet.
	</c:when>
				<c:otherwise>
					<c:forEach begin="0" end="${(item_count - 1) /5 }" varStatus="s">
						<div class="storeItemListRow">
							<c:forEach begin="${s.index * 5 }"
								end="${s.index * 5 + 4 > item_count - 1 ? item_count - 1 : s.index * 5 + 4 }"
								varStatus="vs">
								<div class="storeItem">
									<a
										href="<%=request.getContextPath()%>/item/${product_item_list[vs.index].id}"><img
										width="180px" height="180px"
										src="${product_item_list[vs.index].urlPicture}" alt="..."></a>
									<div class="storeItemDesc">
										<h5>
											<a class="storeItemLink" href="detail.jsp">
												${product_item_list[vs.index].name} </a>
										</h5>
										<p>Price: $${product_item_list[vs.index].price}</p>
										<p>
											<i
												style="margin-top: 5px; background: url(<%=request.getContextPath()%>/images/ratestar.png) no-repeat ${((product_item_list[vs.index].vote<=100)?product_item_list[vs.index].vote div 20:5)*16 - 80}px 0;"
												class="bitranger_3_star"></i>
										</p>
										<!--           					<h5><b>${product_item_list[vs.index].introduction}</b> </h5> -->
										<!--             				<p>Price: ${product_item_list[vs.index].price}</p> -->
										<!--             				<p>Vote: ${product_item_list[vs.index].vote}</p> -->
									</div>
								</div>
							</c:forEach>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<div class="property-list">
				<a href="#" onclick="prevPage();" style="font-size: 18px"><Button
						class="page_link">Prev</Button></a>
						<span id="notice1" class="notice"></span>
						<a href="#" onclick="nextPage();"
					style="font-size: 18px; margin-left: 32px"><Button
						class="page_link">Next</Button></a>
			</div>
			
			
	<div id="itemRecommand">
				<div style="margin: 10px 0 20px 0;">CUSTOMERS WHO VIEWED THIS
					PRODUCT ALSO VIEWED</div>
				<ul>
				<%
				
				List<PsPromotItem> ad_list = (List<PsPromotItem>)request.getAttribute("ad_list");
			if (ad_list != null && ad_list.size() > 0)
				for(PsPromotItem curAd : ad_list) {
				%>
			<li><a href="<%=request.getContextPath()%>/item/<%= curAd.getPsItem().getId()%>">
					<img src="<%= curAd.getPicUrl()%>" />
				</a>
			</li>
				<%} %>
				</ul>
			</div>
			
		</div>
	</div>

	<%@ include file="include/footer.jsp"%>

	<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.js" type="text/javascript"></script>
	<script src="js/categorybar.js" type="text/javascript"></script>
	<script src="js/common.js" type="text/javascript"></script>
	<script type="text/javascript">
		var page_number;
		dict = getArgs(window.location.href);
		if (dict["page_number"] != null) {
			page_number = parseInt(dict["page_number"])
		} else {
			page_number = 1;
		}
		notice = document.getElementById("notice");
		notice.textContent = "Page " + page_number.toString();
		notice1 = document.getElementById("notice1");
		notice1.textContent = "Page " + page_number.toString();
		function getArgs(url) {
			var param = url.split("?")[1];
			var args = {};
			items = param.length ? param.split("&") : [];
			item = null;
			name = null;
			value = null;
			for ( var i = 0; i < items.length; i++) {
				item = items[i].split("=");
				name = decodeURIComponent(item[0]);
				value = decodeURIComponent(item[1]);
				if (name.length) {
					args[name] = value;
				}
			}
			return args;
		}
		function encode(dict) {
			var sb = "";
			var first = true;
			for (key in dict) {
				if (first) {
					first = false;
				} else {
					sb = sb + "&";
				}
				sb = sb + key + "=" + dict[key];
			}
			return sb;
		}
		function addParams(toInsert) {
			var url = window.location.href;
			var currentArg = getArgs(url);
			var extraArg = getArgs(toInsert);
			for (key in extraArg) {
				currentArg[key] = extraArg[key];
			}
			return currentArg;
		}
		function removeParams(param) {
			var url = window.location.href;
			var currentArg = getArgs(url);
			var extraArg = getArgs(toInsert);
			for (key in extraArg) {
				delete currentArg[key];
			}
			return currentArg;
		}
		function addPriceAscending() {
			var addedArg = addParams("?order_by=price&asd=asd");
			var args = encode(addedArg);
			window.location.href = window.location.pathname + "?" + args;
		}
		function addPriceDescending() {
			var addedArg = addParams("?order_by=price&asd=desc");
			var args = encode(addedArg);
			window.location.href = window.location.pathname + "?" + args;
		}
		function addVoteDescending() {
			var addedArg = addParams("?order_by=vote&asd=desc");
			var args = encode(addedArg);
			window.location.href = window.location.pathname + "?" + args;
		}
		function addClickCountDescending() {
			var addedArg = addParams("?order_by=count_click&asd=desc");
			var args = encode(addedArg);
			window.location.href = window.location.pathname + "?" + args;
		}
		function nextPage() {
			page_number++;
			var addedArg = addParams("?page_number=" + page_number.toString());
			var args = encode(addedArg);
			window.location.href = window.location.pathname + "?" + args;
		}
		function prevPage() {
			if (page_number > 1)
				page_number--;
			var addedArg = addParams("?page_number=" + page_number.toString());
			var args = encode(addedArg);
			window.location.href = window.location.pathname + "?" + args;
		}
		console.log(getArgs("?asd=12"));
	</script>

</body>
</html>