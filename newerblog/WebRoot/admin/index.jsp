<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台</title>

  </head>
  <body>
  <table cellpadding="0" cellspacing="0" width="800" border="1" align="center" height="600">
    <!--DWLayoutTable-->
  <tr>
    <td height="192" colspan="2" style="padding-left:40px"><h2><font color="#FF0000">后台</font></h2></td>
  </tr>
  <tr>
    <td width="146" height="406" valign="top">
	  <ul style="list-style-type:none; padding-top:40px">
		<li><a href="admin/mngrPost.jsp" target="right">管理文章</a></li>
		<li><a href="admin/addPost.jsp" target="right">添加文章</a></li>
		<li><a href="userPage.jsp">返回博客</a></li>
	  </ul></td>
    <td width="648" valign="top"><iframe name="right" src="admin/mngrPost.jsp" frameborder="0" width="100%" height="100%"></td>
  </tr>
</table>
</body>
</html>
