<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 5/31/2014
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.bitranger.parknshop.common.model.OrderStatus"%>
<%@page import="com.bitranger.parknshop.buyer.controller.Utility"%>
<%@page import="com.bitranger.parknshop.common.model.ROrderItem"%>
<%@page import="java.util.List"%>
<%@page import="com.bitranger.parknshop.seller.model.PsOrder"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div style="margin-left: 10px;">
	<%
		List<PsOrder> psOrders = (List<PsOrder>) request
				.getAttribute("psOrders");

		if (psOrders == null) {
	%>
	<div>ERROR!</div>
	<%
		} else {

			for (PsOrder psOrder : psOrders) {
	%>
	<div class="historyItem">
		<ul class="historyItemTitle">
			<li><input type="checkbox"></li>
			<li><span><%=psOrder.getTimeCreated().toString()%></span></li>
			<li><span>OrderNumber:</span> <span><%=psOrder.getId()%></span></li>
			<li><span>TrackingNumber:</span> <span><%=psOrder.getTrackingNumber()%></span></li>
			<li><span><a
					href="<%=request.getContextPath()%>/shop/<%=psOrder.getPsShop().getId()%>"><%=psOrder.getPsShop().getName()%></a></span></li>
			<li><span><%=Utility.printStatus(psOrder.getStatus())%></span></li>
		</ul>
		<ul class="historyItemTitle">
			<%
				if (psOrder.getStatus().equals(OrderStatus.UNPAID)) {
			%>
<<<<<<< HEAD
			<li><a
				href="<%=request.getContextPath()%>/pay.jsp?orderId=<%=psOrder.getId()%>">Pay
					Now</a></li>
			<%
				}
			%>
			<%
				if (psOrder.getStatus().equals(OrderStatus.DELIVERING)) {
			%>
			<li><a
				href="<%=request.getContextPath()%>/confirmReceived?orderId=<%=psOrder.getId()%>">Confirm Received</a></li>
=======
				<a href="<%=request.getContextPath()%>/pay.jsp?orderId=<%=psOrder.getId()%>">Pay Now</a>
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
			<%
				}
			%>
		</ul>
		<%
			for (ROrderItem rOrderItem : psOrder.getROrderItems()) {
		%>
		<ul class="historyItemContent">

			<li>
				<div class="left historyItemImgDiv">
<<<<<<< HEAD
					<img src="<%=rOrderItem.getPsItem().getUrlPicture()%>" width="50"
						height="50">
=======
					<img
						src="<%=request.getContextPath()%>/images/<%=rOrderItem.getPsItem().getUrlPicture()%>"
						width="50" height="50">
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
				</div>
				<div class="left historyItemDescDiv">
					<div class="historyItemDesc"><%=Utility.slice(rOrderItem.getPsItem()
								.getIntroduction(), 30)%></div>
					<div class="historyItemExtra"></div>
				</div>
			</li>
			<li><span>$<%=rOrderItem.getPsItem().getPrice()%></span><span><%=rOrderItem.getQuantitiy()%></span></li>
<<<<<<< HEAD
			<li><span><a class="historyActionLink"
					href="<%=request.getContextPath()%>/comment?psItemId=<%=rOrderItem.getPsItem().getId()%>">Comment</a></span>
=======
			<li><span><a class="historyActionLink" href="#">SomeAction</a></span><br>
				<span><a class="historyActionLink" href="#">Complaint</a></span></li>
			<li><span><a class="historyActionLink" href="#">State</a></span><br>
				<span><a class="historyActionLink" href="#">OrderDetail</a></span></li>
			<li><span><a class="historyActionLink" href="#">Comment</a></span>
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
			</li>

		</ul>
		<%
			}
		%>
	</div>
	<%
		}
		}
	%>
</div>