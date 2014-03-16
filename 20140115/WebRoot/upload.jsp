<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文件的上传与下载</title>
    
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
    <center><h1>文件的上传与下载</h1></center>
    <form action="upload" method="post" enctype="multipart/form-data">
    	<table align="center">
    		<tr><td>图片描述</td><td><input type="text" name="desc"/></td></tr>
    		<tr><td colspan="2"><input type="file" name="file"/></td></tr>
    		<tr><td colspan="2" align="center"><input type="submit" value="上传"/></td></tr>
    	</table>
    </form>
  </body>
</html>
