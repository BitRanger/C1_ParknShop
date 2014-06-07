<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Online Store</title>
  <meta charset="utf-8">
  <meta name="viewport" content="initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="css/index.css">
  <link rel="stylesheet" type="text/css" href="css/cart.css">
  <link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<%@ include file="include/header.jsp" %>


<div id="categorybarDiv">
    <%@ include file="include/categorybar.jsp" %>
</div>
<div id="mainContent">
<div id="storeItemList">
    <div id="cartTitle">
        <h3><b><span class="glyphicon glyphicon-shopping-cart"></span>MY CART</b></h3>
    </div>
    <div>
        <% for (int i = 0; i < 6; i++) { %>
        <div class="cartItem">
            <ul>
                <li><input type="checkbox"></li>
                <li>
                    <div class="left cartItemImgDiv">
                        <img src="images/cartItemImg.jpg">
                    </div>
                    <div class="left cartItemDescDiv">
                        <div class="cartItemDesc">现货送豪礼 Apple苹果 iPhone 4s 全新正品 原装无锁智能手机</div>
                        <div class="cartItemExtra"></div>
                    </div>
                </li>
                <li>
                    <p>机身颜色：白色</p>
                    <p>套餐类型：官方标配</p>
                    <p>机身内存：32G</p>
                    <p>版本类型：港澳台</p>
                </li>
                <li>
                    <span>$</span><span style="text-decoration:line-through">218</span><br>
                    <span style="color: #DF4818;font-weight: bold;font-size: 16px;">$172</span>
                </li>
                <li>
    				<span class="itemCart_quantityChangeBar">
                    	<a href="#" class="itemCart_quantityChange">-</a>
                        <input class="itemCart_quantity_input" type="text" value="1" maxlength="8">
                        <a href="#" class="itemCart_quantityChange">+</a>
                    </span>
                </li>
                <li>
                    <span><a href="#">Move to Collection</a></span><br>
                    <span><a href="#">Delete</a></span>
                </li>
            </ul>
        </div>
        <% } %>
    </div>
</div>

</div>




<%@ include file="include/footer.jsp" %>

<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/categorybar.js" type="text/javascript"></script>
<script src="js/common.js" type="text/javascript"></script>
</body>
</html>