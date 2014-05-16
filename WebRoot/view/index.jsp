<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <a href="
	<c:url value="/test">
		<c:param name="category" value="1" />
		<c:param name="tag" value="2" />
		<c:param name="tag" value="3" />
		<c:param name="max_price" value="99" />
		<c:param name="min_price" value="9" />
		<c:param name="sort" value="asd" />
		<c:param name="page" value="2" />
	</c:url>
	">
	XXX
	</a>
	<c:forEach var="item_list" item="ff">
		${ff.id}
	</c:forEach>
</body>
</html>
