<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>user login</h1>
	<form action="doLogin" method="post">
		username:<input type="text" name="userName">
		<p>
			password:<input type="password" name="password">
		<p>
			${msg } 
			<input type="submit" value="submit">
	</form>
</body>
</html>