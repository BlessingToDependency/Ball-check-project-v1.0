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
    <title>科室管理</title>
   <link rel="stylesheet" href="<%=path%>css/bootstrap.min.css">
	<script src="<%=path%>js/jquery.min.js"></script>
	<script src="<%=path%>js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=path%>/lib/layui/css/layui.css">
	
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="<%=path%>/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="<%=path%>/css/font.css">
    <link rel="stylesheet" href="<%=path%>/css/xadmin.css">
<!--     <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script> -->
    <script type="text/javascript" src="<%=path%>/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=path%>/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
         <style>
     .zt{color: #06F;font-size: 18px;font-weight: 10px;}
         #div{width:100%; height:70px;margin: 0px 0px 0px 0px;border:blue 0px solid; float:left;text-align:center;}
         #divleft{width:35%; height:48px;margin: 0px 0px 0px 0px;border:blue 0px solid; float:left;text-align:right;}
         #divright{width:63%; height:48px;margin: 0px 0px 0px 0px;border:blue 0px solid; float:left;text-align:center;}
	</style>
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

          <input type="text" name="depa" id="depa"  placeholder="请输入科室名" autocomplete="off" class="layui-input" value="<%=request.getAttribute("depa")==null?"":request.getAttribute("depa")%>"/>
          <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <button class="layui-btn"  onclick="adddep();"><i class="layui-icon"></i>添加</button>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>科室</th>
            <th>操作</th>
        </thead>
       <tbody>
          <c:forEach items="${deli}"  var="deli"  >
			<tr>
			   <td>${deli.depa}</td>
			  
	       	   <td class="td-status">
	       	   <span class="layui-btn layui-btn-normal layui-btn-mini"   onclick="addHid(${deli.depaId});">修改</span>
                 <span class="layui-btn layui-btn-danger" onclick="delectDepa(${deli.depaId})" >删除</span>
	           </td>
			</tr>
		
			
		
			</c:forEach>
        </tbody>
      </table>
      <div class="page">
        <div>
                     共 ${paNum}页/当前第 ${page}页
          <a class="num" href="<%=path%>maDeparAction/selectDe.action?page=1&depa=${depa}">首页</a>
          <a class="prev" href="<%=path%>maDeparAction/selectDe.action?page=${page-1<1?1:page-1}&depa=${depa}">上一页</a>
          <a class="next" href="<%=path%>maDeparAction/selectDe.action?page=${(page+1)<=paNum?page+1:paNum}&depa=${depa}">下一页</a>
          <a class="num" href="<%=path%>maDeparAction/selectDe.action?page=${paNum}&depa=${depa}">末页</a> 
           <input type="text" id="pageNo" name="code" style="width:50px;height:40px;" autocomplete="off" />
           <a class="num" id="linkToCart" onclick="jump();">跳转</a>
          
        </div>
      </div>

    </div>

  <form id="addfrom" method="post" action="<%=path%>maDeparAction/innserDepar.action" >
<button type="button" id="dep" style="display:none" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal2"></button>
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增科室</h4>
      </div>
     <!--  <div class="modal-body"> -->
        <div id="div">
             <div id="divleft"><span class="zt">新的科室名:</span></div> 
             <div id="divright">
             <input type="text" id="depa2" name="depa" style="width:200px;" class="layui-input" placeholder="科室名" onblur="checkDate()" required="" lay-verify="required"><samp id="us"></samp>
             </div> 
                 
        </div>  
             <div id="div">
             <div id="divleft"><span class="zt">所属小结:</span></div> 
             <div id="divright">
             <select class="form-control" id="xId" name="intfaceId" style="width:200px;">
                 <option value="0">--请选择--</option>
                 </select>
             </div>          
          </div>   
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="submit" class="layui-btn" lay-filter="*" lay-submit>提交</button>
      </div>
    </div>
  </div>
</div>
</form>	

  <form id="addfrom" method="post" action="<%=path%>maDeparAction/updateDepar.action" class="layui-form">
<button type="button" id="dada" style="display:none" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"></button>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改科室</h4>
      </div>
     <!--  <div class="modal-body"> -->
        <div id="div">
             <div id="divleft"><span class="zt">新的科室名:</span></div> 
             <div id="divright">
             <input type="text" id="nedepa" name="depa" style="width:200px;" class="layui-input" placeholder="科室名" onblur="checkDate1()" required="" lay-verify="required"><samp id="us1"></samp>
             </div>          
        </div>  
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="submit"  class="layui-btn" lay-filter="*" lay-submit>保存</button>
      </div>
    </div>
  </div>
</div>
</form>	



  </body>
<script type="text/javascript">
function delectDepa(depaId){
	var r=confirm("确定?")
	 if(r==true){ 
		 window.location.href="<%=path%>maDeparAction/deleteDepar.action?depaId="+depaId;
	  }
}
</script>
<script type="text/javascript">
function checkDate(){
	
	  $.ajax({
		  type:"post",
 	   url:"<%=path%>maDeparAction/checkDepar.action",
 	   data:{"depa":$("#depa2").val()},
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
	   url:"<%=path%>maDeparAction/checkDepar.action",
	   data:{"depa":$("#nedepa").val()},
	   dataType:"json",
			success : function(redata) {//定义各事件发生时回调的函数
			  console.log(redata);
			
			  $("#us1").html(redata);
			}
		  
		  
	  });

}
<!--修改科室-->
function addHid(v){
	
	$.ajax({
		url:"<%=path%>maDeparAction/toUpdateDepar.action",//请求地址
		data:"depId="+v,//发送至服务器的键值数据
		dataType:"json",//请求数据格式，如script,json,text等
		type:"post",//发送方式，get/post
	    success:function(data){
	    	//展开模态框
	    	$("#dada").trigger("click");
	    	$("#nedepa").val(data.depa);
	    	
	    /*  	$("#xId").find("option").remove();
	    	$.each(data, function(i, item) {
		    	  $("#xId").append("<option value="+item.paramId+">"+ item.param+ "</option>");
			}); */
	    	
	  }
	});
}

function adddep(){
	
	$.ajax({
		url:"<%=path%>maDeparAction/toAddDepar.action",//请求地址
		data:"",//发送至服务器的键值数据
		dataType:"json",//请求数据格式，如script,json,text等
		type:"post",//发送方式，get/post
	    success:function(data){
	    	//展开模态框
	    	$("#dep").trigger("click");
	     	$("#xId").find("option").remove();
	    	$.each(data, function(i, item) {
		    	  $("#xId").append("<option value="+item.paramId+">"+ item.param+ "</option>");
			});
	    	
	  }
	});
}

//跳转页码
function jump(){
	var p=document.getElementById("pageNo").value;
	if(p<=${paNum}){window.location.href="<%=path%>maDeparAction/selectDe.action?depa=${depa}&page="+p;}
	else{alert("页数不存在");}
}
</script>
</html>