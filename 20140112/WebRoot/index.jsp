<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 服务器端注释，不会发送给客户端   --%>
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
  
  <body>
    <%
    	boolean isLogin = false;
    	String user = request.getParameter("user");
    	String pwd = request.getParameter("pwd");
    	if(user != null){
    		if(user.equals("admin") && pwd.equals("root")){
    			isLogin = true;
    		}
    	}
    	if(isLogin){
    %>
    	<p>欢迎您，<%=user %><a href="index.jsp">，点击退出</a>
    <%
    	}else{
    %>
    	<form action="index.jsp">
    		<table>
    			<tr>
    				<td>用户名：</td><td><input name="user"></td>
    			</tr>
    			<tr>
    				<td>密码：</td><td><input name="pwd" type="password"></td>
    			</tr>
    			<tr>
    			<td colspan="2" align="center"><input type="submit" value="登录"></td>
    			</tr>
    		</table>
    	</form>
    <%
    	}
    %>
  </body>
</html>
