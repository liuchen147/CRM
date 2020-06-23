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
	
	function searchCustomer(){
		$("#dg").datagrid("load",{
			"khno":$("#s_khno").val(),	
			"name":$("#s_name").val()	
		})
	}
	
	//打开用户对话框(添加)
	function openCustomerAddDialog(){
		//resetValue();
		$("#dlg").dialog("open").dialog("setTitle","添加客户信息");
		url="${pageContext.request.contextPath}/customer/save.do";
	}
	
	//打开用户对话框(修改)
	function openCustomerModifyDialog(){
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
		url="${pageContext.request.contextPath}/customer/save.do?id="+row.id;
	}
	
	//保存
	function saveCustomer(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				//判断下拉框是否选中
				if($("#area").combobox("getValue") == ""){
					$.messager.alert("系统提示","请选择客户地区");
					return false;
				}
				if($("#cusManager").combobox("getValue") == ""){
					$.messager.alert("系统提示","请选择客户经理");
					return false;
				}
				if($("#level").combobox("getValue") == ""){
					$.messager.alert("系统提示","请选择客户等级");
					return false;
				}
				if($("#myd").combobox("getValue") == ""){
					$.messager.alert("系统提示","请选择客户满意度");
					return false;
				}
				if($("#xyd").combobox("getValue") == ""){
					$.messager.alert("系统提示","请选择客户信用度");
					return false;
				}
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
	
	function openCustomerLinkMan(){
		//获取用户选中的行(可以选中多行,但只能查看一行)
		var selectRows = $("#dg").datagrid("getSelections");
		if(selectRows.length != 1){
			$.messager.alert("系统提示","请选择一条要管理的数据");
			return;
		}
		var row = selectRows[0];
		window.parent.openTab('联系人管理','linkManManage.jsp?cusId='+row.id,'icon-lxr');
	}
	
	function openCustomerContact(){
		//获取用户选中的行(可以选中多行,但只能查看一行)
		var selectRows = $("#dg").datagrid("getSelections");
		if(selectRows.length != 1){
			$.messager.alert("系统提示","请选择一条要管理的数据");
			return;
		}
		var row = selectRows[0];
		window.parent.openTab('交往记录管理','contactManage.jsp?cusId='+row.id,'icon-jwjl');
	}
	
	function openCustomerOrder(){
		//获取用户选中的行(可以选中多行,但只能查看一行)
		var selectRows = $("#dg").datagrid("getSelections");
		if(selectRows.length != 1){
			$.messager.alert("系统提示","请选择一条要查看的数据");
			return;
		}
		var row = selectRows[0];
		window.parent.openTab('历史订单查看','orderManage.jsp?cusId='+row.id,'icon-lsdd');
	}
	
	//删除
	function deleteCustomer(){
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
				$.post("${pageContext.request.contextPath}/customer/delete.do",{ids:ids},function (result){
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
	function closeCustomerDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	//重置
	function resetValue(){
		//$("#dataDicName").combobox("setValue","");
		$("name").val("");
		$("#area").combobox("setValue","");
		$("#cusManager").combobox("setValue","");
		$("#level").combobox("setValue","");
		$("#myd").combobox("setValue","");
		$("#xyd").combobox("setValue","");
		$("#postCode").val("");
		$("#phone").val("");
		$("#fax").val("");
		$("#webSite").val("");
		$("#yyzzzch").val("");
		$("#fr").val("");
		$("#zczj").val("");
		$("#nyye").val("");
		$("#khyh").val("");
		$("#khzh").val("");
		$("#dsdjh").val("");
		$("#gsdjh").val("");
	}
	
</script>

</head>
<body>
	<table id="dg" title="客户信息管理" class="easyui-datagrid" pagination="true" rownumbers="true"
	url="${pageContext.request.contextPath}/customer/list.do" fit="true" toolbar="#tb">
		<thead data-options="frozen:true">
				<tr>
					<th field="cb" checkbox="true" align="center"></th>
			 		<th field="id" width="50" align="center" hidden="true">编号</th>
			 		<th field="khno" width="150" align="center">客户编号</th>
			 		<th field="name" width="200" align="center">客户名称</th>
			 		<th field="cusManager" width="100" align="center">客户经理</th>
			 		<th field="level" width="100" align="center">客户等级</th>
			 		<th field="phone" width="100" align="center">联系电话</th>
				</tr>
			</thead>
			<thead>
				<tr>
					<th field="area" width="80" align="center">客户地区</th>	
			 		<th field="myd" width="80" align="center">客户满意度</th>
			 		<th field="xyd" width="80" align="center">客户信用度</th>
			 		<th field="address" width="200" align="center" >客户地址</th>
			 		<th field="postCode" width="100" align="center" >邮政编码</th>
			 		<th field="fax" width="100" align="center" >传真</th>
			 		<th field="webSite" width="100" align="center" >网址</th>
			 		<th field="yyzzzch" width="100" align="center" >营业执照注册号</th>
			 		<th field="fr" width="100" align="center" >法人</th>
			 		<th field="zczj" width="100" align="center" >注册资金(万元)</th>
			 		<th field="nyye" width="100" align="center" >年营业额(万元)</th>
			 		<th field="khyh" width="100" align="center" >开户银行</th>
			 		<th field="khzh" width="100" align="center" >开户帐号</th>
			 		<th field="dsdjh" width="100" align="center" >地税登记号</th>
			 		<th field="gsdjh" width="100" align="center" >国税登记号</th>
				</tr>
			</thead>
	</table>
	<div id="tb">
		<div>
			<a href="javascript:openCustomerAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openCustomerModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteCustomer()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
			<a href="javascript:openCustomerLinkMan()" class="easyui-linkbutton" iconCls="icon-lxr" plain="true">联系人管理</a>
			<a href="javascript:openCustomerContact()" class="easyui-linkbutton" iconCls="icon-jwjl" plain="true">交往记录管理</a>
			<a href="javascript:openCustomerOrder()" class="easyui-linkbutton" iconCls="icon-lsdd" plain="true">客户历史订单查看</a>
		</div>
		<div>
			&nbsp;客户编号：<input type="text" id="s_khno" size="20" onkeydown="if(event.keyCode==13) searchCustomer()"/>
			&nbsp;客户名称：<input type="text" id="s_name" size="20" onkeydown="if(event.keyCode==13) searchCustomer()"/>
			<a href="javascript:searchCustomer()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div>               
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width:700px;height:500px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="8px">
				<tr>
					<td>客户名称：</td>
					<td><input type="text" id="name" name="name" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>地区：</td>
					<td>
						<select class="easyui-combobox" id="area" name="area" style="width:145px" editable="false" panelHeight="auto">
							<option value="">请选择地区...</option>
							<option value="湖南">湖南</option>
							<option value="上海">上海</option>
							<option value="厦门">厦门</option>
							<option value="西藏">西藏</option>
						</select>
						&nbsp;<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>客户经理：</td>
					<td><input class="easyui-combobox" id="cusManager" name="cusManager" panelHeight="auto" editable="false" valueField="trueName" textField="trueName" url="${pageContext.request.contextPath}/user/customerManagerComboList.do"/></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>客户等级：</td>
					<td><input class="easyui-combobox" id="level" name="level" panelHeight="auto" editable="false" valueField="dataDicValue" textField="dataDicValue" url="${pageContext.request.contextPath}/dataDic/dataDicComboList.do"/></td>
				</tr>
				<tr>
					<td>客户满意度：</td>
					<td>
						<select class="easyui-combobox" id="myd" name="myd" style="width:145px" editable="false" panelHeight="auto">
							<option value="">请选择...</option>
							<option value="☆">☆</option>
							<option value="☆☆">☆☆</option>
							<option value="☆☆☆">☆☆☆</option>
							<option value="☆☆☆☆">☆☆☆☆</option>
							<option value="☆☆☆☆☆">☆☆☆☆☆</option>
						</select>
						&nbsp;<font color="red">*</font>
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>客户信用度：</td>
					<td>
						<select class="easyui-combobox" id="xyd" name="xyd" style="width:145px" editable="false" panelHeight="auto">
							<option value="">请选择...</option>
							<option value="☆">☆</option>
							<option value="☆☆">☆☆</option>
							<option value="☆☆☆">☆☆☆</option>
							<option value="☆☆☆☆">☆☆☆☆</option>
							<option value="☆☆☆☆☆">☆☆☆☆☆</option>
						</select>
						&nbsp;<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>邮政编码：</td>
					<td><input type="text" id="postCode" name="postCode" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>联系电话：</td>
					<td><input type="text" id="phone" name="phone" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
				</tr>
				<tr>
					<td>传真：</td>
					<td><input type="text" id="fax" name="fax" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>网址：</td>
					<td><input type="text" id="webSite" name="webSite" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
				</tr>
				<tr>
					<td>客户地址：</td>
					<td colspan="4"><input type="text" id="address" name="address" class="easyui-validatebox" style="width:433px"/>&nbsp;<font color="red">*</font></td>
					</tr>
				<tr>
					<td>营业执照注册号：</td>
					<td><input type="text" id="yyzzzch" name="yyzzzch" class="easyui-validatebox"/></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>法人：</td>
					<td><input type="text" id="fr" name="fr" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
				</tr>
				<tr>
					<td>注册资金(万元)：</td>
					<td><input type="text" id="zczj" name="zczj" class="easyui-validatebox"/></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>年营业额(万元)：</td>
					<td><input type="text" id="nyye" name="nyye" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
				</tr>
				<tr>
					<td>开户银行：</td>
					<td><input type="text" id="khyh" name="khyh" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>开户账号：</td>
					<td><input type="text" id="khzh" name="khzh" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
				</tr>
				<tr>
					<td>地税登记号：</td>
					<td><input type="text" id="dsdjh" name="dsdjh" class="easyui-validatebox"/></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>国税登记号：</td>
					<td><input type="text" id="gsdjh" name="gsdjh" class="easyui-validatebox"/></td>
				</tr>
			</table>
		</form>
	</div>                                                                                                                    
	
	<div id="dlg-buttons">
		<a href="javascript:saveCustomer()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeCustomerDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>