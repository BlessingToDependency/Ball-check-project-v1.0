<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>欢迎页面-X-admin2.0</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="<%=path%>/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="<%=path%>/css/font.css">
<link rel="stylesheet" href="<%=path%>/css/xadmin.css">
<link rel="stylesheet" href="<%=path%>lib/layui/css/layui.css" media="all">
<script type="text/javascript" src="<%=path%>js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=path%>/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=path%>/js/xadmin.js"></script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=path%>css/calendar.css" type="text/css" />
<script type="text/javascript" src="<%=path%>js/calendar.js"></script>


<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">演示</a> <a> <cite>导航元素</cite></a>
		</span> <a class="layui-btn layui-btn-small" style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i class="layui-icon"
			style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so" >			  
				<input type="text" name="name" value="<%=request.getAttribute("name")==null?"":request.getAttribute("name")%>" placeholder="请输入操作人" autocomplete="off"
					class="layui-input">
				<button class="layui-btn" lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock>
		<button class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon"></i>批量删除
		 
		</button>
	    <button class="layui-btn layui-btn-danger" onclick="exportLog()">
			<i ></i>导出日志
		 
		 </button>
		
		<span class="x-right" style="line-height: 40px">页数：${currentPage}/${totalPage }</span> </xblock>
		<form id="fileForm" name="fileform" method="post" action="fileShow.action">
			<table class="layui-table">
				<thead>
					<tr>
						<th>
							<div class="layui-unselect header layui-form-checkbox" lay-skin="primary">
								<i class="layui-icon">&#xe605;</i>
							</div>
						</th>
						
						<th>操作时间</th>
						<th>操作人</th>
						<th>操作模块</th>
						<th>执行描述</th>
						<th>执行的方法</th>
						<th>IP地址</th>
						<th>响应时间</th>
						<th>操作</th>
				</thead>
				<tbody>
					<c:forEach items="${logList}" var="list" varStatus="vs">
						<tr>
							<td>
								<div class="layui-unselect layui-form-checkbox" name="ch" lay-skin="primary" data-id='${list.logId}'><i class="layui-icon">&#xe605;</i></div>
							</td>

						
							<td>${list.time }</td>
							<td>${list.name }</td>
							<td>${list.module }</td>
							<td>${list.commite }</td>
							<td>${list.method }</td>	
							<td>${list.ip }</td>
							<td>${list.responseTime }</td>					
							<td class="td-status" align="center">
								<span
								class="layui-btn layui-btn-warm  layui-btn-mini"><a onclick="return confirm('确认删除?')"
									href="<%=path%>logAction/deleteLog.action?logId=${list.logId}">刪除</a></span> 							
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
		<div class="page">
			<div>
				当前：第${page} 页/ 共 ${paNum} 页
				   <a class="num" href="<%=path%>logAction/selectAllLog.action?page=1&name=${name}">首页</a>
                   <a class="prev" href="<%=path%>logAction/selectAllLog.action?page=${page-1<1?1:page-1}&name=${name}">上一页</a>
                   <a class="next" href="<%=path%>logAction/selectAllLog.action?page=${(page+1)<=paNum?page+1:paNum}&name=${name}">下一页</a>
                   <a class="num" href="<%=path%>logAction/selectAllLog.action?page=${paNum}&name=${name}">末页</a>
				 <input type="text" id="pageNo" name="code" style="width:50px;height:40px;" autocomplete="off" onkeyup="this.value=this.value.replace(/\D/gi,'')"/>
                <a class="num" id="linkToCart" onclick="jump();">跳转</a>
			</div>
		</div>

	</div>
</body>
<script type="text/javascript">
//跳转页码
function jump(){
	var p=document.getElementById("pageNo").value;
	if(p<=${paNum}){window.location.href="<%=path%>logAction/selectAllLog.action?name=${name}&page="+p;}
	else{alert("页数不存在");}
	
}
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
        window.location.href="<%=path%>logAction/batchDel.action?data="+data;
    });
  }
  
  function exportLog(){
		
		window.location.href="<%=path%>logfileAction/exportLogExcel.action";
	} 
</script>
</html>