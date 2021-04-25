<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loginFailure.jsp' starting page</title>
    <meta name="content-type" content="text/html; charset=UTF-8">    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"59166",secure:"59165"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-7" data-genuitec-path="/SixthHomework_2021/WebRoot/loginFailure.jsp">
  
  
        登陆失败 <br data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-7" data-genuitec-path="/SixthHomework_2021/WebRoot/loginFailure.jsp">
    <%
    int code = ((Integer)request.getAttribute("error_code")).intValue();
    switch(code){
      case 1:
         out.println("密码有误");
         break;
      case 2:
         out.println("用户不存在");
         break;
      case 3:
         out.println("验证码有误");
         break;
    }   
     %>
     <br>
     <a href="login.jsp">login</a>
  </body>
</html>
