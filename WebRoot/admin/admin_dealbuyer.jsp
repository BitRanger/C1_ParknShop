<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 6/19/2014
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bitranger.parknshop.buyer.model.PsCustomer"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table id="all_buyers">
<input type="button" name="Search" value="Search">&nbsp;&nbsp;&nbsp;
 <input type="text">
    <tr class="admin_buyerTitle">
        <th>Name</th>
        <th>Birthday</th>
        <th>Email</th>
        <th>JoinTime</th>
        <th>Action</th>
    </tr>
    <% 
    SimpleDateFormat BUYCCFMT = new SimpleDateFormat("YYYY MM DD");
    List<PsCustomer> cus_list = (List<PsCustomer>)request.getAttribute("buyer_list");
    for (int i = 0; i < cus_list.size(); i++) {
    	PsCustomer curBuyer = cus_list.get(i);
    %>
    <tr class="admin_buyerItem">
        <td><%=curBuyer.getNickname() %></td>
        <td></td>
        <td><%=curBuyer.getEmail() %></td>
        <td><%= BUYCCFMT.format(curBuyer.getTimeCreated()) %></td>
        <td>
            <span class="inline admin_action buyer_delete_btn">Delete</span>
            <span class="inline admin_action buyer_ban_btn">Ban</span>
        </td>
    </tr>
    <% } %>
</table>