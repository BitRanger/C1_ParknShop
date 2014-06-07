<%@page import="com.bitranger.parknshop.buyer.model.*" %>
<div id="storeHeaderWrapper">
    <div id="storeHeader">
        <div id="logoDiv">
            <a href="index.jsp"><img id="logoImg" src="images/logo.jpg"/></a>
        </div>
        <div id="headerRight">
            <div id="headerRightUp">
                <ul id="headerList">
                    <li class="headerListItem">
                        <a class="headerListItemLink" href="#">Download App</a>
                    </li>
                    <li class="headerListItem">
                        <a class="headerListItemLink" href="#">24x7 Customer Care</a>
                    </li>
                    <li class="headerListItem">
                        <a class="headerListItemLink" onclick="trackOrder()" href="javascript:void(0)">Track Order</a>
                    </li>
                    <li class="headerListItem">
                        <a class="headerListItemLink" href="#"><span class="glyphicon glyphicon-bell"></span></a>
                    </li>
                    <% PsCustomer currentCustomer = (PsCustomer)session.getAttribute("currentCustomer");
                       if (currentCustomer != null) { %>
                        <li class="headerListItem">
                            <a class="headerListItemLink" href="<%=request.getContextPath()%>/customer/<%=currentCustomer.getId()%>">
                               <%=currentCustomer.getNickname() %>
                            </a>
                        </li>
                        <li class="headerListItem">
                            <a class="headerListItemLink" href="<%=request.getContextPath()%>/logout">Logout</a>
                        </li>
                    <% } else { %>
                        <li class="headerListItem">
                            <a class="headerListItemLink" href="signup.jsp">Signup</a>
                        </li>
                        <li class="headerListItem">
                            <a class="headerListItemLink" href="#" data-toggle="modal" data-target="#login_modal">Login</a>
                        </li>                  
                    <%} %>
                    
                </ul>
            </div>
            <div id="headerRightDown">
                <div id="searchDiv">
                    <form id="searchForm">
                        <div style="float:left">
                            <span id="searchIcon" class="glyphicon glyphicon-search"></span>
                            <input type="text" id="searchBar" name="searchBar" placeholder="search everything you like">
                        </div>
                        <div style="float:left">
                            <input type="submit" id="searchBtn" name="searchBtn" value="Search">
                        </div>
                    </form>
                </div>
                <div id="cartDiv">
                    <a href="cart.jsp"><button id="cartBtn">Cart</button></a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="login_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div id="login_main" class="modal-content">
            <div id="login_main_head" class="modal-header">
                <button type="button" class="close" id="login_close_btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="login_main_head_title">Login</h4>
            </div>
            <div id="login_main_body" class="modal-body">
                <div id="login_main_body_left">
                    <form style="margin: 0" action="<%=request.getContextPath()%>/login">
                        <label class="login_input_text_label">Email</label>
                        <input class="login_input_text" type="text" name="email" /><br>
                        <label class="login_input_text_label">Password</label>
                        <input class="login_input_text" type="password" name="password" /><br>

                        <b><input style="margin: 5px 0;vertical-align: middle;" type="checkbox"></b>
                        <span><label style="margin: 0;vertical-align: middle;font-size: 12px;font-weight: 200;">Stay signed in</label></span>
                        <span style="vertical-align: middle;margin-left: 20px;"><a class="login_link" href="#">Forget Password?</a></span><br>

                        <p style="font-size: 12px;margin-left: 18px;color:#999999">
                            To protect your privacy, remember to sign out when you're done shopping.
                            <a class="login_link" href="#">Learn more</a>
                        </p>
                        <input id="login_btn" type="submit" value="Login">
                        <span style="margin-left: 20px;font-size: 12px;">
                            No account?&nbsp;&nbsp;
                            <a class="login_link" href="#">Sign up</a>
                        </span>
                    </form>
                </div>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>