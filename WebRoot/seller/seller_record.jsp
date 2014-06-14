<%--
  Created by IntelliJ IDEA.
  User: Kaidi
  Date: 5/31/2014
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="record_nav">
    <label style="width: 240px; margin-top: 5px" class="common_label left">
        Checkout your last retail records
    </label>
    <div class="left" id="record_date">
        <select>
            <option>Today</option>
            <option>Yesterday</option>
            <option>Last Month</option>
            <option>Last 3 Months</option>
            <option>Last Year</option>
        </select>
    </div>
</div>
<div id="recordTableDiv">
    <table id="recordTable">
        <tr id="recordTableHeader">
            <th>Product</th>
            <th>Sold At</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Buyer</th>
            <th>State</th>
        </tr>
        <% for(int i = 0; i < 5; i++) { %>
        <tr class="recordRow">
            <td>
                <div class="left recordItemImgDiv">
                    <img src="images/cartItemImg.jpg">
                </div>
                <div class="left recordItemDescDiv">
                    <div class="recordItemDesc">现货送豪礼 Apple苹果 iPhone 4s 全新正品 原装无锁智能手机</div>
                    <div class="recordItemExtra"></div>
                </div>
            </td>
            <td>
                <span>18:35, 2014-5-17</span>
            </td>
            <td>
                <span>$37</span>
            </td>
            <td>
                <span>8</span>
            </td>
            <td>
                <span>Tomas Young</span>
            </td>
            <td>
                <span>Delivering</span>
            </td>
        </tr>
        <% } %>
    </table>
</div>






