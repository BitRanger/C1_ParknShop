<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 5/31/2014
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="margin-left: 10px;">
    <%
        for (int i = 0; i < 4; i++) {
    %>
    <div class="historyItem">
        <ul class="historyItemTitle">
            <li><input type="checkbox"></li>
            <li><span>2014-05-24</span></li>
            <li>
                <span>OrderNumber:</span>
                <span>666349364068871</span></li>
            <li><span><a href="#">StoreName</a></span></li>
        </ul>
        <ul class="historyItemContent">
            <li>
                <div class="left historyItemImgDiv">
                    <img src="images/cartItemImg.jpg">
                </div>
                <div class="left historyItemDescDiv">
                    <div class="historyItemDesc">现货送豪礼 Apple苹果 iPhone 4s 全新正品 原装无锁智能手机</div>
                    <div class="historyItemExtra"></div>
                </div>
            </li>
            <li>
                <span>$218</span><span>5</span>
            </li>
            <li>
                <span><a class="historyActionLink" href="#">SomeAction</a></span><br>
                <span><a class="historyActionLink" href="#">Complaint</a></span>
            </li>
            <li>
                <span><a class="historyActionLink" href="#">State</a></span><br>
                <span><a class="historyActionLink" href="#">OrderDetail</a></span>
            </li>
            <li>
                <span><a class="historyActionLink" href="#">Comment</a></span>
            </li>
        </ul>
    </div>
    <%
        }
    %>

</div>