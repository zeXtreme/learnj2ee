<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>留言簿</title>
    
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
      <td height="135" colspan="3" align="center" valign="top"><img src="images/welcome.jpg" width="750" height="135"></td>
    </tr>
    <tr>
      <td width="91" height="34" align="center" valign="middle"><a href="newmsg.jsp">新留言</a></td>
      <td width="470">&nbsp;</td>
      <td width="189" valign="top"><strong>欢迎您使用&nbsp;&nbsp;留言本</strong></td>
    </tr>
    <tr>
      <td height="410" colspan="3" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
        <tr>
          <td width="750" height="21" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" bordercolor="#F0F0F0" background="images/T_bgcenter.gif">
            <!--DWLayoutTable-->
            <tr>
              <td width="58" height="21" valign="top"><img src="images/T_left.gif" width="140" height="21"></td>
              <td width="565">&nbsp;</td>
              <td width="45" valign="top"><img src="images/T_right.gif" width="56" height="21"></td>
            </tr>
          </table></td>
        </tr>
        <tr>
          <td height="389" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
            <!--DWLayoutTable-->
            <tr>
              <td width="77" height="28" align="center" valign="middle">回复</td>
              <td width="471" align="center" valign="middle">标题</td>
              <td width="101" align="center" valign="middle">作者</td>
              <td width="101" align="center" valign="middle">时间</td>
            </tr>
            <sql:setDataSource
			  	var="zengDS"
			  	driver="oracle.jdbc.OracleDriver"
			  	url="jdbc:oracle:thin:@localhost:1521:zeng"
			  	user="scott"
			  	password="tiger"
			  	/>
			 <sql:query var="msg" dataSource="${zengDS}" sql="select * from msgbook"></sql:query>
			 <c:forEach var="row" items="${msg.rows}">
			 	<tr>
			 	<td align="center">
			 		<sql:query var="recount" dataSource="${zengDS}" sql="select * from revertmsg where msgid=${row.id}"></sql:query>
			 		${recount.rowCount}
			 	</td>
			 	<td align="center"><a href="revertmsg.jsp?msg=${row.id}">${row.title}</a></td><td align="center">${row.author}</td><td align="center"><fmt:formatDate pattern="yyyy-MM-dd" value="${row.msgdate}"></fmt:formatDate></td></tr>
			 </c:forEach>
          </table></td>
        </tr>
        
        
        
        
      </table></td>
    </tr>
    
    <tr>
      <td height="17" colspan="3" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="images/T_bottombg.gif">
        <!--DWLayoutTable-->
        <tr>
          <td width="52" height="17" valign="top"><img src="images/T_bottomleft.gif" width="145" height="17"></td>
          <td width="537"></td>
          <td width="68" valign="top"><img src="images/T_bottomright.gif" width="145" height="17"></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="4"></td>
      <td></td>
      <td></td>
    </tr>
  </table>
  </body>
</html>
