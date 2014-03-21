<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
	<style type="text/css">
		body {font-family: 微软雅黑, 宋体 , Arial}
	</style>
  </head>
  
  <body>
  <form action="login.do" method="post">
    <table align="center" border="1">
    <caption><font size="6">用户登录</font></caption>
    	<tr>
    		<td>用户名：</td><td><input type="text" name="user"/></td>
    	</tr>
    	<tr>
    		<td>密码：</td><td><input type="password" name="pwd"/></td>
    	</tr>
    	<tr>
    		<td colspan="2" align="center"><input type="submit" value="登录"/><input type="reset" value="重置"/></td>
    	</tr>
    </table>
  </form>
  </body>
</html>
