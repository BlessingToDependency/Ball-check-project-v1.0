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
    <title>参数配置</title>
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
    <script src="<%=path%>js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="x-nav">
     <input type="hidden" name="coun" id="coun" value=""/>
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
        <form class="layui-form layui-col-md12 x-so">
          <input class="layui-input" placeholder="开始日" name="start" id="start">
          <input class="layui-input" placeholder="截止日" name="end" id="end">
          <input type="text" name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
          <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <button class="layui-btn" onclick="x_admin_show('添加用户','./admin-add.html')"><i class="layui-icon"></i>添加</button>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>序号</th>
            <th>参数名</th>
            <th>父级参数ID</th>
            <th>操作</th>
        </thead>
        
        <tbody>
          <c:forEach items="${paramList}"  var="list" step="1" varStatus="vs">
			<c:if test="${vs.index%2 == 0}">
			<tr>
			   <td>${vs.index+1}</td>
			   <td>${list.param}</td>
			   <td>${list.parId}</td>
	       	   <td class="td-status">
	       	   
                <span id="up" class="layui-btn layui-btn-normal layui-btn-mini" onclick="addHid(${list.paramId});">修改</span>
                 <a href="<%=path%>adminParamAction/delParam.action?pid=${list.paramId}" ><span class="layui-btn layui-btn-danger" onclick="return disable();">删除</span></a>
	           </td>
			</tr>
			</c:if>
			
		   <c:if test="${vs.index%2 == 1}">
			<tr>
			    <td>${vs.index+1}</td>
			   <td>${list.param}</td>
			   <td>${list.parId}</td>
	       	   <td class="td-status">
                 <span id="up" class="layui-btn layui-btn-normal layui-btn-mini" onclick="addHid(${list.paramId});">修改</span>
                 <a href="<%=path%>adminParamAction/delParam.action?pid=${list.paramId}" ><span class="layui-btn layui-btn-danger" onclick="return disable();">删除</span></a>
	           </td>
			</tr>
			</c:if>
			</c:forEach>
        </tbody>
      </table>
      <div class="page">
        <div>
          <a class="prev" href="">&lt;&lt;</a>
          <c:if test="${vs.index%2 == 1}">
          
          </c:if>
          <a class="num" href="">1</a>
          <span class="current">2</span>
          <a class="num" href="">3</a>
          <a class="num" href="">489</a>
          
          <a class="next" href="">&gt;&gt;</a>
        </div>
      </div>

    </div>

<form id="myform" method="post" action="<%=path%>adminParamAction/saveParam.action" >
<button type="button" id="dada" style="display:none" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"></button>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">系统参数修改</h4>
      </div>
      <div class="modal-body">
        <input type="hidden" id="coun" name="coun"/>
                   参数： <input  type="text" id="pname" name="param" class="form-control" placeholder="参数名">
                 父级ID ： <input  type="text" id="parId" name="parId" class="form-control" placeholder="父级ID">
             
             
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="submit" class="btn btn-primary">保存</button>
      </div>
    </div>
  </div>
</div>
</form>	


</body>

<script type="text/javascript">
//添加到隐藏域
function addHid(v){
	$.ajax({
		url:"<%=path%>adminParamAction/updateParam.action",//请求地址
		data:"pid="+v,//发送至服务器的键值数据
		dataType:"json",//请求数据格式，如script,json,text等
		type:"post",//发送方式，get/post
	    success:function(redata){
	    	alert("*****"+redata.paramId);
	    	
	    	//展开模态框
			$("#dada").trigger("click");
			$("#coun").val(redata.paramId);
	    	$("#pname").val(redata.param);
	    	$("#parId").val(redata.parId);

	  }
	});
} 

/* 
function tijiao(){
	var s =document.getElementById('coun');
	alert(s.value);
} */
//禁用弹窗确认
function disable(){
	 var r=confirm("确定删除吗？")
	 if(r==true){
		 return true;
	 }
	 return false;
}
//上一页限制
 function chageNO(v){
 	 var url = v.href;
 	 var a=url.indexOf('=',1);
 	 var a2=a+1;
 	 var b=a2+2;
 	 var num = parseInt(url.substring(a2,b));
 	 if(num<1){
 		 return false;
 	 }
 	 return true;
 }
</script> 
<!--  <script> 
 	$(function(){

 
     //ajax判断
		$("#up").click(function(){
			alert(v.);
	
		});
	});
	</script>  -->
</html>
