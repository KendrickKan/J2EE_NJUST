<%@page import="njust.dataclass.courseDAO"%>
<%@page import="njust.dataclass.Login"%>
<%@page import="njust.dataclass.LoginDAO"%>
<%@page import="njust.dataclass.course"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'manageCourse.jsp' starting page</title>
    
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
    <h1>This is manageCourse JSP page.</h1>
    	你的学号:
    <%
    	String userid = (String)request.getSession().getAttribute("mainuserid");
    	out.println(userid+"<br>");
    	out.println("你的姓名:");
    	LoginDAO logd = new LoginDAO();
    	Login log = logd.getLogin(userid);
    	out.println(log.getName()+"<br>");
    %>
    	<table border="1px" cellspacing="0px" style="border-collapse:collapse">
    <tr>
        <th>
        <div style="width: 100%;">
         <div style="width: 100px;height: 20px;">序号</div>
    	</div>
		</th>
        <th>       
         <div style="width: 100%;">
         <div style="width: 500px;height: 20px;">作业标题</div>
    	</div>
    	</th>
        <th>
          <div style="width: 100%;">
         <div style="width: 150px;height: 20px;">创建者</div>
    	</div>
		</th>
        <th>
         <div style="width: 100%;">
         <div style="width: 150px;height: 20px;">创建日期</div>
    	</div>
		</th>
		<th>
         <div style="width: 100%;">
         <div style="width: 150px;height: 20px;">创建时间</div>
    	</div>
		</th>
    </tr>
    <%
    	courseDAO coursedao = new courseDAO();
    	List<course> curList = coursedao.getAllCourse(userid);
    	course cou = null;
    	if(!curList.isEmpty()){
    		int size = curList.size();
    		int index =0; //starting from 0
    		 while (index < size){	      	    
			    cou =(course) curList.get(index);
		     	if(cou != null){
		     	%>
		     	  <tr>
        			<td><input type="checkbox" name="xuhao" value="1"style="text-align:center"><%=cou.getId()%><br></td>
        			<td><%=cou.getTitle() %></td>
        			<td><%=cou.getName() %></td>
        			<td><%=cou.getNewdate() %></td>
        			<td><%=cou.getNewtime() %></td>
    			  </tr>
		     	<% 
			    }
			    index = index +1;
		     }
    	}
     %>
    
  </body>
</html>
