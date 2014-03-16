<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String id = request.getParameter("msg");
pageContext.setAttribute("id", id);
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>回复留言</title>
    
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
  <sql:setDataSource
			  	var="zengDS"
			  	driver="oracle.jdbc.OracleDriver"
			  	url="jdbc:oracle:thin:@localhost:1521:zeng"
			  	user="scott"
			  	password="tiger"
			  	/>
	<sql:query var="msg" dataSource="${zengDS}" sql="select * from msgbook where id=${id}"></sql:query>
	<sql:query var="remsg" dataSource="${zengDS}" sql="select * from revertmsg where msgid=${id}"></sql:query>
  <table width="750" border="0" cellpadding="0" cellspacing="0" align="center">
    <!--DWLayoutTable-->
    <tr>
      <td width="750" height="135" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
        <tr>
          <td width="82" height="135" valign="top"><img src="images/welcome.jpg" width="750" height="135"></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="231" valign="top">
      <c:forEach var="msgrow" items="${msg.rows}">
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
        <tr>
          <td width="750" height="21" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="images/T_bgcenter.gif">
            <!--DWLayoutTable-->
            <tr>
              <td width="28" height="21" valign="top"><img src="images/T_left.gif" width="140" height="21"></td>
              <td width="581">&nbsp;</td>
              <td width="29" valign="top"><img src="images/T_right.gif" width="56" height="21"></td>
            </tr>
          </table></td>
        </tr>
        <tr>
          <td height="26" valign="top" bgcolor="#009999">${msgrow.title}</td>
        </tr>
        <tr>
          <td height="142" valign="top">${msgrow.context}</td>
        </tr>
        <tr>
          <td height="25" valign="top">${msgrow.author}&nbsp;<fmt:formatDate pattern="yyyy-MM-dd" value="${msgrow.msgdate}"></fmt:formatDate></td>
        </tr>
        <tr>
          <td height="17" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="images/T_bottombg.gif">
            <!--DWLayoutTable-->
            <tr>
              <td width="22" height="17" valign="top"><img src="images/T_bottomleft.gif" width="145" height="17"></td>
              <td width="549"></td>
              <td width="56" valign="top"><img src="images/T_bottomright.gif" width="145" height="17"></td>
            </tr>
          </table></td>
        </tr>
        
        
        
      </table>
      </c:forEach>
            </td>
    </tr>
    <tr>
      <td height="24">&nbsp;</td>
    </tr>
    <tr>
      <td height="231" valign="top">
      <c:forEach items="${remsg.rows}" var="remsgrow">
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
        <tr>
          <td width="750" height="21" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="images/T_bgcenter.gif">
            <!--DWLayoutTable-->
            <tr>
              <td width="28" height="21" valign="top"><img src="images/T_left.gif" width="140" height="21"></td>
              <td width="581">&nbsp;</td>
              <td width="29" valign="top"><img src="images/T_right.gif" width="56" height="21"></td>
            </tr>
          </table></td>
        </tr>
        <tr>
          <td height="26" valign="top" bgcolor="#009999">${remsgrow.title}</td>
        </tr>
        <tr>
          <td height="142" valign="top">${remsgrow.context}</td>
        </tr>
        <tr>
          <td height="25" valign="top">${remsgrow.author}&nbsp;<fmt:formatDate pattern="yyyy-MM-dd" value="${remsgrow.msgdate}"></fmt:formatDate></td>
        </tr>
        <tr>
          <td height="17" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="images/T_bottombg.gif">
            <!--DWLayoutTable-->
            <tr>
              <td width="22" height="17" valign="top"><img src="images/T_bottomleft.gif" width="145" height="17"></td>
              <td width="549"></td>
              <td width="56" valign="top"><img src="images/T_bottomright.gif" width="145" height="17"></td>
            </tr>
          </table></td>
        </tr>
        
        
        
      </table>
      </c:forEach>
      </td>
    </tr>
    <tr>
      <td height="23">&nbsp;</td>
    </tr>
    <tr>
      <td height="256" valign="top"><form action="remsg" method="post"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
		<caption>快速回复</caption>
        <tr>
          <td height="66" align="right">作者：</td>
          <td><input type="text" name="name"/></td>
        </tr>
		<tr>
          <td height="70" align="right">标题：</td>
          <td><input type="text" name="title"/></td>
        </tr>
		<tr>
          <td align="right">内容：</td>
          <td><textarea name="context" cols="40" rows="10"></textarea></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit" value="提交"/><input type="hidden" name="id" value="${id}"/></td>
        </tr>
      </table></form></td>
    </tr>
  </table>
  </body>
</html>
