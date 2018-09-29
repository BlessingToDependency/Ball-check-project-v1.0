<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
String path = request.getScheme() +"://"+request.getServerName()
	+":"+request.getServerPort()+ request.getContextPath()+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    <meta charset="UTF-8">
    <title>医生主页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="<%=path%>/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="<%=path%>/css/font.css">
    <link rel="stylesheet" href="<%=path%>/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=path%>/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
     <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
    $(document).ready(function(){
    	$("#clickButton").click(function(){
    		var guChIdnum = document.getElementById("guChIdnum").value;
		$.ajax({
			url:"<%=path %>doctorAction/selectSetmeal.action",
			data:"guChId="+guChIdnum,
			dataType:"json",
			type:"post",
			success:function(a) {
				
			$("#guChId").val(guChIdnum);
			
			 var strHtml="";
			$.each(a, function(i, item) {
				str="~";
				if(item.none==null){
					item.none="";
					str="";
				}
				if(item.measur==null){
					item.measur="";
					str="";
				}
				if(item.downLimit==null){
					item.downLimit="";
					str="";
				}
				if(item.upLimit==null){
					item.upLimit="";
					str="";
				}
				strHtml+="<tr>"+
				"<th>"+item.termId+"</th>"+
				"<th>"+item.term+"</th>"+
				"<th>"+"<input type="+"text value="+"'"+item.none+"'"+"name=termVal"+">"+"</th>"+
				"<th>"+item.measur+"</th>"+
				"<th>"+item.downLimit+str+item.upLimit+
				"<input type="+"hidden value="+"'"+item.termId+"'"+"name=termId"+">"+
				"</th>"+
				"</tr>";
			});
			$("#tbody-result").html(strHtml);
			/* document.getElementById("guChId").value.guChIdnum; */
			}
		});
	});
}); 
    
</script>
<script type="text/javascript">
function checkSub(){
	document.getElementById("formid").submit();
}
</script>

  </head>
  
  <body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
   
      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" id="" action=""> 
          <input type="text" id="guChIdnum" name="guChIdnum"  placeholder="请输入导检单号" class="layui-input">
       <input type="button" id="clickButton" value="查询"/>
        <input type="button" onclick = "checkSub();" value="提交"/>
         </form> 
      </div>
      <form id="formid" action="<%=path %>doctorAction/addFinresult.action">
      <input type="hidden" name="guChId" id="guChId"/> 
       <table class="layui-table" id="table_id">
        <thead>
          <tr>
            <th>ID</th>
            <th>细项</th>
            <th>默认值</th>
            <th>单位</th>
            <th>参考范围</th>
           </tr>
        </thead>
        <tbody id="tbody-result">
        </tbody>
      </table>
      </form>

    </div>
   
<script>
      layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });
 </script>
</body>

</html>