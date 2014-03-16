<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理文章</title>

  </head>
  
  <body>
  <table width="600" border="0" cellpadding="0" cellspacing="0" align="center">
    <!--DWLayoutTable-->
    <tr>
      <th width="132" height="30" valign="middle" align="center">时间</th>
      <th width="330" valign="middle" align="center">文章标题</th>
      <th width="69" valign="middle" align="center">修改</th>
      <th width="69" valign="middle" align="center">删除</th>
    </tr>
    <sql:setDataSource
    		var="myDS"
    		url="jdbc:oracle:thin:@localhost:1521:zeng"
    		driver="oracle.jdbc.OracleDriver"
	    	user="scott"
	    	password="tiger"
	    	/>
	    <sql:query var="mypost" dataSource="${myDS}" sql="select * from nb_post where author_id=${user.id}"></sql:query>
	    <c:forEach var="mypostrow" items="${mypost.rows}">
	<tr>
      <td height="30" align="center"><fmt:formatDate value="${mypostrow.postdate}" pattern="yyyy年MM月dd日  HH点mm分"/></td>
	  <td align="center">${mypostrow.title}</td>
	  <td align="center"><a href="admin/editPost.jsp?pid=${mypostrow.id}">修改</a></td>
	  <td align="center"><a href="deletePost?pid=${mypostrow.id}">删除</a></td>
    </tr>
	    </c:forEach>
  </table>
  </body>
</html>
