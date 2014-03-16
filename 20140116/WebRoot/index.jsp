<%@ page language="java" import="java.util.*,me.zwy.vo.Employee" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>EL表达式</title>
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
    <center><h1>EL表达式</h1></center>
    ${100+20}<hr>
    ${1>2}<hr>
    abc对象是否为空:${empty abc}<hr>
    <%
    	Employee emp = new Employee();
    	emp.setName("zs");
    	emp.setAddrs(new String[]{"abc","cde","def"});
    	request.setAttribute("emp2", emp);
    	session.setAttribute("emp2", "emp2");
     %>
     <%=emp.getName() %><br>
     ${emp2.name}|${emp2["name"]}|${emp2["addrs"][1]}<br>
     ${sessionScope.emp2}<br>
     <jsp:useBean id="emp3" class="me.zwy.vo.Employee"></jsp:useBean>
     ${emp3}<br>
     访问<a href="index.jsp?id=23">请求参数</a>：
     ${param.id}
  </body>
</html>
