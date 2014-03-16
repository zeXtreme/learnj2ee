<%@page import="me.zwy.servlet.WebContent" isELIgnored="false"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>WEB监听和过滤</title>
  </head>
  
  <body>
    <%
    ServletContext sc = pageContext.getServletContext();
    sc.setAttribute("abc", "cba");
    sc.setAttribute("abc", "zxc");
     %>
    <p> 当前在线人数：<%=WebContent.count %></p>
     <a href="exit">销毁会话</a>
     <p>该页面被访问的次数：${count}</p>
  </body>
</html>
