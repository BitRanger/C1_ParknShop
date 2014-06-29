<%--
  Created by IntelliJ IDEA.
  User: Kaidi
  Date: 5/31/2014
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List"%>
<%@page import="com.bitranger.parknshop.seller.model.PsRecipient"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	List<PsRecipient> psRecipients = (List<PsRecipient>) request
			.getAttribute("psRecipients");
%>
<div>
	<div id="new_address">Add New Address</div>
	<div>
		<form id="buyer_newAddress"
			action="<%=request.getContextPath()%>/addRecipient">
			<div>
				<label style="margin-top: 5px">District</label>
				<div>
					<select class="select" name="province" id="s1">
						<option></option>
					</select> <select class="select" name="city" id="s2">
						<option></option>
					</select> <select class="select" name="town" id="s3">
						<option></option>
					</select>
				</div>
			</div>
			<br />
			<div>
				<label class="common_label">Zip Code</label> <input
					class="common_input" type="text" name="zipcode">
			</div>
			<div>
				<label class="common_label">Street</label>
				<textarea id="confirmAddr_street" name="street"
					placeholder="No need to write district again, just street, no more than 200 characters"></textarea>
			</div>
			<div>
				<label class="common_label">Receiver</label> <input
					class="common_input" type="text" name="receiver"
					placeholder="no more than 50 characters">
			</div>
			<div>
				<label class="common_label">PhoneNum</label> <input
					class="common_input" type="text" name="phonenum">
			</div>
			<div style="margin-left: 95px">
				<input id="comfirm_addAddressBtn" class="common_btn" type="submit"
					name="confirm" value="Add Address">
			</div>
		</form>
	</div>
</div>

<div style="margin-top: 50px;">
	<div id="saved_address">Saved Address</div>
	<table id="saveAddressTable">
		<tr style="background-color: #e4e4e4">
			<th>Receiver</th>
			<th>District</th>
			<th>Street</th>
			<th>Zipcode</th>
			<th>PhoneNum</th>
			<th>Operation</th>
		</tr>
		<%
			for(PsRecipient psRecipient : psRecipients)
			{
		%>
		<tr>
			<td><%=psRecipient.getNameRecipient()%></td>
			<td><%=psRecipient.getProvince()%> <%=psRecipient.getCity()%> <%=psRecipient.getAddresss()%></td>
			<td><%=psRecipient.getDetailedAddr() %></td>
			<td><%=psRecipient.getPostalCode()%></td>
			<td><%=psRecipient.getPhoneNumber()%></td>
			<td><a href="#">Modify</a> <a href="#">Delete</a></td>
		</tr>
		<% } %>
	</table>
</div>
























