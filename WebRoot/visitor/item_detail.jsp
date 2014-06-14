<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Online Store</title>
  <meta charset="utf-8">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="css/index.css">
  <link rel="stylesheet" type="text/css" href="css/detail.css">
  <link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<%@ include file="include/header.jsp" %>

<div id="categorybarDiv">
    <%@ include file="include/categorybar.jsp" %>
</div>
<div id="mainContent">
    <div id="storeItemList">
        <div id="itemDetail">
            <div id="itemDetail_PicShow">
                <div id="itemDetail_PicShow_Big">
                    <img id="itemDetail_PicShow_Big_img" src="images/detail/detail1.JPG">
                </div>
                <ul id="itemDetail_PicShow_thumbnail_Set">
                    <li class="itemDetail_PicShow_thumbnail_item">
                        <a href="#"><img class="itemDetail_PicShow_thumbnail" src="images/detail/detail1.JPG"/></a>
                    </li>
                    <li class="itemDetail_PicShow_thumbnail_item">
                        <a href="#"><img class="itemDetail_PicShow_thumbnail" src="images/detail/detail2.JPG"/></a>
                    </li>
                    <li class="itemDetail_PicShow_thumbnail_item">
                        <a href="#"><img class="itemDetail_PicShow_thumbnail" src="images/detail/detail3.JPG"/></a>
                    </li>
                    <li class="itemDetail_PicShow_thumbnail_item">
                        <a href="#"><img class="itemDetail_PicShow_thumbnail" src="images/detail/detail4.JPG"/></a>
                    </li>
                    <li class="itemDetail_PicShow_thumbnail_item">
                        <a href="#"><img class="itemDetail_PicShow_thumbnail" src="images/detail/detail5.JPG"/></a>
                    </li>
                </ul>
            </div>
            <div id="itemDetail_Desc">
                <div id="itemDetail_DescTitle">
                    <h3>United Colors of Benetton Solid Men's Shorts</h3>
                </div>
                <div>
                    <div id="itemDetail_price">
                        <span class="itemDetail_intro">Price</span>
                        <span>$</span>
                        <span style="text-decoration: line-through">32.00</span>
                    </div>
                    <div id="itemDetail_promotion">
                        <span style="margin-top: 5px" class="itemDetail_intro">Promotion</span>
                        <span style="font-size: 24px;color: #f40;">$26.00</span>
                    </div>
                    <div id="itemDetail_deliver">

                    </div>
                    <div id="itemDetail_size">
                        <span style="margin-top: 5px" class="itemDetail_intro">Size</span>
                        <ul>
                            <li class="itemDetail_sizeItem"><a href="#"><span>42</span></a></li>
                            <li class="itemDetail_sizeItem"><a href="#"><span>44</span></a></li>
                            <li class="itemDetail_sizeItem"><a href="#"><span>46</span></a></li>
                            <li class="itemDetail_sizeItem"><a href="#"><span>48</span></a></li>
                            <li class="itemDetail_sizeItem"><a href="#"><span>50</span></a></li>
                        </ul>
                    </div>
                    <div id="itemDetail_color">
                        <span style="margin-top: 5px" class="itemDetail_intro">Color</span>
                        <ul>
                            <li class="itemDetail_colorItem"><a href="#"><span></span></a></li>
                            <li class="itemDetail_colorItem"><a href="#"><span></span></a></li>
                        </ul>
                    </div>
                    <div id="itemDetail_quantity">
                        <span class="itemDetail_intro">Quantity</span>
                        <span id="itemDetail_quantityChangeBar">
                            <a href="#"  class="itemDetail_quantityChange">-</a>
                            <input id="itemDetail_quantity_input" type="text"  value="1" maxlength="8">
                            <a href="#" class="itemDetail_quantityChange">+</a>
                         </span>
                    </div>
                    <div id="itemDetail_buy">
                        <Button id="itemDetail_buyBtn">Buy Now</Button>
                        <Button id="itemDetail_chartBtn">Add to Chart</Button>
                    </div>
                </div>


            </div>
        </div>

        <div id="itemDesc">
            <div id="itemDescTab">
                <Button id="itemDescTabBtn_detail" class="itemDescTabBtn">Item Details</Button>
                <Button id="itemDescTabBtn_comment" class="itemDescTabBtn">Comments</Button>
                <Button id="itemDescTabBtn_record" class="itemDescTabBtn">Retail Record</Button>
            </div>
            <div id="itemDesc_Desc">
                <ul id="itemDesc_attributes_list">
                    <li title=" 国内知名品牌">品牌类型: 国内知名品牌</li>
                    <li title=" 七分裤">裤长: 七分裤</li>
                    <li title=" JS14CYP683D">货号: JS14CYP683D</li>
                    <li title=" 军绿色 卡其色">颜色: 军绿色 卡其色</li>
                    <li title=" 薄款纯棉长裤！透气！吸汗！舒爽 正反两面穿！纯棉休闲短裤七分裤 30（2.31尺） 31（2.39尺） 32（2.46尺） 33(2.54尺) 34(2.62尺) 35(2.69尺) 36(2.77尺) 38(2.92尺) 40(3.08尺) 42(3.23尺) 品牌授权！正品保障！假一赔十！">尺码: 薄款纯棉长裤！透气！吸汗！舒爽 正反两面穿！纯棉休闲短裤七分裤 30（2.31尺） 31（2.39尺） 32（2.46尺） 33(2.54尺) 34(2.62尺) 35(2.69尺) 36(2.77尺) 38(2.92尺) 40(3.08尺) 42(3.23尺) 品牌授权！正品保障！假一赔十！</li>
                    <li title=" 口袋装饰">款式细节: 口袋装饰</li>
                    <li title=" 水洗">工艺处理: 水洗</li>
                    <li title=" Afs Jeep/战地吉普">品牌: Afs Jeep/战地吉普</li>
                    <li title=" 棉">主材含量: 棉</li>
                    <li title=" 95%以上">棉含量: 95%以上</li>
                    <li title=" 夏季">适用季节: 夏季</li>
                    <li title=" 休闲">适用场景: 休闲</li>
                    <li title=" 青年">适用对象: 青年</li>
                    <li title=" 薄款">厚薄: 薄款</li>
                    <li title=" 2014年">上市时间: 2014年</li>
                    <li title=" 棉">面料材质: 棉</li>
                    <li title=" 沙滩裤">款式: 沙滩裤</li>
                    <li title=" 青春流行">基础风格: 青春流行</li>
                    <li title=" 工装军旅">细分风格: 工装军旅</li>
                </ul>
                <div id="itemDesc_in_detail">
                    <img src="images/detail/desc1.jpg"/>
                </div>
            </div>
            <div id="itemDesc_Comment">
                <div id="itemdesc_comment_Overview">
                    <span>The Impression: </span>
                    <ul>
                        <li>
                            <a href="#">质量不错 (10)</a> 
                        </li>
                        <li>
                            <a href="#">式样好 (4)</a>                            
                        </li>
                        <li>
                            <a href="#">便宜 (3)</a>                            
                        </li>
                        <li>
                            <a href="#">尺码很好 (3)</a>                           
                        </li>
                        <li>
                            <a href="#">如实描述 (3)</a>  
                        </li>
                        <li>
                            <a href="#">面料好 (3)</a>                            
                        </li>
                        <li>
                            <a href="#">穿着美 (2)</a>                            
                        </li>
                        <li>
                            <a href="#">态度不错 (2)</a>                           
                        </li>
                        <li class="tb-r-neg">
                            <a href="#" data-act="impress" data-val="620-13">质量一般 (4)</a>                          
                        </li>
                        <li class="tb-r-neg">
                            <a href="#" data-act="impress" data-val="223-13">不合身 (4)</a>                           
                        </li>
                    </ul>
                </div>
                <div id="itemdesc_comment_Spec">
                    <ul>
                        <%
                            for (int i = 0; i < 10; i++) {
                        %>
                        <li>
                            <div class="commentItem_left">
                                <span>By&nbsp;<a href="#">Richard Fiske</a></span>
                                <i style="margin-top: 5px" class="bitranger_3_star"></i>
                            </div>
                            <div class="commentItem_right">
                                <div>
                                    A quality product as expected. Well worth the money in the long run. I usually like to wait for the holiday time sales on Amazon to buy jeans but I just had to have them now.
                                </div>
                                <div style="margin-top: 10px">
                                    <span>April 24, 2011</span>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <span>Color: Grey, Size: 44</span>
                                </div>
                            </div>
                        </li>
                        <%
                            }
                        %>

                    </ul>
                </div>
            </div>
            <div id="itemDesc_Record">

            </div>
        </div>

        <div id="itemRecommand">
            <div style="margin: 10px 0 20px 0;">
                CUSTOMERS WHO VIEWED THIS PRODUCT ALSO VIEWED
            </div>
            <ul>
                <li>
                    <a href="#"><img src="images/detail/recommand1.jpg"/></a>
                </li>
                <li>
                    <a href="#"><img src="images/detail/recommand2.jpg"/></a>
                </li>
                <li>
                    <a href="#"><img src="images/detail/recommand3.jpg"/></a>
                </li>
                <li>
                    <a href="#"><img src="images/detail/recommand4.jpg"/></a>
                </li>
                <li>
                    <a href="#"><img src="images/detail/recommand5.jpg"/></a>
                </li>
            </ul>
        </div>
    </div>

</div>

<%@ include file="include/footer.jsp" %>

<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/categorybar.js" type="text/javascript"></script>
<script src="js/details.js" type="text/javascript"></script>
<script src="js/common.js" type="text/javascript"></script>
</body>
</html>