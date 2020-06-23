<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/highcharts4/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/highcharts4/js/highcharts.js" type="text/javascript"></script> 

<script type="text/javascript">
	
	$(function(){
		//创建图表对象
		var chart = new Highcharts.Chart({
			//图表类型：柱状图
			chart: {
				//渲染到哪个位置
				renderTo:'container',
		        type: 'column',
		        //图表加载事件
		        events:{
		        	load:function(event){
		        		//通过ajax请求后台的数据
		        		$.post("${pageContext.request.contextPath}/customer/findCustomerGc.do",{},function(result){
		        			//声明X轴数组
		        			var xArr = new Array();
		        			//声明Y轴数组
		        			var yArr = new Array();
		        			for(var i=0;i<result.length;i++){
		        				//开始给两个数组赋值
		        				xArr.push(result[i].customerLevel);
		        				yArr.push(result[i].customerNum);
		        				//给X轴赋值(标题)
		        				chart.xAxis[0].categories = xArr;
		        				//给Y轴赋值
		        				chart.series[0].setData(yArr);
		        			}
		        		},"json");
		        	}
		        }
		    },
		    //图表标题
		    title: {
		        text: '客户构成分析'
		    },
		    //图表子标题
		    subtitle: {
		        text: '数据来源: 查询t_customer表中level字段'
		    },
		    //X轴
		    xAxis: {
		        categories: [
		            'A','B','C'
		        ],
		    },
		    //Y轴
		    yAxis: {
		        min: 0,
		        title: {
		            text: '客户数量'
		        }
		    },
		    //X轴的数据
		    series: [{
		        name: '客户',
		        data: [1,2,3]
		    }]
		});
	});
	
</script>

</head>
<body>
	<div id="container" style="min-width:800px;height:400px"></div>
</body>
</html>