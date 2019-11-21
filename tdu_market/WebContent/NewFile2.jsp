<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Failed
	<hr />
	<%
		String userAgent = request.getHeader("user-agent");
		out.println(userAgent);
	%>
	<hr />
	私のブラウザ情報:
	<%=userAgent%>
</body>
</html>