<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增课程</title>
    
    <meta name="content-type" content="text/html; charset=UTF-8">
    <?xml encoding="UTF-8"?>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
      .selectCSS{ width:200px}
    </style>
    
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" >
    
      function validateForm(){
		  var cName = document.forms["addCourse"]["cName"].value;
		  var cCreator = document.forms["addCourse"]["cCreator"].value;
		  if (cName ==null || cName =="")
		  {
		    alert("课程名称必须填写！");
		    return false;
		  }else if (cCreator ==null || cCreator =="")
		  {
		    alert("创建者不能为空！");
		    return false;
		  }	  
	  }
    </script>
    
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"59166",secure:"59165"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
 <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-0" data-genuitec-path="/SixthHomework_2021/WebRoot/addCourse.jsp">
  <br data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-0" data-genuitec-path="/SixthHomework_2021/WebRoot/addCourse.jsp">
  <br>
  <center>
  <H2>新增课程信息(名称必填)</H2>
  <form name="addCourse"  action="courseManage" onsubmit="return validateForm()" method = "get">
    <table>
      <tr>  <td><input type = "hidden" name = "operation" value="add"> </td> </tr>
      <tr>  <td> 课程名：   </td><td><input  type = "text" name = "cName"> </td> </tr>
      <tr>  <td> 创建者：   </td><td><input  type = "text" name = "cCreator"></td> </tr>
      <tr>  <td> 开设时间：</td> 
            <td><input type="text" name="cDate" style="width: 90%" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"  />  </td>          
      </tr>
    
    </table>
      <input  type = "submit" value = "新增"><A href ="courseManage?operation=query"><input  type = "button" value = "返回课程管理"></a><br/>
  </form>
  </center>
 </body> 

</html>
