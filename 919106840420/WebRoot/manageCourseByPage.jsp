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
    
    <title>作业管理界面</title>
    
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
  <div align="center">
  <img src="img/logo.png" width="400" />
  &emsp;&emsp;&emsp;&emsp;
  <img src="img/cselogo.png" width="400" />
  </div>
  <center>
    <h1>This is manageCourse JSP page.</h1>
    <h1>欢迎来到你的作业管理界面</h1>
    	&nbsp;你的学号:
    <%
    	String userid = (String)request.getSession().getAttribute("mainuserid");
    	request.getSession().setAttribute("userid", userid);
    	out.println(userid+"&nbsp;&nbsp;&nbsp;");
    	out.println("你的姓名:");
    	LoginDAO logd = new LoginDAO();
    	Login log = logd.getLogin(userid);
    	out.println(log.getName()+"&nbsp;&nbsp;&nbsp;");
    %>
    	<table width="830" height="200" border="1px" cellspacing="0px" style="border-collapse:collapse" bordercolor="black">
    	<tr bgcolor="#8CB9AC" style='width:100px;text-align:center; color:#FFFFFF; font-family:Tahoma; font-size:14pt;'>
    	<td width="100">序号</td>
    	<td width="280">作业标题</td>
    	<td width="150">创建者</td>
    	<td width="150">创建日期</td>
    	<td width="150">创建时间</td>
    	</tr>
 <!--
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
-->    
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
		     	  <tr bgcolor='#DCE6E1' style='text-align:center; color:#285548; font-family:Tahoma; font-size:12pt;'>
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
     &nbsp;&nbsp;
     <form method="post" action="addCourse.jsp" name="form1">
     	<input type="submit" value="新增">
     </form>
     &nbsp;&nbsp;
     <form method="post" action="delCourse.jsp" name="form2">
     	<input type="submit" value="删除">
     </form>
     </table>
     <br>
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
    </center>
  </body>
</html>
