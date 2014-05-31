<%@page import="com.bitranger.parknshop.common.model.PsCategory"%>
<div id="categorybarWrapper">
    <div id="categorybar">
        <ul id="categorybarList">
        	<% 
        		java.util.List<PsCategory> psCategories = (java.util.List<PsCategory>)request.getAttribute("psCategories");
        		for(PsCategory n : psCategories)
        		{
        	%>
	        	<li id="<%=n.getId()%>" class="categorybarListItem">
	                <a class="categorybarListItemLink" href="<%=request.getContextPath() %>/category/<%=n.getId()%>"><span><%=n.getName()%></span></a>          
	            </li>
        	<%
        		}
        	%>
        </ul>
    </div>
</div>