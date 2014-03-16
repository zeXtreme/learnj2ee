<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript" src="dwz.min.js"></script>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type="text/css">
	<!--
	body {
		font-family:微软雅黑,新宋体,宋体,Arial;
	}
	#head p {
		font-size: xx-large;
		text-align: center;
	}
	table a {
		text-decoration:none;
	}
	-->
    </style>
</head>
  
  <body>
  	<div id="body">
		<div id="head">
			<p>MicroBlog登录</p>
		</div>
		<div id="login">
		<form action="login" method="post">
			<table align="center">
				<tr>
					<td align="right">用户名：</td>
					<td><input type="text" name="username"/></td>
				</tr>
				<tr>
					<td align="right">密码：</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="登录"/>&nbsp;<a href="regist.jsp">注册</a></td>
				</tr>
		  </table>
		</form>
		</div>
	</div>
  </body>
</html>
