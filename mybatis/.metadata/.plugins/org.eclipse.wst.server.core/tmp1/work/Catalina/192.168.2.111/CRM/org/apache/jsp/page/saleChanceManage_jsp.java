/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.90
 * Generated at: 2019-09-02 07:58:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class saleChanceManage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/common.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar url;\t\t//全局变量；每个函数都会用；链接地址\r\n");
      out.write("\t\r\n");
      out.write("\t//当选中指派人的时候，给指派时间赋值\r\n");
      out.write("\t$(function (){\r\n");
      out.write("\t\t//onSelect：事件，当选择一个下拉框时触发事件，如添加指派人，修改指派人。进行后面的代码\r\n");
      out.write("\t\t$(\"#assignMan\").combobox({\t\t//#assignMan触发事件的节点，id\r\n");
      out.write("\t\t\tonSelect:function (record){\r\n");
      out.write("\t\t\t\t//判断所选内容指派人是否为空\r\n");
      out.write("\t\t\t\tif(record.trueName !=''){\r\n");
      out.write("\t\t\t\t\t$(\"#assignTime\").val(getCurrentDateTime());\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t$(\"#assignTime\").val(\"\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t//搜索\r\n");
      out.write("\tfunction searchSaleChance(){\r\n");
      out.write("\t\t$(\"#dg\").datagrid(\"load\",{\r\n");
      out.write("\t\t\t\"customerName\":$(\"#s_customerName\").val(),\r\n");
      out.write("\t\t\t\"overView\":$(\"#s_overView\").val(),\r\n");
      out.write("\t\t\t\"createMan\":$(\"#s_createMan\").val(),\r\n");
      out.write("\t\t\t\"state\":$(\"#s_state\").combobox(\"getValue\")\r\n");
      out.write("\t\t})\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//打开营销机会对话框(添加)\r\n");
      out.write("\tfunction openSaleChanceAddDialog(){\r\n");
      out.write("\t\tresetValue();\t\t//打开添加界面时清空文本框内容\r\n");
      out.write("\t\t$(\"#createMan\").val('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentUser.trueName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\r\n");
      out.write("\t\t$(\"#createTime\").val(getCurrentDateTime())\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#dlg\").dialog(\"open\").dialog(\"setTitle\",\"添加营销机会信息\");\r\n");
      out.write("\t\turl=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/saleChance/save.do\";\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//打开营销机会对话框(修改)\r\n");
      out.write("\tfunction openSaleChanceModifyDialog(){\r\n");
      out.write("\t\t//获取选中的行（可以选中多行，但只能修改一行）\r\n");
      out.write("\t\tvar selectRows = $(\"#dg\").datagrid(\"getSelections\");\r\n");
      out.write("\t\t//判断营销机会是否选择一行，如若不是则提示\r\n");
      out.write("\t\tif(selectRows.length != 1){\r\n");
      out.write("\t\t\t$.messager.alert(\"系统提示\",\"请选择一条要编辑的数据\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar row = selectRows[0];\t\t//当前记录的所有属性值\r\n");
      out.write("\t\t$(\"#dlg\").dialog(\"open\").dialog(\"setTitle\",\"修改营销机会信息\");\r\n");
      out.write("\t\t//给对话框里面的表单赋值\r\n");
      out.write("\t\t$(\"#fm\").form(\"load\",row);\r\n");
      out.write("\t\turl=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/saleChance/save.do?id=\"+row.id;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//保存\r\n");
      out.write("\t function saveSaleChance(){\r\n");
      out.write("\t\t$(\"#fm\").form(\"submit\",{\r\n");
      out.write("\t\t\turl:url,\r\n");
      out.write("\t\t\tonSubmit:function(){\r\n");
      out.write("\t\t\t\t//所有数据填充完毕，进行最后一次验证表单\r\n");
      out.write("\t\t\t\treturn $(this).form(\"validate\");\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tsuccess:function(result){\r\n");
      out.write("\t\t\t\tvar result = eval('('+result+')');\r\n");
      out.write("\t\t\t\tif(result.success){\r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"系统提示\",\"保存成功！\");\r\n");
      out.write("\t\t\t\t\t//重置属性值\r\n");
      out.write("\t\t\t\t\tresetValue();\r\n");
      out.write("\t\t\t\t\t//关闭对话框\r\n");
      out.write("\t\t\t\t\t$(\"#dlg\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t//刷新表格数据\r\n");
      out.write("\t\t\t\t\t$(\"#dg\").datagrid(\"reload\");\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"系统提示\",\"保存失败！\");\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t} \r\n");
      out.write("\t\r\n");
      out.write("\t//删除\r\n");
      out.write("\tfunction deleteSaleChance(){\r\n");
      out.write("\t\t//获取营销机会选中的行（可以选中多行）\r\n");
      out.write("\t\tvar selectRows = $(\"#dg\").datagrid(\"getSelections\");\r\n");
      out.write("\t\t//判断营销机会是否选中记录\r\n");
      out.write("\t\tif(selectRows.length == 0){\r\n");
      out.write("\t\t\t$.messager.alert(\"系统提示\",\"请选择要删除的数据！\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//储存营销机会选中的Id\r\n");
      out.write("\t\tvar strIds = [];\r\n");
      out.write("\t\tfor(var i=0;i < selectRows.length; i++){\r\n");
      out.write("\t\t\t//把选中的Id存到strIds数组里面\r\n");
      out.write("\t\t\tstrIds.push(selectRows[i].id)\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//将数组变成字符串，按指定的符号隔开[11,12]\r\n");
      out.write("\t\tvar ids = strIds.join(\",\");\r\n");
      out.write("\t\t$.messager.confirm(\"系统提示\",\"您确定要删除这<font color='red' size='3'>\"+selectRows.length+\"</font>条记录吗？\",function(r){\r\n");
      out.write("\t\t\tif(r){\r\n");
      out.write("\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/saleChance/delete.do\",{ids:ids},function(result){\r\n");
      out.write("\t\t\t\t\tvar result = eval('('+result+')');\r\n");
      out.write("\t\t\t\t\tif(result.success){\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert(\"系统提示\",\"数据删除成功！\");\r\n");
      out.write("\t\t\t\t\t\t//刷新表格数据\r\n");
      out.write("\t\t\t\t\t\t$(\"#dg\").datagrid(\"reload\");\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert(\"系统提示\",\"数据删除失败！\")\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//关闭\r\n");
      out.write("\tfunction closeSaleChanceDialog(){\r\n");
      out.write("\t\t$(\"#dlg\").dialog(\"close\");\r\n");
      out.write("\t\tresetValue();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//重置属性值\r\n");
      out.write("\tfunction resetValue(){\r\n");
      out.write("\t\t$(\"#chanceSource\").val(\"\");\r\n");
      out.write("\t\t$(\"#customerName\").val(\"\");\r\n");
      out.write("\t\t$(\"#cgjl\").numberbox(\"setValue\",\"\");\r\n");
      out.write("\t\t$(\"#overView\").val(\"\");\r\n");
      out.write("\t\t$(\"#linkMan\").val(\"\");\r\n");
      out.write("\t\t$(\"#linkPhone\").val(\"\");\r\n");
      out.write("\t\t$(\"#description\").val(\"\");\r\n");
      out.write("\t\t$(\"#createMan\").val(\"\");\r\n");
      out.write("\t\t$(\"#createTime\").val(\"\");\r\n");
      out.write("\t\t$(\"#assignMan\").combobox(\"setValue\",\"\");\r\n");
      out.write("\t\t$(\"#assignTime\").val(\"\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//处理分配状态显示的值\r\n");
      out.write("\tfunction formatState(value,row){\r\n");
      out.write("\t\tif(row.state == 1){\r\n");
      out.write("\t\t\treturn \"已分配\";\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\treturn \"未分配\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("\t<table id=\"dg\" title=\"营销机会管理\" class=\"easyui-datagrid\" fitColumns=\"true\" pagination=\"true\" rownumbers=\"true\"\r\n");
      out.write("\turl=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/saleChance/list.do\" fit=\"true\" toolbar=\"#tb\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th field=\"cb\" checkbox=\"true\" align=\"center\"></th>\r\n");
      out.write("\t\t\t\t<th field=\"id\" width=\"50px\" align=\"center\">编号</th>\r\n");
      out.write("\t\t\t\t<th field=\"chanceSource\" width=\"50px\" align=\"center\" hidden=\"true\">机会来源</th>\r\n");
      out.write("\t\t\t\t<th field=\"customerName\" width=\"50px\" align=\"center\">客户名称</th>\r\n");
      out.write("\t\t\t\t<th field=\"cgjl\" width=\"50px\" align=\"center\" hidden=\"true\">成功几率</th>\r\n");
      out.write("\t\t\t\t<th field=\"overView\" width=\"50px\" align=\"center\">概要</th>\r\n");
      out.write("\t\t\t\t<th field=\"linkMan\" width=\"50px\" align=\"center\">联系人</th>\r\n");
      out.write("\t\t\t\t<th field=\"linkPhone\" width=\"50px\" align=\"center\">联系电话</th>\r\n");
      out.write("\t\t\t\t<th field=\"description\" width=\"50px\" align=\"center\" hidden=\"true\">机会描述</th>\r\n");
      out.write("\t\t\t\t<th field=\"createMan\" width=\"50px\" align=\"center\">创建人</th>\r\n");
      out.write("\t\t\t\t<th field=\"createTime\" width=\"50px\" align=\"center\">创建时间</th>\r\n");
      out.write("\t\t\t\t<th field=\"assignMan\" width=\"50px\" align=\"center\" hidden=\"true\">指派人</th>\r\n");
      out.write("\t\t\t\t<th field=\"assignTime\" width=\"50px\" align=\"center\" hidden=\"true\">指派时间</th>\r\n");
      out.write("\t\t\t\t<th field=\"state\" width=\"50px\" align=\"center\" formatter=\"formatState\">分配状态</th>\r\n");
      out.write("\t\t\t\t<th field=\"devResult\" width=\"50px\" align=\"center\" hidden=\"true\">客户开发状态</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead> \r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"tb\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<a href=\"javascript:openSaleChanceAddDialog()\" class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\">添加</a>\r\n");
      out.write("\t\t\t<a href=\"javascript:openSaleChanceModifyDialog()\" class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\">修改</a>\r\n");
      out.write("\t\t\t<a href=\"javascript:deleteSaleChance()\" class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\">删除</a>\r\n");
      out.write("\t\t</div> \r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t&nbsp;客户名称：<input type=\"text\" id=\"s_customerName\" size=\"20\" onkeydown=\"if(event.keyCode==13) searchSaleChance()\"/>\r\n");
      out.write("\t\t\t&nbsp;概要：<input type=\"text\" id=\"s_overView\" size=\"20\" onkeydown=\"if(event.keyCode==13) searchSaleChance()\"/>\r\n");
      out.write("\t\t\t&nbsp;创建人：<input type=\"text\" id=\"s_createMan\" size=\"20\" onkeydown=\"if(event.keyCode==13) searchSaleChance()\"/>\r\n");
      out.write("\t\t\t&nbsp;分配状态：<select class=\"easyui-combobox\" id=\"s_state\" editable=\"false\" panelHeight=\"auto\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"\">请选择...</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"0\">未分配</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"1\">已分配</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t<a href=\"javascript:searchSaleChance()\" class=\"easyui-linkbutton\" iconCls=\"icon-search\" plain=\"true\">搜索</a>\r\n");
      out.write("\t\t</div> \r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"dlg\" class=\"easyui-dialog\" style=\"width:700px;height:450px;padding:10px 20px\" closed=\"true\" buttons=\"#dlg-buttons\">\r\n");
      out.write("\t\t<form id=\"fm\" method=\"post\">\r\n");
      out.write("\t\t\t<table cellspacing=\"8px\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>客户名称：</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"customerName\" name=\"customerName\" class=\"easyui-validatebox\" required=\"true\">&nbsp;<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td>机会来源：</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"chanceSource\" name=\"chanceSource\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>联系人：</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"linkMan\" name=\"linkMan\"></td>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td>联系电话：</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"linkPhone\" name=\"linkPhone\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>成功几率（%）：</td>\r\n");
      out.write("\t\t\t\t\t<!-- class=\"easyui-numberbox\" easyui里自带的验证，只能为数字 -->\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"cgjl\" name=\"cgjl\" class=\"easyui-numberbox\" min=\"0\" max=\"100\" required=\"true\">&nbsp;<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>概要：</td>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"4\"><input type=\"text\" id=\"overView\" name=\"overView\" style=\"width:420px;\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>机会描述：</td>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"4\">\r\n");
      out.write("\t\t\t\t\t\t<!-- rows:高度（行）。cols:宽度（列） -->\r\n");
      out.write("\t\t\t\t\t\t<textarea rows=\"5\" cols=\"50\" id=\"description\" name=\"description\"></textarea>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>创建人：</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"createMan\" name=\"createMan\" class=\"easyui-validatebox\" required=\"true\" readonly=\"readonly\"/>&nbsp;<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td>创建时间：</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"createTime\" name=\"createTime\" readonly=\"readonly\"/>&nbsp;<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>指派人：</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"easyui-combobox\" id=\"assignMan\" name=\"assignMan\" panelHeight=\"auto\" editable=\"false\" valueField=\"trueName\" textField=\"trueName\" url=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/customerManagerComboList.do\"/></td>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td>指派时间：</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"assignTime\" name=\"assignTime\" readonly=\"readonly\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"dlg-buttons\">\r\n");
      out.write("\t\t<a href=\"javascript:saveSaleChance()\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\">保存</a>\r\n");
      out.write("\t\t<a href=\"javascript:closeSaleChanceDialog()\" class=\"easyui-linkbutton\" iconCls=\"icon-cancel\">关闭</a>\r\n");
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