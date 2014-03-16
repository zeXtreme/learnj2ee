<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>购物车</title>
  </head>
  
  <body>
    <center><h1>购物页面</h1></center><br>
    <form action="shop.do" method="post">
    	<table border="1" align="center" width="400">
    		<tr>
    			<td><input type="checkbox" name="product" value="1" /><td>火车票</td>
    		</tr>
    		<tr>
    			<td><input type="checkbox" name="product" value="2" /><td>汽车票</td>
    		</tr>
    		<tr>
    			<td><input type="checkbox" name="product" value="3" /><td>飞机票</td>
    		</tr>
    		<tr>
    			<td><input type="checkbox" name="product" value="4" /><td>电影票</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
