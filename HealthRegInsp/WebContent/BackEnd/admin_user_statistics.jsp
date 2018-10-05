<%@ page language="java" contentType="text/html; charset=utf-8"
import="org.great.bean.*,java.util.*,java.text.*" pageEncoding="utf-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
      <%String paths = request.getContextPath(); %>
   <%String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+paths+"/";
 %> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>渠道量统计表</title>
<script type="text/javascript"  src="<%=path%>js/laydate.js"></script>
<script type="text/javascript" src="<%=path%>js/latest.js"></script>
<script type="text/javascript" src="<%=path%>js/jquery.min.js"></script>
<link rel="stylesheet" href="<%=path%>css/jHsDate.css" />
<link rel="stylesheet" href="<%=path%>css/laydate.css" />
<script type="text/javascript" src="<%=path%>js/jHsDate.js"></script>
<script type='text/javascript'>
			$(function(){	
				<%--  var list=eval('<%=request.getAttribute("satisBeanList")%>');  --%>
                   var str = '${contan}';//list
                   var list = $.parseJSON(str); 
                   var conValue=[list.length];
                   var ordValue=[list.length];
                   var labels=[list.length];
                   /* var DoctorName="";
                   var consoltCount="";
                   var orderCount=""; */
                   console.log(list);
              
                	   for(var i=0;i<list.length;i++){
                      	 conValue[i]=list[i].orderCount;//预约
                      	// ordValue[i]=list[i].countConsult;//咨询
                      	 labels[i]=list[i].orderName;//名字
                       }
                	    /* var DoctorName1=DoctorName.slice(0,-1)
                	    var consoltCount1=consoltCount.slice(0,-1)
                	    var orderCount1=orderCount.slice(0,-1)*/
                	  
				var data = [
				         	{
				         		name : '销售量',
				         		value:conValue,
				         		color:'#1385a5'
				         	}
				         ];
                 
				var chart = new iChart.ColumnMulti2D({
						render : 'canvasDiv',
						data: data,
						labels:labels,
						title : '渠道量统计',
						subtitle : '指定时间段内套餐销量统计',
						footnote : '数据来源：jx180309',
						width : 1200,
						height : 400,
						background_color : '#ffffff',
						legend:{
							enable:true,
							background_color : null,
							border : {
								enable : false
							}
						},
						coordinate:{
							background_color : '#f1f1f1',
							scale:[{
								 position:'left',	
								 start_scale:0,
								 end_scale:50,
								 scale_space:10
							}],
							width:1200,
							height:260
						}
				});
				
                  
                   
				chart.draw();
			});
			</script>
</head>
<body >
 <h1 align="center">渠道量统计</h2>
<form id="form1" name="form1" method="post" action="<%=path%>Statistic/showChannel.action">
<table align="center" >
				<tr>
					<td colspan="7">查询条件：</td>
				<tr>
				<tr>
					<td>咨询师：</td>
					<td colspan="2"><input type="text" name="orderName" value="${channel.orderName}"
						style="width: 150px" /></td>
						<td >日期： <input type="text" class="demo-input" name="before" placeholder="请选择日期" id="beforeDate" value="${channel.before}">
						至 <input type="text" class="demo-input" name="after" placeholder="请选择日期" id="test2" value="${channel.after}">
						<input type="submit" value="查询" id="login"style="width: 100; height: 30" />
					</td>
					
				
				</table>
				</form>
<div id='canvasDiv'></div>
</body>

<script>
lay('#version').html('-v'+ laydate.v);


laydate.render({
  elem: '#beforeDate' 
});
</script>
<script>
lay('#version').html('-v'+ laydate.v);
 laydate.render({
	elem : '#test2'
	});
</script>
</html>