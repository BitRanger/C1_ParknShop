<%@page import="com.bitranger.parknshop.seller.model.PsNoticeSeller"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bitranger.parknshop.admin.data.PsNoticeAdmin"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String ctxPath = request.getContextPath();
SimpleDateFormat FMT = new SimpleDateFormat("YYYY MM-DD");
List<PsNoticeSeller> notice_list = (List<PsNoticeSeller>)request.getAttribute("notice_list");
	if (notice_list == null || notice_list.size() < 1) {
		out.println("<center>No Message</center>");
	}else
    for (int i = 0; i < notice_list.size(); i++) {
    	PsNoticeSeller curNotice = notice_list.get(i);
%>
<div class="notify_item">
    <div class="notify_item_title">
        <ul>
            <li><%= FMT.format(curNotice.getTimeCreated()) %></li>
            <li class="admin_nofify_delete">
            	<a href="<%=ctxPath%>/admin/delete/notice/id/<%= curNotice.getId()%>">
            		Delete
            	</a>
            </li>
        </ul>
    </div>
    <ul class="notify_item_content">
        <li>
           <%= curNotice.getSource() %>
        </li>
        <li><div>
        		<%= curNotice.getMessage()%>
        	</div>
        </li>
    </ul>
</div>
<%
    }
%>
