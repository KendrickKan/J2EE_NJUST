<%@page import="njust.dataclass.course"%>
<%@page import="njust.dataclass.courseDAO"%>
<%@page import="njust.dataclass.LoginDAO"%>
<%@page import="njust.dataclass.Login"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addCourse.jsp' starting page</title>
    
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
    <h1>This is addCourse JSP page. </h1>
    <form method="post" action="CourseController" name="form1">
    	序号(此项为自动生成):
    	<% 
    		int errno = 200;
    		request.getSession().setAttribute("errno", errno);
    		courseDAO testCourseDAO = new courseDAO();
    		int nowid = testCourseDAO.getMaxId()+1;
    		out.println(nowid+"<br>");
    		course testcourse = new course();
    		testcourse.setId(nowid);
    	%>
    	作业标题:<input type="text" name="title" style="width:200px; height:22px;text-align:center;"><br>
    	学号(此项为自动生成):
    	<%
    		String adduserid = (String)request.getSession().getAttribute("userid");
    		out.println(adduserid+"<br>");
    		testcourse.setUserid(adduserid);
    		LoginDAO logd = new LoginDAO();
    		Login log  = logd.getLogin(adduserid);
    		String addname = log.getName();
    		testcourse.setName(addname);
    		request.getSession().setAttribute("testcourse", testcourse);
    	%>
    	姓名(此项为自动生成):<%=addname %><br>
    	日期:<input type="text" name="adddate" style="width:232px; height:22px;text-align:center;"><br>
    	时间:<input type="text" name="addtime" style="width:232px; height:22px;text-align:center;"><br>
    	<br>
    	<input type="submit" value="新增">
    </form>
  </body>
</html>
