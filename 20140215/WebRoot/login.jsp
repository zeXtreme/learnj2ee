<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  
  <body>
  <form action="login" method="post">
    <h1>登陆页面</h1>
    <p>请输入用户名：<br><input type="text" name="user"/><input type="submit" value="登录"/>
  </form>
  </body>
</html>
