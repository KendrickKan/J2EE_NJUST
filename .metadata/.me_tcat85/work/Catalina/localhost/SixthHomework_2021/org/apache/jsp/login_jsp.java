/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.9
 * Generated at: 2021-04-25 13:34:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>登录</title>\r\n");
      out.write("    \r\n");
      out.write("    <meta name=\"content-type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <?xml encoding=\"UTF-8\"?>\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<!--\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n");
      out.write("\t-->\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("      .selectCSS{ width:200px}\r\n");
      out.write("    </style>\r\n");
      out.write("    \r\n");
      out.write("\t<script type=\"text/javascript\" src=\"jquery\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" >\r\n");
      out.write("    \r\n");
      out.write("      function validateForm(){\r\n");
      out.write("\t\t  var uname = document.forms[\"login\"][\"uname\"].value;\r\n");
      out.write("\t\t  var upwd = document.forms[\"login\"][\"upwd\"].value;\r\n");
      out.write("\t\t  var code = document.forms[\"login\"][\"checkcode\"].value;\r\n");
      out.write("\t\t  if (uname ==null || uname ==\"\")\r\n");
      out.write("\t\t  {\r\n");
      out.write("\t\t    alert(\"姓名必须填写！\");\r\n");
      out.write("\t\t    return false;\r\n");
      out.write("\t\t  }else if (upwd ==null || upwd ==\"\")\r\n");
      out.write("\t\t  {\r\n");
      out.write("\t\t    alert(\"密码不能为空！\");\r\n");
      out.write("\t\t    return false;\r\n");
      out.write("\t\t  }else if (code ==null || code ==\"\"){\r\n");
      out.write("\t\t    alert(\"必须输入验证码！\");\r\n");
      out.write("\t\t    return false;\r\n");
      out.write("\t\t  }\t\t  \r\n");
      out.write("\t  }\r\n");
      out.write("\t  \r\n");
      out.write("\t  var schoolName = [{label:\"cs\",value:\"计算机学院\"},{label:\"auto\",value:\"自动化学院\"},{label:\"mech\",value:\"机械学院\"}];\r\n");
      out.write("\t  //var school ={\"计算机学院\",\"自动化学院\",\"机械学院\"};\r\n");
      out.write("\t  var csDep = new Array(\"软件工程\",\"计算机科学与技术\",\"网络空间安全\",\"智能科学与技术\");\r\n");
      out.write("\t  var autoDep = new Array(\"电力工程\",\"电气自动化\",\"轨道编程\");\r\n");
      out.write("\t  var mechDep = new Array(\"汽车制造\",\"工业互联网\",\"智能制造\");\t  \r\n");
      out.write("\t  \r\n");
      out.write("\t  function initDep(){\r\n");
      out.write("\t    var school=document.getElementById(\"school\");\r\n");
      out.write("\t    var i =0;\r\n");
      out.write("\t    var s =\"\";\r\n");
      out.write("\t    for(i=0;i<schoolName.length;i++){\r\n");
      out.write("\t      s += \"<option value=\"+schoolName[i].label +\">\"+schoolName[i].value+\"</option>\";  \r\n");
      out.write("\t    }\r\n");
      out.write("\t    school.innerHTML=s;\r\n");
      out.write("\t    \r\n");
      out.write("\t    var department=document.getElementById(\"department\");\r\n");
      out.write("\t    i =0;\r\n");
      out.write("\t    s =\"\";\r\n");
      out.write("\t    for(i=0;i<csDep.length;i++){\r\n");
      out.write("\t      s += \"<option>\"+csDep[i]+\"</option>\";\r\n");
      out.write("\t   //   var op=document.createElement(\"option\");\r\n");
      out.write("\t   //   op.setAttribute(\"label\", s.label); \r\n");
      out.write("\t   //   op.setAttribute(\"value\", s.value); \r\n");
      out.write("\t   //   department.appendChild(op);\t  \r\n");
      out.write("\t    }\r\n");
      out.write("\t    department.innerHTML=s;\r\n");
      out.write("\t  }\r\n");
      out.write("\t  \r\n");
      out.write("\t  function changeDepartment(){\r\n");
      out.write("\t    var school =document.getElementById(\"school\");\r\n");
      out.write(" \t\tvar t=school.value;\r\n");
      out.write(" \t\tvar s =\"\";\r\n");
      out.write(" \t\tvar i = 0;\r\n");
      out.write(" \t\tswitch(t){\r\n");
      out.write("\t  \t\tcase \"cs\": \r\n");
      out.write("\t  \t\t   for(i=0;i<csDep.length;i++){\r\n");
      out.write("\t\t\t     s += \"<option>\"+csDep[i]+\"</option>\";\r\n");
      out.write("\t\t       }\r\n");
      out.write("\t  \t\t   break;\r\n");
      out.write("\t  \t\tcase \"auto\":\r\n");
      out.write("\t  \t\t   for(i=0;i<autoDep.length;i++){\r\n");
      out.write("\t\t\t     s += \"<option>\"+autoDep[i]+\"</option>\";\r\n");
      out.write("\t\t       }\r\n");
      out.write("\t  \t\t   break;\r\n");
      out.write("\t  \t\tcase \"mech\":\r\n");
      out.write("\t  \t\t   for(i=0;i<mechDep.length;i++){\r\n");
      out.write("\t\t\t     s += \"<option>\"+mechDep[i]+\"</option>\";\r\n");
      out.write("\t\t       }\r\n");
      out.write("\t  \t\t   break;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write(" \t\tvar department=document.getElementById(\"department\");\r\n");
      out.write("        department.innerHTML=s;\r\n");
      out.write("\t      \r\n");
      out.write("\t  }\r\n");
      out.write("    \r\n");
      out.write("      function reloadCheckImg()\r\n");
      out.write("      {\r\n");
      out.write("          $(\"img\").attr(\"src\",\"img.jsp?t=\"+(new Data().getTime()));\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("      $(document).ready(function()\r\n");
      out.write("      {\r\n");
      out.write("         $(\"checkcodeId\").blur(function()\r\n");
      out.write("         {\r\n");
      out.write("            var $checkcode = $(\"#checkcodeId\").val();\r\n");
      out.write("            $.post(\r\n");
      out.write("            \"LoginServlet\",\r\n");
      out.write("            \"checcode=\"+$checkcode,\r\n");
      out.write("            function(result)\r\n");
      out.write("            {\r\n");
      out.write("                var result = $(\"<img src = '\"+result+\"' height='15' width='15px' />\");\r\n");
      out.write("            });\r\n");
      out.write("         });\r\n");
      out.write("      });\r\n");
      out.write("    </script>\r\n");
      out.write("    \r\n");
      out.write("  <script>\"undefined\"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:\"59166\",secure:\"59165\"},c={nonSecure:\"http://\",secure:\"https://\"},r={nonSecure:\"127.0.0.1\",secure:\"gapdebug.local.genuitec.com\"},n=\"https:\"===window.location.protocol?\"secure\":\"nonSecure\";script=e.createElement(\"script\"),script.type=\"text/javascript\",script.async=!0,script.src=c[n]+r[n]+\":\"+t[n]+\"/codelive-assets/bundle.js\",e.getElementsByTagName(\"head\")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>\r\n");
      out.write("  \r\n");
      out.write(" <body onload=\"initDep()\" data-genuitec-lp-enabled=\"false\" data-genuitec-file-id=\"wc1-6\" data-genuitec-path=\"/SixthHomework_2021/WebRoot/login.jsp\">\r\n");
      out.write("  <br data-genuitec-lp-enabled=\"false\" data-genuitec-file-id=\"wc1-6\" data-genuitec-path=\"/SixthHomework_2021/WebRoot/login.jsp\">\r\n");
      out.write("  <br>\r\n");
      out.write("  <center>\r\n");
      out.write("  <form name=\"login\"  action=\"LoginServlet\" onsubmit=\"return validateForm()\" method = \"get\">\r\n");
      out.write("    <table>\r\n");
      out.write("      <tr>  <td> 用户名：</td><td><input  type = \"text\" name = \"uname\"> </td> </tr>\r\n");
      out.write("      <tr>  <td> 密码：</td><td><input  type = \"password\" name = \"upwd\"></td> </tr>\r\n");
      out.write("      <tr> <td> 所在学院：</td> \r\n");
      out.write("           <td>\r\n");
      out.write("              <select name = \"school\" id =\"school\" onchange = \"changeDepartment()\"  class =\"selectCSS\" >\r\n");
      out.write("               \t \r\n");
      out.write("\t\t\t  </select>           \r\n");
      out.write("           </td>  \r\n");
      out.write("      </tr>\r\n");
      out.write("      \r\n");
      out.write("      <tr> <td> 所在系：</td> \r\n");
      out.write("           <td>\r\n");
      out.write("              <select name = \"department\" id=\"department\" class =\"selectCSS\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t  </select>           \r\n");
      out.write("           </td>   \r\n");
      out.write("      <tr> \r\n");
      out.write("      \r\n");
      out.write("      <tr>    \r\n");
      out.write("        <td>验证码：</td>\r\n");
      out.write("        <td><input type=\"text\" name=\"checkcode\" id= \"checkcode\" size=\"4\">  </td>\r\n");
      out.write("        <td><a href=\"javascript:reloadCheckImg();\"><img src=\"img.jsp\"/></a> </td>\r\n");
      out.write("      </tr>  \r\n");
      out.write("    </table>\r\n");
      out.write("      <input  type = \"submit\" value = \"登录\"><br/>\r\n");
      out.write("  </form>\r\n");
      out.write("  </center>\r\n");
      out.write(" </body>\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
