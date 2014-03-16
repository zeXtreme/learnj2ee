<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String username = (String)session.getAttribute("user");
if(username==null){
	response.sendRedirect("login.jsp");
}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加新闻</title>
    
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
  	<center><h1>添加新闻</h1></center>
    <form action="addnews" method="post">
    	<table align="center" width="800" height="600">
    		<tr>
    			<th width="50%" height="45">标题：</th>
    			<td><input type="text" name="title"/></td>
    		</tr>
    		<tr>
    			<th height="211">正文：</th>
    			<td><textarea name="content" cols="80" rows="20"></textarea></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center"><input type="submit" value="提交"/></td>
    		</tr>
   	  </table>
    </form>
  </body>
</html>
