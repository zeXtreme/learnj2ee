<%@page import="me.zwy.web.WebContent"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    <p>用户${user}已经登录，欢迎您！<a href="exit">退出</a>
    <p>当前在线人数：<%=WebContent.userCount %>
    <p>在线用户列表：
    <table border="1">
    	<tr>
    		<th>用户名</th>
    	</tr>
    	<c:forEach var="userName" items="<%=WebContent.userList %>" >
    	<tr>
    		<td>${userName}</td>
    	</tr>
    	</c:forEach>
    </table>
  </body>
</html>
