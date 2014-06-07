<%@page import="com.bitranger.parknshop.common.controller.Utility"%>
<%@page import="com.bitranger.parknshop.common.model.PsItem"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Online Store</title>
<meta charset="utf-8">
<meta name="viewport" content="initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/cart.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
	<%@ include file="include/header.jsp"%>


	<div id="categorybarDiv">
		<%@ include file="include/categorybar.jsp"%>
	</div>
	<div id="mainContent">
		<div id="storeItemList">
			<div id="cartTitle">
				<h3>
					<b><span class="glyphicon glyphicon-shopping-cart"></span>MY
						CART</b>
				</h3>
			</div>
			<div>
				<%
					List<CartCustomerItem> cartCustomerItems = (List<CartCustomerItem>) request
							.getAttribute("cartCustomerItems");
					for (CartCustomerItem cartCustomerItem : cartCustomerItems) {
						PsItem item = cartCustomerItem.getPsItem();
				%>
				<div class="cartItem">
					<ul>
						<li><input type="checkbox"></li>
						<li>
							<div class="left cartItemImgDiv">
								<img
									src="<%=request.getContextPath()%>/images/<%=item.getUrlPicture()%>" />
							</div>
							<div class="left cartItemDescDiv">
								<div class="cartItemDesc">
									<a href="<%=request.getContextPath()%>/item/<%=item.getId()%>"><%=Utility.slice(item.getName(), 30)%></a>
								</div>
								<div class="cartItemExtra"></div>
							</div>
						</li>
						<li>
							<p>
								<%=Utility.slice(item.getIntroduction(), 50)%>
							</p>
						</li>
						<li><span>$</span><span style="text-decoration:line-through"><%=item.getPrice()%></span><br>
							<span style="color: #DF4818;font-weight: bold;font-size: 16px;">$<%=item.getPrice()%></span>
						</li>
						<li><span class="itemCart_quantityChangeBar"> <a
								href="<%=request.getContextPath()%>/decreaseCartItem?itemId=<%=item.getId()%>"
								class="itemCart_quantityChange">-</a> <input
								class="itemCart_quantity_input" type="text"
								value="<%=cartCustomerItem.getQuantity()%>" maxlength="8">
								<a
								href="<%=request.getContextPath()%>/increaseCartItem?itemId=<%=item.getId()%>"
								class="itemCart_quantityChange">+</a>
						</span></li>
						<li><span><a
								href="<%=request.getContextPath()%>/addcollection?itemId=<%=item.getId()%><%=item.getId()%>">Move
									to Collection</a></span><br> <span><a
								href="<%=request.getContextPath()%>/deleteCartItem?itemId=<%=item.getId()%>">Delete</a></span></li>
					</ul>
				</div>
				<%
					}
				%>
			</div>
			<div id="cartTitle">
				<h3>
					<a href="<%=request.getContextPath()%>/cashier"><b>GO TO CASHIER</b></a>
				</h3>
			</div>
		</div>

	</div>




	<%@ include file="include/footer.jsp"%>

	<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.js" type="text/javascript"></script>
	<script src="js/categorybar.js" type="text/javascript"></script>
	<script src="js/common.js" type="text/javascript"></script>
</body>
</html>