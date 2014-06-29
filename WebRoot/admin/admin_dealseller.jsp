

<%@page import="com.bitranger.parknshop.seller.dao.IPsSellerDAO"%>
<%@page import="com.bitranger.parknshop.seller.model.PsShopApply"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bitranger.parknshop.seller.model.PsSeller"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <ul id="dealSeller_nav" class="nav nav-tabs">
        <li><a href="#dealSeller_all" data-toggle="tab">Sellers</a></li>
        <li class="active"><a href="#dealSeller_apply" data-toggle="tab">Applications</a></li>
        <li><a href="#dealSeller_create" data-toggle="tab">Create</a></li>
        <li><a href="#dealSeller_work" data-toggle="tab">Work</a></li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div class="tab-pane" id="dealSeller_all">
            <table id="all_sellers">
<input type="button" name="Search" value="Search">&nbsp;&nbsp;&nbsp;
 <input type="text">
 <br/>
 <br/>
                <tr class="admin_sellerTitle">
                    <th>Name</th>
                    <th>ID</th>
                    <th>CreateTime</th>
                    <th>Shop</th>
                    <th>Action</th>
                </tr>
                <% 
                String ctnPath = request.getContextPath();
                SimpleDateFormat XCCFMT = new SimpleDateFormat("YYYY MM DD");
                List<PsSeller> seller_list = (List<PsSeller>)request.getAttribute("seller_list");
                for (int i = 0; i < seller_list.size(); i++) { 
                	PsSeller curSeller = seller_list.get(i);
                %>
                <tr class="admin_sellerItem">
                    <td><%= curSeller.getNickname() %></td>
                    <td> <%= curSeller.getPersonIdNum() %></td>
                    <td> <%= XCCFMT.format(curSeller.getTimeCreated()) %> </t d>
                    <td>
                    <% if (curSeller.getPsShops() != null && curSeller.getPsShops().size() > 0)
                    		{out.println(curSeller.getPsShops().iterator().next().getName());}
                    else {
                    	out.println("No Shop Yet");
                    }
                    	%> 
                    </td>
                    <td>
                        <span class="inline admin_action seller_delete_btn">Delete</span>
                        <span class="inline admin_action seller_ban_btn">Ban</span>
                    </td>
                </tr>
                <% } %>
            </table>
        </div>
        <div class="tab-pane active" id="dealSeller_apply">
            <table id="all_applys">
                <tr class="admin_applyTitle">
                    <th>Proposer</th>
                    <th>Application Notes</th>
                    <th>Application Time</th>
                    <th>Action</th>
                </tr>
                <% 
                List<PsShopApply> shopapply_list = (List<PsShopApply>)request.getAttribute("shopapply_list");
                IPsSellerDAO dao = (IPsSellerDAO)request.getAttribute("psSellerDAO");
                	
                for (int i = 0; i < shopapply_list.size(); i++) { 
                		PsShopApply sa = shopapply_list.get(i);
                	 PsSeller seller = dao.findById(sa.getIdSeller());
                %>
                <tr class="admin_applyItem">
                    <td><%=seller.getNickname() %></td>
                    <td><%= sa.getMessage() %></td>
                    <%-- <td><%=XCCFMT.format(sa.getTimeCreated()) %></td> --%>
                    <td>
                        <span class="admin_action application_pass_btn">
                        	<a href="<%= ctnPath%>/admin/approve/apply/id/<%= sa.getId()%>">Approve
                        	</a>
                        	</span>
                        <span class="admin_action application_fail_btn">Fail</span>
                        <span class="admin_action application_delete_btn">Delete</span>
                    </td>
                </tr>
                <% } %>
            </table>
        </div>
        <div class="tab-pane" id="dealSeller_create">
            ewe
        </div>
        <div class="tab-pane" id="dealSeller_work">hhh
        </div>
    </div>
</div>
