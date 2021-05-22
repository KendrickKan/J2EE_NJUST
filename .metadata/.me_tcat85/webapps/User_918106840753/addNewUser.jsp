<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addNewUser.jsp' starting page</title>
    
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
  
   <body style="background: #f7f7f7;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-0" data-genuitec-path="/User_918106840753/WebRoot/addNewUser.jsp">
		<div id="header" style="background: white;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-0" data-genuitec-path="/User_918106840753/WebRoot/addNewUser.jsp">
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
  <%
    	session.setAttribute("req","add");session.setAttribute("req","add");
   %>
    This is my JSP page. <br>
    <form action="UserController" method="post">
    <table style="height:200px;margin:120 auto;">
    		<tr>
				<td>用户名：</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="upsd"></td>
			</tr>
			<tr>
	        	<td colspan="2"><input type="submit" value="新增" style="width:60px;margin:0 auto;"></td>
	        </tr>
	        
    </table>
    </form><div id="footer">
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
