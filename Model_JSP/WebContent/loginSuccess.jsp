<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
		String name = request.getParameter("name1");
	
	%>
로그인 성공!
<%=name %>님 환영합니다.
</body>
</html>