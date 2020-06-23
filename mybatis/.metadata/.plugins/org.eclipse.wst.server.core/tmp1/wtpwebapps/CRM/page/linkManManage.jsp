<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.edatagrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript">
	//页面加载完，给各个控件赋值
	$(function (){
		$.post("${pageContext.request.contextPath}/customer/findById.do",{id:'${param.cusId }'},function (result){
			$("#khno").val(result.khno);
			$("#name").val(result.name);
		},"json");
		
		
		$("#dg").edatagrid({ 
			//url：查询
			url:'${pageContext.request.contextPath}/linkMan/list.do?cusId=${param.cusId}',
			//saveUrl：保存
			saveUrl:'${pageContext.request.contextPath}/linkMan/save.do?customer.id=${param.cusId}',
			//updateUrl：修改
			updateUrl:'${pageContext.request.contextPath}/linkMan/save.do?customer.id=${param.cusId}',
			//destroyUrl：删除
			destroyUrl:'${pageContext.request.contextPath}/linkMan/delete.do'
		}); 
	}) 
	
</script>

</head>
<body style="margin:15px">
	<div id="p" title="客户基本管理" class="easyui-panel" style="width:700px;height:100px;padding:10px;">
		<table cellspacing="8px">
			<tr>
				<td>客户编号：</td>
				<td><input type="text" id="khno" name="khno" readonly="readonly" /></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>客户名称：</td>
				<td><input type="text" id="name" name="name" readonly="readonly"/>&nbsp;</td>
			</tr>
			
		</table>
	</div>   
	
	<br/>
	
	<table id="dg" title="开发计划项" style="width:700px;height:250px" toolbar="#toolbar" idField="id" 
	rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="id" width="30px">编号</th>
				<th field="linkName" width="100px" editor="{type:'validatebox',options:{required:true}}">客户姓名</th>
				<th field="sex" width="100px" 
					editor="{type:'combobox',
					options:{
						valueField:'id',
						textField:'name',
						data:[{id:'男',name:'男'},{id:'女',name:'女'}],
						required:true,
						editable:false,
						panelHeight:'auto',
					}}">性别</th>
				<th field="zhiwei" width="100px" editor="{type:'validatebox',options:{required:true}}">职位</th>
				<th field="officePhone" width="100px" editor="{type:'validatebox',options:{required:true}}">办公电话</th>
				<th field="phone" width="100px" editor="{type:'validatebox',options:{required:true}}">电话</th>
			</tr>
		</thead>
	</table>
		<div id="toolbar">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').edatagrid('addRow')">添加计划</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#dg').edatagrid('destroyRow')">删除计划</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#dg').edatagrid('saveRow');$('#dg').edatagrid('reload')">保存计划</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#dg').edatagrid('cancelRow')">撤销行</a>
		</div>
</body>
</html>