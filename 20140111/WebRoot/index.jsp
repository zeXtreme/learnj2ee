<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <%
  	if(session.getAttribute("user")==null){
  	  	Cookie[] cookies = request.getCookies();
  	  	if(cookies != null){
  	  		for(Cookie c : cookies){
  	  			String name = c.getName();
  	  			String pwd = c.getValue();
  	  			if(new com.web.util.LoginDaoImpl().isLogin(name, pwd)){
  	  				session.setAttribute("user", name);
  	  			}
  	  		}
  	  	}
    	}
  %>
  <body>
    欢迎您：<%=session.getAttribute("user") %>！<br>
  </body>
</html>
