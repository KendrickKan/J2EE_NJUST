<%@ page language="java" import="java.util.*,njust.data.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'createCon.jsp' starting page</title>
    
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
     <br>
    <%
       MetaDataJDBC test = null;
       String method = request.getParameter("way");
       if (method !=null && method.equals("1")){
          test = new MetaDataJDBC(1);
          out.println("successfully construct a connection to mysql database 'test' by DriverManager" +"<br>");
       }else if (method !=null && method.equals("2")){
          test = new MetaDataJDBC(2);
          out.println("successfully construct a connection to mysql database 'test' by DataSource" +"<br>");
       }
       
       if(test!=null){
          out.println("���ݿ����ƣ�"+ test.getDbpName()+"<br>");
          out.println("���ݿ�URL��"+ test.getDbUrl()+"<br>");
          out.println("���ݿ���������"+ test.getDriverName()+"<br>");
          out.println("���ݿ����������"+ test.getMaxConnections()+"<br>");
       }  
     %>
     <a href="index.jsp">����Index.jspҳ��</A>
  </body>
</html>
