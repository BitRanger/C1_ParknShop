<%@page import="com.bitranger.parknshop.common.model.PsComment"%>
<%@page import="com.bitranger.parknshop.common.model.PsItem"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Online Store</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/index.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/detail.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/common.css">
</head>
<%
	PsItem psItem = (PsItem) request.getAttribute("psItem");
	List<PsComment> psComments = (List<PsComment>) request
	.getAttribute("psComments");
	if (psItem != null) {
%>
<body>
	<%@ include file="include/header.jsp"%>

	<div id="categorybarDiv">
		<%@ include file="include/categorybar.jsp"%>
	</div>

	<div id="mainContent">
		<div id="storeItemList">
			<div id="itemDetail">
				<div id="itemDetail_PicShow">
					<div id="itemDetail_PicShow_Big">
						<img id="itemDetail_PicShow_Big_img"
							src="<%=request.getContextPath()%>/images/<%=psItem.getUrlPicture()%>">
					</div>
					<ul id="itemDetail_PicShow_thumbnail_Set">
						<li class="itemDetail_PicShow_thumbnail_item"><a href="#"><img
								class="itemDetail_PicShow_thumbnail"
								src="<%=request.getContextPath()%>/images/<%=psItem.getUrlPicture()%>" /></a></li>
						<li class="itemDetail_PicShow_thumbnail_item"><a href="#"><img
								class="itemDetail_PicShow_thumbnail"
								src="<%=request.getContextPath()%>/images/<%=psItem.getUrlPicture()%>" /></a></li>
						<li class="itemDetail_PicShow_thumbnail_item"><a href="#"><img
								class="itemDetail_PicShow_thumbnail"
								src="<%=request.getContextPath()%>/images/<%=psItem.getUrlPicture()%>" /></a></li>
						<li class="itemDetail_PicShow_thumbnail_item"><a href="#"><img
								class="itemDetail_PicShow_thumbnail"
								src="<%=request.getContextPath()%>/images/<%=psItem.getUrlPicture()%>" /></a></li>
						<li class="itemDetail_PicShow_thumbnail_item"><a href="#"><img
								class="itemDetail_PicShow_thumbnail"
								src="<%=request.getContextPath()%>/images/<%=psItem.getUrlPicture()%>" /></a></li>
					</ul>
				</div>
				<div id="itemDetail_Desc">
					<div id="itemDetail_DescTitle">
						<h3><%=psItem.getName()%></h3>
					</div>
					<div>
						<div id="itemDetail_price">
							<span class="itemDetail_intro">Price</span> <span>$</span> <span
								style="text-decoration: line-through"><%=psItem.getPrice()%></span>
						</div>
						<div id="itemDetail_promotion">
							<span style="margin-top: 5px" class="itemDetail_intro">Promotion</span>
							<span style="font-size: 24px;color: #f40;">$<%=psItem.getPrice()%></span>
						</div>
						<div id="itemDetail_deliver"></div>
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
						<div id="itemDetail_buy">
							<a
								href="<%=request.getContextPath()%>/addcollection?itemId=<%=psItem.getId()%>"><Button
									id="itemDetail_buyBtn">Add Favourite</Button></a> <a
								href="<%=request.getContextPath()%>/addcart?itemId=<%=psItem.getId()%>"><Button
									id="itemDetail_chartBtn">Add to Cart</Button></a> <a href="#"
								id="commentBtn" data-toggle="modal" data-target="#commentModal"><Button
									id="itemDetail_commentBtn">Make Comment</Button></a>
						</div>
					</div>


				</div>
			</div>

			<div id="itemDesc">
				<div id="itemDescTab">
					<Button id="itemDescTabBtn_detail" class="itemDescTabBtn">Item
						Details</Button>
					<Button id="itemDescTabBtn_comment" class="itemDescTabBtn">Comments</Button>
					<Button id="itemDescTabBtn_record" class="itemDescTabBtn">Retail
						Record</Button>
				</div>
				<div id="itemDesc_Desc"></div>
				<div id="itemDesc_Comment">
					<div id="itemdesc_comment_Overview">
						<span>The Impression: </span>
						<ul>
							<li><a href="#">质量不错 (10)</a></li>
							<li><a href="#">式样好 (4)</a></li>
							<li><a href="#">便宜 (3)</a></li>
							<li><a href="#">尺码很好 (3)</a></li>
							<li><a href="#">如实描述 (3)</a></li>
							<li><a href="#">面料好 (3)</a></li>
							<li><a href="#">穿着美 (2)</a></li>
							<li><a href="#">态度不错 (2)</a></li>
							<li class="tb-r-neg"><a href="#" data-act="impress"
								data-val="620-13">质量一般 (4)</a></li>
							<li class="tb-r-neg"><a href="#" data-act="impress"
								data-val="223-13">不合身 (4)</a></li>
						</ul>
					</div>
					<div id="itemdesc_comment_Spec">
						<ul>
							<%
								if (psComments != null && !psComments.isEmpty()) {
																				for (PsComment psComment : psComments) {
							%>
							<li>
								<div class="commentItem_left">
									<span>By&nbsp;<a href="#"><%=psComment.getPsCustomer().getNickname()%></a></span>
									<i
										style="margin-top: 5px; background: url(<%=request.getContextPath()%>/images/ratestar.png) no-repeat <%=psComment.getScoreItem() * 16 - 80%>px 0;"
										class="bitranger_3_star"></i>
								</div>
								<div class="commentItem_right">
									<div><%=psComment.getContent()%>
									</div>
									<div style="margin-top: 10px">
										<span><%=psComment.getTimeCreated().toString()%></span>
									</div>
								</div>
							</li>
							<%
								}
																			} else {
							%>
							<li>There's no comments yet.</li>
							<%
								}
							%>

						</ul>
					</div>
				</div>
				<div id="itemDesc_Record"></div>
			</div>

			<div id="itemRecommand">
				<div style="margin: 10px 0 20px 0;">CUSTOMERS WHO VIEWED THIS
					PRODUCT ALSO VIEWED</div>
				<ul>
					<li><a href="#"><img
							src="<%=request.getContextPath()%>/images/detail/recommand1.jpg" /></a>
					</li>
					<li><a href="#"><img
							src="<%=request.getContextPath()%>/images/detail/recommand2.jpg" /></a>
					</li>
					<li><a href="#"><img
							src="<%=request.getContextPath()%>/images/detail/recommand3.jpg" /></a>
					</li>
					<li><a href="#"><img
							src="<%=request.getContextPath()%>/images/detail/recommand4.jpg" /></a>
					</li>
					<li><a href="#"><img
							src="<%=request.getContextPath()%>/images/detail/recommand5.jpg" /></a>
					</li>
				</ul>
			</div>
			<div class="modal fade" id="commentModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Make Comment</h4>
						</div>
						<div class="modal-body">
							<form id="commentForm" action="<%=request.getContextPath() %>/makeComment" method="post">
								<input type="hidden" name="psItemId" value="<%=psItem.getId()%>">
								<div>
									<label>Item Score(0~5)</label> <span>0<input
										type="radio" name="scoreItem" value="0"></span> <span>1<input
										type="radio" name="scoreItem" value="1"></span> <span>2<input
										type="radio" name="scoreItem" value="2"></span> <span>3<input
										type="radio" name="scoreItem" value="3"></span> <span>4<input
										type="radio" name="scoreItem" value="4"></span> <span>5<input
										type="radio" name="scoreItem" value="5" checked="checked"></span>
								</div>
								<div>
									<label>Shop Score(0~5)</label> <span>0<input
										type="radio" name="scoreShop" value="0"></span> <span>1<input
										type="radio" name="scoreShop" value="1"></span> <span>2<input
										type="radio" name="scoreShop" value="2"></span> <span>3<input
										type="radio" name="scoreShop" value="3"></span> <span>4<input
										type="radio" name="scoreShop" value="4"></span> <span>5<input
										type="radio" name="scoreShop" value="5" checked="checked"></span>
								</div>
								<label>Content</label>
								<textarea rows="10" cols="60" name="content"></textarea>
							</form>
							<div class="modal-footer">
								<button type="button" class="common_btn" id="payDoneModalBtn"
									data-dismiss="modal" onclick="document.getElementById('commentForm').submit();">Submit</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
			</div>
		</div>

	</div>

	<%@ include file="include/footer.jsp"%>

	<script src="<%=request.getContextPath()%>/js/jquery-1.10.2.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.js"
		type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/categorybar.js"
		type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/details.js"
		type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/common.js"
		type="text/javascript"></script>
</body>
<%
	} else {
%>
<body>ERROR!
</body>
<%
	}
%>
</html>