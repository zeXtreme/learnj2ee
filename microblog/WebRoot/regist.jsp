<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    <style type="text/css">
		<!--
		body {
			font-family: "微软雅黑", "新宋体", "宋体", Arial;
		}
#body #head {
	font-size: xx-large;
	text-align: center;
}
#body #foot {
	text-align: center;
	text-decoration: none;
}
		-->
    </style>
</head>
  
  <body>
  	<div id="body">
  	<div id="head">
		<p>用户注册</p>
	</div>
    <div id="regist">
		<form action="regist" method="post">
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
					<td align="right">确认密码：</td>
					<td><input type="password" name="retype"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="注册"/></td>
				</tr>
		  </table>
		</form>
	</div>
	<div id="foot">
		<a href="login.jsp">返回首页</a>
	</div>
	</div>
  </body>
</html>
