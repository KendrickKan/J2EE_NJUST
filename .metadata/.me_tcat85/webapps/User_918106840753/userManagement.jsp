<%@ page language="java" import="java.util.*,entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userManagement.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	--><script type="text/javascript" >
	  
	  
	  function delConfirm(){
	    if(confirm("确定删除吗？")){
	      return true;
	    }
	    else{
	      return false;
	    }
	  
	  }
	  
	</script>
	<link rel="stylesheet" href="css/base.css" />
<style type="text/css">
			table{
				width: 600px;
				height: 240px;
				border: 1px solid blue;
				margin: 30px auto 0;
				border-spacing: 0;
				
				/* left、right只有火狐识别*/
				caption-side: top;
			}
			
			table caption{
				line-height: 40px;
				font-size: 20px;
			}
			table thead{
				background: #7e9de5;
				color: white;
				text-align: center;
			}
			table tbody td{
				font-size: 14px;
				text-align: center;
			}
			table tbody .title td{
				text-align: left;
				background: #7e9de5;
				color: white;
			}
			/* 隔行变色
			 单: tr:nth-child(2n+1)
			 双: tr:nth-child(2n)
			 */
			table tr:nth-child(2n){
				background: #fef0f5;
			}
	</style>
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"59166",secure:"59165"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
   <body style="background: white;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-6" data-genuitec-path="/User_918106840753/WebRoot/userManagement.jsp">
		<div id="header" style="background: white;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-6" data-genuitec-path="/User_918106840753/WebRoot/userManagement.jsp">
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
    List<UserBean> allusers=(List<UserBean>)request.getAttribute("allusers");
  	int totcount=0,index=1;
  	if(allusers!=null)totcount=allusers.size();
   %>
   <%
   		if(totcount==0){ 
   %>
   		<p>没有用户</p>
   <%
   		}else{
    %>
    	<table style="border:1px solid;height:420px;">
    	<thead>
    	<tr>
    		<td>id</td><td>name</td><td>pwd</td><td>是否删除</td><td>是否修改</td>
    	</tr>
    	</thead>
		<tbody>
    <%
	    	for(UserBean user:allusers){
	%>
	    	<tr>
		     	  <td align = "center"><%=index%></td>
		     	  <td align = "center"><%=user.getName() %></td>
		     	  <td align = "center"><%=user.getPsd() %></td>
		     	  <td align = "center"><a href="UserController?uname=<%=user.getName() %>&upsd=<%=user.getPsd() %>&req=delete" onclick ="return delConfirm();" >删除</a></td>
		     	  <td align = "center"><a href="modifyUser.jsp?uname=<%=user.getName() %>&upsd=<%=user.getPsd() %>">修改</a></td>
		    </tr>
	    		
	    		
	<%
				index++;
	    	}
	    }
    %>
    
    <tr>
    	<td colspan=5>
   	<a href="addNewUser.jsp">新增用户</a>
   		</td>
    </tr>
    </tbody>
    </table>
    共<%= request.getAttribute("cnt") %>人<br>
    
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
