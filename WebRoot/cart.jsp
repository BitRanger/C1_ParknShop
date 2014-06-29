<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Online Store</title>
  <meta charset="utf-8">
  <link rel="stylesheet" type="text/css" href="../asset/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="../asset/css/index.css">
  <link rel="stylesheet" type="text/css" href="../asset/css/cart.css">
</head>
<body>
<%@ include file="../include/header.jsp" %>


<div id="categorybarDiv">
    <%@ include file="../include/categorybar.jsp" %>
</div>
<div id="mainContent">
<div id="storeItemList">
    <!-- 新加 -->
    <div class="row1">
        <div class="row">
            <div class="col-md-12">
                <h3>
                    <b>
                        <span class="glyphicon glyphicon-shopping-cart"></span>
                        MY CART
                    </b>
                </h3>
            </div>
        </div>
    </div>


    <div class="tab">
        <table class="table table-bordered" >
            <tr>
                <td align="center" valign="middle">Goods</td>
                <td align="center" valign="middle">Price</td>
                <td align="center" valign="middle">Quantity</td>
                <td align="center" valign="middle">Operation</td>
            </tr>

            <tr>
                <td>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"><!--  Check me out -->
                            <img src="images/cartpic.jpg">
                            Goods Description
                        </label>
                    </div>
                </td>

                <td align="center" valign="middle" style="height:80px; line-height:80px;">¥318.00</td>

                <td align="center" valign="middle" style="height:80px; line-height:80px;">
                    <button type="button" class="btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-minus"></span>
                    </button>

                    <!-- <input type="text" width="30" height="10" placeholder="1"> -->
                    <input name="" type="text" style="width:30px; height:22px;" placeholder="1"/>
                    <button type="button" class="btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-plus"></span>
                    </button>
                </td>

                <td align="center" valign="middle" style="height:80px; line-height:80px;"><a href="#">Delete</a></td>
            </tr>

            <tr>
                <td>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"><!--  Check me out -->
                            <img src="images/cartpic.jpg">
                            Goods Description
                        </label>
                    </div>
                </td>

                <td align="center" valign="middle" style="height:80px; line-height:80px;">¥318.00</td>

                <td align="center" valign="middle" style="height:80px; line-height:80px;">
                    <button type="button" class="btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-minus"></span>
                    </button>

                    <!-- <input type="text" width="30" height="10" placeholder="1"> -->
                    <input name="" type="text" style="width:30px; height:22px;" placeholder="1"/>
                    <button type="button" class="btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-plus"></span>
                    </button>
                </td>

                <td align="center" valign="middle" style="height:80px; line-height:80px;"><a href="#">Delete</a></td>
            </tr>

            <tr>
                <td>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"><!--  Check me out -->
                            <img src="images/cartpic.jpg">
                            Goods Description
                        </label>
                    </div>
                </td>

                <td align="center" valign="middle" style="height:80px; line-height:80px;">¥318.00</td>

                <td align="center" valign="middle" style="height:80px; line-height:80px;">
                    <button type="button" class="btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-minus"></span>
                    </button>

                    <!-- <input type="text" width="30" height="10" placeholder="1"> -->
                    <input name="" type="text" style="width:30px; height:22px;" placeholder="1"/>
                    <button type="button" class="btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-plus"></span>
                    </button>
                </td>

                <td align="center" valign="middle" style="height:80px; line-height:80px;"><a href="#">Delete</a></td>
            </tr>
        </table>
    </div>

    <div class="tab1">
        <div class="row">
            <div class="col-md-9"></div>
            <div class="col-md-2">Total：</div>
            <div class="col-md-1">$318.00</div>
        </div>
    </div>

    <div class="tab2">
        <div class="col-md-2">
            <a href="index.jsp"><button type="button" class="btn btn-default">< Go on Shopping</button></a>
        </div>
        <div class="col-md-8"></div>
        <div class="col-md-2">
            <a href="comformOrder.jsp"><button type="button" class="btn btn-danger">Set Settle ></button></a>
        </div>




</div>
</div>

</div>




<%@ include file="../include/footer.jsp" %>

<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/index.js" type="text/javascript"></script>

</body>
</html>