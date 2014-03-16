<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.web.util.DBConnection"%>
<%@page import="oracle.net.aso.b"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String pages = request.getParameter("page");
if(pages==null||Integer.parseInt(pages)<1){
	pages = "1";
}
pageContext.setAttribute("pages", Integer.parseInt(pages));
 %>
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
    
    <title>管理新闻</title>
    
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
  	<table width="800" align="center" style="margin:20px auto;">
  	  <!--DWLayoutTable-->
  		<tr style="padding-bottom:10px"><th width="477" height="30" valign="top" style="padding-bottom:10px">新闻标题</th>
	    <th width="90" valign="top"><!--DWLayoutEmptyCell-->&nbsp;</th>
  		<th width="76" valign="top"><!--DWLayoutEmptyCell-->&nbsp;</th>
  		</tr>
  		<sql:setDataSource
			  	var="zengDS"
			  	driver="oracle.jdbc.OracleDriver"
			  	url="jdbc:oracle:thin:@localhost:1521:zeng"
			  	user="scott"
			  	password="tiger"
			  	/>
  		<sql:query var="countnews" dataSource="jdbc/zeng" sql="select * from news"></sql:query>
  			<c:set var="count" value="${countnews.rowCount}"></c:set>
  			<c:set var="maxpage" value="${count%10==0?count/10:(count-(count%10))/10+1}"></c:set>
  			<sql:query var="n" dataSource="${zengDS}" sql="select * from news order by ndate desc" maxRows="10" startRow="${0+10*(pages-1)}"></sql:query>
  			<c:forEach var="new" items="${n.rows}">
  			<tr><td style='padding-bottom:10px'><b>${new.title}</b></td><td style='padding-bottom:10px'><a href='managenews?delete=${new.id}'>删除</a></td><td style='padding-bottom:10px'><a href='managenews?alter=${new.id}'>修改</a></td></tr>
  			</c:forEach>
  			<tr>
  			<td colspan="3">
  			<c:choose>
			  <c:when test="${maxpage==1}">
  		</c:when>
  		<c:when test="${pages==1}">
  			上一页<a href="admin/managenews.jsp?page=${pages+1}">下一页</a>
  		</c:when>
  		<c:when test="${pages==maxpage}">
  			<a href="admin/managenews.jsp?page=${pages-1}">上一页</a>下一页
  		</c:when>
  		<c:otherwise>
  			<a href="admin/managenews.jsp?page=${pages-1}">上一页</a><a href="admin/managenews.jsp?page=${pages+1}">下一页</a>
  		</c:otherwise>
  		</c:choose>
  		</td>
  		</tr>
     </table>
  </body>
</html>
