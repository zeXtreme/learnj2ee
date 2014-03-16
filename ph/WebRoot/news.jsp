<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.web.util.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String id = request.getParameter("news");
pageContext.setAttribute("news", id);
String pages = request.getParameter("page");
if(pages==null||Integer.parseInt(pages)<1){
	pages = "1";
}
pageContext.setAttribute("pages", Integer.parseInt(pages));
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>站内新闻</title>
  </head>
  
  <body>
    
  <table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
    <!--DWLayoutTable-->
    <tr>
      <td height="161" colspan="2" valign="top"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="799" height="161">
        <param name="movie" value="images/2.swf">
        <param name="quality" value="high">
        <embed src="images/2.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="799" height="161"></embed>
      </object></td>
    </tr>
    <tr>
      <td height="40" colspan="2" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
        <tr>
          <td width="57" height="40" valign="top"><img src="images/d_r3_c1.jpg" width="42" height="40"></td>
          <td width="41" valign="top"><a href="index.jsp"><img src="images/d_r3_c5.jpg" width="64" height="40" border="0"></a></td>
          <td width="38" valign="top"><a href="product.jsp"><img src="images/d_r3_c7.jpg" width="94" height="40" border="0"></a></td>
          <td width="31" valign="top"><a href="news.jsp"><img src="images/d_r3_c8.jpg" width="94" height="40" border="0"></a></td>
          <td width="32" valign="top"><img src="images/d_r3_c9.jpg" width="94" height="40"></td>
          <td width="31" valign="top"><a href="msgboard.jsp"><img src="images/d_r3_c10.jpg" width="94" height="40" border="0"></a></td>
          <td width="30" valign="top"><img src="images/d_r3_c11.jpg" width="94" height="40"></td>
          <td width="35" valign="top"><img src="images/d_r3_c12.jpg" width="94" height="40"></td>
          <td width="30" valign="top"><a href="admin/index.jsp"><img src="images/d_r3_c13.jpg" width="94" height="40" border="0" lowsrc="admin/index.jsp"></a></td>
          <td width="18" valign="top"><img src="images/d_r3_c25.jpg" width="36" height="40"></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td width="265" height="100" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
        <tr>
          <td height="25" align="center" valign="top"><a href="news.jsp"><img src="images/cg1_r1_c2.jpg" width="175" height="25" border="0"></a></td>
        </tr>
        <tr>
          <td height="15" align="center" valign="top"><a href="product.jsp"><img src="images/cg1_r2_c2.jpg" width="175" height="25" border="0"></a></td>
        </tr>
        <tr>
          <td height="20" align="center" valign="top"><img src="images/cg1_r4_c2.jpg" width="175" height="25"></td>
        </tr>
        <tr>
          <td height="18" align="center" valign="top"><img src="images/cg1_r6_c2.jpg" width="175" height="25"></td>
        </tr>
      </table></td>
      <td width="535" rowspan="3" valign="top">
      <sql:setDataSource
			  	var="zengDS"
			  	driver="oracle.jdbc.OracleDriver"
			  	url="jdbc:oracle:thin:@localhost:1521:zeng"
			  	user="scott"
			  	password="tiger"
			  	/>
      <c:choose>
      	<c:when test="${news==null}">
      		<sql:query var="countnews" dataSource="jdbc/zeng" sql="select * from news"></sql:query>
  			<c:set var="count" value="${countnews.rowCount}"></c:set>
  			<c:set var="maxpage" value="${count%10==0?count/10:(count-(count%10))/10+1}"></c:set>
      		<sql:query var="n" dataSource="${zengDS}" sql="select * from news order by ndate desc" maxRows="10" startRow="${0+10*(pages-1)}"></sql:query>
		      <ul style="margin:20px auto; list-style-type:none;">
      		<c:forEach var="new" items="${n.rows}">
      			<li style="padding:10px"><a href="news.jsp?news=${new.id}">${new.title}</a></li>
      		</c:forEach>
			  </ul>
			  <c:choose>
			  <c:when test="${maxpage==1}">
  		</c:when>
  		<c:when test="${pages==1}">
  			上一页<a href="news.jsp?page=${pages+1}">下一页</a>
  		</c:when>
  		<c:when test="${pages==maxpage}">
  			<a href="news.jsp?page=${pages-1}">上一页</a>下一页
  		</c:when>
  		<c:otherwise>
  			<a href="news.jsp?page=${pages-1}">上一页</a><a href="news.jsp?page=${pages+1}">下一页</a>
  		</c:otherwise>
  		</c:choose>
      	</c:when>
      	<c:otherwise>
      		<sql:query var="n" dataSource="${zengDS}" sql="select * from news where id=${news}"></sql:query>
      		<c:forEach var="new" items="${n.rows}">
      		<center><h1 style="margin-top:20px">${new.title}</h1></center>
      		<p>&nbsp;&nbsp;&nbsp;&nbsp;${new.content}</p><br>
      		<p>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${new.ndate}" pattern="yyyy年MM月dd日  HH点mm分"></fmt:formatDate></p>
      		</c:forEach>
      	</c:otherwise>
      </c:choose>
		</td>
    </tr>
    <tr>
      <td height="170" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
        <tr>
          <td width="188" height="27" valign="top" background="images/d_r11_8.jpg"><img src="images/cg1_r10_c1.jpg" width="188" height="27"></td>
        </tr>
        <tr>
          <td height="143" valign="top">
		  <ul style="list-style-image:url(images/cg5_1.jpg)">
				<li>业务专线：010-88888888</li>
				<li>售后服务：010-88888888</li>
				<li>传真：010-88888888</li>
			</ul></td>
        </tr>
      </table>      </td>
    </tr>
    <tr>
      <td height="285">&nbsp;</td>
    </tr>
  </table>
  </body>
</html>
