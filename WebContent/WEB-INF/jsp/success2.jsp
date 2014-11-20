<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	${imgName}<a href="upform.kosta">입력해보기</a>
	<img src="<%= application.getContextPath() %>/img/${imgName}"><br/>
	<img src="${pageContext.request.contextPath }/img/${imgName}">
</body>
</html>