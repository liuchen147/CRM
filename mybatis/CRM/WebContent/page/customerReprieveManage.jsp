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
		$.post("${pageContext.request.contextPath}/customerLoss/findById.do",{id:'${param.lossId }'},function (result){
			$("#cusNo").val(result.cusNo);
			$("#cusName").val(result.cusName);
			$("#cusManager").val(result.cusManager);
			$("#lastOrderTime").val(result.lastOrderTime);
			
		},"json");
		
		
		$("#dg").edatagrid({ 
			//url：查询
			url:'${pageContext.request.contextPath}/customerReprieve/list.do?lossId=${param.lossId}',
			//saveUrl：保存
			saveUrl:'${pageContext.request.contextPath}/customerReprieve/save.do?customerLoss.id=${param.lossId}',
			//updateUrl：修改
			updateUrl:'${pageContext.request.contextPath}/customerReprieve/save.do?customerLoss.id=${param.lossId}',
			//destroyUrl：删除
			destroyUrl:'${pageContext.request.contextPath}/customerReprieve/delete.do'
		});  
		          
	}) 
	
	
	function confirmLoss(){
		
		$.messager.prompt('系统提示','请输入流失原因',function (r){
			
			if(r){
				$.post("${pageContext.request.contextPath}/customerLoss/confirmLoss.do",
						{id:'${param.lossId}',lossReason:r},function(result){
					if(result.success){
						
						$.messager.alert("系统提示","执行成功！");
					}else{
						$.messager.alert("系统提示","执行失败！");
					}
				},"json");
			}
		})
		
	}
	
	
</script>

</head>
<body style="margin:15px">
	<div id="p" title="客户流失基本信息" class="easyui-panel" style="width:700px;height:150px;padding:10px;">
		<table cellspacing="8px">
			<tr>
				<td>客户编号：</td>
				<td><input type="text" id="cusNo" name="cusNo" readonly="readonly" /></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>客户名称：</td>
				<td><input type="text" id="cusName" name="cusName" readonly="readonly"/>&nbsp;</td>
			</tr>
			<tr>
				<td>客户经理：</td>
				<td><input type="text" id="cusManager" name="cusManager" readonly="readonly"/>&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>上次下单时间：</td>
				<td><input type="text" id="lastOrderTime" name="lastOrderTime" readonly="readonly"/>&nbsp;</td>
			</tr>
			
		</table>
	</div>   
	
	<br/>
	
	<table id="dg" title="客户流失暂缓措施管理" style="width:700px;height:250px" toolbar="#toolbar" idField="id" 
	rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="id" width="30px">编号</th>
				<th field="measure" width="100px" editor="{type:'validatebox',options:{required:true}}">措施</th>
				
			</tr>
		</thead>
	</table>
	
		<div id="toolbar">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').edatagrid('addRow')">添加计划</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#dg').edatagrid('destroyRow')">删除计划</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#dg').edatagrid('saveRow');$('#dg').edatagrid('reload')">保存计划</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#dg').edatagrid('cancelRow')">撤销行</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-confrim" plain="true" onclick="javascript:confirmLoss()">确认流失</a>
			
		</div>                                                                                                 
</body>
</html>