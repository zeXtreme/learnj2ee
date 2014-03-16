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
    <title>商品信息</title>
  </head>
  
  <body>
    
  <table width="801" border="0" align="center" cellpadding="0" cellspacing="0">
    <!--DWLayoutTable-->
    <tr>
      <td height="161" colspan="4" valign="top"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="799" height="161">
        <param name="movie" value="images/2.swf">
        <param name="quality" value="high">
        <embed src="images/2.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="799" height="161"></embed>
      </object></td>
      <td width="1"></td>
    </tr>
    <tr>
      <td height="40" colspan="4" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
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
      <td></td>
    </tr>
    <tr>
      <td width="277" rowspan="2" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
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
      <td width="30" rowspan="2">&nbsp;      </td>
      <td width="467" height="25">&nbsp;</td>
      <td width="26" rowspan="2">&nbsp;</td>
      <td></td>
    </tr>
    <tr>
    <sql:setDataSource
			  	var="zengDS"
			  	driver="oracle.jdbc.OracleDriver"
			  	url="jdbc:oracle:thin:@localhost:1521:zeng"
			  	user="scott"
			  	password="tiger"
			  	/>
		<sql:query var="pros" dataSource="${zengDS}" sql="select * from product"></sql:query>
      <td rowspan="2" valign="top">
      <c:forEach var="row" items="${pros.rows}">
      <table width="100%" border="0" cellpadding="0" cellspacing="0" style="margin:20px auto">
        <!--DWLayoutTable-->
        <tr>
          <td width="155" rowspan="2" valign="top"><img alt="${row.pname}" src="${row.pimage}"/><br><a href="shopcart.jsp?add=${row.pid}">加入购物车</a></td>
          <td width="312" height="114" valign="top"><table width="100%" border="1" cellpadding="0" cellspacing="0">
            <!--DWLayoutTable-->
            <tr>
              <td width="36%">产品编号：</td>
              <td width="64%">${row.pid}</td>
              </tr>
            <tr>
              <td>产品名称：</td><td>${row.pname}</td>
              </tr>
            <tr>
              <td>产品品牌：</td><td>${row.pbrand}</td>
              </tr>
            <tr>
              <td>产品型号：</td><td>${row.ptype}</td>
              </tr>
            <tr>
              <td>产品价格：</td><td>${row.pprice}元</td>
              </tr>
            <tr>
              <td>产品介绍：</td><td>${row.pdesc}</td>
              </tr>
          </table></td>
        </tr>
        <tr>
          <td height="1"></td>
        </tr>
        
      </table>
      </c:forEach>
      </td>
      <td height="75"></td>
    </tr>
    
    <tr>
      <td rowspan="2" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
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
      <td height="40">&nbsp;</td>
      <td>&nbsp;</td>
      <td></td>
    </tr>
    <tr>
      <td height="130">&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td></td>
    </tr>
    
    <tr>
      <td height="270">&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td></td>
    </tr>
  </table>
  </body>
</html>
