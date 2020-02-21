package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("        <title>Register Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid\"> \n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-9 col-md-7 col-lg-5 mx-auto\">\n");
      out.write("                    <div class=\"card card-signin my-5\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            \n");
      out.write("                            <h3 class=\"card-title text-center\">REGISTRATION</h3>\n");
      out.write("                            <form action=\"MainController\" method=\"POST\">\n");
      out.write("                                <form action=\"MainController\" method=\"POST\" class=\"form-signin\">\n");
      out.write("                                    <input type=\"email\" name=\"txtEmail\" placeholder=\"Email\" class=\"form-control mb-3\" />\n");
      out.write("                                    <input type=\"text\" name=\"txtFullname\" placeholder=\"Full name\" class=\"form-control mb-3\"/>\n");
      out.write("                                    <input type=\"password\" name=\"txtPassword\" placeholder=\"Password\" class=\"form-control mb-3\" />\n");
      out.write("                                    <input type=\"password\" name=\"txtConfirm\" placeholder=\"Confirm password\" class=\"form-control mb-3\" />\n");
      out.write("                                    <input type=\"submit\" name=\"action\" value=\"Registration\" class=\"btn btn-lg btn-primary btn-block text-uppercase mb-3\">\n");
      out.write("                                </form>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
