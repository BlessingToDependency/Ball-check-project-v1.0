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
    <div class="x-nav">
      <span class="layui-breadcrumb">
      <a href="<%=path%>openBillAction/massInspList.action"><button class="layui-btn layui-btn-warm">返回</button></a>
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
      
        <form   method="post" action="<%=path %>Report/showUser.action">
        <input type="hidden" name="companyId" id="companyId" value="${companyId}"/>
        <div id="div">
          <input type="text" id="staffName" name="staffName"  placeholder="姓名" autocomplete="off" class="layui-input" value="${staffName==null?"":staffName}">
        </div>
         <div id="div">
          <select id="partYear" name="partYear" style="width:90%;height:40px;" value="${pBean.partYear==null?"":pBean.partYear}">
          <option value="">年份</option>
           <c:forEach items="${orderyear}"  var="year" step="1" varStatus="vs">
           <option value="${year}" ${pBean.partYear==year ? 'selected = "selected"':''}>${year}</option>
           </c:forEach>
          </select>
          </div>
          
          <div id="div">
          <select id="batchNum" name="batchNum" style="width:90%;height:40px;" value="${pBean.batchNum==null?"":pBean.batchNum}">
          <option value="">批次</option>
           <option value="${pBean.batchNum}" ${pBean.batchNum==null ? '':'selected = "selected"'}>${pBean.batchNum}</option>
          </select>
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
            <th>操作</th>
        </thead>
        <tbody>
          <c:forEach items="${slist}"  var="list" step="1" varStatus="vs">
			<tr>
			   <td>${vs.index+1}</td>
			   <td>${list.staffName}</td>
			   <td>${list.age}</td>
			   <td>${list.sex}</td>
			   <td>${list.idNum}</td>
			    <td>${list.phone}</td>
	       	   <td class="td-status">                 
	           	<a href="<%=path%>Report/showSmall.action?staffId=${list.staffId}&myGuChId=${list.myGuChId}" ><span class="layui-btn layui-btn-danger" style="width:80px;" onclick="return dele();">总结</span></a>
	          	<!-- ?guChId=${guChId} -->
	           </td>
			</tr>
			</c:forEach>
        </tbody>
      </table>     
        <div class="page">
        <div>
      		当前：第  ${currentPage} 页/ 共 ${totalPage} 页
           <a class="num" href="<%=path %>Report/showUser.action?currentPage=1&companyId=${companyId }&staffName=${staffName }&partYear=${pBean.partYear }&batchNum=${pBean.batchNum }">首页</a> 
           <a class="prev" href="<%=path %>Report/showUser.action?currentPage=${(currentPage-1)>0?currentPage-1:1}&companyId=${companyId }&staffName=${staffName }&partYear=${pBean.partYear }&batchNum=${pBean.batchNum }">上一页</a>
		   <a class="next" 	href="<%=path%>Report/showUser.action?currentPage=${(currentPage+1)<=totalPage?currentPage+1:totalPage}&companyId=${companyId }&staffName=${staffName }&partYear=${pBean.partYear }&batchNum=${pBean.batchNum }">下一页</a>
		   <a class="num" href="<%=path %>Report/showUser.action?currentPage=${totalPage}&companyId=${companyId}&staffName=${staffName }&partYear=${pBean.partYear }&batchNum=${pBean.batchNum }">末页</a>
		   <input type="text" id="currentPage" name="code" style="width: 50px; height: 40px;" autocomplete="off" /> 
					<a class="num" id="linkToCart" href="">跳转</a>
		   <input type="hidden" id="totalPage" value="${totalPage}" >
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
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });

    //点击链接的时候调用
    $("#linkToCart").click(function(){
        //得到input的值
        alert("进入函数");
        var currentPage = $("#currentPage").val();
        var  totalPage  = $("#totalPage").val();
        if(currentPage>totalPage){
      	alert(111111111);
      	  return;
        }else{
      	//设置linkToCart的href的值
            $("#linkToCart").attr("href","<%=path%>Report/showCompany.action?currentPage="+currentPage);
        }
        
    });
  });
</script>
<script type="text/javascript">
//跳转页码
function jump(){
	var p=document.getElementById("pageNo").value;
	window.location.href="<%=path%>openBillAction/staff.action?pageNo="+p+"&companyId=${batchSheetCon.companyId}&batch=${batchSheetCon.batch}&staffName=${batchSheetCon.staffName}";
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