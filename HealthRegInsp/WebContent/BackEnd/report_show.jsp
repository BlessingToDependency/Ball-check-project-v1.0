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
    <title>公司体检人员总结</title>
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
  
    <div class="x-body">
      
        <form   method="post" action="<%=path%>ComQuery/queryAll.action">
        <div id="div">
          <input type="text" id="staffName" name="staffName"  placeholder="姓名" autocomplete="off" class="layui-input" value="${staffBean.staffName}">
        </div>
          <div id="div"> 
             <input class="layui-input" placeholder="开始日" name="statTime" id="start" placeholder="起始时间" autocomplete="off" value="${staffBean.statTime}">
          </div>
           <div id="div">        
             <input class="layui-input" placeholder="截止日" name="stopTime" id="end" placeholder="结束时间" autocomplete="off" value="${staffBean.stopTime}">
          </div>
          
           <div id="div">
             <input type="text" id="myGuChId" name="myGuChId"  placeholder="条形号" autocomplete="off" class="layui-input" value="${staffBean.myGuChId}">
          </div>   
             <button class="layui-btn" type="submit" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>

        
        </form>
    
      <xblock>
<!--         <button class="layui-btn layui-btn-normal" onclick="delAll()"><i class="layui-icon"></i>批量删除</button> -->
        <span class="x-right" style="line-height:40px">共有数据:${allRecord}条</span>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>名字</th>
            <th>年龄</th>
            <th>性别</th>
            <th>身份证号</th>
            <th>联系方式</th>
            <th>条码号</th>
            <th>小结</th>
            <th>总结</th>
            <th>报告预览</th>
        </thead>
        <tbody>
          <c:forEach items="${userList}"  var="list" step="1" varStatus="vs">
			<tr>
			   <td>${vs.index+1}</td>
			   <td>${list.staffName}</td>
			   <td>${list.age}</td>
			   <td>${list.sex}</td>
			   <td>${list.idNum}</td>
			   <td>${list.phone}</td>
			   <td>${list.myGuChId} </td>
	       	     <c:if test="${list.smallState==13}">
	       	      <td class="td-status">	             
				   未完成	
				</td>        
				</c:if>
				 <c:if test="${list.smallState==14 || list.smallState==15}">  
				 <td class="td-status">
	           	<a href="<%=path%>ComQuery/showLittle.action?staffId=${list.staffId}&myGuChId=${list.myGuChId}" ><span class="layui-btn layui-btn-primary" style="width:80px;" onclick="return dele();">小结</span></a>	                 			
				</td>	        
				</c:if>
	           
	            <c:if test="${list.smallState==15}">  
	            <td class="td-status">   
	           	<a href="<%=path%>ComQuery/showSummary.action?guChId=${list.myGuChId}" ><span class="layui-btn" style="width:80px;" onclick="return dele();">总结</span></a>
	        	 </td>
	        	</c:if>
	        	<c:if test="${list.smallState!=15}">         
	            <td class="td-status">  
	        	未完成
	        	</td>
	        	</c:if>
	          
	            <c:if test="${list.smallState==15}">                      
	            <td class="td-status">     
	           	<a href="<%=path%>ComQuery/showFinalSummary.action?staffId=${list.staffId}&myGuChId=${list.myGuChId}&staffName=${list.staffName}" ><span class="layui-btn layui-btn-warm" style="width:80px;" onclick="return dele();">报告预览</span></a>
	             </td>
	            </c:if>
	            <c:if test="${list.smallState!=15}">           
	             <td class="td-status">           
	         	  未完成
	         	 </td>
	           </c:if>
	         
			</tr>
			</c:forEach>
        </tbody>
      </table>     
        <div class="page">
        <div>
      		当前：第  ${staffBean.currentpage} 页/ 共 ${staffBean.totalPage} 页
           <a class="num" href="<%=path%>ComQuery/queryAll.action?currentpage=1&staffName=${staffBean.staffName }&statTime=${staffBean.statTime}&stopTime=${staffBean.stopTime}&myGuChId=${staffBean.myGuChId}">首页</a>
           <a class="prev" href="<%=path%>ComQuery/queryAll.action?currentpage=${(staffBean.currentpage-1)>0?(staffBean.currentpage-1):1}&staffName=${staffBean.staffName }&statTime=${staffBean.statTime}&stopTime=${staffBean.stopTime}&myGuChId=${staffBean.myGuChId}">上一页</a>
		   <a class="next" href="<%=path%>ComQuery/queryAll.action?currentpage=${(staffBean.currentpage+1)<=staffBean.totalPage?(staffBean.currentpage+1):staffBean.totalPage}&staffName=${staffBean.staffName }&statTime=${staffBean.statTime}&stopTime=${staffBean.stopTime}&myGuChId=${staffBean.myGuChId}">下一页</a>
		   <a class="num" href="<%=path%>ComQuery/queryAll.action?currentpage=${staffBean.totalPage}&staffName=${staffBean.staffName }&statTime=${staffBean.statTime }&stopTime=${staffBean.stopTime}&myGuChId=${staffBean.myGuChId}">末页</a> 
		   <input type="text" id="currentPage" name="currentPage" style="width: 50px; height: 40px;" autocomplete="off" /> <a
					class="num" id="linkToCart" href="">跳转</a>
        </div>
      </div>


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
		
				     	$("#batchNum").find("option").remove();
					
						$("#batchNum").append("<option value=0>批次</option>");
						
						$.each(redata, function(i, item) {
							
							$("#batchNum").append("<option value="+item+">"+ item+ "</option>");
						
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
          ,type: 'datetime'
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
          ,type: 'datetime'
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

$(document).ready(function(){
    //点击链接的时候调用
   $("#linkToCart").click(function(){
       //得到input的值
       var currentPage = $("#currentPage").val();
       //设置linkToCart的href的值
       $("#linkToCart").attr("href","<%=path%>ComQuery/queryAll.action?currentpage="+currentPage);
   });
 });


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