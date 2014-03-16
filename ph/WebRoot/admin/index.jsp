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
    
    <title>后台</title>
    
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
  <table width="100%" height="100%" border="1" cellpadding="0" cellspacing="0">
    <!--DWLayoutTable-->
    <tr height="20%">
      <td height="93" colspan="2" align="center"><h1>品红网站管理系统</h1></td>
    </tr>
    <tr>
      <td width="20%" height="468" valign="top">
      欢迎您，${user}
	  <ul style="margin:20px auto; list-style-type:none">
	  <li style="padding-bottom:10px;"><a href="admin/addnews.jsp" target="main">添加新闻</a></li>
	  <li style="padding-bottom:10px;"><a href="admin/managenews.jsp" target="main">管理新闻</a></li>
	  <li style="padding-bottom:10px;"><a href="admin/addproduct.jsp" target="main">添加商品</a></li>
	  <li style="padding-bottom:10px;"><a href="admin/managepro.jsp" target="main">管理商品</a></li>
	  <li style="padding-bottom:10px;"><a href="login?exit=1">退出登录</a></li>
	  </ul></td>
      <td width="80%" valign="top"><iframe src="admin/welcome.jsp" frameborder="0" name="main" width="100%" height="100%"><!--DWLayoutEmptyCell--></td>
    </tr>
  </table>
  </body>
</html>
