<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.newer.com.cn" prefix="n"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>自定义标签</title>
  </head>
  
  <body>
  	<center><font size="7"><n:hi/></font></center>
  	<hr>
  	<n:fmtdate format="yyyy-MM-dd HH:mm:ss"/>
  </body>
</html>
