/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.58
 * Generated at: 2020-11-06 04:24:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.bookmovie.dto.Hall;
import java.util.List;

public final class admin_005fhall_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.bookmovie.dto.Hall");
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
      out.write("      \r\n");
      out.write("\r\n");
      out.write("\r\n");
 
       //System.out.println("hi shows_page ");
      if(session.getAttribute("admin") == null){
    	 session.setAttribute("err_mssg", "Please Login Again...");
    	 response.sendRedirect("prep_admin_log.htm");
    	 
      }
	
      
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Book Movies</title>\r\n");
      out.write("    <!-- Required meta tags -->\r\n");
      out.write("    <meta charset=\"utf-8\" />\r\n");
      out.write("    <meta\r\n");
      out.write("      name=\"viewport\"\r\n");
      out.write("      content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"\r\n");
      out.write("    />\r\n");
      out.write("    <meta\r\n");
      out.write("      name=\"viewport\"\r\n");
      out.write("      content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"\r\n");
      out.write("    />\r\n");
      out.write("    <link\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("      href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"\r\n");
      out.write("    />\r\n");
      out.write("     \r\n");
      out.write("     <link rel=\"stylesheet\" type=\"text/css\" href=\"signup.css\">\r\n");
      out.write("     \r\n");
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
      out.write("    </script>\r\n");
      out.write("    <script>\r\n");
      out.write("    $(document).ready(function() {\r\n");
      out.write("\t\t$(\"#myInput\").on(\"keyup\", function() {\r\n");
      out.write("\t\t\tvar value = $(this).val().toLowerCase();\r\n");
      out.write("\t\t\t$(\"#myTableBody tr\").filter(function() {\r\n");
      out.write("\t\t\t\t$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("    </script>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <style>\r\n");
      out.write("      body {\r\n");
      out.write("        \r\n");
      out.write("        background-repeat: no-repeat;\r\n");
      out.write("        background-size: cover;\r\n");
      out.write("      }\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t.jumbotron {\r\n");
      out.write(" \t\t\t background-image: url(\"background.jpg\");\r\n");
      out.write("\t\t  background-size: cover;\r\n");
      out.write("\t\t\t}\r\n");
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
      out.write("         <a class=\"nav-item nav-link active\" href=\"prep_admin_logout.htm\"><button class=\"btn btn-danger\">Logout</button></a>\r\n");
      out.write("      </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("    \r\n");
      out.write("\t<!--  <div style=\"height:80px;\"></div>  -->\r\n");
      out.write("\r\n");
      out.write("<div class=\"container-fluid\">\r\n");
      out.write("      \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"row content\">\r\n");
      out.write("\t\t\t<div class=\"text-light col-sm-12 main jumbotron\" style=\"background: rgba(26, 26, 26, 0.6)\">\r\n");
      out.write("\t\t\t\t<h3 class=\"text-center\" >\r\n");
      out.write("\t\t\t\t\t<b ><span style=\"color;white;\">All Screen &#127909;</span></b>\r\n");
      out.write("\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-2 form-group col-sm-3 ml-0 pl-0 float-left\"><input class=\"form-control  float-center\" id=\"myInput\" type=\"text\" placeholder=\"&#128269; Search\"></div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-8 form-group col-sm-6 float-left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span style=\"color:#FF0000;\">\r\n");
      out.write("                                    ");
      out.print(((session.getAttribute("err_mssgHall") != null)?(String)session.getAttribute("err_mssgHall") : "") );
      out.write("</span>\r\n");
      out.write("                                    <span style=\"color:#00FF40;\">\r\n");
      out.write("                                    ");
      out.print(((session.getAttribute("err_mssgHall1") != null)?(String)session.getAttribute("err_mssgHall1") : "") );
      out.write("</span>\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-2 form-group col-sm-3 \">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"admin_home.htm\">\r\n");
      out.write("\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-outline-light \" id=\"btn0\"   data-target=\"#myModal\">Home</button>\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"prep_admin_hall_add.htm\"><button type=\"button\" class=\"btn btn-outline-success \" id=\"btn0\" data-toggle=\"modal\" data-target=\"#myModal\">Add</button></a>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"table-responsive\" id=\"myTable\"></div>\r\n");
      out.write("\t\t\t\t<table class=\"table  table-striped \">\r\n");
      out.write("\t\t\t\t\t<thead class=\"table-dark\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"align-middle\">Hall Id</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"align-middle\">Hall Name</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"align-middle\">Capacity </th>\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"align-middle\">Action</th>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody id=\"myTableBody\">\r\n");
      out.write("\t\t\t\t\t");
 List<Hall> li = (List<Hall>)request.getAttribute("hList");
							for(Hall f : li){
							
		  			 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr style=\"color:white;\">\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"align-middle\">");
      out.print( f.getHallId() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"align-middle\">");
      out.print( f.getHallName());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"align-middle\">");
      out.print( f.getCapacity() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"align-middle\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"prep_admin_hall_update.htm?hall_id=");
      out.print(f.getHallId());
      out.write("\"><button type=\"button\" class=\"btn btn-primary btn-sm\" id=\"btn0\"   data-target=\"#myModal\" >Update</button></a>\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t  \r\n");
      out.write("   \r\n");
      out.write("    <footer class=\"page-footer font-small bg-dark text-light fixed-bottom\">\r\n");
      out.write("      <div class=\"footer-copyright text-center\">Created by : Team A</div>\r\n");
      out.write("      <!-- Copyright -->\r\n");
      out.write("      <div class=\"footer-copyright text-center\">\r\n");
      out.write("        © 2020 Copyright:\r\n");
      out.write("        <a href=\"https://mdbootstrap.com/\"> CDAC</a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- Copyright -->\r\n");
      out.write("    </footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
 session.removeAttribute("err_mssgHall");
	session.removeAttribute("err_mssgHall1");

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