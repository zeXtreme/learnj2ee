<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String id = request.getParameter("alter");
pageContext.setAttribute("id", id);
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
    
    <title>修改商品</title>
    
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
	<sql:query var="pro" dataSource="${zengDS}" sql="select * from product where pid=${id}"></sql:query>
    <form action="alterpro" method="post" enctype="multipart/form-data">
    <c:forEach var="row" items="${pro.rows}">
  <table width="800" border="0" cellpadding="0" cellspacing="0" align="center">
    <!--DWLayoutTable-->
    <tr>
      <td height="54" align="center">商品编号：</td>
      <td><input type="text" name="pid" value="${row.pid}"/></td>
    </tr>
	<tr>
      <td height="67" align="center">商品名称：</td>
      <td><input type="text" name="pname" value="${row.pname}"/></td>
    </tr>
	<tr>
      <td height="60" align="center">商品商标：</td>
      <td><input type="text" name="pbrand" value="${row.pbrand}"/></td>
    </tr>
	<tr>
      <td height="49" align="center">商品型号：</td>
      <td><input type="text" name="ptype" value="${row.ptype}"/></td>
    </tr>
	<tr>
      <td height="56" align="center">商品价格：</td>
      <td><input type="text" name="pprice" value="${row.pprice}"/></td>
    </tr>
	<tr>
      <td height="173" align="center">商品介绍：</td>
      <td><textarea name="pdesc" cols="50" rows="10">${row.pdesc}</textarea></td>
    </tr>
	<tr>
      <td height="59" align="center">商品图片：</td>
      <td><input type="file" name="pimage" /></td>
    </tr>
	<tr align="center">
      <td colspan="2"><input type="submit" value="提交"/><input type="hidden" name="id" value="${id}"/></td>
    </tr>
  </table>
  </c:forEach>
  </form>
  </body>
</html>
