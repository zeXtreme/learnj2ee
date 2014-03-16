<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>星期天的学习计划</title>
    

  </head>
  
  <body>
    <center><h1>星期天的学习计划</h1></center><br>
    <p>（上午）<a href="sunday.jsp?info=1">7:00~8:00</a><br>
    （下午）<a href="sunday.jsp?info=2">2:00~4:00</a></p><br>
    <%
    	if(request.getParameter("info") == null){
     %>
    <center>俗话说：<b>莫等闲，白了少年头</b></center>
    <%
    	}else if(request.getParameter("info").equals("1")){
     %>
    <center><b>该起床了</b></center>
    <%
    	}else if(request.getParameter("info").equals("2")){
     %>
    <center><b>该学习了</b></center>
    <%
    	}
     %>
  </body>
</html>
