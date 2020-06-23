<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript">
	var url;	//全局变量：每个函数都会用，链接地址

	//打开客户服务处理对话框
	function openCustomerServiceFeedbackDialog(){
		//获取用户选中的行(可以选中多行，但只能修改一行)
		var selectRows = $("#dg").datagrid("getSelections");
		if(selectRows.length != 1){
			$.messager.alert("系统提示","请选择一条要反馈的数据");
			return;
		}
		var row = selectRows[0];		//当前记录的所有属性值
		$("#dlg").dialog("open").dialog("setTitle","客户服务反馈");
		//给对话框里面的表单赋值
		$("#fm").form("load",row);
		$("#state").val("已归档");
		url="${pageContext.request.contextPath}/customerService/save.do?id="+row.id;
	}
	
	//保存
	function saveCustomerService(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				if($("#myd").combobox("getValue") == ""){
					$.messager.alert("系统提示","请选择客户满意度");
					return false; 
				}
				//所有数据填充完毕，最后再一次验证表单
				return $(this).form("validate");
			},
			success:function(result){
				//alert(result);
				var result = eval('('+result+')');
				if(result.success){
					$.messager.alert("系统提示","反馈成功！");
					//重置属性值
					resetValue();
					//关闭对话框
					$("#dlg").dialog("close");
					//刷新表格数据
					$("#dg").datagrid("reload");
				}else{
					$.messager.alert("系统提示","反馈失败！");
					return;
				}
			}
		});
	}
	//关闭
	function closeCustomerServiceDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	//重置值
	function resetValue(){
		$("#serviceProceResult").val("");
		$("#myd").combobox("setValue","");
	}
	
</script>

</head>
<body>
	<table id="dg" title="客户服务反馈管理" class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true"
	url="${pageContext.request.contextPath}/customerService/list.do?state=已处理" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true" align="center"></th>
				<th field="id" width="50px" align="center">编号</th>
				<th field="customer" width="100px" align="center">客户</th>
				<th field="overview" width="200px" align="center">概要</th>
				<th field="serveType" width="100px" align="center">服务类型</th>
				<th field="createPeople" width="80px" align="center">创建人</th>
				<th field="createTime" width="100px" align="center">创建时间</th>
				<th field="state" width="50px" align="center" hidden="true">客户服务状态</th>
				<th field="assigner" width="80px" align="center">分配人</th>
				<th field="assignTime" width="100px" align="center">分配日期</th>
				<th field="serviceProce" width="100px" align="center">服务处理</th>
				<th field="serviceProcePeople" width="80px" align="center">服务处理人</th>
				<th field="serviceProceTime" width="100px" align="center">服务处理日期</th>
				<th field="serviceProceResult" width="50px" align="center" hidden="true">服务处理结果</th>
				<th field="myd" width="50px" align="center" hidden="true">客户满意度</th>
			</tr>
		</thead>
	</table>
	<div id="tb">
		<div>
			<a href="javascript:openCustomerServiceFeedbackDialog()" class="easyui-linkbutton" iconCls="icon-fwfk" plain="true">反馈</a>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width:620px;height:550px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="8px">
				<tr>
					<td>服务类型：</td>
					<td><input type="text" id="serveType" name="serveType" readonly="readonly"/></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>客户：</td>
					<td><input type="text" id="customer" name="customer" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>概要：</td>
					<td colspan="4"><input type="text" style="width:420px" id="overview" name="overview" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>服务请求：</td>
					<td colspan="4">
						<textarea rows="5" cols="49" id="servicerequest" name="servicerequest" readonly="readonly"></textarea>
					</td>
				</tr>
				<tr>
					<td>创建人：</td>
					<td>
						<input type="hidden" id="state" name="state"/>
						<input type="text" id="createPeople" name="createPeople" readonly="readonly"/>
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>创建时间：</td>
					<td><input type="text" id="createTime" name="createTime" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>分配给：</td>
					<td><input type="text" id="assigner" name="assigner" readonly="readonly"/></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>分配时间：</td>
					<td><input type="text" id="assignTime" name="assignTime" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>服务处理：</td>
					<td colspan="4">
						<textarea rows="5" cols="49" id="serviceProce" name="serviceProce" readonly="readonly"></textarea>
					</td>
				</tr>
				<tr>
					<td>处理人：</td>
					<td><input type="text" id="serviceProcePeople" name="serviceProcePeople" readonly="readonly"/></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>处理时间：</td>
					<td><input type="text" id="serviceProceTime" name="serviceProceTime" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>处理结果：</td>
					<td><input type="text" id="serviceProceResult" name="serviceProceResult" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>客户满意度：</td>
					<td>
						<select class="easyui-combobox" style="width:154px" id="myd" name="myd" editable="false" panelHeight="auto">
							<option value="">请选择...</option>
							<option value="☆">☆</option>
							<option value="☆☆">☆☆</option>
							<option value="☆☆☆">☆☆☆</option>
							<option value="☆☆☆☆">☆☆☆☆</option>
							<option value="☆☆☆☆☆">☆☆☆☆☆</option>
						</select>
					</td>
				</tr>
			</table>
		</form>
	</div>                                                                                                                    
	
	<div id="dlg-buttons">
		<a href="javascript:saveCustomerService()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeCustomerServiceDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>