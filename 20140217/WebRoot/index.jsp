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
    <title>MVC</title>
  </head>
  
  <body>
  	<table border="1" align="center">
    <c:forEach var="emp" items="${pager.list}">
    	<tr>
    		<td>${emp.empno}</td><td>${emp.ename}</td><td>${emp.job}</td>
    	</tr>
    </c:forEach>
    	<tr>
    		<td colspan="3" align="center">总共${pager.total}页</td>
    	</tr>
  	</table>
  </body>
</html>
