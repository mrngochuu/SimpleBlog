package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class postArticle_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_var_value;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_var_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_param_value_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_url_var_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_var_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_param_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_url_var_value.release();
    _jspx_tagPool_c_if_var_test.release();
    _jspx_tagPool_c_param_value_name_nobody.release();
    _jspx_tagPool_c_if_test.release();
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
      out.write("        <title>Post Article</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Header -->\n");
      out.write("<div class=\"container-fluid\">\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("        ");
      if (_jspx_meth_c_url_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("            <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${homeLink}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Home</a>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("            <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                ");
      if (_jspx_meth_c_url_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                ");
      if (_jspx_meth_c_url_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("</div>\n");
      out.write("<!-- end header -->");
      out.write("\n");
      out.write("        <div class=\"container-fluid\"> \n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-9 col-md-7 col-lg-5 mx-auto\">\n");
      out.write("                    <div class=\"card card-signin my-5\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <h5 class=\"card-title text-center mb-3\"><font color=\"red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.MESSAGE}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</font></h5>\n");
      out.write("                            <h3 class=\"card-title text-center\">ARTICLE FORM</h3>\n");
      out.write("                            <form action=\"MainController\" method=\"POST\" class=\"form-signin\">\n");
      out.write("                                Title: <input type=\"text\" name=\"txtTitle\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.txtTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control mb-3\" />\n");
      out.write("                                <font color=\"red\"><p class=\"mb-3\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.INVALID.titleError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p></font>\n");
      out.write("                                Short Description: <textarea name=\"txtDescription\" class=\"form-control mb-3\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.txtDescription}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</textarea>\n");
      out.write("                                <font color=\"red\"><p class=\"mb-3\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.INVALID.descriptionError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p></font>\n");
      out.write("                                Content: <textarea name=\"txtContent\" class=\"form-control mb-3\" rows=\"5\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.txtContent}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</textarea>\n");
      out.write("                                <font color=\"red\"><p class=\"mb-3\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.INVALID.contentError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p></font>\n");
      out.write("                                <button type=\"submit\" name=\"action\" value=\"PostArticle\" class=\"btn btn-lg btn-primary text-uppercase mb-3 btn-block\">Post</button>\n");
      out.write("                            </form>\n");
      out.write("                            <hr class=\"my-4\">\n");
      out.write("                            <div class=\"mb-3\">\n");
      out.write("                                ");
      if (_jspx_meth_c_url_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${homeLink}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Home Page</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("<!-- footer -->\n");
      out.write("<div class=\"container-fluid\">\n");
      out.write("    <footer class=\"p-3\">\n");
      out.write("        <center style=\"font-size: 15px; opacity: 0.5;\">Copyright &copy; G.A.U Co.op\n");
      out.write("        </center>\n");
      out.write("    </footer>\n");
      out.write("</div>");
      out.write("\n");
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

  private boolean _jspx_meth_c_url_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_var_value.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(_jspx_page_context);
    _jspx_th_c_url_0.setParent(null);
    _jspx_th_c_url_0.setVar("homeLink");
    _jspx_th_c_url_0.setValue("MainController");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_eval_c_url_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_c_url_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_c_url_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_c_url_0.doInitBody();
      }
      do {
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_param_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_url_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_c_url_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_0);
      return true;
    }
    _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_0);
    return false;
  }

  private boolean _jspx_meth_c_param_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_0 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_0.setPageContext(_jspx_page_context);
    _jspx_th_c_param_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_0);
    _jspx_th_c_param_0.setName("action");
    _jspx_th_c_param_0.setValue("SearchArticle");
    int _jspx_eval_c_param_0 = _jspx_th_c_param_0.doStartTag();
    if (_jspx_th_c_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_0);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_0);
    return false;
  }

  private boolean _jspx_meth_c_url_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_var_value.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_1.setPageContext(_jspx_page_context);
    _jspx_th_c_url_1.setParent(null);
    _jspx_th_c_url_1.setVar("logoutLink");
    _jspx_th_c_url_1.setValue("MainController");
    int _jspx_eval_c_url_1 = _jspx_th_c_url_1.doStartTag();
    if (_jspx_eval_c_url_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_c_url_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_c_url_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_c_url_1.doInitBody();
      }
      do {
        out.write("\n");
        out.write("                    ");
        if (_jspx_meth_c_param_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_url_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_c_url_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_c_url_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_1);
      return true;
    }
    _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_1);
    return false;
  }

  private boolean _jspx_meth_c_param_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_1 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_1.setPageContext(_jspx_page_context);
    _jspx_th_c_param_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_1);
    _jspx_th_c_param_1.setName("action");
    _jspx_th_c_param_1.setValue("Logout");
    int _jspx_eval_c_param_1 = _jspx_th_c_param_1.doStartTag();
    if (_jspx_th_c_param_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_1);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_1);
    return false;
  }

  private boolean _jspx_meth_c_url_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_var_value.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_2.setPageContext(_jspx_page_context);
    _jspx_th_c_url_2.setParent(null);
    _jspx_th_c_url_2.setVar("manageArticlesLink");
    _jspx_th_c_url_2.setValue("MainController");
    int _jspx_eval_c_url_2 = _jspx_th_c_url_2.doStartTag();
    if (_jspx_eval_c_url_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_c_url_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_c_url_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_c_url_2.doInitBody();
      }
      do {
        out.write("\n");
        out.write("                    ");
        if (_jspx_meth_c_param_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_2, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_url_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_c_url_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_c_url_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_2);
      return true;
    }
    _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_2);
    return false;
  }

  private boolean _jspx_meth_c_param_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_2 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_2.setPageContext(_jspx_page_context);
    _jspx_th_c_param_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_2);
    _jspx_th_c_param_2.setName("action");
    _jspx_th_c_param_2.setValue("AdminSearchArticle");
    int _jspx_eval_c_param_2 = _jspx_th_c_param_2.doStartTag();
    if (_jspx_th_c_param_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_2);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_2);
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_var_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.ROLE.roleName eq 'member'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    _jspx_th_c_if_0.setVar("isUser");
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <li class=\"nav-item\">\n");
        out.write("                        <a class=\"nav-link mt-2\" href=\"postArticle.jsp\">Post Article</a>\n");
        out.write("                    </li>\n");
        out.write("                    <li class=\"nav-item\">\n");
        out.write("                        <p class=\"nav-link mt-2\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.USER.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\n");
        out.write("                    </li>\n");
        out.write("                    <li class=\"nav-item\">\n");
        out.write("                        <a class=\"nav-link mt-2\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${logoutLink}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">Logout</a>\n");
        out.write("                    </li>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_var_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_var_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_var_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.ROLE.roleName eq 'admin'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    _jspx_th_c_if_1.setVar("isAdmin");
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <li class=\"nav-item\">\n");
        out.write("                        <a class=\"nav-link mt-2\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${manageArticlesLink}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" >\n");
        out.write("                            Manage\n");
        out.write("                        </a>\n");
        out.write("                    </li>\n");
        out.write("                    <li class=\"nav-item\">\n");
        out.write("                        <p class=\"nav-link mt-2\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.USER.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\n");
        out.write("                    </li>\n");
        out.write("                    <li class=\"nav-item\">\n");
        out.write("                        <a class=\"nav-link mt-2\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${logoutLink}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">Logout</a>\n");
        out.write("                    </li>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_var_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_var_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${!isUser && !isAdmin}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <li class=\"nav-item\">\n");
        out.write("                        <a class=\"nav-link mt-2\" href=\"login.jsp\">Login</a>\n");
        out.write("                    </li>\n");
        out.write("                    <li class=\"nav-item\">\n");
        out.write("                        <a class=\"nav-link mt-2\" href=\"registration.jsp\">Register</a>\n");
        out.write("                    </li>       \n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_url_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_var_value.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_3.setPageContext(_jspx_page_context);
    _jspx_th_c_url_3.setParent(null);
    _jspx_th_c_url_3.setVar("homeLink");
    _jspx_th_c_url_3.setValue("MainController");
    int _jspx_eval_c_url_3 = _jspx_th_c_url_3.doStartTag();
    if (_jspx_eval_c_url_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_c_url_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_c_url_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_c_url_3.doInitBody();
      }
      do {
        out.write("\n");
        out.write("                                    ");
        if (_jspx_meth_c_param_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_3, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_url_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_c_url_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_c_url_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_3);
      return true;
    }
    _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_3);
    return false;
  }

  private boolean _jspx_meth_c_param_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_3 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_3.setPageContext(_jspx_page_context);
    _jspx_th_c_param_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_3);
    _jspx_th_c_param_3.setName("action");
    _jspx_th_c_param_3.setValue("SearchArticle");
    int _jspx_eval_c_param_3 = _jspx_th_c_param_3.doStartTag();
    if (_jspx_th_c_param_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_3);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_3);
    return false;
  }
}
