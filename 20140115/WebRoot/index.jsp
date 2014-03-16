<%@ page language="java" import="java.util.*,me.zwy.vo.Employee" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>JSP动作</title>
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
    <h1>JSP标准动作</h1>
    <a href="index.jsp?id=3&name=ls">点击</a>
    <hr>
    <%
    	Employee e = new Employee("1","qq");
    	out.print(e.getId()+" "+e.getName());
    	
     %>
    <br>
	<jsp:useBean id="emp" class="me.zwy.vo.Employee">
		<jsp:setProperty property="id" name="emp" value="2"/>
		<jsp:setProperty property="name" name="emp" value="zs"/>
	</jsp:useBean>
	<%=emp.getId()+" "+emp.getName() %>
	<br>
	<jsp:useBean id="emp2" class="me.zwy.vo.Employee"></jsp:useBean>
	<jsp:setProperty property="id" name="emp2" param="id"/>
	<jsp:setProperty property="name" name="emp2" param="name"/>
	<%=emp2.getId()+" "+emp2.getName() %>
	<br>
	<jsp:setProperty property="*" name="emp2"/>
	<%=emp2.getId()+" "+emp2.getName() %>
	<br>
	<jsp:getProperty property="name" name="emp2"/>
	<!--<jsp:forward page="main.jsp">
		<jsp:param value="hello" name="name"/>
	</jsp:forward>-->
	<jsp:include page="read.txt" flush="true"></jsp:include>
  </body>
</html>
