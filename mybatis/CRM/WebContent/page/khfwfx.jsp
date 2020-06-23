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
		var chart=new Highcharts.Chart({
			chart: {
				renderTo:'container',
	            plotBackgroundColor: null,
	            plotBorderWidth: null,
	            plotShadow: false,
	            events:{
	            	load:function(event){
	            		var series=this.series[0];
	            		// ajax请求后台加载数据
	            		$.post("${pageContext.request.contextPath}/customer/findCustomerFw.do",{},function(result){
	            			var xArr=new Array();
	            			for(var i=0;i<result.length;i++){
	            				//xArr[0][0] = result[i].serveType;	
		        				//xArr[0][1] = result[i].num;	
		        				
		        				//xArr[1][0] = result[i].serveType;	
		        				//xArr[1][1] = result[i].num;	
		        				
		        				//xArr[2][0] = result[i].serveType;	
		        				//xArr[2][1] = result[i].num;
	            				
	            				xArr[i]=new Array();
	            				xArr[i][0]=result[i].serveType;
	            				xArr[i][1]=result[i].num;
	            			}
	            			series.setData(xArr);
	            		},"json");
	            	}
	            }
	        },
	        title: {
	            text: '客服服务分析'
	        },
	        tooltip: {
	        	formatter:function(){
	        		return '<b>'+this.point.name+'</b>:'+Highcharts.numberFormat(this.percentage,1)+'% ('+this.y+'个)'	
	        	}
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                dataLabels: {
	                    enabled: true,
	                    //字体颜色
	                    color: '#000000',
	                    //连接线的颜色
	                    connectorColor: '#000000',
	                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	                }
	            }
	        },
	        series: [{
	            type: 'pie',
	            name: '比例',
	            data: [
	               
	            ]
	        }]
		});
	});
	
</script>

</head>
<body>
	<div id="container" style="min-width:800px;height:400px"></div>
</body>
</html>