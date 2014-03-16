<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>添加商品</title>
    
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
  <form action="addproduct" method="post" enctype="multipart/form-data">
  <table width="800" border="0" cellpadding="0" cellspacing="0" align="center">
    <!--DWLayoutTable-->
    <tr>
      <td height="54" align="center">商品编号：</td>
      <td><input type="text" name="pid"/></td>
    </tr>
	<tr>
      <td height="67" align="center">商品名称：</td>
      <td><input type="text" name="pname"/></td>
    </tr>
	<tr>
      <td height="60" align="center">商品商标：</td>
      <td><input type="text" name="pbrand"/></td>
    </tr>
	<tr>
      <td height="49" align="center">商品型号：</td>
      <td><input type="text" name="ptype"/></td>
    </tr>
	<tr>
      <td height="56" align="center">商品价格：</td>
      <td><input type="text" name="pprice"/></td>
    </tr>
	<tr>
      <td height="173" align="center">商品介绍：</td>
      <td><textarea name="pdesc" cols="50" rows="10"></textarea></td>
    </tr>
	<tr>
      <td height="59" align="center">商品图片：</td>
      <td><input type="file" name="pimage"/></td>
    </tr>
	<tr align="center">
      <td colspan="2"><input type="submit" value="提交"/></td>
    </tr>
  </table>
  </form>
  </body>
</html>
