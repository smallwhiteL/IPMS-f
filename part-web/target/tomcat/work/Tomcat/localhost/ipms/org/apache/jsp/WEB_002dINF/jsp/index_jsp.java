/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-04-14 07:42:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/jsp/common/pageHeader.jsp", Long.valueOf(1555227701362L));
    _jspx_dependants.put("/WEB-INF/jsp/register.jsp", Long.valueOf(1554624397734L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html style=\"height: 100%\">\r\n");
      out.write("<head>\r\n");
      out.write("<title>IPMS-f</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\r\n");
      out.write("\r\n");
      out.write("<!-- Own CSS -->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/index-style.css\" rel=\"stylesheet\">\r\n");
      out.write("<!-- Bootstrap CSS -->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("<!-- Title Icon -->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/plan.jpg\" rel=\"shortcut icon\">\r\n");
      out.write("<!-- JQuery (Before Bootstrap) -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<!-- Load Bootstrap Javascript Plugin -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/bootstrap.min.js\"></script>\r\n");
      out.write("<!-- Own Javascript register -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/registerJS.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"height: 100%; margin: auto; background: yellowgreen;\">\r\n");
      out.write("\t\r\n");
      out.write("\t");

		// 判断session中是否含有登录信息
		if (session.getAttribute("loginUser") != null) {
			session.invalidate();
		}
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- Header -->\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>页头</title>\r\n");
      out.write("<!-- Own CSS -->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/pageHeader-style.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- Header -->\r\n");
      out.write("    <div style=\"background-color:#E5E5E5\" class=\"headerHeightAjustment\">\r\n");
      out.write("        <!-- welcome and portrait -->\r\n");
      out.write("        <div class=\"col-xs-4\">\r\n");
      out.write("            <div class=\"col-xs-8 left-part-welcome\">\r\n");
      out.write("\t\t        ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-xs-4 left-part-portrait\">\r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- logo -->\r\n");
      out.write("        <div class=\"col-xs-4 logo-part\">\r\n");
      out.write("            IPMS<br>\r\n");
      out.write("           \t个人计划管理系统\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- back-to-home and logout -->\r\n");
      out.write("        <div class=\"col-xs-4\">\r\n");
      out.write("           <div class=\"col-xs-8 right-part-back-to-home\">\r\n");
      out.write("\t        \t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("           </div>\r\n");
      out.write("           <div class=\"col-xs-4 right-part-logout\">\r\n");
      out.write("\t\t        ");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("           </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- Main Content Form -->\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"row\" style=\"height: 100%\">\r\n");
      out.write("\t\t\t<div class=\"col-md-2\"></div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"col-xs-12 col-md-8\" style=\"height: 100%; background-color: white\">\r\n");
      out.write("\t\t\t\t<!-- Main Form -->\r\n");
      out.write("\t\t\t\t<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/loginAndRegister/login\" method=\"POST\" style=\"margin-top: 20%\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-- Username -->\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"username\">\r\n");
      out.write("\t\t\t\t\t\t\t<h1>账号</h1>\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\"\r\n");
      out.write("\t\t\t\t\t\t style=\"height: 70px; font-size: 30px\"\r\n");
      out.write("\t\t\t\t\t\t placeholder=\"请输入你的账号\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-- Password -->\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"password\">\r\n");
      out.write("\t\t\t\t\t\t\t<h1>密码</h1>\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\"\r\n");
      out.write("\t\t\t\t\t\t style=\"height: 70px; font-size: 30px\"\r\n");
      out.write("\t\t\t\t\t\t placeholder=\"请输入你的密码\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-- Fall to login and print the wrong message -->\r\n");
      out.write("\t\t\t\t\t<div><span class=\"fallMessage\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fallMessage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span></div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-- Submit and Register -->\r\n");
      out.write("\t\t\t\t\t<div class=\"row\" style=\"margin-top: 8%;\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-xs-4 col-xs-offset-3\">\r\n");
      out.write("\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-default\" \r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"font-size: 35px; font-weight: bold\">登录</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-xs-4 \">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-default\" role=\"button\" data-toggle=\"modal\" data-target=\"#myModal\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"font-size: 35px; font-weight: bold\">注册</a>\r\n");
      out.write("\t\t\t\t\t\t\t<!-- 通过bootstrap和jsp编译指令将注册页面引入 -->\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>用户注册</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- Modal -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n");
      out.write("\t  <div class=\"modal-dialog\" role=\"document\" style=\"width: 800px\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"close closeAndClear\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t<h4 class=\"modal-title adjustment1\" id=\"myModalLabel\"\r\n");
      out.write("\t\t\t\tstyle=\"color: blue\">用户注册</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t  \t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<!-- 账号 -->\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"register-username\" class=\"col-xs-3 control-label adjustment1\">账号</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-xs-6\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control \" id=\"register-username\"\r\n");
      out.write("\t\t\t\t\t\t\tplaceholder=\"请输入账号\" name=\"register-username\"  maxlength=\"20\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-xs-3\">\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"btn btn-info\" style=\"font-size: 17px; margin-left: -10px\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"check_repeat\">\r\n");
      out.write("\t\t\t\t\t\t\t\t是否可用\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t<span id=\"check_username\" class=\"adjustment2\"></span>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<br><br>\r\n");
      out.write("\t\t\t\t<!-- 密码 -->\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label for=\"register-password\" class=\"col-xs-3 control-label adjustment1\">密码</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-6\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" id=\"register-password\"\r\n");
      out.write("\t\t\t\t\t\tplaceholder=\"请输入密码\" name=\"register-password\" maxlength=\"20\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-3\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"check_password\" class=\"adjustment2\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<br><br>\r\n");
      out.write("\t\t\t\t<!-- 确认密码 -->\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label for=\"register-password-confirm\" class=\"col-xs-3 control-label adjustment1\">确认密码</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-6\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" id=\"register-password-confirm\"\r\n");
      out.write("\t\t\t\t\t\tplaceholder=\"请确认密码\" name=\"register-password-confirm\" maxlength=\"20\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-3\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"check_password_confirm\" class=\"adjustment2\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<br><br>\r\n");
      out.write("\t\t\t\t<!-- 名字 -->\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label for=\"name\" class=\"col-xs-3 control-label adjustment1\">名字</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-6\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"name\" placeholder=\"请输入名字\"name=\"name\" \r\n");
      out.write("\t\t\t\t\t\tmaxlength=\"20\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-3\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"check_name\" class=\"adjustment2\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<br><br>\r\n");
      out.write("\t\t\t\t<!-- 性别 -->\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label class=\"col-xs-3 control-label adjustment1\">性别</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-1\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"radio-inline\" style=\"font-size: 25px; height: 37px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"radio\" id=\"men\" name=\"sex\" value=\"男\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"height: 20px; width: 20px; margin-top: 8px\" class=\"form-control\">男\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-1\" >\r\n");
      out.write("\t\t\t\t\t\t<label class=\"radio-inline\" style=\"font-size: 25px; height: 37px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"radio\" id=\"women\" name=\"sex\" value=\"女\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"height: 20px; width: 20px; margin-top: 8px\" class=\"form-control\">女\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<br><br>\r\n");
      out.write("\t\t\t\t<!-- 出生日期 -->\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label for=\"birthday\" class=\"col-xs-3 control-label adjustment1\">出生日期</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-6\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"date\" name=\"birthday\" class=\"form-control\" id=\"birthday\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-xs-offset-3 col-xs-3\">\r\n");
      out.write("\t\t\t\t\t<span id=\"checkAll\"></span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<div style=\"text-align:center\">\r\n");
      out.write("\t\t\t\t<a class=\"btn btn-danger closeAndClear\" data-dismiss=\"modal\" style=\"font-size: 25px\">关闭</a>\r\n");
      out.write("\t\t\t\t<span style=\"white-space:pre\">                             </span>\r\n");
      out.write("\t\t\t\t<a class=\"btn btn-primary\" style=\"font-size: 25px\" id=\"register\">注册</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"col-md-2\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/jsp/common/pageHeader.jsp(18,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty loginUser}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t               \t欢迎您!<br>\r\n");
        out.write("\t               \t");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\r\n");
        out.write("\t\t        ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/jsp/common/pageHeader.jsp(35,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty otherPages}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t                <a href=\"javascript:;\" id=\"toHomePage\">回到首页</a>\r\n");
        out.write("\t            ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    // /WEB-INF/jsp/common/pageHeader.jsp(40,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty loginUser}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                \t<a id=\"logout\" href=\"javascript:;\">注销</a>\r\n");
        out.write("\t            ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }
}
