<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loginFailure.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="refresh" content="5,URL=login.jsp">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>This is loginfailure JSP page.</h1> 
    <%
    	if((int)request.getSession().getAttribute("loginerrno")==201)
    	{
    		out.println("<h1>错误原因：不存在这个用户</h1>");
    	}
    	else 
    	{
    		out.println("<h1>错误原因：密码错误</h1>");
    	}
    		out.println("<h1>将在五秒后跳转回登录页面</h1>");
    %>
  </body>
</html>
