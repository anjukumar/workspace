/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-10-24 20:11:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ForgotPassword_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Forgot Password</title>\n");
      out.write("<script>\n");
      out.write("function validateForm() {\n");
      out.write("    var a = document.forms[\"PasswordForm\"][\"useremail\"].value;\n");
      out.write("    var b = document.forms[\"PasswordForm\"][\"userpassword\"].value;\n");
      out.write("    var c = document.forms[\"PasswordForm\"][\"confirmpassword\"].value;\n");
      out.write("\n");
      out.write("    if (a == null || a == \"\") {\n");
      out.write("        alert(\"Email must be filled out\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("    if (b == null || b == \"\") {\n");
      out.write("        alert(\"Password must be filled out\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("    if (!validateEmail(a)) {\n");
      out.write("    \talert(\"Enter a valid email address\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("    if (b != c ) {\n");
      out.write("        alert(\"Password does not match\");\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write("}\n");
      out.write("function validateEmail(email) {\n");
      out.write("\t  var re = /^(([^<>()[\\]\\\\.,;:\\s@\\\"]+(\\.[^<>()[\\]\\\\.,;:\\s@\\\"]+)*)|(\\\".+\\\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/;\n");
      out.write("\t  return re.test(email);\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write(" \n");
      out.write("\t<br>\n");
      out.write("\t<br>\n");
      out.write("\t<br>\n");
      out.write("\t<br>\n");
      out.write("\t<br>\n");
      out.write("\t<br>\n");
      out.write("\t<br>\n");
      out.write("\t<br>\n");
      out.write("\t<center>\n");
      out.write("\t");
if("notfound".equalsIgnoreCase(request.getParameter("error"))){ 
      out.write("\n");
      out.write("\t<font color=\"red\">Email not found.</font>\n");
      out.write("\t");
} 
      out.write("\n");
      out.write("\t\t<form name=\"PasswordForm\" action=\"ForgotPassword\" method=\"post\" onsubmit=\"return validateForm()\">\n");
      out.write("\n");
      out.write("\t\t\t            Email: <input type=\"text\" name=\"useremail\" id=\"useremail\"> <br>\n");
      out.write("\t\t\t<br> New Password: <input type=\"password\" name=\"userpassword\"\n");
      out.write("\t\t\t\tid=\"userpassword\"> <br> \n");
      out.write("\t\t\t\tconfirm Password: <input type=\"password\" name=\"confirmpassword\"\n");
      out.write("\t\t\t\tid=\"confirmpassword\"> <br>\n");
      out.write("\t\t\t\t<br> <input type=\"submit\"\n");
      out.write("\t\t\t\tvalue=\"Submit\" id=\"submit\" />\n");
      out.write("\t\t</form>\n");
      out.write("\t</center>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
