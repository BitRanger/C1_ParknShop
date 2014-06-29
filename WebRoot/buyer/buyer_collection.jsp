<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 5/31/2014
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>


<%@page import="com.bitranger.parknshop.buyer.controller.Utility"%>
<%@page import="java.util.List"%>
<%@page
	import="com.bitranger.parknshop.buyer.model.CustomerFavouriteItem"%>
<%
	List<CustomerFavouriteItem> psFavourites = (List<CustomerFavouriteItem>) request
			.getAttribute("psFavourites");
	int collection_rows = psFavourites.size() / 3;
	int collection_remain = psFavourites.size() % 3;
%>

<%
	for (int i = 0; i < collection_rows; i++) {
%>
<div class="collectionItemRow">
	<%
		for (int j = 0; j < 3; j++) {
				CustomerFavouriteItem favouriteItem = psFavourites.get(i
						* 3 + j);
	%>
	<div class="collectionItem">
		<a
			href="<%=request.getContextPath()%>/item/<%=favouriteItem.getPsItem().getId()%>"><img
			width="180px" height="180px" src="<%=favouriteItem.getPsItem().getUrlPicture()%>"
			alt="..."></a>
		<div class="collectionItemDesc">
			<h5>
				<a class="collectionItemLink" href="#"><%=Utility.slice(favouriteItem.getPsItem().getName(),30)%></a>
			</h5>
			<p>
				Price: $<%=favouriteItem.getPsItem().getPrice()%></p>
		</div>
	</div>
	<%
		}
	%>
</div>
<%
	}
%>
<div class="collectionItemRow">
	<%
		for (int j = 0; j < collection_remain; j++) {
			CustomerFavouriteItem favouriteItem = psFavourites
					.get(collection_rows * 3 + j);
	%>
	<div class="collectionItem">
		<a
			href="<%=request.getContextPath()%>/item/<%=favouriteItem.getPsItem().getId()%>"><img
			width="180px" height="180px" src="<%=favouriteItem.getPsItem().getUrlPicture()%>"
			alt="..."></a>
		<div class="collectionItemDesc">
			<h5>
				<a class="collectionItemLink" href="#"><%=Utility.slice(favouriteItem.getPsItem().getName(),30)%></a>
			</h5>
			<p>
				Price: $<%=favouriteItem.getPsItem().getPrice()%></p>
		</div>
	</div>
	<%
		}
	%>
</div>