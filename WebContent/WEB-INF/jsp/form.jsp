<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
	<style>
		#wrap {
			width: 500px;
			margin: 300px auto;
		}
	</style>	
</head>
<body>
	<div id="wrap">
		<form method="post" action="save.kosta">
			SUB: <input type="text" id="sub" name="sub" /> <br />
			WRITER: <input type="text" id="writer" name="writer" /> <br />
			CONTENT: <textarea rows="10" cols="15" name="conetent" id="content"></textarea> <br />
			PASSWORD: <input type="password" name="pwd" maxlength="10" /> <br />
			<input type="submit" value="send">
		</form>
	</div>
</body>
</html>