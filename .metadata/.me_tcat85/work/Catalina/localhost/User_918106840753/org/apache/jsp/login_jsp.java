/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.9
 * Generated at: 2021-05-22 15:17:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import utils.*;
import entity.*;

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
    _jspx_imports_packages.add("utils");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("entity");
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
      response.setContentType("text/html;charset=utf-8");
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
      out.write("    <title>My JSP 'login.jsp' starting page</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<!--\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n");
      out.write("\t-->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/base.css\" />\r\n");
      out.write("\r\n");
      out.write("  <script>\"undefined\"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:\"59166\",secure:\"59165\"},c={nonSecure:\"http://\",secure:\"https://\"},r={nonSecure:\"127.0.0.1\",secure:\"gapdebug.local.genuitec.com\"},n=\"https:\"===window.location.protocol?\"secure\":\"nonSecure\";script=e.createElement(\"script\"),script.type=\"text/javascript\",script.async=!0,script.src=c[n]+r[n]+\":\"+t[n]+\"/codelive-assets/bundle.js\",e.getElementsByTagName(\"head\")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>\r\n");
      out.write("  \r\n");
      out.write("  <body style=\"background: #f7f7f7;\" data-genuitec-lp-enabled=\"false\" data-genuitec-file-id=\"wc2-4\" data-genuitec-path=\"/User_918106840753/WebRoot/login.jsp\">\r\n");
      out.write("\t\t<div id=\"header\" style=\"background: white;\" data-genuitec-lp-enabled=\"false\" data-genuitec-file-id=\"wc2-4\" data-genuitec-path=\"/User_918106840753/WebRoot/login.jsp\">\r\n");
      out.write("\t\t\t<div class=\"header-content\" style=\"width: 100%; height: 120px;\">\r\n");
      out.write("\t\t\t\t<div class=\"logo\" style=\"margin-left:100px ;\">\r\n");
      out.write("\t\t\t\t\t<a href=\"index.html\"> <img src=\"img/logo.png\" width=\"400\"/> </a>\r\n");
      out.write("\t\t\t\t\t<div class=\"key\" style=\"margin-top: 60px;\">\r\n");
      out.write("\t\t\t\t\t\t<p>???????????? </p><p style=\"text-decoration: underline;\">???????????? </p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"height: 28px; width: 100%; background: #8d0981;position:absolute;top: 120px;\"></div>\r\n");
      out.write("\t\t\t\t<div style=\"height: 1px; width: 100%; background: black;position:absolute;top: 148px;\"></div>\r\n");
      out.write("\t\t\t\t<div style=\"height: 1px; width: 100%; background: gray;position:absolute;top: 149px;\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"nav\" style=\"position: absolute;top:20px;right: 0px;\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"active\"> <a>??????</a> </li>\r\n");
      out.write("\t\t\t\t\t\t<li> <a href=\"http://www.njust.edu.cn/\">????????????</a> </li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("    ");

    	session.setAttribute("req","check");session.setAttribute("req","check");
    
      out.write("\r\n");
      out.write("    <div style=\"hetght:1000px;\">\r\n");
      out.write("    <form name=\"login\"  action=\"UserController\"  method=\"post\">\r\n");
      out.write("    \t<div style=\"width:300px;margin:0 auto;background: whitesomke;\">\r\n");
      out.write("\t\t<table style=\"hetght:1000px;margin-top:200px;margin-bottom:200px;\">\r\n");
      out.write("    \t\t<tr>\r\n");
      out.write("\t\t\t\t<td>????????????</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"uname\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>?????????</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"password\" name=\"upsd\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t        \t<td colspan=\"2\"><input type=\"submit\" value=\"??????\" style=\"width:60px;margin:0 auto;\"></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("    \t</table>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <div id=\"footer\">\r\n");
      out.write("\t\t\t<img src=\"img/lg2.png\" width=\"100\" style=\"position: absolute;left: 80px;\">\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t<a>??????</a> <a>|</a>\r\n");
      out.write("\t\t\t\t<a href=\"http://www.njust.edu.cn/\">????????????</a>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p style=\"color: #whitesmoke;\">\r\n");
      out.write("\t\t\t\t<a>???????????? &copy; 2020 &nbsp; ?????????????????? by918106840753 ?????????  </a>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p style=\"color: #whitesmoke;\">\r\n");
      out.write("\t\t\t\t<a>??????: 19825000486 &nbsp; E-mail:niso4@foxmail.com &nbsp;  ??????: ??????????????????????????????200??? ??????: 210094</a>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("    \r\n");
      out.write("  </body>\r\n");
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
