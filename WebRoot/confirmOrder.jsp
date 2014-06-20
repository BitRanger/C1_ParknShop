<%@page import="com.bitranger.parknshop.buyer.controller.Utility"%>
<%@page import="com.bitranger.parknshop.seller.model.PsRecipient"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Online Store</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/conformOrder.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script src="js/geo.js" type="text/javascript"></script>
</head>
<body onload="setup();preselect('陕西省');">
	<%@ include file="include/header.jsp"%>


	<div id="categorybarDiv">
		<%@ include file="include/categorybar.jsp"%>
	</div>
	<div id="mainContent">

		<div id="storeItemList">
			<%@ include file="include/newAddress.jsp"%>
			<div class="confirm_title_bar">
				<div class="left confirm_title">Deliver Address</div>
			</div>
			<form id="address_form"
				action="<%=request.getContextPath()%>/submitOrder">
				<div>

					<%
						List<PsRecipient> psRecipients = (List<PsRecipient>) request
								.getAttribute("psRecipients");
						List<CartCustomerItem> psCartItems = (List<CartCustomerItem>) request
								.getAttribute("psCartItems");
						for (PsRecipient psRecipient : psRecipients) {
					%>
					<div class="comfirm_address_item">
						<input type="radio" name="psRecipientId"
							value="<%=psRecipient.getId()%>" /> <label><%=psRecipient.getProvince()%>
							<%=psRecipient.getCity()%> <%=psRecipient.getAddresss()%> <%=psRecipient.getDetailedAddr()%>
							(<%=psRecipient.getNameRecipient()%>)</label> <em><%=psRecipient.getPhoneNumber() %></em>
					</div>
					<%
						}
					%>
					<!-- 					<div class="comfirm_address_item">
						<input type="radio" name="address" value="addr2"> <label>陕西省
							西安市 碑林区 友谊西路127号 （杨开地 收）</label> <em>18688722368</em>
					</div>
					<div class="comfirm_address_item">
						<input type="radio" name="address" value="addr3"> <label>陕西省
							西安市 莲湖区 劳动南路88号旺园学生公寓 （杨开地 收）</label> <em>18688722368</em>
					</div> -->

					<div>
						<button id="addNewAddrBtn" data-toggle="modal"
							data-target="#newAddress">New Address</button>
					</div>
				</div>
			</form>
			<div class="confirm_title_bar">
				<div class="left confirm_title">Current Order</div>
				<div class="right" style="padding-top: 6px">
					<a class="confirm_link" href="cart.jsp">Back to Cart</a>
				</div>
			</div>
			<div>
				<table id="confirmTable">
					<tr id="confirmTableHeader">
						<th>Product</th>
						<th>Shop</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Subtotal</th>
					</tr>
					<%
						for (CartCustomerItem cartItem : psCartItems) {
					%>
					<tr class="confirmRow">
						<td>
							<div class="left confirmItemImgDiv">
								<img
									src="<%=request.getContextPath()%>/images/<%=cartItem.getPsItem().getUrlPicture()%>"
									width="50" height="50" />
							</div>
							<div class="left confirmItemDescDiv">
								<div class="confirmItemDesc">
									<%=Utility.slice(cartItem.getPsItem().getIntroduction(),
						50)%>
								</div>
								<div class="confirmItemExtra"></div>
							</div>
						</td>
						<td><span><%=cartItem.getPsItem().getPsShop().getName()%></span></td>
						<td><span>$<%=cartItem.getPsItem().getPrice()%></span></td>
						<td><span><%=cartItem.getQuantity()%></span></td>
						<td><span>$<%=cartItem.getPsItem().getPrice()
						* cartItem.getQuantity()%></span></td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
			<div style="margin-top: 20px; height: 30px">
				<input type="button" value="Submit Order" onclick="document.getElementById('address_form').submit();">
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