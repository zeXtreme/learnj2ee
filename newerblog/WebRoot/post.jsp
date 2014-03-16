<%@page import="me.zwy.dao.impl.UserDaoImpl"%>
<%@page import="me.zwy.dao.PostDao"%>
<%@page import="me.zwy.dao.impl.PostDaoImpl"%>
<%@ page language="java" import="java.util.*,me.zwy.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String pid = request.getParameter("pid");
pageContext.setAttribute("pid", pid);
String author_id = new PostDaoImpl().findById(pid).getAuthor_id();
String author = new UserDaoImpl().findById(author_id).getUserName();
pageContext.setAttribute("author", author);
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>blog title</title>
	<style type="text/css">
		#title:link{color:#666666}
		#title:visited{color:#666666}
		#title:hover{color:#333333}
		#title:active{color:#666666}
	</style>
  </head>
  
  <body>
  <table width="800" border="0" cellpadding="0" cellspacing="0" align="center">
    <!--DWLayoutTable-->
    <tr>
      <td height="141" colspan="2" valign="top"><table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#666666">
        <!--DWLayoutTable-->
        <tr>
          <td width="800" height="141" valign="top" style="padding:40px"><a id="title" href="index.jsp" style="text-decoration:none"><h1>NewerBlog</h1></a></td>
        </tr>
      </table>      </td>
    </tr>
    <tr>
      <td width="203" height="350" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable--><c:choose>
          <c:when test="${user==null}">
        <tr>
          <td width="12" height="15"></td>
          <td width="178"></td>
          <td width="13"></td>
        </tr>
        <tr>
          <td height="116"></td>
          <td valign="top">
		  <form action="login" method="post">
		  <table width="100%" border="0" cellpadding="0" cellspacing="0" style="margin-top:30px">
            <!--DWLayoutTable-->
            <tr>
              <td width="80" height="30">用户名：</td>
              <td height="30"><input name="userName" type="text" size="12">
              <td height="30">			  </tr>
			  <tr>
			  <td width="80" height="30">密码：</td>
			  <td height="30"><input name="passWord" type="password" size="12">
			  <td height="30">			  </tr>
			  <tr>
			  <td align="center" colspan="2"><input type="submit" value="登录">
			  </td>
			  </tr>
			  <tr>
			  <td align="center" colspan="2"><a href="regist.jsp">注册账号</a></td>
            </tr>
          </table>
		  </form>         
		  </td>
          <td></td>
        </tr>
        <tr>
          <td height="219"></td>
          <td>&nbsp;</td>
          <td></td>
        </tr>
          </c:when>
          <c:otherwise>
          <tr>
          <td width="22" height="34">&nbsp;</td>
          <td width="150">&nbsp;</td>
          <td width="31">&nbsp;</td>
        </tr>
        <tr>
          <td height="64">&nbsp;</td>
          <td valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
            <!--DWLayoutTable-->
            <tr>
              <td width="150" height="31" align="center" valign="middle" colspan="2">欢迎您，${user.userName}</td>
          </tr>
            <tr>
              <td><a href="userPage.jsp">我的blog</a></td><td height="33" align="center" valign="middle"><a href="admin/index.jsp">进入后台</a></td>
          </tr>
          <tr>
              <td colspan="2" align="center"><a href="login?exit=1">退出登录</a></td>
          </tr>
          </table>
          </td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td height="252">&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
          </c:otherwise>
          </c:choose>
      </table></td>
      <td width="597" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
        <tr>
          <td width="597" height="350" valign="top" style="padding:30px">
          <sql:setDataSource
    		var="myDS"
    		url="jdbc:oracle:thin:@localhost:1521:zeng"
    		driver="oracle.jdbc.OracleDriver"
	    	user="scott"
	    	password="tiger"
	    	/>
          <sql:query var="post" dataSource="${myDS}" sql="select * from nb_post where id=${pid}"></sql:query>
          <c:forEach var="postrow" items="${post.rows}">
		  <center><h1>${postrow.title}</h1></center>
		  <center><font color="#999999" size="2"><fmt:formatDate value="${postrow.postdate}" pattern="yyyy年MM月dd日  HH点mm分"/> by ${author}</font></center>
		  <p>${postrow.context}</p>
          </c:forEach>
		  </td>
        </tr>
        
      </table></td>
    </tr>
  </table>
  </body>
</html>
