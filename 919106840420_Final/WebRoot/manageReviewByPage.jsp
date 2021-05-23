<%@page import="njust.entity.Review"%>
<%@page import="njust.entity.ReviewPage"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'manageReviewByPage.jsp' starting page</title>
    
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
    
    <table width="1130" height="200" border="1px" cellspacing="0px" style="border-collapse:collapse" bordercolor="black">
    	<tr bgcolor="#8CB9AC" style='width:100px;text-align:center; color:#FFFFFF; font-family:Tahoma; font-size:14pt;'>
    	<td width="100">序号</td>
    	<td width="250">送审机构</td>
    	<td width="330">论文标题</td>
    	<td width="150">费用</td>
    	<td width="150">日期</td>
    	<td width="150">是否支付</td>
    	</tr>
    	
    	 <%
    	//courseDAO coursedao = new courseDAO();
    	ReviewPage temppage = (ReviewPage)request.getAttribute("kPage");
    	//List<course> curList = (List<course>)request.getAttribute("courses");
    	List<Review> curList = temppage.getCourses();
    	Review cou = null;
    	if(!curList.isEmpty()){
    		int size = curList.size();
    		int index =0; //starting from 0
    		 while (index < size){	      	    
			    cou =(Review) curList.get(index);
		     	if(cou != null){
		     	%>
		     	  <tr bgcolor='#DCE6E1' style='text-align:center; color:#285548; font-family:Tahoma; font-size:12pt;'>
        			<td height="50" style="text-align:center"><input type="checkbox" name="xuhao" value="<%= String.valueOf(cou.getReviewid()) %>"style="text-align:center"><%=cou.getReviewid()%><br></td>
        			<td height="50" style="text-align:center"><%=cou.getOrganization() %></td>
        			<td height="50" style="text-align:center"><%=cou.getPapertitle() %></td>
        			<td height="50" style="text-align:center"><%=cou.getFee() %></td>
        			<td height="50" style="text-align:center"><%=cou.getDate() %></td>
        			<td height="50" style="text-align:center"><%=cou.isIspayed() %></td>
    			  </tr>
		     	<% 
			    }
			    index = index +1;
		     }
    	}
     %>
     <input type="submit" value="" style="width:190px;height:35px;border:none;background:url(img/btn.png) left top no-repeat;"/>
    	
    </table>
    <br>
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <a href="ReviewController?currentPage=1">首页</a>
     &nbsp;
     <a href="ReviewController?currentPage=<%=temppage.getCurrentPage()-1 %>">上一页</a>
     &nbsp;
     <a href="ReviewController?currentPage=<%=temppage.getCurrentPage()+1 %>">下一页</a>
     &nbsp;
     <a href="ReviewController?currentPage=<%=temppage.getTotalPage() %>">尾页</a>
     &nbsp;
     当前页:<%=temppage.getCurrentPage() %>&nbsp;&nbsp;总页数:<%=temppage.getTotalPage() %>
     <br>
    </center>
  </body>
</html>
