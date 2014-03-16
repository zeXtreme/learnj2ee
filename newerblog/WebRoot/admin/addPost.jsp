<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加文章</title>

  </head>
  
  <body>
   <form action="addpost" method="post">
   	<table width="600" align="center">
		<tr>
			<th width="100" height="30">文章标题：</th><td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>文章内容：</th><td><textarea name="context" cols="60" rows="20"></textarea></td>
		</tr>
		<tr>
			<td height="30" align="center" colspan="2"><input type="submit" value="添加"></td>
		</tr>
	</table>
   </form>
  </body>
</html>
