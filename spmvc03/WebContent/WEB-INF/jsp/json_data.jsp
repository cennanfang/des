<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
var XMLHttpReq = false;
//创建XMLHttpRequest对象       
function createXMLHttpRequest() {
  if(window.XMLHttpRequest) { //Mozilla 浏览器
      XMLHttpReq = new XMLHttpRequest();
  }
  else if (window.ActiveXObject) { // IE浏览器
      try {
          XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
      } catch (e) {
          try {
              XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
          } catch (e) {}
      }
  }
}
//发送请求函数
function sendRequest(url) {
  createXMLHttpRequest();
  XMLHttpReq.open("GET", url, true);
  XMLHttpReq.onreadystatechange = processResponse;//指定响应函数
  XMLHttpReq.send(null);  // 发送请求
}
//处理返回信息函数
function processResponse() {
  if (XMLHttpReq.readyState == 4) { // 判断对象状态
      if (XMLHttpReq.status == 200) { // 信息已经成功返回，开始处理信息
          var result = XMLHttpReq.responseText;    
          document.getElementById("data").innerHTML = result;  
          setTimeout("test()", 2000);    
      } else { //页面不正常
          window.alert("您所请求的页面有异常。");
      }
  }
}

</script>
</head>
<body>
out jsp
</body>
</html>