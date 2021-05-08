<%@page import="njust.dataclass.coursePage"%>
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
    <h1>欢迎来到你的作业管理界面</h1>
    	你的学号:
    <%
    	String userid = (String)request.getSession().getAttribute("mainuserid");
    	request.getSession().setAttribute("userid", userid);
    	out.println(userid+"<br>");
    	out.println("你的姓名:");
    	LoginDAO logd = new LoginDAO();
    	Login log = logd.getLogin(userid);
    	out.println(log.getName()+"<br>");
    %>
    	<table border="1px" cellspacing="0px" style="border-collapse:collapse" bordercolor="black">
    <tr>
        <th style="text-align:center;vertical-align:middle">
        <div style="width: 100%;">
         <div style="width: 100px;height: 25px;text-align:center;vertical-align:middle">序号</div>
    	</div>
		</th>
        <th style="text-align:center;vertical-align:middle">       
         <div style="width: 100%;">
         <div style="width: 500px;height: 25px;text-align:center;vertical-align:middle">作业标题</div>
    	</div>
    	</th>
        <th style="text-align:center;vertical-align:middle">
          <div style="width: 100%;">
         <div style="width: 150px;height: 25px;text-align:center;vertical-align:middle">创建者</div>
    	</div>
		</th>
        <th style="text-align:center;vertical-align:middle">
         <div style="width: 100%;">
         <div style="width: 150px;height: 25px;text-align:center;vertical-align:middle">创建日期</div>
    	</div>
		</th>
		<th style="text-align:center;vertical-align:middle">
         <div style="width: 100%;">
         <div style="width: 150px;height: 25px;text-align:center;vertical-align:middle">创建时间</div>
    	</div>
		</th>
    </tr>
    <%
    	//courseDAO coursedao = new courseDAO();
    	coursePage temppage = (coursePage)request.getAttribute("kPage");
    	//List<course> curList = (List<course>)request.getAttribute("courses");
    	List<course> curList = temppage.getCourses();
    	course cou = null;
    	if(!curList.isEmpty()){
    		int size = curList.size();
    		int index =0; //starting from 0
    		 while (index < size){	      	    
			    cou =(course) curList.get(index);
		     	if(cou != null){
		     	%>
		     	  <tr>
        			<td height="50" style="text-align:center"><input type="checkbox" name="xuhao" value="<%=cou.getId() %>"style="text-align:center"><%=cou.getId()%><br></td>
        			<td height="50" style="text-align:center"><%=cou.getTitle() %></td>
        			<td height="50" style="text-align:center"><%=cou.getName() %></td>
        			<td height="50" style="text-align:center"><%=cou.getNewdate() %></td>
        			<td height="50" style="text-align:center"><%=cou.getNewtime() %></td>
    			  </tr>
		     	<% 
			    }
			    index = index +1;
		     }
    	}
     %>
     <form method="post" action="addCourse.jsp" name="form1">
     <input type="submit" value="新增">
     </form>
     &nbsp;
     <form method="post" action="delCourse.jsp" name="form2">
     <input type="submit" value="删除">
     </form>
     
     &nbsp;
     <a href="CourseController?currentPage=1">首页</a>
     &nbsp;
     <a href="CourseController?currentPage=<%=temppage.getCurrentPage()-1 %>">上一页</a>
     &nbsp;
     <a href="CourseController?currentPage=<%=temppage.getCurrentPage()+1 %>">下一页</a>
     &nbsp;
     <a href="CourseController?currentPage=<%=temppage.getTotalPage() %>">尾页</a>
     &nbsp;
     当前页:<%=temppage.getCurrentPage() %>&nbsp;&nbsp;总页数:<%=temppage.getTotalPage() %>
     <br>
    
  </body>
</html>
