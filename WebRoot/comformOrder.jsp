<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Online Store</title>
  <meta charset="utf-8">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="css/index.css">
  <link rel="stylesheet" type="text/css" href="css/comformOrder.css">
  <link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<%@ include file="include/header.jsp" %>


<div id="categorybarDiv">
    <%@ include file="include/categorybar.jsp" %>
</div>
<div id="mainContent">

<div id="storeItemList">
<!-- 新加代码 -->
<div class="comformOrderRow">
    <div class="row">
        <div class="col-md-12">
            <h3>
                <b>
                    Comform Order
                </b>
            </h3>
        </div>
    </div>
</div>



<div class="comformOrderRow">
    <div class="orderbox" style="background-color:#A9A9A9">
        <font size=5 color=white>填写并核对订单信息</font>
    </div>

    <div class="orderbox">
        <font size=3 color=black style="padding-left:15px;"><b>Consignee's message</b></font>
        <a data-toggle="modal" data-target="#myModal">[Modification]</a>
        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">Modify Consignee's message</h4>
                    </div>
                    <div class="modal-body">




                        <form role="form">
                            <div class="form-group">
                                <label >Name</label>
                                <input type="name" class="form-control"  placeholder="Name">
                            </div>
                            <div class="form-group">
                                <label >Tel</label>
                                <input type="name" class="form-control"  placeholder="Tel">
                            </div>
                            <div class="form-group">
                                <label >Email address</label>
                                <input type="email" class="form-control" placeholder="Enter email">
                            </div>
                            <div class="form-group">
                                <label >Anndress</label>
                                <input type="name" class="form-control"  placeholder="Address">
                            </div>
                        </form>




                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->


        <br>
        <font size=2 color=black style="padding-left:30px;">
            Name&nbsp&nbsp&nbsp&nbsp&nbsp
            Tel&nbsp&nbsp&nbsp&nbsp&nbsp
            Email&nbsp&nbsp&nbsp&nbsp&nbsp
        </font>
        <br>
        <font size=2 color=black style="padding-left:30px;">
            陕西 西安市 莲湖区 西关街道   劳动南路88号旺园学生公寓
        </font>

    </div>

    <div class="orderbox">
        <font size=3 color=black style="padding-left:15px;"><b>Mode of payment</b></font>
        <div class="btn-group">
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                Modification
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" >
                <li><button type="button" class="btn btn-default" style="width:160">Online Payment</button></li>
                <li><button type="button" class="btn btn-default" style="width:160">Cash on delivery</button></li>
            </ul>
        </div>


        <br>
        <font size=2 color=black style="padding-left:30px;">
            Online Payment
        </font>

    </div>

    <div class="orderbox">
        <!-- <font size=3 color=black style="padding-left:15px;"><b>商品清单</b></font>
        <font size=2 color=black style="margin-right:150px;">[修改]</font> -->
        <div class="row">
            <div class="col-md-10">
                <font size=3 color=black style="padding-left:15px;"><b>Goods Account</b></font>
            </div>
            <div class="col-md-2">
                <a href="cart.jsp">Return cart</a>
            </div>
        </div>

        <div class="tablebox">
            <table class="table table-bordered" >
                <tr>
                    <td align="center" valign="middle" style=" background-color:#BBBBBB;">Goods</td>
                    <td align="center" valign="middle" style=" background-color:#BBBBBB;">Price</td>
                    <td align="center" valign="middle" style=" background-color:#BBBBBB;">Quantity</td>
                </tr>
                <tr>
                    <td valign="middle" style="height:80px; line-height:80px;">
                        <img src="images/cartpic.jpg">
                        Goods description
                    </td>
                    <td align="center" valign="middle" style="height:80px; line-height:80px;">$318.00</td>
                    <td align="center" valign="middle" style="height:80px; line-height:80px;">×1</td>
                </tr>

                <tr>
                    <td valign="middle" style="height:80px; line-height:80px;">
                        <img src="images/cartpic.jpg">
                        Goods description
                    </td>
                    <td align="center" valign="middle" style="height:80px; line-height:80px;">¥318.00</td>
                    <td align="center" valign="middle" style="height:80px; line-height:80px;">×1</td>
                </tr>

                <tr>
                    <td valign="middle" style="height:80px; line-height:80px;">
                        <img src="images/cartpic.jpg">
                        Goods description
                    </td>
                    <td align="center" valign="middle" style="height:80px; line-height:80px;">¥318.00</td>
                    <td align="center" valign="middle" style="height:80px; line-height:80px;">×1</td>
                </tr>
            </table>
        </div>

        <div class="row">
            <div class="col-md-7"></div>
            <div class="col-md-3" style="height:30px; line-height:30px;">
                <font size=3 color=black>Tatal：</font>
                <font size=3 color=red>$679.90</font>
            </div>
            <div class="col-md-2" >
                <a href="history.jsp"><button type="button" class="btn btn-danger">提交订单</button></a>
            </div>
        </div>
    </div>
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