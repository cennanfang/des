<%@page import="com.redbird.pojo.Person"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
Person p = (Person)request.getAttribute("p");
Person p1 = (Person)request.getAttribute("p1");
%>
<form>
 <input type="text" value="<%=p.getName()%>"/>
 <input type="text" value="<%=p.getAge()%>"/>
 <br/>
 <input type="text" value="<%=p1.getName()%>"/>
 <input type="text" value="<%=p1.getAge()%>"/>
</form>
</body>
</html>