/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.58
 * Generated at: 2020-11-06 00:00:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.bookmovie.dto.Admin;

public final class admin_005fhome_005fpage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.bookmovie.dto.Admin");
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
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
 
       //System.out.println("hi shows_page ");
      if(session.getAttribute("admin") == null){
    	 session.setAttribute("err_mssg", "Please Login Again...");
    	 response.sendRedirect("prep_admin_log.htm");
    	 
      }
	
      
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Book Movies</title>\r\n");
      out.write("    <!-- Required meta tags -->\r\n");
      out.write("    <meta charset=\"utf-8\" />\r\n");
      out.write("    <meta\r\n");
      out.write("      name=\"viewport\"\r\n");
      out.write("      content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"\r\n");
      out.write("    />\r\n");
      out.write("    <link\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("      href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"\r\n");
      out.write("    />\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.js\" integrity=\"sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <!-- Bootstrap CSS -->\r\n");
      out.write("    <link\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("      href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n");
      out.write("      integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n");
      out.write("      crossorigin=\"anonymous\"\r\n");
      out.write("    />\r\n");
      out.write("    <script\r\n");
      out.write("      src=\"https://kit.fontawesome.com/0ff6456f25.js\"\r\n");
      out.write("      crossorigin=\"anonymous\"\r\n");
      out.write("    >\r\n");
      out.write("   \r\n");
      out.write("    \r\n");
      out.write("    </script>\r\n");
      out.write("  \r\n");
      out.write("    \r\n");
      out.write("    <style>\r\n");
      out.write("      html,body {\r\n");
      out.write("\t\r\n");
      out.write(" \tbackground-repeat: no-repeat;\r\n");
      out.write(" \tbackground:url(\"home.jpg\");\r\n");
      out.write(" \tbackground-size: contain;\r\n");
      out.write("    padding:0;\r\n");
      out.write("    margin:0;\r\n");
      out.write("    height:100%;\r\n");
      out.write("    min-height:100%;\r\n");
      out.write("   }\r\n");
      out.write("  \r\n");
      out.write("  .quarter{\r\n");
      out.write("    width:50%;\r\n");
      out.write("    height:100%;\r\n");
      out.write("    float:left;\r\n");
      out.write("  }\r\n");
      out.write("  .contents{\r\n");
      out.write("    height:50%;\r\n");
      out.write("    width:100%;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("      .img {\r\n");
      out.write("        width: 50vh;\r\n");
      out.write("        height: 50vh;\r\n");
      out.write("        margin-left: 16%;\r\n");
      out.write("        margin-top: 40%;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      #icn {\r\n");
      out.write("        font-size: 25px;\r\n");
      out.write("        margin: 19px;\r\n");
      out.write("        color: white;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      .mobileShow {\r\n");
      out.write("        display: inline;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      /* Smartphone Portrait and Landscape */\r\n");
      out.write("      @media only screen and (min-device-width: 320px) and (max-device-width: 580px) {\r\n");
      out.write("        .mobileShow {\r\n");
      out.write("          display: inline;\r\n");
      out.write("        }\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      .mobileHide {\r\n");
      out.write("        display: inline;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      /* Smartphone Portrait and Landscape */\r\n");
      out.write("      @media only screen and (min-device-width: 320px) and (max-device-width: 580px) {\r\n");
      out.write("        .mobileHide {\r\n");
      out.write("          display: none;\r\n");
      out.write("        }\r\n");
      out.write("      }\r\n");
      out.write("    </style>\r\n");
      out.write("  </head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<nav class=\"navbar navbar-expand fixed-top text-light navbar-dark bg-dark justify-content-between\"  >\r\n");
      out.write("      <div class=\"nav navbar-nav\">\r\n");
      out.write("        <!--<a class=\"nav-item nav-link active\" href=\"#\">\r\n");
      out.write("          <i class=\"fa fa-home\" aria-hidden=\"true\"></i> Home</a\r\n");
      out.write("        >-->\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"nav navbar-nav\" style=\"font-family: cursive; font-size: 25px\">\r\n");
      out.write("        <font color=\"white\"> &#127909;</font>&nbspBOOK MY TICKET \r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"nav navbar-nav\">\r\n");
      out.write("         <a class=\"nav-item nav-link active\" href=\"prep_logout.htm\"><button class=\"btn btn-danger\">Logout</button></a>\r\n");
      out.write("      </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("    \r\n");
      out.write("\t<div style=\"height:80px;\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("<div class=\"container-fluid\" >\r\n");
      out.write("    \r\n");
      out.write("     <div class=\"contents\">\r\n");
      out.write("            <div class=\"col-md-6 quarter d-flex justify-content-center align-items-center\" style=\"background:rgba(26, 26, 26, 0.7); height: 50vh;\"><a href=\"prep_admin_shows.htm\" class=\"btn btn-warning btn-lg\" role=\"button\" aria-pressed=\"true\"><b><font color=\"black\"> &#x2634;</font>&nbspSHOWS</b></a></div>\r\n");
      out.write("            <div class=\"col-md-6 quarter d-flex justify-content-center align-items-center\" style=\"background-color:rgba(255, 255, 255, 0.7); height: 50vh;\"><a href=\"prep_admin_orders.htm\" class=\"btn btn-warning btn-lg\" role=\"button\" aria-pressed=\"true\"><b><font color=\"black\"> &#x2139;</font>&nbspORDERS</b></a></div>\r\n");
      out.write("            <div class=\"col-md-6 quarter d-flex justify-content-center align-items-center\" style=\"background-color:rgba(255, 255, 255, 0.7); height: 50vh;\"><a href=\"prep_admin_movie.htm\" class=\"btn btn-warning btn-lg\" role=\"button\" aria-pressed=\"true\"><b><font color=\"black\"> &#127909;</font>&nbspMOVIES</b></a></div>\r\n");
      out.write("            <div class=\"col-md-6 quarter d-flex justify-content-center align-items-center\" style=\"background: rgba(26, 26, 26, 0.7); height: 50vh;\"><a href=\"prep_admin_hall.htm\" class=\"btn btn-warning btn-lg\" role=\"button\" aria-pressed=\"true\"><b><font color=\"black\"> &#x2638;</font>&nbspHALLS</b></a></div>   \r\n");
      out.write("      </div>\r\n");
      out.write("    \r\n");
      out.write("</div>\r\n");
      out.write("  \r\n");
      out.write("   \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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