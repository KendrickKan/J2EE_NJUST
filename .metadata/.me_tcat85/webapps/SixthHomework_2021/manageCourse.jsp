<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import= "edu.njust.entity.*,edu.njust.dao.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta name="content-type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" >
	  function inValidateSession(){
	    session.invalidate();
	  }
	  
	  function delConfirm(){
	    if(confirm("确定删除吗？")){
	      return true;
	    }
	    else{
	      return false;
	    }
	  
	  }
	  
	</script>

  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"59166",secure:"59165"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-8" data-genuitec-path="/SixthHomework_2021/WebRoot/manageCourse.jsp">
  <center data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-8" data-genuitec-path="/SixthHomework_2021/WebRoot/manageCourse.jsp">
     <table border="1" width="600">
        <tr>
          <td align = "center"><a href ="addCourse.jsp"> 新     增</a>
          <td align = "center"><a href ="login.jsp" onclick="inValidateSession()"> 退出登录</a>
        </tr>
   </table>
   <table border="1" width="600" id = "courseT">       
      <tr>
          <td align = "center">序号</td>
          <td align = "center">课程名称</td>
          <td align = "center">创建者</td>
          <td align = "center">创建时间</td>
        </tr>
        <% 
          Vector<Course> curVec = (Vector<Course>)request.getAttribute("allCourse");
          Course course = null;
          if(!curVec.isEmpty()){
             int size = curVec.size();
             int index =1; //starting from 1
	      	 while (size> 0){	      	    
			    course =(Course) curVec.get(size-1);
		     	if(course != null){
		     	%>
		     	<tr>
		     	  <td align = "center"><%=index%></td>
		     	  <td align = "center"><%=course.getName() %></td>
		     	  <td align = "center"><%=course.getCreator() %></td>
		     	  <% Date date = course.getCreateDate();
		     	     if(date != null){
		     	  %>
		     	    <td align = "center"><%=date.toLocaleString() %></td>
		     	  <% }else { %>
		     	     <td align = "center">未填写日期</td>
		     	  <% } %>
		     	      <td align = "center"><a href="courseManage?operation=del&cName=<%=course.getName() %>" onclick ="return delConfirm();" >删除</a></td>
		     	      <td align = "center"><a href="courseManage?operation=modReq&cName=<%=course.getName() %>">修改</a></td>
		     
		     	</tr>
		     	<% 
			//	   System.out.println(course.getName()+"   "+course.getCreator()+"   "+course.getCreateDate());
			    }
			    index = index +1;
			    size = size -1;
		     }
          }   
        %>
       
      </table>
      </center>
  </body>
</html>
