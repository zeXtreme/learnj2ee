<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
List<String> pros = (ArrayList<String>)session.getAttribute("pros");
if(pros==null){
	pros = new ArrayList<String>();
}
String id = request.getParameter("add");
if(id!=null){
	pros.add(id);
}else{
	String pid = request.getParameter("delete");
	pros.remove(pid);
}
session.setAttribute("pros", pros);
 %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车</title>
    
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
  <sql:setDataSource
			  	var="zengDS"
			  	driver="oracle.jdbc.OracleDriver"
			  	url="jdbc:oracle:thin:@localhost:1521:zeng"
			  	user="scott"
			  	password="tiger"
			  	/>
    <center><ul style="list-style-type: none;">
    	<c:forEach var="pro" items="${pros}">
    	<sql:query var="p" dataSource="${zengDS}" sql="select * from product where pid=${pro}"></sql:query>
    	<c:forEach var="row" items="${p.rows}">
    	<li>${row.pname}&nbsp;<a href="shopcart.jsp?delete=${row.pid}">删除</a></li>
    	</c:forEach>
    	</c:forEach>
    </ul>
    <a href="product.jsp">继续购物</a>
    </center>
  </body>
</html>
