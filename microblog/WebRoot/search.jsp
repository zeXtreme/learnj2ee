<%@page import="me.zwy.vo.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
User user = (User)session.getAttribute("user");
if(user==null){
	response.sendRedirect("login.jsp");
	return;
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>搜索用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    <style type="text/css">
	<!--
	body {
		font-family:"微软雅黑", "新宋体", "宋体", Arial;
	}
	div {
		overflow:auto;
		border:1px solid #000000;
	}
	#body #head #logo {
		height:100px;
		margin:30px;
		margin-bottom:0px;
	}
	#body #head #logo a {
		text-decoration:none;
	}
	#body {
		margin:0px auto;
		width: 960px;
	}
	#body #main div {
		float: left;
		margin:0px 8px;
	}
	#body #main #center {
		width: 600px;
		padding: 0px;
	}
	#body #main #left {
		width: 150px;
	}
	#body #main #left td {
		text-align:center;
	}
	#body #main #right {
		width: 150px;
	}
	#body #main #right table {
		text-align:center;
	}
	#body #main #center p {
		margin:20px;
	}
	#body #main #center li {
		margin:10px;
	}
	-->
    </style>
</head>
  
  <body>
    <div id="body">
		<div id="head">
			<div id="logo">
				<h1><a href="index.jsp">MicroBlog</a></h1>
			</div>
		</div>
		<div id="main">
			<div id="left">
				<table align="center" width="150px">
					<tr>
						<td colspan="2">欢迎您</td>
					</tr>
					<tr>
						<td colspan="2">${user.userName}</td>
					</tr>
					<tr>
						<td>关注</td><td>粉丝</td>
					</tr>
					<tr>
						<td><a href="user.jsp?follow=1"><%=user.getFollows().size() %></a></td>
						<td><a href="user.jsp?fans=1"><%=user.getFans().size() %></a></td>
					</tr>
					<tr>
						<td colspan="2"><a href="changepwd.jsp">修改密码</a></td>
					</tr>
					<tr>
						<td colspan="2"><a href="mypost.jsp">管理发表过的内容</a></td>
					</tr>
					<tr>
						<td colspan="2"><a href="exit">退出登录</a></td>
					</tr>
				</table>
			</div>
			<div id="center">
				<p>搜索结果：</p>
				<c:forEach items="${users}" var="u">
				<ul>
					<li><a href="userinfo.jsp?userid=${u.userId}">${u.userName}</a>&nbsp;<a href="follow?userid=${u.userId}">关注此用户</a></li>
				</ul>
				</c:forEach>
			</div>
			<div id="right">
				<form action="search" method="post">
					<table>
						<tr>
							<td>找人</td>
						</tr>
						<tr>
							<td><input name="user" type="text" size="10"/><input type="submit" value="搜索"/></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
  </body>
</html>
