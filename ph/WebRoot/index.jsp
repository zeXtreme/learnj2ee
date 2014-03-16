<%@page import="java.sql.ResultSet"%>
<%@page import="com.web.util.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>品红公司</title>
    <link href="css/news.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  
  <table width="800" border="0" cellpadding="0" cellspacing="0" align="center">
    <!--DWLayoutTable-->
    <tr>
      <td height="161" colspan="4" valign="top"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="799" height="161">
        <param name="movie" value="images/2.swf">
        <param name="quality" value="high">
        <embed src="images/2.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="799" height="161"></embed>
      </object></td>
    </tr>
    <tr>
      <td height="40" colspan="4" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="images/top_red.jpg">
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
          <td width="30" valign="top"><a href="admin/index.jsp"><img src="images/d_r3_c13.jpg" width="94" height="40" border="0"></a></td>
          <td width="18" valign="top"><img src="images/d_r3_c25.jpg" width="36" height="40"></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td width="295" height="238" valign="top"><table width="100%" height="238" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
        <tr>
          <td width="295" height="35" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="images/d02.jpg">
            <!--DWLayoutTable-->
            <tr>
              <td width="47" height="35" valign="top"><img src="images/d_r7_c1.jpg" width="101" height="35"></td>
                <td width="99" valign="top"><!--DWLayoutEmptyCell-->&nbsp;</td>
                <td width="28" valign="top"><img src="images/d_r7_c14.jpg" width="94" height="35"></td>
              </tr>
          </table></td>
        </tr>
        <tr>
          <td height="200" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
            <!--DWLayoutTable-->
            <tr>
              <td width="295" height="167" valign="top">
			  <div id="news">
			  	<ul>
			  	<sql:setDataSource
			  	var="zengDS"
			  	driver="oracle.jdbc.OracleDriver"
			  	url="jdbc:oracle:thin:@localhost:1521:zeng"
			  	user="scott"
			  	password="tiger"
			  	/>
			  	<sql:query var="news" dataSource="${zengDS}" sql="select * from news order by ndate desc" maxRows="5"></sql:query>
			  	<c:forEach var="row" items="${news.rows}">
			  		<li><a href="news.jsp?news=${row.id}">${row.title}</a></li>
			  	</c:forEach>
				</ul>
			  </div>			  </td>
            </tr>
            <tr>
              <td height="33" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                <!--DWLayoutTable-->
                <tr>
                  <td width="276" height="33">&nbsp;</td>
                    <td width="19" valign="top"><a href="news.jsp"><img src="images/d_r11_c15.jpg" width="51" height="33" border="0"></a></td>
                </tr>
              </table></td>
            </tr>
            
            
            
          </table>          </td>
        </tr>
        
        
      </table></td>
      <td colspan="2" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
        <tr>
          <td width="330" height="235">&nbsp;</td>
        </tr>
      </table></td>
      <td width="175" rowspan="3" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" style="width: 182px;">
        <!--DWLayoutTable-->
        <tr>
          <td width="175" height="35" valign="top"><img src="images/d_r11_6.jpg" width="175" height="42"></td>
        </tr>
        <tr>
          <td>
          <sql:query var="pros" dataSource="${zengDS}" sql="select * from product" maxRows="5"></sql:query>
          <ul style="list-style-type:none">
          <c:forEach var="row" items="${pros.rows}">
		  <li><a href="product.jsp"><img alt="${row.pname}" src="${row.pimage}"/></a></li>
		  </c:forEach>
          </ul>
          </td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="257" colspan="3" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
        <tr>
          <td height="27" colspan="12" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="images/d_r11_8.jpg">
            <!--DWLayoutTable-->
            <tr>
              <td width="63" height="27" valign="top"><img src="images/d_r13_c1.jpg" width="160" height="27"></td>
              <td width="405" valign="top"><!--DWLayoutEmptyCell-->&nbsp;</td>
              <td width="60" valign="top"><img src="images/d_r13_c21.jpg" width="66" height="27"></td>
            </tr>
          </table></td>
        </tr>
        <tr>
          <td align="center"><img src="images/d_r11_10_r1_c1.jpg" width="143" height="112"></td>
		  <td align="center"><img src="images/d_r11_10_r1_c2.jpg" width="143" height="112"></td>
          <td align="center"><img src="images/d_r11_10_r1_c8.jpg" width="143" height="112"></td>
          <td align="center"><img src="images/d_r11_10_r1_c116.jpg" width="143" height="112"></td>
        </tr>
        <tr>
          <td align="center"><img src="images/d_r11_10_r1_c16.jpg" width="143" height="112"></td>
          <td align="center"><img src="images/d_r11_10_r1_c22.jpg" width="143" height="112"></td>
          <td align="center"><img src="images/d_r11_10_r1_c221.jpg" width="143" height="112"></td>
          <td align="center"><img src="images/d_r11_10_r1_c81.jpg" width="143" height="112"></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="191" colspan="2" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
        <tr>
          <td width="311" height="27" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="images/d_r11_8.jpg">
            <!--DWLayoutTable-->
            <tr>
              <td width="50" height="27" valign="top"><img src="images/d_r11_11_r1_c1.jpg" width="185" height="27"></td>
              <td width="261">&nbsp;</td>
            </tr>
          </table></td>
        </tr>
        <tr>
          <td height="120" valign="top">
		  	<ul style="margin:10px auto; list-style-image:url(images/cg5_1.jpg)">
				<li style="padding:10px;"><b>业务专线：010-88888888</b></li>
				<li style="padding:10px;"><b>售后服务：010-88888888</b></li>
				<li style="padding:10px;"><b>传真：010-88888888</b></li>
			</ul>		  </td>
        </tr>       
      </table></td>
      <td width="314" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
        <tr>
          <td width="314" height="27" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="images/d_r11_8.jpg">
            <!--DWLayoutTable-->
            <tr>
              <td width="47" height="27" valign="top"><img src="images/d_r11_11_r1_c21.jpg" width="160" height="27"></td>
              <td width="121">&nbsp;</td>
              <td width="33" valign="top"><img src="images/d_r11_11_r1_c30.jpg" width="63" height="27"></td>
            </tr>
          </table>          </td>
        </tr>
        <tr>
          <td height="164">&nbsp;</td>
        </tr>
      </table></td>
    </tr>
    
    <tr>
      <td height="166">&nbsp;</td>
      <td width="16">&nbsp;</td>
      <td>&nbsp;</td>
      <td></td>
    </tr>
  </table>
  </body>
</html>
