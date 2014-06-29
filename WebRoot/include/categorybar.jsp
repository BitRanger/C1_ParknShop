<%@page import="java.util.List"%>
<%@page import="com.bitranger.parknshop.common.model.PsCategory"%>
<div id="categorybarWrapper">
	<div id="categorybar">
		<ul id="categorybarList">
			<%
				List<PsCategory> psCategories_bar = (List<PsCategory>) session
						.getAttribute("psCategories");
				if(psCategories_bar != null && psCategories_bar.size() > 0)
				for (PsCategory psCategory : psCategories_bar) {
			%>
			<li id="<%=psCategory.getId()%>" class="categorybarListItem"><a
				class="categorybarListItemLink"
<<<<<<< HEAD
				href="<%=request.getContextPath()%>/itemlist?category_id=<%=psCategory.getId()%>"><span><%=psCategory.getName().split("&")[0]%></span></a>
=======
				href="<%=request.getContextPath()%>/category/<%=psCategory.getId()%>"><span><%=psCategory.getName().split("&")[0]%></span></a>
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
				<div id="sub_<%=psCategory.getId()%>" class="submenu">
					<ul class="submenuPanel">
						<li class="submenuItem submenuItemTitle"><a href="#"
							class="submenuItemLink submenuItemTitleLink">Mass Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem submenuItemTitle"><a href="#"
							class="submenuItemLink submenuItemTitleLink">Mass Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
					</ul>
					<ul class="submenuPanel">
						<li class="submenuItem submenuItemTitle"><a href="#"
							class="submenuItemLink submenuItemTitleLink">Mass Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
					</ul>
					<ul class="submenuPanel">
						<li class="submenuItem submenuItemTitle"><a href="#"
							class="submenuItemLink submenuItemTitleLink">Mass Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
					</ul>
					<ul class="submenuPanel">
						<li class="submenuItem submenuItemTitle"><a href="#"
							class="submenuItemLink submenuItemTitleLink">Mass Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
					</ul>
					<ul class="submenuPanel">
						<li class="submenuItem submenuItemTitle"><a href="#"
							class="submenuItemLink submenuItemTitleLink">Mass Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
						<li class="submenuItem"><a href="#" class="submenuItemLink">Mass
								Effect 3</a></li>
					</ul>
				</div></li>
			<%
				}
			%>
		</ul>
	</div>
</div>