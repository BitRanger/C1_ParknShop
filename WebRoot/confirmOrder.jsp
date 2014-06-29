<%@page import="com.bitranger.parknshop.buyer.controller.Utility"%>
<%@page import="com.bitranger.parknshop.seller.model.PsRecipient"%>
<<<<<<< HEAD
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="gbk"%>
=======
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
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
<<<<<<< HEAD
<body onload="setup();preselect('ÉÂÎ÷Ê¡');">
=======
<body onload="setup();preselect('é™•è¥¿çœ');">
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
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
<<<<<<< HEAD
						<input type="radio" name="address" value="addr2"> <label>ÉÂÎ÷Ê¡
							Î÷°²ÊĞ ±®ÁÖÇø ÓÑÒêÎ÷Â·127ºÅ £¨Ñî¿ªµØ ÊÕ£©</label> <em>18688722368</em>
					</div>
					<div class="comfirm_address_item">
						<input type="radio" name="address" value="addr3"> <label>ÉÂÎ÷Ê¡
							Î÷°²ÊĞ Á«ºşÇø ÀÍ¶¯ÄÏÂ·88ºÅÍúÔ°Ñ§Éú¹«Ô¢ £¨Ñî¿ªµØ ÊÕ£©</label> <em>18688722368</em>
=======
						<input type="radio" name="address" value="addr2"> <label>é™•è¥¿çœ
							è¥¿å®‰å¸‚ ç¢‘æ—åŒº å‹è°Šè¥¿è·¯127å· ï¼ˆæ¨å¼€åœ° æ”¶ï¼‰</label> <em>18688722368</em>
					</div>
					<div class="comfirm_address_item">
						<input type="radio" name="address" value="addr3"> <label>é™•è¥¿çœ
							è¥¿å®‰å¸‚ è²æ¹–åŒº åŠ³åŠ¨å—è·¯88å·æ—ºå›­å­¦ç”Ÿå…¬å¯“ ï¼ˆæ¨å¼€åœ° æ”¶ï¼‰</label> <em>18688722368</em>
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
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
<<<<<<< HEAD
									src="<%=cartItem.getPsItem().getUrlPicture()%>"
=======
									src="<%=request.getContextPath()%>/images/<%=cartItem.getPsItem().getUrlPicture()%>"
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
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
<<<<<<< HEAD
            <a id="settleBtn" href="#" onclick="document.getElementById('address_form').submit();">Next</a>
        </div>
=======
				<input type="button" value="Submit Order" onclick="document.getElementById('address_form').submit();">
			</div>
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
		</div>
	</div>



	<%@ include file="include/footer.jsp"%>

	<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.js" type="text/javascript"></script>
	<script src="js/categorybar.js" type="text/javascript"></script>
	<script src="js/common.js" type="text/javascript"></script>
</body>
</html>