/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.90
 * Generated at: 2019-09-02 07:59:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class customerLossManage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
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

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jquery-easyui-1.3.3/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jquery-easyui-1.3.3/themes/icon.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jquery-easyui-1.3.3/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jquery-easyui-1.3.3/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//搜索\r\n");
      out.write("\tfunction searchCustomerLoss(){\r\n");
      out.write("\t\t$(\"#dg\").datagrid(\"load\",{\r\n");
      out.write("\t\t\t\"cusName\":$(\"#s_cusName\").val(),\r\n");
      out.write("\t\t\t\"cusManager\":$(\"#s_cusManager\").val(),\r\n");
      out.write("\t\t\t\"state\":$(\"#s_state\").combobox(\"getValue\")\r\n");
      out.write("\t\t})\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction formatstate(val,row){\r\n");
      out.write("\t\tif (row.state == 1) {\r\n");
      out.write("\t\t\treturn \"确认流失\";\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\treturn \"暂缓流失\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction formatAction(val,row){\r\n");
      out.write("\t\tif (row.state == 1) {\r\n");
      out.write("\t\t\treturn \"确认流失\";\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\treturn \"<a href='javascript:openCustomerReprieve(\"+row.id+\")'>暂缓流失</a>\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction openCustomerReprieve(id){\r\n");
      out.write("\t\twindow.parent.openTab(\"客户流失暂缓措施管理\",'customerReprieveManage.jsp?lossId='+id,'icon-khlsgl');\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("\t<table id=\"dg\" title=\"客户流失管理\" class=\"easyui-datagrid\" fitColumns=\"true\" pagination=\"true\" rownumbers=\"true\"\r\n");
      out.write("\turl=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customerLoss/list.do\" fit=\"true\" toolbar=\"#tb\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th field=\"cb\" checkbox=\"true\" align=\"center\"></th>\r\n");
      out.write("\t\t\t\t<th field=\"id\" width=\"50px\" align=\"center\">编号</th>\r\n");
      out.write("\t\t\t\t<th field=\"cusNo\" width=\"50px\" align=\"center\" hidden=\"true\">客户编号</th>\r\n");
      out.write("\t\t\t\t<th field=\"cusName\" width=\"100px\" align=\"center\">客户名称</th>\r\n");
      out.write("\t\t\t\t<th field=\"cusManager\" width=\"50px\" align=\"center\">客户经理</th>\r\n");
      out.write("\t\t\t\t<th field=\"lastOrderTime\" width=\"50px\" align=\"center\">上次下单日期</th>\r\n");
      out.write("\t\t\t\t<th field=\"confirmLossTime\" width=\"50px\" align=\"center\">确认流失日期</th>\r\n");
      out.write("\t\t\t\t<th field=\"state\" width=\"50px\" align=\"center\" formatter=\"formatstate\">状态</th>\r\n");
      out.write("\t\t\t\t<th field=\"lossReason\" width=\"50px\" align=\"center\">流失原因</th>\r\n");
      out.write("\t\t\t\t<th field=\"a\" width=\"50px\" align=\"center\" formatter=\"formatAction\">操作</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead> \r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"tb\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t客户名称：<input type=\"text\" id=\"s_cusName\" size=\"20\" onkeydown=\"if(event.keyCode==13) searchCustomerLoss()\"/>\r\n");
      out.write("\t\t\t客户经理：<input type=\"text\" id=\"s_cusManager\" size=\"20\" onkeydown=\"if(event.keyCode==13) searchCustomerLoss()\"/>\r\n");
      out.write("\t\t\t客户状态：\r\n");
      out.write("\t\t\t\t<select class=\"easyui-combobox\" id=\"s_state\" editable=\"false\" panelHeight=\"auto\">\r\n");
      out.write("\t\t\t\t\t<option value=\"\">请选择...</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"0\">暂缓流失</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"1\">确认流失</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t<a href=\"javascript:searchCustomerLoss()\" class=\"easyui-linkbutton\" iconCls=\"icon-search\" plain=\"true\">搜索</a>\r\n");
      out.write("\t\t</div> \r\n");
      out.write("\t</div>\r\n");
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