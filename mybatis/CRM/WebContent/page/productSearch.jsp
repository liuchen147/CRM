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
	function searchProduct(){
		$("#dg").datagrid("load",{
			"productName":$("#s_productName").val()
		})
	}
</script>
</head>
<body>
	
	<table id="dg" title="产品信息管理" class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true"
	url="${pageContext.request.contextPath}/product/list.do" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true" align="center"></th>
				<th field="id" width="50px" align="center">编号</th>
				<th field="productName" width="200px" align="center">产品名称</th>
				<th field="model" width="100px" align="center">型号</th>
				<th field="unit" width="50px" align="center">单位</th>
				<th field="price" width="80px" align="center">价格</th>
				<th field="store" width="80px" align="center">库存</th>
				<th field="remark" width="20   0px" align="center">备注</th>
			</tr>
		</thead> 
	</table>
	
	<div id="tb">
		<div>
			用户名：<input type="text" id="s_productName" size="20" onkeydown="if(event.keyCode==13) searchProduct()"/>
			<a href="javascript:searchProduct()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div> 
	</div>
</body>
</html>