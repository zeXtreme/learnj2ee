<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String pid = request.getParameter("pid");
pageContext.setAttribute("pid", pid);
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改文章</title>
    

  </head>
  
  <body>
    <form action="editpost" method="post">
   	<table width="600" align="center">
   			<sql:setDataSource
    		var="myDS"
    		url="jdbc:oracle:thin:@localhost:1521:zeng"
    		driver="oracle.jdbc.OracleDriver"
	    	user="scott"
	    	password="tiger"
	    	/>
	    	<sql:query var="post" dataSource="${myDS}" sql="select * from nb_post where id=${pid}"></sql:query>
	    	<c:forEach var="postrow" items="${post.rows}">
		<tr>
			<th width="100" height="30">文章标题：</th><td><input type="text" name="title" value="${postrow.title}"></td>
		</tr>
		<tr>
			<th>文章内容：</th><td><textarea name="context" cols="60" rows="20">${postrow.context}</textarea></td>
		</tr>
		<tr>
			<td height="30" align="center" colspan="2"><input type="submit" value="修改"><input type="hidden" name="pid" value="${pid}"></td>
		</tr>
	    	</c:forEach>
	</table>
   </form>
  </body>
</html>
