<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 6/25/2014
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Store</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/buyer_css/buyer_comment.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css">
</head>
<body>
<%@ include file="../include/header.jsp" %>


<div id="categorybarDiv">
    <%@ include file="../include/categorybar.jsp" %>
</div>

<div id="mainContent">

   <div id="storeItemList">
       <div id="itemDetail">
           <div id="itemDetail_PicShow">
               <div id="itemDetail_PicShow_Big">
                   <img id="itemDetail_PicShow_Big_img" src="<%=request.getContextPath() %>/images/detail/detail1.JPG">
               </div>
           </div>
           <div id="itemDetail_Desc">
               <div id="itemDetail_DescTitle">
                   <h3>${psItem.name}</h3>
               </div>
               <div>
                   <div id="itemDetail_price">
                       <span class="itemDetail_intro">Price</span>
                       <span>$</span>
                       <span style="text-decoration: line-through">${psItem.price}</span>
                   </div>
                   <div id="itemDetail_promotion">
                       <span style="margin-top: 5px" class="itemDetail_intro">Promotion</span>
                       <span style="font-size: 24px;color: #f40;">$${psItem.price}</span>
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
               </div>


           </div>
       </div>
       <div id="item_comment">
           <div id="item_comment_title">What do you think of the experience?</div>

           <div style="height: 240px">
               <div id="item_comment_left">

                   <div id="comment_box">
                       <div id="comment_box_title"></div>
                       <div id="comment_box_content">
                           <textarea id="item_comment_area"></textarea>
                       </div>
                   </div>
                   <div id="comment_error">
                       please give your comment
                   </div>


               </div>
               <div id="item_comment_right">
                   <div class="comment_star_item">
                       <span>描述相符: </span>
                       <i data-rating="0" class="bitranger_0_star" id="rating1"></i>
                       <span class="errorTriangle"></span>
                   </div>
                   <div class="comment_star_item">
                       <span>服务态度: </span>
                       <i data-rating="0" class="bitranger_0_star" id="rating2"></i>
                       <span class="errorTriangle"></span>
                   </div>
                   <div class="comment_star_item">
                       <span>发货速度: </span>
                       <i data-rating="0" class="bitranger_0_star" id="rating3"></i>
                       <span class="errorTriangle"></span>
                   </div>
                   <div class="comment_star_item">
                       <span>物流速度: </span>
                       <i data-rating="0" class="bitranger_0_star" id="rating4"></i>
                       <span class="errorTriangle"></span>
                   </div>
               </div>
           </div>
           <div>
               <button class="common_btn" id="commentBtn">Submit</button>
           </div>
       </div>
   </div>

</div>


<%@ include file="../include/footer.jsp" %>


<script src="<%=request.getContextPath() %>/js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/categorybar.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/buyer.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/common.js" type="text/javascript"></script>
<script type="text/javascript">
	var psItemId = ${psItem.id};
	$("#commentBtn").click(function() {
		var rating1 = parseInt($("#rating1").data("rating"));
		var rating2 = parseInt($("#rating2").data("rating"));
		var rating3 = parseInt($("#rating3").data("rating"));
		var rating4 = parseInt($("#rating4").data("rating"));
	   if (checkComment()) {
	       $.post("<%=request.getContextPath()%>/makeComment",
	       {
	    	   psItemId: psItemId,
	           content: $("#item_comment_area").val(),
	           scoreItem: Math.floor((rating1 + rating2 + rating3 + rating4) / 4),
	           scoreShop: Math.floor((rating1 + rating2 + rating3 + rating4) / 4)
	       }, function(data) {
	    	   alert(data);
	       });
	   }
	});
</script>
</body>
</html>