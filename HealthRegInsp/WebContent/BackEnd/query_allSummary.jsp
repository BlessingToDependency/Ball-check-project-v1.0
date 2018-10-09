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
    <title>公司总结</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="<%=path%>/favicon.ico" type="image/x-icon" />
    <link href="<%=path%>css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=path%>/css/font.css">
    <link rel="stylesheet" href="<%=path%>/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=path%>/js/xadmin.js"></script>
    <%-- <script src="<%=path%>js/bootstrap.min.js"></script> --%>
     <style>
     .zt{color: #06F;font-size: 18px;font-weight: 10px;}
         #div{width:20%; height:40px;margin: 0px 0px 0px 0px;border:blue 0px solid; float:left;text-align:center;}
	</style>
  </head>
  <body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
     <button class="layui-btn layui-btn-warm" onclick="javascript:history.back(-1)">返回</button></a>       
      </span>
    </div>
    <div class="x-body">       
      <xblock>
        <span class="x-right" style="line-height:40px"></span>
      </xblock>
      <table class="layui-table">
				<thead>
     			   <tr>
                   <th>体检总结及建议</th>     
                   </tr>    
        		</thead>
        				<tr>
							<td>[综述:]</td>
						</tr>									
						<tr>
							<td height="33"><textarea name="proposal" cols="150" readonly="readonly"> ${totalBean.proposal}</textarea>								
							</td>
							
						</tr>
						<tr>
							<td>[建议:]</td>
						</tr>
						<tr>
							<td ><textarea name="suggest" cols="150" readonly="readonly">${totalBean.suggest}</textarea></td>
						</tr>
					<thead>
     			  		<tr>
                   		<th>生活保健指导</th>     
                  		</tr>    
        			</thead>							
						<tr>
							<td><textarea name="lifeGuid" cols="150">${totalBean.lifeGuid}</textarea></td>
						</tr>	
						<tr>   <td align="center">
						  <button class="layui-btn" type="submit" lay-filter="sreach"><i class="layui-icon">&#xe615;</i>提交</button>
						   <button class="layui-btn layui-btn-normal" onclick="delAll()"><i class="layui-icon"></i>返回</button>
							<input type="hidden" name="companyId" id="companyId" value="${companyId}"/>
						</td></tr>								
					</table>     	    
    </div>
</body>
 <script type="text/javascript" src="<%=path%>js/jquery.min.js"></script>
 <script>
$(document).ready(function(){
	
        //ajax判断
  		$("#partYear").change(function(){

				$.ajax({
					url:"<%=path%>Report/showBatch.action",//请求地址
					data:"partYear="+$("#partYear").val()+"&"+"companyId="+$("#companyId").val(),//发送至服务器的键值数据
					dataType:"json",//请求数据格式，如script,json,text等
					type:"post",//发送方式，get/post
					success:function(redata) {//定义各事件发生时回调的函数
		
				     	$("#batch").find("option").remove();
					
						$("#batch").append("<option value=0>批次</option>");
						
						$.each(redata, function(i, item) {
							
							$("#batch").append("<option value="+item+">"+ item+ "</option>");
						
						});
					}
				});
  		});
});
</script>
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

      function delAll (argument) {

        var data = tableCheck.getData();
  
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
            window.location.href="<%=path%>adminManagerAction/batchDel.action?data="+data;
        });
      }
</script>
<script type="text/javascript">
//跳转页码
function jump(){
	var p=document.getElementById("pageNo").value;
	window.location.href="<%=path%>openBillAction/staff.action?pageNo="+p+"&companyId=${batchSheetCon.companyId}&batch=${batchSheetCon.batch}&staffName=${batchSheetCon.staffName}";
}


//启用弹窗确认
function daying(){
	document.execCommand("print");
}


//启用弹窗确认
function disable(){
	 var r=confirm("确定启用该用户吗？")
	 if(r==true){
		 return true;
	 }
	 return false;
}


</script> 
</html>