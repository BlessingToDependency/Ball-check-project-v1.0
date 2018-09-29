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
    <title>角色管理</title>
     <link rel="stylesheet" href="<%=path%>css/bootstrap.min.css">
	<script src="<%=path%>js/jquery.min.js"></script>
	<script src="<%=path%>js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=path%>js/jquery.min.js"></script>
  <style>
     .zt{color: #06F;font-size: 18px;font-weight: 10px;}
         #div{width:100%; height:50px;margin: 0px 0px 0px 0px;border:blue 0px solid; float:left;text-align:center;}
         #divleft{width:35%; height:48px;margin: 0px 0px 0px 0px;border:blue 0px solid; float:left;text-align:right;}
         #divright{width:63%; height:48px;margin: 0px 0px 0px 0px;border:blue 0px solid; float:left;text-align:center;}
	</style>	
<script type="text/javascript">
function delectRole(id){
	var r=confirm("确定?")
	 if(r==true){ 
		 window.location.href="<%=path%>maRoleAction/deleteRole.action?roleId="+id;
	 }
}
</script>
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
        <form class="layui-form layui-col-md12 x-so">

          <input type="text" name="role"  placeholder="请输入角色名" autocomplete="off" class="layui-input" value="<%=request.getAttribute("role")==null?"":request.getAttribute("role")%>"/>
          <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <button class="layui-btn" data-toggle="modal" data-target="#myModal2"><i class="layui-icon"></i>添加</button>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>角色</th>
            <th>操作</th>
        </thead>
        <tbody>
        
        
        
        
          <c:forEach items="${roleList}"  var="rolist"  >
			<tr>
			   <td>${rolist.role}</td>
			  
	       	   <td class="td-status">
	       	   <span class="layui-btn layui-btn-normal layui-btn-mini"  onclick="addHid(${rolist.roleId});">修改</span>
                 <span class="layui-btn layui-btn-danger" onclick="delectRole(${rolist.roleId})" >删除</span>
	           </td>
			</tr>
		
			
		
			</c:forEach>
        </tbody>
      </table>
      <div class="page">
        <div>
                     总页数/当前页数 ${paNum}/${page}
          <a class="num" href="<%=path%>maRoleAction/selectAllRole.action?page=1">首页</a>
          <a class="prev" href="<%=path%>maRoleAction/selectAllRole.action?page=${page-1<1?1:page-1}">上一页</a>
          <a class="next" href="<%=path%>maRoleAction/selectAllRole.action?page=${(page+1)<=paNum?page+1:paNum}">下一页</a>
          <a class="num" href="<%=path%>maRoleAction/selectAllRole.action?page=${paNum}">末页</a>
          <input type="text" id="pageNo" name="code" style="width:50px;height:40px;" autocomplete="off" />
           <a class="num" id="linkToCart" onclick="jump();">跳转</a>
        </div>
      </div>

    </div>

  <form id="addfrom" method="post" action="<%=path%>maRoleAction/innerRole.action">

<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增角色</h4>
      </div>
     <!--  <div class="modal-body"> -->
        <div id="div">
             <div id="divleft"><span class="zt">新的角色:</span></div> 
             <div id="divright">
             <input type="text" id="role2" name="role" style="width:200px;" class="form-control" placeholder="角色名" onblur="checkDate()"><samp id="us"></samp>
             </div>          
        </div>  
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="submit" class="btn btn-primary">提交</button>
      </div>
    </div>
  </div>
</div>
</form>	

 <form id="addfrom" method="post" action="<%=path%>maRoleAction/updateRoleNmae.action">
<button type="button" id="dada" style="display:none" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"></button>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改角色</h4>
      </div>
     <!--  <div class="modal-body"> -->
        <div id="div">
             <div id="divleft"><span class="zt">新的角色名:</span></div> 
             <div id="divright">
             <input type="text" id="role3" name="role" style="width:200px;" class="form-control" placeholder="角色名" onblur="checkDate1()"><samp id="us1"></samp>
             </div>          
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
function checkDate(){

	  $.ajax({
		  type:"post",
 	   url:"<%=path%>maRoleAction/checkRole.action",
 	   data:{"role":$("#role2").val()},
 	   dataType:"json",
			success : function(redata) {//定义各事件发生时回调的函数
			  console.log(redata);
			
		    	$("#us").html(redata);
			}
		  
		  
	  });

} 

function checkDate1(){
    
	  $.ajax({
		  type:"post",
	   url:"<%=path%>maRoleAction/checkRole.action",
	   data:{"role":$("#role3").val()},
	   dataType:"json",
			success : function(redata) {//定义各事件发生时回调的函数
			  console.log(redata);
			
			  $("#us1").html(redata);
			}
		  
		  
	  });

}

function addHid(v){
	
	$.ajax({
		url:"<%=path%>maRoleAction/tomaRole.action",//请求地址
		data:"roleId="+v,//发送至服务器的键值数据
		dataType:"json",//请求数据格式，如script,json,text等
		type:"post",//发送方式，get/post
	    success:function(data){
	    	//展开模态框
	    	$("#dada").trigger("click");
	  }
	});
} 

//跳转页码
function jump(){
	var p=document.getElementById("pageNo").value;
	window.location.href="<%=path%>maRoleAction/selectAllRole.action?page="+p;
}
</script>
</html>