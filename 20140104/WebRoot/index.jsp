<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function change(obj){
			obj.src="image.do?"+Math.random();
		}
	</script>
  </head>
  
  <body>
    <img alt="验证码" src="image.do" onclick="change(this)" style="cursor:hand;"><br>
    <a href="readtxt.do">readtxt</a><br>
    <a href="client.html">clientinfo</a><br>
    <a href="test">UA</a><br>
    <a href="flippage.do">分页</a>
  </body>
</html>
