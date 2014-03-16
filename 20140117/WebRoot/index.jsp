<%@ page language="java" import="java.util.*,me.zwy.vo.Employee" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>JSTL</title>
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
    <c:set var="str" value="${'hello world'}"></c:set>
    ${str}
    <c:out value="<br>${str}"></c:out>
    <c:out value="<br>${str}" escapeXml="false"></c:out>
    <c:out value="${null}" default="默认值，当value为空时输出"></c:out><hr>
    <jsp:useBean id="emp" class="me.zwy.vo.Employee">
	    <jsp:setProperty property="id" name="emp" value="1"/>
	    <jsp:setProperty property="name" name="emp" value="zs"/>
    </jsp:useBean>
    ${emp.id}<br>
    <c:set var="empid" target="${emp}" property="id" value="2"></c:set>
    ${empid}
    <c:remove var="str"/>
    ${str}--str已移除，所以不显示<hr>
    <%
    	Employee e = new Employee();
    	e.setId("123");
    	session.setAttribute("e", e);
     %>
    之前的值:${e.id}<br>
    <c:set target="${e}" property="id" value="321"></c:set>
    之后的值:${e.id}<hr>
    <c:set var="user" scope="session" value="loser"></c:set>
    <c:choose>
    	<c:when test="${user!=null}">
    		<p>欢迎您：${user}
    	</c:when>
    	<c:otherwise>
    		用户名<input type="text"/><br>
    		密码<input type="password"/>
    	</c:otherwise>
    </c:choose>
    <hr>
    <c:forEach begin="1" end="5">
    	helloworld!<br>
    </c:forEach>
    <hr>
    <%
    	String[] strs = {"aa","bb","cc"};
    	session.setAttribute("strs", strs);
     %>
    <c:forEach items="${strs}" var="str" varStatus="stu">
    	${stu.count}.${str}&nbsp;${stu.last}<br>
    </c:forEach>
    <hr>
    <c:forTokens items="aaa,bbb,ccc,ddd|fff" delims=",|" var="str">
    	${str}<br>
    </c:forTokens>
    <hr>
    <sql:setDataSource
    	var="mydb"
    	url="jdbc:oracle:thin:@localhost:1521:zeng"
    	driver="oracle.jdbc.OracleDriver"
    	user="scott"
    	password="tiger"
    />
    <sql:query var="rs" sql="select * from emp" dataSource="${mydb}"></sql:query>
    <c:forEach items="${rs.rows}" var="row">
    	<p>${row.empno}&nbsp;${row.ename}&nbsp;${row.sal}</p>
    </c:forEach>
  </body>
</html>
