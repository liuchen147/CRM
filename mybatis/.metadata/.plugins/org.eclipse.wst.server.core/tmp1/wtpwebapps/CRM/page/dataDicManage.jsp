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
	var url;	//全局变量：每个函数都会用，链接地址
	
	function searchDataDic(){
		$("#dg").datagrid("load",{
			"dataDicName":$("#s_dataDicName").combobox("getValue"),
			"dataDicValue":$("#s_dataDicValue").val()	
		})
	}
	
	//打开用户对话框(添加)
	function openDataDicAddDialog(){
		resetValue();
		$("#dlg").dialog("open").dialog("setTitle","添加数据字典信息");
		url="${pageContext.request.contextPath}/dataDic/save.do";
	}
	
	//打开用户对话框(修改)
	function openDataDicModifyDialog(){
		//获取用户选中的行(可以选中多行，但只能修改一行)
		var selectRows = $("#dg").datagrid("getSelections");
		if(selectRows.length != 1){
			$.messager.alert("系统提示","请选择一条要编辑的数据");
			return;
		}
		var row = selectRows[0];		//当前记录的所有属性值
		$("#dlg").dialog("open").dialog("setTitle","修改数据字典信息");
		//给对话框里面的表单赋值
		$("#fm").form("load",row);
		url="${pageContext.request.contextPath}/dataDic/save.do?id="+row.id;
	}
	
	//保存
	function saveDataDic(){
		var dataDicName = $("#dataDicName").combobox("getText");
		var dataDicValue = $("#dataDicValue").val();
		if(dataDicName == ""){
			$.messager.alert("系统提示","数据字典名不能为空！");
			return;
		}
		if(dataDicValue == ""){
			$.messager.alert("系统提示","数据字典值不能为空！");
			return;
		}
		$.post(url,{dataDicName:dataDicName,dataDicValue:dataDicValue},function (result){
			if(result.success){
				$.messager.alert("系统提示","保存成功！");
				//关闭对话框
				$("#dlg").dialog("close");
				//刷新表格数据
				$("#dg").datagrid("reload");
				resetValue();
			}else{
				$.messager.alert("系统提示","保存失败！");
			}
		},"json");
	}
	
	//删除
	function deleteDataDic(){
		//获取用户选中的行(可以选中多行)
		var selectRows = $("#dg").datagrid("getSelections");
		if(selectRows.length == 0){
			$.messager.alert("系统提示","请选择要删除的数据");
			return;
		}
		//存储用户所选中行的id
		var strIds = [];
		for(var i=0;i < selectRows.length;i++){
			//把选中记录的id存到strIds数组里面
			strIds.push(selectRows[i].id)
		}
		//将数组变成字符串，按指定的符号隔开 [11,12]   	"11,12"
		var ids = strIds.join(",");
		$.messager.confirm("系统提示","您却定要删除这<font color='red' size='3'>"+selectRows.length+"</font>条记录吗？",function(r){
			if(r){
				$.post("${pageContext.request.contextPath}/dataDic/delete.do",{ids:ids},function (result){
					var result = eval('('+result+')');
					if(result.success){
						$.messager.alert("系统提示","数据删除成功！");
						//刷新表格数据
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert("系统提示","数据删除失败！");
					}         
				})
			}
		});
	}
	
	//关闭
	function closeDataDicDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	//重置
	function resetValue(){
		$("#dataDicName").combobox("setValue","");
		$("#dataDicValue").val("");
	}
	
</script>

</head>
<body>
	<table id="dg" title="数据字典管理" class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true"
	url="${pageContext.request.contextPath}/dataDic/list.do" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true" align="center"></th>
				<th field="id" width="50px" align="center">编号</th>
				<th field="dataDicName" width="50px" align="center">数据字典名称</th>
				<th field="dataDicValue" width="50px" align="center">数据字典值</th>
			</tr>
		</thead>
	</table>
	<div id="tb">
		<div>
			<a href="javascript:openDataDicAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openDataDicModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteDataDic()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
		<div>
			&nbsp;数据字典名：<input class="easyui-combobox" id="s_dataDicName" valueField="dataDicName" textField="dataDicName" 
			panelHeight="auto" editable="true" url="${pageContext.request.contextPath}/dataDic/findDataDicName.do"/>
			&nbsp;数据字典值：<input type="text" id="s_dataDicValue" size="20" onkeydown="if(event.keyCode==13) searchDataDic()"/>
			<a href="javascript:searchDataDic()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div>               
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width:620px;height:250px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="8px">
				<tr>
					<td>数据字典名：</td>
					<td><input class="easyui-combobox" id="dataDicName" name="dataDicName" valueField="dataDicName" textField="dataDicName" 
			panelHeight="auto" editable="true" url="${pageContext.request.contextPath}/dataDic/findDataDicName.do"/>&nbsp;<font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>数据字典值：</td>
					<td><input type="text" id="dataDicValue" name="dataDicValue" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
				</tr>
			</table>
		</form>
	</div>                                                                                                                    
	
	<div id="dlg-buttons">
		<a href="javascript:saveDataDic()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeDataDicDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>