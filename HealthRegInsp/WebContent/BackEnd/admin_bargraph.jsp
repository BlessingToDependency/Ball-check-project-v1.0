<%@ page language="java" contentType="text/html; charset=utf-8"
   import="org.great.bean.*,java.util.*,java.text.*" pageEncoding="utf-8"%>

<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>统计柱状图</title>
<script type="text/javascript" src="<%=path %>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>js/ichart.latest.min.js"></script>
<script type='text/javascript'>

$(document).ready(function(){
	var initData=[{
			name : "",
			value : 0,
			color : "rgba(131,166,213,0.9)"
		}, {
			name : "",
			value : 0,
			color : "rgba(243,125,178,0.9)"
		}, {
			name : "",
			value : 0,
			color : "rgba(237,236,238,0.9)"
		}, {
			name : "",
			value : 0,
			color : "rgba(143,198,64,0.9)"
		}, {
			name : "",
			value : 0,
			color : "rgba(100,139,191,0.9)"
		} ,{
			name : "",
			value : 0,
			color : "rgba(100,139,191,0.9)"
		} ,{
			name : "",
			value : 0,
			color : "rgba(100,139,191,0.9)"
		} ];
		
	SetOption(initData);
	//$("#ichart-render").
	});


	function GetInfo(type){
    //var val = $("#qclass option:selected").text();
    console.log(type); 
    $.ajax({
        type: "post",
        data:  "",
        dataType: "json",
        url: "<%=path%>Statistic/"+type,
        async:false,
        success: function (data) {
        	console.log(data);

        	SetOption(data);
           /*  var str = "";
           
            if ("qclass" == classify){
                $("#qclass").empty();
                $.each(data, function(index,value){   // 解析出data对应的Object数组  
                    str += "<option value='"+value.classId+"'>" + value.className + "</option>";
                });
                $("#qclass").append("<option>----请选择----</option>");
            } 
            if ("qconsultant" == classify){
                $("#qconsultant").empty();
                $.each(data, function(index,value){   // 解析出data对应的Object数组  
                    str += "<option value='"+value.consultantId+"'>" + value.cName + "</option>";
                });
                $("#qconsultant").append("<option>----请选择----</option>");
            } 
            $("#" + classify).append(str); */
        },
        error: function(json){  
            alert("error");  
        }  
    });
}

	function SetOption(data) {
		var chart = iChart.create({
			render : "ichart-render",
			width : 800,
			height : 400,
			background_color : "#2e3b4e",
			gradient : false,
			color_factor : 0.2,
			border : {
				color : "#404c5d",
				width : 1
			},
			align : "center",
			offsetx : 0,
			offsety : -20,
			sub_option : {
				border : {
					color : "#fefefe",
					width : 1
				},
				label : {
					fontweight : 600,
					fontsize : 20,
					color : "#f5f5f5",
					sign : "square",
					sign_size : 12,
					border : {
						color : "#BCBCBC",
						width : 1
					},
					background_color : "#fefefe"
				}
			},
			shadow : true,
			shadow_color : "#fafafa",
			shadow_blur : 10,
			showpercent : false,
			column_width : "70%",
			bar_height : "70%",
			radius : "90%",
			title : {
				text : "注册用户统计",
				color : "#f5f5f5",
				fontsize : 24,
				font : "Verdana",
				textAlign : "left",
				height : 30,
				offsetx : 36,
				offsety : 0
			},
			subtitle:{
                text:"",
                color:"#8d9db5",
                fontsize:15,
                font:"微软雅黑",
                textAlign:"left",
                height:50,
                offsetx:36,
                offsety:6
          },
          footnote:{
                text:"",
                color:"#8d9db5",
                fontsize:1,
                font:"微软雅黑",
                textAlign:"right",
                height:30,
                offsetx:-32,
                offsety:0
          },
          legend:{
                enable:true,
                background_color:"rgba(254,254,254,0.2)",
                color:"#c1cdde",
                fontsize:13,
                border:{
                      color:"#85898f",
                      width:0
                },
                column:5,
                align:"right",
                valign:"top",
                offsetx:-32,
                offsety:-40
          },
          coordinate:{
                width:"92%",
                height:"80%",
                background_color:"rgba(246,246,246,0.05)",
                axis:{
                      color:"#bfbfc3",
                      width:["","",6,""]
                },
                grid_color:"#c0c0c0",
                label:{
                      fontweight:500,
                      color:"#f5f5f5",
                      fontsize:0
                }
          },
          label:{
                fontweight:600,
                color:"#f5f5f5",
                fontsize:18
          },
          type:"column2d",

			data : data
		});
		chart.draw();
	}

</script>
</head>
<body style='background-color:#FFFFFF;'>
 <table id="tbl_list" width="1000" cellspacing="0" cellpadding="0" style="border:1px solid #cccccc;text-align:center;margin: 0 auto;">
 	<tr><td colspan="3"> <h2 align="center">注册用户统计</h2> </td></tr>
 	<tr>
 	<td><button id="userweek"  onclick="GetInfo('showWeek.action')">本周</button></td>
 	<td><button id="usermonth" onclick="GetInfo('showMonth.action')">本月</button></td>
 	<td><button id="userthreemonth" onclick="GetInfo('showSeason.action')">近三月</button></td>
 	</tr>
 	<tr><td>  </td></tr>
 	<tr><td colspan="3"><div id='ichart-render'></div></td></tr>
 </table>

</body>
</html>