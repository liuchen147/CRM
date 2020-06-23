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
	var url;		//全局变量；每个函数都会用；链接地址
	
	//搜索
	function searchUser(){
		$("#dg").datagrid("load",{
			"userName":$("#s_userName").val()
		})
	}
	
	//打开用户对话框(添加)
	function openUserAddDialog(){
		resetValue();		//打开添加界面时清空文本框内容
		$("#dlg").dialog("open").dialog("setTitle","添加用户信息");
		url="${pageContext.request.contextPath}/user/save.do";
	}
	
	//打开用户对话框(修改)
	function openUserModifyDialog(){
		//获取选中的行（可以选中多行，但只能修改一行）
		var selectRows = $("#dg").datagrid("getSelections");
		//判断用户是否选择一行，如若不是则提示
		if(selectRows.length != 1){
			$.messager.alert("系统提示","请选择一条要编辑的数据");
			return;
		}
		var row = selectRows[0];		//当前记录的所有属性值
		$("#dlg").dialog("open").dialog("setTitle","修改用户信息");
		
		$("#fm").form("load",row);
		url="${pageContext.request.contextPath}/user/save.do?id="+row.id;
	}
	
	//保存
	function saveUser(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				//判断下拉框是否选中
				if($("#roleName").combobox("getValue")==""){
					$.messager.alert("系统提示","请选择用户角色");
					return false;
				}
				//所有数据填充完毕，进行最后一次调整
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
	function deleteUser(){
		//获取用户选中的行（可以选中多行）
		var selectRows = $("#dg").datagrid("getSelections");
		//判断用户是否选中记录
		if(selectRows.length == 0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		//储存用户选中的Id
		var strIds = [];
		for(var i=0;i < selectRows.length; i++){
			//把选中的Id存到strIds数组里面
			strIds.push(selectRows[i].id)
		}
		//将数组变成字符串，按指定的符号隔开[11,12]
		var ids = strIds.join(",");
		$.messager.confirm("系统提示","您确定要删除这<font color='red' size='3'>"+selectRows.length+"</font>条记录吗？",function(r){
			if(r){
				$.post("${pageContext.request.contextPath}/user/delete.do",{ids:ids},function(result){
					var result = eval('('+result+')');
					if(result.success){
						$.messager.alert("系统提示","数据删除成功！");
						//删除表格数据
						$("#dg").datagarid("reload");
					}else{
						$.messager.alert("系统提示","数据删除失败！")
					}
				})
			}
		});
	}
	
	//关闭
	function closeUserDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	//重置属性值
	function resetValue(){
		$("#userName").val("");
		$("#password").val("");
		$("#trueName").val("");
		$("#email").val("");
		$("#phone").val("");
		$("#roleName").combobox("setValue","");
	}
	
</script>
</head>
<body>
	
	<table id="dg" title="用户管理" class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true"
	url="${pageContext.request.contextPath}/user/list.do" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true" align="center"></th>
				<th field="id" width="50px" align="center">编号</th>
				<th field="userName" width="50px" align="center">用户名</th>
				<th field="password" width="50px" align="center">密码</th>
				<th field="trueName" width="50px" align="center">真实姓名</th>
				<th field="email" width="50px" align="center">邮箱</th>
				<th field="phone" width="50px" align="center">电话</th>
				<th field="roleName" width="50px" align="center">角色名</th>
			</tr>
		</thead> 
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:openUserAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openUserModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteUser()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div> 
		<div>
			客户姓名：<input type="text" id="s_userName" size="20" onkeydown="if(event.keyCode==13) searchUser()"/>
			<a href="javascript:searchUser()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div> 
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width:620px;height:250px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="8px">
				<tr>
					<td>用户名：</td>
					<td><input type="text" id="userName" name="userName" class="easyui-validatebox" required="true">&nbsp;<font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>密码：</td>
					<td><input type="text" id="password" name="password" class="easyui-validatebox" required="true">&nbsp;<font color="red">*</font></td>
				</tr>
				<tr>
					<td>真实姓名：</td>
					<td><input type="text" id="trueName" name="trueName" class="easyui-validatebox" required="true">&nbsp;<font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>邮箱：</td>
					<td><input type="text" id="email" name="email" class="easyui-validatebox" validType="email" required="true">&nbsp;<font color="red">*</font></td>
				</tr>
				<tr>
					<td>电话：</td>
					<td><input type="text" id="phone" name="phone" class="easyui-validatebox" required="true">&nbsp;<font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>用户角色：</td>
					<td>
						<select class="easyui-combobox" id="roleName" name="roleName" style="width:154px" editable="false" panelHeight="auto">
							<option value="">请选择角色...</option>
							<option value="系统管理员">系统管理员</option>
							<option value="销售主管">销售主管</option>
							<option value="客户经理">客户经理</option>
							<option value="高管">高管</option>
						</select>&nbsp;<font color="red">*</font>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveUser()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeUserDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>