<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import= "njust.data.*,njust.utils.*" %>

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

  </head>
  
  <body>
  <center>
     <table border="1" width="600">
        <tr>
          <td align = "center"><a href ="addBook.jsp"> 新     增</a>
        </tr>
   </table>
   <table border="1" width="600" id = "courseT">       
      <tr>
          <td align = "center">序号</td>
          <td align = "center">书名</td>
          <td align = "center">作者</td>
          <td align = "center">数量</td>
        </tr>
        <% 
          List<Book> curList = (List<Book>)request.getAttribute("allBooks");
          Book book = null;
          if(!curList.isEmpty()){
             int size = curList.size();
             int index =0; //starting from 0
	      	 while (index < size){	      	    
			    book =(Book) curList.get(index);
		     	if(book != null){
		     	%>
		     	<tr>
		     	  <td align = "center"><%=book.getBookId()%></td>
		     	  <td align = "center"><%=book.getTitle() %></td>
		     	  <td align = "center"><%=book.getAuthor() %></td>		     	
		     	  <td align = "center"><%=book.getQuantity() %></td>
		     	  <td align = "center"><a href="bookManage?operation=del&bookId=<%=book.getBookId() %>" onclick ="return delConfirm();" >删除</a></td>
		     	  <td align = "center"><a href="bookManage?operation=modReq&bookId=<%=book.getBookId() %>">修改</a></td>
		     	</tr>
		     	<% 
			    }
			    index = index +1;
		     }
          }   
        %>
       
      </table>
      </center>
  </body>
</html>
