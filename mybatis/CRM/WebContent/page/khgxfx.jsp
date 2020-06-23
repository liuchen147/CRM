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
	function search(){
		$("#dg").datagrid("load",{
			"name":$("#s_name").val(),
		})
	}
	
	
</script>
</head>
<body>
	
	<table id="dg" title="客户贡献分析" class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true"
	url="${pageContext.request.contextPath}/customer/findCustomerGx.do" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="name" width="300px"  align="center">客户名称</th>
				<th field="gx" width="100px" align="center">订单总金额（元）</th>
			</tr>
		</thead> 
	</table>
	
	<div id="tb">
			<div>
			客户名称：<input type="text" id="s_name" size="20" onkeydown="if(event.keyCode==13) search()"/>
			<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
			</div>
	</div>
</body>
</html>