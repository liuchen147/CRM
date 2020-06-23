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
	
	//搜索
	function searchSaleChance(){
		$("#dg").datagrid("load",{
			"customerName":$("#s_customerName").val(),
			"overView":$("#s_overView").val(),
			"devResult":$("#s_devResult").combobox("getValue")
		})
	}
	
	//处理分配状态显示的值
	function formatState(value,row){
		if(row.state == 1){
			return "已分配";
		}else{
			return "未分配";
		}
	}
	
	//处理开发状态显示的值
	function formatDevResult(value,row){
		if(row.devResult==0){
			return "未开发";
		}else if(row.devResult==1){
			return "开发中";
		}else if(row.devResult==2){
			return "开发成功";
		}else if(row.devResult==3){
			return "开发失败";
		}
	}
	
	//调用父窗体的openTab方法，打开一个新的窗口
	function openCusDevPlanTab(id){
		window.parent.openTab('客户开发计划项管理','cusdevplanitemManage.jsp?saleChanceId='+id,'icon-khkfjh');
	}
	
	function openCusDevPlanTab2(id){
		window.parent.openTab('查看客户开发计划','cusdevplanitemManage.jsp?saleChanceId='+id+'&detailed=show','icon-khkfjh');
	}
	
	//处理需要显示的按钮
	function formatAction(value,row){
		if(row.devResult == 0 || row.devResult==1){
			return "<a href='javascript:openCusDevPlanTab("+row.id+")'>开发</a>";
		}else{
			return "<a href='javascript:openCusDevPlanTab2("+row.id+")'>查看详情</a>";
		}
	}
</script>
</head>
<body>
	
	<table id="dg" title="客户开发机会管理" class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true"
	url="${pageContext.request.contextPath}/saleChance/list.do?state=1" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true" align="center"></th>
				<th field="id" width="20px" align="center">编号</th>
				<th field="chanceSource" width="50px" align="center" hidden="true">机会来源</th>
				<th field="customerName" width="50px" align="center">客户名称</th>
				<th field="cgjl" width="50px" align="center" hidden="true">成功几率</th>
				<th field="overView" width="50px" align="center">概要</th>
				<th field="linkMan" width="50px" align="center">联系人</th>
				<th field="linkPhone" width="50px" align="center" hidden="true">联系电话</th>
				<th field="description" width="50px" align="center" hidden="true">机会描述</th>
				<th field="createMan" width="50px" align="center">创建人</th>
				<th field="createTime" width="50px" align="center">创建时间</th>
				<th field="assignMan" width="50px" align="center">指派人</th>
				<th field="assignTime" width="50px" align="center">指派时间</th>
				<th field="state" width="50px" align="center" hidden="true" formatter="formatState">分配状态</th>
				<th field="devResult" width="50px" align="center" formatter="formatDevResult">客户开发状态</th>
				<th field="a" width="50px" align="center" formatter="formatAction">操作</th>
			</tr>
		</thead> 
	</table>
	
	<div id="tb">
		<div>
			&nbsp;客户名称：<input type="text" id="s_customerName" size="20" onkeydown="if(event.keyCode==13) searchSaleChance()"/>
			&nbsp;概要：<input type="text" id="s_overView" size="20" onkeydown="if(event.keyCode==13) searchSaleChance()"/>
			&nbsp;开发状态：<select class="easyui-combobox" id="s_devResult" editable="false" panelHeight="auto">
							<option value="">请选择...</option>
							<option value="0">未开发</option>
							<option value="1">开发中</option>
							<option value="2">开发成功</option>
							<option value="3">开发失败</option>
						</select>
			<a href="javascript:searchSaleChance()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div> 
	</div>
	
</body>
</html>