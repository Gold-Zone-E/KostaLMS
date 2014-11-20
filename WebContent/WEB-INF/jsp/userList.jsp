<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>Insert title here</title>
<!-- jQuery javascript -->
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- Bootstrap3 css -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0-wip/css/bootstrap.min.css">
<!-- Bootstrap3 javascript -->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0-wip/js/bootstrap.min.js"></script>
</head>
<body>
	<table border="1">
		<tr>
			<td class="heading">No.</td>
			<td class="heading">제목</td>
			<td class="heading">이미지</td>
			<td class="heading">작성자</td>
			<td class="heading">수정</td>
			<td class="heading">삭제</td>
		</tr>
		<c:forEach var="item" items="${userList}">
			<tr>
				<td>${item.num}</td>
				<td>${item.sub}</td>
				<td>${item.wfile}</td>
				<td>${item.writer}</td>
				<td><a href="edit?id=${item.num}">수정</a></td>
				<td><a href="delete?id=${item.num}">삭제</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7"><a href="register">글쓰기</a></td>
		</tr>
	</table>
</body>
</html>