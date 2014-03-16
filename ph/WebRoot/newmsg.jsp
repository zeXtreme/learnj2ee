<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新留言</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body background="images/bookbg.gif">
  <table width="750" border="0" cellpadding="0" cellspacing="0" align="center">
    <!--DWLayoutTable-->
    <tr>
      <td width="750" height="135" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
        <tr>
          <td width="81" height="135" valign="top"><img src="images/welcome.jpg" width="750" height="135"></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="23">&nbsp;</td>
    </tr>
    <tr>
      <td height="25" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="images/titlemu_2.gif">
        <!--DWLayoutTable-->
        <tr>
          <td width="750" height="25" valign="middle" align="center">新留言</td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="397" valign="top"><form action="newmsg" method="post"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
        <tr>
          <td height="56" align="right">姓名：</td>
          <td><input type="text" name="name"/><font color="#FF0000">*</font></td>
        </tr>
		<tr>
          <td height="57" align="right">标题：</td>
          <td><input type="text" name="title"/></td>
        </tr>
		<tr>
          <td height="185" align="right">内容：</td>
          <td><textarea cols="50" rows="10" name="context"></textarea></td>
		 </tr>
		 <tr>
		  <td colspan="2" align="center"><input type="submit" value="提交" /></td>
        </tr>
      </table></form>
      </td>
    </tr>
  </table>
  </body>
</html>
