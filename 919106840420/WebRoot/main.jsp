<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="refresh" content="5,CourseController">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<%
  		String mainuserid = (String)request.getSession().getAttribute("controllerUserid");
  		session.setAttribute("mainuserid", mainuserid);
  		request.getSession().setAttribute("mainuserid", mainuserid);
  	%>
    <h1>This is main JSP page.</h1>
    <h1>这意味着你登录成功</h1>
    <h1>你将在五秒钟后自动跳转到manageCourse页面</h1>
  </body>
</html>
