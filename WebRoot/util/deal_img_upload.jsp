<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,com.jspsmart.upload.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	SmartUpload su = new SmartUpload();
	su.initialize(pageContext);
	su.setAllowedFilesList("jpg,png,gif");
	su.upload();
	int count = su.save("C:\\upload");
	out.println("<div>" + count + " kkkfiles are: " + "</div>");
%>
</body>
</html>