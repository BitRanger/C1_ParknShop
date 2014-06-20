<%@page import="java.util.List"%>
<%@page import="com.bitranger.parknshop.common.model.PsCategory"%>
<div id="categorybarWrapper">
	<div id="categorybar">
		<ul id="categorybarList">
			<%
				List<PsCategory> psCategories_bar = (List<PsCategory>) session
						.getAttribute("psCategories");
				for (PsCategory psCategory : psCategories_bar) {
			%>
			<li id="<%=psCategory.getId()%>" class="categorybarListItem"><a
				class="categorybarListItemLink"
				href="<%=request.getContextPath()%>/category/<%=psCategory.getId()%>"><span><%=psCategory.getName().split("&")[0]%></span></a>
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