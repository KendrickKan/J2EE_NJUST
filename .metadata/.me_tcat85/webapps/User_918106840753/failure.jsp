<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'failure.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="stylesheet" href="css/base.css" />
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"59166",secure:"59165"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body style="background: #f7f7f7;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-2" data-genuitec-path="/User_918106840753/WebRoot/failure.jsp">
		<div id="header" style="background: white;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-2" data-genuitec-path="/User_918106840753/WebRoot/failure.jsp">
			<div class="header-content" style="width: 100%; height: 120px;">
				<div class="logo" style="margin-left:100px ;">
					<a href="index.html"> <img src="img/logo.png" width="400"/> </a>
					<div class="key" style="margin-top: 60px;">
						<p>进德修业 </p><p style="text-decoration: underline;">志道鼎新 </p>
					</div>
				</div>
				<div style="height: 28px; width: 100%; background: #8d0981;position:absolute;top: 120px;"></div>
				<div style="height: 1px; width: 100%; background: black;position:absolute;top: 148px;"></div>
				<div style="height: 1px; width: 100%; background: gray;position:absolute;top: 149px;"></div>
				<div class="nav" style="position: absolute;top:20px;right: 0px;">
					<ul>
						<li class="active"> <a>首页</a> </li>
						<li> <a href="http://www.njust.edu.cn/">官网主页</a> </li>
					</ul>
				</div>
			</div>
		</div>
    <br><br><br><br>
    <div style="height:400px;width 100%;text-align:center;">
   	<%
   		int error_code=((Integer)request.getAttribute("error_code")).intValue();
   		if(error_code==-2){
   	%>
   		密码错误
    <a href="login.jsp">重新登录</a>
   	<%
   		}
   		else if(error_code==-1){ 
   	%>
   		用户不存在
    <a href="login.jsp">重新登录</a>
   	<%
   		} 
   		else if(error_code==2){ 
   	%>
   		用户名重复，请更换用户名。
    <a href="addNewUser.jsp">重新添加</a>
   	<%
   		} 
   	%>
   	</div>
   	<div id="footer">
			<img src="img/lg2.png" width="100" style="position: absolute;left: 80px;">
			<p>
				<a>首页</a> <a>|</a>
				<a href="http://www.njust.edu.cn/">官网主页</a>
			</p>
			<p style="color: #whitesmoke;">
				<a>版权所有 &copy; 2020 &nbsp; 南京理工大学 by918106840753 钟涵文  </a>
			</p>
			<p style="color: #whitesmoke;">
				<a>电话: 19825000486 &nbsp; E-mail:niso4@foxmail.com &nbsp;  地址: 江苏省南京市孝陵卫街200号 邮编: 210094</a>
			</p>
		</div>
    
  </body>
</html>
