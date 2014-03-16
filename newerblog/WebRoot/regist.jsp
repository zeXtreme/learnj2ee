<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="regist" method="post">
  <table width="800" align="center">
  <caption><h1>用户注册</h1></caption>
  	<tr>
	<td align="right" width="50%">用户名：</td>
	<td><input type="text" name="userName"></td>
	</tr>
	<tr>
	<td align="right" width="50%">密码：</td>
	<td><input type="password" name="passWord"></td>
	</tr>
	<tr>
	<td align="right" width="50%">确认密码：</td>
	<td><input type="password" name="rePassWord"></td>
	</tr>
	<tr>
	<td colspan="2" align="center"><input type="submit" value="提交"></td>
	</tr>
  </table>
  </form>
  <center><a href="index.jsp">返回首页</a></center>
  </body>
  
</html>
