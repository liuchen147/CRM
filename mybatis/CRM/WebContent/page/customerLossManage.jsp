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
<script type="text/javascript">
	//搜索
	function searchCustomerLoss(){
		$("#dg").datagrid("load",{
			"cusName":$("#s_cusName").val(),
			"cusManager":$("#s_cusManager").val(),
			"state":$("#s_state").combobox("getValue")
		})
	}
	
	function formatstate(val,row){
		if (row.state == 1) {
			return "确认流失";
		} else {
			return "暂缓流失";
		}
	}
	
	function formatAction(val,row){
		if (row.state == 1) {
			return "确认流失";
		} else {
			return "<a href='javascript:openCustomerReprieve("+row.id+")'>暂缓流失</a>";
		}
	}
	function openCustomerReprieve(id){
		window.parent.openTab("客户流失暂缓措施管理",'customerReprieveManage.jsp?lossId='+id,'icon-khlsgl');
	}
</script>
</head>
<body>
	
	<table id="dg" title="客户流失管理" class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true"
	url="${pageContext.request.contextPath}/customerLoss/list.do" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true" align="center"></th>
				<th field="id" width="50px" align="center">编号</th>
				<th field="cusNo" width="50px" align="center" hidden="true">客户编号</th>
				<th field="cusName" width="100px" align="center">客户名称</th>
				<th field="cusManager" width="50px" align="center">客户经理</th>
				<th field="lastOrderTime" width="50px" align="center">上次下单日期</th>
				<th field="confirmLossTime" width="50px" align="center">确认流失日期</th>
				<th field="state" width="50px" align="center" formatter="formatstate">状态</th>
				<th field="lossReason" width="50px" align="center">流失原因</th>
				<th field="a" width="50px" align="center" formatter="formatAction">操作</th>
			</tr>
		</thead> 
	</table>
	
	<div id="tb">
		
		<div>
			客户名称：<input type="text" id="s_cusName" size="20" onkeydown="if(event.keyCode==13) searchCustomerLoss()"/>
			客户经理：<input type="text" id="s_cusManager" size="20" onkeydown="if(event.keyCode==13) searchCustomerLoss()"/>
			客户状态：
				<select class="easyui-combobox" id="s_state" editable="false" panelHeight="auto">
					<option value="">请选择...</option>
					<option value="0">暂缓流失</option>
					<option value="1">确认流失</option>
				</select>
			<a href="javascript:searchCustomerLoss()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div> 
	</div>
</body>
</html>