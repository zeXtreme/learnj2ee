<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
    
    <title>管理商品</title>
    
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
	<sql:query var="pros" dataSource="${zengDS}" sql="select * from product"></sql:query>
  <table width="800" border="0" cellpadding="0" cellspacing="0" align="center">
    <!--DWLayoutTable-->
    <tr>
      <th>商品编号</th><th>商品名称</th><th>商品商标</th><th>商品型号</th><th>商品价格</th><th>修改</th><th>删除</th>
    </tr>
    <c:forEach var="row" items="${pros.rows}">
	<tr align="center">
		<td>${row.pid}</td>
		<td>${row.pname}</td>
		<td>${row.pbrand}</td>
		<td>${row.ptype}</td>
		<td>${row.pprice}</td>
		<td><a href="managepro?alter=${row.pid}">修改</a></td>
		<td><a href="managepro?delete=${row.pid}">删除</a></td>
	</tr>
	</c:forEach>
  </table>
  </body>
</html>
