<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Online Store</title>
  <meta charset="utf-8">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<%@ include file="include/header.jsp" %>


<div id="categorybarDiv">
    <%@ include file="include/categorybar.jsp" %>
</div>
<div id="mainContent">
<div id="storeItemList">

<c:choose>
	<c:when test="${item_count eq 0 }">
		泥煤的！！！
	</c:when>
	<c:otherwise>
		<c:forEach begin="0" end="${(item_count - 1) /5 }" varStatus="s">
			<div class="storeItemListRow">
    			<div class="storeItemListRowTitle">
       				 <h1>Fashion
          				  <small>Some of new products in this month</small>
       				 </h1>
   				</div>
				
				<c:forEach begin="${s.index * 5 }" end="${s.index * 5 + 4 > item_count - 1 ? item_count - 1 : s.index * 5 + 4 }" varStatus="vs">
					<div class="storeItem">
       					<a href="item?id=${product_item_list[vs.index].id}"><img width="180px" src="images/lunbo.jpg" alt="..."></a>
        				<div class="caption">
        				    <a href="detail.jsp">
                				<h7>
                		  			${product_item_list[vs.index].name}
               					</h7>
            				</a>
          					<h5><b>${product_item_list[vs.index].introduction}</b> </h5>
            				<p>Price: ${product_item_list[vs.index].price }</p>
            				<p>Vote: ${product_item_list[vs.index].vote}</p>
        				</div>
    				</div>
				</c:forEach>	
			</div>	
		</c:forEach>
	</c:otherwise>	
</c:choose>

</div>
</div>
</div>



<%@ include file="include/footer.jsp" %>

<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/index.js" type="text/javascript"></script>
</body>
</html>