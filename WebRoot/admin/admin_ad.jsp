<%@page import="com.bitranger.parknshop.common.ads.PsPromotItem"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul id="ad_nav" class="nav nav-tabs">
    <li ><a href="#ad_publish" data-toggle="tab"></a></li>
    <li class="active"><a href="#ad_view" data-toggle="tab">View All</a></li>
</ul>
<!-- Tab panes -->
<div class="tab-content">
    <div class="tab-pane" id="ad_view">
        <table id="ad_listTable">
            <tr id="ad_listTableHeader">
                <th>ID</th>
                <th>Content</th>
                <th>Clicks</th>
                <th>Operation</th>
            </tr>
            <% 
            List<PsPromotItem> ad_list = (List<PsPromotItem>)request.getAttribute("ad_list");
            if (ad_list == null || ad_list.size() < 1)
            	out.print("No Advertisement Yet");
            else
            for(int i = 0; i < ad_list.size(); i++) { 
            	PsPromotItem ad = ad_list.get(i);
            %>
            <tr class="ad_listRow">
                <td>
                    <span><%= ad.getId() %></span>
                </td>
                <td>
                    <div class="left ad_listItemImgDiv">
                        <img src="<%= ad.getPicUrl().trim()%>">
                    </div>
                    <div class="left ad_listItemDescDiv">
                    	<%= ad.getDescription()%>
                    </div>
                </td>
                <td>
                    <span><%=ad.getPsAdItem().getNumFetched() %></span>
                </td>
                <td>
                    <span class="operation">Modify</span>
                    <span class="operation">Delete</span>
                </td>
            </tr>
            <% } %>
        </table>
        <div class="pageList">
            <ul>
                <% for (int i = 0; i < 6; i++) {%>
                <li>
                    <span><%= (i + 1) %></span>
                </li>
                <% } %>
            </ul>
        </div>
    </div>
</div>



