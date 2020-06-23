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
	var url;		//全局变量；每个函数都会用；链接地址
	
	//当选中指派人的时候，给指派时间赋值
	$(function (){
		//onSelect：事件，当选择一个下拉框时触发事件，如添加指派人，修改指派人。进行后面的代码
		$("#assignMan").combobox({		//#assignMan触发事件的节点，id
			onSelect:function (record){
				//判断所选内容指派人是否为空
				if(record.trueName !=''){
					$("#assignTime").val(getCurrentDateTime());
				}else{
					$("#assignTime").val("");
				}
			}
		})
	})
		
	
	//搜索
	function searchSaleChance(){
		$("#dg").datagrid("load",{
			"customerName":$("#s_customerName").val(),
			"overView":$("#s_overView").val(),
			"createMan":$("#s_createMan").val(),
			"state":$("#s_state").combobox("getValue")
		})
	}
	
	//打开营销机会对话框(添加)
	function openSaleChanceAddDialog(){
		resetValue();		//打开添加界面时清空文本框内容
		$("#createMan").val('${currentUser.trueName}')
		$("#createTime").val(getCurrentDateTime())
		
		$("#dlg").dialog("open").dialog("setTitle","添加营销机会信息");
		url="${pageContext.request.contextPath}/saleChance/save.do";
	}
	
	//打开营销机会对话框(修改)
	function openSaleChanceModifyDialog(){
		//获取选中的行（可以选中多行，但只能修改一行）
		var selectRows = $("#dg").datagrid("getSelections");
		//判断营销机会是否选择一行，如若不是则提示
		if(selectRows.length != 1){
			$.messager.alert("系统提示","请选择一条要编辑的数据");
			return;
		}
		var row = selectRows[0];		//当前记录的所有属性值
		$("#dlg").dialog("open").dialog("setTitle","修改营销机会信息");
		//给对话框里面的表单赋值
		$("#fm").form("load",row);
		url="${pageContext.request.contextPath}/saleChance/save.do?id="+row.id;
	}
	
	//保存
	 function saveSaleChance(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				//所有数据填充完毕，进行最后一次验证表单
				return $(this).form("validate");
			},
			success:function(result){
				var result = eval('('+result+')');
				if(result.success){
					$.messager.alert("系统提示","保存成功！");
					//重置属性值
					resetValue();
					//关闭对话框
					$("#dlg").dialog("close");
					//刷新表格数据
					$("#dg").datagrid("reload");
				}else{
					$.messager.alert("系统提示","保存失败！");
					return;
				}
			}
		})
	} 
	
	//删除
	function deleteSaleChance(){
		//获取营销机会选中的行（可以选中多行）
		var selectRows = $("#dg").datagrid("getSelections");
		//判断营销机会是否选中记录
		if(selectRows.length == 0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		//储存营销机会选中的Id
		var strIds = [];
		for(var i=0;i < selectRows.length; i++){
			//把选中的Id存到strIds数组里面
			strIds.push(selectRows[i].id)
		}
		//将数组变成字符串，按指定的符号隔开[11,12]
		var ids = strIds.join(",");
		$.messager.confirm("系统提示","您确定要删除这<font color='red' size='3'>"+selectRows.length+"</font>条记录吗？",function(r){
			if(r){
				$.post("${pageContext.request.contextPath}/saleChance/delete.do",{ids:ids},function(result){
					var result = eval('('+result+')');
					if(result.success){
						$.messager.alert("系统提示","数据删除成功！");
						//刷新表格数据
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert("系统提示","数据删除失败！")
					}
				})
			}
		});
	}
	
	//关闭
	function closeSaleChanceDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	//重置属性值
	function resetValue(){
		$("#chanceSource").val("");
		$("#customerName").val("");
		$("#cgjl").numberbox("setValue","");
		$("#overView").val("");
		$("#linkMan").val("");
		$("#linkPhone").val("");
		$("#description").val("");
		$("#createMan").val("");
		$("#createTime").val("");
		$("#assignMan").combobox("setValue","");
		$("#assignTime").val("");
	}
	
	//处理分配状态显示的值
	function formatState(value,row){
		if(row.state == 1){
			return "已分配";
		}else{
			return "未分配";
		}
	}
</script>
</head>
<body>
	
	<table id="dg" title="营销机会管理" class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true"
	url="${pageContext.request.contextPath}/saleChance/list.do" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true" align="center"></th>
				<th field="id" width="50px" align="center">编号</th>
				<th field="chanceSource" width="50px" align="center" hidden="true">机会来源</th>
				<th field="customerName" width="50px" align="center">客户名称</th>
				<th field="cgjl" width="50px" align="center" hidden="true">成功几率</th>
				<th field="overView" width="50px" align="center">概要</th>
				<th field="linkMan" width="50px" align="center">联系人</th>
				<th field="linkPhone" width="50px" align="center">联系电话</th>
				<th field="description" width="50px" align="center" hidden="true">机会描述</th>
				<th field="createMan" width="50px" align="center">创建人</th>
				<th field="createTime" width="50px" align="center">创建时间</th>
				<th field="assignMan" width="50px" align="center" hidden="true">指派人</th>
				<th field="assignTime" width="50px" align="center" hidden="true">指派时间</th>
				<th field="state" width="50px" align="center" formatter="formatState">分配状态</th>
				<th field="devResult" width="50px" align="center" hidden="true">客户开发状态</th>
			</tr>
		</thead> 
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:openSaleChanceAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openSaleChanceModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteSaleChance()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div> 
		<div>
			&nbsp;客户名称：<input type="text" id="s_customerName" size="20" onkeydown="if(event.keyCode==13) searchSaleChance()"/>
			&nbsp;概要：<input type="text" id="s_overView" size="20" onkeydown="if(event.keyCode==13) searchSaleChance()"/>
			&nbsp;创建人：<input type="text" id="s_createMan" size="20" onkeydown="if(event.keyCode==13) searchSaleChance()"/>
			&nbsp;分配状态：<select class="easyui-combobox" id="s_state" editable="false" panelHeight="auto">
							<option value="">请选择...</option>
							<option value="0">未分配</option>
							<option value="1">已分配</option>
						</select>
			<a href="javascript:searchSaleChance()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div> 
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width:700px;height:450px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="8px">
				<tr>
					<td>客户名称：</td>
					<td><input type="text" id="customerName" name="customerName" class="easyui-validatebox" required="true">&nbsp;<font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>机会来源：</td>
					<td><input type="text" id="chanceSource" name="chanceSource"></td>
				</tr>
				
				<tr>
					<td>联系人：</td>
					<td><input type="text" id="linkMan" name="linkMan"></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>联系电话：</td>
					<td><input type="text" id="linkPhone" name="linkPhone"></td>
				</tr>
				
				<tr>
					<td>成功几率（%）：</td>
					<!-- class="easyui-numberbox" easyui里自带的验证，只能为数字 -->
					<td><input type="text" id="cgjl" name="cgjl" class="easyui-numberbox" min="0" max="100" required="true">&nbsp;<font color="red">*</font></td>
				</tr>
				
				<tr>
					<td>概要：</td>
					<td colspan="4"><input type="text" id="overView" name="overView" style="width:420px;"/></td>
				</tr>
				
				<tr>
					<td>机会描述：</td>
					<td colspan="4">
						<!-- rows:高度（行）。cols:宽度（列） -->
						<textarea rows="5" cols="50" id="description" name="description"></textarea>
					</td>
				</tr>
				
				<tr>
					<td>创建人：</td>
					<td><input type="text" id="createMan" name="createMan" class="easyui-validatebox" required="true" readonly="readonly"/>&nbsp;<font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>创建时间：</td>
					<td><input type="text" id="createTime" name="createTime" readonly="readonly"/>&nbsp;<font color="red">*</font></td>
				</tr>
				
				<tr>
					<td>指派人：</td>
					<td><input class="easyui-combobox" id="assignMan" name="assignMan" panelHeight="auto" editable="false" valueField="trueName" textField="trueName" url="${pageContext.request.contextPath}/user/customerManagerComboList.do"/></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>指派时间：</td>
					<td><input type="text" id="assignTime" name="assignTime" readonly="readonly"></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveSaleChance()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeSaleChanceDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>