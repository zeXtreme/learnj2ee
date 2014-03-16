<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.web.util.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String id = request.getParameter("alter");
String title = null;
String content = null;
Connection conn = DBConnection.getConnection();
Statement st = conn.createStatement();
ResultSet rs = st.executeQuery("select * from news where id="+id);
if(rs.next()){
	title = rs.getString("title");
	content = rs.getString("content");
}
pageContext.setAttribute("id", id);
pageContext.setAttribute("title", title);
pageContext.setAttribute("content", content);
 %>
 <%
String username = (String)session.getAttribute("user");
if(username==null){
	response.sendRedirect("login.jsp");
}
 %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改新闻</title>
    
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
  <center><h1>修改新闻</h1></center>
    <form action="alternews" method="post">
    	<table align="center" width="800" height="379">
    		<tr>
    			<th height="45">标题：</th>
    			<td><input type="text" name="title" value="${title}"/></td>
    		</tr>
    		<tr>
    			<th height="211">正文：</th>
    			<td><textarea name="content" cols="80" rows="20">${content}</textarea></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center"><input type="submit" value="提交"/></td>
    		</tr>
   	  </table>
   	  <input type="hidden" name="id" value="${id}"/>
    </form>
  </body>
</html>
