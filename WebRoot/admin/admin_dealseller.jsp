<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 6/19/2014
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <ul id="dealSeller_nav" class="nav nav-tabs">
        <li><a href="#dealSeller_all" data-toggle="tab">Sellers</a></li>
        <li class="active"><a href="#dealSeller_apply" data-toggle="tab">Apply</a></li>
        <li><a href="#dealSeller_create" data-toggle="tab">Create</a></li>
        <li><a href="#dealSeller_work" data-toggle="tab">Work</a></li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div class="tab-pane" id="dealSeller_all">
            <table id="all_sellers">
                <tr class="admin_sellerTitle">
                    <th>Name</th>
                    <th>ID</th>
                    <th>CreateTime</th>
                    <th>Shop</th>
                    <th>Action</th>
                </tr>
                <% for (int i = 0; i < 10; i++) { %>
                <tr class="admin_sellerItem">
                    <td>Kaidan</td>
                    <td>334476593</td>
                    <td>09 24th, 2011</td>
                    <td>Star Trek</td>
                    <td>
                        <span class="admin_action">Modify</span>
                        <span class="admin_action">Delete</span>
                        <span class="admin_action">Ban</span>
                    </td>
                </tr>
                <% } %>
            </table>
        </div>
        <div class="tab-pane active" id="dealSeller_apply">

        </div>
        <div class="tab-pane" id="dealSeller_create">
            ewe
        </div>
        <div class="tab-pane" id="dealSeller_work">hhh
        </div>
    </div>
</div>
