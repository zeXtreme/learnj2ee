<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
if(session.getAttribute("user")==null){
	response.sendRedirect("index.jsp");
}
 %>
 <%
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
    
    <title>xx的blog</title>
    
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
        <!--DWLayoutTable-->
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
        
        
      </table></td>
      <td width="597" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <!--DWLayoutTable-->
        <tr>
          <td width="597" height="350" valign="top" style="padding:30px">
		  	<center><h3>您的文章</h3></center>
		  	<sql:setDataSource
    		var="myDS"
    		url="jdbc:oracle:thin:@localhost:1521:zeng"
    		driver="oracle.jdbc.OracleDriver"
	    	user="scott"
	    	password="tiger"
	    	/>
		  	<sql:query var="countpost" dataSource="${myDS}" sql="select * from nb_post where author_id=${user.id}"></sql:query>
		  	<c:set var="count" value="${countpost.rowCount}"></c:set>
		  	<c:set var="maxpage" value="${count%10==0?count/10:(count-(count%10))/10+1}"></c:set>
		  	<c:choose>
		  		<c:when test="${maxpage==0}">
		  		<p>您目前还没有文章
		  		</c:when>
		  		<c:otherwise>
		  	<c:if test="${pages>maxpage}">
		  		<c:redirect url="userPage.jsp"></c:redirect>
		  	</c:if>
          <sql:query var="allMyPost" dataSource="${myDS}" sql="select * from nb_post where author_id=${user.id}" maxRows="10" startRow="${0+10*(pages-1)}"></sql:query>
		    <ul style="list-style-type:none">
          <c:forEach var="mypostrow" items="${allMyPost.rows}">
		      <li style="margin-bottom:10px"><a href="post.jsp?pid=${mypostrow.id}">${mypostrow.title}</a></li>
          </c:forEach>
          </ul>
          <br>
  	<c:choose>
  		<c:when test="${maxpage==1}"></c:when>
  		<c:when test="${pages==1}">
  			上一页<a href="userPage.jsp?page=${pages+1}">下一页</a>
  		</c:when>
  		<c:when test="${pages==maxpage}">
  			<a href="userPage.jsp?page=${pages-1}">上一页</a>下一页
  		</c:when>
  		<c:otherwise>
  			<a href="userPage.jsp?page=${pages-1}">上一页</a><a href="userPage.jsp?page=${pages+1}">下一页</a>
  		</c:otherwise>
  	</c:choose>
		  		</c:otherwise>
		  	</c:choose>
		      </td>
        </tr>
        
      </table></td>
    </tr>
  </table>
  </body>
</html>
