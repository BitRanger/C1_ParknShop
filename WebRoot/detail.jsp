<html>
<head>
  <title>Online Store</title>
  <meta charset="utf-8">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="css/index.css">
  <link rel="stylesheet" type="text/css" href="css/detail.css">
</head>
<body>
<%@ include file="include/header.jsp" %>

<div id="categorybarDiv">
    <%@ include file="include/categorybar.jsp" %>
</div>
<div id="mainContent">
<div id="storeItemList">
    <div class="row">
        <div class="page-header">
            <h4>The Long sleeve t-shirt men's Lapel T-shirts Mens </h4>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="thumbnail">
                <a href="#"><img src="images/detail.jpg" alt="..."></a>
                <div class="col-md-3">
                    <div class="thumbnail">
                        <a href="#"><img src="images/pro1.jpg" alt=""></a>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="thumbnail">
                        <a href="#"><img src="images/pro2.jpg" alt=""></a>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="thumbnail">
                        <a href="#"><img src="images/pro3.jpg" alt=""></a>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="thumbnail">
                        <a href="#"><img src="images/pro1.jpg" alt=""></a>
                    </div>
                </div>
            </div>
        </div>
                         <!--product size and color-->
             <div class="col-md-6"> 
                  <div class="row">
                    <div class="col-md-6">
                       <div class="row">
                          <div class="page-header"> <h4>Select Color </h4> </div>
                       </div>
                        <input type="checkbox"  > <font size="4" color="red">red</font>
                        <input type="checkbox"  > <font size="4" color="blue">blue</font>
                        <input type="checkbox"  > <font size="4" color="black">black</font>
                        <input type="checkbox"  > <font size="4" color="gree">gree</font>
                    </div>
                   <div class="col-md-6">
                        <div class="row">
                           <div class="page-header"> <h4>Select Size</h4> </div>
                       </div>
                        <input type="checkbox"  > <font size="4" color="blue">28</font>
                        <input type="checkbox"  > <font size="4" color="blue">30</font>
                        <input type="checkbox"  > <font size="4" color="blue">32</font>
                        <input type="checkbox"  > <font size="4" color="blue">35</font>
                   </div>
                </div>

            <div class="row">
                <div class="col-md-3">
                    <div class="caption">
                        <h5><b><font color="#ff0000">3516</font></b> </h5>
                        <p>monthly sales</p>
                    </div>
                </div>
                <div class="col-md-6" align="center">
                    <div class="caption">
                        <h5><b><font color="#0000ff">3236</font></b> </h5>
                        <p>evaluate</p>
                        <em><img src="images/evaluteStar.jpg" alt="">4.5</em>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="caption">
                        <h5><b><font color="#00ff00">35156</font></b> </h5>
                        <p>views</p>
                    </div>
                </div>
              </div>
               
            <p><br>Price:   <b>$69.00</b> </p>
            <p>Promotion: <font color="#ff0000"><b>$39.00</b> </font></p>
            <!--输入框的最小值为0，即购买物品最少为0，最大值为100，即一次最多购买100件商品-->
            <p>Quatityt:   <input type="number" value="1"  style="width:60px" min="0" max="100">  </p>
              
            <div class="row">
                <div class="col-md-6">
                    <a href="comformOrder.html"><img src="images/BuyNow.jpg" alt="" style="border:2 outset #ffff00"></a>
                </div>
                <div class="col-md-6">
                    <a href="#"><img src="images/AddToCart.jpg" alt="" style="border:2 outset #ffff00"></a>
                </div>
            </div>
        </div>
    </div>

<!--评价,宝贝详情-->
<div class="navbar navbar-default" role="navigation">
        <div class="navbar-collapse collapse">
          <ul id="myTab"  class="nav nav-tabs">
            <li><a href="#goodsDetails" data-toggle="tab">Goods details</a></li>
            <li><a href="#commentDetails" data-toggle="tab">Comment Details</a></li>
            <li><a href="#tradeRecords" data-toggle="tab">Trade Records</a></li>
          </ul>
          <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade"  id="goodsDetails">
             <div class="row">
                 <div class="page-header">
                       <h4>Product Deatails</h4>
                </div>
            </div>
            <table>
              <tr>
               <td width="40%">Type:&nbsp;&nbsp;fashion</td>
               <td width="40%">Type:&nbsp;&nbsp;fashion</td>
               <td width="40%">Type:&nbsp;&nbsp;fashion</td>  
              </tr>
              <tr>
               <td>Type:&nbsp;&nbsp;fashion</td>
               <td>Type:&nbsp;&nbsp;fashion</td>
               <td>Type:&nbsp;&nbsp;fashion</td>
              </tr>
              <tr>
               <td>Type:&nbsp;&nbsp;fashion</td>
               <td>Type:&nbsp;&nbsp;fashion</td>
               <td>Type:&nbsp;&nbsp;fashion</td>
              </tr>
              <tr>
               <td>Type:&nbsp;&nbsp;fashion</td>
               <td>Type:&nbsp;&nbsp;fashion</td>
               <td>Type:&nbsp;&nbsp;fashion</td>
              </tr>
              <tr>
               <td>Type:&nbsp;&nbsp;fashion</td>
               <td>Type:&nbsp;&nbsp;fashion</td>
              </tr>
            </table>
            </div>
            <div class="tab-pane fade"  id="commentDetails">
             <div class="row">
                 <div class="page-header">
                       <h4>Comment Details</h4>
                  </div>
              <p>Product comment: 4.6</p>  
              <br>
               <input type="radio">All&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="radio">Good comments&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="radio">middle comments&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="radio">bad comments&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="radio">Addtional comments&nbsp;&nbsp;&nbsp;&nbsp;
              <br>
              <br>
              <br>
              <table>
              <tr>
                <td width="20%"><a href="#"><img src="images/head.png" width="50px" height="50px"></a></td>
                <td width="50%">This is the goods description.This is the goods description.This is the
                                    goods description.</td>
              </tr>
               <tr>
                <td width="20%"><a href="#"><img src="images/head.png" width="50px" height="50px"></a></td>
                <td width="50%">This is the goods description.This is the goods description.This is the
                                    goods description.</td>
              </tr>
               <tr>
                <td width="20%"><a href="#"><img src="images/head.png" width="50px" height="50px"></a></td>
                <td width="50%">This is the goods description.This is the goods description.This is the
                                    goods description.</td>
              </tr>
             </table>
            </div>
         </div>
            <div class="tab-pane fade"  id="tradeRecords">
              <div class="row">
                 <div class="page-header">
                       <h4>Trade Records</h4>
                </div>
            </div>
            <table>
              <tr>
               <td width=20%>UserName</td>
               <td width=20%>Goods Name</td>
               <td width=15%>Price</td>   
               <td width=15%>Quality</td>
               <td width=30%>Trade Date</td>
               <td width=20%>Size</td>
              </tr>
              <tr>
               <td>zhang3</td>
               <td>clothes</td>
               <td>$24.00</td>
               <td>3</td>
               <td>2013-05-15&nbsp;&nbsp;15:20:16</td> 
               <td>XL</td> 
              </tr>
              <tr>
               <td>li4</td>
               <td>clothes</td>
               <td>$51.00</td>
               <td>1</td>
               <td>2013-05-15&nbsp;&nbsp;15:20:16</td>  
               <td>XL</td>
              </tr>
              <tr>
               <td>wang5</td>
               <td>clothes</td>
               <td>$25.21</td>
               <td>2</td>
               <td>2013-05-15&nbsp;&nbsp;15:20:16</td>  
               <td>XL</td>
              </tr>
            </table>
            </div>
          </div>
        </div><!--/.nav-collapse -->
    </div>
    
    <!-- 同类商品推荐 -->
    <div class="row">
        <div class="page-header">
            <h4>Recommend </h4>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <div class="thumbnail">
                <a href="#"><img src="images/pro1.jpg" alt=""></a>
            </div>
        </div>
        <div class="col-md-3">
            <div class="thumbnail">
                <a href="#"><img src="images/pro2.jpg" alt=""></a>
            </div>
        </div>
        <div class="col-md-3">
            <div class="thumbnail">
                <a href="#"><img src="images/pro3.jpg" alt=""></a>
            </div>
        </div>
        <div class="col-md-3">
            <div class="thumbnail">
                <a href="#"><img src="images/pro1.jpg" alt=""></a>
            </div>
        </div>
    </div>
</div>


</div>

<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/index.js" type="text/javascript"></script>
</body>
</html>